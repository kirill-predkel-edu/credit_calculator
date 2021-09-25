package bank.creditcalculators;

import static java.lang.Math.log;

public class ModifiersCalculator {

  public static double calculateModifiers(int creditRate, String purpose, int requestedAmount, String incomeSource) {

    double modifierByPurpose = 0;
    double modifierByCreditRate = 0;
    double modifierByRequestedAmount = 0;
    double modifierByIncomeSource = 0;

    switch (creditRate) {
      case -1:
        modifierByCreditRate = 0.015;
        break;
      case 0:
        modifierByCreditRate = 0;
        break;
      case 1:
        modifierByCreditRate = -0.0025;
        break;
      case 2:
        modifierByCreditRate = 0.0075;
        break;
    }

    switch (purpose) {
      case "Ипотека":
        modifierByPurpose = -0.02;
        break;
      case "Развитие бизнеса":
        modifierByPurpose = -0.05;
        break;
      case "Автокредит":
        modifierByCreditRate = 0;
        break;
      case "Потребительский":
        modifierByCreditRate = 0.015;
        break;
    }

    switch (incomeSource) {
      case "Пассивный доход":
        modifierByIncomeSource = 0.05;
        break;
      case "Наёмный работник":
        modifierByIncomeSource = -0.025;
        break;
      case "Собственный бизнес":
        modifierByIncomeSource = 0.025;
        break;
    }

    modifierByRequestedAmount = -log(requestedAmount);

    return modifierByCreditRate + modifierByPurpose + modifierByIncomeSource + modifierByRequestedAmount;
  }
}