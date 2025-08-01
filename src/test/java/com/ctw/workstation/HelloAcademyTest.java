/*package com.ctw.workstation;

import org.jboss.logging.Logger;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class HelloAcademyTest {

    private static final Logger log = Logger.getLogger(HelloAcademyTest.class.getName());

    private static HelloAcademy helloAcademy;

    @BeforeAll
    static void setup(){
        log.info("Setting up");
        helloAcademy = new HelloAcademy();
    }

    @BeforeEach
    void beforeEach(){
        log.info("Next Test");

    }

    @Order(1)
    @Test
    void provide_null_name() {
        //given
        String name = null;

        assertThat(name).isNull();

        //When
        String s = helloAcademy.sayHello(name);
        assertThat(s).isEqualTo("Hello Academy").describedAs("Test if name is null");
    }

    @Order(2)
    @Test
    void provide_empty_name() {
        //given
        String name = "";

        //When
        String s = helloAcademy.sayHello(name);
        assertThat(s).isNotNull().isEqualTo("Hello Academy").describedAs("Test with empty name");
    }

    public static Stream<Arguments> provide_valid_name() {
        return Stream.of(
                Arguments.of("João", "Hello João"),
                Arguments.of("Pedro", "Hello Pedro"),
                Arguments.of("Carlos",  "Hello Carlos")
        );
    }

    @Order(3)
    @ParameterizedTest
    @MethodSource
    void provide_valid_name(String name, String expectedName) {
        //given

        String actualName = helloAcademy.sayHello(name);
        //When
        String s = helloAcademy.sayHello(name);
        assertThat(actualName).isEqualTo(expectedName).describedAs("Test with valid name");
    }



}*/