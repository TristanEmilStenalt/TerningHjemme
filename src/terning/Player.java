package terning;

public class Player
{
    private String name;
    private int score;
    private int position;


    public Player(String name, int score, int position) //Constructor of player-object
    {
        this.name = name;
        this.score = score;
        this.position = position;

    }


    //get & set methods

    //get & set name
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    //get & set score
    public int getScore()
    {
        return score;
    }
    public void setScore(int score)
    {
        this.score = score;
    }

    //get & set score
    public int getPosition()
    {
        return position;
    }
    public void setPosition(int position)
    {
        this.position = position;
    }

}
