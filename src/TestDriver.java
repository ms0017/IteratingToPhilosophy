//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: Test driver
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


import java.util.function.Function;

public class TestDriver {

  public static boolean testEvenNumbers() {
    EvenNumbers it = new EvenNumbers(44);
    if (it.next() != 44) {
      System.out.println("The first call of EvenNumbers.next() "
          + "did not return the value passed into its constructor.");
      return false;
    }
    if (it.next() != 46) {
      System.out.println(
          "The second call of EvenNumbers.next() " + "did not return the smallest even number, "
              + "that is larger than the previously returned number.");
      return false;
    }
    if (it.hasNext() != true) {
      System.out.println("EvenNumbers.next() returned false, " + "but should always return true.");
      return false;
    }
    return true;
  }


  public static boolean testPowersOfTwo() {
    InfiniteIterator<Integer> it = new InfiniteIterator<>(8, new NextPowerOfTwo());
    if (it.next() != 8) {
      System.out.println("The first call of InfiniteIterator.next() "
          + "did not return the number passed into its constructor.");
      return false;
    }
    if (!it.next().equals(16)) {
      System.out.println("The second call of InfiniteIterator.next() "
          + "did not return the smallest power of two number, "
          + "that is larger than the previously returned number.");
      return false;
    }
    if (it.hasNext() != true) {
      System.out
          .println("InfiniteIterator.next() returned false, " + "but should always return true.");
      return false;
    }
    return true;
  }


  public static boolean testAddExtraSmile() {
    InfiniteIterator<String> it = new InfiniteIterator<>("Hello", new AddExtraSmile());
    if (!it.next().equals("Hello")) {
      System.out.println("The first call of InfiniteIterator.next() "
          + "did not return the string passed into its constructor.");
      return false;
    }
    if (!it.next().contains(" :)")) {
      System.out.println("The second call of InfiniteIterator.next() "
          + "did not return the a string with one more :), "
          + "than the previously returned string.");
      return false;
    }
    if (it.hasNext() != true) {
      System.out
          .println("InfiniteIterator.next() returned false, " + "but should always return true.");
      return false;
    }
    return true;
  }

  public static boolean testFiniteIterator() {
    FiniteIterator<Integer> it =
        new FiniteIterator<>(new InfiniteIterator<Integer>(2, new NextPowerOfTwo()), 8);
    String s = "";
    while (it.hasNext())
      s += " " + it.next();
    if (!s.equals(" 2 4 8 16 32 64 128 256")) {
      System.out.println("Repeatedly called the next() method of a FiniteIterator,"
          + "and the incorrect valuese were returned:" + s);
      return false;
    }
    return true;
  }


  public static boolean testGenerator() {
    // creates and assigns an instance of a generator
    Generator<Integer> gen = new Generator<Integer>(2, new NextPowerOfTwo(), 5);
    // to concatenate the values returned from the generator call
    String s = "";
    // using an enhanced for loop to concatenate values
    for (int inte : gen) {
      s += inte + " ";
    }
    // reaturn a boolean if there is a match
    return s.equals("2 4 8 16 32 ");
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    // testing even numbers
    if (testEvenNumbers()) {
      System.out.println("Passed");
    } else {
      System.out.println("Failed");
    }
    // testing the powers of two
    if (testPowersOfTwo()) {
      System.out.println("Passed");
    } else {
      System.out.println("Failed");
    }
    // testing the smile
    if (testAddExtraSmile()) {
      System.out.println("Passed");
    } else {
      System.out.println("Failed");
    }
    // testing the finite iterator
    if (testFiniteIterator()) {
      System.out.println("Passed");
    } else {
      System.out.println("Failed");
    }
    // testing the generator
    if (testGenerator()) {
      System.out.println("Passed");
    } else {
      System.out.println("Failed");
    }
  }
}


class NextPowerOfTwo implements Function<Integer, Integer> {
  @Override
  public Integer apply(Integer previous) {
    return 2 * previous;
  }
}


class AddExtraSmile implements Function<String, String> {
  @Override
  public String apply(String t) {
    return t + " :)";
  }
}

