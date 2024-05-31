import java.util.Scanner;
//Mc Curvin Royeras -- A121
public class Problem6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vrt1 = sc.nextInt();
        int vrt2 = sc.nextInt();
        // Get the number of vertices
        System.out.print("Enter the number of vertices in your graph: ");
        int vert = sc.nextInt();

        // Create the adjacency matrix
        int[][] adjMat = new int[vert][vert];

        // Get whether the graph is directed or undirected
        System.out.print("Is the graph directed? (y/n): ");
        String directed = sc.next();
        boolean isDirected = directed.equalsIgnoreCase("y");

        // Get the edges of the graph
        System.out.println("Enter the edges of the graph as pairs of vertices, e.g. '0 1'. (Enter '-1 -1' to stop): ");
    
        while (vrt1 != -1 && vrt2 != -1) {
            if (vrt1 < 0 || vrt1 >= vert || vrt2 < 0 || vrt2 >= vert) {
                System.out.println("Invalid input. Vertex numbers must be between 0 and " + (vert-1) + ".");
            } else {
                // Add the edge to the adjacency matrix
                adjMat[vrt1][vrt2]++;
                if (!isDirected && vrt1 != vrt2) {
                    adjMat[vrt2][vrt1]++;
                }
            }
            vrt1 = sc.nextInt();
            vrt2 = sc.nextInt();
        } // end of while

        sc.close();

        // Print the adjacency matrix
        System.out.println("\nAdjacency Matrix:");
        for (int i = 0; i < vert; i++) {
            for (int j = 0; j < vert; j++) {
                System.out.print(adjMat[i][j] + " ");
            }
            System.out.println();
        } // end of for

    } // end of main
} // end of class