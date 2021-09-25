package bank.creditcalculators;

public class CreditAmountCalculator {

  public double calculateCreditAmount(String incomeSource, int creditRate) {
    int creditAmountByIncomeSource;
    int creditAmountByCreditRate;

    /* При пассивном доходе выдаётся кредит на сумму до 1 млн,
    наёмным работникам - до 5 млн,
    собственное дело - до 10 млн */
    switch (incomeSource) {
      case "пассивный доход":
        creditAmountByIncomeSource = 1;
        break;
      case "наёмный работник":
        creditAmountByIncomeSource = 5;
        break;
      case "собственный бизнес":
        creditAmountByIncomeSource = 10;
        break;
      default:
        throw new IllegalStateException("Unexpected value: " + incomeSource);
    }

    /* При кредитном рейтинге -1 выдаётся кредит на сумму до 1 млн,
     при 0 - до 5 млн,
     при 1 или 2 - до 10 млн */
    switch (creditRate) {
      case -1:
        creditAmountByCreditRate = 1;
        break;
      case 0:
        creditAmountByCreditRate = 5;
        break;
      case 1:
      case 2:
        creditAmountByCreditRate = 10;
        break;
      default:
        throw new IllegalStateException("Unexpected value: " + creditRate);
    }

    //Если работают несколько условий по сумме кредита - выбирается наименьшая
    return Math.min(creditAmountByCreditRate, creditAmountByIncomeSource);
  }
}
