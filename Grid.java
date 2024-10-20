public class Grid {
    public static void main(String[] args) {
        int rows = 5;
        int columns = 4;
        //initialize wordSearch array to rows x columns
        char wordSearch[][] = new char[rows][columns];

        //populate array wordSearch[][]
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                wordSearch[row][column] = 'x';
            }//end inner for loop
        }//end outer for loop

        //test: will print in row 1, column 2 (counting from zero)
        wordSearch[1][2] = '!';

        //Test: print wordSearch[][] grid
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                System.out.print(wordSearch[row][column] + " ");
            }//end inner for loop
            System.out.println();
        }//end outer for loop
        
    }
}
