package com.tamplan.sample.store.core;

import com.tamplan.sample.store.core.domain.entity.RentalFilm;
import com.tamplan.sample.store.core.domain.entity.RentalFilmType;
import com.tamplan.sample.store.core.domain.pricecalculator.PriceCalculatorContext;
import com.tamplan.sample.store.core.domain.pricecalculator.RentalFilmPriceCalculator;
import com.tamplan.sample.store.core.domain.pricecalculator.RentalFilmPriceCalculatorFactory;
import com.tamplan.sample.store.core.domain.pricecalculator.RentalFilmPriceType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.Map;

@SpringBootTest
@ActiveProfiles("test")
public class RentalFilmPriceCalculatorForRentalsTest {

    @Autowired
    RentalFilmPriceCalculatorFactory rentalFilmPriceCalculatorFactory;

    @Test
    public void shouldCalculateRentalPriceForOneItem(){
        // given
        RentalFilm rfMatrix11 = new RentalFilm("M11","Matrix11", RentalFilmType.NEW_RELEASE);

        PriceCalculatorContext priceCalculatorContext = new PriceCalculatorContext(rfMatrix11.getFilmType());

        RentalFilmPriceCalculator priceCalculator = rentalFilmPriceCalculatorFactory.getRentalFilmPriceCalculator(priceCalculatorContext);

        // when
        BigDecimal total = priceCalculator.calculatePrice(rfMatrix11, 1, 0);

        // then
        Assertions.assertEquals(RentalFilmPriceType.PREMIUM.getPrice().doubleValue(), total.doubleValue(), 0.1);
    }

    @Test
    public void shouldCalculateRentalPriceForRegularFilm() {
        // given
        RentalFilm rfSpiderMan = new RentalFilm("S11","Spider Man", RentalFilmType.REGULAR);

        PriceCalculatorContext priceCalculatorContext = new PriceCalculatorContext(rfSpiderMan.getFilmType());

        RentalFilmPriceCalculator priceCalculator = rentalFilmPriceCalculatorFactory.getRentalFilmPriceCalculator(priceCalculatorContext);

        // when
        BigDecimal total = priceCalculator.calculatePrice(rfSpiderMan, 5, 0);

        // then
        Assertions.assertEquals(90.0, total.doubleValue(), 0.1);
    }

    @Test
    public void shouldCalculateRentalPriceForRegularFilmWithFlatDayPricing() {
        // given
        RentalFilm rfSpiderMan = new RentalFilm("S12","Spider Man 2", RentalFilmType.REGULAR);

        PriceCalculatorContext priceCalculatorContext = new PriceCalculatorContext(rfSpiderMan.getFilmType());

        RentalFilmPriceCalculator priceCalculator = rentalFilmPriceCalculatorFactory.getRentalFilmPriceCalculator(priceCalculatorContext);

        // when
        BigDecimal total = priceCalculator.calculatePrice(rfSpiderMan, 2, 0);

        // then
        Assertions.assertEquals(30.0, total.doubleValue(), 0.1);
    }

    @Test
    public void shouldCalculateRentalPriceForOldFilm() {
        // given
        RentalFilm rfSpiderMan = new RentalFilm("O11","Out of Africa", RentalFilmType.OLD_FILM);

        PriceCalculatorContext priceCalculatorContext = new PriceCalculatorContext(rfSpiderMan.getFilmType());

        RentalFilmPriceCalculator priceCalculator = rentalFilmPriceCalculatorFactory.getRentalFilmPriceCalculator(priceCalculatorContext);

        // when
        BigDecimal total = priceCalculator.calculatePrice(rfSpiderMan, 7, 0);

        // then
        Assertions.assertEquals(90.0, total.doubleValue(), 0.1);
    }

    @Test
    public void shouldCalculateRentalFilmBasket() {
        // given
        Map<RentalFilm, Integer> filmRentals = Map.of(
                new RentalFilm("M11", "Matrix11", RentalFilmType.NEW_RELEASE), 1,
                new RentalFilm("S11", "Spider Man", RentalFilmType.REGULAR), 5,
                new RentalFilm("S12", "Spider Man 2", RentalFilmType.REGULAR), 2,
                new RentalFilm("O11", "Out of Africa", RentalFilmType.OLD_FILM), 7
        );

        // when

        BigDecimal total = BigDecimal.ZERO;

        for(Map.Entry<RentalFilm, Integer> entry: filmRentals.entrySet()) {
            RentalFilm film = entry.getKey();
            Integer days = entry.getValue();

            PriceCalculatorContext priceCalculatorContext = new PriceCalculatorContext(film.getFilmType());

            RentalFilmPriceCalculator priceCalculator = rentalFilmPriceCalculatorFactory.getRentalFilmPriceCalculator(priceCalculatorContext);

            BigDecimal subtotal = priceCalculator.calculatePrice(film, days, 0);

            total = total.add(subtotal);
        }

        // then

        Assertions.assertEquals(250.0, total.doubleValue(), 0.1);

    }
}
