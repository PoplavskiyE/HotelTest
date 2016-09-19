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
import models.Booking;

/**
 *
 * @author fraian
 */
public class BookingDAO extends AbstractDAO<Booking> {

    private static final String SELECT_QUERY_ALL_BOOKING = "SELECT * FROM booking"; //ORDER BY idOrder";
    private static final String INSERT_QUERY_BOOKING = "INSERT INTO booking (idUser,placeRoom,classRoom,"
            + "timeBooking,coinsidence,payment) VALUES (?,?,?,?,?,?)";
    private static final String DELETE_QUERY_BOOKING = "DELETE FROM booking WHERE idBooking=?";
    private static final String SET_PAYMENT_TRUE = "UPDATE booking SET payment=true WHERE idUser=?";
    private static final String SELECT_QUERY_GET_BOOKING_BY_ID = "SELECT * FROM booking WHERE idBooking=?";
    private static final String SELECT_QUERY_GET_BOOKING_BY_ID_USER = "SELECT * FROM booking WHERE idUser=?";

    public BookingDAO() {
        this.connector = new ConnectorDB();
    }

    @Override
    public void insert(Booking booking) {
        PreparedStatement ps = null;
        try {
            ps = connector.getPreparedStatement(INSERT_QUERY_BOOKING);
            ps.setInt(1, booking.getIdUser());
            ps.setString(2, booking.getPlaceRoom());
            ps.setString(3, booking.getClassRoom());
            ps.setString(4, booking.getTimeBooking());
            ps.setInt(5, booking.getCoinsidence());
            ps.setBoolean(6, false);
            ps.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeStatement(ps);
        }
    }

    @Override
    public void delete(Booking booking) {
        PreparedStatement ps = null;
        try {
            ps = connector.getPreparedStatement(DELETE_QUERY_BOOKING);
            ps.setInt(1, booking.getIdBooking());
            ps.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeStatement(ps);
        }
    }

    @Override
    public List<Booking> getAll() {
        Statement st = null;
        ResultSet rs = null;
        List<Booking> bookings = new ArrayList<>();
        try {
            st = connector.getStatement();
            rs = st.executeQuery(SELECT_QUERY_ALL_BOOKING);
            while (rs.next()) {
                Booking book = new Booking();
                book.setIdBooking(rs.getInt(1));
                book.setIdUser(rs.getInt(2));
                book.setPlaceRoom(rs.getString(3));
                book.setClassRoom(rs.getString(4));
                book.setTimeBooking(rs.getString(5));
                book.setCoinsidence(rs.getInt(6));
                book.setPayment(rs.getBoolean(7));
                bookings.add(book);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeStatement(st);
        }
        return bookings;
    }

    public Booking getBookingById(Integer idBooking) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Booking b = null;
        try {
            ps = connector.getPreparedStatement(SELECT_QUERY_GET_BOOKING_BY_ID);
            ps.setInt(1, idBooking);
            rs = ps.executeQuery();
            if (rs.next()) {
                b = new Booking(rs.getInt(1), rs.getInt(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getInt(6), rs.getBoolean(7));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeStatement(ps);
        }

        return b;

    }

    public Booking getBookingByIdUser(Integer idUser) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Booking b = null;
        try {
            ps = connector.getPreparedStatement(SELECT_QUERY_GET_BOOKING_BY_ID_USER);
            ps.setInt(1, idUser);
            rs = ps.executeQuery();
            if (rs.next()) {
                b = new Booking(rs.getInt(1), rs.getInt(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getInt(6), rs.getBoolean(7));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeStatement(ps);
        }
        return b;
    }

    public void setPaymentTrue(Booking book) {
        PreparedStatement ps = null;
        try {
            ps = connector.getPreparedStatement(SET_PAYMENT_TRUE);
            ps.setInt(1, book.getIdUser());
            ps.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeStatement(ps);
        }
    }
    /*
    
    public void setCoinsidence(String idRoom, String loginOrder,Connection connector) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = connector.prepareStatement("UPDATE order SET coinsidence=? WHERE login=?");
            ps.setString(1, idRoom);
            ps.setString(2, loginOrder);
            ps.execute();
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }*/
}
