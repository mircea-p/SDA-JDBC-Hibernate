package com.sda.mirceapopa.hibernate3.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "seats")
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seat_id")
    private Integer seatId;
    @Column(name = "seat_row")
    private Integer row;
    @Column(name = "seat_number")
    private Integer number;
    @ManyToMany(mappedBy = "seatSet")
    private Set<Reservation> reservationSet;

    public Seat(Integer row, Integer number) {
        this.row = row;
        this.number = number;
    }

    public Seat() {
    }

    public Integer getSeatId() {
        return seatId;
    }

    public void setSeatId(Integer seatId) {
        this.seatId = seatId;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Set<Reservation> getReservationSet() {
        return reservationSet;
    }

    public void setReservationSet(Set<Reservation> reservationSet) {
        this.reservationSet = reservationSet;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "seatId=" + seatId +
                ", row=" + row +
                ", number=" + number +
                '}';
    }
}
