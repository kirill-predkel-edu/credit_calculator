import static org.junit.jupiter.api.Assertions.assertFalse;

import bank.creditcalculators.CreditCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class IntSourceTest {
    CreditCalculator calculator = new CreditCalculator();

    @BeforeEach
    void setUp() {
        CreditCalculator.setAreValidationRulesPassed(true);
    }

    @ParameterizedTest
    @Tag("Age")
    @ValueSource(ints = {1, 2, 3})
    void calculateCreditByAgeOnly(int age) {
        calculator.calculateCredit(age, "F", "наёмный работник", 10, 1, 5, 5, "автокредит");
        assertFalse(calculator.isCreditTaken(), "Кредит должен быть отменён для пользователя до 18");
    }
}