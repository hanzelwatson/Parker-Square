import java.io.*;
import java.util.*;
/**
 * This is just a neat little SIDE PROJECT. Main project is "Game of Set!"
 * SquareSearch tries to find possibilities for a magic square made of perfect squares.
 * This is an open math problem that I thought would be fun to tackle.
 * I think this is cool because I programmed the computer to find an answer
 * and I had no idea what to expect. Anyway, I did a little math with what qualities
 * a theoretical "Parker Square" should have and ran tests based on that.
 * The program is incomplete; it only looks for three pairs of numbers that could be
 * in a "Parker Square", and I tested all its outputs (myCap = 200) by hand (no luck).
 * The math is tricky to explain unless it's in person. Create a SquareSearch object and set
 * the cap appropriately to however long you want your computer to run, as there's quite a lot of
 * computation involved. Oh, and if you find a solution, creds go to me! :)
 *
 * Maya Gusak
 * June, 2019
 */
public class SquareSearch
{
    ArrayList<SquarePair> list = new ArrayList<SquarePair>();
    ArrayList<Integer> values = new ArrayList<Integer>();
    ArrayList<PairArrayList> arrarr = new ArrayList<PairArrayList>();
    int myCap;
    /**
     * Constructor
     */
    public SquareSearch(int cap){
        myCap = cap;
    }

    /**
     * Searches up to myCap and organizes pairs of squares into arrarr
     */
    public void search(){
        int i=1;
        arrarr.add(new PairArrayList(2));
        for(int x=1; x<=myCap; x++){
            for(int y=1; y<=myCap-i; y++){
                SquarePair pair = new SquarePair(x, y+i);
                //insert(value);
                //System.out.println(x + "^2 + " + (y+i) + "^2 = " + value);
                //  if(pair.getSum() == 50690)
                //  System.out.println(x + "^2 + " + (y+i) + "^2 = " + pair.getSum());
                //if(pair.getSum() == 64532)
                // System.out.println(x + "^2 + " + (y+i) + "^2 = " + pair.getSum());
                int pairSum = pair.getSum();
                Boolean foundOtherPairs = false;
                for(int g=0; g<arrarr.size(); g++){
                    if(pairSum == arrarr.get(g).getSum()){
                        arrarr.get(g).insertPair(pair);
                        foundOtherPairs = true;
                        break;
                    }
                }
                if(!foundOtherPairs){
                    arrarr.add(new PairArrayList(pair.getSum()));
                    arrarr.get(arrarr.size()-1).insertPair(pair);
                }

            }
            i++;
            System.out.println("x = " + x);
        }

        for(int j=0; j<arrarr.size(); j++){
            if(arrarr.get(j).getSize() < 4){
                arrarr.remove(j);
                j--;
            } else{
                placeEdges(arrarr.get(j));   
            }
        }
    }

    /**
     * Places the four edges
     */
    private void placeEdges(PairArrayList arr){
        //SquarePair verticalPair;
        //SquarePair horizontalPair;
        int index = 1;
        for(int first=0; first<arr.getSize()-1; first++){
            for(int second=index; second<arr.getSize(); second++){
                placeCorners(arr, first, second);
                //System.out.println("Placing Edges: " + arr.get(first).toString() + "; " + arr.get(second).toString());
                index++;
            }
        }
    }

    /**
     * Places two diagonal corners
     */
    private void placeCorners(PairArrayList arr, int first, int second){
        int position = 1;
        SquarePair verticalPair = arr.get(first);
        SquarePair horizontalPair= arr.get(second);
        SquarePair possibleDiagonal;
        boolean reversed;
        for(int i=0; i<arr.getSize(); i++){
            if(i != first && i != second){
                possibleDiagonal = arr.get(i);
                if(verticalPair.getSquare1()+possibleDiagonal.getSquare1() == horizontalPair.getSquare2()+possibleDiagonal.getSquare2()){
                    if(horizontalPair.getSquare1()+possibleDiagonal.getSquare1() == verticalPair.getSquare2()+possibleDiagonal.getSquare2()){
                        System.out.println("This corner works!");
                        System.out.println("Vertically: "+ verticalPair.toString());
                        System.out.println("Horizontally: "+ horizontalPair.toString());
                        System.out.println("Diagonally: "+ possibleDiagonal.toString());
                        reversed = false;
                        checkOtherCorner(arr, first, second, i, reversed);
                    }
                }
                if(verticalPair.getSquare1()+possibleDiagonal.getSquare2() == horizontalPair.getSquare2()+possibleDiagonal.getSquare1()){
                    if(horizontalPair.getSquare1()+possibleDiagonal.getSquare2() == verticalPair.getSquare2()+possibleDiagonal.getSquare1()){
                        System.out.println("This corner works!");
                        System.out.println("Vertically: "+ verticalPair.toString());
                        System.out.println("Horizontally: "+ horizontalPair.toString());
                        System.out.println("Diagonally: "+ possibleDiagonal.toString());
                        reversed = true;
                        checkOtherCorner(arr, first, second, i, reversed);
                    }
                }
            }
        }
    }

    /**
     * Unfinished method for creating another corner
     */
    private void checkOtherCorner(PairArrayList arr, int ver, int hor, int diag, boolean reversed){
         SquarePair verticalPair = arr.get(ver);
        SquarePair horizontalPair= arr.get(hor);
         SquarePair diagonalPair = arr.get(diag);
        for(int i=0; i<arr.getSize(); i++){
            if(i != ver && i != hor && i != diag){
                
            }
        }
    }
}
