import java.security.SecureRandom;

public class Grid {
    public static void main(String[] args) {
        //instance of SecureRandom (object)
        SecureRandom secureRandom = new SecureRandom();

        //initialize words
        String word1 = "crane";
        String word2 = "place";

        //initialize wordSearch array to rows x columns
        int rows = 7;
        int columns = 7;
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
    public static char[][] placeHorizontally(char[][] wordSearch, SecureRandom secureRandom, String word, int rows, int columns) {
        //create random ints
        int rowInt = secureRandom.nextInt(rows - 4);//between 0 and rows - 4
        int columnInt = secureRandom.nextInt(columns = 4);//between 0 and columns - 4
        //print for test purposes
        System.out.println(word);
        System.out.println("Row int: " + rowInt);
        System.out.println("Column int: " + columnInt);

        //place word horizontally
        //rows: stay the same, columns: increase
        int index = 0; //index in string
        for (int j = columnInt; j < columnInt + 5; j++) {
            wordSearch[rowInt][j] = word.charAt(index);
            index++;//increasing so we can go through word
        }//end for loop
        return wordSearch;
    }//end method placeHorizontally
}//end class

//To do:
// - make sure words don't overlap: if does NOT contain'-', don't put word there
//  (add and check again?) won't work if you're putting random letters there
//  maybe put user words in first and then change blank spaces to random letters
// - make different printing directions their own methods and randomize which
//   method is called for each word?