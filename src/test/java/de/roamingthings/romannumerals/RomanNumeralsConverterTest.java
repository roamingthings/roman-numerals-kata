package de.roamingthings.romannumerals;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class RomanNumeralsConverterTest {

    private RomanNumeralsConverter romanNumeralsConverter;

    @BeforeEach
    public void setup() {
        romanNumeralsConverter = new RomanNumeralsConverter();
    }

    @DisplayName("Should convert number-value to roman numeral")
    @ParameterizedTest(name = "{0} => {1}")
    @CsvFileSource(resources = "/test_numbers.csv")
    public void shouldConvertNumberToRomainNumber(int number, String expectedRomanNumeral) {
        // given
        // by parameter

        // when
        String convertedNumber = romanNumeralsConverter.convert(number);

        // then
        Assertions.assertThat(convertedNumber).isEqualTo(expectedRomanNumeral);
    }
}
