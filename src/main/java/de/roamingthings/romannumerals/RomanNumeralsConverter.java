package de.roamingthings.romannumerals;

public class RomanNumeralsConverter {
    private static class RomanSymbol {
        int value;
        String symbol;

        RomanSymbol(int value, String symbol) {
            this.value = value;
            this.symbol = symbol;
        }

        @Override
        public String toString() {
            return "RomanSymbol{" +
                    "value=" + value +
                    ", symbol='" + symbol + '\'' +
                    '}';
        }
    }

    private static RomanSymbol[] ROMAN_SYMBOLS = {
            new RomanSymbol(1, "I"),
            new RomanSymbol(4, "IV"),
            new RomanSymbol(5, "V"),
            new RomanSymbol(9, "IX"),
            new RomanSymbol(10, "X"),
            new RomanSymbol(40, "XL"),
            new RomanSymbol(50, "L"),
            new RomanSymbol(90, "XC"),
            new RomanSymbol(100, "C"),
            new RomanSymbol(400, "CD"),
            new RomanSymbol(500, "D"),
            new RomanSymbol(900, "CM"),
            new RomanSymbol(1000, "M")
    };

    public String convert(int number) {
        StringBuilder builder = new StringBuilder();
        int currentValue = number;

        while (currentValue > 0) {
            RomanSymbol currentSymbol = findMaxSymbolFor(currentValue);

            builder.append(currentSymbol.symbol);
            currentValue -= currentSymbol.value;
        }
        return builder.toString();
    }

    private RomanSymbol findMaxSymbolFor(int value) {
        int currentIdx = ROMAN_SYMBOLS.length - 1;
        while (currentIdx > 0 && ROMAN_SYMBOLS[currentIdx].value > value) {
            currentIdx--;
        }
        return ROMAN_SYMBOLS[currentIdx];
    }
}
