package terning;

import java.util.Random;

public class Dice
{


    public int roll(int sides)
    {
        Random rand = new Random(); //Make an instance of Random
        int roll = rand.nextInt(sides); //Random int between [0;max[ +1 ... therefore [1;max]

        return roll+1;
    }






}
