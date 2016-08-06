/**
 * Satan is a prisoner who always defects, regardless of the opponent's plays.
 * @author Serina Chang - sc3003.
 * Theological correctness ensured by Kara Schechtman - kws2121.
 */
public class Satan extends Prisoner
{
    public Satan()
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