import java.security.SecureRandom;

public class Grid {
    public static void main(String[] args) {
        //instance of SecureRandom (object)
        SecureRandom secureRandom = new SecureRandom();
        //initialize ints
        int rows = 25;
        int columns = 25;
        int rowInt = secureRandom.nextInt(16);//between 0-15
        int columnInt = secureRandom.nextInt(16);//between 0-15
        //initialize words
        String word1 = "crane";

        //initialize wordSearch array to rows x columns
        char wordSearch[][] = new char[rows][columns];
        //populate array wordSearch[][] with xs
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                wordSearch[row][column] = 'x';
            }//end inner for loop
        }//end outer for loop

        //print for test purposes
        System.out.println("Row int: " + rowInt);
        System.out.println("Column int: " + columnInt);

        //print word1 horizontally in a random location
        //rows: stay the same, columns: increase
        int index = 0; //index in string
        for (int j = columnInt; j < columnInt + 5; j++) {
            wordSearch[rowInt][j] = word1.charAt(index);
            index++;//increasing so we can go through word
        }

        //print wordSearch[][] grid
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                System.out.print(wordSearch[row][column] + " ");
            }//end inner for loop
            System.out.println();
        }//end outer for loop
    }
}
