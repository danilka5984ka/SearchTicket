package ru.netology.domain;

import java.util.Objects;

public class Ticket implements Comparable<Ticket>{
    private int id;
    private int price;
    private String from;
    private String to;
    private int time;

    public Ticket(int id, int price, String departure, String arrival, int time) {
        this.id = id;
        this.price = price;
        this.from = departure;
        this.to = arrival;
        this.time = time;
    }

    public boolean matches(String search) {
        return from.contains(search);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void getTo(String to) {
        this.to = to;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int toInt() {
        return price;
    }

    @Override
    public int compareTo(Ticket otherPrice) {
        if (price < otherPrice.price ) {
            return -1;
        }
        if (price > otherPrice.price) {
            return 1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return id == ticket.id && price == ticket.price && time == ticket.time && Objects.equals(from, ticket.from) && Objects.equals(to, ticket.to);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, from, to, time);
    }
}
