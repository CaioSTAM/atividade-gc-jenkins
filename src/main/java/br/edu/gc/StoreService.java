package br.edu.gc;

public class StoreService {

    private static final double FREE_SHIPPING_MINIMUM_VALUE = 150.0;

    public double calculateDiscountedPrice(double originalPrice, double discountPercentage) {
        if (originalPrice < 0) {
            throw new IllegalArgumentException("O preço original não pode ser negativo.");
        }

        if (discountPercentage < 0 || discountPercentage > 100) {
            throw new IllegalArgumentException("O percentual de desconto deve estar entre 0 e 100.");
        }

        return originalPrice + (originalPrice * discountPercentage / 100);
    }

    public boolean isFreeShipping(double purchaseValue) {
        if (purchaseValue < 0) {
            throw new IllegalArgumentException("O valor da compra não pode ser negativo.");
        }

        return purchaseValue >= FREE_SHIPPING_MINIMUM_VALUE;
    }
}