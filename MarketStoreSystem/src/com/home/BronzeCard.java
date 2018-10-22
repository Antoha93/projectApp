package com.home;

class BronzeCard {

    private float discountRate = 0.0f;

    public float getDiscountRate() {
        return discountRate;
    }
    public void setDiscountRate(float discountRate) {
        this.discountRate = discountRate;
    }

    public void calculateDiscountRate(final float turnoverForPreviousMonth) {
        if (turnoverForPreviousMonth >= 100 && turnoverForPreviousMonth < 300) {
            discountRate = 1.0f;
        }
        if (turnoverForPreviousMonth >= 300) {
            discountRate = 2.5f;
        }
    }
}
