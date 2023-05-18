package by.cryptoidf.service.impl;

import by.cryptoidf.dto.UpdateProfileDTO;
import by.cryptoidf.entity.User;
import by.cryptoidf.exception.consts.ExMessageCurrency;
import by.cryptoidf.exception.dto.CurrencyException;
import by.cryptoidf.exception.dto.UserException;
import by.cryptoidf.repository.UserRepository;
import by.cryptoidf.service.CurrencyService;
import by.cryptoidf.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static by.cryptoidf.exception.consts.ExMessageUser.USER_WITH_NAME_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final CurrencyService currencyService;

    @Override
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UserException(String.format(USER_WITH_NAME_NOT_FOUND, username)));
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateProfile(UpdateProfileDTO updateProfileDTO) {
        User user = findByUsername(updateProfileDTO.getUsername());
        if (!user.getSymbolPrice().containsKey(updateProfileDTO.getSymbol())) {
            throw new CurrencyException(ExMessageCurrency.CURRENCY_WITH_SYMBOL_NOT_FOUND);
        }
        user.getSymbolPrice().put(updateProfileDTO.getSymbol(), updateProfileDTO.getPrice());
        return save(user);
    }
}
