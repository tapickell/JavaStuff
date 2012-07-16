/**
 * CourseGrades Class
 * @author Todd Pickell CISS 238
 * Chapter 9
 * Programming Challenge 5 pg 640
 */
import java.text.DecimalFormat;

/**
 * class that holds all grade objects for course
 */
public class CourseGrades
{
    // fields
    private FinalExam classFinal;
    private PassFailExam classPfExam;
    private GradedActivity classLab;
    private Essay classEssay;
    private GradedActivity[] grades = {classLab, classPfExam, classEssay, classFinal};

    /**
     * constructor
     * @param Lab
     * @param PFExam
     * @param Final
     * @param essay
     */
    public CourseGrades(GradedActivity Lab, PassFailExam PFExam, FinalExam Final, Essay essay)
    {
        setLab(Lab);
        setPassFailExam(PFExam);
        setFinalExam(Final);
        setEssay(essay);
    }

    /**
     * setters
     * @param classLab
     */
    public void setLab(GradedActivity classLab)
    {
        this.classLab = classLab;
    }

    public void setPassFailExam(PassFailExam classPfExam)
    {
        this.classPfExam = classPfExam;
    }

    public void setFinalExam(FinalExam classFinal)
    {
        this.classFinal = classFinal;
    }

    public void setEssay(Essay classEssay)
    {
        this.classEssay = classEssay;
    }

    /**
     * to string method
     * @return
     */
    public String toString()
    {
        DecimalFormat f = new DecimalFormat("0.0");
        return "CourseGrades {" +
                "Essay = " + f.format(classEssay.getScore()) +" - "+ classEssay.getGrade() +
                ", Final Exam = " + f.format(classFinal.getScore()) +" - "+  classFinal.getGrade() +
                ", Pass Fail Exam = " + f.format(classPfExam.getScore()) +" - "+ classPfExam.getGrade() +
                ", Lab = " + f.format(classLab.getScore()) +" - "+ classLab.getGrade() +
                '}';
    }
}
