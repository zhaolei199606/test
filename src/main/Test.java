package main;

import java.util.Scanner;

public class Test {
    /**
     * String数组转成int类型数组
     * @return
     */
    public static int[] StirngToInt(String str[]){
        int []array = new int[str.length];
        for(int i=0;i<str.length;i++){
            array[i] = Integer.parseInt(str[i]);
        }
        return array;
    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);

    }
}
