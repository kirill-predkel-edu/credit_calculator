package bank.creditcalculators;

import static bank.creditdecisions.Positive.creditPositiveDecision;

public class CreditCalculator {

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
      int requestedAmount,
      int creditTerm,
      String purpose) {

    //Валидация на соответствие условиям выдачи кредита
    validationRules.validateApplicant(age, gender, incomeSource, annualIncome, creditRate, requestedAmount, creditTerm);

    //Расчёт доступной для выдачи суммы кредита
    double creditAmount = creditAmountCalculator.calculateCreditAmount(incomeSource, creditRate);

    //Расчёт кредитного модификатора
    double creditModifier = modifiersCalculator.calculateModifiers(creditRate, purpose, requestedAmount, incomeSource);

    //Расчёт годового платежа
    double annualPayment = annualPaymentCalculator.calculateAnnualPayment(creditModifier, creditAmount, creditTerm);

    //Валидация годового платежа
    validationRules.validateAnnualPayment(annualPayment, annualIncome);

    //Сообщение пользователю результата по заявке на кредит
    creditPositiveDecision(annualPayment);
  }
}