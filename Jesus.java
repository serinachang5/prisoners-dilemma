/**
 * Jesus is a prisoner who always cooperates, regardless of the opponent's plays.
 * @author Serina Chang - sc3003
 */
public class Jesus extends Prisoner
{   
    public Jesus()
    {
        lastPlay = null;
        name = "Jesus";
    }
    
    public Choice makePlay(Choice oppLastPlay)
    {
        Choice play = Choice.COOPERATE;
        return play;
    }
}