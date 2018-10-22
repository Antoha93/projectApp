package com.home;

import java.util.Scanner;

public class PayDesk {

    public static void main(String[] args) {

        boolean newCard = true;

        while (newCard) {

            String ownersName;
            int cardType;
            float turnoverForPreviousMonth = 0.0f;
            float purchaseValue = 0.0f;

            System.out.println("Choose card:");
            System.out.println("0. No discount card");
            System.out.println("1. Bronze card");
            System.out.println("2. Silver card");
            System.out.println("3. Gold card");
            System.out.println("4. Exit");
            Scanner scanner = new Scanner(System.in);
            int chooseCard = scanner.nextInt();

            if (chooseCard == 1 || chooseCard == 2 || chooseCard == 3) {
                cardType = chooseCard;

                ownersName = getName();
                turnoverForPreviousMonth = getTurnoverForPreviousMonth(turnoverForPreviousMonth);
                purchaseValue = getPurchaseValue(purchaseValue);

                Card card = new Card(ownersName, cardType, turnoverForPreviousMonth, purchaseValue);
                card.printInformation();
            }
            else if (chooseCard == 0) {
                ownersName = getName();
                purchaseValue = getPurchaseValue(purchaseValue);

                Card card = new Card(ownersName, purchaseValue);
                card.printInformation();
            }
            else if (chooseCard == 4) {
                break;
            }
            else {
                continue;
            }

            boolean successEnter;
            do {
                System.out.println("Do you want to enter new card (Y/N): ");
                scanner = new Scanner(System.in);
                String continueWithNewCard = scanner.nextLine().toLowerCase();

                if (continueWithNewCard.equals("y") || continueWithNewCard.equals("yes")) {
                    successEnter = false;
                }
                else if (continueWithNewCard.equals("n") || continueWithNewCard.equals("no")) {
                    newCard = false;
                    successEnter = false;
                }
                else {
                    System.out.println("Error enter!");
                    successEnter = true;
                }
            } while (successEnter);
        }
    }

    private static float getTurnoverForPreviousMonth(float turnoverForPreviousMonth) {
        Scanner scanner;
        boolean successEnter;
        do {
            System.out.println("Enter turnover: ");
            scanner = new Scanner(System.in);
            if (scanner.hasNextFloat()) {
                turnoverForPreviousMonth = scanner.nextFloat();
                successEnter = false;
            }
            else {
                System.out.println("Error enter!");
                successEnter = true;
            }
        } while (successEnter);
        return turnoverForPreviousMonth;
    }

    private static float getPurchaseValue(float purchaseValue) {
        Scanner scanner;
        boolean successEnter;
        do {
            System.out.println("Enter purchase value: ");
            scanner = new Scanner(System.in);
            if (scanner.hasNextFloat()) {
                purchaseValue = scanner.nextFloat();
                successEnter = false;
            }
            else {
                successEnter = true;
            }
        } while (successEnter);
        return purchaseValue;
    }

    private static String getName() {
        Scanner scanner;
        String ownersName;
        boolean successEnter;
        do {
            System.out.println("Enter owner's name: ");
            scanner = new Scanner(System.in);
            ownersName = scanner.nextLine();

            if (ownersName.isEmpty()) {
                System.out.println("Error enter!");
                successEnter = true;
            }
            else {
                successEnter = false;
            }
        } while (successEnter);
        return ownersName;
    }
}
