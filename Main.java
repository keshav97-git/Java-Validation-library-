import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
     Validator validator = new Validator();
     try{
         validator.open();
         Scanner sc  = new Scanner(System.in);
         System.out.println("Enter input: ");
         String input = sc.nextLine();
         validator.validate(input);
         System.out.println("Validtion succeeded");
     } catch(Exception e){
         System.err.println("Validtion failed: " + e.getMessage());
     }
     finally {
         try{
             validator.close();
         }catch(Exception e){
             System.err.println("Failed to close validator: " + e.getMessage());
         }
     }
    }
}