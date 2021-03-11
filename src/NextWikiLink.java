//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: NextWikiLink
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


import java.io.IOException;
import java.util.function.Function;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.util.Scanner;

/**
 * @author Sheriff class generates wiki links given certain specifications
 *
 */
public class NextWikiLink implements Function<String, String> {

  /*
   * (non-Javadoc)
   * 
   * @see java.util.function.Function#apply(java.lang.Object)
   */
  @Override
  public String apply(String t) {
    try {
      // Download a Wikipedia page, using t in their internal link format: /wiki/Some_Subject
      Document doc = Jsoup.connect("https://en.wikipedia.org" + t).get();
      // Use .css selector to retrieve a collection of links from this page's description
      // "p a" selects links within paragraphs
      // ":not([title^='Help'])" skips pronunciations
      // ":not(sup a)" skips citations
      Elements links = doc.select("p a:not([title^='Help']):not(sup a)");
      // return the link attribute from the first element of this list
      return links.get(0).attr("href");
      // Otherwise return an appropriate error message:
    } catch (IOException | IllegalArgumentException e) {
      return "FAILED to find wikipedia page: " + t;
    } catch (IndexOutOfBoundsException e) {
      return "FAILED to find a link in wikipedia page: " + t;
    }
  }

  /**
   * @param args
   */
  public static void main(String[] args) {

    // prompts the user to enter a topic name and number of iterations to follow
    Scanner scnr = new Scanner(System.in);
    System.out.print("Enter a wikipedia page topic: ");
    String topic = scnr.nextLine();
    System.out.print("Enter the number of pages you'd like to step through: ");
    int pages = scnr.nextInt();
    scnr.close();
    // prepends "/wiki/" to the user's input, and replace spaces with underscores
    topic = "/wiki/" + topic;
    topic = topic.replaceAll(" ", "_");
    // uses a for-each loop to iterate through the number of links requested
    Generator<String> gen = new Generator<String>(topic, new NextWikiLink(), pages);
    for (String string : gen) {
      System.out.println(string);
    }

  }
}
