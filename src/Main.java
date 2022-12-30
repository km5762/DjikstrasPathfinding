import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] adjMatrix = {
                {0, 53, 10, 12, 0, 0, 0, 0, 0, 0},
                {53, 0, 33, 0, 2, 0, 101, 0, 0, 0},
                {10, 33, 0, 9, 30, 18, 0, 0, 0, 0},
                {12, 0, 9, 0, 0, 17, 0, 0, 6, 0},
                {0, 2, 30, 0, 0, 14, 123, 122, 0, 0},
                {0, 0, 18, 17, 14, 0, 0, 137, 7, 0},
                {0, 101, 0, 0, 123, 0, 0, 8, 0, 71},
                {0, 0, 0, 0, 122, 137, 8, 0, 145, 66},
                {0, 0, 0, 6, 0, 7, 0, 145, 0, 212},
                {0, 0, 0, 0, 0, 0, 71, 66, 212, 0}
        };
        Graph graph = new Graph(adjMatrix);
        System.out.println("Dijkstra's Pathfinder V1.0. type \"exit\" to terminate the program. To continue, press enter.");
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("exit"))
                break;
            else {
                System.out.println("Enter starting node:");
                String start = scanner.nextLine();
                System.out.println("Enter ending node:");
                String end = scanner.nextLine();
                if (graph.isValidNode(start) && graph.isValidNode(end))
                    System.out.println(graph.getMinPath(start, end));
                else
                    System.out.println("Error: Invalid nodes entered. Please enter only valid nodes.");
            }
        }
    }
}
