import java.net.CookieHandler;
import java.util.*;
import java.io.*;

    static FastScanner fs = null;
    static  ArrayList<Pair> moves = new ArrayList<>() ;
 
    public static void main(String[] args) {
     fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        int n = fs.nextInt();
        int a=1;
        int b=2;
        int c=3;
        toh(n,a,b,c);
        out.println(moves.size());
        for(int i=0;i<moves.size();i++){
            out.println(moves.get(i).x +" "+moves.get(i).y);
        }
        
        out.close();
    }
 
    public static void toh(int n,int a,int b,int c){
        if(n==1){
            moves.add(new Pair((a),(c)));
            return ;
        }
 
 
        toh(n-1 , a,c,b);
        moves.add(new Pair(a,c));
        toh(n-1,b,a,c);
 
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
