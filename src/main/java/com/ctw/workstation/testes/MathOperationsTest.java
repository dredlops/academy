package com.ctw.workstation.testes;

import org.assertj.core.api.Assertions;
import org.jboss.logging.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MathOperationsTest {

    private static final Logger log = Logger.getLogger(MathOperationsTest.class);

    MathOperations mathOperations;

    @BeforeAll
    void init(){
        log.info("Before All");
        mathOperations = new MathOperations();
    }

    @ParameterizedTest
    @MethodSource(value = "provided_add_ints")
    @DisplayName("Testing adding numbers")
    void provided_add_ints(int a, int b, int expected){
        int actual = mathOperations.add(a,b);
        assertEquals(expected, actual);
    }

    public Stream<Arguments> provided_add_ints() {
        return Stream.of(
                Arguments.of(2, 2, 5),
                Arguments.of(2, 4, 6)
        );
    }

    @ParameterizedTest
    @MethodSource(value = "provided_divided_ints")
    @DisplayName("Testing dividing numbers")
    void provided_divide_ints(int a, int b, int expected){
        int actual = mathOperations.div(a,b);
        assertEquals(expected, actual);
    }

    public Stream<Arguments> provided_divided_ints() {
        return Stream.of(
                Arguments.of(4, 2, 2),
                Arguments.of(12, 3, 4)
        );
    }

    @Test
    @DisplayName("Testing dividing by zero")
    void provided_divide_ints_by_zero(){
        Assertions.assertThatException().isThrownBy(() -> mathOperations.div(4, 0));
    }
}