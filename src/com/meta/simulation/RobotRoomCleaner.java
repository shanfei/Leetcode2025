package com.meta.simulation;

import common.Robot;
import kotlin.Pair;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * You are controlling a robot that is located somewhere in a room.
 * The room is modeled as an m x n binary grid where 0 represents a wall and 1 represents an empty slot.
 *
 * The robot starts at an unknown location in the room that is guaranteed to be empty,
 * and you do not have access to the grid, but you can move the robot using the given API Robot.
 *
 * You are tasked to use the robot to clean the entire room (i.e., clean every empty cell in the room).
 * The robot with the four given APIs can move forward, turn left, or turn right. Each turn is 90 degrees.
 *
 * When the robot tries to move into a wall cell, its bumper sensor detects the obstacle,
 * and it stays on the current cell.
 *
 * Design an algorithm to clean the entire room using the following APIs:
 *
 * interface Robot {
 *   // returns true if next cell is open and robot moves into the cell.
 *   // returns false if next cell is obstacle and robot stays on the current cell.
 *   boolean move();
 *
 *   // Robot will stay on the same cell after calling turnLeft/turnRight.
 *   // Each turn will be 90 degrees.
 *   void turnLeft();
 *   void turnRight();
 *
 *   // Clean the current cell.
 *   void clean();
 * }
 * Note that the initial direction of the robot will be facing up. You can assume all four edges of the grid are all surrounded by a wall.
 *
 */
public class RobotRoomCleaner {

    int[][] directions = {{-1,0}, {0,1}, {1,0}, {0,-1}};

    Set<Pair<Integer, Integer>> v = new HashSet<>();

    Robot r;

    public void cleanRoom(Robot robot) {
        this.r = robot;
        backtrack(0, 0, 0);
    }

    public void goBack() {
        r.turnRight();
        r.turnRight();
        r.move();
        r.turnRight();
        r.turnRight();
    }

    public void backtrack(int row, int col, int initDirectionOfCurrentPosition) {

        Pair<Integer, Integer> currentPosition = new Pair<>(row, col);

        v.add(currentPosition);
        r.clean();


        for ( int i = 0; i < directions.length; ++i ) {

            int nextInitDirection = ( i + initDirectionOfCurrentPosition ) % 4;

            int nr = row + directions[nextInitDirection][0];
            int nl = col + directions[nextInitDirection][1];

            Pair<Integer, Integer> nextPosistion = new Pair<>(nr, nl);

            if ( !hasBeenVisisted(nextPosistion)  && r.move() ) {
                backtrack(nr, nl, nextInitDirection);
                goBack();
            }

            r.turnRight();
        }
    }

    boolean hasBeenVisisted(Pair<Integer, Integer> p) {
        return v.contains(p);
    }
}
