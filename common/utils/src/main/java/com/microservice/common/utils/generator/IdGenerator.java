package com.microservice.common.utils.generator;

import java.util.UUID;

public class IdGenerator {

    public IdGenerator(){ /* The contructor is empty because the class contains a only static method */ }

    public static String generate(String prefix) {
        return prefix + '-'+ UUID.randomUUID().toString();
    }
}
