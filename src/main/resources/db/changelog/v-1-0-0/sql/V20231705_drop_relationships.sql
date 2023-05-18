ALTER TABLE users_currencies
    DROP FOREIGN KEY fk_usecur_on_currency;

ALTER TABLE users_currencies
    DROP FOREIGN KEY fk_usecur_on_user;
    
ALTER TABLE users_symbol_price
    DROP FOREIGN KEY fk_users_symbol_price_on_user;