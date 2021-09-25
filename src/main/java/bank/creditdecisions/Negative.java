package bank.creditdecisions;

public class Negative {
  private Negative() {}

  public static void creditNegativeDecision() {
    System.out.println("В выдаче кредита отказано");
    System.exit(0);
  }

}
