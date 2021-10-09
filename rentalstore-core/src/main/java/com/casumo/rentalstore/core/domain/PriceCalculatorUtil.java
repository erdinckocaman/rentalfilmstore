package com.casumo.rentalstore.core.domain;

import java.math.BigDecimal;

public class PriceCalculatorUtil {

    public static BigDecimal calculatePriceWithFlatPricing(int totalDays, BigDecimal pricePerday, int flatDays) {
        BigDecimal total = pricePerday;

        if ( totalDays > flatDays ) {
            BigDecimal interimTotal = BigDecimal.valueOf(totalDays - flatDays).multiply(pricePerday);
            total = total.add(interimTotal);
        }

        return total;
    }
}
