import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackCalculatorTest {
    private StackCalculator sut;

    @BeforeEach
    void setUp() {
        sut = new StackCalculator();
    }

    @Test
    public void testSimpleSum() {
        try {
            double result = sut.calculate("2 2 +");
            assertEquals(4.0, result);
        } catch(StackCalculator.InvalidExpressionException e) {
            fail();
        }
    }

    @Test
    public void testSumAndMultiply() {
        try {
            double result = sut.calculate("2 4 + 6 *");
            assertEquals(36.0, result);
        } catch(StackCalculator.InvalidExpressionException e) {
            fail();
        }
    }

    @Test
    public void testSubtraction() {
        try {
            double result = sut.calculate("4 2 10 -");
            assertEquals(4.0, result);
        } catch(StackCalculator.InvalidExpressionException e) {
            fail();
        }
    }

    @Test
    public void testMultipleOperations() {
        try {
            double result = sut.calculate("2 4 3 + 6 1 * 108 /");
            assertEquals(2.0, result);
        } catch(StackCalculator.InvalidExpressionException e) {
            fail();
        }
    }

    @Test
    public void testInvalidExpression() {
        try {
            sut.calculate("c");
            fail();
        } catch(StackCalculator.InvalidExpressionException e) {
            assertTrue(true);
        }
    }
}