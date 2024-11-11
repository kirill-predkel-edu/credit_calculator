import static org.junit.jupiter.api.Assertions.assertTrue;

import bank.creditcalculators.CreditCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class StringsSourceTest {

    CreditCalculator calculator = new CreditCalculator();

    @BeforeEach
    void setUp() {
        CreditCalculator.setAreValidationRulesPassed(true);
    }

    @ParameterizedTest
    @Tag("Purpose")
    @ValueSource(strings = {"автокредит", "ипотека", "развитие бизнеса", "потребительский"})
    void calculateCreditByPurposeOnly(String purpose) {
        calculator.calculateCredit(30, "F", "наёмный работник", 15, 1, 5, 5, purpose);
        assertTrue(calculator.isCreditTaken(), "Кредит должен быть отклонён для некоторых целей");
    }
}