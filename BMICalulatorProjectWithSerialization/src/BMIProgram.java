import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * This program is a BMI calculator.
 * It prompts the user for an option (Metric or Standard),
 * then calculates the BMI based on kilograms/centimeters or
 * pounds/inches.
 * The BMI class will be used for instantiation.
 * Edited by Mishaela Pedersen 3/19/20 -
 *      -added while loops to input modules to keep looping through input until valid weight or height is entered.
 *      -If not a valid weight or height, it will reset the weight/height to zero before looping through again.
 *      -made myBMI a static global variable for easier access to the instantiable class.
 * Updated by Mishaela Pedersen 4/1/20 -
 *      - added Object serialization to hold bmi values and names as patient info to display later
 *      - added a menu option to display all the patients in report format
 *      - default constructor was updated to include the default first name "John" and last name "Doe"
 */
public class BMIProgram {

    static Scanner inputScanner = new Scanner(System.in);
    static BMI myBMI;
    static List<BMI> patientList = new ArrayList<>();
    static String filename = "bmi.ser";

    public static void main(String[] args) throws FileNotFoundException {
        int option = 0, weight = 0, height = 0;
        String response;

        String fname = "", lname = "";
        try {
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }
        do {
            option = menu();
            switch (option) {
                case 1:
                    weight = inputWeight(option);
                    height = inputHeight(option);
                    fname = inputFirstName();
                    lname = inputLastName();
                    myBMI = new BMI(fname, lname, option, weight, height);
                    response = showBMI(myBMI);
                    if(response.equals("y") || "Y".equals(response))
                        patientList.add(myBMI);
                    break;
                case 2:
                    weight = inputWeight(option);
                    height = inputHeight(option);
                    fname = inputFirstName();
                    lname = inputLastName();
                    myBMI = new BMI(fname, lname, option, weight, height );
                    response = showBMI(myBMI);
                    if(response.equals("y") || response.equals("Y")){
                        patientList.add(myBMI);
                    }

                    break;
                case 3:
                    displayAllPatients(patientList);
                    inputScanner.nextLine();
                    break;
                case 4:
                    System.out.println("\nProgram will now exit, press Enter");
                    inputScanner.nextLine();
                    break;
                default:
                    System.out.println("\nOption must be 1 - 4, press Enter");
                    inputScanner.nextLine();
            }
        } while (option != 4);
        closing();
    }




    public static void init() throws IOException {
        try{
            FileInputStream inFile = new FileInputStream(filename);
            ObjectInputStream inStream = new ObjectInputStream(inFile);


            patientList = (List<BMI>) inStream.readObject();

            inStream.close();
            inFile.close();
        } catch(FileNotFoundException | ClassNotFoundException ex){
            System.out.println("Error in reading patient file");
        }

    }

    public static int menu() {
        int opt = 0;

        System.out.println("Welcome to the To Your Health BMI Calculator\n\n");
        System.out.println("MENU\n");
        System.out.println("\tOption 1: Metric\n");
        System.out.println("\tOption 2: Standard\n");
        System.out.println("\tOption 3: Display All Patients\n");
        System.out.println("\tOption 4: Exit\n");
        System.out.print("Enter your option: ");

        try {
            opt = Integer.parseInt(inputScanner.nextLine());
        } catch (Exception e) {
            opt = 0;
        }

        return opt;
    }

    public static int inputWeight(int opt) {
        int weight = 0;
        boolean validWeight = false;

        switch (opt) {
            case 1:
                while (!validWeight) {
                    System.out.print("\nEnter your weight in kilograms: ");
                    weight = Integer.parseInt(inputScanner.nextLine());
                    if (weight > 0) {
                        validWeight = true;
                    } else {
                        System.out.print("Error: Invalid Weight\n");
                        weight = 0;
                        System.out.println("Press enter to continue,");
                        inputScanner.nextLine();
                    }
                }
                break;
            case 2:
                while (!validWeight) {
                    System.out.print("Enter your weight in pounds: ");
                    weight = Integer.parseInt(inputScanner.nextLine());
                    if (weight > 0) {
                        validWeight = true;
                    } else {
                        System.out.print("Error: Invalid Weight\n");
                        System.out.println("Press enter to continue,");
                        weight = 0;
                        inputScanner.nextLine();
                    }
                }
                break;
        }

        return weight;
    }

    public static int inputHeight(int opt) {
        int height = 0, h = 0;
        String iHeight;
        boolean validHeight = false;

        switch (opt) {
            case 1:
                while (!validHeight) {
                    System.out.print("\nEnter your height in centimeters: ");
                    height = Integer.parseInt(inputScanner.nextLine());
                    if (height > 0) {
                        validHeight = true;
                    } else {
                        System.out.print("Error: Invalid Height\n\n");
                        System.out.println("Press enter to continue,");
                        height = 0;
                        inputScanner.nextLine();
                    }
                }
                break;
            case 2:
                while (!validHeight) {
                    System.out.print("Enter your height in inches: ");
                    height = Integer.parseInt(inputScanner.nextLine());
                    if (height > 0) {
                        validHeight = true;
                    } else {
                        System.out.print("Error: Invalid Height\n\n");
                        System.out.println("Press enter to continue,");
                        height = 0;
                        inputScanner.nextLine();
                    }
                }
                break;
        }

        return height;
    }



    public static String inputFirstName() {
        String fname = null;
        int len;
        boolean validFName = false;
        while(!validFName){
            System.out.println("Please enter the patient's first name");
            fname = inputScanner.nextLine();
            len = fname.length();
            if(len > 0){
                validFName = true;
            }
            else{
                System.out.println("Error: Patient name is required.");
                System.out.println("Press enter to continue,");
                len = 0;
                inputScanner.nextLine();
            }
        }
        return fname;
    }

    public static String inputLastName() {
        String lname = null;
        int len;
        boolean validLName = false;
        while(!validLName){
            System.out.println("Please enter the patient's last name");
            lname = inputScanner.nextLine();
            len = lname.length();
            if(len > 0){
                validLName = true;
            }
            else{
                System.out.println("Error: Patient name is required.");
                System.out.println("Press enter to continue,");
                len = 0;
                inputScanner.nextLine();
            }
        }
        return lname;
    }

    public static String showBMI(BMI b) {
        String response;
        Double bmiValue = b.calcBMI();
        DecimalFormat df = new DecimalFormat("##.##");
        System.out.println("Your BMI is " + df.format(bmiValue));
        System.out.println("Would you like to add this patient to the file?:");
        response = inputScanner.nextLine();
        return response;
    }

    public static void displayAllPatients(List patientList) throws FileNotFoundException {
        DecimalFormat df = new DecimalFormat("##.##");
        int o;
        String option;


        System.out.println("PATIENT NAME               WEIGHT         HEIGHT         TYPE          BMI         STATUS          ");

        for(Object myBMI : patientList){
            System.out.println(myBMI.toString());
        }

        System.out.println("Press enter to return to menu,");
    }

    public static void closing(){
        try{
            FileOutputStream outFile;
            ObjectOutputStream outStream;
            outFile = new FileOutputStream(filename);
            outStream = new ObjectOutputStream(outFile);

            outStream.writeObject(patientList);

            outStream.close();
            outFile.close();

            System.exit(1);
        }
        catch(IOException e){
            System.out.println("Error: File not found");
            System.out.println("Press enter to continue,");
            inputScanner.nextLine();
        }
    }

}
