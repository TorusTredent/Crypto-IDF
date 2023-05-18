package by.cryptoidf.controller;


import by.cryptoidf.dto.CurrencyDTO;
import by.cryptoidf.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static by.cryptoidf.mapper.CurrencyMapper.mapCurrencyListToCurrencyDTOList;
import static by.cryptoidf.mapper.CurrencyMapper.mapCurrencyToCurrencyDTO;

@Controller
@RequestMapping("/currency")
@RequiredArgsConstructor
public class CurrencyController {

    private final CurrencyService currencyService;

    @GetMapping("/all")
    public ResponseEntity<List<CurrencyDTO>> getAll() {
        return ResponseEntity.ok(mapCurrencyListToCurrencyDTOList(currencyService.findAll()));
    }

    @GetMapping("/{currencyId}")
    public ResponseEntity<CurrencyDTO> getByCurrencyId(@PathVariable Long currencyId) {
        return ResponseEntity.ok(mapCurrencyToCurrencyDTO(currencyService.findByCurrencyId(currencyId)));
    }
}
