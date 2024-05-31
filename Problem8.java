import java.util.*;
//Mc Curvin Royeras -- A121
public class Problem8 {
    private static int[][] adj1, adj2;
    private static int verts;

    private static void readEdges(int[][] adj, Scanner sc) {
        int vrt1, vrt2;
        vrt1 = sc.nextInt();
        vrt2 = sc.nextInt();
        while (vrt1 != -1 && vrt2 != -1) {
            if (vrt1 < 0 || vrt1 >= verts || vrt2 < 0 || vrt2 >= verts) {
                System.out.println("Invalid vertex number. Vertex numbers must be between 0 and " + (verts-1) + ".");
            } else {
                // Add the edge to the adjacency matrix
                adj[vrt1][vrt2]++;
                adj[vrt2][vrt1]++;
            }
            vrt1 = sc.nextInt();
            vrt2 = sc.nextInt();
        } // end of while
    } // end of readEdges method

    private static boolean isIsomorphic() {
        // try every permutation of vertices
        int[] permutation = new int[verts];
        for (int i = 0; i < verts; i++) {
            permutation[i] = i;
        }
        return isIsomorphic(permutation, 0);
    } // end of isIsomorphic method

    private static boolean isIsomorphic(int[] permutation, int index) {
        if (index == verts) {
            // check if the current permutation produces a valid mapping
            for (int i = 0; i < verts; i++) {
                for (int j = 0; j < verts; j++) {
                    if (adj1[i][j] != adj2[permutation[i]][permutation[j]]) {
                        return false;
                    }
                }
            } // end of for loop
            return true;
        } else {
            // try swapping the current index with each index greater than or equal to it
            for (int i = index; i < verts; i++) {
                swap(permutation, index, i);
                if (isIsomorphic(permutation, index+1)) {
                    return true;
                }
                swap(permutation, index, i);
            } // end of for loop
            return false;
        }
    } // end of isIsomorphic method with 2 parameters

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    } // end of swap method
 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Get the number of vertices
        System.out.print("Enter the number of vertices in the graphs: ");
        verts = sc.nextInt();

        // Create adjacency matrices for the 2 graphs
        adj1 = new int[verts][verts];
        adj2 = new int[verts][verts];

        // Get the edges of the first graph
        System.out.println("Enter the edges of the 1st graph as pairs of vertices, e.g. '0 1'. (Enter '-1 -1' to stop): ");
        readEdges(adj1, sc);

        // Get the edges of the second graph
        System.out.println("Enter the edges of the 2nd graph as pairs of vertices, e.g. '0 1'. (Enter '-1 -1' to stop): ");
        readEdges(adj2, sc);

        sc.close();

        // Check if the graphs are isomorphic
        if (isIsomorphic()) {
            System.out.println("The graphs are isomorphic.");
        } else {
            System.out.println("The graphs are not isomorphic.");
        }
    } // end of main


} // end of class

