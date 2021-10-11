import java.util.Random;
import java.util.Scanner;

public class Assignment3 {
    public static void main(String[] args) {
        a();
    }

    public static void a() {
        Scanner scanner = new Scanner(System.in);
        String inputString = "";
        int[] score;
        String[] alternatives = {"rock", "scissors", "paper"};
        String[] methods = {"crushes", "cuts", "covers"};
        boolean quit = false, isWinner;

        while(!quit) {
            b();
            isWinner = false;
            score = new int[2];

            while(!quit && !isWinner) {
                System.out.println("Make your choice (rock, paper or scissors): ");
                inputString = scanner.nextLine().trim();

                if(inputString.equalsIgnoreCase("Q")) {
                    System.out.println("Bye!");
                    quit = true;
                }

                else {
                    int input = -1;

                    for(int i = 0; i < alternatives.length; i ++) {
                        if(alternatives[i].equalsIgnoreCase(inputString)) {
                            input = i;
                        }
                    }

                    if(input == -1) {
                        System.out.println("Invalid input. Valid input is rock, paper or scissors.");
                    }

                    else {

                        int computerChoice = new Random().nextInt(3);
                        System.out.println("Computer chooses " + alternatives[computerChoice] + ".");

                        if((computerChoice - 1) == input || (computerChoice + 2) == input) {
                            score[0] ++;
                            System.out.println("Your " + alternatives[input] + " " + methods[input] + " computers " +
                                    alternatives[computerChoice] + " (" + score[0] + " - " + score[1] + ").");
                        }

                        else if(computerChoice == input) {
                            System.out.println("Same choise, no winner.");
                        }

                        else {

                            score[1] ++;
                            System.out.println("Computers " + alternatives[computerChoice] + " " + methods[computerChoice] +
                                    " your " + alternatives[input] + " (" + score[0] + " - " + score[1] + ").");
                        }
                        isWinner = c(score);
                    }
                }
            }
        }
        scanner.close();
    }

    public static void b() {
        System.out.println("** WELCOME TO ROCK-PAPER-SCISSORS **");
        System.out.println("The game where rock crushes scissors, scissors cuts paper and paper covers rock. Best of five wins.");
        System.out.println("Terminate program by typing Q.");
    }

    public static boolean c(int[] a) {

        if(a[0] == 3 || a[1] == 3) {
            String winner = "Computer";

            if(a[0] == 3) {
                winner = "You";
            }
            System.out.println(winner + " have won (" + a[0] + " - " + a[1] + ")!");
            return true;
        }

        else {
            return false;
        }
    }
}