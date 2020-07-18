package graphs;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Stack;

public class GraphRun {
    public static void main(String[] args) {

    }
}

@AllArgsConstructor
@Data
class Vertex {
    public Vertex (String name) {
        this.name = name;
    }
    private String name;
    private boolean wasVisited;
}

class Graph {
    private final int MAX_VERTEX = 20;
    private Vertex vertexList[];
    private int[][] adjMatx;
    private int nVertex;

    public Graph() {
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

    public int getAdjUnvisitedVertex(int v) {
        for (int j = 0; j < nVertex; j++)
            if (adjMatx[v][j] == 1 && vertexList[j].isWasVisited() == false)
                return j;
        return -1;
    }

    public void dfs() {
        vertexList[0].setWasVisited(true);
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        while (!stack.isEmpty()) {
            int v = getAdjUnvisitedVertex(stack.peek());
            if (v == -1) stack.pop();
            else  {
                vertexList[v].setWasVisited(true);
                stack.push(v);
            }
        }

        for (var vertex : vertexList) {
            vertex.setWasVisited(false);
        }
    }

}
