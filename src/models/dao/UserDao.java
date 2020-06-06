package models.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.dto.UserDto;
import models.dxo.UserDxo;

public class UserDao extends BaseDao {

    public UserDao(Connection connection) {
        super(connection);
    }

    public UserDto fetchById(Integer id) {
        UserDto dto = null;
        String sql = "select * from users where id = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                dto = UserDxo.convert(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        return dto;
    }

    public List<UserDto> fetchAll() {
        List<UserDto> list = new ArrayList<>();
        String sql = "select * from users";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                UserDto dto = UserDxo.convert(rs);
                list.add(dto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        return list;
    }

    public List<UserDto> fetchByNameAndEmail(String name, String email) {
        List<UserDto> list = new ArrayList<>();
        String sql = "select * from users where name = ? and email = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setString(2, email);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                UserDto dto = UserDxo.convert(rs);
                list.add(dto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        return list;
    }

    public int insert(UserDto dto) {
        int result = -1;
        String sql = "insert into users (name, email) values (?, ?)";
        String[] pkName = { "id" };
        try (PreparedStatement ps = getConnection().prepareStatement(sql, pkName)) {
            ps.setString(1, dto.getName());
            ps.setString(2, dto.getEmail());
            result = ps.executeUpdate();
            if (result > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                while (rs.next()) {
                    result = rs.getInt("id");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        return result;
    }

    public int update(UserDto dto) {
        int result = -1;
        String sql = "update users set name = ?, email = ? where id = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, dto.getName());
            ps.setString(2, dto.getEmail());
            ps.setInt(3, dto.getId());
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        return result;
    }

    public int delete(UserDto dto) {
        int result = -1;
        String sql = "delete from users where id = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setInt(1, dto.getId());
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        return result;
    }
}
