/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package finalprojec;

/**
 *
 * @author 22ug2-0064 Musharraff
 */
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;


class BloodPressure {
    private int id;
    private String name;
    private int yearOfBirth;
    private int systolic;
    private int diastolic;

    
    public BloodPressure(int id, String name, int yearOfBirth, int systolic, int diastolic) {
        this.id = id;
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.systolic = systolic;
        this.diastolic = diastolic;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public int getSystolic() {
        return systolic;
    }

    public void setSystolic(int systolic) {
        this.systolic = systolic;
    }

    public int getDiastolic() {
        return diastolic;
    }

    public void setDiastolic(int diastolic) {
        this.diastolic = diastolic;
    }

    
    public int calculateAge() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        return currentYear - yearOfBirth;
    }

    
    public String calculateCategory() {
        if (systolic < 90 && diastolic < 60) {
            return "LOW";
        } else if (systolic >= 90 && systolic < 120 && diastolic <= 80 && diastolic > 60) {
            return "NORMAL";
        } else if (systolic >= 120 && systolic <= 139 && diastolic <= 90 && diastolic > 80) {
            return "PREHYPERTENSION";
        } else if ((systolic >= 140 && systolic <= 159) || (diastolic >= 90 && diastolic <= 99)) {
            return "STAGE 1 HYPERTENSION";
        } else if (systolic >= 160 || diastolic >= 100) {
            return "Hypertension Stage 2";
        } else {
            return "Hypertensive crisis";
        }
    }

    
    public void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Year of Birth: " + yearOfBirth);
        System.out.println("Systolic: " + systolic);
        System.out.println("Diastolic: " + diastolic);
        System.out.println("Age: " + calculateAge());
        System.out.println("Blood Pressure Category: " + calculateCategory());
        System.out.println("----------------------");
    }
}


public class Tester {
    private ArrayList<BloodPressure> users = new ArrayList<>();
    private int currentId = 1;
    private Scanner scanner = new Scanner(System.in);

    
    public void displayMenu() {
        System.out.println("\nBlood Pressure Monitor Application");
        System.out.println("1. Create a record");
        System.out.println("2. Show blood pressure data for all users");
        System.out.println("3. Show blood pressure data for a selected user");
        System.out.println("4. Delete all records");
        System.out.println("5. Exit application");
        System.out.print("Enter your choice: ");
    }

    
    public static void main(String[] args) {
        Tester tester = new Tester();
        tester.run();
    }

    
    public void run() {
        String choice;
        do {
            displayMenu();
            choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    create();
                    break;
                case "2":
                    index();
                    break;
                case "3":
                    System.out.print("Enter user ID: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    view(id);
                    break;
                case "4":
                    delete();
                    break;
                case "5":
                    exit();
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        } while (!choice.equals("5"));
    }

    
    public void create() {
        System.out.print("Enter user name: ");
        String name = scanner.nextLine();
        System.out.print("Enter year of birth: ");
        int yearOfBirth = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter systolic pressure: ");
        int systolic = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter diastolic pressure: ");
        int diastolic = Integer.parseInt(scanner.nextLine());

        BloodPressure newRecord = new BloodPressure(currentId, name, yearOfBirth, systolic, diastolic);
        users.add(newRecord);
        currentId++;
        System.out.println("Record created successfully.");
    }

    
    public void index() {
        if (users.isEmpty()) {
            System.out.println("No records found.");
        } else {
            for (BloodPressure user : users) {
                user.display();
            }
        }
    }

    
    public void view(int id) {
        boolean found = false;
        for (BloodPressure user : users) {
            if (user.getId() == id) {
                user.display();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("User not found with ID: " + id);
        }
    }

    
    public void delete() {
        users.clear();
        System.out.println("All records deleted.");
    }

    
    public void exit() {
        System.out.println("Thank you for using the Blood Pressure Monitor Application.");
        System.exit(0);
    }
}
