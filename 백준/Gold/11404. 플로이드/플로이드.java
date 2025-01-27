import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] arr = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            Arrays.fill(arr[i], Integer.MAX_VALUE);
            arr[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            arr[start][end] = Math.min(arr[start][end], cost);
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (arr[i][k] != Integer.MAX_VALUE && arr[k][j] != Integer.MAX_VALUE) {
                        arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (arr[i][j] == Integer.MAX_VALUE) {
                    sb.append("0 ");
                } else {
                    sb.append(arr[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}