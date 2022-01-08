import static utils.Graph.initializeDefaultGraphUsingAdjacencyList;

import searchalgorithms.BreadthFirstSearch;
import searchalgorithms.DepthFirstSearch;
import org.apache.commons.lang3.tuple.Pair;
import utils.Graph;
import utils.Vertex;
import java.util.List;

public class SearchApplication {

    public static void main(String[] args) {
        List<Vertex> graphBFS = initializeDefaultGraphUsingAdjacencyList();
        List<Vertex> graphDFS = initializeDefaultGraphUsingAdjacencyList();

        implementBFS(graphBFS);
        implementRecursiveDFS(graphDFS, false);

        final Graph customizedGraph = new Graph();

        List<Vertex> customGraphList = customizedGraph.initializeCustomGraphUsingAdjacencyList(8);
        customizedGraph.setAdjacency(Pair.of(customGraphList.get(0),customGraphList.get(6)));
        customizedGraph.setAdjacency(Pair.of(customGraphList.get(2),customGraphList.get(1)));
        customizedGraph.setAdjacency(Pair.of(customGraphList.get(2),customGraphList.get(3)));
        customizedGraph.setAdjacency(Pair.of(customGraphList.get(2),customGraphList.get(4)));
        customizedGraph.setAdjacency(Pair.of(customGraphList.get(3),customGraphList.get(7)));
        customizedGraph.setAdjacency(Pair.of(customGraphList.get(4),customGraphList.get(3)));
        customizedGraph.setAdjacency(Pair.of(customGraphList.get(4),customGraphList.get(7)));
        customizedGraph.setAdjacency(Pair.of(customGraphList.get(5),customGraphList.get(0)));
        customizedGraph.setAdjacency(Pair.of(customGraphList.get(6),customGraphList.get(5)));

       System.out.println("===> CUSTOMIZED");
       implementRecursiveDFS(customGraphList, true);

    }

    private static void implementBFS(final List<Vertex> graph) {

        System.out.println("################ BREADTH FIRST ALGORITHM ################");

        BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch();
        breadthFirstSearch.traverse(graph.get(0));

        System.out.println("                                                         ");
    }

    private static void implementRecursiveDFS(final List<Vertex> graph, final boolean clustered) {

        System.out.println("################ RECURSIVE DEPTH FIRST ALGORITHM ################");

        DepthFirstSearch depthFirstSearch = new DepthFirstSearch();

        if (clustered) {
            depthFirstSearch.traverseClustersRecursively(graph);
        }
        else {
            depthFirstSearch.traverseRecursively(graph.get(0));
        }

        System.out.println("                                                         ");
    }

}
