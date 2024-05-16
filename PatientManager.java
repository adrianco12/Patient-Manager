// main class
import java.util.*;

// class for main
public class PatientManager
{
   public static void main(String args[]) 
   {
      // initialize variables
      Patient patient;
      int input;
      
      // creating a new PatientQueue object
      PatientQueue queue = new PatientQueue();
      // create a scanner object for input from user
      Scanner in = new Scanner(System.in);
      
      // Display menu to the user
      while (true)
      {
         // prompt user to choose enqueue or dequeue
         displayMenu();
         input = in.nextInt();
         
         // data validation
         while (input < 1 || input > 4)
         {
            displayMenu();
            input = in.nextInt();
         }
         
         // decision structure to determine user's decision
         if (input == 1) // enqueue a patient
         {
            in.nextLine(); // consume newline character
            String name = "";

            while (!name.equals("exit"))
            {
               // get data to add to Patron object
               System.out.println("Enter the name of the patient or 'exit': ");
               name = in.nextLine();
               
               if (name.equals("exit"))
               {
                  break;
               }
               
               enqueuePatient(name, queue, in);
            }         
         }
         else if (input == 2) // retrieve patients in order of priority
         {
            System.out.println ("Retrieving patients in order of priority... \n");
            queue.displayQueue(); 
         }
         else if (input == 3) // removing patients based on priority
         {
            System.out.println ("Removing the first patients based on priority... \n");
            Patient removedPatient = queue.popPriority();
            System.out.println ("Removed " + removedPatient.getName() + " (Injury: " + removedPatient.getInjury() + ")");     
         } 
         else
         {
            System.out.println ("Bye!");
            // exit while loop and end program
            break;
         }      
      } // end while loop
   } // end main 
   
   
   
   // method to display menu
   public static void displayMenu()
   {
      System.out.println("\nMenu: \n 1. Enqueue a new Patient  \n 2. Retrieve patients in order of priority \n 3. Remove the patient with the next highest priority \n 4. Exit");
   }
   
   
   // method to enqueue a patient
   public static void enqueuePatient(String name, PatientQueue queue, Scanner in)
   {
      String injury = "";
      int priority;

      System.out.println("Enter the injury: ");
      injury = in.nextLine();
      System.out.println("Enter the priority: ");
      priority = in.nextInt();
      in.nextLine(); // consume newline character
      
      // pass data to an instance of Patient class
      Patient newPatient = new Patient(name, injury, priority);
      
      // queue data using the enqueue method in the PatientQueue class
      queue.enqueue(newPatient);
   }
   
} // end class
