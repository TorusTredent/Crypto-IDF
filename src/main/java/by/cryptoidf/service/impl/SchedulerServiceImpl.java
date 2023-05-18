package by.cryptoidf.service.impl;

import by.cryptoidf.client.MarketClient;
import by.cryptoidf.dto.ApiCurrencyDTO;
import by.cryptoidf.entity.Currency;
import by.cryptoidf.service.CurrencyService;
import by.cryptoidf.service.SchedulerService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchedulerServiceImpl implements SchedulerService {

    private final CurrencyService currencyService;
    private final MarketClient marketClient;

    @Override
    @Scheduled(fixedRate = 60000L)
    public void marketScheduler() {
        List<Currency> currencies = currencyService.findAll();
        List<Long> currencyIds = currencyService.findAllCurrencyIds(currencies);
        List<ApiCurrencyDTO> apiCurrencyDTOS = marketClient.getMarkets(currencyIds.toArray(new Long[0]));
        currencyService.updateCurrenciesByCurrenciesDTO(currencies, apiCurrencyDTOS);
    }
}
