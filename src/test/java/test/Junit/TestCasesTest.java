package Junit;

import Service.BankServiceImp;
import static junit.framework.Assert.assertEquals;
import org.junit.Test;

public class TestCasesTest {

    BankServiceImp bsi = new BankServiceImp();

    @Test
    public void Deposit1() {

        double result = bsi.deposit(1001, -10);
        double expected = -1;

        assertEquals(expected, result);

    }

    @Test
    public void Deposit2() {

        double result = bsi.deposit(1001, 50);
        double expected = 150;

        assertEquals(expected, result);

    }

    @Test
    public void Withdraw1() {

        double result = bsi.withdraw(1001, 125);
        double expected = -1;

        assertEquals(expected, result);

    }

    @Test
    public void Withdraw2() {

        double result = bsi.withdraw(1001, 25);
        double expected = 75;

        assertEquals(expected, result);

    }

    @Test
    public void Transfer1() {

        double result = bsi.transfer(1001, 1002, 20);
        double expected = 80;

        assertEquals(expected, result);

    }

    @Test
    public void Transfer2() {

        double result = bsi.transfer(1001, 1003, 20);
        double expected = -1;

        assertEquals(expected, result);

    }

    @Test
    public void Transfer3() {

        double result = bsi.transfer(1001, 1002, 110);
        double expected = 0;

        assertEquals(expected, result);

    }

}
