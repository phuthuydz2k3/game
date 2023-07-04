import java.util.Random;

public class Bot extends Player implements Lose
{
    public Bot(String name)
    {
        super(name);
    }

    @Override
    public int loseBehavior()
    {
        Random rand = new Random();
        int option = rand.nextInt(3);

        if (option == 1)
        {
            System.out.println(this.getName() + ": GG");

            return 1;
        }
        else if (option == 2)
        {
            System.out.println(this.getName() + ": I'm quit");

            return 2;
        }
        else
        {
            System.out.println(this.getName() + ": Bad game!");
        }

        return 0;
    }
}
