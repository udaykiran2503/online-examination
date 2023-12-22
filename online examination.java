import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class OnlineExamination {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // User Login
        System.out.println("Welcome to the Online Examination!");
        System.out.println("Please enter your username:");
        String username = scanner.nextLine();
        System.out.println("Please enter your password:");
        String password = scanner.nextLine();

        if (!isValidLogin(username, password)) {
            System.out.println("Invalid login credentials. Please try again.");
            return;
        }

        // Exam Start Time
        long startTime = System.currentTimeMillis();

        // Exam Duration in minutes
        int examDuration = 60; // Set exam duration in minutes
        long endTime = startTime + examDuration * 60 * 1000; // Calculate exam end time in milliseconds

        // Exam Questions and Answers
        String[] questions = {"What is the capital of India?", "What is the largest river in the world?",
                "What is the smallest country in the world?"};
        String[][] answerOptions = {{"Mumbai", "Delhi", "Kolkata"}, {"Nile River", "Amazon River", "Yangtze River"},
                {"Vatican City", "Monaco", "San Marino"}};
        int[] correctAnswers = {2, 2, 1};

        // Start Exam Timer
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Exam time is over. Please submit your answers.");
            }
        }, endTime - System.currentTimeMillis());

        // Question Answering and Score Calculation
        int score = 0;
        for (int i = 0; i < questions.length; i++) {
            System.out.println("Question " + (i + 1) + ": " + questions[i]);
            for (int j = 0; j < answerOptions[i].length; j++) {
                System.out.println(j + 1 + ". " + answerOptions[i][j]);
            }

            int answer = scanner.nextInt();
            if (answer == correctAnswers[i]) {
                score++;
            }
        }

        // Exam Finish Time and Score Display
        long finishTime = System.currentTimeMillis();
        System.out.println("Exam finished. Your score is: " + score);

        scanner.close();
    }

    private static boolean isValidLogin(String username, String password) {
        // Implement user login validation logic here
        // (e.g., checking against a database or hardcoded credentials)
        return username.equals("admin") && password.equals("password");
    }
}