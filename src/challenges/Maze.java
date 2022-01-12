package challenges;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.tuple.Pair;
import searchalgorithms.utils.Vertex;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class Maze {

   private Vertex [][] mazeMatrix;
   private Pair<Integer, Integer> startingPoint;
   private Pair<Integer, Integer> currentVertexIndex;

    public void createDefaultMaze() {

        this.mazeMatrix = new Vertex[][]{
            {Vertex.createVertex(1), Vertex.createVertex(1), Vertex.createVertex(1), Vertex.createVertex(1), Vertex.createVertex(1)},
            {Vertex.createVertex(1), Vertex.createVertex(2), Vertex.createVertex(0), Vertex.createVertex(1), Vertex.createVertex(1)},
            {Vertex.createVertex(1), Vertex.createVertex(1), Vertex.createVertex(0), Vertex.createVertex(1), Vertex.createVertex(1)},
            {Vertex.createVertex(1), Vertex.createVertex(1), Vertex.createVertex(0), Vertex.createVertex(0), Vertex.createVertex(0)},
            {Vertex.createVertex(1), Vertex.createVertex(1), Vertex.createVertex(1), Vertex.createVertex(1), Vertex.createVertex(3)}
        };

        setVerticesNames(this.mazeMatrix);

    }

    public Maze createCustomizedMaze(final Maze customizedMaze, final Vertex [][] maze) {

        customizedMaze.setMazeMatrix(maze);
        setVerticesNames(maze);
        return customizedMaze;

    }

    public void setStartingPoint(final int left, final int right) {

        this.startingPoint = Pair.of(left, right);
    }

    public void setCurrentVertexIndex(final Pair<Integer, Integer> currentVertexIndex) {

        this.currentVertexIndex = currentVertexIndex;
    }

    public Vertex getCurrentVertex(final Pair<Integer, Integer> currentVertexIndex) {

        return mazeMatrix[currentVertexIndex.getLeft()][currentVertexIndex.getRight()];
    }

    private void setVerticesNames(final Vertex [][] maze) {

        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                maze[i][j].setVertexIndex(Pair.of(i,j));
                switch ( maze[i][j].getVertexValue()) {
                    case 0:
                        maze[i][j].setName("Route");
                        break;
                    case 1:
                        maze[i][j].setName("Wall");
                        break;
                    case 2:
                        maze[i][j].setName("Starting Point");
                        break;
                    case 3:
                        maze[i][j].setName("Destination Point");
                        break;
                }
            }
        }
    }

}
