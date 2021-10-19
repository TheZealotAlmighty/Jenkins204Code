import java.util.Scanner;

public class Main
{
  public static void main(String[] args) {
    System.out.println("This is a calculator.\nEnter a command: ");
    Scanner in = new Scanner(System.in);
    String arg1 = in.next();
    Calculator calculator = new Calculator();
    if (arg1.equals("add")) {
      int val1 = in.nextInt();
      int val2 = in.nextInt();
      System.out.println(calculator.add(val1, val2));
    } else if (arg1.equals("subtract")) {
      int val1 = in.nextInt();
      int val2 = in.nextInt();
      System.out.println(calculator.subtract(val1, val2));
    } else if (arg1.equals("multiply")) {
      int val1 = in.nextInt();
      int val2 = in.nextInt();
      System.out.println(calculator.multiply(val1, val2));
    } else if (arg1.equals("divide")) {
      int val1 = in.nextInt();
      int val2 = in.nextInt();
      System.out.println(calculator.divide(val1, val2));
    } else if (arg1.equals("fibonacci")) {
      int val = in.nextInt();
      System.out.println(calculator.fibonacciNumberFinder(val));
    } else if (arg1.equals("binary")) {
      int val = in.nextInt();
      System.out.println(calculator.intToBinaryNumber(val));
    }
  }
}
