/**
 * CourseGrades Demo
 * @author Todd Pickell CISS 238
 * Chapter 9
 * Programming Challenge 5 pg 640
 */

/**
 *  Relatable interface 
 */

public interface Relatable
{
   boolean equals(GradedActivity g);
   boolean isGreater(GradedActivity g);
   boolean isLess(GradedActivity g);
}