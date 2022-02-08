package com.learn.java.uh;

public class GCD {
    public static void main(String[] args) {
//        int[] arr= {12,2,10,17,24};
//        int[] arr= {3, 9, 6, 8, 3 };
        int[] arr= {9,6,9};
//        int[] arr ={3};
//        int[] arr= {12,15,24,36};
//        int[] arr ={21,7};
        System.out.println(solve(arr));
//        System.out.println(gcd(5,25));
    }
    public static int solve(int[] A) {
        int len =A.length;
        int[] prefixArr= new int[len];
        int[] suffixArr = new int[len];
        int ele1 = A[0], ele2 = A[len-1];
        prefixArr[0]=ele1;
        suffixArr[len-1]=ele2;
        for(int i=1;i<len;i++){
            if(A[i]>ele1)
                ele1 = gcd(ele1,A[i]%ele1);
            else
                ele1 = gcd(ele1%A[i],A[i]);
            prefixArr[i]=ele1;
            if(A[len-i-1]>ele2)
                ele2 = gcd(ele2,A[len-i-1]%ele2);
            else
                ele2 = gcd(ele2%A[len-i-1],A[len-i-1]);
            suffixArr[len-i-1]=ele2;
        }
        int idx1=0, idx2=len-1,pVal=prefixArr[0],sVal=suffixArr[len-1];
       while(idx1!=idx2){
            if(prefixArr[idx1]>=suffixArr[idx2]){
                if(prefixArr[idx1]<pVal)
                    pVal=prefixArr[idx1];
                idx1++;
            }
            else{
                if(suffixArr[idx2]<pVal)
                    pVal=suffixArr[idx2];
                idx2--;
            }
        }
       if(idx1==0 && prefixArr.length!=1)
           pVal=0;
       if(idx2==len-1 && suffixArr.length !=1)
           sVal=0;
        return gcd(pVal,sVal);
    }

    static int gcd(int a,int b){
        if(a==0)
            return b;
        return gcd(b%a,a);
    }
}
