/**
 * CourseGrades Demo
 * @author Todd Pickell CISS 238
 * Chapter 9
 * Programming Challenge 5 pg 640
 */
import java.util.Scanner;

/**
 * class to demo course grades class
 */
public class CourseGradesDemo
{
    /**
     * main method for demo program
     * creates grade objects and passes them to
     * instance of courseGradesClass
     * then calls the toString method from
     * the courseGradesClass
     * @param args
     */
    public static void main(String[] args)
    {
        //main menu to enter grades
        System.out.println("Term 1 grades.");
        String MissString = "Enter number of questions MISSED:";
        //create objects & get scores
        GradedActivity Lab = getLabScores();
        Essay essay = getEssayScores();
        PassFailExam PassFail = getPassFailExamScores(MissString);
        FinalExam Final = getFinalExamScores(MissString);
        //create course grades object
        CourseGrades grades = new CourseGrades(Lab, PassFail, Final, essay);
        System.out.println(grades.toString());
    }

    /**
     * method that takes a string to prompt user then
     * gets input and validates it and returns a
     * PassFailExam object
     * @param missString
     * @return
     */
    public static PassFailExam getPassFailExamScores(String missString)
    {
        //get pass fail exam scores
        System.out.println("Pass Fail Exam Score:\n10 questions total:");
        int quest = 10;
        int miss = validateInput(missString, 0, quest);
        double min = 70;
        return new PassFailExam(quest, miss, min);
    }

    /**
     * method that takes a string to prompt user then
     * gets input and validates it and returns a
     * FinalExam object
     * @param missString
     * @return
     */
    public static FinalExam getFinalExamScores(String missString)
    {
        //get final exam scores
        System.out.println("Final Exam Score:\n50 questions total:");
        int fquest = 50;
        int fmiss = validateInput(missString, 0, fquest);
        return new FinalExam(fquest,fmiss);
    }

    /**
     * method that gets input from user and
     * validates it then returns an Essay object
     * @return
     */
    public static Essay getEssayScores()
    {
        //get essay scores
        System.out.println("Essay Score:");
        int gram = validateInput("Enter Grammar points: (0-30)", 0, 30); //grammar
        int spell = validateInput("Enter Spelling points: (0-20)", 0, 20);  //spelling
        int len = validateInput("Enter Length points: (0-20)", 0, 20);  //length
        int cont = validateInput("Enter Content points: (0-30)", 0, 30);  //content
        return new Essay(gram, spell, len, cont);
    }

    /**
     * method that gets input from user and
     * validates it then returns an Lab object
     * @return
     */
    public static GradedActivity getLabScores()
    {
        //get lab scores
        GradedActivity Lab = new GradedActivity();
        Lab.setScore(validateInput("Enter score for lab activity: (0-100)", 0, 100));
        return Lab;
    }

    /**
     * my method that prints string passed in then
     * gets input from the user
     * @param stringIn
     * @return
     */
    public static int getIntInput(String stringIn)
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.println(stringIn);
        return keyboard.nextInt();
    }

    /**
     * my method that prints string passed in then
     * gets input from the user
     * @param stringIn
     * @return
     */
    public static double getDblInput(String stringIn)
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.println(stringIn);
        return keyboard.nextDouble();
    }

    /**
     * my method that prints string passed in then
     * gets input from the user
     * @param stringIn
     * @return
     */
    public static String getStringInput(String stringIn)
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.println(stringIn);
        return keyboard.next();
    }

    /**
     * method used to validate input from the user
     * gets passed a string for user prompt also
     * a minimum value and a maximum value
     * to check against for validation
     * if input is out of range it will continue
     * to prompt user for correct input then returns
     * the input only after it passes validation
     * @param stringIn
     * @param min
     * @param max
     * @return
     */
    public static int validateInput(String stringIn, int min, int max)
    {
        int objVar = getIntInput(stringIn);
        while(objVar > max || objVar < min)
        {
            System.out.println("Invalid Entry!\nTry Again:");
            objVar = getIntInput(stringIn);
        }
        return objVar;
    }
}

