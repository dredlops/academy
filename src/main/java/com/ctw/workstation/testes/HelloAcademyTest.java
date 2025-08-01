package com.ctw.workstation.testes;

import org.jboss.logging.Logger;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class HelloAcademyTest {

    private static final Logger log = Logger.getLogger(HelloAcademyTest.class);

    HelloAcademy helloAcademy;

    @BeforeAll
    void init() {
        log.info("Before All");
        helloAcademy = new HelloAcademy();
    }

    @BeforeEach
    void setUp() {}

    @AfterEach
    void afterEach() {
        log.info("After Each");
    }

    @AfterAll
    static void afterAll() {
        log.info("After All");
    }



    public static Stream<Arguments> provide_name() {
        return Stream.of(
                Arguments.of("Rennan", "Hello Rennan"),
                Arguments.of("Joao", "Hello Joao"),
                Arguments.of("Diogo", "Hello Diogo")
        );
    }

    @Order(1)
    @ParameterizedTest
    @MethodSource(value = "provide_name")
    @DisplayName("When providing a name to say hello, just Hello \" \" should be returned")
    void provide_name(String name, String expected){
        // GIVEN
        HelloAcademy helloAcademy = new HelloAcademy();

        // WHEN
        String actualName = helloAcademy.sayHello(name);

        // THEN
        assertThat(actualName)
                .isNotNull()
                .isNotEmpty()
                .startsWith("Hello ");
        assertAll(
                () -> assertNotNull(actualName),
                () -> assertEquals(expected, actualName)
        );
    }

    @Order(2)
    @Test
    @DisplayName("WWWWhen providing a null name to say hello just Hello should be returned")
    void provide_null_name() {
        // GIVEN
        HelloAcademy helloAcademy = new HelloAcademy();
        String name = null;
        // WHEN
        String actualName = helloAcademy.sayHello(name);
        // THEN
        assertEquals("Hello", actualName, "Returned named should be only \"Hello\"");
    }

    @Test
    @DisplayName("When providing no name, just Hello  should be returned")
    void provide_no_name(){
        // GIVEN
        HelloAcademy helloAcademy = new HelloAcademy();
        String name = "";
        // WHEN
        String actualName = helloAcademy.sayHello(name);
        // THEN
        assertEquals("Hello ", actualName, "Returned named should be only \"\"");
    }
}