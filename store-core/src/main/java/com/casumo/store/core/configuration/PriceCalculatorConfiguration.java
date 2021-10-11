package com.casumo.store.core.configuration;

import com.casumo.store.core.domain.RentalFilmPriceCalculatorFactory;
import com.casumo.store.core.domain.impl.NewReleaseBasedPriceCalculator;
import com.casumo.store.core.domain.impl.OldFilmBasedPriceCalculator;
import com.casumo.store.core.domain.impl.RegularFilmBasedPriceCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Price calculation specific instances are defined here
 */
@Configuration
public class PriceCalculatorConfiguration {

    @Bean
    NewReleaseBasedPriceCalculator getNewReleaseBasedPriceCalculator() {
        return new NewReleaseBasedPriceCalculator();
    }

    @Bean
    OldFilmBasedPriceCalculator getOldFilmBasedPriceCalculator() {
        return new OldFilmBasedPriceCalculator();
    }

    @Bean
    RegularFilmBasedPriceCalculator getRegularFilmBasedPriceCalculator() {
        return new RegularFilmBasedPriceCalculator();
    }

    @Bean
    RentalFilmPriceCalculatorFactory getRentalFilmPriceCalculatorFactory(
            NewReleaseBasedPriceCalculator newReleaseBasedPriceCalculator,
            OldFilmBasedPriceCalculator oldFilmBasedPriceCalculator,
            RegularFilmBasedPriceCalculator regularFilmBasedPriceCalculator) {

        return new RentalFilmPriceCalculatorFactory(
                newReleaseBasedPriceCalculator,
                oldFilmBasedPriceCalculator,
                regularFilmBasedPriceCalculator);
    }

}
