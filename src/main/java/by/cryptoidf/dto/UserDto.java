package by.cryptoidf.dto;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.Map;

@Getter
@SuperBuilder
public class UserDto {

    String username;
    Map<String, Double> savePrices;
    List<CurrencyDTO> currencies;
}
