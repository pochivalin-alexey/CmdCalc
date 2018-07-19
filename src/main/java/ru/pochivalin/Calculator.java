package ru.pochivalin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Calculator {

    private double result;
    private static int minIndexOper = 1;
    private static int maxIndexOper = 4;
    private static final Logger LOG = LoggerFactory.getLogger(Calculator.class);

    public void add(final int firstArg, final int secondArg) {
            this.result = firstArg + secondArg;
    }

    public void div(final int firstArg, final int secondArg) {
        if (secondArg != 0) {
            this.result = firstArg / (double) secondArg;
        } else {
            LOG.info("Sorry, can't divide by zero");
        }
    }

    public void sub(final int firstArg, final int secondArg) {
        this.result = firstArg - secondArg;
    }

    public void mult(final int firstArg, final int secondArg) {
        this.result = firstArg * secondArg;
    }

    public boolean validateOperation(final int indexOperation) {
        boolean isValide = true;
        if (!(indexOperation >= minIndexOper && indexOperation <= maxIndexOper)) {
            LOG.info("Sorry, don't have this operation.");
            isValide = false;
        }
        return isValide;
    }

    public boolean validateArgs(String number) {
        boolean isValide = false;
        try {
            int num = Integer.parseInt(number);
            isValide = true;
        } catch (NumberFormatException e) {
            LOG.info("use incorect value, try again");
        }
        return isValide;
    }

    public void calc(final int indexOperation, final int firstArg, final int secondArg) {
        switch (indexOperation) {
            case 1 :
                add(firstArg, secondArg);
                break;
            case 2 :
                sub(firstArg, secondArg);
                break;
            case 3 :
                div(firstArg, secondArg);
                break;
            case 4 :
                mult(firstArg, secondArg);
                break;
        }
    }

    public double getResult() {
        return this.result;
    }

    public void cleanResult() {
        this.result = 0;
    }
}
