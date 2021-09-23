package bank.creditdecisions;

import static bank.creditcalculators.CreditCalculator.creditAmount;

public class Negative {
  private Negative() {}

  public static void creditNegativeDecision() {
    System.out.println("В выдаче кредита отказано, сумма к выдаче: " + creditAmount);
    System.exit(0);
  }

}
