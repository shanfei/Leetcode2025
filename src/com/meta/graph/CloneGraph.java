package com.meta.graph;

import common.GraphNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CloneGraph {

    public GraphNode cloneGraph(GraphNode node) {

        GraphNode cloneNode = dfs(node, new HashSet<>());

        return cloneNode;
    }


    GraphNode dfs(GraphNode node, Set<GraphNode> visited) {

        if (visited.contains(node)) {
            return null;
        }

        GraphNode cloneNode = new GraphNode(node.val, new ArrayList<>());

        visited.add(node);

        for ( GraphNode n : node.neighbors ) {
            GraphNode cn = dfs(n, visited);
            if ( cn != null ) {
                cloneNode.neighbors.add(cn);
            }
        }

        return cloneNode;
    }
}
