package com.geeksforless.yevdokymov.javaCore;
import org.junit.Assert;
import org.junit.Test;

public class ArithmeticExpressionCalculatingTest {
    // Чомусь не програжає тести з дужками
    @Test
    public void testCalculate() throws Exception {
        String[] values  = new String[] {"23+123", "223-123", "12-67+880/2-4+5*10/2", "23-45+2*5-11-2", "56+-3", "34)-34"};
        Double[] result  = new Double[] {146.0, 100.0, 406.0, -25.0, 53.0, 234.0};
        for (int i = 0; i < 5; i ++) {
            ArithmeticExpressionValuesAnalyze arithmeticExpressionValuesAnalyze = new ArithmeticExpressionValuesAnalyze();
            ArithmeticExpressionCalculating arithmeticExpressionCalculating = new ArithmeticExpressionCalculating();

            arithmeticExpressionValuesAnalyze.analyze(new StringBuilder(values[i]));
            Assert.assertEquals(arithmeticExpressionCalculating.calculate(arithmeticExpressionValuesAnalyze.values), result[i]);
        }

    }
    @Test
    public void testGetPriority() {
        ArithmeticExpressionCalculating arithmeticExpressionCalculating = new ArithmeticExpressionCalculating();
        Assert.assertEquals(arithmeticExpressionCalculating.getPriority("("), 1);
        Assert.assertEquals(arithmeticExpressionCalculating.getPriority(")"), -1);
        Assert.assertEquals(arithmeticExpressionCalculating.getPriority("+"), 2);
        Assert.assertEquals(arithmeticExpressionCalculating.getPriority("-"), 2);
        Assert.assertEquals(arithmeticExpressionCalculating.getPriority("*"), 3);
        Assert.assertEquals(arithmeticExpressionCalculating.getPriority("/"), 3);
    }
}