package com.ctw.workstation.testes;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.DoNotMock;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

class HelloExtAcademyTest {

    HelloExtAcademy helloExtAcademy;
    ExternalMessageService externalMessageServiceSpy;

    @BeforeEach
    void setUp() {
        externalMessageServiceSpy = Mockito.spy(new ExternalMessageServiceImpl());
        helloExtAcademy = new HelloExtAcademy(externalMessageServiceSpy);
    }

    @Test
    @DisplayName("When providing a null name, a message from outer space should be returned")
    void when_providing_a_null_name() {
        // GIVEN
        String name = null;
        //ExternalMessageService externalMessageServiceMock = Mockito.mock(ExternalMessageService.class);
        //helloExtAcademy.externalMessageService = externalMessageServiceMock;
        Mockito.doReturn("Hey Diogo")
                        .when(externalMessageServiceSpy)
                        .sayHelloFromOuterSpace(name);
        //Mockito.when(externalMessageServiceSpy.sayHelloFromOuterSpace()).thenReturn("Hello from outer space");

        // WHEN
        String actualName = helloExtAcademy.sayHello(name);

        // THEN
        Assertions.assertThat(actualName)
                .as("valid message is returned even when provided a null name")
                .isEqualTo("Hello from outer space");
    }

    @Test
    @DisplayName("When providing a valid name, a hello from outer space for the given name is returned")
    void when_providing_a_valid_name() {
        // GIVEN
        String name = "Diogo";
        String otherName = "Neves";
        ExternalMessageService externalMessageServiceMock = Mockito.mock(ExternalMessageService.class);
        helloExtAcademy.externalMessageService = externalMessageServiceMock;
        Mockito.when(externalMessageServiceMock.sayHelloFromOuterSpace(name)).thenReturn("Hello Diogo");

        // WHEN
        String actualName = helloExtAcademy.sayHello(name);

        // THEN
        Assertions.assertThat(actualName)
                .isEqualTo("Hello Diogo");
    }

    @Test
    void spy_test(){
        ArrayList<String> list = new ArrayList<>();
        List<String> spiedList = Mockito.spy(list);
        Mockito.doReturn("Hello").when(spiedList).get(0);
    }
}