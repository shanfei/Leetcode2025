package com.amazon;

import java.util.*;

public class TimeTakenToCrossTheDoor {


    /**
     * (arriving time) -> (  (door state) -> ( person index asc ) )
     * prevState = state[arrival[0]];
     */
    public int[] timeTaken(int[] arrival, int[] state) {

        Map<Integer, Map<Integer, TreeSet<Integer>>> c = new HashMap<>();

        Queue<Integer> enterQueue = new LinkedList<>();
        Queue<Integer> exitQueue = new LinkedList<>();

        for (int i = 0; i < arrival.length; ++i) {

            int arrivalTimeOfUser = arrival[i];
            int doorStateOfUser = state[i];

            Map<Integer, TreeSet<Integer>> m = c.getOrDefault(arrivalTimeOfUser, new HashMap<>());
            TreeSet<Integer> users = m.getOrDefault(doorStateOfUser, new TreeSet<>());

            users.add(i);
            m.put(doorStateOfUser, users);
            c.put(arrivalTimeOfUser, m);

            if (doorStateOfUser == 0) {
                enterQueue.offer(i);
            } else {
                exitQueue.offer(i);
            }

        }

        List<Integer> ret = new ArrayList<>();

        int currentStateOfDoor = -1;

        for (int i = 0; i < arrival.length; ++i) {

            int arrivalTimeOfUser = arrival[i];

            Map<Integer, TreeSet<Integer>> m = c.get(arrivalTimeOfUser);

            TreeSet<Integer> users = m.get(currentStateOfDoor);

            if ( users == null ) {
                currentStateOfDoor = state[i];
                users = m.get(currentStateOfDoor);
            }

            if ( users == null || users.isEmpty() ) {
                currentStateOfDoor = currentStateOfDoor == 1 ? 0 : 1;
                users = m.get(currentStateOfDoor);
            }

//            Queue<Integer> queue = null;
//
//            if (currentStateOfDoor == 0 && !enterQueue.isEmpty()) {
//                queue = enterQueue;
//            } else {
//                queue = exitQueue;
//            }
//
//            if (queue == null || queue.isEmpty()) {
//                break;
//            }

            int k = getFirstElementFromSet(users);

            if ( k == -1 ) {
                break;
            }

            ret.add(k);

        }

        int[] r = new int[ret.size()];
        for (int i = 0; i < ret.size(); ++i) {
            r[i] = ret.get(i);
        }

        return r;

    }

    Integer getFirstElementFromSet(Set<Integer> s) {

        if (s == null || s.isEmpty()) {
            return null;
        }

        Iterator<Integer> iter = s.iterator();
        if (iter.hasNext()) {
            int r = iter.next();
            iter.remove();
            return r;
        }

        return null;
    }

    public static void main(String[] args) {

        TimeTakenToCrossTheDoor instance = new TimeTakenToCrossTheDoor();

        int[] arrival =  { 0,1,1,2,4 }, state =  { 0,1,0,0,1 };

        int[] r = instance.timeTaken(arrival, state);

        for ( int s : r ) {
            System.out.print(s + " : ");
        }

        System.out.println();

        arrival = new int[] { 0,0,0 };
        state = new int[] { 1,0,1 };

        r = instance.timeTaken(arrival, state);

        for ( int s : r ) {
            System.out.print(s + " : ");
        }

        System.out.println();




    }

}
