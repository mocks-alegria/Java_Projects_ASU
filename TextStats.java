import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TextStats {
  public static void main(String[] args) {
    File iFile = null;
    File oFile = null;
    boolean switch1 = false;
    boolean switch2 = false;
    Scanner scnr = new Scanner(System.in);
    Scanner reader = null;
    PrintWriter writer = null;
    while (!switch1) {
      try {
        System.out.printf("Input file: ", new Object[0]);
        iFile = new File(scnr.nextLine());
        reader = new Scanner(iFile);
        switch1 = true;
      } catch (FileNotFoundException fnfe) {
        System.out.printf("File %s cannot be found. Please try again.\n", new Object[] { iFile.getName() });
      } 
    } 
    while (!switch2) {
      try {
        System.out.printf("Output file: ", new Object[0]);
        String fileName = scnr.nextLine();
        oFile = new File(fileName);
        if (!oFile.exists())
          try {
            oFile.createNewFile();
          } catch (IOException ioe) {
            throw new RuntimeException("This should never happen, the file was just created", ioe);
          }  
        writer = new PrintWriter(oFile);
        switch2 = true;
      } catch (FileNotFoundException fnfe) {
        System.out.printf("\n File %s cannot be found. Please try again.", new Object[] { oFile.getName() });
      } 
    } 
    calculateStats(reader, writer, iFile, oFile);
    scnr.close();
    reader.close();
    writer.close();
  }
  
  private static void calculateStats(Scanner reader, PrintWriter writer, File iFile, File oFile) {
    String letter = null;
    char ch = ' ';
    int whiteSpace = 0;
    int digits = 0;
    int uppercase = 0;
    int lowercase = 0;
    int other = 0;
    int total = 0;
    reader.useDelimiter("");
    while (reader.hasNext()) {
      letter = reader.next();
      ch = letter.charAt(0);
      if (Character.isWhitespace(ch)) {
        whiteSpace++;
        total++;
        continue;
      } 
      if (Character.isDigit(ch)) {
        digits++;
        total++;
        continue;
      } 
      if (Character.isUpperCase(ch)) {
        uppercase++;
        total++;
        continue;
      } 
      if (Character.isLowerCase(ch)) {
        lowercase++;
        total++;
        continue;
      } 
      other++;
      total++;
    } 
    writer.println("=================================");
    writer.printf("= Text Analysis for %s\n", new Object[] { iFile.getName() });
    writer.println("= ACO102 - Maximiliano Alegria ");
    writer.println("=================================");
    writer.println("");
    writer.printf("\tWhitespace%9d%7.2f%%\n", new Object[] { Integer.valueOf(whiteSpace), Double.valueOf(whiteSpace / total * 100.0D) });
    writer.printf("\tDigits%13d%7.2f%%\n", new Object[] { Integer.valueOf(digits), Double.valueOf(digits / total * 100.0D) });
    writer.printf("\tUppercase%10d%7.2f%%\n", new Object[] { Integer.valueOf(uppercase), Double.valueOf(uppercase / total * 100.0D) });
    writer.printf("\tLowercase%10d%7.2f%%\n", new Object[] { Integer.valueOf(lowercase), Double.valueOf(lowercase / total * 100.0D) });
    writer.printf("\tOther%14d%7.2f%%\n", new Object[] { Integer.valueOf(other), Double.valueOf(other / total * 100.0D) });
    writer.println("\t------------ ------\n");
    writer.printf("\tTotal%14d", new Object[] { Integer.valueOf(total) });
  }
}
