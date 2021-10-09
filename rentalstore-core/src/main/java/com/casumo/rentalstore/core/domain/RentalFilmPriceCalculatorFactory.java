package com.casumo.rentalstore.core.domain;

import com.casumo.rentalstore.core.domain.impl.NewReleaseBasedPriceCalculator;
import com.casumo.rentalstore.core.domain.impl.OldFilmBasedPriceCalculator;
import com.casumo.rentalstore.core.domain.impl.RegularFilmBasedPriceCalculator;
import com.casumo.rentalstore.core.domain.exception.PriceCalculatorNotFoundException;

import java.util.Map;

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
