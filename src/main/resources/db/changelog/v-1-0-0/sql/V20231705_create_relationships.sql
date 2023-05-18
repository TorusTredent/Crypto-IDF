ALTER TABLE users_currencies
    ADD CONSTRAINT fk_usecur_on_currency FOREIGN KEY (currencies_id) REFERENCES currency (id);

ALTER TABLE users_currencies
    ADD CONSTRAINT fk_usecur_on_user FOREIGN KEY (users_id) REFERENCES users (id);

ALTER TABLE users_symbol_price
    ADD CONSTRAINT fk_users_symbol_price_on_user FOREIGN KEY (user_id) REFERENCES users (id);