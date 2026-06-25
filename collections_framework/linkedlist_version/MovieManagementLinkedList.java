import java.util.*;

class Movie {
    int movieId;
    String title;
    String genre;
    int duration;
    int rating;

    void displayMovie() {
        System.out.println("\nMovie ID    : " + movieId);
        System.out.println("Title       : " + title);
        System.out.println("Genre       : " + genre);
        System.out.println("Duration    : " + duration + " minutes");
        System.out.println("Rating      : " + rating + "/10");
        System.out.println("------------------------------");
    }
}

public class MovieManagementLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Movie> movieList = new LinkedList<>();

        int choice = 0;

        while (choice != 5) {
            System.out.println("\n===== Movie Management System =====");
            System.out.println("1. Add Movie");
            System.out.println("2. Display Movies");
            System.out.println("3. Search Movie by ID");
            System.out.println("4. Delete Movie");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            if (choice == 1) {
                Movie m = new Movie();

                System.out.print("Enter Movie ID: ");
                m.movieId = sc.nextInt();

                sc.nextLine();
                System.out.print("Enter Title: ");
                m.title = sc.nextLine();

                System.out.print("Enter Genre: ");
                m.genre = sc.nextLine();

                System.out.print("Enter Duration: ");
                m.duration = sc.nextInt();

                System.out.print("Enter Rating: ");
                m.rating = sc.nextInt();

                movieList.add(m);
                System.out.println("Movie added successfully!");

            } else if (choice == 2) {
                if (movieList.isEmpty()) {
                    System.out.println("No movies found!");
                } else {
                    for (Movie movie : movieList) {
                        movie.displayMovie();
                    }
                }

            } else if (choice == 3) {
                System.out.print("Enter Movie ID to search: ");
                int searchId = sc.nextInt();
                boolean found = false;

                for (Movie movie : movieList) {
                    if (movie.movieId == searchId) {
                        movie.displayMovie();
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Movie not found!");
                }

            } else if (choice == 4) {
                System.out.print("Enter Movie ID to delete: ");
                int deleteId = sc.nextInt();
                boolean deleted = false;

                Iterator<Movie> it = movieList.iterator();

                while (it.hasNext()) {
                    Movie movie = it.next();
                    if (movie.movieId == deleteId) {
                        it.remove();
                        deleted = true;
                        System.out.println("Movie deleted successfully!");
                        break;
                    }
                }

                if (!deleted) {
                    System.out.println("Movie not found!");
                }

            } else if (choice == 5) {
                System.out.println("Exiting program...");

            } else {
                System.out.println("Invalid choice!");
            }
        }

        sc.close();
    }
}
