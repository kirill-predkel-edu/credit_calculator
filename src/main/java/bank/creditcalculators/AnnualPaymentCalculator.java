package bank.creditcalculators;

public class AnnualPaymentCalculator {
  public static double calculateAnnualPayment(double creditModifier, double creditAmount, int creditTerm) {
    double basicModifier = 0.1;
    return (creditAmount * (1 + creditTerm * (creditModifier + basicModifier))) / creditTerm;
  }
}
