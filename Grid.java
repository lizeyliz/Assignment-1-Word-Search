import java.security.SecureRandom;

public class Grid {
    public static void main(String[] args) {
        //instance of SecureRandom (object)
        SecureRandom secureRandom = new SecureRandom();

        //initialize words
        String word1 = "crane";
        String word2 = "place";
        String word3 = "times";
        String word4 = "happy";

        //initialize wordSearch array to rows x columns
        int rows = 10;
        int columns = 10;
        char wordSearch[][] = new char[rows][columns];
        //populate array wordSearch[][] with xs
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                wordSearch[row][column] = '-';
            }//end inner for loop
        }//end outer for loop

        //call method placeHorizontally for word1
        placeHorizontally(wordSearch, secureRandom, word1, rows, columns);
        //call method placeHorizontally for word2
        placeHorizontally(wordSearch, secureRandom, word2, rows, columns);
        //call method placeVertically for word3
        //placeVertically(wordSearch, secureRandom, word3, rows, columns);
        //call place diagonally for word4
        //placeDiagonally(wordSearch, secureRandom, word4, rows, columns);

        //print wordSearch[][] grid
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                System.out.print(wordSearch[row][column] + " ");
            }//end inner for loop
            System.out.println();
        }//end outer for loop
    }//end main method

    //place word horizontally in a random location
    //only putting rows and columns as parameters for test purposes
    //(so i can change grid size easily)
    public static char[][] placeHorizontally(char[][] wordSearch, SecureRandom secureRandom, String word, int rows, int columns) {
        //create random ints for rows and columns
        int rowInt = secureRandom.nextInt(rows);
        int columnInt = secureRandom.nextInt(columns - word.length() + 1);

        //test printing
        System.out.println(word);
        System.out.println("Row int initial: " + rowInt);
        System.out.println("Column intitial: " + columnInt);

        //place word horizontally
        int index = 0; //index in string
        for (int j = columnInt; j < columnInt + word.length(); j++) {
            //if spot is blank, put char there
            if(wordSearch[rowInt][j] == '-') {
                wordSearch[rowInt][j] = word.charAt(index);
                index++;//increasing so we can go through word
            } else { //if spot contains char erase all previous letter placements
                //replace previous word placement with '-'s
                for (int i = columnInt; i < j; i++) {
                    wordSearch[rowInt][i] = '-';
                }//end for loop

                //move down a row
                rowInt++;
                System.out.println("moved down a row"); //test purposes
                j = columnInt - 1; //will go back to original value for column int when starting the loop again
                index = 0; //start from beginning of word

                //catch exception here (try/catch) if can't move down a row, move up a row
                
                //go back to beginning of for loop
            }//end if/else
        }//end for loop
        return wordSearch;
    }//end method placeHorizontally

    //place a word vertically in a random place
    //works, but need to add code so it doesn't overwrite other words
    public static char[][] placeVertically (char[][] wordSearch, SecureRandom secureRandom, String word, int rows, int columns) {
        //create random ints
        int rowInt = secureRandom.nextInt(rows - word.length() + 1);
        int columnInt = secureRandom.nextInt(columns);
        //print for test purposes
        System.out.println(word);
        System.out.println("Row int: " + rowInt);
        System.out.println("Column int: " + columnInt);
        //row increase, column stays the same
        int index = 0;
        for (int row = rowInt; row < rowInt + word.length(); row++) {
            wordSearch[row][columnInt] = word.charAt(index);
            index++;
        }//end for loop
        return wordSearch;
    }//end placeVertically method

    //place diagonally (one direction: could create if/else with random #s
    //for different directions)
    //still working on: currently generates in specific spot, will add random generation
    public static char[][] placeDiagonally (char[][] wordSearch, SecureRandom secureRandom, String word, int rows, int columns) {
        /*wordSearch[0][0] = word.charAt(0);
        wordSearch[1][1] = word.charAt(1);
        wordSearch[2][2] = word.charAt(2);*/
        int x = 0;
        for (int index = 0; index < 5; index++) {
            wordSearch[x][x] = word.charAt(index);
            x++;
        }
        return wordSearch;
    }//end placeDiagonally method
}//end class

//To do:
// - make sure words don't overlap: if does NOT contain'-', don't put word there
//  (add and check again?) won't work if you're putting random letters there
//  maybe put user words in first and then change blank spaces to random letters
// - make different printing directions their own methods and randomize which
//   method is called for each word?
// - test for exceptions
// - create separate method for creating random numbers for row and column
//   (so that you don't have to repeat code in each method)
// - exception catching for moving rows

//Things I learned:
// - when you are happy with work in test branch, save to main branch (then the bad test code you write later won't overwrite it)