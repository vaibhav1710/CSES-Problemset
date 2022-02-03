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
 
    public static void main(String[] args) {
     fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        char c[] = fs.next().toCharArray();
        int max=1;
        int omax = 1;
        char cur = c[0];
        for(int i=1;i<c.length;i++){
            if(c[i]==cur) max++;
            else{
                omax = Math.max(omax,max);
                max = 1;
                cur = c[i];
            }
        }
out.println(Math.max(omax,max));
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