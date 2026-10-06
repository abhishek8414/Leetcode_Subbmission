class Solution {
    public int fib(int n) {
        if(n==1|| n==0){
            return n;
        }

        int z=0,f=1;

        for ( int i=2;i<=n;i++){

        
          int next=z+f;
           z=f;
           f=next;
        }
        return f;



        /* int fib1=fib(n-1);
        int fib2=fib(n-2);

        int ans=(fib1 + fib2);

        return ans; */


        
    }
}