import java.util.Random;

public class Bot extends Player
{
    public Bot(String name)
    {
        super(name);
    }

    public void loseBehavior()
    {
        Random rand = new Random();
        int option = rand.nextInt(3);

        if (option == 1)
        {
            System.out.println("I'm losed");
        }
        else if (option == 2)
        {
            System.out.println(this.getName() + "quited");
        }
    }
}
