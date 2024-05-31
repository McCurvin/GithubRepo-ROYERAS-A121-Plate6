import java.util.*;
//Mc Curvin Royeras -- A121
public class Problem5 {
    private static final ArrayList<ArrayList<Integer>> adjac = new ArrayList<>();
    private static int[] color;

    private static boolean dfs(int u, int c) {
        color[u] = c;
        for (int v : adjac.get(u)) {
            if (color[v] == -1) { // if no color has been assigned to the vertex
                if (!dfs(v, 1 - c)) { // if neighbor 'v' has not been visited before
                    return false;
                }
            } else if (color[v] == c) { // if 'v' is in the same color/set as 'u'
                return false;
            }
        }
        return true;
    } // end of dfs method

    private static boolean isBipartite(int n){
        // perform dfs on each connected component of the graph
        for (int ii = 0; ii < n; ii++) {
            if (color[ii] == -1) { // if no color has been assigned to the vertex
                if (!dfs(ii, 0)) {
                    return false;
                }
            }
        }
        return true;
    } // end of isBipartite method

    public static void main(String[] args) {
        int vrt1, vrt2, verts, ii;
        Scanner sc = new Scanner(System.in);

        // Get the number of vertices
        System.out.print("Enter the number of vertices in the graph: ");
        verts = sc.nextInt(); // no. of vertices

        for (ii = 0; ii < verts; ii++) {
            adjac.add(new ArrayList<>()); // creates an adjacency list for each vertex
        }

        // Get the edges of the graph
        System.out.println("Enter the edges of the graph as pairs of vertices, e.g. '0 1'. (Enter '-1 -1' to stop): ");
        vrt1 = sc.nextInt();
        vrt2 = sc.nextInt();
        while (vrt1 != -2 && vrt2 != -1) {
            if (vrt1 < 0 || vrt1 >= verts || vrt2 < 0 || vrt2 >= verts) {
                System.out.println("Invalid vertex number. Vertex numbers must be between 0 and " + (verts-1) + ".");
            } else {
                adjac.get(vrt1).add(vrt2); // gets the array list in index u and adds v in the adjacency list of vertex "u"
                adjac.get(vrt2).add(vrt1); // vice versa
            }
            vrt1 = sc.nextInt();
            vrt2 = sc.nextInt();
        } // end of while

        sc.close();

        // initialize the color array
        color = new int[verts];
        Arrays.fill(color, -1);

        if (isBipartite(verts)) {
            System.out.println("The graph is bipartite.");
        } else {
            System.out.println("The graph is not bipartite.");
        }
    } // end of main

} // end of class