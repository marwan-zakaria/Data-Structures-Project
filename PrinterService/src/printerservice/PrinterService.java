package printerservice;

/**
 *
 * @author marwan
 */
import java.util.Scanner;

public class PrinterService {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        Queue printer = new Queue();
        
        System.out.println("Enter a set of jobs: ");
        int n = s.nextInt();
        // the user will keep entering set of jobs until -99 is entered
        while(n != -99){
            printer.enqueue(n);
            n = s.nextInt();
        }
        // The printer will close
        printer.enqueue(n);

    }

}
