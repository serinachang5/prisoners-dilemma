/**
 * This class both determines and inflicts punishment upon the prisoners, based on their plays
 * in a given round. It also stores the immutable rules of the game as constants.
 * @author Serina Chang - sc3003
 */
public class Judger
{
    private static final int[] DEF_COO = {0,6};
    private static final int[] COO_COO = {1,1};
    private static final int[] COO_DEF = {6,0};
    private static final int[] DEF_DEF = {3,3};
    
    private int[] judgment;

    public Judger()
    {
        judgment = null;
    }
    
    public void judge(Choice choice1, Choice choice2)
    {
        if (choice1 == Choice.DEFECT && choice2 == Choice.COOPERATE)
        {
            judgment = DEF_COO;
        }
        else if (choice1 == Choice.COOPERATE && choice2 == Choice.COOPERATE)
        {
            judgment = COO_COO;
        }
        else if (choice1 == Choice.COOPERATE && choice2 == Choice.DEFECT)
        {
            judgment = COO_DEF;
        }
        else
        {
            judgment = DEF_DEF;
        }
    }
    
    public void punish(Prisoner prisoner1, Prisoner prisoner2)
    {
        prisoner1.incScore(judgment[0]);
        prisoner2.incScore(judgment[1]);
    }
}