package by.cryptoidf.service;

import by.cryptoidf.dto.ApiCurrencyDTO;
import by.cryptoidf.entity.Currency;

import java.util.List;
import java.util.Map;

public interface CurrencyService {
    List<Currency> findAll();

    List<Long> findAllCurrencyIds(List<Currency> currencies);

    void updateCurrenciesByCurrenciesDTO(List<Currency> currencies, List<ApiCurrencyDTO> apiCurrencyDTOS);

    void updateAll(List<Currency> currencies);

    List<Currency> findAllBySymbols(List<String> symbols);

    Currency findByCurrencyId(Long currencyId);

    Map<String, Double> getSymbolPriceMapFromCurrencies(List<Currency> currencies);
}
