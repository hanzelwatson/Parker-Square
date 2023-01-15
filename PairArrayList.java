import java.io.*;
import java.util.*;
/**
 * PairArrayList objects hold ArrayLists of SquarePair objects, and the save
 * the sum of the SquarePairs 
 * 
 * Maya Gusak
 * June, 2019
 */
public class PairArrayList
{
    ArrayList<SquarePair> arr = new ArrayList<SquarePair>();
    private int sum;
    /**
     * Constructor
     */
    public PairArrayList(int value){
        sum = value;
    }
    
    /**
     * Insert a SquarePair object
     */
    public void insertPair(SquarePair p){
        arr.add(p);
    }
    
    /**
     * Returns sum
     */
    public int getSum(){
        return sum;
    }
    
    /**
     * Returns the ArrayList's size
     */
    public int getSize(){
        return arr.size();
    }
    
    /**
     * Returns the SquarePair at a certain index
     */
    public SquarePair get(int index){
        return arr.get(index);
    }
}
