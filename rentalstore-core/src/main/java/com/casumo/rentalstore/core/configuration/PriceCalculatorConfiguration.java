package com.casumo.rentalstore.core.configuration;

import com.casumo.rentalstore.core.domain.RentalFilmPriceCalculatorFactory;
import com.casumo.rentalstore.core.domain.impl.NewReleaseBasedPriceCalculator;
import com.casumo.rentalstore.core.domain.impl.OldFilmBasedPriceCalculator;
import com.casumo.rentalstore.core.domain.impl.RegularFilmBasedPriceCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
