//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: generator
// Files: jsoup-1.10.3.jar
// Course: CS 300, spring, and 2019
//
// Author: Sheriff Issaka
// Email: issaka@wisc.edu
// Lecturer's Name: Gary
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: (name of your pair programming partner)
// Partner Email: (email address of your programming partner)
// Partner Lecturer's Name: (name of your partner's lecturer)
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// ___ Write-up states that pair programming is allowed for this assignment.
// ___ We have both read and understand the course Pair Programming Policy.
// ___ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: NONE
// Online Sources: NONE
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////


import java.util.Iterator;
import java.util.function.Function;

/**
 * @author Sheriff
 *
 * @param <T> class generates values based on user specifications
 */
public class Generator<T> implements Iterable<T> {
  // boolean to be used later
  Boolean selected;
  // stores the first value
  T firstValue;
  // instance of function
  Function<T, T> generateNextFromLast;
  // tracking length
  int length;


  /**
   * @param firstValue
   * @param generateNextFromLast generates values given 2 parameters
   */
  public Generator(T firstValue, Function<T, T> generateNextFromLast) {
    // assigning appropriate class variables
    this.firstValue = firstValue;
    this.generateNextFromLast = generateNextFromLast;
    // choosing to make my boolean true for this instance
    selected = true;
  }

  /**
   * @param firstValue
   * @param generateNextFromLast
   * @param length               generates values given 3 parameters
   */
  public Generator(T firstValue, Function<T, T> generateNextFromLast, int length) {
    // assigning appropriate class variables
    this.firstValue = firstValue;
    this.length = length;
    this.generateNextFromLast = generateNextFromLast;
    // choosing to make my boolean false for this instance
    selected = false;
  }


  @Override
  public Iterator<T> iterator() {
    // if boolean is true or if the infinite is used,
    if (selected) {
      // returns the corresponding infinite value
      return new InfiniteIterator<T>(firstValue, generateNextFromLast);
    } else {
      // returns the corresponding finite value
      return new FiniteIterator<T>(new InfiniteIterator<T>(firstValue, generateNextFromLast),
          length);
    }
  }

}
