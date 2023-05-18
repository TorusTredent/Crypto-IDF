package by.cryptoidf.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@AllArgsConstructor
@SuperBuilder
public class UpdateProfileDTO {

    String username;
    String symbol;
    double price;
}
