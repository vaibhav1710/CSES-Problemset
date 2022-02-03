import java.io.*;
//import java.util.PriorityQueue;
import java.util.*;
 
 
public class Cses {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }
 
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt() {
            return Integer.parseInt(next());
        }
 
        long nextLong() {
            return Long.parseLong(next());
        }
 
        double nextDouble() {
            return Double.parseDouble(next());
        }
 
        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
 
    static int n;
    static int m;
    static boolean visited[];
    static ArrayList<ArrayList<Integer>> arr;
 
    public static void main(String[] args) throws IOException ,NumberFormatException {
      Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
        char grid[][] = new char[n][n];
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < n; j++) {
                grid[i][j] = s.charAt(j);
            }
        }
       int dp[][] = new int[n][n];
        dp[0][0] = 1;
        int m = 1_000_000_007;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='*'){
                    dp[i][j] = 0;
                    continue;
                }
                if(i+1<n && grid[i+1][j]!='*') {
                    dp[i + 1][j] = (dp[i][j] + dp[i+1][j])%m;
                }
                if(j+1<n && grid[i][j+1]!='*') {
                    dp[i][j + 1] = (dp[i][j] + dp[i][j+1])%m;
                }
            }
        }
 
        System.out.println(dp[n-1][n-1]);
 
 
    }
 }