// Citation:
// Multi-Dimensional Arrays: https://www.w3schools.com/java/java_arrays_multi.asp
// Method Calls: https://www.w3schools.com/java/java_class_methods.asp 
import java.util.Scanner;
public class WordSearchTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //for calling methods, will change later
        WordSearchTest myWordSearch = new WordSearchTest();
        myWordSearch.userMenu(scan);

        
    } // end main method
    //user menu
    public void userMenu(Scanner scan){
        //print user menu
        System.out.println("1) Create a wordsearch");
        System.out.println("2) View a wordsearch with solutions");
        System.out.println("3) View a wordsearch without solutions");
        System.out.println("4) Quit");
        //take user input
        int userInput = scan.nextInt();

    } // end method userMenu
}