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
import models.Room;
import models.Booking;

/**
 *
 * @author fraian
 */
public class RoomDAO extends AbstractDAO<Room> {

    private static final String SELECT_QUERY_ALL_ROOM = "SELECT * FROM room ORDER BY idRoom";
    private static final String INSERT_QUERY_ROOM = "INSERT INTO room (idRoom,classRoom,placeRoom,price,status,timeOrder) VALUES (?,?,?,?,?,?)";
    private static final String DELETE_QUERY_ROOM = "DELETE FROM room WHERE idRoom =?";
    private static final String SET_STATUS_OCCUP = "UPDATE room SET status='occupied', timeOrder=? WHERE idRoom=?";
    private static final String SET_STATUS_NOT_OCCUP = "UPDATE room SET status='not occupied', timeOrder='0' WHERE idRoom=?";
    private static final String FIND_COINSIDENSE = "SELECT * FROM room WHERE classRoom=? AND placeRoom=? AND status='not occupied'";

    public RoomDAO() {
        this.connector = new ConnectorDB();
    }

    @Override
    public void insert(Room value) {
        PreparedStatement ps = null;
        try {
            ps = connector.getPreparedStatement(INSERT_QUERY_ROOM);
            ps.setInt(1, value.getIdRoom());
            ps.setString(2, value.getClassRoom());
            ps.setInt(3, value.getPlaceRoom());
            ps.setInt(4, value.getPrice());
            ps.setString(5, value.getStatus());
            ps.setInt(6, value.getTimeOrder());
            ps.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeStatement(ps);
        }
    }

    @Override
    public void delete(Room value) {
        PreparedStatement ps = null;
        try {
            ps = connector.getPreparedStatement(DELETE_QUERY_ROOM);
            ps.setInt(1, value.getIdRoom());
            ps.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeStatement(ps);
        }
    }

    @Override
    public List<Room> getAll() {
        Statement st = null;
        ResultSet rs = null;
        List<Room> rooms = new ArrayList<>();
        try {
            st = connector.getStatement();
            rs = st.executeQuery(SELECT_QUERY_ALL_ROOM);
            while (rs.next()) {
                Room r = new Room();
                r.setIdRoom(rs.getInt(1));
                r.setClassRoom(rs.getString(2));
                r.setPlaceRoom(rs.getInt(3));
                r.setPrice(rs.getInt(4));
                r.setStatus(rs.getString(5));
                r.setTimeOrder(rs.getInt(6));
                rooms.add(r);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeStatement(st);
        }
        return rooms;
    }

    public Integer findCoinsidence(String classRoom, String countPlace) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Integer idRoom = 0;
        try {
            ps = connector.getPreparedStatement(FIND_COINSIDENSE);
            ps.setString(1, classRoom);
            ps.setString(2, countPlace);
            rs = ps.executeQuery();
            //если получили что-нибудь из БД комнат, то ...
            if (rs.next()) {//.getString(5)).equalsIgnoreCase("not occupied"
                //выбираем первое совпадение...
                rs.first();
                idRoom = rs.getInt(1);
                return idRoom;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeStatement(ps);
        }
        return idRoom;
    }

    /*//метод ниже заменен на метод выше только потому,
      //что нужно получить лишь номер комнаты(Integer) подходящей по условиям
    public Room findCoinsidence(String classRoom, String countPlace) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connector.getPreparedStatement(FIND_COINSIDENSE);
            ps.setString(1, classRoom);
            ps.setString(2, countPlace);
            rs = ps.executeQuery();
            //если получили что-нибудь из БД комнат, то ...
            if (rs.next()) {//.getString(5)).equalsIgnoreCase("not occupied"
                //выбираем первое совпадение...
                rs.first();
                Room r = new Room();
                r.setIdRoom(rs.getInt(1));
                r.setClassRoom(rs.getString(2));
                r.setPlaceRoom(rs.getInt(3));
                r.setPrice(rs.getInt(4));
                r.setStatus(rs.getString(5));
                r.setTimeOrder(rs.getInt(6));
                rs.close();
                ps.close();
                return r;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeStatement(ps);
        }
        return null;
    }*/
    public void setStatusRoomOcup(Booking book) {
        PreparedStatement ps = null;
        try {
            ps = connector.getPreparedStatement(SET_STATUS_OCCUP);
            ps.setInt(1, Integer.valueOf(book.getTimeBooking()));
            ps.setInt(2, book.getCoinsidence());
            ps.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeStatement(ps);
        }
    }

    public void setStatusRoomNotOcup(Booking book) {
        PreparedStatement ps = null;
        try {
            ps = connector.getPreparedStatement(SET_STATUS_NOT_OCCUP);
            ps.setInt(1, book.getCoinsidence());
            ps.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeStatement(ps);
        }
    }
}
