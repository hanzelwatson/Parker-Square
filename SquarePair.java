
/**
 * Objects of type SquarePair save two square numbers and their sum
 *
 * Maya Gusak
 * June, 2019
 */
public class SquarePair
{
    private int square1;
    private int square2;
    /**
     * Constructor
     */
    public SquarePair(int x, int y){
        square1 = x*x;
        square2 = y*y;
    }
    
    /**
     * Returns first square
     */
    public int getSquare1(){
        return square1;
    }
    
    /**
     * Returns second square
     */
    public int getSquare2(){
        return square2;
    }
    
    /**
     * Returns the SquarePair's sum
     */
    public int getSum(){
        return square1 + square2;
    }
    
    /**
     * Compares the sums of two SquarePairs
     */
    public boolean sameSum(SquarePair other){
        if(getSum() == other.getSum())
            return true;
        return false;
    }
    
    /**
     * toString() method of this class
     */
    public String toString(){
        return "1: " + Math.pow(square1, 0.5) + " 2: " + Math.pow(square2, 0.5);
    }
}
