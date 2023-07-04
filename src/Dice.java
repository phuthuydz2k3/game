import java.util.Random;

public class Dice
{
    private float[] faces;

    public Dice(int face20)
    {
        faces = new float[6];
        int start = 0;

        if (face20 == 0)
        {
            for (int i = 0; i < 6; i++)
            {
                start += 100 / 6;
                faces[i] = start;
            }
        }
        else
        {
            for (int i = 0; i < 6; i++)
            {
                if (i == face20 -1)
                {
                    start += 20;
                }
                else
                {
                    start += 16;
                }

                faces[i] = start;
            }
        }
    }

    public int roll()
    {
        Random rand = new Random();
        int randNum = rand.nextInt(100);

        if (randNum >= 0 && randNum < faces[0])
        {
            return 1;
        }

        for (int i = 1; i < 6; i++)
        {
            if (randNum >= faces[i - 1] && randNum < faces[i])
            {
                return i + 1;
            }
        }

        return 0;
    }
}
