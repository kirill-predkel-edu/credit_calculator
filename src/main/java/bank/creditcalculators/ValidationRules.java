package bank.creditcalculators;

import static bank.creditdecisions.Negative.creditNegativeDecision;

class ValidationRules {

  public void validateApplicant(
      int age,
      String gender,
      String incomeSource,
      double annualIncome,
      int creditRate,
      double requestedAmount,
      int loanTerm) {

    //Если возраст превышает пенсионный возраст на момент возврата кредита --> кредит не выдаётся
    if (age + loanTerm >= 65 && gender.equals("M") || age + loanTerm >= 60 && gender.equals("F"))
      creditNegativeDecision();

    //допущение о том, что в кредите должно быть отказано для несовершеннолетнего заявителя
    if (age < 18)
      creditNegativeDecision();

    /* Если результат деления запрошенной суммы
    на срок погашения в годах более трети годового дохода --> кредит не выдаётся */
    if (requestedAmount / loanTerm > annualIncome / 3)
      creditNegativeDecision();

    //Если кредитный рейтинг -2 --> кредит не выдаётся
    if (creditRate < -1)
      creditNegativeDecision();

    //Если в источнике дохода указано "безработный" --> кредит не выдаётся
    if (incomeSource.equalsIgnoreCase("безработный"))
      creditNegativeDecision();
  }

  //Если годовой платёж (включая проценты) больше половины дохода --> кредит не выдаётся
  public void validateAnnualPayment(double annualPayment, int annualIncome) {
    if (annualPayment > (annualIncome / 2))
      creditNegativeDecision();
  }
}