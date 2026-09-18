import java.util.*;

public class Dijkstras {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int INF = 999;
        System.out.println("Enter number of nodes:");
        int n = sc.nextInt();
        int[][] cost = new int[n + 1][n + 1];
        int[] d = new int[n + 1], vis = new int[n + 1];
        System.out.println("Enter cost matrix (999 if no edge):");
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++) {
                cost[i][j] = sc.nextInt();
                if (i == j)
                    cost[i][j] = 0;
            }
        System.out.println("Enter source vertex:");
        int s = sc.nextInt();
        for (int i = 1; i <= n; i++)
            d[i] = cost[s][i];
        vis[s] = 1;
        for (int ne = 1; ne < n; ne++) {
            int min = INF, u = -1;
            for (int i = 1; i <= n; i++)
                if (vis[i] == 0 && d[i] < min) {
                    min = d[i];
                    u = i;
                }
            if (u == -1)
                break;
            vis[u] = 1;
            for (int v = 1; v <= n; v++)
                if (vis[v] == 0 && cost[u][v] != INF && d[v] > d[u] + cost[u][v])
                    d[v] = d[u] + cost[u][v];
        }
        System.out.println("Shortest paths:");
        for (int i = 1; i <= n; i++)
            if (i != s)
                System.out.println(
                        d[i] == INF ? "No path from " + s + " to " + i : "From " + s + " to " + i + " = " + d[i]);
        sc.close();
    }
}