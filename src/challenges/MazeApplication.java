package challenges;

import java.util.Stack;
import graphs.searchalgorithms.utils.Vertex;

public class MazeApplication {


    public static void main(String[] args) {

        Maze defaultMaze = new Maze();
        defaultMaze.createDefaultMaze();

        Maze customizedMaze = new Maze();
        final Vertex [][] maze = new Vertex[][]{
            {Vertex.createVertex(2), Vertex.createVertex(1), Vertex.createVertex(0), Vertex.createVertex(0), Vertex.createVertex(0)},
            {Vertex.createVertex(0), Vertex.createVertex(1), Vertex.createVertex(0), Vertex.createVertex(1), Vertex.createVertex(0)},
            {Vertex.createVertex(0), Vertex.createVertex(1), Vertex.createVertex(0), Vertex.createVertex(1), Vertex.createVertex(0)},
            {Vertex.createVertex(0), Vertex.createVertex(1), Vertex.createVertex(0), Vertex.createVertex(1), Vertex.createVertex(0)},
            {Vertex.createVertex(0), Vertex.createVertex(0), Vertex.createVertex(0), Vertex.createVertex(1), Vertex.createVertex(3)}
        };

        customizedMaze =  customizedMaze.createCustomizedMaze(customizedMaze, maze);

        MazeApplication app = new MazeApplication();

        System.out.println("DEFAULT MAZE ROUTE TO DESTINATION ");
        app.findDestination(defaultMaze);
        System.out.println("                                  ");
        System.out.println("                                  ");
        System.out.println("CUSTOMIZED MAZE ROUTE TO DESTINATION ");
        app.findDestination(customizedMaze);

    }

    private void findDestination(final Maze maze) {
        setInitialIndices(maze);

        final Vertex startingVertex = maze.getCurrentVertex(maze.getCurrentVertexIndex());

        final Stack<Vertex> routeStack = new Stack<>();

        routeStack.push(startingVertex);

        while (!routeStack.isEmpty()) {

            Vertex currentVertex = routeStack.pop();
            currentVertex.setVisited(true);

            if (currentVertex.getVertexValue() == 3) {
                System.out.print(currentVertex.getVertexValue() + " (at index [" + currentVertex.getVertexIndex().left+ ","
                    + currentVertex.getVertexIndex().right + "])" + " ===> FINISHED !!!");
            } else {

                setAdjacencyOfTheCurrentVertex(maze, currentVertex);

                System.out.print(currentVertex.getVertexValue() + " (at index [" + currentVertex.getVertexIndex().left + ","
                    + currentVertex.getVertexIndex().right + "])" + " -> ");

                for (Vertex vertex : currentVertex.getAdjacencyList()) {

                    if (!vertex.isVisited() && (vertex.getVertexValue() == 0 || vertex.getVertexValue() == 3)
                        && !routeStack.contains(vertex)) {
                        routeStack.push(vertex);
                    }
                }
            }
        }
    }

    private void setInitialIndices(Maze maze) {
        setStartingPoint(maze);
        maze.setCurrentVertexIndex(maze.getStartingPoint());
    }

    private void setStartingPoint(Maze maze) {

        for(int i = 0; i < maze.getMazeMatrix().length; i++) {

            for(int j = 0; j < maze.getMazeMatrix()[i].length; j++) {

                if(maze.getMazeMatrix()[i][j].getVertexValue() == 2) {
                    maze.setStartingPoint(i,j);
                    break;
                }
            }
        }
    }

    private void setAdjacencyOfTheCurrentVertex(Maze maze, Vertex vertex) {

        final int left = vertex.getVertexIndex().left;
        final int right = vertex.getVertexIndex().right;
        final int mazeLength = maze.getMazeMatrix().length;

        // ONE OF NON-EDGED VERTICES
        if (left > 0 && left < mazeLength - 1 && right < mazeLength - 1 && right > 0) {

            vertex.addAdjacentVertex(maze.getMazeMatrix()[left-1][right]); // UP
            vertex.addAdjacentVertex(maze.getMazeMatrix()[left][right-1]); // LEFT
            vertex.addAdjacentVertex(maze.getMazeMatrix()[left+1][right]); // BOTTOM
            vertex.addAdjacentVertex(maze.getMazeMatrix()[left][right+1]); // RIGHT
        }

        //RIGHT EDGE
        else if (left < mazeLength - 1 && left > 0 && right == mazeLength - 1) {

            vertex.addAdjacentVertex(maze.getMazeMatrix()[left-1][right]); // UP
            vertex.addAdjacentVertex(maze.getMazeMatrix()[left][right-1]); // LEFT
            vertex.addAdjacentVertex(maze.getMazeMatrix()[left+1][right]); // BOTTOM
        }

        //LEFT EDGE
        else if (left < mazeLength - 1 && left > 0 && right == 0) {

            vertex.addAdjacentVertex(maze.getMazeMatrix()[left-1][right]); // UP
            vertex.addAdjacentVertex(maze.getMazeMatrix()[left][right+1]); // LEFT
            vertex.addAdjacentVertex(maze.getMazeMatrix()[left+1][right]); // BOTTOM
        }

        //UPPER EDGE
        else if (left == 0 && right < mazeLength - 1 && right > 0) {

            vertex.addAdjacentVertex(maze.getMazeMatrix()[left][right+1]); // RIGHT
            vertex.addAdjacentVertex(maze.getMazeMatrix()[left][right+1]); // LEFT
            vertex.addAdjacentVertex(maze.getMazeMatrix()[left+1][right]); // BOTTOM
        }

        //LOWER EDGE
        else if (left == mazeLength - 1 && right < mazeLength - 1 && right > 0) {

            vertex.addAdjacentVertex(maze.getMazeMatrix()[left][right+1]); // RIGHT
            vertex.addAdjacentVertex(maze.getMazeMatrix()[left][right+1]); // LEFT
            vertex.addAdjacentVertex(maze.getMazeMatrix()[left-1][right]); // UP
        }

        //UP-LEFT CORNER
        else if (left == 0 && right == 0) {
            vertex.addAdjacentVertex(maze.getMazeMatrix()[left][right+1]); // RIGHT
            vertex.addAdjacentVertex(maze.getMazeMatrix()[left+1][right]); // BOTTOM
        }

        //UP-RIGHT CORNER
        else if (left == 0 && right == mazeLength - 1) {
            vertex.addAdjacentVertex(maze.getMazeMatrix()[left][right-1]); // LEFT
            vertex.addAdjacentVertex(maze.getMazeMatrix()[left+1][right]); // BOTTOM
        }

        //BOTTOM-RIGHT CORNER
        else if (left == mazeLength - 1 && right == mazeLength - 1) {
            vertex.addAdjacentVertex(maze.getMazeMatrix()[left][right-1]); // LEFT
            vertex.addAdjacentVertex(maze.getMazeMatrix()[left-1][right]); // UP
        }

        //BOTTOM-LEFT CORNER
        else if (left == mazeLength - 1 && right == 0) {
            vertex.addAdjacentVertex(maze.getMazeMatrix()[left][right+1]); // RIGHT
            vertex.addAdjacentVertex(maze.getMazeMatrix()[left-1][right]); // UP
        }


    }

}
