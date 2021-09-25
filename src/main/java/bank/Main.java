package bank;

import bank.creditcalculators.CreditCalculator;

public class Main {
  public static void main(String[] args) {
    CreditCalculator calculator = new CreditCalculator();
    calculator.calculateCredit(45,
        "M", //Пол
        "наёмный работник", //Источник дохода
        -1, //Доход за последний год, млн
        -1, //Кредитный рейтинг
        9.9, //Запрошенная сумма
        5, //Срок погашения
        "автокредит"); //Цель
  }
}