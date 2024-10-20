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
        int rows = 20;
        int columns = 20;
        char wordSearch[][] = new char[rows][columns];
        //populate array wordSearch[][] with xs
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                wordSearch[row][column] = '-';
            }//end inner for loop
        }//end outer for loop

        //call method placeHorizontally for word1
        placeHorizontally(wordSearch, secureRandom, word1, rows, columns, 0, 4);
        //call method placeHorizontally for word2
        placeHorizontally(wordSearch, secureRandom, word2, rows, columns, 0, 1);
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

    //place word horizontally in a random location (make sure it fits page)
    //only putting rows and columns as parameters for test purposes
    //(so i can change grid size easily)
    //adding row and column int for test purposes (will remove later)
    public static char[][] placeHorizontally(char[][] wordSearch, SecureRandom secureRandom, String word, int rows, int columns, int rowInt, int columnInt) {
        //create random ints
        //int rowInt = secureRandom.nextInt(rows);
        //int columnInt = secureRandom.nextInt(columns - word.length() + 1);
        //print for test purposes
        System.out.println(word);
        System.out.println("Row int: " + rowInt);
        System.out.println("Column int: " + columnInt);

        //middle var
        int m = columnInt + word.length();

        //place word horizontally
        //rows: stay the same, columns: increase
        int index = 0; //index in string
        for (int j = columnInt; j < m; j++) {
            //exception: words shouldn't overwrite eachother
            //need to overwrite word already printed with '-' if moving down a row
            //add test case for exception catching (overlap in middle of word)
            System.out.println("J: " + j);
            System.out.println("index: " + index);
            if(wordSearch[rowInt][j] == '-') {
                wordSearch[rowInt][j] = word.charAt(index);
                index++;//increasing so we can go through word
            } else {
                //replace previous word placement with '-'s (overwrote letters of previous word, fixed by adding minus 1 to middle statement
                // should be minus a variable (number of overlaps)?) mb easier if you catch exceptions in main
                for (int i = columnInt; i < columnInt + word.length() - 2; i++) {
                    wordSearch[rowInt][i] = '-';
                }
                //move down a row
                rowInt++;
                System.out.println("moved down a row"); //test purposes
                j = -1;
                //set word index back to zero to start from beginning
                index = 0;
                m = columnInt + word.length() - 1;
                //go back to beginning of for loop

                //catch exception here (try/catch) if can't move down a row, move up a row
            }
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