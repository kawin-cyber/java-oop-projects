import java.util.Scanner;

class StudentInfo {
    int rollNo;
    String name;
    int age;
    String department;
    int marks;

    // Parameterized Constructor
    StudentInfo(int r, String n, int a, String d, int m) {
        rollNo = r;
        name = n;
        age = a;
        department = d;
        marks = m;
    }

    // Display Method
    void display() {
        System.out.println("Roll Number : " + rollNo);
        System.out.println("Name        : " + name);
        System.out.println("Age         : " + age);
        System.out.println("Department  : " + department);
        System.out.println("Marks       : " + marks);
        System.out.println("--------------------------");
    }
}

public class StudentInformationSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        StudentInfo[] students = new StudentInfo[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details of Student " + (i + 1));

            System.out.print("Roll Number: ");
            int roll = sc.nextInt();

            sc.nextLine(); // consume newline
            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Age: ");
            int age = sc.nextInt();

            sc.nextLine();
            System.out.print("Department: ");
            String dept = sc.nextLine();

            System.out.print("Marks: ");
            int marks = sc.nextInt();

            students[i] = new StudentInfo(roll, name, age, dept, marks);
        }

        System.out.println("\n--- Student Information ---");
        for (int i = 0; i < n; i++) {
            students[i].display();
        }

        sc.close();
    }
}
