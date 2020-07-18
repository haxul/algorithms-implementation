package graphs;

import lombok.AllArgsConstructor;
import lombok.Data;

public class GraphRun {
    public static void main(String[] args) {
        
    }
}

@AllArgsConstructor
@Data
class Vertex {
    private String name;
}

class Graph {
    private final int MAX_VERTEX = 20;
    private Vertex vertexList[];
    private int[][] adjMatx;
    private int nVertex;

    public Graph () {
        vertexList = new Vertex[MAX_VERTEX];
        adjMatx = new int[MAX_VERTEX][MAX_VERTEX];
        nVertex = 0;
        for (int i = 0; i < MAX_VERTEX; i++) {
            for (int j = 0; j < MAX_VERTEX; j++) {
                adjMatx[i][j] = 0;
            }
        }
    }

    public void addVertex(String name) {
        vertexList[nVertex++] = new Vertex(name);
    }

    public void addEdge(int start, int end) {
        adjMatx[start][end] = 1;
        adjMatx[end][start] = 1;
    }
}
