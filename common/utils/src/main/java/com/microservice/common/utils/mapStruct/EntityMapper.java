package com.microservice.common.utils.mapStruct;

import java.util.List;

public interface EntityMapper<D, E> {
    List<D> mapEntityToList(List<E> entities);
}
