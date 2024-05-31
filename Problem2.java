import java.util.Scanner;
//Mc Curvin Royeras -- A121
public class Problem2 {
    public static void main(String[] args) {
        int ii, jj, n;
        int index = 0;
        Scanner scan = new Scanner(System.in);

        // Get the number of vertices
        System.out.print("Enter the number of vertices of this graph: ");
        n = scan.nextInt(); // no. of vertices
        int[][] adjacentMatrix = new int[n][n]; // n x n matrix
        System.out.println("Enter the adjacency matrix of the graph: ");
        for (ii = 0; ii < n; ii++) {
            for (jj = 0; jj < n; jj++) { adjacentMatrix[ii][jj] = scan.nextInt(); }
        }
        int[][] edges = new int[n*(n-1)/2][2]; // 2 columns to store the vertex indices
        int[] counts = new int[n*(n-1)/2];
        // Get the edges of the graph
        System.out.println("Edges of the graph:");

        /* [n * (n-1)] excludes the diagonal and divides the total to 2
        to get the total number of edges, without counting them twice. */

        for (ii = 0; ii < n; ii++) {
            for (jj = ii + 1; jj < n; jj++) { // 1 is added to i to consider the elements above the diagonal
                if (adjacentMatrix[ii][jj] != 0) { // if there is an edge between vertices i and j
                    edges[index][0] = ii;
                    edges[index][1] = jj;
                    counts[index] = adjacentMatrix[ii][jj]; // no. of times a specific edge appears
                    index++;
                }
            }
        }
        for (ii = 0; ii < index; ii++) { // displays each edge with the no. of times it appears
            System.out.println("{" + edges[ii][0] + ", " + edges[ii][1] + "} or {" + edges[ii][1] + ", " +
                    edges[ii][0] + "} : " + counts[ii] + " time(s)");
        }
        scan.close();
    } // end of main
} // end of class