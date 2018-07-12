package ru.pochivalin;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void testAddFiveAndSix() {
       Calculator calculator = new Calculator();
       calculator.add(5, 7);
       assertEquals(12, calculator.getResult(),0.0);
    }

    @Test
    public void testDivFiveToTwo() {
        Calculator calculator = new Calculator();
        calculator.div(5, 2);
        assertEquals(2.5, calculator.getResult(), 0.0);
    }

    @Test
    public void testDivFiveToZero() {
        OutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        System.setOut(ps);
        Calculator calculator = new Calculator();
        calculator.div(5, 0);
        assertEquals("Sorry, can't divide by zero" +
                System.getProperty("line.separator"), os.toString());
    }

    @Test
    public void testValidateOperationWithNotValideIndex() {
        OutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        System.setOut(ps);
        Calculator calculator = new Calculator();
        calculator.validateOperation(50);
        assertEquals("Sorry, don't have this operation." +
                System.getProperty("line.separator"), os.toString());
    }

    @Test
    public void testValidateOperationWithValideIndex() {
        int randomNum = ThreadLocalRandom.current().nextInt(1,4);
        Calculator calculator = new Calculator();
        boolean isValide = calculator.validateOperation(randomNum);
        assertEquals(true, isValide);
    }

    @Test
    public void testSubFiveFromTen() {
        Calculator calculator = new Calculator();
        calculator.sub(10, 5);
        assertEquals(5, calculator.getResult(), 0.0);
    }

    @Test
    public void testMultFiveAndFive() {
        Calculator calculator = new Calculator();
        calculator.mult(5, 5);
        assertEquals(25, calculator.getResult(), 0.0);
    }

    @Test
    public void testValidateNoValideArgs() {
        double start = 400;
        double end = 402;
        double random = new Random().nextDouble();
        double resultDouble = start + (random * (end - start));
        //String number = Double.toString(resultDouble);
        String number = String.format("%.2f", resultDouble);
        OutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        System.setOut(ps);
        Calculator calculator = new Calculator();
        calculator.validateArgs(number);
        assertEquals("use incorect value, try again" +
                System.getProperty("line.separator"), os.toString());
    }

    @Test
    public void testValidateValideArgs() {
        Random random = new Random();
        int randomInt = random.nextInt();
        String number = Integer.toString(randomInt);
        Calculator calculator = new Calculator();
        boolean isValide = calculator.validateArgs(number);
        assertEquals(true, isValide);
    }

    @Test
    public void testCleanResult() {
        Calculator calculator = new Calculator();
        calculator.cleanResult();
        assertEquals(0, calculator.getResult(), 0.0);
    }
}
