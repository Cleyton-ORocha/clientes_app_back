package com.github.cleyton_orocha.clientes_app_back.util;

import java.math.BigDecimal;

public class BigDecimalConverter {

    public static BigDecimal valueOf(String value) {
        if (!value.isBlank()) {
            value = value.replace(".", "").replace(",", ".");
            return new BigDecimal(value);
        } 
        else return null;
    }

}
