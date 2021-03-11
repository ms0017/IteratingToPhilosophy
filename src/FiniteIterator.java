//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: Finite iterator
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

/**
 * @author Sheriff
 *
 * @param <T>
 *  class regulates finite values
 */
public class FiniteIterator<T> implements Iterator<T> {
  // keeping count
  int count;
  // a new infinite to be used below
  InfiniteIterator<T> infinite;

  /**
   * @param infinite
   * @param length
   *  constructor to assign values
   */
  public FiniteIterator(InfiniteIterator<T> infinite, int length) {
    // assigning infinite
    this.infinite = infinite;
    // assigning count
    count = length;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.util.Iterator#hasNext()
   * checks if there is a next value
   */
  @Override
  public boolean hasNext() {
    // return a boolean depending on the length of count
    return count > 0;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.util.Iterator#next()
   * returns the next value
   */
  @Override
  public T next() {
    // if there is a next
    if (count > 0) {
      // decrease the count
      count--;
      // return the appropriate next value
      return infinite.next();
    } else {
      // return null if count is invalid
      return null;

    }


  }

}
