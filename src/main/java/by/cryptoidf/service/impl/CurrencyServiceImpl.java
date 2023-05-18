package by.cryptoidf.service.impl;

import by.cryptoidf.dto.ApiCurrencyDTO;
import by.cryptoidf.entity.Currency;
import by.cryptoidf.entity.User;
import by.cryptoidf.exception.dto.CurrencyException;
import by.cryptoidf.repository.CurrencyRepository;
import by.cryptoidf.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import static by.cryptoidf.exception.consts.ExMessageCurrency.CURRENCY_WITH_CUR_ID_NOT_FOUND;
import static by.cryptoidf.exception.consts.ExMessageCurrency.SMTH_INCORRECTLY_ENTERED;

@Service
@RequiredArgsConstructor
@Slf4j
public class CurrencyServiceImpl implements CurrencyService {

    private final CurrencyRepository currencyRepository;

    @Override
    public List<Currency> findAll() {
        return currencyRepository.findAll();
    }

    @Override
    public List<Long> findAllCurrencyIds(List<Currency> currencies) {
        return getAllCurrenciesId(currencies);
    }

    @Override
    public void updateCurrenciesByCurrenciesDTO(List<Currency> currencies, List<ApiCurrencyDTO> apiCurrencyDTOS) {
        updatePrice(currencies, apiCurrencyDTOS);
        checkUsersPrices(currencies);
        updateAll(currencies);
    }

    @Override
    public void updateAll(List<Currency> currencies) {
        currencyRepository.saveAll(currencies);
    }

    @Override
    public List<Currency> findAllBySymbols(List<String> symbols) {
        List<Currency> currencies = currencyRepository.findAllBySymbolIn(symbols.stream()
                        .distinct()
                        .toList())
                .orElseThrow(() -> new CurrencyException(String.format(SMTH_INCORRECTLY_ENTERED, symbols)));
        if (currencies.size() < symbols.size()) {
            throw new CurrencyException(String.format(SMTH_INCORRECTLY_ENTERED, symbols));
        }
        return currencies;
    }

    @Override
    public Currency findByCurrencyId(Long currencyId) {
        return currencyRepository.findByCurrencyId(currencyId)
                .orElseThrow(() -> new CurrencyException(String.format(CURRENCY_WITH_CUR_ID_NOT_FOUND, currencyId)));
    }

    @Override
    public Map<String, Double> getSymbolPriceMapFromCurrencies(List<Currency> currencies) {
        return currencies.stream()
                .collect(Collectors.toMap(Currency::getSymbol, Currency::getPrice));
    }


    private void updatePrice(List<Currency> currencies, List<ApiCurrencyDTO> apiCurrencyDTOS) {
        currencies.forEach(currency -> apiCurrencyDTOS.stream()
                .filter(apiCurrencyDTO -> Objects.equals(currency.getCurrencyId(), apiCurrencyDTO.getId()))
                .forEach(apiCurrencyDTO -> currency.setPrice(apiCurrencyDTO.getPrice_usd())));
    }

    private void checkUsersPrices(List<Currency> currencies) {
        for (Currency currency : currencies) {
            if (currency.getUsers().isEmpty()) break;
            for (User user : currency.getUsers()) {
                double userPrice = user.getSymbolPrice().get(currency.getSymbol());
                double percent = (currency.getPrice() - userPrice) / userPrice * 100;
                if (percent >= 1 || percent <= -1) {
                    log.warn("{} - {} - {}%", user.getUsername(), currency.getSymbol(), percent);
                }
            }
        }
    }

    private List<Long> getAllCurrenciesId(List<Currency> currencies) {
        return currencies.stream()
                .map(Currency::getCurrencyId)
                .toList();
    }
}
