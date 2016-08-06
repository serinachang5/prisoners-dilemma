/**
 * Lucifer is a prisoner who always defects, regardless of the opponent's plays.
 * @author Serina Chang - sc3003
 */
public class Lucifer extends Prisoner
{
    public Lucifer()
    {
        lastPlay = null;
        name = "Lucifer";
    }
    
    public Choice makePlay(Choice oppLastPlay)
    {
        Choice play = Choice.DEFECT;
        return play;
    }
}