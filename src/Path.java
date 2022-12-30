import java.util.LinkedList;

public class Path extends LinkedList<Node> {
    public String toString() {
        String stringRep = "";
        for (int i = 0; i < this.size(); i++) {
            if (i != this.size() - 1)
                stringRep += (this.get(i).toString() + " -> ");
            else
                stringRep += (this.get(i).toString()) + ", Length: " + this.length();
        }
        if (this.getFirst().toString().equals("A") && this.getLast().toString().equals("D"))
            stringRep += "        ( Dijkstra backwards !!!! )";
        return stringRep;
    }

    public int length() {
        return this.getLast().getMinPath();
    }
}
