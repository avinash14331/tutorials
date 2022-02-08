package com.learn.java;

public class Main1 {

    public static void main(String[] args) {
	// write your code here
        Float f= new Float("3.0");
        int i= f.intValue();
        byte b=f.byteValue();
        Double d= f.doubleValue();
        System.out.println(i + b+ d);
//        int i=0x000F;
//        int j=0x222;
//        System.out.println(i & j);
//        System.out.println(j);
        int arr[] = {0, 0, 0, 0, 0, 0 , 0, 1, 1, 1,1 ,1, 1 };
        int result = firstIndexOfOne(arr,0,arr.length-1);
        System.out.println(result);
    }

    public static int firstIndexOfOne(int[] arr, int low, int high){
        try{

            while (low <= high) {
                int mid = (low + high) / 2;

                if (arr[mid] == 1 && (mid == 0 || arr[mid - 1]
                        == 0))
                    return mid;

                else if (arr[mid] == 1)
                    high = mid - 1;

                else
                    low = mid + 1;
            }

            return -1;

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return 0;
    }
}

// 0, 0, 0, 0, 0, 0 , 0, 1, 1, 1,1 ,1, 1
//public int firstIndexOfOne(int[] arr);
//        Dipayan Bhowmick4:23 PM
//        arr.length , find out the length.

