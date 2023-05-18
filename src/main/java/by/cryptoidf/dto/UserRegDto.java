package by.cryptoidf.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class UserRegDto {

    String username;
    List<String> symbols;
}
