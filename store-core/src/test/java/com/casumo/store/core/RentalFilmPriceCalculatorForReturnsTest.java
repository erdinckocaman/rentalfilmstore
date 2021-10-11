package com.casumo.store.core;

import com.casumo.store.core.domain.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;

@SpringBootTest
@ActiveProfiles("test")
public class RentalFilmPriceCalculatorForReturnsTest {

    @Autowired
    RentalFilmPriceCalculatorFactory rentalFilmPriceCalculatorFactory;

    @Test
    public void shouldCalculateLateFeeForNewRelease() {
        // given
        RentalFilm rfMatrix11 = new RentalFilm("M11","Matrix11", RentalFilmType.NEW_RELEASE);

        PriceCalculatorContext priceCalculatorContext = new PriceCalculatorContext(rfMatrix11.getFilmType());

        RentalFilmPriceCalculator priceCalculator = rentalFilmPriceCalculatorFactory.getRentalFilmPriceCalculator(priceCalculatorContext);

        // when
        BigDecimal total = priceCalculator.calculatePrice(rfMatrix11, 1, 0);
        BigDecimal totalWithFee = priceCalculator.calculatePrice(rfMatrix11, 1, 2);
        BigDecimal fee = totalWithFee.subtract(total);

        // then
        Assertions.assertEquals(80, fee.doubleValue(), 0.1);
    }

    @Test
    public void shouldCalculateLateFeeForRegularFilm() {
        // given
        RentalFilm rfSpiderMan = new RentalFilm("S11","Spider Man", RentalFilmType.REGULAR);

        PriceCalculatorContext priceCalculatorContext = new PriceCalculatorContext(rfSpiderMan.getFilmType());

        RentalFilmPriceCalculator priceCalculator = rentalFilmPriceCalculatorFactory.getRentalFilmPriceCalculator(priceCalculatorContext);

        // when
        BigDecimal total = priceCalculator.calculatePrice(rfSpiderMan, 3, 0);
        BigDecimal totalWithFee = priceCalculator.calculatePrice(rfSpiderMan, 3, 1);
        BigDecimal fee = totalWithFee.subtract(total);

        // then
        Assertions.assertEquals(30, fee.doubleValue(), 0.1);
    }
}
