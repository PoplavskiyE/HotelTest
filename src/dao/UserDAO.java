/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dbconnector.ConnectorDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.User;

/**
 *
 * @author fraian
 */
public class UserDAO extends AbstractDAO<User> {

    public UserDAO() {
        this.connector = new ConnectorDB();
    }

    private static final String SELECT_QUERY_ALL_USER = "SELECT * FROM user";
    private static final String INSERT_QUERY_USER = "INSERT INTO user (login, password, email, phone) "
            + "VALUES (?, ?, ?, ?)";
    private static final String DELETE_QUERY_USER = "DELETE FROM user WHERE `id`=?";
    private static final String SELECT_QUERY_USER_BY_NAME = "SELECT * FROM user WHERE `login`=?";
    private static final String SELECT_QUERY_USER_BY_ID = "SELECT * FROM user WHERE `id`=?";
    private static final String SELECT_QUERY_USER_BY_NAME_AND_PASS = "SELECT * FROM user WHERE `login`=? "
            + "AND `password`=?";
    //PreparedStatement ps = null;

    @Override
    public void insert(User value) {
        PreparedStatement ps = null;
        try {
            ps = connector.getPreparedStatement(INSERT_QUERY_USER);
            ps.setString(1, value.getLogin());
            ps.setString(2, value.getPassword());
            ps.setString(3, value.getEmail());
            ps.setString(4, value.getPhone());
            ps.execute();
            //ps.executeQuery();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeStatement(ps);
        }

    }

    @Override
    public void delete(User value) {
        PreparedStatement ps = null;
        try {
            ps = connector.getPreparedStatement(DELETE_QUERY_USER);
            ps.setInt(1, value.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeStatement(ps);
        }
    }

    @Override
    public List<User> getAll() {
        Statement st = null;
        ResultSet rs = null;
        List<User> users = new ArrayList<>();
        try {
            st = connector.getStatement();
            rs = st.executeQuery(SELECT_QUERY_ALL_USER);
            while (rs.next()) {
                users.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeStatement(st);
        }
        return users;
    }

    public User getUserByName(String userName) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;
        try {
            ps = connector.getPreparedStatement(SELECT_QUERY_USER_BY_NAME);
            ps.setString(1, userName);
            rs = ps.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt(1));
                user.setLogin(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setEmail(rs.getString(4));
                user.setPhone(rs.getString(5));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeStatement(ps);
        }
        return user;
    }

    public User getUserByNameAndPass(String userName, String password) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;
        try {
            ps = connector.getPreparedStatement(SELECT_QUERY_USER_BY_NAME_AND_PASS);
            ps.setString(1, userName);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while (rs.next()) {
                user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeStatement(ps);
        }
        return user;
    }

    public User getUserById(Integer idUser) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;
        try {
            ps = connector.getPreparedStatement(SELECT_QUERY_USER_BY_ID);
            ps.setInt(1, idUser);
            rs = ps.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt(1));
                user.setLogin(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setEmail(rs.getString(4));
                user.setPhone(rs.getString(5));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeStatement(ps);
        }
        return user;
    }

}
