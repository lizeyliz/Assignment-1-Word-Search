import java.security.SecureRandom;
import java.util.Scanner;

public class WordSearch {
    public static void main(String[] args) {
        //initialize section
        SecureRandom secureRandom = new SecureRandom();
        int userInt = 0;
        Scanner scan = new Scanner(System.in);
        
        String[] words = new String[8]; //array to hold words (may remove)
        WordSearchGrid grid = new WordSearchGrid(20,20, words);
        char wordSearch[][] = new char[grid.getRows()][grid.getColumns()]; //initialize wordSearch array to rows x columns
        
        //loop user menu
        do {  
            userMenu(userInt, wordSearch, secureRandom, grid, scan);
            //get user input
            userInt = scan.nextInt();
        } while (userInt != 4);
        System.out.println("Goodbye!");
    }//end main method

    //place word horizontally in a random location
    public static char[][] placeHorizontally(char[][] wordSearch, SecureRandom secureRandom, String word,
    WordSearchGrid grid) { //putting rows and columns as a parameter so size can easily be changed
        //create random ints for placement
        int rowInt = secureRandom.nextInt(grid.getRows());
        int columnInt = secureRandom.nextInt(grid.getColumns() - word.length() + 1);

        //place word horizontally
        int index = 0; //index in string
        for (int j = columnInt; j < columnInt + word.length(); j++) {
            //if spot is blank, put char there
            if(wordSearch[rowInt][j] == '-') {
                wordSearch[rowInt][j] = word.charAt(index);
                index++;//increasing so we can go through word
            } else {//if spot contains char erase all previous letter placements
                //replace previous char placements with '-'
                for (int i = columnInt; i < j; i++) {
                    wordSearch[rowInt][i] = '-';
                }//end for loop

                //generate word in new location
                rowInt = secureRandom.nextInt(grid.getRows());
                columnInt = secureRandom.nextInt(grid.getColumns() - word.length() + 1); 
                
                j = columnInt - 1; //go back to new value for column int when starting the loop again
                index = 0; //will start from beginning of word        
            }//end if/else
        }//end for loop
        return wordSearch;
    }//end method placeHorizontally

    //place a word vertically in a random place
    public static char[][] placeVertically (char[][] wordSearch, SecureRandom secureRandom, String word, 
    WordSearchGrid grid) {
        //initialize
        int rowInt = secureRandom.nextInt(grid.getRows() - word.length() + 1);
        int columnInt = secureRandom.nextInt(grid.getColumns());
        int index = 0;
        
        for (int row = rowInt; row < rowInt + word.length(); row++) {
            //if spot is blank, put char there
            if(wordSearch[row][columnInt] == '-') {
                wordSearch[row][columnInt] = word.charAt(index);
                index++;//increasing so we can go through word
            } else {//if spot contains char erase all previous letter placements
                //replace previous word placement with '-'s
                for (int i = rowInt; i < row; i++) {
                    wordSearch[i][columnInt] = '-';
                }//end for loop

                //generate word in new location
                columnInt = secureRandom.nextInt(grid.getColumns());
                rowInt = secureRandom.nextInt(grid.getRows() - word.length() + 1); 
                
                row = rowInt - 1; //will go back to new value for row int when starting the loop again
                index = 0; //will start from beginning of word        
            }//end if/else
        }//end for loop
        return wordSearch;
    }//end placeVertically method

    //place a word diagonally in a random location
    public static char[][] placeDiagonally (char[][] wordSearch, SecureRandom secureRandom, String word, 
    WordSearchGrid grid) {
        //intitialize
        int rowInt = secureRandom.nextInt(grid.getRows() - word.length() + 1);
        int columnInt = secureRandom.nextInt(grid.getColumns() - word.length() + 1);

        //generate without overlaps
        for (int index = 0; index < word.length(); index++) { //loop through word characters
            //if blank, place char at index there
            if(wordSearch[rowInt + index][columnInt + index] == '-'){
                wordSearch[rowInt + index][columnInt + index] = word.charAt(index);
            } else {//if not blank
                for(int i = 0; i < index; i++){
                    //replace previous char placements with '-'
                    wordSearch[rowInt + i][columnInt + i] = '-';
                }//end for loop
                //place in new location
                rowInt = secureRandom.nextInt(grid.getRows() - word.length() + 1);
                columnInt = secureRandom.nextInt(grid.getColumns() - word.length() + 1);

                index = -1;//so loop will start over from beginning
            }//end if/else
        }//end for loop
        return wordSearch;
    }//end placeDiagonally method

    //adds random chars to blank spots in wordsearch
    public static char[][] addRandomChars (char[][] wordSearch, SecureRandom secureRandom,
    WordSearchGrid grid) {
        //loop through wordSearch
        for (int row = 0; row < grid.getRows(); row++) {
            for (int column = 0; column < grid.getColumns(); column++) {
                if(wordSearch[row][column] == '-') { //if char = '-', replace with random nums
                    //fills word search with chars a-z
                    wordSearch[row][column] = (char)(secureRandom.nextInt(26) + 97); //a-z ASCII values are 97-122
                } //end if
            }//end inner for loop
        }//end outer for loop
        return wordSearch;
    }//end method addRandomChars
    
    //print wordSearch
    public static void printWordSearch(char[][] wordSearch, WordSearchGrid grid) {
        //exception if user hasn't created a wordsearch yet
        for (String i : grid.getWords()) {
            if(i == null) {
                System.out.println("Please create a wordsearch to view.");
                return;
            }
        }
        //loop through wordsearch and print
        for (int row = 0; row < grid.getRows(); row++) {
            for (int column = 0; column < grid.getColumns(); column++) {
                System.out.print(wordSearch[row][column] + " ");
            }//end inner for loop
            System.out.println();
        }//end outer for loop
        //print words to find
        System.out.println("Find:");
        for (int i = 0; i < 8; i++) {//loop through words array
            System.out.println(grid.getWords()[i]);
        }//end for loop
    }//end printWordSearch method

    //create a wordsearch
    public static char[][] createWordSearch(char[][] wordSearch, Scanner scan, 
    SecureRandom secureRandom, WordSearchGrid grid) {
        //initialize
        String currentWord;
        //populate wordsearch grid with '-' which will serve as blank spots
        for (int row = 0; row < grid.getRows(); row++) {
            for (int column = 0; column < grid.getColumns(); column++) {
                wordSearch[row][column] = '-';
            }//end inner for loop
        }//end outer for loop

        //loop through words array and adds word user enter as value
        for (int i = 0; i < 8; i++) {
            System.out.println("Enter word " + (i + 1) + ":");
            grid.getWords()[i] = scan.next().toLowerCase(); //get word and make it lowercase, put in array
        } //end for loop

        //print chosen words in random directions
        for (int i = 0; i < 8; i++) { //loop through words array 
            int randomDirection = secureRandom.nextInt(3); //number between 0-2 (inclusive)
            currentWord = grid.getWords()[i];
            switch(randomDirection) {
                case 0 -> {//place word horizontally
                    placeHorizontally(wordSearch, secureRandom, currentWord, grid);
                } case 1 -> {//place word vertically
                    placeVertically(wordSearch, secureRandom, currentWord, grid);
                } case 2 -> {//place word diagonally
                    placeDiagonally(wordSearch, secureRandom, currentWord, grid);
                }
            }//end switch/case
        } //end for loop
        return wordSearch;
    }//end method createWordSearch

    //user menu
    public static void userMenu(int userInt, char [][] wordSearch, SecureRandom secureRandom,
    WordSearchGrid grid, Scanner scan) {
        switch (userInt) {
            case 1 -> { //create a wordsearch
                createWordSearch(wordSearch, scan, secureRandom, grid);
            } case 2 -> { //view wordsearch with solution
                printWordSearch(wordSearch, grid);
            } case 3 -> { //view wordsearch without solutions
                addRandomChars(wordSearch, secureRandom, grid);
                printWordSearch(wordSearch, grid);
            } case 4 -> {
                //quit
            } default -> { //initialized to this, and does this if user enters wrong input
                System.out.println("Enter a number between 1 and 4:");
            } 
        } //end switch/case
        //print user menu
        System.out.println("1) Create a wordsearch");
        System.out.println("2) View a wordsearch with solutions");
        System.out.println("3) View a wordsearch without solutions");
        System.out.println("4) Quit");
    } // end method userMenu
}//end class

// To do:
// - let user choose number of size of wordsearch and number of words
// - create WordSearchGrid class for words, columns, wordSearch[][], so you don't
// need so many parameters
// - optimize user menu
// - add overlap capability
// - addRandomChars permanently alters, preserve original
// - ask user to name wordsearch and save different wordsearches
// (create wordsearch object class and then create arraylist of different 
// wordsearches user has created?)