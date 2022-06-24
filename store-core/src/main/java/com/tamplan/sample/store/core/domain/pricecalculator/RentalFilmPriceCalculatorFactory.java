package com.tamplan.sample.store.core.domain.pricecalculator;

import com.tamplan.sample.store.core.domain.entity.RentalFilmType;
import com.tamplan.sample.store.core.domain.pricecalculator.impl.NewReleaseBasedPriceCalculator;
import com.tamplan.sample.store.core.domain.pricecalculator.impl.OldFilmBasedPriceCalculator;
import com.tamplan.sample.store.core.domain.pricecalculator.impl.RegularFilmBasedPriceCalculator;
import com.tamplan.sample.store.core.domain.pricecalculator.exception.PriceCalculatorNotFoundException;

import java.util.Map;

/**
 * Depending on content of price context, this objects returns a suitable price calculator instance
 */
public class RentalFilmPriceCalculatorFactory {

    private Map<RentalFilmType, RentalFilmPriceCalculator> rentalFilmPriceCalculatorMap;

    public RentalFilmPriceCalculatorFactory(
                                            NewReleaseBasedPriceCalculator newReleaseBasedPriceCalculator,
                                            OldFilmBasedPriceCalculator oldFilmBasedPriceCalculator,
                                            RegularFilmBasedPriceCalculator regularFilmBasedPriceCalculator) {

        rentalFilmPriceCalculatorMap = Map.of(
                RentalFilmType.NEW_RELEASE, newReleaseBasedPriceCalculator,
                RentalFilmType.OLD_FILM,    oldFilmBasedPriceCalculator,
                RentalFilmType.REGULAR,     regularFilmBasedPriceCalculator);
    }

    public RentalFilmPriceCalculator getRentalFilmPriceCalculator(PriceCalculatorContext priceCalculatorContext) {
        RentalFilmPriceCalculator priceCalculator = rentalFilmPriceCalculatorMap.get(priceCalculatorContext.getFilmType());

        if ( priceCalculator == null ) {
            throw new PriceCalculatorNotFoundException(priceCalculatorContext.getFilmType());
        }

        return priceCalculator;
    }
}
