package studentmanagement;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagement {
    ArrayList<Student> arrSV = new ArrayList<>(); 

    public void studentArrangement(ArrayList<Student> arrSV) {
        for (int i = 0; i < arrSV.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arrSV.size(); j++) {
                if (arrSV.get(j).getPoint() < arrSV.get(minIndex).getPoint()) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                Student temp = arrSV.get(i);
                arrSV.set(i, arrSV.get(minIndex));
                arrSV.set(minIndex, temp);
            }
        }
    }

    public String getRank(float point) {
        if (point < 5.0) {
            return "Fail";
        } else if (point < 6.5) {
            return "Medium";
        } else if (point < 7.5) {
            return "Good";
        } else if (point < 9.0) {
            return "Very Good";
        } else {
            return "Excellent";
        }
    }

    public void showListSV(ArrayList<Student> arr) {
        if (arr.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        for (int i = 0; i < arr.size(); i++) {
            Student student = arr.get(i);
            student.outputSV();
            String rank = getRank(student.getPoint());
            System.out.println("Rank: " + rank);
        }
    }

    public void inputListSV(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("Please enter information for student number: " + (i + 1));
            Student student = new Student();
            student.inputSV();
            arrSV.add(student);
        }
    }

    public void searchSV(ArrayList<Student> arr, String name) {
        int found = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).getName().contains(name)) {
                arr.get(i).outputSV();
                found = 1;
            }
        }
        if (found == 0) {
            System.out.println("No student found with that name.");
        }
    }

    public void fix(String ID) {
        for (Student student : arrSV) {
            if (student.getID().equals(ID)) {
                System.out.println("Re-enter information for student with ID: " + ID);
                student.inputSV();
                System.out.println("Student information updated successfully!");
                return;
            }
        }
        System.out.println("No student found with ID: " + ID);
    }

    public void delete(String ID) {
        for (int i = 0; i < arrSV.size(); i++) {
            if (arrSV.get(i).getID().equals(ID)) {
                arrSV.remove(i);
                System.out.println("Deleted student with ID: " + ID);
                return;
            }
        }
        System.out.println("No student found with ID: " + ID);
    }

    public static void main(String[] args) {
        StudentManagement studentManagement = new StudentManagement();
        Scanner input = new Scanner(System.in);
        int select;

        while (true) {
            System.out.println("MENU");
            System.out.println("1. Enter student list");
            System.out.println("2. Show student information");
            System.out.println("3. Student Arrangement (Sort by score)");
            System.out.println("4. Search for students");
            System.out.println("5. Edit student information");
            System.out.println("6. Delete student");
            System.out.println("7. Exit");

            System.out.print("Enter your selection: ");
            select = input.nextInt();

            switch (select) {
                case 1:
                    System.out.println("Please enter the number of students in the list:");
                    int n = input.nextInt();
                    studentManagement.inputListSV(n);
                    break;
                case 2:
                    studentManagement.showListSV(studentManagement.arrSV);
                    break;
                case 3:
                    studentManagement.studentArrangement(studentManagement.arrSV);
                    System.out.println("Student list has been sorted by score.");
                    studentManagement.showListSV(studentManagement.arrSV); 
                    break;
                case 4:
                    input.nextLine();
                    System.out.println("Please enter the name of the student you want to search for:");
                    String name = input.nextLine();
                    studentManagement.searchSV(studentManagement.arrSV, name);
                    break;
                case 5:
                    input.nextLine();
                    System.out.println("Enter the student ID you want to edit:");
                    String idToEdit = input.nextLine();
                    studentManagement.fix(idToEdit);
                    break;
                case 6:
                    input.nextLine();
                    System.out.println("Enter the student ID you want to delete:");
                    String idToDelete = input.nextLine();
                    studentManagement.delete(idToDelete);
                    break;
                case 7:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid input! Please choose a valid option (1-7).");
            }
        }
    }
}
