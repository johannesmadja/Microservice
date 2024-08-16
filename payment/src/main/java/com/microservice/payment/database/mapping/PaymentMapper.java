package com.microservice.payment.database.mapping;

import org.mapstruct.Mapper;

import com.microservice.common.utils.mapStruct.EntityMapper;
import com.microservice.payment.database.domain.Payment;
import com.microservice.payment.database.dto.PaymentDto;

@Mapper(componentModel = "spring")
public interface PaymentMapper extends EntityMapper<PaymentDto, Payment> {
    PaymentDto mPayamentDto(Payment payment);
}
