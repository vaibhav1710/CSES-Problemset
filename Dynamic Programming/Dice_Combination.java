import java.io.*;
//import java.util.PriorityQueue;
import java.util.*;
 
 
public class Cses {
    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }
 
        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt()
        {
            return Integer.parseInt(next());
        }
 
        long nextLong()
        {
            return Long.parseLong(next());
        }
 
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
 
        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }
    static int n;
    static int m;
    static boolean visited[];
    static ArrayList<ArrayList<Integer>> arr;
 
    public static void main(String[]args)
    {
        FastReader sc=new FastReader();
        int n = sc.nextInt();
        long dp[] = new long[n+1];
        if(n<=6){
            dp[0] = 0;
            dp[1] = 1;
            for(int i=2;i<=n;i++){
                int j=1;
                while(i-j>0 && j<=n){
                    dp[i] += dp[i-j];
                    j++;
                }
                dp[i] += 1;
            }
            System.out.println(dp[n]);
        }else {
                 dp[0]=0;
                 dp[1] = 1;
                 dp[2] = 2;
                 dp[3] = 4;
                 dp[4] = 8;
                 dp[5] = 16;
                 dp[6] = 32;
            for (int i = 7; i <= n; i++) {
                dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3] + dp[i - 4] + dp[i - 5] + dp[i - 6]) % 1000000007;
            }
            System.out.println(dp[n]);
        }
    }
 
 
 
 
 
    }