package main;
import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static int[] StirngToInt(String str[]){
        int []array = new int[str.length];
        for(int i=0;i<str.length;i++){
            array[i] = Integer.parseInt(str[i]);
        }
        return array;
    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        int sum =0;
        while(sc.hasNext()){
            String line =sc.nextLine();
            String []lineArray = line.split(" ");
            //int intArray[] = StirngToInt(lineArray);
            //sum = sum + intArray[1]-intArray[0];
            System.out.println(lineArray[1]);
        }

    }
}
