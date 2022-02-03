import java.net.CookieHandler;
import java.util.*;
import java.io.*;

public class Cses {
    static class Node
    {
        int data;
        Node left, right;
        Node(int data)
        {
            this.data=data;
            left=right=null;
        }
    };
    static FastScanner fs = null;
    static  ArrayList<Long> graph[] ;
    // static  int count=0;
    public static void main(String[] args) {
 
 
        fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        //sieveOfEratosthenes(1000000);
       /* int t = fs.nextInt();
        while (t-- > 0) {*/
            long n = fs.nextLong();
            int a[]= new int[(int)n-1];
            long sum=0l;
            for(int i=0;i<n-1;i++){
                a[i] = fs.nextInt();
                sum += a[i];
            }
 
           long y = (n*(n+1))/2;
 
            out.println(y-sum);
        int w=1;
        out.close();
    }
    static class Pair implements Comparable<Pair> {
        int x;
        int y;
 
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
 
        }
 
        public int compareTo(Pair o) {
            if (this.x != o.x) {
                return this.x - o.x;
            } else {
                return this.y - o.y;
            }
        }
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
