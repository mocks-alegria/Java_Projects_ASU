import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class ScrabbleScores {
  public static void main(String[] args) {
    ArrayList<Integer> letterScores = loadLetterScores();
    Queue<String> words = readWords();
    Stack<String> best = new Stack<>();
    System.out.println("Scrabble Scores - Maximiliano Alegria");
    Scanner in = new Scanner(System.in);
    System.out.print("How many rotations? ");
    int numRotate = in.nextInt();
    in.close();
    rotate(words, numRotate);
    int currentBest = 0;
    for (String s : words) {
      if (score(s, letterScores) > currentBest) {
        currentBest = score(s, letterScores);
        best.push(s);
      } 
    } 
    while (!best.isEmpty())
      System.out.println(" " + score(best.peek(), letterScores) + " - " + (String)best.pop()); 
  }
  
  private static int score(String s, ArrayList<Integer> l) {
    int total = 0;
    for (int i = 0; i < s.length(); i++) {
      char current = s.charAt(i);
      total += ((Integer)l.get(current - 97)).intValue();
    } 
    return total;
  }
  
  private static void rotate(Queue<String> q, int n) {
    for (int i = 0; i < n; i++)
      q.add(q.remove()); 
  }
  
  private static ArrayList<Integer> loadLetterScores() {
    ArrayList<Integer> l = new ArrayList<>();
    int[] letterScores = { 
        1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 
        5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 
        1, 4, 4, 8, 4, 10 };
    byte b;
    int i, arrayOfInt1[];
    for (i = (arrayOfInt1 = letterScores).length, b = 0; b < i; ) {
      int score = arrayOfInt1[b];
      l.add(Integer.valueOf(score));
      b++;
    } 
    return l;
  }
  
  private static Queue<String> readWords() {
    Queue<String> words = new LinkedList<>();
    try {
      File inputFile = new File(System.getProperty("user.dir") + File.separator + "words.txt");
      Scanner in = new Scanner(inputFile);
      while (in.hasNext())
        words.add(in.next().toLowerCase()); 
      in.close();
    } catch (FileNotFoundException f) {
      System.out.println("Cannot file file 'words.txt' in the project directory.");
      System.exit(1);
    } 
    return words;
  }
}