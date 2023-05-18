package by.cryptoidf.controller;

import by.cryptoidf.dto.UpdateProfileDTO;
import by.cryptoidf.dto.UserDto;
import by.cryptoidf.dto.UserRegDto;
import by.cryptoidf.entity.Currency;
import by.cryptoidf.entity.User;
import by.cryptoidf.exception.consts.ExMessageUser;
import by.cryptoidf.exception.dto.UserException;
import by.cryptoidf.service.CurrencyService;
import by.cryptoidf.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static by.cryptoidf.mapper.UserMapper.mapUserToUserDto;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final CurrencyService currencyService;

    @PostMapping("/notify")
    public ResponseEntity<UserDto> notify(@RequestBody UserRegDto userRegDto) {
        if (userService.existsByUsername(userRegDto.getUsername())) {
            throw new UserException(String.format(ExMessageUser.USER_WITH_NAME_IS_ALREADY_EXIST, userRegDto.getUsername()));
        }
        List<Currency> currencies = currencyService.findAllBySymbols(userRegDto.getSymbols());
        User userDb = userService.save(User.builder()
                .username(userRegDto.getUsername())
                .symbolPrice(currencyService.getSymbolPriceMapFromCurrencies(currencies))
                .currencies(currencies)
                .build());
        return ResponseEntity.ok(mapUserToUserDto(userDb));
    }

    @GetMapping("/profile/{username}")
    public ResponseEntity<UserDto> profile(@PathVariable String username) {
        return ResponseEntity.ok(mapUserToUserDto(userService.findByUsername(username)));
    }

    @PostMapping("/change-price")
    public ResponseEntity<UserDto> changePrice(@RequestBody UpdateProfileDTO updateProfileDTO) {
        return ResponseEntity.ok(mapUserToUserDto(userService.updateProfile(updateProfileDTO)));
    }
}
