package by.cryptoidf.mapper;


import by.cryptoidf.dto.UserDto;
import by.cryptoidf.entity.User;

public class UserMapper {

    private UserMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static UserDto mapUserToUserDto(User user) {
        return UserDto.builder()
                .username(user.getUsername())
                .savePrices(user.getSymbolPrice())
                .currencies(user.getCurrencies().stream()
                        .map(CurrencyMapper::mapCurrencyToCurrencyDTO)
                        .toList())
                .build();
    }
}
