/**
 * An abstract representation of a prisoner who has a score and name. His or her 
 * main responsibility is to make a choice whether to cooperate or defect under
 * interrogation. After making this decision, his or her last play is stored.
 * @author Serina Chang - sc3003
 */
public abstract class Prisoner
{
    Choice lastPlay;
    int score;
    String name;
    abstract Choice makePlay(Choice oppLastPlay);
    Choice getLastPlay()
    {
        return lastPlay;
    }
    void setLastPlay(Choice play)
    {
        lastPlay = play;
    }
    void incScore(int points)
    {
        score += points;
    }
    int getScore()
    {
        return score;
    }
    void setScore(int newScore)
    {
        score = newScore;
    }
    String getName()
    {
        return name;
    }
}
    