/**
 * @author Todd Pickell CISS 238
 *         Programming Discussion 2
 *
 *         Describe a programming problem that would require the use of an accumulator.
 *         Write the pseudo code necessary to solve your programming problem.
 *         Explain why you chose to solve the problem in that way.
 *         
 *         Any problem that would require you to tally
 *         up a total value from a bunch of values one at a time.
 *         I would use an accumulator to do something 
 *         like add a bunch of numbers from
 *         an array than output the average.
 *
 *         I choose to solve the problem in this way because
 *         it seems to be a good way to get the desired results.
 *         An easier way would be if arrays had a get sum method
 *         that you could call then you would not need an accumulator.
 *
 *         I guess if I really wanted I could write a class that extends
 *         the array class and adds methods using overloading to sum
 *         arrays of ints, floats, doubles, etc. But not strings or objects.
 *
 *         Nevermind, I just tried that in another class and I cant
 *         locate the actual Arrays class to extend from java.lang so
 *         I tried to extend Integer to give it a sumIt method for an
 *         array of Integers, but I got an error that I cant extend
 *         final Integer.
 *         Oh well. It looks like the for loop / accumulator combo wins.
 *
 */

public class Accumulator
{
	public static void AverageIt()
	{
		//my accumulator variable
		int myAccumulator = 0;

		//my average variable
		int average;

		//my array that stores a bunch of integers
		int[] myArray = {5,3,8,4,6,3,6,9,5,3,4,9,6};

		//a for loop to iterate through the values stored in my array
		//and add then to the accumulator
		for (int i = 0; i < myArray.length; i++)
		{
			myAccumulator += myArray[i];
		}

		//calculates the average and stores it to my average variable
		average = (myAccumulator / myArray.length);

		System.out.println("Average: " + average);
	}

}

