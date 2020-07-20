
package graphs;

class Vert {
    public char label;

    public Vert(char lab) {
        label = lab;
    }
}


class DirectedGraph {
    private final int MAX_VERTS = 20;
    private Vert vertexList[];
    private int adjMat[][];
    private int nVerts;
    private char sortedArray[];

    // -------------------------------------------------------------
    public DirectedGraph() {
        vertexList = new Vert[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        for (int j = 0; j < MAX_VERTS; j++)
            for (int k = 0; k < MAX_VERTS; k++)
                adjMat[j][k] = 0;
        sortedArray = new char[MAX_VERTS];
    }

    public void addVertex(char lab) {
        vertexList[nVerts++] = new Vert(lab);
    }

    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
    }

    public void displayVertex(int v) {
        System.out.print(vertexList[v].label);
    }

    // Топологическая сортировка
    public void topo() {
        int orig_nVerts = nVerts; // Сохранение количества вершин
        while (nVerts > 0) {
            int currentVertex = noSuccessors();
            if (currentVertex == -1) {
                System.out.println("ERROR: Graph has cycles");
                return;
            }
            sortedArray[nVerts - 1] = vertexList[currentVertex].label;
            deleteVertex(currentVertex);
        }
        System.out.print("Topologically sorted order: ");
        for (int j = 0; j < orig_nVerts; j++)
            System.out.print(sortedArray[j]);
        System.out.println("");
    }

    public int noSuccessors() {
        boolean isEdge; // Ребро в матрице adjMat, ведущее от row в column
        for (int row = 0; row < nVerts; row++) // Для каждой вершины
        {
            isEdge = false;
            for (int col = 0; col < nVerts; col++) {
                if (adjMat[row][col] > 0) {
                    isEdge = true;
                    break;
                }
            }
            if (!isEdge)
                return row;
        }
        return -1;
    }

    public void deleteVertex(int delVert) {
        if (delVert != nVerts - 1) {
            for (int j = delVert; j < nVerts - 1; j++)
                vertexList[j] = vertexList[j + 1];
            for (int row = delVert; row < nVerts - 1; row++)
                moveRowUp(row, nVerts);
            for (int col = delVert; col < nVerts - 1; col++)
                moveColLeft(col, nVerts - 1);
        }
        nVerts--;
    }

    private void moveRowUp(int row, int length) {
        for (int col = 0; col < length; col++)
            adjMat[row][col] = adjMat[row + 1][col];
    }

    private void moveColLeft(int col, int length) {
        for (int row = 0; row < length; row++)
            adjMat[row][col] = adjMat[row][col + 1];
    }
}

public class DirectedGraphRun {
    public static void main(String[] args) {
        DirectedGraph theGraph = new DirectedGraph();
        theGraph.addVertex('A'); // 0
        theGraph.addVertex('B'); // 1
        theGraph.addVertex('C'); // 2
        theGraph.addVertex('D'); // 3
        theGraph.addVertex('E'); // 4
        theGraph.addVertex('F'); // 5
        theGraph.addVertex('G'); // 6
        theGraph.addVertex('H'); // 7
        theGraph.addEdge(0, 3); // AD
        theGraph.addEdge(0, 4); // AE
        theGraph.addEdge(1, 4); // BE
        theGraph.addEdge(2, 5); // CF
        theGraph.addEdge(3, 6); // DG
        theGraph.addEdge(4, 6); // EG
        theGraph.addEdge(5, 7); // FH
        theGraph.addEdge(6, 7); // GH
        theGraph.topo();

    }
} 
