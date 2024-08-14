package com.microservice.product.database.domain.generator;

import java.lang.reflect.Member;

import org.hibernate.generator.GeneratorCreationContext;
import org.hibernate.id.uuid.UuidGenerator;



public class IdGenerator extends UuidGenerator{

    public IdGenerator(org.hibernate.annotations.UuidGenerator config, Member member,
            GeneratorCreationContext creationContext) {
        super(config, member, creationContext);
    }
}
