// Citation:
// Multi-Dimensional Arrays: https://www.w3schools.com/java/java_arrays_multi.asp 
// Google AI search "print grid in Java"
// Google AI search "initialize multidimensional array to size java"

import java.security.SecureRandom;
import java.util.Scanner;

public class WordSearch {
    public static void main(String[] args) {
        //initialize section
        SecureRandom secureRandom = new SecureRandom();
        int userInt = 0;
        Scanner scan = new Scanner(System.in);
        String[] words = new String[8]; //array to hold words
        int rows = 20;
        int columns = 20;
        char wordSearch[][] = new char[rows][columns]; //initialize wordSearch array to rows x columns

        //loop user menu
        do {  
            userMenu(userInt, wordSearch, secureRandom, rows, columns, scan, words);
            //get user input
            userInt = scan.nextInt();
        } while (userInt != 4);
        System.out.println("Goodbye!");
    }//end main method

    //place word horizontally in a random location
    public static char[][] placeHorizontally(char[][] wordSearch, SecureRandom secureRandom, String word,
    int rows, int columns) { //putting rows and columns as a parameter so size can easily be changed
        //create random ints for placement
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
                //replace previous char placements with '-'
                for (int i = columnInt; i < j; i++) {
                    wordSearch[rowInt][i] = '-';
                }//end for loop

                //generate word in new location
                rowInt = secureRandom.nextInt(rows);
                columnInt = secureRandom.nextInt(columns - word.length() + 1); 
                
                j = columnInt - 1; //go back to new value for column int when starting the loop again
                index = 0; //will start from beginning of word        
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

    public static void printWordSearch(char[][] wordSearch, int rows, int columns, String[] words) {
        //print wordSearch[][] grid
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                System.out.print(wordSearch[row][column] + " ");
            }//end inner for loop
            System.out.println();
        }//end outer for loop
        //print words to find
        System.out.println("Find:");
        for (int i = 0; i < 8; i++) {//loop through words array
            System.out.println(words[i]);
        }//end for loop
    }//end printWordSearch method

    //create a wordsearch
    public static char[][] createWordSearch(char[][] wordSearch, Scanner scan, String[] words, SecureRandom secureRandom, int rows, int columns) {
        //populate wordsearch grid with '-' which will serve as blank spots
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                wordSearch[row][column] = '-';
            }//end inner for loop
        }//end outer for loop

        String currentWord;
        //add catch for if user enters wrong word (ie too long)
        System.out.println("Words must be eight characters or under");
        //loop through words array and adds word user enter as value
        for (int i = 0; i < 8; i++) {
            System.out.println("Enter word " + (i + 1) + ":");
            words[i] = scan.next().toLowerCase(); //get word and make it lowercase, put in array
        } //end for loop

        //print chosen words in random directions
        for (int i = 0; i < 8; i++) { //loop through words array 
            int randomDirection = secureRandom.nextInt(3); //number between 0-2 (inclusive)
            currentWord = words[i];
            switch(randomDirection) {
                case 0 -> {//place word horizontally
                    placeHorizontally(wordSearch, secureRandom, currentWord, rows, columns);
                } case 1 -> {//place word vertically
                    placeVertically(wordSearch, secureRandom, currentWord, rows, columns);
                } case 2 -> {//place word diagonally
                    placeDiagonally(wordSearch, secureRandom, currentWord, rows, columns);
                }
            }//end switch/case
        } //end for loop
        return wordSearch;
    }//end method createWordSearch

    //user menu
    public static void userMenu(int userInt, char [][] wordSearch, SecureRandom secureRandom, int rows, int columns, Scanner scan, String[] words) {
        switch (userInt) {
            case 1 -> { //create a wordsearch
                createWordSearch(wordSearch, scan, words, secureRandom, rows, columns);
            } case 2 -> { //view wordsearch with solution
                printWordSearch(wordSearch, rows, columns, words);
            } case 3 -> { //view wordsearch without solutions
                addRandomChars(wordSearch, secureRandom, rows, columns);
                printWordSearch(wordSearch, rows, columns, words);
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

//To do:
// - remove test code, add comments and clean up before turning in
// - exta credit (enums etc)
// - try/catch finally for empty array wordSearch "you need to create a wordsearch
//   before viewing"