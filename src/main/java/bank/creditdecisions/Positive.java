package bank.creditdecisions;

public class Positive {

  public static void creditPositiveDecision(double annualPayment, int creditAmount) {
    System.out.format("Заявка на кредит одобрена на сумму %d млн, годовой платёж составляет: %.2f млн",creditAmount,
        annualPayment);
  }
}