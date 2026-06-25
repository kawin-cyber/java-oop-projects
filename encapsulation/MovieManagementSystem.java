import java.util.Scanner;

// Encapsulated class
class Movie {
    private int movieId;
    private String title;
    private String genre;
    private int duration;
    private int rating;

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getMovieId() {
        return movieId;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public int getDuration() {
        return duration;
    }

    public int getRating() {
        return rating;
    }

    public void displayMovie() {
        System.out.println("Movie ID    : " + movieId);
        System.out.println("Title       : " + title);
        System.out.println("Genre       : " + genre);
        System.out.println("Duration    : " + duration + " minutes");
        System.out.println("Rating      : " + rating + "/10");
        System.out.println("------------------------------");
    }
}

public class MovieManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of movies: ");
        int n = sc.nextInt();

        Movie[] movies = new Movie[n];

        for (int i = 0; i < n; i++) {
            movies[i] = new Movie();

            System.out.println("\nEnter details of Movie " + (i + 1));

            System.out.print("Movie ID: ");
            movies[i].setMovieId(sc.nextInt());

            sc.nextLine();
            System.out.print("Title: ");
            movies[i].setTitle(sc.nextLine());

            System.out.print("Genre: ");
            movies[i].setGenre(sc.nextLine());

            System.out.print("Duration (minutes): ");
            movies[i].setDuration(sc.nextInt());

            System.out.print("Rating (out of 10): ");
            movies[i].setRating(sc.nextInt());
        }

        System.out.println("\n--- Movie Information ---");
        for (int i = 0; i < n; i++) {
            movies[i].displayMovie();
        }

        sc.close();
    }
}
