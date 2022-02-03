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
 
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        int x = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        long dp[] = new long[x+1];
        dp[0]=1;
      for(int i=0;i<n;i++){
          for(int j=1;j<=x;j++){
                if(j-arr[i]>=0){
                    dp[j] = (dp[j]+dp[j-arr[i]])%1000000007;
                }
            }
        }
 
        System.out.println((dp[x]%1000000007));
 
 
 
    }
 
}
 