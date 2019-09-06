package com.tts.lambdas;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class StreamTests {
    @Test
    public void sumIntegersInArray() {
        int[] numbers = {3, 1, 4, 1, 5, 9};
        int total = Arrays.stream(numbers).sum();
        assertEquals(23, total);
    }

    @Test
    public void sumBigInteger() {
        BigDecimal total = Stream.iterate(BigDecimal.ZERO, n -> n.add(BigDecimal.ONE))
                .limit(10)
                .reduce(BigDecimal.ZERO, (accumulator, y) -> {
                    System.out.println("x = " + accumulator + ", y = " + y);
                    return accumulator.add(y);
                });

        System.out.println(total);
    }
}
