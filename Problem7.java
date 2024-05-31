import java.util.Scanner;
//Mc Curvin Royeras -- A121
public class Problem7 {
    public static void main(String[] args) {
        int verts, edges; int ii, jj;
        Scanner sc = new Scanner(System.in);

        // Get the number of vertices
        System.out.print("Enter the number of vertices in the graph: ");
        verts = sc.nextInt();

        // Get the number of edges
        System.out.print("Enter the number of edges in the graph: ");
        edges = sc.nextInt();

        int[][] incMat = new int[verts][edges]; // creates a 2D array for the incidence matrix

        // Get the edges of the graph
        System.out.println("Enter the edges of the graph as pairs of vertices followed by the number of times each edge appears, e.g. '0 1 2'.");
        for (ii = 0; ii < edges; ii++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int count = sc.nextInt();

            for (int j = 0; j < count; j++){
                incMat[u][ii+j] = 1;
                incMat[v][ii+j] = 1;
            }
            ii+=count-1;
        }

        sc.close();

        // Print the incidence matrix
        System.out.println("Incidence matrix:");
        for (ii = 0; ii < verts; ii++) {
            for (jj = 0; jj < edges; jj++) {
                System.out.print(incMat[ii][jj] + " ");
            }
            System.out.println();
        } // end of for loop

    } // end of main
} // end of class
