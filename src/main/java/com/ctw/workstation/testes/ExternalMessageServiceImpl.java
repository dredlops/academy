package com.ctw.workstation.testes;

public class ExternalMessageServiceImpl implements ExternalMessageService {

    @Override
    public String sayHelloFromOuterSpace() {
        return "Hello from outer space";
    }

    @Override
    public String sayHelloFromOuterSpace(String name) {
        return "Hello from outer space" + name;
    }
}
