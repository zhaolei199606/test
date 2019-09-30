package main;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    public static int[] StirngToInt(String str[]){
        int []array = new int[str.length];
        for(int i=0;i<str.length;i++){
            array[i] = Integer.parseInt(str[i]);
        }
        return array;
    }
    public static void getSum(int array[],int m){
        int sum= 0;
        for(int i =0,j=2*m ; i<j; i++,j--){
            sum = sum + array[i]*array[j];
        }
        System.out.println(sum);
    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        String line1 = sc.nextLine();
        String line2 = sc.nextLine();
        String []str1 = line1.split(" ");
        String []str2 = line2.split(" ");
        int []lineArray1 = StirngToInt(str1);
        int []lineArray2 = StirngToInt(str2);
        int n = lineArray1[1];
        int m = lineArray1[2];
        Arrays.sort(lineArray2);
        getSum(lineArray2,m);

    }
}
