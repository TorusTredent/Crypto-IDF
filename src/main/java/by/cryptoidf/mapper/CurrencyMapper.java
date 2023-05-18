package by.cryptoidf.mapper;

import by.cryptoidf.dto.CurrencyDTO;
import by.cryptoidf.entity.Currency;

import java.util.List;

public class CurrencyMapper {

    private CurrencyMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static CurrencyDTO mapCurrencyToCurrencyDTO(Currency currency) {
        return CurrencyDTO.builder()
                .currencyId(currency.getCurrencyId())
                .symbol(currency.getSymbol())
                .price(currency.getPrice())
                .build();
    }

    public static List<CurrencyDTO> mapCurrencyListToCurrencyDTOList(List<Currency> currencies) {
        return currencies.stream()
                .map(CurrencyMapper::mapCurrencyToCurrencyDTO)
                .toList();
    }
}
