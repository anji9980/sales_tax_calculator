package org.apache.taxcalculatorapp.parser;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class ExemptionChecker {

    /*
    in the problem statement it is very generic that the goods from the domain of books, food and medical items.
     So adding a flexibility to add keywords of that domain.

     or we can also have a lookup table kind of thing which will specify the domain,
     actually one good way to tackle is from input:
     we can utilise the non used special chars like, @ for books, # for food, $ for medicines in the start of the
     name of the product.
     */

    private static final List<Pattern> EXEMPT_PATTERNS = Arrays.asList(
            Pattern.compile("\\bbook\\b", Pattern.CASE_INSENSITIVE),
            Pattern.compile("\\bchocolate\\b", Pattern.CASE_INSENSITIVE),
            Pattern.compile("\\bchocolates\\b", Pattern.CASE_INSENSITIVE),
            Pattern.compile("\\bpill\\b", Pattern.CASE_INSENSITIVE),
            Pattern.compile("\\bpills\\b", Pattern.CASE_INSENSITIVE)
            // Add more patterns here if needed
    );

    public static boolean isExempt(String itemName){
        return EXEMPT_PATTERNS.stream()
                .anyMatch(pattern -> pattern.matcher(itemName).find());
    }
}
