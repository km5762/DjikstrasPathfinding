import java.util.Comparator;

public class DijkstraComparator implements Comparator<Node> {

    @Override
    public int compare(Node node1, Node node2) {
        if (node1.getMinPath() > node2.getMinPath())
            return 1;
        else if (node1.getMinPath() < node2.getMinPath())
            return -1;
        else
            return 0;
    }
}
