package bank.creditcalculators;

import static bank.creditcalculators.ModifiersCalculator.calculateModifiers;
import static bank.creditcalculators.ValidationRules.validateApplicant;

public class CreditCalculator {

  public static double creditAmount = 0.0;
  public static double creditModifier = 0.0;

  public void calculateCredit(
      int age,
      String gender,
      String incomeSource,
      double annualIncome,
      int creditRate,
      int requestedAmount,
      int loanTerm,
      String purpose) {

    validateApplicant(age, gender, incomeSource, annualIncome, creditRate, requestedAmount, loanTerm);
    creditModifier = calculateModifiers(creditRate, purpose, requestedAmount, incomeSource);
  }
}