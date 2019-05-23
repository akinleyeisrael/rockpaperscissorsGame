package rockpapersis;

import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Rockpapersis {
    //method to convert the integers to string
    public static String ConvertToString(int choice) {
        String rock = "Rock";
        String Paper = "Paper";
        String Scissors = "Scissors";
        switch (choice) {
            case 1:
                return rock;
            case 2:
                return Paper;
            default:
                break;
        }
        return Scissors;
    }
    //to create random numbers between 1 to 3
    public static void Computer(int RandomNum) {
        Random rand = new Random();
        RandomNum = rand.nextInt(3) + 1;    //generates random numbers between 1 and 3
    }
    //main method
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Welcome to Rock Paper Scissors Game");
        Object[] options = {"Human X Computer",
                "Human X Human",};
            int choice = JOptionPane.showOptionDialog(null,
                    "CHOOSE YOUR GAME?",
                    "Rock Paper Scissors Game",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    options,
                    null);
            switch (choice) {
                case 0:
                  PlayGame();    //if chose is human vs computer execute the playgame method
                    break;
                case 1:
                  Human();  
                default:
                    System.exit(0);
                    break;
            }
//        PlayGame();   ///called the method for it to execute
        Human();
    }   //end of main method
    
     public static void PlayGame() {
        JFrame frame = new JFrame();
        int PlayerTotalWins = 0;
        int ComputerWins = 0;
        int TotalGamePlayed = 0;
        int Play = 1;   //play is 1

        while (Play == 1) {   //while play is 1 while loop executes
            int PlayerChoice;
            String UserInput = JOptionPane.showInputDialog(frame, "Enter  [1]  for paper  [2]  for rock  [3]  for scissors");
            PlayerChoice = Integer.parseInt(UserInput);
            if (PlayerChoice > 3 || PlayerChoice < 1) {
                JOptionPane.showMessageDialog(frame, "Wrong input, input number between 1 and 3", "", JOptionPane.ERROR_MESSAGE);
            }

            int val;
            Random rand = new Random();
            val = rand.nextInt(3) + 1;
            int ComputerChoice = val;

            Computer(ComputerChoice);   //call the method computer to run the randomnumber generated

            if (PlayerChoice >= 1 && PlayerChoice <= 3) {  //if player choice is between 1 and 3 execute if not do not print
                PrintResult(PlayerChoice, ComputerChoice);
                TotalGamePlayed++;   //increment number of games played
            }
            //option dialog for options
            Object[] options = {"Yes",
                "No",};
            int choice = JOptionPane.showOptionDialog(null,
                    "Do you want to try again?",
                    "Enjoyed the game",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    options,
                    null);
            switch (choice) {
                case 0:
                    Play = 1;            //if yes play is initialised to 1 then while loop re-executes
                    break;
                case 1:
                    System.out.println("\nTotal Games played : " + TotalGamePlayed + " Game(s)");
                
                default:
                    System.exit(0);
                    break;
            }
        }
    }
    //method to print result
    public static String PrintResult(int player, int computer) {
        //contains two parameter that represent player choice and computer choice
        System.out.println("Player choice :" + ConvertToString(player));   //only one parameter can be passed
        System.out.println("computer choice : " + ConvertToString(computer));
        //logic for the winner 1.represent rock 2.paper 3.scissors
        if (player == computer) {
            JOptionPane.showMessageDialog(null, "It a TIE,nobody wins");
        }if (player == 2 && computer == 1 || player == 1 && computer == 3 || player == 3 && computer == 2) {
            JOptionPane.showMessageDialog(null, "You win!!");         
        }if (computer == 3 && player == 2 || computer == 2 && player == 1 || computer == 1 && player == 3) {
            JOptionPane.showMessageDialog(null, "Computer won!!");      
        }
        return null;
    }
    
    
//method for human vs human
    public static void Human() {
        int Player1_TotalWins = 0;
        int Player2_TotalWins = 0;
        int TotalGamePlayed = 0;
        
        for (int play = 1; play == 1;) {
            int player1;
            int player2;
            String UserInput1;
            String UserInput2;

            UserInput1 = JOptionPane.showInputDialog(null, "Enter  [1]  for paper  [2]  for rock  [3]  for scissors", "PLAYER 1", JOptionPane.INFORMATION_MESSAGE);
            player1 = Integer.parseInt(UserInput1);
            if (player1 > 3 || player1 < 1) {
                JOptionPane.showMessageDialog(null, "Wrong input, input number between 1 and 3", "", JOptionPane.ERROR_MESSAGE);
            }

            UserInput2 = JOptionPane.showInputDialog(null, "Enter  [1]  for paper  [2]  for rock  [3]  for scissors", "PLAYER 2", JOptionPane.INFORMATION_MESSAGE);
            player2 = Integer.parseInt(UserInput2);
            if (player2 > 3 || player2 < 1) {
                JOptionPane.showMessageDialog(null, "Wrong input, input number between 1 and 3", "", JOptionPane.ERROR_MESSAGE);
            }

            if (player1 >= 1 && player1 <= 3 && player2 >= 1 && player2 <= 3) {   //if the value inputed is correct do this
                System.out.println("Player 1 choice : " + ConvertToString(player1));  //reuse the convertToString method 
                System.out.println("Player 2 choice : " + ConvertToString(player2));

                if (player1 == player2) {
                    JOptionPane.showMessageDialog(null, "It a TIE,nobody wins");
                } else if (player1 == 2 && player2 == 1 || player1 == 1 && player2 == 3 || player1 == 3 && player2 == 2) {
                    JOptionPane.showMessageDialog(null, "player 1 wins!!");
                    Player1_TotalWins++;   //increment variable if player one wins
                } else if (player2 == 3 && player1 == 2 || player2 == 2 && player1 == 1 || player2 == 1 && player1 == 3) {
                    JOptionPane.showMessageDialog(null, "player 2 wins!!");
                    Player2_TotalWins++;      // increment variable if player two wins
                }
                TotalGamePlayed++;  //increment total game played
            } else {
                JOptionPane.showMessageDialog(null, "Wrong values were inputed", "", JOptionPane.WARNING_MESSAGE);
                System.out.println("No game(s) counted");
            }

            Object[] options = {"Yes",
                "No",};
            int choice = JOptionPane.showOptionDialog(null,
                    "Do you want to try again?",
                    "Rock Paper Scissors Game",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    options,
                    null);
            switch (choice) {
                case 0:
                    play = 1;            //if yes play is initialised to 1 then while loop re-executes
                    break;
                case 1:
                    System.out.println("\nTotal Games played  : " + TotalGamePlayed + " Game(s)");
                     System.out.println("Player 1 Total Wins : " + Player1_TotalWins + " Game(s)");
                     System.out.println("Player 2 Total Wins : " + Player2_TotalWins + " Game(s)");
                default:
                    System.exit(0);
                    break;
            }
        }   //for loop ends here
    }    //Human method ends here
}   //class ends here


