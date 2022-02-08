

import java.net.CookieHandler;
import java.util.*;
import java.io.*;
//import static com.sun.tools.javac.jvm.ByteCodes.swap;
// ?)(?
public class Cses {

    static FastScanner fs = null;
    static  ArrayList<Pair> moves = new ArrayList<>() ;
    static boolean visited[][];
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
                 //i = tmp;
             }
             out.println(dp[n]);
        }

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

    // JAVA program to compute factorial
// of big numbers
    // This function finds factorial of
    // large numbers and prints them
    static void factorial(int n)
    {
        int res[] = new int[500];

        // Initialize result
        res[0] = 1;
        int res_size = 1;

        // Apply simple factorial formula
        // n! = 1 * 2 * 3 * 4...*n
        for (int x = 2; x <= n; x++)
            res_size = multiply(x, res, res_size);

        System.out.println("Factorial of given number is ");
        for (int i = res_size - 1; i >= 0; i--)
            System.out.print(res[i]);
    }

    // This function multiplies x with the number
    // represented by res[]. res_size is size of res[] or
    // number of digits in the number represented by res[].
    // This function uses simple school mathematics for
    // multiplication. This function may value of res_size
    // and returns the new value of res_size
    static int multiply(int x, int res[], int res_size)
    {
        int carry = 0; // Initialize carry

        // One by one multiply n with individual
        // digits of res[]
        for (int i = 0; i < res_size; i++)
        {
            int prod = res[i] * x + carry;
            res[i] = prod % 10; // Store last digit of
            // 'prod' in res[]
            carry = prod/10; // Put rest in carry
        }

        // Put carry in res and increase result size
        while (carry!=0)
        {
            res[res_size] = carry % 10;
            carry = carry / 10;
            res_size++;
        }
        return res_size;
    }


    static int m = 998244353;
    static   long fact[] = new long[200001];
    public static void fact(){
        fact[1] = 1;
        fact[0] = 1;

        for(int i=2;i<=200000;i++){
            fact[i] = (fact[i-1]*i)%m;
        }
    }




    static long lower(long array[], long key,int i,int k)
    {
        long ans=-1;
        while(i<=k){
            int mid = (i+k)/2;
            if(array[mid]>=key){
                ans = mid;
                k = mid-1;
            }else{
                i = mid+1;
            }
        }
        return ans;
    }

    static long upper(long array[], long key ,int i , int k){

        long ans = -1;
        while(i<=k){
            int mid = (i+k)/2;
            if(array[mid]<=key){
                ans = array[mid];
                i = mid+1;
            }else{
                k = mid-1;
            }
        }


        return ans;
    }



    public static boolean contains(String s,String s1){
        boolean found = false;
        for(int i=0;i<s.length();i++){
            for(int j = i+1;j<s.length();j++){
                String ss = s.substring(i,j);
                if(ss.equals(s1)){
                    found = true;
                }
            }
        }



        return found;
    }



    public static class String1 implements Comparable<String1>{
        String str;
        int id;
        String1(String str , int id){
            this.str = str;
            this.id = id;
        }
        public  int compareTo(String1 o){
            int i=0;
            while(i<str.length() && str.charAt(i)==o.str.charAt(i)){
                i++;
            }
            if(i<str.length()){
                if(i%2==1){
                    return o.str.compareTo(str);   // descending order
                }else{
                    return str.compareTo(o.str);  // ascending order
                }
            }
            return str.compareTo(o.str);
        }
    }



    static void sort(int[] a) {
        ArrayList<Integer> l=new ArrayList<>();
        for (int i:a) l.add(i);
        Collections.sort(l);
        for (int i=0; i<a.length; i++) a[i]=l.get(i);
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
    // ------------------------------------------swap----------------------------------------------------------------------

    static void swap(int arr[],int i,int j)
    {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }


    //-------------------------------------------seiveOfEratosthenes----------------------------------------------------


    static boolean prime[];
    static void sieveOfEratosthenes(int n)
    {
        // Create a boolean array
        // "prime[0..n]" and
        // initialize all entries
        // it as true. A value in
        // prime[i] will finally be
        // false if i is Not a
        // prime, else true.
        prime= new boolean[n + 1];
        for (int i = 0; i <= n; i++)
            prime[i] = true;

        for (int p = 2; p * p <= n; p++)
        {
            // If prime[p] is not changed, then it is a
            // prime
            if (prime[p] == true)
            {
                // Update all multiples of p
                for (int i = p * p; i <= n; i += p)
                    prime[i] = false;
            }
        }

        // Print all prime numbers
//        for (int i = 2; i <= n; i++)
//        {
//            if (prime[i] == true)
//                System.out.print(i + " ");
//        }
    }



    //------------------------------------------- power------------------------------------------------------------------



    static long power(long x, long y, long p)
    {
        long res = 1; // Initialize result

        x = x % p; // Update x if it is more than or
        // equal to p

        if (x == 0)
            return 0; // In case x is divisible by p;

        while (y > 0)
        {

            // If y is odd, multiply x with result
            if ((y & 1) != 0)
                res = (res * x) % p;

            // y must be even now
            y = y >> 1; // y = y/2
            x = (x * x) % p;
        }
        return res;
    }




    //--------------------------------------lower bound----------------------------------------------------------


    static int LowerBound(int a[], int x)
    { // x is the target value or key
        int l=-1,r=a.length;
        while(l+1<r) {
            int m=(l+r)>>>1;
            if(a[m]>=x) r=m;
            else l=m;
        }
        return r;
    }

    //--------------------------------------------------------------------------------------------------------------
    public static int log2(int x) {
        return (int) (Math.log(x) / Math.log(2));
    }

    //---------------------------------------EXTENDED EUCLID ALGO--------------------------------------------------------

    public static Pair Euclid(int a,int b){

        if(b==0){
            return new Pair(1,0);  // answer of x and y
        }

        Pair dash = Euclid(b,a%b);

        return new Pair(dash.y , dash.x - (a/b)*dash.y);


    }
//--------------------------------GCD------------------GCD-----------GCD--------------------------------------------

    public static long gcd(long a,long b){
        if(b==0){
            return a;
        }

        return gcd(b,a%b);
    }
    public static void BFS(ArrayList<Integer>[] graph) {
    }

    static long C(int n, int k) {
        long res = 1;
        for (int i = n - k + 1; i <= n; ++i)
            res *= i;
        for (int i = 2; i <= k; ++i)
            res /= i;
        return res;
    }

}
// Fenwick / BinaryIndexed  Tree  USE IT - FenwickTree ft1=new FenwickTree(n);