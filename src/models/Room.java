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
public class Room {

    private Integer idRoom;
    private String classRoom;
    private Integer placeRoom;
    private Integer price;
    private String status;
    private Integer timeOrder;

    public Room() {
    }

    public Room(Integer idRoom, String classRoom, Integer placeRoom, Integer price, String status, Integer TimeOrder) {
        this.idRoom = idRoom;
        this.classRoom = classRoom;
        this.placeRoom = placeRoom;
        this.price = price;
        this.status = status;
        this.timeOrder = TimeOrder;
    }

    public Integer getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(Integer idRoom) {
        this.idRoom = idRoom;
    }

    public String getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }

    public Integer getPlaceRoom() {
        return placeRoom;
    }

    public void setPlaceRoom(Integer placeRoom) {
        this.placeRoom = placeRoom;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getTimeOrder() {
        return timeOrder;
    }

    public void setTimeOrder(Integer timeOrder) {
        this.timeOrder = timeOrder;
    }

    @Override
    public String toString() {
        return "Room{" + "idRoom=" + idRoom + ", classRoom=" + classRoom + ", placeRoom=" + placeRoom + ", price=" + price + ", status=" + status + ", TimeOrder=" + timeOrder + '}';
    }

}
