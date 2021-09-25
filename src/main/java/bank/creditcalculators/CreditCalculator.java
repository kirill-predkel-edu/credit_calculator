package bank.creditcalculators;

import static bank.creditcalculators.AnnualPaymentCalculator.calculateAnnualPayment;
import static bank.creditcalculators.CreditAmountCalculator.calculateCreditAmount;
import static bank.creditcalculators.ModifiersCalculator.calculateModifiers;
import static bank.creditcalculators.ValidationRules.validateAnnualPayment;
import static bank.creditcalculators.ValidationRules.validateApplicant;
import static bank.creditdecisions.Positive.creditPositiveDecision;

public class CreditCalculator {

  public static double creditAmount;
  public static double creditModifier;
  public static double annualPayment;

  public void calculateCredit(
      int age,
      String gender,
      String incomeSource,
      int annualIncome,
      int creditRate,
      int requestedAmount,
      int creditTerm,
      String purpose) {

    validateApplicant(age, gender, incomeSource, annualIncome, creditRate, requestedAmount, creditTerm);
    creditModifier = calculateModifiers(creditRate, purpose, requestedAmount, incomeSource);
    creditAmount = calculateCreditAmount(incomeSource, creditRate);
    annualPayment = calculateAnnualPayment(creditModifier, creditAmount, creditTerm);
    validateAnnualPayment(annualPayment, annualIncome);
    creditPositiveDecision(annualPayment);
  }
}