package com.casumo.rentalstore.core.configuration;

import com.casumo.rentalstore.core.domain.RentalFilmPriceCalculatorFactory;
import com.casumo.rentalstore.core.repository.RentalFilmDetailsRepository;
import com.casumo.rentalstore.core.repository.RentalFilmRepository;
import com.casumo.rentalstore.core.repository.impl.DefaultRentalFilmDetailsRepository;
import com.casumo.rentalstore.core.repository.impl.DefaultRentalFilmRepository;
import com.casumo.rentalstore.core.service.RentalFilmService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
