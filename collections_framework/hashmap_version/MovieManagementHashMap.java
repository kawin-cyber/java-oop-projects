import java.util.*;

class Movie {
    int movieId;
    String title;
    String genre;
    int duration;
    int rating;

    Movie(int movieId, String title, String genre, int duration, int rating) {
        this.movieId = movieId;
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.rating = rating;
    }

    void displayMovie() {
        System.out.println("Movie ID    : " + movieId);
        System.out.println("Title       : " + title);
        System.out.println("Genre       : " + genre);
        System.out.println("Duration    : " + duration + " minutes");
        System.out.println("Rating      : " + rating + "/10");
        System.out.println("------------------------------");
    }
}

public class MovieManagementHashMap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashMap<Integer, Movie> movieMap = new HashMap<>();
        int choice;

        do {
            System.out.println("\n===== Movie Management System =====");
            System.out.println("1. Add Movie");
            System.out.println("2. View All Movies");
            System.out.println("3. Search Movie by ID");
            System.out.println("4. Delete Movie");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter Movie ID: ");
                int id = sc.nextInt();

                sc.nextLine();
                System.out.print("Enter Title: ");
                String title = sc.nextLine();

                System.out.print("Enter Genre: ");
                String genre = sc.nextLine();

                System.out.print("Enter Duration: ");
                int duration = sc.nextInt();

                System.out.print("Enter Rating: ");
                int rating = sc.nextInt();

                Movie m = new Movie(id, title, genre, duration, rating);
                movieMap.put(id, m);

                System.out.println("Movie added successfully!");

            } else if (choice == 2) {
                if (movieMap.isEmpty()) {
                    System.out.println("No movies available.");
                } else {
                    System.out.println("\n--- Movie List ---");
                    for (Movie m : movieMap.values()) {
                        m.displayMovie();
                    }
                }

            } else if (choice == 3) {
                System.out.print("Enter Movie ID to search: ");
                int id = sc.nextInt();

                if (movieMap.containsKey(id)) {
                    movieMap.get(id).displayMovie();
                } else {
                    System.out.println("Movie not found.");
                }

            } else if (choice == 4) {
                System.out.print("Enter Movie ID to delete: ");
                int id = sc.nextInt();

                if (movieMap.containsKey(id)) {
                    movieMap.remove(id);
                    System.out.println("Movie deleted successfully.");
                } else {
                    System.out.println("Movie not found.");
                }

            } else if (choice == 5) {
                System.out.println("Exiting program...");
            } else {
                System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}
