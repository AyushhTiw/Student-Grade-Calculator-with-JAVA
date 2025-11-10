import java.util.Scanner;

class Student {
    String name;
    String studentID;
    int[] grades;

    // Constructor
    Student(String name, String studentID, int[] grades) {
        this.name = name;
        this.studentID = studentID;
        this.grades = grades;
    }

    // Calculate average marks
    double calculateAverage() {
        int sum = 0;
        for (int grade : grades) sum += grade;
        return (double) sum / grades.length;
    }

    // Display individual grades
    void displayGrades() {
        System.out.print("Grades: ");
        for (int grade : grades) System.out.print(grade + " ");
        System.out.println();
    }

    // Determine pass/fail
    boolean hasPassed() {
        return calculateAverage() >= 33; // pass mark is 33%
    }

    // Determine grade based on average
    String getGrade(double avg) {
        if (avg >= 90)
            return "A1 GRADE";
        else if (avg >= 80)
            return "A2 GRADE";
        else if (avg >= 70)
            return "B1 GRADE";
        else if (avg >= 60)
            return "B2 GRADE";
        else if (avg >= 50)
            return "C1 GRADE";
        else if (avg >= 40)
            return "C2 GRADE";
        else if (avg >= 33)
            return "D1 GRADE";
        else
            return "FAIL";
    }
}

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for student " + (i + 1) + ":");
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Student ID: ");
            String id = sc.nextLine();

            System.out.print("Enter number of subjects: ");
            int subjects = sc.nextInt();
            int[] grades = new int[subjects];

            for (int j = 0; j < subjects; j++) {
                System.out.print("Enter grade for subject " + (j + 1) + ": ");
                grades[j] = sc.nextInt();
            }
            sc.nextLine(); 

            students[i] = new Student(name, id, grades);
        }

        double totalAverage = 0;
        System.out.println("\n----- STUDENT RESULTS -----");
        for (Student s : students) {
            s.displayGrades();
            double avg = s.calculateAverage();
            totalAverage += avg;

            System.out.println("Student: " + s.name + " (" + s.studentID + ")");
            System.out.printf("Average Percentage: %.2f%n", avg);
            System.out.println("Grade: " + s.getGrade(avg));
            System.out.println("Status: " + (s.hasPassed() ? "Passed" : "Failed"));
            System.out.println("----------------------------");
        }

        System.out.printf("Class Average: %.2f%n", (totalAverage / n));
        sc.close();
    }
}
