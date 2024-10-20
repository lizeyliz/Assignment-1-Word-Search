import java.security.SecureRandom;

public class Grid {
    public static void main(String[] args) {
        //instance of SecureRandom (object)
        SecureRandom secureRandom = new SecureRandom();

        //initialize words
        String word1 = "crane";
        String word2 = "place";

        //initialize wordSearch array to rows x columns
        int rows = 25;
        int columns = 25;
        char wordSearch[][] = new char[rows][columns];
        //populate array wordSearch[][] with xs
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                wordSearch[row][column] = '-';
            }//end inner for loop
        }//end outer for loop

        //call method placeHorizontally
        placeHorizontally(wordSearch, secureRandom, word2);

        //print wordSearch[][] grid
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                System.out.print(wordSearch[row][column] + " ");
            }//end inner for loop
            System.out.println();
        }//end outer for loop
    }//end main method

    //place word horizontally in a random location (make sure it fits page)
    public static char[][] placeHorizontally(char[][] wordSearch, SecureRandom secureRandom, String word) {
        //create random ints
        int rowInt = secureRandom.nextInt(16);//between 0-15
        int columnInt = secureRandom.nextInt(16);//between 0-15
        //print for test purposes
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