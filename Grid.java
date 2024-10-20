public class Grid {
    public static void main(String[] args) {
        int rows = 5;
        int columns = 5;
        //initialize wordSearch array to rows x columns
        char wordSearch[][] = new char[rows][columns];

        //populate array wordSearch[][]
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                wordSearch[row][column] = 'x';
            }//end inner for loop
        }//end outer for loop

        //test: will print in row 1, column 2 (counting from zero)
        //because of the way loops work, has to be this way
        //wordSearch[1][2] = '!';

        //print word1 horizontally
        String word1 = "crane";
        //rows, columns
        //wordSearch[0][0] = word1.charAt(0);
        //wordSearch[0][1] = word1.charAt(1);

        //loop to print crane horizontally in row 0
        for (int i = 0; i < 1; i++) { //rows 
            for (int j = 0; j < 5; j++) {//columns
                wordSearch[i][j] = word1.charAt(j);
            }
            
        }


        //Test: print wordSearch[][] grid
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                System.out.print(wordSearch[row][column] + " ");
            }//end inner for loop
            System.out.println();
        }//end outer for loop
        
    }
}
