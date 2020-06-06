package models.dto;

import java.util.ArrayList;
import java.util.List;

public class TopDto {
    private List<UserDto> users = new ArrayList<>();

    public TopDto() {
    }

    public TopDto(List<UserDto> users) {
        super();
        this.setUsers(users);
    }

    public List<UserDto> getUsers() {
        return users;
    }

    public void setUsers(List<UserDto> users) {
        this.users = users;
    }
}
