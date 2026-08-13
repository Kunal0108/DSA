class Solution {
    public boolean isPowerOfTwo(int n) {
        // double x = getUnkownValue();
        // double evenVariable = 2 * x;
        // if(n == 1) {
        //     return true;
        // }
        // if(n % 2 == 0) {
        //     if(n == Math.pow(2, evenVariable)){
        //     return true;
        // } 
        // return true;
        // } else {
        //     return false;
        // }

        if (n<=0) {
            return false;
        }

        while (n%2==0) {
            n = n/2;
        }
        return n == 1;
        
    }
}