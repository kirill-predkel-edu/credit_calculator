package bank.creditcalculators;

import static bank.creditdecisions.Negative.creditNegativeDecision;

class ValidationRules {

  public static void validateApplicant(
      int age,
      String gender,
      String incomeSource,
      double annualIncome,
      int creditRate,
      int requestedAmount,
      int loanTerm) {

    if (age + loanTerm >= 65 && gender.equals("M") || age + loanTerm >= 60 && gender.equals("F")) {
      creditNegativeDecision();
    }
    if ((double) requestedAmount / loanTerm > annualIncome / 3) {
      creditNegativeDecision();
    }
    if (creditRate < -1) {
      creditNegativeDecision();
    }
    if (incomeSource.equalsIgnoreCase("безработный")) {
      creditNegativeDecision();
    }
  }
}