package by.cryptoidf.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@Entity
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long currencyId;
    private String symbol;
    private double price;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "currencies")
    private Set<User> users;
}
