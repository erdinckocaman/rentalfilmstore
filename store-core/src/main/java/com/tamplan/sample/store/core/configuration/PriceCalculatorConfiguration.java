package com.tamplan.sample.store.core.configuration;

import com.tamplan.sample.store.core.domain.pricecalculator.RentalFilmPriceCalculatorFactory;
import com.tamplan.sample.store.core.domain.pricecalculator.impl.NewReleaseBasedPriceCalculator;
import com.tamplan.sample.store.core.domain.pricecalculator.impl.OldFilmBasedPriceCalculator;
import com.tamplan.sample.store.core.domain.pricecalculator.impl.RegularFilmBasedPriceCalculator;
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
