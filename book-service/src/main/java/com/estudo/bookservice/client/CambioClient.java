package com.estudo.bookservice.client;

import com.estudo.bookservice.model.Cambio;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;

@FeignClient(name = "cambio-service")
public interface CambioClient {

    @GetMapping(value = "/cambio-service/{amount}/{from}/{to}")
    Cambio getCambio (@PathVariable("amount") Double amount,
                             @PathVariable("from") String from,
                             @PathVariable("to") String to);
}
