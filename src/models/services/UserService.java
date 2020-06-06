package models.services;

import java.util.ArrayList;
import java.util.List;

import models.dao.UserDao;
import models.dbaccess.ConnectionManager;
import models.dto.UserDto;

public class UserService {
    public List<UserDto> findById(Integer id) {
        List<UserDto> result = null;
        ConnectionManager connectionManager = new ConnectionManager();
        try {
            UserDao dao = new UserDao(connectionManager.getConnection());
            UserDto dto = dao.fetchById(id);
            result = new ArrayList<>();
            if (dto != null) {
                result.add(dto);
            }
        } catch (RuntimeException e) {
        } finally {
            connectionManager.closeConnection();
        }
        return result;
    }

    public List<UserDto> findAll() {
        List<UserDto> result = null;
        ConnectionManager connectionManager = new ConnectionManager();
        try {
            UserDao dao = new UserDao(connectionManager.getConnection());
            result = dao.fetchAll();
        } catch (RuntimeException e) {
        } finally {
            connectionManager.closeConnection();
        }
        return result;
    }

    public int add(UserDto dto) {
        int result = -1;
        ConnectionManager connectionManager = new ConnectionManager();
        try {
            UserDao dao = new UserDao(connectionManager.getConnection());
            result = dao.insert(dto);
            if (result > 0) {
                connectionManager.commit();
            } else {
                connectionManager.rollback();
            }
        } catch (RuntimeException e) {
            connectionManager.rollback();
        } finally {
            connectionManager.closeConnection();
        }
        return result;
    }

    public int edit(UserDto dto) {
        int result = -1;
        ConnectionManager connectionManager = new ConnectionManager();
        try {
            UserDao dao = new UserDao(connectionManager.getConnection());
            result = dao.update(dto);
            if (result > 0) {
                connectionManager.commit();
            } else {
                connectionManager.rollback();
            }
        } catch (RuntimeException e) {
            connectionManager.rollback();
        } finally {
            connectionManager.closeConnection();
        }
        return result;
    }

    public int remove(UserDto dto) {
        int result = -1;
        ConnectionManager connectionManager = new ConnectionManager();
        try {
            UserDao dao = new UserDao(connectionManager.getConnection());
            result = dao.delete(dto);
            if (result > 0) {
                connectionManager.commit();
            } else {
                connectionManager.rollback();
            }
        } catch (RuntimeException e) {
            connectionManager.rollback();
        } finally {
            connectionManager.closeConnection();
        }
        return result;
    }

    public List<UserDto> isValidSignIn(String name, String email) {
        List<UserDto> result = null;
        ConnectionManager connectionManager = new ConnectionManager();
        try {
            UserDao dao = new UserDao(connectionManager.getConnection());
            result = dao.fetchByNameAndEmail(name, email);
        } catch (RuntimeException e) {
        } finally {
            connectionManager.closeConnection();
        }
        return result;
    }
}
