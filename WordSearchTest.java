// Citation:
// Multi-Dimensional Arrays: https://www.w3schools.com/java/java_arrays_multi.asp
// Method Calls: https://www.w3schools.com/java/java_class_methods.asp 
// For-Each Loops: https://www.w3schools.com/java/java_foreach_loop.asp
// Google AI print grid in Java
// Google AI initialize multidimensional array to size java
import java.util.Scanner;
//import random #s
public class WordSearchTest {
    public static void main(String[] args) {
        //initialize
        int userInt = 0;
        Scanner scan = new Scanner(System.in);
        //for calling methods, will change later
        WordSearchTest myWordSearch = new WordSearchTest();
        //test
        //myWordSearch.createWordSearch();

        //initialize two dimensional array grid
        char[][] grid = new char[20][20];
        // Initialize grid elements
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                grid[i][j] = 'x';
            }
        }
        //add word 1 to grid vertically (loc 1 to 5)
        //have to add space after words (maybe fix this later)
        String word1 = "crane ";
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 1; j++) {
                grid[i][j] = word1.charAt(i);
            }
        }


        //print grid
        for (char[] row : grid) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }

        //loop user menu
        /*do {  
            myWordSearch.userMenu(userInt);
            //get user input
            userInt = scan.nextInt();
        } while (userInt != 4);
        System.out.println("Goodbye!");*/
    } // end main method
    //user menu
    public void userMenu(int userInt){
        switch (userInt) {
            case 1 -> {
                System.out.println("create a wordsearch (method)");
            }
            case 2 -> {
                System.out.println("view wordsearch with solution");
            }
            case 3 -> {
                System.out.println("view wordsearch without solutions");
            }
            case 4 -> {
                //quit
            }
            default -> {
                System.out.println("Enter a number between 1 and 4:");
            } 
        } //end switch/case
        //print user menu
        System.out.println("1) Create a wordsearch");
        System.out.println("2) View a wordsearch with solutions");
        System.out.println("3) View a wordsearch without solutions");
        System.out.println("4) Quit");
    } // end method userMenu

    //create a wordsearch
    //make sure you have different directions
    public String createWordSearch() {
        //looking up print in grid java, use two dimensional array
        //e.g char word[x][y] = 'c' location of char
        String wordSearch = "x x x x x"; //times 5 (newline)
        //test words, will add user input later
        String word1 = "crane";
        String word2 = "place";
        String word3 = "times";
        String word4 = "happy";
        String word5 = "crazy";
        //array of chars
        char[] allChars = new char[24];
        //array of words
        String[] words = {word1, word2, word3, word4, word5};
        //word 1 char array
        char[] word1Chars = new char[5];
        for (int i = 0; i < 5; i++) {
            word1Chars[i]= word1.charAt(i);
        }
        //TESTING print word1Chars
        for (int i = 0; i < 5; i++) {
            System.out.println(word1Chars[i]);
        }
        //horizontal: x+1, y for each increment
        //vertical: x, y-1, for each increment
        return wordSearch;
    }

    //view a wordsearch with solutions

    //view a wordsearch without solutions
}