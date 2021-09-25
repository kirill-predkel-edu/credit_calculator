package bank;

import bank.creditcalculators.CreditCalculator;

public class Main {
  public static void main(String[] args) {
    CreditCalculator calculator = new CreditCalculator();
    calculator.calculateCredit(18,
        "F",
        "безработный",
        2,
        1,
        5,
        10,
        "ипотека");
  }
}
