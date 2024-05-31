import java.util.*;
//Mc Curvin Royeras - A121
public class Problem3 {

    private static final ArrayList<ArrayList<Integer>> adjacent = new ArrayList<>(); // adjacency list
    private static boolean hasCycle;
    public static void main(String[] args) {
        int vertex1, vertex2, vertices;
        int ii;
        Scanner scan = new Scanner(System.in);

        // Get the number of vertices
        System.out.print("Enter the number of vertices in the graph: ");
        vertices = scan.nextInt();

        for (ii = 0; ii < vertices; ii++) {
            adjacent.add(new ArrayList<>()); // creates an adjacency list for each vertex
        }

        // Get the edges of the graph
        System.out.println("Enter the edges of the graph as pairs of vertices, e.g. '0 1'. (Enter '-2 -1' to stop): ");
        vertex1 = scan.nextInt();
        vertex2 = scan.nextInt();

        while (vertex1 != -2 && vertex2 != -1) {
            if (vertex1 < 0 || vertex1 >= vertices || vertex2 < 0 || vertex2 >= vertices) {
                System.out.println("Invalid vertex number. Vertex numbers must be between 0 and " + (vertices-1) + ".");
            } else {
                adjacent.get(vertex1).add(vertex2); // gets the array list in index u and adds v in the adjacency list of vertex "u"
                adjacent.get(vertex2).add(vertex1); // vice versa
            }
            vertex1 = scan.nextInt();
            vertex2 = scan.nextInt();
        } // end of while

        if (hasCycle(vertices)) {
            System.out.println("The graph contains a cycle.");
        } else {
            System.out.println("The graph does not contain a cycle.");
        }

        scan.close();
    } // end of main

    private static boolean hasCycle(int V) {
        boolean[] visited = new boolean[V]; // keeps track of vertices visited
        for (int v = 0; v < V; v++) {
            if (!visited[v]) { // if a vertex has not been visited
                if (dfs(v, -1, visited)) { // (since starting vertex has no parent, parent = -1)
                    hasCycle = true;
                    break;
                }
            }
        }
        return hasCycle;
    } // end of hasCycle method
    // depth-first search
    private static boolean dfs(int v, int parent, boolean[] visited) {
        visited[v] = true;
        for (int w : adjacent.get(v)) { // for each adjacent vertex
            if (!visited[w]) { // if adjacent vertex has not been visited
                if (dfs(w, v, visited)) {
                    return true;
                }
            } else if (w != parent) { // if w is not the parent of the vertex
                return true;
            }
        }
        return false;
    } // end of dfs method
} // end of class