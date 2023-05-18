package by.cryptoidf.repository;

import by.cryptoidf.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Long> {

    Optional<List<Currency>> findAllBySymbolIn(List<String> symbol);

    Optional<Currency> findByCurrencyId(Long currencyId);
}
