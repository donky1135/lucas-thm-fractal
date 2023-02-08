package com.company;

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_BLACK = "\u001B[30m";
    int table[][];
    public static int kChooseN(int n, int k){
        return (int)(factorial(n,k)/(factorial(n-k,0)));
    }
    // n!/(k!(n-k)!)
    // 19! > 2^32 - 1
    //
    public static long factorial(int n, int k) {
        if (n == 0)
            return 1l;
        else {
            long fact = 1l;
            for (; n > k; n--)
                fact *= (long)n;
            return fact;
        }
    }

    public static long kChooseN3(int n, int k){
        if (n == 0 || k == 0 || (n == k))
            return 1l;

        long[] smaller = new long[n-k];

        for (int i = 1; i <= n-k; i++)
            smaller[i-1] = i;

        long fact = 1l;
        for (int i = k+1; i <= n; i++) {
            fact *= i;

            for (int j = n-k-1; j >= 0; j--) {

                if(smaller[j] == 1){
                    continue;
                }
                else {
                    if (fact % smaller[j] == 0) {
                        fact /= smaller[j];
                        smaller[j] = 1;
                    } else
                        continue;
                }
            }
        }
        return fact;
    }

    public static int kChooseN2(int n, int k){
        double sum1 = 0, sum2 = 0;
        for (int i = k+1; i <= n; i++)
            sum1 += Math.log(i);

        for (int i = 1; i <= n-k; i++)
            sum2 += Math.log(i);

        return (int)Math.round(Math.exp(sum1-sum2));
    }

    public static int miniFact(int n, int k){
        if (n == 0) {
            return 1;
        }
        int fact = 1;
        for (; n>k; n--) {
            fact *= (n%2);
        }
        return fact;
    }

    public static int sirpinski(int n, int k){
        int size = (int)Math.ceil((Math.log(n)/Math.log(2)));
        int mask = 1;
        mask <<= size;
        for (int i = 0; i <= size; i++) {
            if ((n & mask) >= (k & mask)){
                mask >>= 1;
            }
            else
                return 0;
        }
        return 1;
    }

    public static int bitRev(int n){
        int rev = 0;
        while(n>0){
            rev <<= 1;
            if ((n & 1)==1) {
                rev ^= 1;
            }
            n >>= 1;
        }
        return rev;
    }
    public static int kChooseNmod5(int n, int k, int[][] table){
        



        return 0;
    }
    public static void main(String[] args){
//        for (int i = 0; i < ; i++) {
//
//        }
        
        
        for(int i = 0; i <= 127; i++){
//            System.out.print(i + " ");
            String pad = "";
            for (int j = 0; j < 127-i; j++) {
                pad += " ";
            }
            System.out.print(pad);
            for(int j = 0; j <= i; j++){
                int sir =sirpinski(i,j);
//                int sir = kChooseN(i,j);
                System.out.print(((sir == 0)?(ANSI_BLACK + 0):(ANSI_WHITE + 1)) + " ");
//              System.out.print(kChooseN2(i,j) + " ");
//              System.out.print((Math.abs(kChooseN3(i,j) - kChooseN2(i,j)))/((double)kChooseN3(i,j)) + " ");
            }
            System.out.println();
        }
        System.out.println("-----------------------------------------");
        
        
        for (int i = 0; i <= 56; i++) {
            System.out.print(i + ": ");
            for (int j = 0; j <= i; j++) {
                System.out.print((kChooseN2(i,j) % 2) + " ");
            }
            System.out.println();
        }

    }
}
