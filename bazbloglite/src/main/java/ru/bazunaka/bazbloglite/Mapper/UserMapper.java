package ru.bazunaka.bazbloglite.Mapper;

import ru.bazunaka.bazbloglite.Dto.UserDto;
import ru.bazunaka.bazbloglite.Entity.User;

public class UserMapper {

    public static UserDto mapToUserDto(User user){
        return new UserDto(
                user.getId(),
                user.getUserName(),
                user.getFullName(),
                user.getBio()
        );
    }

    public static User mapToUser(UserDto userDto){
      return new User(
              userDto.getId(),
              userDto.getUserName(),
              userDto.getFullName(),
              userDto.getBio()
      );
    }
}
