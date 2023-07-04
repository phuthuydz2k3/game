public class Player
{
    private String name;
    private int point;

    public void setPoint(int point) {
        this.point = point;
    }

    public int getPoint() {
        return point;
    }

    public Player(String name)
    {
        this.name = name;
        point = 0;
    }

    public int play(Dice dice)
    {
        int rollPoint = dice.roll();
        System.out.println(rollPoint);
        point += rollPoint;
        System.out.println(name + " point: " + point);
        if (point == 21)
        {
            return 1;
        }
        else if (point > 21)
        {
            point = 0;

            return 0;
        }

        return 0;
    }

    public String getName() {
        return name;
    }
}
