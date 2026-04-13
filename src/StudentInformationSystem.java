import java.util.Scanner;
import java.util.ArrayList;

// Class representing a Student (Encapsulation)
class Student {
    private String name;
    private int age;
    private double grade;
    private String studentId;
    private String contact;

    // Constructor
    public Student(String name, int age, double grade, String studentId, String contact) {
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.studentId = studentId;
        this.contact = contact;
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) {
        if (age > 0) this.age = age;
        else System.out.println("Age must be positive!");
    }

    public double getGrade() { return grade; }
    public void setGrade(double grade) { this.grade = grade; }

    public String getStudentId() { return studentId; }

    public String getContact() { return contact; }
    public void setContact(String contact) { this.contact = contact; }

    // Display student details
    public void displayInfo() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Grade: " + grade);
        System.out.println("Contact: " + contact);
        System.out.println("-".repeat(30));
    }
}

public class StudentInformationSystem {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        // Main menu loop
        while (running) {
            System.out.println("\n=== STUDENT INFORMATION SYSTEM ===");
            System.out.println("1. Add New Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewAllStudents();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    updateStudent();
                    break;
                case 5:
                    deleteStudent();
                    break;
                case 6:
                    running = false;
                    System.out.println("Thank you for using Student Information System!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
        scanner.close();
    }

    // Method to add a new student
    private static void addStudent() {
        System.out.println("\n=== ADD NEW STUDENT ===");

        System.out.print("Enter Student ID: ");
        String studentId = scanner.nextLine();

        // Check duplicate ID
        for (Student s : students) {
            if (s.getStudentId().equals(studentId)) {
                System.out.println("Student ID already exists!");
                return;
            }
        }

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Age: ");
        int age = scanner.nextInt();

        System.out.print("Enter Grade: ");
        double grade = scanner.nextDouble();
        scanner.nextLine(); // consume newline

        System.out.print("Enter Contact: ");
        String contact = scanner.nextLine();

        Student student = new Student(name, age, grade, studentId, contact);
        students.add(student);

        System.out.println("Student added successfully!");
    }

    // Method to display all students
    private static void viewAllStudents() {
        System.out.println("\n=== ALL STUDENTS ===");

        if (students.isEmpty()) {
            System.out.println("No students found!");
            return;
        }

        System.out.printf("%-15s %-20s %-8s %-8s %-15s\n",
                "Student ID", "Name", "Age", "Grade", "Contact");
        System.out.println("-".repeat(70));

        for (Student student : students) {
            System.out.printf("%-15s %-20s %-8d %-8.2f %-15s\n",
                    student.getStudentId(),
                    student.getName(),
                    student.getAge(),
                    student.getGrade(),
                    student.getContact());
        }
    }

    // Method to search student by ID
    private static void searchStudent() {
        System.out.print("Enter Student ID to search: ");
        String id = scanner.nextLine();

        for (Student student : students) {
            if (student.getStudentId().equals(id)) {
                System.out.println("\nStudent Found:");
                student.displayInfo();
                return;
            }
        }

        System.out.println("Student not found!");
    }

    // Method to update student details
    private static void updateStudent() {
        System.out.print("Enter Student ID to update: ");
        String id = scanner.nextLine();

        for (Student student : students) {
            if (student.getStudentId().equals(id)) {

                System.out.print("Enter new name: ");
                student.setName(scanner.nextLine());

                System.out.print("Enter new age: ");
                student.setAge(scanner.nextInt());

                System.out.print("Enter new grade: ");
                double grade = scanner.nextDouble();
                scanner.nextLine();
                student.setGrade(grade);

                System.out.print("Enter new contact: ");
                String contact = scanner.nextLine();
                student.setContact(contact);

                System.out.println("Student updated successfully!");
                return;
            }
        }

        System.out.println("Student not found!");
    }

    // Method to delete student
    private static void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        String id = scanner.nextLine();

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentId().equals(id)) {
                students.remove(i);
                System.out.println("Student deleted successfully!");
                return;
            }
        }

        System.out.println("Student not found!");
    }
}