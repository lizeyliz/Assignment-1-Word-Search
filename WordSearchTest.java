// Citation:
// Multi-Dimensional Arrays: https://www.w3schools.com/java/java_arrays_multi.asp
// Method Calls: https://www.w3schools.com/java/java_class_methods.asp 
import java.util.Scanner;
public class WordSearchTest {
    public static void main(String[] args) {
        //initialize
        int userInt = 0;
        Scanner scan = new Scanner(System.in);
        //for calling methods, will change later
        WordSearchTest myWordSearch = new WordSearchTest();
        
        myWordSearch.intro();
        do {  
            //print user menu
            System.out.println("1) Create a wordsearch");
            System.out.println("2) View a wordsearch with solutions");
            System.out.println("3) View a wordsearch without solutions");
            System.out.println("4) Quit");
            //get user input
            userInt = scan.nextInt();
            myWordSearch.userMenu(userInt);
        } while (userInt != 4);

        
    } // end main method
    public void intro() {
        System.out.println("Intro text");
    }
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
                System.out.println("Goodbye!");
            }
            default -> {
                System.out.println("Please enter valid input.");
            } 
        } //end switch/case
    } // end method userMenu
}