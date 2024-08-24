package com.microservice.client.controller.exception;

import feign.Response;
import feign.codec.ErrorDecoder;

public class CustomErrorDecoder implements ErrorDecoder{

    private ErrorDecoder defaultErrorDecoder = new ErrorDecoder.Default();

    @Override
    public Exception decode(String summoner, Response response) {
        if(response.status() == 400 ) {
            return new ProductBadRequestException(
                  "Requête incorrecte "
            );
          }
          return defaultErrorDecoder.decode(summoner, response);
    }

}
