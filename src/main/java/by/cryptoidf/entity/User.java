package by.cryptoidf.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@Entity (name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "users_symbol_price", joinColumns = @JoinColumn(name = "user_id"))
    @MapKeyColumn(name = "symbol")
    @Column(name = "price")
    private Map<String, Double> symbolPrice;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Currency> currencies;
}
