

import java.net.CookieHandler;
import java.util.*;
import java.io.*;

public class Cses {

    static FastScanner fs = null;
   
    public static void main(String[] args) {
        fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        int n = fs.nextInt();
        int a[] = new int[n+1];
        if(n<10){
            out.println(1);
        }else{
            int dp[] = new int[n+1];
            Arrays.fill(dp,Integer.MAX_VALUE);
            dp[0] = 0;
             for(int i=1;i<=9;i++){
                 dp[i]  = 1;
             }

             for(int i=10;i<=n;i++){
                 int tmp=i;
                 int min = Integer.MAX_VALUE;
                 while(tmp>0){
                     int r = tmp%10;
                     tmp = tmp/10;
                     min = Math.min(min , dp[i - r]);
                 }
                 dp[i] = min + 1;
            
             }
             out.println(dp[n]);
        }

out.close();
    }


  static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}