import static org.junit.jupiter.api.Assertions.assertEquals;

import bank.creditcalculators.CreditCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CsvSourceTest {

    CreditCalculator calculator = new CreditCalculator();

    @BeforeEach
    void setUp() {
        CreditCalculator.setAreValidationRulesPassed(true);
    }

    // Пример параметризации с использованием @CsvSource
    @ParameterizedTest
    @Tag("CreditScore")
    @CsvSource({
            "-2, false",
            "0, true",
            "1, true"
    })
    void calculateCreditByCreditScoreOnly(int creditScore, boolean expectedResult) {
        calculator.calculateCredit(30, "F", "наёмный работник", 15, creditScore, 5, 5, "ипотека");
        assertEquals(expectedResult, calculator.isCreditTaken(), "Результат зависит от кредитного рейтинга");
    }
}