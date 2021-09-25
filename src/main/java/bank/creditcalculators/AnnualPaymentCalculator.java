package bank.creditcalculators;

public class AnnualPaymentCalculator {

  public double calculateAnnualPayment(double creditModifier, double creditAmount, int creditTerm) {

    //Базовая ставка - 10%
    double basicModifier = 0.1;

    /* Годовой платеж по кредиту определяется по следующей формуле:
    (<сумма кредита> * (1 + <срок погашения> *
    (<базовая ставка> + <модификаторы>))) / <срок погашения> */
    return (creditAmount * (1 + creditTerm * (creditModifier + basicModifier))) / creditTerm;
  }
}
