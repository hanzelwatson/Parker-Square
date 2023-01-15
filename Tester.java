import java.io.*;
import java.util.*;
/**
 * Just a tester class that helped me test stuff in the beginning
 * Nothing interesting to see here
 * 
 *
 * Maya Gusak
 * June, 2019
 */
public class Tester
{
    static ArrayList<Integer> list = new ArrayList<Integer>();
    static ArrayList<Integer> parallel = new ArrayList<Integer>();
    public static void square(){
        int cap = 300;
        int value;
        list.add(2);
        list.add(5);
        parallel.add(1);
        parallel.add(1);
        int i = 0;
        for(int x=2; x<=cap; x++){
            for(int y=2; y<=cap-i; y++){
                value = x*x + (y+i)*(y+i);
                insert(value);
                //System.out.println(x + "^2 + " + (y+i) + "^2 = " + value);
                if(value == 9425)
                    System.out.println(x + "^2 + " + (y+i) + "^2 = " + value);
                
            }
            i++;
        }
        printArray();
    }

    public static void insert(int value){
        int position = list.size()-1;
        for(int i=0; i<list.size(); i++){
            if(value == list.get(position-i)){
                int old = parallel.get(position-i);
                parallel.set(position-i, old+1);
                break;
            }else if(value > list.get(position-i)){
                list.add(position-i+1, value);
                parallel.add(position-i+1, 1);
                break;
            }
        }
    }
    
    public static void printArray(){
        for(int i=0; i<list.size(); i++){
            if(parallel.get(i) > 5){
             System.out.println("The number " + list.get(i) + " repeated " + parallel.get(i) + " times");  
            }
        }
    }
    
    public static void findMatch(){
        int[] arr = new int[8];
        arr[0] = 4;
        arr[1] = 97;
        arr[2] = 20;
        arr[3] = 95;
        arr[4] = 55;
        arr[5] = 80;
        arr[6] = 64;
        arr[7] = 73;
        int position = 1;
        for(int i=0; i<arr.length-1; i++){
            for(int g=position; g<arr.length; g++){
                if(arr[i]*arr[i] + 1681 == arr[g]*arr[g] + 8464){
                    System.out.println("i: " + i + ", g: " + g);
                }
                if(arr[i]*arr[i] + 8464 == arr[g]*arr[g] + 1681){
                    System.out.println("i: " + i + ", g: " + g);
                }
            }
        }
    }
}
