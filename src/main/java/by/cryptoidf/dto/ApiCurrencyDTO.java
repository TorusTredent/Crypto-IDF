package by.cryptoidf.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@AllArgsConstructor
@SuperBuilder
public class ApiCurrencyDTO {

    Long id;
    double price_usd;
    String symbol;
    String name;
    String nameId;
    String rank;
    String percent_change_24h;
    String percent_change_1h;
    String percent_change_7d;
    String market_cap_usd;
    String volume24;
    String volume24_native;
    String csupply;
    String price_btc;
    String tsupply;
    String msupply;
}
