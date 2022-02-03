import java.net.CookieHandler;
import java.util.*;
import java.io.*;

public class Cses {
 
    static FastScanner fs = null;
    static  ArrayList<Pair> moves = new ArrayList<>() ;

    public static void main(String[] args) {
     fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
       char grid[][] = new char[8][8];
       for(int i=0;i<8;i++){
           grid[i] = fs.next().toCharArray();
       }
       boolean[][] vis = new boolean[8][8];
       solveq(0,grid,vis);
        out.println(count);
        out.close();
    }
static int count=0;
    public static void solveq(int row,char [][] grid,boolean[][] vis){
        if(row==grid.length){/*
            for(int i=0;i<grid.length;i++){
                for(int j=0;j<grid.length;j++){
                    System.out.print(grid[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println();*/
            count++;
            return;
        }

        for(int i=0;i<grid.length;i++){

           if(!vis[row][i]) {
               if (isSafe(grid, row, i, vis)) {
                   vis[row][i] = true;
                   //  grid[row][i] = 'Q';
                   solveq(row + 1, grid, vis);
                   vis[row][i] = false;
                   // grid[row][i] ='.';
               } else {
                   continue;
               }
           }
        }

        return;

    }



    public static boolean isSafe(char [][] grid,int r,int c,boolean vis[][]){

        if(grid[r][c]=='*'){
            return false;
        }

        //row
        for(int i=0;i<grid.length;i++){
            if( i!=c && vis[r][i]){
                return false;
            }
        }


        //col

        for(int i=0;i<grid.length;i++){
            if( i!=r && vis[i][c]){
                return false;
            }
        }

        //left daigonal

        int i=r;
        int j=c;

        while(i>=0 && j>=0){
            if(vis[i][j]){
                return false;
            }else{
                i--;
                j--;
            }
        }

        i=r;
        j=c;

        while(i<grid.length && j<grid[0].length){
            if(vis[i][j]){
                return false;
            }else{
                i++;
                j++;
            }
        }


        // right daigonal

         i=r;
         j=c;

        while(i>=0 && j<grid[0].length){
            if(vis[i][j]){
                return false;
            }else{
                i--;
                j++;
            }
        }

        i=r;
        j=c;

        while(i<grid.length && j>=0){
            if(vis[i][j]){
                return false;
            }else{
                i++;
                j--;
            }
        }

        return true;
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
