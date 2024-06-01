import java.util.Scanner;
 
// This program creates an adjacency matrix representation of a graph based on user input.
// Written by Mc Curvin Royeras -- A121
 
public class Problem6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       
        // Prompting the user to input the number of vertices in the graph
        System.out.print("Enter the number of vertices in your graph: ");
        int vert = sc.nextInt(); // Number of vertices
 
        // Creating the adjacency matrix
        int[][] adjMat = new int[vert][vert];
 
        // Asking whether the graph is directed or undirected
        System.out.print("Is the graph directed? (y/n): ");
        String directed = sc.next();
        boolean isDirected = directed.equalsIgnoreCase("y"); // Checking if the input is "y"
 
        // Prompting the user to input the edges of the graph
        System.out.println("Enter the edges of the graph as pairs of vertices, e.g. '0 1'. (Enter '-1 -1' to stop): ");
        int vrt1 = sc.nextInt();
        int vrt2 = sc.nextInt();
 
    
        // Processing the input edges until termination condition is met
        while (vrt1 != -1 && vrt2 != -1) {
            if (vrt1 < 0 || vrt1 >= vert || vrt2 < 0 || vrt2 >= vert) {
                System.out.println("Invalid input. Vertex numbers must be between 0 and " + (vert - 1) + ".");
            } else {
                // Adding the edge to the adjacency matrix
                adjMat[vrt1][vrt2]++; // Incrementing the count of the edge from vertex vrt1 to vrt2
                if (!isDirected && vrt1 != vrt2) {
                    adjMat[vrt2][vrt1]++; // If undirected, increment the count of the edge from vrt2 to vrt1 as well
                }
            }
            // Getting the next pair of vertices from the user
            vrt1 = sc.nextInt();
            vrt2 = sc.nextInt();
        } // End of while
 
        sc.close(); // Closing the Scanner object after input is complete
 
        // Printing the adjacency matrix
        System.out.println("\nAdjacency Matrix:");
        for (int i = 0; i < vert; i++) {
            for (int j = 0; j < vert; j++) {
                System.out.print(adjMat[i][j] + " ");
            }
            System.out.println();
        } // End of for
    } // End of main
} // End of class