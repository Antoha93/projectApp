package com.home;

class Card {

    private String owner;
    private float turnoverForPreviousMonth = 0.0f;
    private float initialDiscountRate = 0.0f;
    private float discount = 0.0f;
    private float valueOfPurchase;
    private int cardType = 0;
    private float total;

    private BronzeCard bronzeCard = new BronzeCard();
    private SilverCard silverCard = new SilverCard();
    private GoldCard goldCard = new GoldCard();


    public String getOwner() {
        return owner;
    }
    public void setOwner(String owner) {
        this.owner = owner;
    }

    public float getTurnoverForPreviousMonth() {
        return turnoverForPreviousMonth;
    }
    public void setTurnoverForPreviousMonth(float turnoverForPreviousMonth) {
        this.turnoverForPreviousMonth = turnoverForPreviousMonth;
    }

    public float getInitialDiscountRate() {
        return initialDiscountRate;
    }
    public void setInitialDiscountRate(float initialDiscountRate) {
        this.initialDiscountRate = initialDiscountRate;
    }

    public float getDiscount() {
        return discount;
    }
    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public float getValueOfPurchase() {
        return valueOfPurchase;
    }
    public void setValueOfPurchase(float valueOfPurchase) {
        this.valueOfPurchase = valueOfPurchase;
    }

    public int getCardType() {
        return cardType;
    }
    public void setCardType(int cardType) {
        this.cardType = cardType;
    }

    public float getTotal() {
        return total;
    }
    public void setTotal(float total) {
        this.total = total;
    }


    public Card(final String name, final int cardType, final float currentTurnover, final float purchase){
        setOwner(name);
        setCardType(cardType);
        setTurnoverForPreviousMonth(currentTurnover);
        setValueOfPurchase(purchase);
        setDiscountRate(cardType);
        setDiscount((calculateDiscount(valueOfPurchase, initialDiscountRate)));
    }

    public Card(final String name,final float purchase){
        setOwner(name);
        setValueOfPurchase(purchase);
        setDiscountRate(cardType);
        setDiscount((calculateDiscount(valueOfPurchase, initialDiscountRate)));
    }

    private void setDiscountRate(final int cardType) {
        if (cardType == 1) {
            bronzeCard.calculateDiscountRate(turnoverForPreviousMonth);
            setInitialDiscountRate(bronzeCard.getDiscountRate());
        }
        if (cardType == 2) {
            silverCard.calculateDiscountRate(turnoverForPreviousMonth);
            setInitialDiscountRate(silverCard.getDiscountRate());
        }
        if (cardType == 3) {
            goldCard.calculateDiscountRate(turnoverForPreviousMonth);
            setInitialDiscountRate(goldCard.getDiscountRate());
        }
    }

    private float calculateDiscount(final float valueOfPurchase, final float initialDiscountRate){
        float discount;
        discount = (valueOfPurchase * (initialDiscountRate / 100));
        setTotal(valueOfPurchase - discount);
        return discount;
    }
    public void printInformation(){
        System.out.println("Owner: " + getOwner());
        System.out.print("Card type: ");
        if (getCardType() == 0)
            System.out.println("Don't have a card");
        if (getCardType() == 1)
            System.out.println("Bronze");
        if (getCardType() == 2)
            System.out.println("Silver");
        if (getCardType() == 3)
            System.out.println("Gold");
        System.out.println(String.format("Turnover: " + "%.2f", getTurnoverForPreviousMonth()));
        System.out.println(String.format("Purchase value: " + "%.2f", getValueOfPurchase()));
        System.out.println("Discount rate: " + getInitialDiscountRate() + "%");
        System.out.println(String.format("Discount: " + "%.2f", getDiscount()));
        System.out.println(String.format("Total: " + "%.2f", getTotal()) + "\n");
    }
}
