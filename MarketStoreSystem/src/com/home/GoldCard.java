package com.home;

class GoldCard {

    private float discountRate = 2.0f;

    public float getDiscountRate() {
        return discountRate;
    }
    public void setDiscountRate(float discountRate) {
        this.discountRate = discountRate;
    }

    public void calculateDiscountRate(final float turnoverForPreviousMonth) {
        float turnover = turnoverForPreviousMonth;
        while (turnover - 100 >= 0 && discountRate < 10.0f) {
            turnover -= 100;
            discountRate+= 1.0f;
        }
    }
}
