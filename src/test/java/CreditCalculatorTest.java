import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import bank.creditcalculators.CreditCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CreditCalculatorTest {

  CreditCalculator calculator = new CreditCalculator();

  @BeforeEach
  void setUp() {
    CreditCalculator.areValidationRulesPassed = true;
  }

  @Tag("id1")
  @Test
  void calculateCreditRetirementAgeFemaleCreditDeclined() {
    calculator.calculateCredit(51,
        "F", //Пол
        "наёмный работник", //Источник дохода
        5, //Доход за последний год, млн
        0, //Кредитный рейтинг
        1, //Запрошенная сумма
        10, //Срок погашения
        "автокредит"); //Цель;
    assertFalse(calculator.isCreditTaken, "Кредит отменён?");
  }

  @Tag("id2")
  @Test
  void calculateCreditRetirementAgeMaleCreditDeclined() {
    calculator.calculateCredit(58,
        "M", //Пол
        "наёмный работник", //Источник дохода
        15, //Доход за последний год, млн
        1, //Кредитный рейтинг
        2, //Запрошенная сумма
        8, //Срок погашения
        "ипотека"); //Цель;
    assertFalse(calculator.isCreditTaken, "Кредит отменён?");
  }

  @Tag("id3")
  @Test
  void calculateCreditNotAdultCreditDeclined() {
    calculator.calculateCredit(17,
        "F", //Пол
        "пассивный доход", //Источник дохода
        7, //Доход за последний год, млн
        2, //Кредитный рейтинг
        3, //Запрошенная сумма
        15, //Срок погашения
        "потребительский"); //Цель;
    assertFalse(calculator.isCreditTaken, "Кредит отменён?");
  }

  @Tag("id4")
  @Test
  void calculateCreditLowCreditRateCreditDeclined() {
    calculator.calculateCredit(25,
        "M", //Пол
        "собственный бизнес", //Источник дохода
        20, //Доход за последний год, млн
        -2, //Кредитный рейтинг
        0.1, //Запрошенная сумма
        5, //Срок погашения
        "развитие бизнеса"); //Цель;
    assertFalse(calculator.isCreditTaken, "Кредит отменён?");
  }

  @Tag("id5")
  @Test
  void calculateCreditAnnualIncomeLowerThanRequestedAmountCreditDeclined() {
    calculator.calculateCredit(25,
        "F", //Пол
        "наёмный работник", //Источник дохода
        10, //Доход за последний год, млн
        0, //Кредитный рейтинг
        10, //Запрошенная сумма
        1, //Срок погашения
        "ипотека"); //Цель;
    assertFalse(calculator.isCreditTaken, "Кредит отменён?");
  }

  @Tag("id6")
  @Test
  void calculateCreditAnnualPaymentHigherThanAnnualIncomeCreditDeclined() {
    calculator.calculateCredit(35,
        "M", //Пол
        "пассивный доход", //Источник дохода
        1, //Доход за последний год, млн
        2, //Кредитный рейтинг
        1, //Запрошенная сумма
        1, //Срок погашения
        "потребительский"); //Цель;
    assertFalse(calculator.isCreditTaken, "Кредит отменён?");
  }

  @Tag("id7")
  @Test
  void calculateCreditJoblessCreditDeclined() {
    calculator.calculateCredit(45,
        "F", //Пол
        "безработный", //Источник дохода
        7, //Доход за последний год, млн
        2, //Кредитный рейтинг
        1, //Запрошенная сумма
        10, //Срок погашения
        "развитие бизнеса"); //Цель;
    assertFalse(calculator.isCreditTaken, "Кредит отменён?");
  }

  @Tag("id8")
  @Test
  void calculateCreditAnnualIncomeIsZeroCreditDeclined() {
    calculator.calculateCredit(51,
        "M", //Пол
        "собственный бизнес", //Источник дохода
        0, //Доход за последний год, млн
        -1, //Кредитный рейтинг
        1, //Запрошенная сумма
        3, //Срок погашения
        "автокредит"); //Цель;
    assertFalse(calculator.isCreditTaken, "Кредит отменён?");
  }

  @Tag("id9")
  @Test
  void calculateCreditAdultBoundaryValueCreditApproved() {
    calculator.calculateCredit(18,
        "F", //Пол
        "собственный бизнес", //Источник дохода
        25, //Доход за последний год, млн
        1, //Кредитный рейтинг
        2.5, //Запрошенная сумма
        19, //Срок погашения
        "потребительский"); //Цель;
    assertTrue(calculator.isCreditTaken, "Кредит одобрен?");
    assertEquals(1.66, calculator.annualPayment, "Размер годового платежа неверен");
  }

  @Tag("id10")
  @Test
  void calculateCreditAgeBeforeRetirementBoundaryValueMaleCreditApproved() {
    calculator.calculateCredit(61,
        "M", //Пол
        "наёмный работник", //Источник дохода
        25, //Доход за последний год, млн
        0, //Кредитный рейтинг
        2.5, //Запрошенная сумма
        4, //Срок погашения
        "развитие бизнеса"); //Цель;
    assertTrue(calculator.isCreditTaken, "Кредит одобрен?");
    assertEquals(1.69, calculator.annualPayment, "Размер годового платежа неверен");
  }

  @Tag("id11")
  @Test
  void calculateCreditAgeBeforeRetirementBoundaryValueFemaleCreditApproved() {
    calculator.calculateCredit(53,
        "F", //Пол
        "пассивный доход", //Источник дохода
        25, //Доход за последний год, млн
        2, //Кредитный рейтинг
        0.2, //Запрошенная сумма
        7, //Срок погашения
        "ипотека"); //Цель;
    assertTrue(calculator.isCreditTaken, "Кредит одобрен?");
    assertEquals(0.23, calculator.annualPayment, "Размер годового платежа неверен");
  }

  @Tag("id12")
  @Test
  void calculateCreditAgeBeforeRetirementMaleCreditApproved() {
    calculator.calculateCredit(61,
        "M", //Пол
        "собственный бизнес", //Источник дохода
        15, //Доход за последний год, млн
        1, //Кредитный рейтинг
        1, //Запрошенная сумма
        3, //Срок погашения
        "потребительский"); //Цель;
    assertTrue(calculator.isCreditTaken, "Кредит одобрен?");
    assertEquals(4.51, calculator.annualPayment, "Размер годового платежа неверен");
  }

  @Tag("id13")
  @Test
  void calculateCreditAgeBeforeRetirementFemaleCreditApproved() {
    calculator.calculateCredit(54,
        "F", //Пол
        "наёмный работник", //Источник дохода
        15, //Доход за последний год, млн
        1, //Кредитный рейтинг
        9.9, //Запрошенная сумма
        5, //Срок погашения
        "потребительский"); //Цель;
    assertTrue(calculator.isCreditTaken, "Кредит одобрен?");
    assertEquals(1.51, calculator.annualPayment, "Размер годового платежа неверен");
  }

  @Tag("id14")
  @Test
  void calculateCreditAdultCreditApproved() {
    calculator.calculateCredit(19,
        "F", //Пол
        "пассивный доход", //Источник дохода
        150, //Доход за последний год, млн
        -1, //Кредитный рейтинг
        0.2, //Запрошенная сумма
        15, //Срок погашения
        "автокредит"); //Цель;
    assertTrue(calculator.isCreditTaken, "Кредит одобрен?");
    assertEquals(0.18, calculator.annualPayment, "Размер годового платежа неверен");
  }

  @Tag("id15")
  @Test
  void calculateCreditMaxRequestedAmountCreditApproved() {
    calculator.calculateCredit(45,
        "M", //Пол
        "пассивный доход", //Источник дохода
        150, //Доход за последний год, млн
        0, //Кредитный рейтинг
        10, //Запрошенная сумма
        5, //Срок погашения
        "развитие бизнеса"); //Цель;
    assertTrue(calculator.isCreditTaken, "Кредит одобрен?");
    assertEquals(0.29, calculator.annualPayment, "Размер годового платежа неверен");
  }

  @Tag("id16")
  @Test
  void calculateCreditMinRequestedAmountCreditApproved() {
    calculator.calculateCredit(43,
        "F", //Пол
        "собственный бизнес", //Источник дохода
        14, //Доход за последний год, млн
        0, //Кредитный рейтинг
        0.1, //Запрошенная сумма
        2, //Срок погашения
        "ипотека"); //Цель;
    assertTrue(calculator.isCreditTaken, "Кредит одобрен?");
    assertEquals(2.96, calculator.annualPayment, "Размер годового платежа неверен");
  }

  @Tag("id17")
  @Test
  void calculateCreditMaxTermCreditApproved() {
    calculator.calculateCredit(22,
        "M", //Пол
        "наёмный работник", //Источник дохода
        2, //Доход за последний год, млн
        2, //Кредитный рейтинг
        1, //Запрошенная сумма
        20, //Срок погашения
        "ипотека"); //Цель;
    assertTrue(calculator.isCreditTaken, "Кредит одобрен?");
    assertEquals(0.6, calculator.annualPayment, "Размер годового платежа неверен");
  }

  @Tag("id18")
  @Test
  void calculateCreditMinTermCreditApproved() {
    calculator.calculateCredit(28,
        "M", //Пол
        "пассивный доход", //Источник дохода
        62, //Доход за последний год, млн
        1, //Кредитный рейтинг
        5, //Запрошенная сумма
        1, //Срок погашения
        "потребительский"); //Цель;
    assertTrue(calculator.isCreditTaken, "Кредит одобрен?");
    assertEquals(1.11, calculator.annualPayment, "Размер годового платежа неверен");
  }
}