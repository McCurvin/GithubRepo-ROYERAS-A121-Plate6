import java.util.Scanner;
import java.util.ArrayList;
//Mc Curvin Royeras -- A121
public class Problem1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); //Instantiation of Scanner
        int vertices, u, v, count, isolatedVertices; //Declaring variables

        System.out.print("Enter graph's number of vertices: ");
        vertices = scan.nextInt();

        ArrayList<ArrayList<Integer>> adjacent = new ArrayList(); //Graph's adjacency list
        for (int ii = 0; ii < vertices; ii++) {
            adjacent.add(new ArrayList<>()); //adding each user input to the ArrayList named adjacent
        }
        //Obtaining the graph's edges
        System.out.println("Enter the edges of the graph as pairs in the format n n (i.e. 0 1). To stop the program, enter -2 -1: ");
        u = scan.nextInt();
        v = scan.nextInt();
        while (u != -2 && v != -1) {
            if (u < 0 || u >= vertices || v < 0 || v >= vertices) { //
                System.out.println("Invalid input. Vertex numbers must be between 0 to "+(vertices-1)+".");
            }
            else {
                adjacent.get(u).add(v); //obtains the array list in index u and adds v inside the adjacency list of u
                adjacent.get(v).add(u); //does the same as Line 25, but the other way around.
            }
            u = scan.nextInt();
            v = scan.nextInt();
        }
        scan.close();

        int[] result = isConnected(vertices, adjacent);
        count = result[0];
        isolatedVertices = result[1];
        if (count == 1) {
            System.out.println("The graph is connected.");
        }
        else {
            System.out.println("The graph has "+count+" connected components and "+ isolatedVertices+" isolated vertices.");
        }
        
    }
    private static void dfs(int node, ArrayList<ArrayList<Integer>> adjacent, boolean[] visited) {
        visited[node] = true;
        for (int neighbor : adjacent.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adjacent, visited);
            }
        }
    }
    private static int[] isConnected(int vertices, ArrayList<ArrayList<Integer>> adjacent) {
        boolean[] visited = new boolean[vertices];
        int count = 0;
        int isolatedVertices = 0;
        for (int ii = 0; ii < vertices; ii++) {
            if (!visited[ii]) {
                dfs(ii, adjacent, visited);
                count++;
            }
            if (adjacent.get(ii).isEmpty()) {
                isolatedVertices++;
            }
        }
        int[] result = new int[2];
        result[0] = count;
        result[1] = isolatedVertices;
        return result;
    }
}