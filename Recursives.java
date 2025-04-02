import java.util.ArrayList;

public class Recursives {
  public static void main(String[] args) {
    System.out.println("Recursives - Maximiliano Alegria\n");
    System.out.println("Factors:");
    System.out.printf("   %7d: %s%n", new Object[] { Integer.valueOf(24), factors(24) });
    System.out.printf("   %7d: %s%n", new Object[] { Integer.valueOf(105), factors(105) });
    System.out.printf("   %7d: %s%n%n", new Object[] { Integer.valueOf(3783780), factors(3783780) });
    System.out.println("Binary:");
    System.out.printf("   %7d: %s%n", new Object[] { Integer.valueOf(24), toBinary(24) });
    System.out.printf("   %7d: %s%n", new Object[] { Integer.valueOf(105), toBinary(105) });
    System.out.printf("   %7d: %s%n%n", new Object[] { Integer.valueOf(3783780), toBinary(3783780) });
    System.out.println("Reverse:");
    System.out.printf("   %s: %s%n", new Object[] { "Hello!", reverse("Hello!") });
    System.out.printf("   %s: %s%n", new Object[] { "Madam, I'm Adam", reverse("Madam, I'm Adam") });
    System.out.printf("   %s: %s%n", new Object[] { "amanaplanacanalpanama", reverse("amanaplanacanalpanama") });
    System.out.printf("   %s: %s%n%n", new Object[] { "This is a test of Double Reverse!!", 
          reverse(reverse("This is a test of Double Reverse!!")) });
    System.out.println("Polygon:");
    ArrayList<Double> points = new ArrayList<>();
    points.add(Double.valueOf(1.0D));
    points.add(Double.valueOf(3.0D));
    points.add(Double.valueOf(1.0D));
    points.add(Double.valueOf(7.0D));
    points.add(Double.valueOf(3.0D));
    points.add(Double.valueOf(9.0D));
    points.add(Double.valueOf(8.0D));
    points.add(Double.valueOf(8.0D));
    points.add(Double.valueOf(9.0D));
    points.add(Double.valueOf(4.0D));
    points.add(Double.valueOf(8.0D));
    points.add(Double.valueOf(1.0D));
    points.add(Double.valueOf(4.0D));
    points.add(Double.valueOf(1.0D));
    System.out.printf("   %f%n", new Object[] { Double.valueOf(polygon(points)) });
  }
  
  private static ArrayList<Integer> factors(int f) {
    ArrayList<Integer> factors = new ArrayList<>();
    factors(f, factors);
    return factors;
  }
  
  private static void factors(int f, ArrayList<Integer> l) {
    int divisor = 0;
    if (f > 1) {
      for (int i = 2; i <= f; i++) {
        if (f % i == 0 && 
          isPrime(i)) {
          divisor = i;
          break;
        } 
      } 
      l.add(Integer.valueOf(divisor));
      f /= divisor;
      factors(f, l);
    } 
  }
  
  private static String toBinary(int n) {
    if (n == 1)
      return "1"; 
    if (n == 0)
      return "0"; 
    if (n % 2 == 0)
      return String.valueOf(toBinary(n / 2)) + "0"; 
    return String.valueOf(toBinary(n / 2)) + "1";
  }
  
  private static String reverse(String s) {
    if (s.length() <= 1)
      return s; 
    char Temp = s.charAt(0);
    char Temp2 = s.charAt(s.length() - 1);
    s = s.substring(1, s.length() - 1);
    return String.valueOf(Temp2) + reverse(s) + Temp;
  }
  
  private static double polygon(ArrayList<Double> p) {
    if (p.size() == 6)
      return Math.abs(((Double)p.get(0)).doubleValue() * ((Double)p.get(3)).doubleValue() + ((Double)p.get(2)).doubleValue() * ((Double)p.get(5)).doubleValue() + ((Double)p.get(4)).doubleValue() * ((Double)p.get(1)).doubleValue() - ((Double)p.get(1)).doubleValue() * ((Double)p.get(2)).doubleValue() - ((Double)p.get(3)).doubleValue() * ((Double)p.get(4)).doubleValue() - ((Double)p.get(5)).doubleValue() * ((Double)p.get(0)).doubleValue()) / 2.0D; 
    double a = Math.abs(((Double)p.get(0)).doubleValue() * ((Double)p.get(3)).doubleValue() + ((Double)p.get(2)).doubleValue() * ((Double)p.get(5)).doubleValue() + ((Double)p.get(4)).doubleValue() * ((Double)p.get(1)).doubleValue() - ((Double)p.get(1)).doubleValue() * ((Double)p.get(2)).doubleValue() - ((Double)p.get(3)).doubleValue() * ((Double)p.get(4)).doubleValue() - ((Double)p.get(5)).doubleValue() * ((Double)p.get(0)).doubleValue()) / 2.0D;
    p.remove(2);
    p.remove(2);
    return a + polygon(p);
  }
  
  private static boolean isPrime(int n) {
    for (int j = 2; j <= n / 2; j++) {
      if (n % j == 0)
        return false; 
    } 
    return true;
  }
}