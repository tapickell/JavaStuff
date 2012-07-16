/**
 * CourseGrades Demo
 * @author Todd Pickell CISS 238
 * Chapter 9
 * Programming Challenge 5 pg 640
 */

/**
 *  This class computes a curved grade. It inherits   
 *  from the GradedActivity class.
 */

public class CurvedActivity extends GradedActivity
{
   double rawScore,     // Unadjusted score
          percentage;   // Curve percentage

   /**
    *  The constructor accepts the curve percentage  
    *  as an argument.
    */

   public CurvedActivity(double percent)
   {
      percentage = percent;
      rawScore = 0.0;
   }

   /**
    *  The setScore method overrides the superclass  
    *  setScore method. This version accepts the     
    *  unadjusted score as an argument. That score   
    *  is multiplied by the curve percentage and the 
    *  result is sent as an argument to the          
    *  superclass's setScore method.
    */

   public void setScore(double s)
   {
      rawScore = s;
      super.setScore(rawScore * percentage);
   }

   /**
    *  The getRawScore method returns the rawScore   
    *  field.
    */

   public double getRawScore()
   {
      return rawScore;
   }

   /**
    *  The getPercentage method returns the          
    *  percentage field.
    */

   public double getPercentage()
   {
      return percentage;
   }
}