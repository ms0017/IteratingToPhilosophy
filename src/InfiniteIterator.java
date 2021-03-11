//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: infinite iterator
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
 * @param <T> this class regulates infinite values
 */
public class InfiniteIterator<T> implements Iterator<T> {
  // int to keep count of iterations
  int count = 0;
  // storing integer
  T a; // the next element
  Function<T, T> f;

  /**
   * @param input this method assigns the user's input
   */
  public InfiniteIterator(T input, Function<T, T> funtion) {
    // assigning the user input to the class variable
    a = input;
    f = funtion;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.util.Iterator#hasNext() checking if there is a next value
   */
  @Override
  public boolean hasNext() {
    // because we are generating new numbers every time,
    // there is always a next
    // hence returning true each time
    return true;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.util.Iterator#next() this method creates the next variable
   */
  @Override
  public T next() {
    // storing value to be returned
    T toReturn = a;
    // updating a to the next value
    a = f.apply(a);
    // returning stored value
    return toReturn;
  }
}
