import java.util.*;

/**
 * Created by david on 4/5/15.
 */
public class RomanNumerals {

    public enum Factor {
        THOUSAND(1000, "M"),
        NINE_HUNDRED(900, "CM"),
        FIVE_HUNDRED(500, "D"),
        FOUR_HUNDRED(400, "CD"),
        HUNDRED(100, "C"),
        NINETY(90, "XC"),
        FIFTY(50, "L"),
        FORTY(40, "XL"),
        TEN(10, "X"),
        NINE(9, "IX"),
        FIVE(5, "V"),
        FOUR(4, "IV"),
        ONE(1, "I");

        private int arabic;
        private String roman;
        private static Map<String, Factor> factors;

        static {
            initializeFactors();
        }

        private static void initializeFactors() {
            factors = new LinkedHashMap<>();
            factors.put("1000", THOUSAND);
            factors.put("900", NINE_HUNDRED);
            factors.put("500", FIVE_HUNDRED);
            factors.put("400", FOUR_HUNDRED);
            factors.put("100", HUNDRED);
            factors.put("90", NINETY);
            factors.put("50", FIFTY);
            factors.put("40", FORTY);
            factors.put("10", TEN);
            factors.put("9", NINE);
            factors.put("5", FIVE);
            factors.put("4", FOUR);
            factors.put("1", ONE);
        }


        Factor(int arabic, String roman) {
             this.arabic = arabic;
             this.roman = roman;
         }

        public int getArabic() {
            return arabic;
        }

        public String getRoman() {
            return  roman;
        }


        public static Optional<Factor> getFactorFor(String inArabic) {
            Collection<Factor> factorCollection = factors.values();
            return factorCollection.stream().
                    sorted().
                    filter(f -> f.getArabic() <= Integer.parseInt(inArabic)).
                    findFirst();

        }

    }


    public static String of(final String inArabic) {
        if (Integer.parseInt(inArabic) == 0){
            return "";
        }
        Factor factor = conversion_factor_for(inArabic);
        return factor.getRoman() + of(String.valueOf(Integer.parseInt(inArabic) - factor.getArabic()));

    }

    private static Factor conversion_factor_for(String inArabic) {

        return Factor.getFactorFor(inArabic).get();
    }
}
