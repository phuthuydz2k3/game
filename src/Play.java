import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Play
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int numPlayer;
        Player[] players = new Player[4];
        Dice[] dices = new Dice[6];
        List<Bot> bots = new ArrayList<>();
        bots.add(new Bot("Bot Alpha"));
        bots.add(new Bot("Bot Beta"));
        bots.add(new Bot("Bot Gamma"));
        bots.add(new Bot("Bot Omega"));

        System.out.print("Enter number of players: ");
        numPlayer = in.nextInt();
        in.nextLine();

        for (int i = 0; i < numPlayer; i++)
        {
            String name;

            System.out.print("Enter name of players " + (i + 1) + ": ");
            name = in.nextLine();

            players[i] = new Player(name);
        }
        for (int i = numPlayer; i < 4; i++)
        {
            players[i] = new Bot("Bot " + (i + 1));
        }

        dices[0] = new Dice(1);
        dices[1] = new Dice(2);
        dices[2] = new Dice(3);
        dices[3] = new Dice(4);
        dices[4] = new Dice(0);
        dices[5] = new Dice(0);

        while (true)
        {
            int nextPlayer;
            int nextDice;
            Random rand = new Random();

            for (int i = 0; i < 4; i++)
            {
                System.out.println(players[i].getName() + " choose by enter " + (i + 1));
            }
            System.out.print("Enter the next player: ");
            nextPlayer = in.nextInt();
            in.nextLine();
            nextDice = rand.nextInt(6) + 1;

            int result = players[nextPlayer - 1].play(dices[nextDice - 1]);

            if (result == 1)
            {
                win(players[nextPlayer - 1]);
                for (int i = 0; i < 4; i++)
                {
                    if (i != nextPlayer - 1 && players[i] instanceof Bot)
                    {
                        if (((Bot) players[i]).loseBehavior() == 2)
                        {
                            System.out.println(players[i].getName() + " quited");
                            players[i] = bots.get(rand.nextInt(4));
                            System.out.println(players[i].getName() + " enters the game");
                            System.out.println("****************************\nStart Again!");

                            break;
                        }
                    }
                }

                for (int i = 0; i < 4; i++)
                {
                    players[i].setPoint(0);
                }
            }
        }
    }
    private static void win(Player winner)
    {
        System.out.println("The winner is " + winner.getName());
    }
}
