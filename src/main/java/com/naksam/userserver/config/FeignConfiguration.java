package com.naksam.userserver.config;

import com.naksam.userserver.feign.FeignErrorDecode;
import feign.codec.ErrorDecoder;
import org.springframework.cloud.openfeign.FeignFormatterRegistrar;
import org.springframework.context.annotation.Bean;
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;

public class FeignConfiguration {

    @Bean
    public FeignFormatterRegistrar localDateFeignFormatterRegister() {
        return registry -> {
            DateTimeFormatterRegistrar registrar = new DateTimeFormatterRegistrar();
            registrar.setUseIsoFormat(true);
            registrar.registerFormatters(registry);
        };
    }

    @Bean
    public ErrorDecoder decoder() {
        return new FeignErrorDecode();
    }
}