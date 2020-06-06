package models.dxo;

import java.sql.ResultSet;
import java.sql.SQLException;

import models.dto.SignUpDto;
import models.dto.UserDto;

public class UserDxo {
    private UserDxo() {
    }

    public static UserDto convert(ResultSet rs) {
        UserDto dto = null;
        try {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String email = rs.getString("email");
            dto = new UserDto(id, name, email);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        return dto;
    }

    public static UserDto convert(SignUpDto signUpDto) {
        UserDto userDto = new UserDto();
        userDto.setName(signUpDto.getName());
        userDto.setEmail(signUpDto.getEmail());
        return userDto;
    }
}
