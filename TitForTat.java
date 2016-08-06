/**
 * TitForTat is a prisoner who plays what the opponent played in the last round. 
 * If it is the first round, TitForTat cooperates.
 * @author Serina Chang - sc3003
 */
public class TitForTat extends Prisoner
{   
    public TitForTat()
    {
        lastPlay = null;
        name = "TitForTat";
    }
    
    public Choice makePlay(Choice oppLastPlay) //opponent's last play
    {
        Choice play = null;
        if (oppLastPlay == null)
        {
            play = Choice.COOPERATE;
        }
        else
        {
            play = oppLastPlay;
        }
        return play;
    }   
}