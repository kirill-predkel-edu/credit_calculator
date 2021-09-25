package bank.creditdecisions;

public class Positive {

  public static void creditPositiveDecision(double annualPayment) {
    System.out.format("Заявка на кредит одобрена, годовой платёж составляет: %.2f млн", annualPayment);
  }
}
