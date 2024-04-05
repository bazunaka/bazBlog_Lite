package ru.bazunaka.bazbloglite.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long Id;
    private String fullName;
    private String userName;
    private String bio;
}
