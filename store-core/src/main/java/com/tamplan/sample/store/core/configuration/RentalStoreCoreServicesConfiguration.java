package com.tamplan.sample.store.core.configuration;

import com.tamplan.sample.store.core.domain.pricecalculator.RentalFilmPriceCalculatorFactory;
import com.tamplan.sample.store.core.domain.pricecalculator.RentalFilmService;
import com.tamplan.sample.store.core.infra.outbound.repository.DefaultRentalFilmDetailsRepository;
import com.tamplan.sample.store.core.infra.outbound.repository.DefaultRentalFilmRepository;
import com.tamplan.sample.store.core.repository.RentalFilmDetailsRepository;
import com.tamplan.sample.store.core.repository.RentalFilmRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * All services are defined here
 */
@Configuration
public class RentalStoreCoreServicesConfiguration {

    @Bean
    public RentalFilmDetailsRepository getRentalFilmDetailsRepository() {
        return new DefaultRentalFilmDetailsRepository();
    }

    @Bean
    public RentalFilmRepository getRentalFilmRepository() {
        return new DefaultRentalFilmRepository();
    }

    @Bean
    public RentalFilmService getRentalFilmService(
            RentalFilmRepository rentalFilmRepository,
            RentalFilmDetailsRepository rentalFilmDetailsRepository,
            RentalFilmPriceCalculatorFactory rentalFilmPriceCalculatorFactory) {

        return new RentalFilmService(
                rentalFilmRepository,
                rentalFilmDetailsRepository,
                rentalFilmPriceCalculatorFactory);
    }

}
