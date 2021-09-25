package bank.creditcalculators;

import static java.lang.Math.log10;

public class ModifiersCalculator {

  public double calculateModifiers(int creditRate, String purpose, double requestedAmount, String incomeSource) {

    double modifierByPurpose = 0;
    double modifierByCreditRate;
    double modifierByRequestedAmount;
    double modifierByIncomeSource;

    /* +1.5% для кредитного рейтинга -1,
    0% для кредитного рейтинга 0,
    -0.25% для кредитного рейтинга 1,
    -0.75% для кредитного рейтинга 2 */
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
        modifierByCreditRate = -0.0075;
        break;
      default:
        throw new IllegalStateException("Unexpected value: " + creditRate);
    }

    /* -2% для ипотеки,
    -0.5% для развития бизнеса,
    +1.5% для потребительского кредита,
    для автокредита 0 (совершаем допущение) */
    switch (purpose) {
      case "ипотека":
        modifierByPurpose = -0.02;
        break;
      case "развитие бизнеса":
        modifierByPurpose = -0.005;
        break;
      case "автокредит":
        modifierByCreditRate = 0;
        break;
      case "потребительский":
        modifierByCreditRate = 0.015;
        break;
      default:
        throw new IllegalStateException("Unexpected value: " + purpose);
    }

    /* Для пассивного дохода ставка повышается на 0.5%,
    для наемных работников ставка снижается на 0.25%,
    для заемщиков с собственным бизнесом ставка повышается на 0.25% */
    switch (incomeSource) {
      case "пассивный доход":
        modifierByIncomeSource = 0.005;
        break;
      case "наёмный работник":
        modifierByIncomeSource = -0.0025;
        break;
      case "собственный бизнес":
        modifierByIncomeSource = 0.0025;
        break;
      default:
        throw new IllegalStateException("Unexpected value: " + incomeSource);
    }

    //Модификатор в зависимости от запрошенной суммы рассчитывается по формуле [-log(sum)]
    modifierByRequestedAmount = -(log10(requestedAmount)) / 100;

    //Все модификаторы процентной ставки суммируются, применяется итоговый модификатор
    return modifierByCreditRate + modifierByPurpose + modifierByIncomeSource + modifierByRequestedAmount;
  }
}