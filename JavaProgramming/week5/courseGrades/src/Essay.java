/**
 * Essay Class
 * @author Todd Pickell CISS 238
 * Chapter 9
 * Programming Challenge 5 pg 640
 */

/**
 * class from previous problem created to be used in this problem
 * it takes in each sub grade the calculates the total grade
 * this inherits from GradedActivity class
 */
public class Essay extends GradedActivity
{
    // final fields
    private final int grammarPossible = 30;
    private final int spellingPossible = 20;
    private final int lengthPossible = 20;
    private final int contentPossible = 30;
    private final int overallPossible = 100;

    // fields
    private int grammarGrade;
    private int spellingGrade;
    private int lengthGrade;
    private int contentGrade;
    private int overallGrade;

    /**
     * constructor
     * @param grammar
     * @param spelling
     * @param length
     * @param content
     */
    public Essay(int grammar, int spelling, int length, int content)
    {
        setGrammarGrade(grammar);
        setSpellingGrade(spelling);
        setLengthGrade(length);
        setContentGrade(content);
        setOverallGrade();
        setScore(getOverallGrade());  // inherited method

    }

    /**
     * setters and getters
     * @return
     */
    public int getGrammarGrade()
    {
        return grammarGrade;
    }

    public void setGrammarGrade(int grammarGrade)
    {
        this.grammarGrade = grammarGrade;
    }

    public int getSpellingGrade()
    {
        return spellingGrade;
    }

    public void setSpellingGrade(int spellingGrade)
    {

        this.spellingGrade = spellingGrade;
    }

    public int getLengthGrade()
    {
        return lengthGrade;
    }

    public void setLengthGrade(int lengthGrade)
    {
        this.lengthGrade = lengthGrade;
    }

    public int getContentGrade()
    {
        return contentGrade;
    }

    public void setContentGrade(int contentGrade)
    {
        this.contentGrade = contentGrade;
    }

    public int getOverallGrade()
    {
        return overallGrade;
    }

    /**
     * this setter actually calculates the overall grade for the class
     * by adding all of the sub grades
     */
    public void setOverallGrade()
    {
        int grades = grammarGrade + spellingGrade + lengthGrade + contentGrade;
        this.overallGrade = grades;
    }

    public int getGrammarPossible()
    {
        return grammarPossible;
    }

    public int getSpellingPossible()
    {
        return spellingPossible;
    }

    public int getLengthPossible()
    {
        return lengthPossible;
    }

    public int getContentPossible()
    {
        return contentPossible;
    }

    public int getOverallPossible()
    {
        return overallPossible;
    }
}
