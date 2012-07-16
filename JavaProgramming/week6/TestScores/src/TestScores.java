/**
 * TestScores
 * @author Todd Pickell CISS 238
 * Chapter 10
 * Programming Challenge 1 pg 697
 */

public class TestScores
{
	private int[] _scores;
	private int _avg;

    /**
     * calls validateScoresCreateAverage and stores that in the _avg field
     * then if exception is not thrown stores the
     * array in _scores field
     * @param scores
     * @throws IllegalArgumentException
     */
	public TestScores(int[] scores)   throws IllegalArgumentException
	{    		
		_avg = validateScoresCreateAverage(scores);
		_scores = scores;
	}

    /**
     * tests each score for within range
     * if not throws illegal arg exception to calling code
     * then adds scores to avg, then calculates and returns
     * the average score as an int
     * @param scores
     * @return
     */
	private int validateScoresCreateAverage(int[] scores)
	{
		int avg = 0;
		for(int i =0; i < scores.length; i++)
		{
			if(scores[i] < 0 || scores[i] > 100)
				throw new IllegalArgumentException("Score for test #"+ (i+1) + " out of range.");
			avg += scores[i];
		}
        return (avg / scores.length);
	}

    /**
     * getter method to be called by demo program to retrieve the avg score
     * @return
     */
	public int getAverage()
	{
		return _avg;
	}
}
