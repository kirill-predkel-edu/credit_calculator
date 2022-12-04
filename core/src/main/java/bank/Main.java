package bank;

import bank.creditcalculators.CreditCalculator;

public class Main {

  public static void main(String[] args) {
    CreditCalculator calculator = new CreditCalculator();
    calculator.calculateCredit(56,
        "M", //Пол
        "наёмный работник", //Источник дохода
        15, //Доход за последний год, млн
        1, //Кредитный рейтинг
        2, //Запрошенная сумма
        8, //Срок погашения
        "ипотека");
  }
}