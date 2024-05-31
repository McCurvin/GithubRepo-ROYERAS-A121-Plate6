import java.util.ArrayList;
import java.util.Scanner;
//Mc Curvin Royeras - A121
@SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
public class Problem4 {

    private static final ArrayList<ArrayList<Integer>> adjacent = new ArrayList<>(); // adjacency list
    private static final ArrayList<String> stringAdjacent = new ArrayList<>(); // adjacency list
    public static void main(String[] args) {
        int vertex1, vertex2, vertices, size, total = 0;
        int ii;
        Scanner scan = new Scanner(System.in);

        // Get the number of vertices
        System.out.print("Enter the number of vertices in the graph: ");
        vertices = scan.nextInt(); // no. of vertices

        for (ii = 0; ii < vertices; ii++) {
            adjacent.add(new ArrayList<>()); // creates an adjacency list for each vertex
        }

        // Get the edges of the graph
        System.out.println("Enter the edges of the graph as pairs of vertices, e.g. '0 1'. (Enter '-1 -1' to stop): ");
        vertex1 = scan.nextInt();
        vertex2 = scan.nextInt();
        while (vertex1 != -1 && vertex2 != -1) {
            if (vertex1 < 0 || vertex1 >= vertices || vertex2 < 0 || vertex2 >= vertices) {
                System.out.println("Invalid vertex number. Vertex numbers must be between 0 and " + (vertices-1) + ".");
            } else {
                adjacent.get(vertex1).add(vertex2); // gets the array list in index u and adds v in the adjacency list of vertex "u"
                adjacent.get(vertex2).add(vertex1); // vice versa
                stringAdjacent.add("{" + vertex1 + ", " + vertex2 + "}");
            }
            vertex1 = scan.nextInt();
            vertex2 = scan.nextInt();
        } // end of while

        scan.close();

        for (ii = 0; ii < vertices; ii++){
            size = adjacent.get(ii).size(); // gets no. of adjacent vertices for every vertex i
            total+=size; // computes total degrees
            System.out.println("deg(" + ii + "): " + size); // displays degrees per vertex
        }
        System.out.println("\nTotal Degree of Graph: " + total); // displays total degrees

    } // end of main

} // end of class