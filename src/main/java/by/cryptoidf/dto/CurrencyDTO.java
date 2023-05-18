package by.cryptoidf.dto;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class CurrencyDTO {

    Long currencyId;
    String symbol;
    double price;
}
