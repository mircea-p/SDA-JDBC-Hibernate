package com.sda.mirceapopa.hibernate3.model;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name ="reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id")
    private Integer reservationId;
    @Column(name = "is_paid")
    private Integer isPaid;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToMany
    @JoinTable(name = "reservation_seat",
    joinColumns = {@JoinColumn(name = "reservation_id")},
    inverseJoinColumns = {@JoinColumn(name = "seat_id")})
    private Set<Seat> seatSet;

    public Reservation(Integer isPaid) {
        this.isPaid = isPaid;
    }

    public Reservation() {
    }

    public Integer getReservationId() {
        return reservationId;
    }

    public void setReservationId(Integer reservationId) {
        this.reservationId = reservationId;
    }

    public Integer getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(Integer isPaid) {
        this.isPaid = isPaid;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Set<Seat> getSeatSet() {
        return seatSet;
    }

    public void setSeatSet(Set<Seat> seatSet) {
        this.seatSet = seatSet;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationId=" + reservationId +
                ", isPaid=" + isPaid +
                '}';
    }
}
