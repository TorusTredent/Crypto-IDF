package by.cryptoidf.client;

import by.cryptoidf.dto.ApiCurrencyDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "${MARKET}", url = "${MARKET_URL}")
public interface MarketClient {

    @GetMapping(value = "${TICKER}", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    List<ApiCurrencyDTO> getMarkets(@RequestParam("id") Long[] ids);
}
