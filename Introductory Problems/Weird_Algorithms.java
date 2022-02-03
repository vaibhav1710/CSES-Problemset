import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.math.*; 
import static java.lang.Long.bitCount;
import static java.lang.Long.parseLong;

 class Cses{ 
    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n  = Long.parseLong(br.readLine()); 
        System.out.print(n+" "); 
        while(n!=1){
            if(n%2==0){
                n /= 2;
                System.out.print(n+" ");
            }else if(n%2!=0){
                n = n*3 + 1;
                System.out.print(n+" ");
            }else{
                break;
            }
        }
 }   
}
 