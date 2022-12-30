import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.PriorityQueue;

public class Graph {
    private LinkedHashSet<Node> nodes;
    private final static String[] names = {"A", "J", "M", "R", "K", "S", "I", "N", "T", "D"};

    public Graph(int[][] adjMatrix) {
        this.nodes = new LinkedHashSet<>();
        for (int row = 0; row < adjMatrix.length; row++) {          /// initializing all nodes
            nodes.add(new Node(names[row]));
        }
        Iterator<Node> currentNode = nodes.iterator();          /// current node for which we are setting edges
        for (int row = 0; row < adjMatrix.length; row++) {          /// setting edges for each node
            Node sourceNode = currentNode.next();
            Iterator<Node> hasEdgeTo = nodes.iterator();            /// nodes which we are setting edges to
            for (int edgeWeight : adjMatrix[row]) {
                Node destinationNode = hasEdgeTo.next();
                if (edgeWeight != 0) {            /// if the current node has an edge, add the edge to it's adj list
                    sourceNode.addEdge(destinationNode, edgeWeight);
                }
            }
        }
    }

    public LinkedHashSet<Node> getNodes() {
        return nodes;
    }

    public void djiksrasAlg(Node source) {
        PriorityQueue<Node> queue = new PriorityQueue<>(new DijkstraComparator());
        source.setMinPath(0);
        queue.addAll(nodes);

        while (!queue.isEmpty()) {
            Node currentNode = queue.peek();
            for (Edge edge : currentNode.getEdges()) {
                Node toNode = edge.getTo();
                int totalPathLength = edge.getWeight() + currentNode.getMinPath();
                if (totalPathLength < toNode.getMinPath()) {      /// if the path to the next node + that nodes minpath is less than that nodes current minpath, update its minpath and thru
                    toNode.setMinPath(totalPathLength);
                    toNode.setThru(currentNode);
                    queue.remove(toNode);
                    queue.add(toNode);
                }
            }
            queue.poll();
        }
    }

    public Path getMinPath(String from, String to) {
        Path minPath = new Path();
        Node start = findNode(from);
        Node end = findNode(to);

        resetNodes();
        djiksrasAlg(start);

        Node currentNode = end;
        while (currentNode != null) {
            minPath.addFirst(currentNode);
            currentNode = currentNode.getThru();
        }
        return minPath;
    }

    public void resetNodes() {
        Iterator<Node> iter = nodes.iterator();
        for (Node node : nodes) {
            iter.next().reset();
        }
    }

    public boolean isValidNode(String node) {
        return Arrays.stream(names).anyMatch(node :: equals);
    }

    public Node findNode(String name) {
        for (Node node : nodes) {
            if (node.toString().equals(name))
                return node;
        }
        return null;
    }
}
