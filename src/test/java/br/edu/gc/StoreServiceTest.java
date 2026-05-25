package br.edu.gc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StoreServiceTest {

    private final StoreService storeService = new StoreService();

    @Test
    void shouldCalculateDiscountedPriceWithTenPercentDiscount() {
        double result = storeService.calculateDiscountedPrice(100.0, 10.0);

        assertEquals(90.0, result, 0.001);
    }

    @Test
    void shouldCalculateDiscountedPriceWithTwentyFivePercentDiscount() {
        double result = storeService.calculateDiscountedPrice(200.0, 25.0);

        assertEquals(150.0, result, 0.001);
    }

    @Test
    void shouldReturnTrueWhenPurchaseValueHasFreeShipping() {
        boolean result = storeService.isFreeShipping(150.0);

        assertTrue(result);
    }

    @Test
    void shouldReturnFalseWhenPurchaseValueDoesNotHaveFreeShipping() {
        boolean result = storeService.isFreeShipping(149.99);

        assertFalse(result);
    }

    @Test
    void shouldThrowExceptionWhenOriginalPriceIsNegative() {
        assertThrows(
                IllegalArgumentException.class,
                () -> storeService.calculateDiscountedPrice(-100.0, 10.0)
        );
    }

    @Test
    void shouldThrowExceptionWhenDiscountPercentageIsInvalid() {
        assertThrows(
                IllegalArgumentException.class,
                () -> storeService.calculateDiscountedPrice(100.0, 120.0)
        );
    }
}