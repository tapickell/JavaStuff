/**
 * TestScores Demo
 * @author Todd Pickell CISS 238
 * Chapter 10
 * Programming Challenge 1 pg 697
 */

import java.util.Scanner;

/**
 * demo program that uses the TestScores
 * prompts user for number of scores to enter
 * creates an array of that size then prompts
 * user for each score to enter into array
 * then gets the average of the scores by
 * calling the .getAverage method of the class
 */
public class TestScoresDemo
{
	public static void main(String[] args)
	{
		int[] scoresArray = getArray(getIntInput("Scores for last test:\nHow many tests would you like to enter?"));
		try
		{
			TestScores theseScores = new TestScores(scoresArray);
			System.out.println("\nAverage score for test: " + theseScores.getAverage());
		}
		catch (IllegalArgumentException e)
		{
			System.out.println("I'm sorry, you entered an invalid test score.\nPlease check your scores and run the application again.\n" + e.getMessage());
		}
	}

    /**
     * method to prompt user for test scores
     * and add scores to the array
     * @param intIn
     * @return int[]
     */
	public static int[] getArray(int intIn)
	{
		int[] scores = new int[intIn];
		for (int i = 0; i < scores.length; i++)
		{
			scores[i] = getIntInput("Enter score for test #" + (i+1));
		}
		return scores;
	}

    /**
     * my method that prints string passed in then
     * gets input from the user
     * @param stringIn
     * @return int
     */
	public static int getIntInput(String stringIn)
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.println(stringIn);
		return keyboard.nextInt();
	}
}
