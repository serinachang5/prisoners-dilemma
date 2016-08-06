/**
 * This class offers multiple ways of testing the game. First we have a Round Robin simulation,
 * which tests every possible match (Lucifer vs. Jesus, Lucifer vs. Randomizer, etc.). Round Robin 
 * is appropriate for testing many rounds at a time, since only the final scores from each match
 * and the total scores tallied from all the matches are printed. Second we have a detailed version, 
 * which prints out the plays and updated scores from each round. The detailed version is appropriate
 * for close-testing and not too many rounds should be played per match, or else the printed output can
 * be overwhemling. Other versions of the game (e.g. play and interact with a live user?) may be added.
 * @author Serina Chang - sc3003
 */
public class Game
{
    private Prisoner[] prisoners;    
    private Judger myJudger;    
    private int[] scoreboard;
    
    public Game()
    {
        prisoners = new Prisoner[4];
        myJudger = new Judger();
        scoreboard = new int[prisoners.length];
        
        Prisoner mySatan = new Satan();        
        Prisoner myJesus = new Jesus();
        Prisoner myRandomizer = new Randomizer();
        Prisoner myTitForTat = new TitForTat(); 
        prisoners = new Prisoner[4];
        prisoners[0] = mySatan;
        prisoners[1] = myJesus;
        prisoners[2] = myRandomizer;
        prisoners[3] = myTitForTat;        
    }
    
    public void cleanBoard()
    {
        for (int i = 0; i < scoreboard.length; i++)
        {
            scoreboard[i] = 0;
        }
    }
    
    public void roundRobin(int rounds)
    {
        this.cleanBoard();
        System.out.println("Welcome to Prisoner's Dilemma! Check out this Round Robin simulation.");        
        int match = 1;
        //test each pairing with Round Robin
        for (int i = 0; i < prisoners.length; i++)
        {
            for (int j = i+1; j < prisoners.length; j++)
            {
                Prisoner prisoner1 = prisoners[i];
                prisoner1.setScore(0);
                Prisoner prisoner2 = prisoners[j];
                prisoner2.setScore(0);
                System.out.println("\n" + "Match " + match + ": " + prisoner1.getName() +
                    " vs. " + prisoner2.getName());
                for (int trial = 0; trial < rounds; trial++)
                {
                    Choice pris1Play = prisoner1.makePlay(prisoner2.getLastPlay());
                    Choice pris2Play = prisoner2.makePlay(prisoner1.getLastPlay());
                    myJudger.judge(pris1Play, pris2Play);
                    myJudger.punish(prisoner1, prisoner2);
                    prisoner1.setLastPlay(pris1Play);
                    prisoner2.setLastPlay(pris2Play);
                }
                System.out.println(prisoner1.getName() + ": " + prisoner1.getScore());
                scoreboard[i] += prisoner1.getScore();
                System.out.println(prisoner2.getName() + ": " + prisoner2.getScore());
                scoreboard[j] += prisoner2.getScore();
                match++;
            }
        }
        System.out.println("\n" + "FINAL STATS:");
        for (int i = 0; i < prisoners.length; i++)
        {
            System.out.println(prisoners[i].getName() + " received " + scoreboard[i] + " years in total.");
        }
        System.out.println("");
    }
    
    public void giveDetails(int rounds)
    {
        this.cleanBoard();
        System.out.println("Welcome to Prisoner's Dilemma! Check out this detailed simulation.");
        int match = 1;
        for (int i = 0; i < prisoners.length; i++)
        {
            for (int j = i+1; j < prisoners.length; j++)
            {
                Prisoner prisoner1 = prisoners[i];
                prisoner1.setScore(0);
                Prisoner prisoner2 = prisoners[j];
                prisoner2.setScore(0);
                System.out.println("\n" + "Match " + match + ": " + prisoner1.getName() +
                    " vs. " + prisoner2.getName());
                for (int trial = 0; trial < rounds; trial++)
                {
                    Choice pris1Play = prisoner1.makePlay(prisoner2.getLastPlay());
                    System.out.println(prisoner1.getName() + " played " + pris1Play);
                    Choice pris2Play = prisoner2.makePlay(prisoner1.getLastPlay());
                    System.out.println(prisoner2.getName() + " played " + pris2Play);
                    myJudger.judge(pris1Play, pris2Play);
                    myJudger.punish(prisoner1, prisoner2);
                    System.out.println(prisoner1.getName() + "'s updated score is " + prisoner1.getScore());
                    System.out.println(prisoner2.getName() + "'s updated score is " + prisoner2.getScore());
                    prisoner1.setLastPlay(pris1Play);
                    prisoner2.setLastPlay(pris2Play);
                }
                System.out.println("RESULTS OF THIS ROUND");
                System.out.println(prisoner1.getName() + ": " + prisoner1.getScore());
                scoreboard[i] += prisoner1.getScore();
                System.out.println(prisoner2.getName() + ": " + prisoner2.getScore());
                scoreboard[j] += prisoner2.getScore();
                match++;
            }
        }
        System.out.println("\n" + "FINAL STATS");
        for (int i = 0; i < prisoners.length; i++)
        {
            System.out.println(prisoners[i].getName() + " received " + scoreboard[i] + " years in total.");
        }
    }
}
        
                    