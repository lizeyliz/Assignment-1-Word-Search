// Citation:
// Multi-Dimensional Arrays: https://www.w3schools.com/java/java_arrays_multi.asp
// Method Calls: https://www.w3schools.com/java/java_class_methods.asp 
// For-Each Loops: https://www.w3schools.com/java/java_foreach_loop.asp
// Google AI search "print grid in Java"
// Google AI search "initialize multidimensional array to size java"
import java.util.Scanner;
//this class currently only contains user menu
public class WordSearchTest {
    public static void main(String[] args) {
        //initialize
        int userInt = 0;
        Scanner scan = new Scanner(System.in);
        //loop user menu
        do {  
            userMenu(userInt);
            //get user input
            userInt = scan.nextInt();
        } while (userInt != 4);
        System.out.println("Goodbye!");
    } // end main method
    //user menu
    public static void userMenu(int userInt){
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
}