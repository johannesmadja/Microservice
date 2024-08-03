package com.microservice.product.database.mapping;

import java.util.List;

public interface EntityMapper<D, E> {
    List<D> mapEntityToList(List<E> entities);
}   
