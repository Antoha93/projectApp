package com.home;

class SilverCard {

    private float discountRate = 2.0f;

    public float getDiscountRate() {
        return discountRate;
    }
    public void setDiscountRate(float discountRate) {
        this.discountRate = discountRate;
    }

    public void calculateDiscountRate(final float turnoverForPreviousMonth) {
        if (turnoverForPreviousMonth >= 300) {
            discountRate = 3.5f;
        }
    }
}
