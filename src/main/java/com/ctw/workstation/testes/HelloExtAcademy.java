package com.ctw.workstation.testes;

public class HelloExtAcademy {



    ExternalMessageService externalMessageService;

    protected HelloExtAcademy(ExternalMessageService externalMessageServiceSpy) {
        this.externalMessageService = externalMessageServiceSpy;
    }

    public String sayHello(String name) {
        if(name != null) {
            return externalMessageService.sayHelloFromOuterSpace(name);
        }else{
            return externalMessageService.sayHelloFromOuterSpace();
        }
    }
}
