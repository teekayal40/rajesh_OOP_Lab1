package Source;
import java.util.*;

class Employee {

    public String Employee(String First, String Last) {


        String Fullname = First +  Last;
        return Fullname;
    }

}

class CredentialService {

    public String generatePassword(int ch,int len) {

        String password = "";
        Random random = new Random();

        String pass_string = "";

        // Storing all the ASCII values starting from 33 (!) to 126 (~) to generate the password

        for (int i = 33;i<127;i++) {

            pass_string = pass_string + (char) i;         
          
        }

        for(int i = 0;i < 5;i++) {

            int random_pass = random.nextInt(pass_string.length()+i);
            password = password + pass_string.substring(random_pass, random_pass + 2);
        }

        return password;
    }

    public String generateEmailAddress(String FLName,String dept) {

            String email = FLName+"@"+dept+".abc.com";
            return email;

    }

    public void showCredentials(String First,String eaddr,String epass) {

        System.out.println("Dear " + First + " your generated credentials as follows");
        System.out.println("Email    --->" + eaddr);
        System.out.println("Password --->" + epass);

    }

}

public class lab1 {
        
    public static void main(String[] args) {

        String dname = "";
        String email_address = "";
        String FullName = "";
        String Epswd = "";
        
        Employee FLname = new Employee();

        CredentialService credentials = new CredentialService();

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your First Name");

        String Fname = sc.nextLine();

        System.out.println("Enter your Last Name");

        String Lname = sc.nextLine();  

        FullName = FLname.Employee(Fname, Lname);
     
        System.out.println(" ______________________________________________");
        System.out.println("|Please enter the department from the following");
        System.out.println("|1. Technical");
        System.out.println("|2. Admin");
        System.out.println("|3. Human Resource");
        System.out.println("|4. Legal");
        System.out.println();
        System.out.println();
        
        //hasNextInt() is a boolean method which turn into False if you enter option non-numeric so that program won't 
        //error out but gives a warning message that entered option is not the right one

        if (sc.hasNextInt()){
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                     dname = "tech";
                      break;

                case 2:
                    dname = "admn";
                    break;

                case 3:
                    dname = "hres";
                    break;

                case 4:
                    dname = "legl";
                    break;

                default:
                    System.out.println("Enter the right option 1 - 4");
            
        }
            Epswd = credentials.generatePassword(choice,FullName.length());            
            email_address = credentials.generateEmailAddress(FullName,dname);
            credentials.showCredentials(Fname,email_address,Epswd);
        }
        else {
            System.out.println("Not right option entered please enter between 1 and 4 integer value");
        }
              
        sc.close();
    }
    
}