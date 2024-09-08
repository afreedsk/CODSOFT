import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizApp
{
    private static final int TOTAL_QUESTIONS = 10;  // Number of questions
    private static final int TIME_LIMIT = 10;  // Time limit per question in seconds
    private static String[] questions = {
        "1. What is the capital of India?\n(a) Mumbai\n(b) New Delhi\n(c) Kolkata\n(d) Chennai",
        "2. Who is known as the Father of the Nation in India?\n(a) Jawaharlal Nehru\n(b) Sardar Patel\n(c) Mahatma Gandhi\n(d) Subhas Chandra Bose",
        "3. What is the national animal of India?\n(a) Lion\n(b) Elephant\n(c) Bengal Tiger\n(d) Peacock",
        "4. In which year did India gain independence?\n(a) 1945\n(b) 1947\n(c) 1950\n(d) 1952",
        "5. What is the national sport of India?\n(a) Cricket\n(b) Hockey\n(c) Kabaddi\n(d) Badminton",
        "6. Which river is known as the Ganges of the South?\n(a) Yamuna\n(b) Godavari\n(c) Kaveri\n(d) Krishna",
        "7. What is the national flower of India?\n(a) Rose\n(b) Sunflower\n(c) Lotus\n(d) Marigold",
        "8. Who was the first President of India?\n(a) Dr. Rajendra Prasad\n(b) Dr. A.P.J. Abdul Kalam\n(c) S. Radhakrishnan\n(d) Zakir Husain",
        "9. What is the official language of India?\n(a) Hindi\n(b) English\n(c) Sanskrit\n(d) Tamil",
        "10. Who wrote the Indian National Anthem?\n(a) Rabindranath Tagore\n(b) Bankim Chandra Chatterjee\n(c) Sarojini Naidu\n(d) Mahatma Gandhi"
    };
    
    private static char[] answers = {'b', 'c', 'c', 'b', 'b', 'c', 'c', 'a', 'a', 'a'};  // Correct answers
    private static int score = 0;
    private static boolean timeOut;

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < TOTAL_QUESTIONS; i++)
        {
            timeOut = false;
            System.out.println(questions[i]);
            
            // Timer setup
            Timer timer = new Timer();
            timer.schedule(new TimerTask() 
            {
                @Override
                public void run() 
                {
                    timeOut = true;
                    System.out.println("\nTime's up! Moving to the next question.");
                }
            }, TIME_LIMIT * 1000);

            // Take user input
            char userAnswer = scanner.next().charAt(0);
            
            // Cancel the timer if the user answers within the time
            timer.cancel();

            if (!timeOut && userAnswer == answers[i]) 
            {
                System.out.println("Correct!\n");
                score++;
            } else if (!timeOut) 
            {
                System.out.println("Wrong! The correct answer is: " + answers[i] + "\n");
            }
        }
        
        // Display the score at the end
        System.out.println("Quiz Over! Your final score is: " + score + " out of " + TOTAL_QUESTIONS);
        scanner.close();
    }
}
