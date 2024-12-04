package studentmanagement;

import java.util.Scanner;

public class Student {
    private String ID;      
    private String name;   
    private String birthday; 
    private float point;    
    public void inputSV() {
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter the student ID:");
        ID = input.nextLine();
        while (ID.trim().isEmpty()) {
            System.out.println("\u001B[31mThe ID cannot be empty! Please enter it again.\u001B[0m");
            ID = input.nextLine();
        }

        System.out.println("Please enter the student's name:");
        name = input.nextLine();
        while (name.trim().isEmpty()) {
            System.out.println("\u001B[31mThe name cannot be empty! Please enter it again.\u001B[0m");
            name = input.nextLine();
        }

        System.out.println("Please enter the student's date of birth (dd/MM/yyyy):");
        birthday = input.nextLine();

        while (true) {
            System.out.println("Please enter the student's score (0-10):");
            if (input.hasNextFloat()) {
                point = input.nextFloat();
                if (point >= 0 && point <= 10) {
                    break; 
                } else {
                    System.out.println("\u001B[31mInvalid score! The score must be between 0 and 10. Please enter it again.\u001B[0m");
                }
            } else {
                System.out.println("\u001B[31mInvalid input! Please enter a valid number for the score. (e.g., 8.5)\u001B[0m");
                input.next(); 
            }
        }

        input.nextLine();  
    }

    public void outputSV() {
        System.out.println("Student ID: " + ID + 
                           ", Student's name: " + name + 
                           ", Date of birth: " + birthday + 
                           ", Score: " + point);
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public float getPoint() {
        return point;
    }

    public void setPoint(float point) {
        this.point = point;
    }
}
