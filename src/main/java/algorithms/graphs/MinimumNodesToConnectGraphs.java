package algorithms.graphs;

import java.util.*;

public class MinimumNodesToConnectGraphs {

    public int calculate(List<int[]> connections, List<int[]> connectionCosts) {
        List<Set<Integer>> setsByGraph = buildSetByGraph(connections);
        Collections.sort(connectionCosts, Comparator.comparingInt(e -> e[2]));
        int cost = 0;
        connectionCosts.stream().map(c ->
            buildSetByConnection(setsByGraph, c) ? c[2] : 0
        );

        return cost;
    }

    private List<Set<Integer>> buildSetByGraph(List<int[]> connections) {
        List<Set<Integer>> setByGraph = new ArrayList<>();
        connections.stream().forEach(c -> buildSetByConnection(setByGraph, c));

        return setByGraph;
    }

    private boolean buildSetByConnection(List<Set<Integer>> setByGraph, int[] connection) {
        Optional<Set<Integer>> set1Opt = findSetByNode(setByGraph, connection[0]);
        Optional<Set<Integer>> set2Opt = findSetByNode(setByGraph, connection[1]);

        if (set1Opt.isPresent() && set2Opt.isPresent()) {
            if (set1Opt.get().equals(set2Opt.get())) {
                return false;
            }

            set1Opt.get().addAll(set2Opt.get());
            setByGraph.remove(set2Opt.get());
        } else if (set1Opt.isPresent()) {
            set1Opt.get().add(connection[1]);
        } else if (set2Opt.isPresent()) {
            set2Opt.get().add(connection[0]);
        } else {
            Set<Integer> newSet = new HashSet<>();
            newSet.add(connection[0]);
            newSet.add(connection[1]);
            setByGraph.add(newSet);
        }

        return true;
    }

    private Optional<Set<Integer>> findSetByNode(List<Set<Integer>> setsByGraph, Integer node) {
        return setsByGraph.stream().filter(s -> s.contains(node)).findFirst();
    }
}
