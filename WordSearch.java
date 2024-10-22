// Citation:
// Multi-Dimensional Arrays: https://www.w3schools.com/java/java_arrays_multi.asp 
// Google AI search "print grid in Java"
// Google AI search "initialize multidimensional array to size java"

import java.security.SecureRandom;
import java.util.Scanner;

public class WordSearch {
    public static void main(String[] args) {
        //instance of SecureRandom (object)
        SecureRandom secureRandom = new SecureRandom();

        //initialize
        int userInt = 0;
        Scanner scan = new Scanner(System.in);

        //initialize words (getting rid of this later)
        String word1 = "crane";
        String word2 = "place";
        String word3 = "times";
        String word4 = "happy";
        String word5 = "crazy";

        //array to hold words
        String[] words = new String[8];

        


        //initialize wordSearch array to rows x columns
        int rows = 20;
        int columns = 20;
        char wordSearch[][] = new char[rows][columns];
        //populate array wordSearch[][] with '-'
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                wordSearch[row][column] = '-';
            }//end inner for loop
        }//end outer for loop

        //loop user menu
        do {  
            userMenu(userInt, wordSearch, secureRandom, rows, columns, scan, words);
            //get user input
            userInt = scan.nextInt();
        } while (userInt != 4);
        System.out.println("Goodbye!");

        //call method placeHorizontally for word1
        placeHorizontally(wordSearch, secureRandom, word1, rows, columns);
        //call method placeHorizontally for word2
        placeHorizontally(wordSearch, secureRandom, word2, rows, columns);
        //call method placeVertically for word3
        placeVertically(wordSearch, secureRandom, word3, rows, columns);
        //call place diagonally for word4
        placeDiagonally(wordSearch, secureRandom, word4, rows, columns);
        //call place vertically for word 5
        placeVertically(wordSearch, secureRandom, word5, rows, columns);
        
        //print wordsearch with answers
        printWordSearch(wordSearch, rows, columns);
        
        //print wordsearch without answers
        System.out.println();
        System.out.println("Without answers:");
        addRandomChars(wordSearch, secureRandom, rows, columns);
        printWordSearch(wordSearch, rows, columns);

    }//end main method

    //place word horizontally in a random location
    //only putting rows and columns as parameters for test purposes (so i can change grid size easily)
    public static char[][] placeHorizontally(char[][] wordSearch, SecureRandom secureRandom, String word, int rows, int columns) {
        //create random ints for rows and columns
        int rowInt = secureRandom.nextInt(rows);
        int columnInt = secureRandom.nextInt(columns - word.length() + 1);

        //place word horizontally
        int index = 0; //index in string
        for (int j = columnInt; j < columnInt + word.length(); j++) {
            //if spot is blank, put char there
            if(wordSearch[rowInt][j] == '-') {
                wordSearch[rowInt][j] = word.charAt(index);
                index++;//increasing so we can go through word
            } else {//if spot contains char erase all previous letter placements
                //replace previous word placement with '-'s
                for (int i = columnInt; i < j; i++) {
                    wordSearch[rowInt][i] = '-';
                }//end for loop

                //generate word in new location
                rowInt = secureRandom.nextInt(rows);
                columnInt = secureRandom.nextInt(columns - word.length() + 1); 
                
                j = columnInt - 1; //will go back to new value for column int when starting the loop again
                index = 0; //will start from beginning of word        
                //go back to beginning of for loop
            }//end if/else
        }//end for loop
        return wordSearch;
    }//end method placeHorizontally

    //place a word vertically in a random place
    public static char[][] placeVertically (char[][] wordSearch, SecureRandom secureRandom, String word, int rows, int columns) {
        //create random ints
        int rowInt = secureRandom.nextInt(rows - word.length() + 1);
        int columnInt = secureRandom.nextInt(columns);
        //row increase, column stays the same
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
                columnInt = secureRandom.nextInt(columns);
                rowInt = secureRandom.nextInt(rows - word.length() + 1); 
                
                row = rowInt - 1; //will go back to new value for row int when starting the loop again
                index = 0; //will start from beginning of word        
                //go back to beginning of for loop
            }//end if/else
        }//end for loop
        return wordSearch;
    }//end placeVertically method

    //place diagonally
    public static char[][] placeDiagonally (char[][] wordSearch, SecureRandom secureRandom, String word, int rows, int columns) {
        int rowInt = secureRandom.nextInt(rows - word.length() + 1);
        int columnInt = secureRandom.nextInt(columns - word.length() + 1);

        //generate without overlaps
        for (int index = 0; index < word.length(); index++) {
            if(wordSearch[rowInt + index][columnInt + index] == '-'){
                wordSearch[rowInt + index][columnInt + index] = word.charAt(index);
            } else {
                for(int i = 0; i < index; i++){
                    wordSearch[rowInt + i][columnInt + i] = '-';
                }//end for loop
                rowInt = secureRandom.nextInt(rows - word.length() + 1);
                columnInt = secureRandom.nextInt(columns - word.length() + 1);
                index = -1;
            }//end if/else
        }//end for loop
        return wordSearch;
    }//end placeDiagonally method

    //adds random chars to blank spots in wordsearch (must be called after word placement methods!)
    public static char[][] addRandomChars (char[][] wordSearch, SecureRandom secureRandom, int rows, int columns) {
        //loop through wordSearch
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                if(wordSearch[row][column] == '-') { //if char = '-', replace with random nums
                    //fills word search with chars a-z
                    wordSearch[row][column] = (char)(secureRandom.nextInt(26) + 97); //a-z ASCII values are 97-122
                } else {
                    //leave it alone
                }//end if/else
            }//end inner for loop
        }//end outer for loop
        return wordSearch;
    }//end method addRandomChars

    public static void printWordSearch(char[][] wordSearch, int rows, int columns) {
        //print wordSearch[][] grid
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                System.out.print(wordSearch[row][column] + " ");
            }//end inner for loop
            System.out.println();
        }//end outer for loop
    }//end printWordSearch method

    //create a wordsearch
    public static char[][] createWordSearch(char[][] wordSearch, Scanner scan, String[] words, SecureRandom secureRandom) {
        //add catch for if user enters wrong word (ie too long)
        System.out.println("Words must be eight characters or under");
        //loop through words array and adds word user enter as value
        for (int i = 0; i < 8; i++) {
            System.out.println("Enter word " + (i + 1) + ":");
            words[i] = scan.next();
        } //end for loop

        int randomDirection = secureRandom.nextInt(3);

        //print chosen words in random directions
        for (int i = 0; i < 8; i++) { //loop through words array
            switch(randomDirection) {
                case 0 -> {//place word horizontally


                } case 1 -> {//place word vertically

                } case 2 -> {//place word diagonally

                }//end switch/case
            }
        } //end for loop

        return wordSearch;
    }//end method createWordSearch
    //user menu
    public static void userMenu(int userInt, char [][] wordSearch, SecureRandom secureRandom, int rows, int columns, Scanner scan, String[] words) {
        switch (userInt) {
            case 1 -> { //create a wordsearch
                System.out.println("create a wordsearch (method)");
                createWordSearch(wordSearch, scan, words, secureRandom);

            }
            case 2 -> { //view wordsearch with solution
                System.out.println("view wordsearch with solution");
                printWordSearch(wordSearch, rows, columns);
            }
            case 3 -> { //view wordsearch without solutions
                System.out.println("view wordsearch w/o solutions");
                addRandomChars(wordSearch, secureRandom, rows, columns);
                printWordSearch(wordSearch, rows, columns);
            }
            case 4 -> {
                //quit
            }
            default -> { //initialized to this, and does this if user enters wrong input
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

//To do:
// - randomize directions for each word
// - add key for words you need to find to printed wordsearch
// - get user menu working
// - remove test code, add comments and clean up before turning in
// - exta credit (enums etc)
// - try/catch finally for empty array wordSearch "you need to create a wordsearch
//   before viewing"
// - enums for word list