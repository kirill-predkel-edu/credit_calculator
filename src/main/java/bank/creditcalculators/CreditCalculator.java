package bank.creditcalculators;

public class CreditCalculator {

  public static boolean areValidationRulesPassed = true;
  public double annualPayment = 0;
  public boolean isCreditTaken = false;
  int creditAmount = 0;

  ValidationRules validationRules = new ValidationRules();
  AnnualPaymentCalculator annualPaymentCalculator = new AnnualPaymentCalculator();
  CreditAmountCalculator creditAmountCalculator = new CreditAmountCalculator();
  ModifiersCalculator modifiersCalculator = new ModifiersCalculator();

  public void calculateCredit(
      int age,
      String gender,
      String incomeSource,
      int annualIncome,
      int creditRate,
      double requestedAmount,
      int creditTerm,
      String purpose) {

    //Валидация на соответствие условиям выдачи кредита
    validationRules.validateApplicant(age, gender, incomeSource, annualIncome, creditRate,
        requestedAmount, creditTerm);

    if (areValidationRulesPassed) {
      //Расчёт доступной для выдачи суммы кредита
      creditAmount = creditAmountCalculator.calculateCreditAmount(incomeSource, creditRate);

      //Расчёт кредитного модификатора
      double creditModifier = modifiersCalculator.calculateModifiers(creditRate, purpose, requestedAmount,
          incomeSource);

      //Расчёт годового платежа
      annualPayment = annualPaymentCalculator.calculateAnnualPayment(creditModifier, creditAmount, creditTerm);
    }

    //Валидация годового платежа
    validationRules.validateAnnualPayment(annualPayment, annualIncome);

    if (areValidationRulesPassed) {
      //Сообщение пользователю результата по заявке на кредит
      creditPositiveDecision(annualPayment, creditAmount);
      isCreditTaken = true;
    }
  }

  static void creditNegativeDecision() {
    System.out.println("В выдаче кредита отказано");
    areValidationRulesPassed = false;
  }

  void creditPositiveDecision(double annualPayment, int creditAmount) {
    System.out.format("Заявка на кредит одобрена на сумму %d млн, годовой платёж составляет: %.2f млн ", creditAmount,
        annualPayment);
  }
}