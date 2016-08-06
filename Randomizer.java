/**
 * Randomizer is a prisoner who plays randomly, regardless of the opponent's plays.
 * @author Serina Chang - sc3003
 */
import java.util.Random;

public class Randomizer extends Prisoner
{
    private Choice lastPlay;
    
    public Randomizer()
    {
        lastPlay = null;
        name = "Randomizer";
    }
    
    public Choice makePlay(Choice oppLastPlay)
    {
        Choice play = null;
        Random myRandom = new Random();
        int randomNum = myRandom.nextInt(2);
        if (randomNum == 0)
        {
            play = Choice.COOPERATE;
        }
        else
        {
            play = Choice.DEFECT;
        }
        return play;
    }
}