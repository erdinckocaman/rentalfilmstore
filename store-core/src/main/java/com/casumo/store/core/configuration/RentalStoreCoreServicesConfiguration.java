package com.casumo.store.core.configuration;

import com.casumo.store.core.domain.RentalFilmPriceCalculatorFactory;
import com.casumo.store.core.repository.RentalFilmDetailsRepository;
import com.casumo.store.core.repository.RentalFilmRepository;
import com.casumo.store.core.repository.impl.DefaultRentalFilmDetailsRepository;
import com.casumo.store.core.repository.impl.DefaultRentalFilmRepository;
import com.casumo.store.core.service.RentalFilmService;
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

        return new RentalFilmService(rentalFilmRepository, rentalFilmDetailsRepository, rentalFilmPriceCalculatorFactory);
    }

}
