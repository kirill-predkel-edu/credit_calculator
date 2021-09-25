package bank.creditcalculators;

public class CreditAmountCalculator {

  public static int calculateCreditAmount(String incomeSource, int creditRate) {
    int creditAmountByIncomeSource = 0;
    int creditAmountByCreditRate = 0;
    int finalCreditAmount;

    switch (incomeSource) {
      case "Пассивный доход":
        creditAmountByIncomeSource = 1;
        break;
      case "Наёмный работник":
        creditAmountByIncomeSource = 5;
        break;
      case "Собственный бизнес":
        creditAmountByIncomeSource = 10;
        break;
    }

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
    }

    finalCreditAmount = Math.min(creditAmountByCreditRate, creditAmountByIncomeSource);

    return finalCreditAmount;
  }
}
