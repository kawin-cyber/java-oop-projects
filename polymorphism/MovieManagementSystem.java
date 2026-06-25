import java.util.*;

class MovieManager {

    void trackMovie(int movieId) {
        System.out.println("Tracking Movie ID: " + movieId);
        System.out.println("Movie ID: " + movieId + " is currently available in theaters.");
    }

    void trackMovie(String title) {
        System.out.println("Tracking movie with title: " + title);
        System.out.println("Movie \"" + title + "\" is available for streaming.");
    }

    void trackMovie(String title, String director) {
        System.out.println("Tracking movie \"" + title + "\" directed by " + director);
        System.out.println("Movie \"" + title + "\" by " + director + " is scheduled for release.");
    }
}

public class MovieManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MovieManager mm = new MovieManager();

        System.out.println("Welcome to the Movie Management System");

        String again = "yes";
        while (again.equalsIgnoreCase("yes")) {
            System.out.println("\nSelect tracking option:");
            System.out.println("1. Track by Movie ID");
            System.out.println("2. Track by Movie Title");
            System.out.println("3. Track by Movie Title and Director");
            System.out.print("Enter your choice (1-3): ");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Enter the Movie ID: ");
                int movieId = sc.nextInt();
                sc.nextLine();
                mm.trackMovie(movieId);
            } else if (choice == 2) {
                System.out.print("Enter the Movie Title: ");
                String title = sc.nextLine();
                mm.trackMovie(title);
            } else if (choice == 3) {
                System.out.print("Enter the Movie Title: ");
                String title = sc.nextLine();
                System.out.print("Enter the Director Name: ");
                String director = sc.nextLine();
                mm.trackMovie(title, director);
            } else {
                System.out.println("Invalid choice! Please select a valid option.");
            }

            System.out.print("\nDo you want to track another movie? (yes/no): ");
            again = sc.nextLine();
        }

        System.out.println("Thank you for using the Movie Management System!");
        sc.close();
    }
}
