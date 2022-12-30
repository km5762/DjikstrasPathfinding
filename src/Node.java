import java.util.ArrayList;

public class Node {
    private ArrayList<Edge> edges;
    private String name;
    private int minPath;
    private Node thru;


    public int getMinPath() {
        return minPath;
    }

    public Node(String name, ArrayList<Edge> edges) {
        this.name = name;
        this.edges = edges;
        this.minPath = Integer.MAX_VALUE;
    }

    public Node(String name) {
        this.name = name;
        this.edges = new ArrayList<>();
        this.minPath = Integer.MAX_VALUE;
    }

    public void addEdge(Node to, int weight) {
        this.edges.add(new Edge(this, to, weight));
    }

    public void setMinPath(int val) {
        this.minPath = val;
    }

    public String toString() {
        return this.name;
    }

    public ArrayList<Edge> getEdges() {
        return this.edges;
    }

    public void setThru(Node thru) {
        this.thru = thru;
    }

    public Node getThru() {
        return this.thru;
    }

    public void reset() {
        this.minPath = Integer.MAX_VALUE;
        this.thru = null;
    }
}
