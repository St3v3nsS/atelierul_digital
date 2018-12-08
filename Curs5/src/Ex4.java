import java.util.List;
import java.util.Random;

import static java.util.Arrays.asList;

public class Ex4 {

    private String[] args;

    static class Player extends Thread{

        public String option;
        @Override
        public void run(){
            List<String> options = asList("paper", "rock", "scissors");
            Integer randomOptionIndex = new Random().nextInt(3);
            this.option = options.get(randomOptionIndex);
        }
    }

    public static void main(String[] args) throws InterruptedException{
        Player player1 = new Player();
        Player player2 = new Player();

        player1.start();
        player2.start();

        player1.join();
        player2.join();

        printWinner(player1, player2);
    }

    private static void printWinner(Player player1, Player player2) {
        String opt1 = player1.option;
        String opt2 = player2.option;
        System.out.println("player1: " + opt1);
        System.out.println("Player2: " + opt2);
        if(opt1.equals(opt2)){
            System.out.println("It's a Tie!");
        }
        else if ((opt1 == "rock" && opt2 == "scissors") ||
                (opt1 == "paper" && opt2 == "rock") ||
                (opt1 == "scissors" && opt2 == "paper")){
            System.out.println("Player1 Wins!");
        }
        else{
            System.out.println("Player2 Wins!");
        }
    }
}
