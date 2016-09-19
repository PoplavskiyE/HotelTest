/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author fraian
 */
public class Booking {

    private Integer idBooking;
    private Integer idUser;
    private String placeRoom;
    private String classRoom;
    private String timeBooking;
    private Integer coinsidence;
    private Boolean payment;

    public Booking() {
    }

    public Booking(Integer idBooking, Integer idUser, String placeRoom, String classRoom, String timeBooking, Integer coinsidence, Boolean payment) {
        this.idBooking = idBooking;
        this.idUser = idUser;
        this.placeRoom = placeRoom;
        this.classRoom = classRoom;
        this.timeBooking = timeBooking;
        this.coinsidence = coinsidence;
        this.payment = payment;
    }

    public Booking(Integer idUser, String placeRoom, String classRoom, String timeBooking, Integer coinsidence, Boolean payment) {
        this.idUser = idUser;
        this.placeRoom = placeRoom;
        this.classRoom = classRoom;
        this.timeBooking = timeBooking;
        this.coinsidence = coinsidence;
        this.payment = payment;
    }

    public Integer getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(Integer idBooking) {
        this.idBooking = idBooking;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getPlaceRoom() {
        return placeRoom;
    }

    public void setPlaceRoom(String placeRoom) {
        this.placeRoom = placeRoom;
    }

    public String getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }

    public String getTimeBooking() {
        return timeBooking;
    }

    public void setTimeBooking(String timeBooking) {
        this.timeBooking = timeBooking;
    }

    public Integer getCoinsidence() {
        return coinsidence;
    }

    public void setCoinsidence(Integer coinsidence) {
        this.coinsidence = coinsidence;
    }

    public Boolean getPayment() {
        return payment;
    }

    public void setPayment(Boolean payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "Booking{" + "id=" + idBooking + ", idUser=" + idUser + ", placeRoom=" + placeRoom + ", classRoom=" + classRoom + ", timeOrder=" + timeBooking + ", coinsidence=" + coinsidence + ", payment=" + payment + '}';
    }

}
