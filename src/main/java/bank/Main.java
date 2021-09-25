package bank;

import bank.creditcalculators.CreditCalculator;

public class Main {
  public static void main(String[] args) {
    CreditCalculator calculator = new CreditCalculator();
    calculator.calculateCredit(18,
        "F",
        "собственный бизнес",
        2,
        -1,
        10,
        15,
        "ипотека");
  }
}