package ru.netology.domain;

import java.util.Arrays;

public class TicketManager {
    private TicketRepository repository;

    public TicketManager (TicketRepository repository) {
        this.repository = repository;
    }

    void add(Ticket ticket) {
        repository.save(ticket);
    }

    public Ticket[] searchBy (String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repository.findAll()) {
            if (ticket.getFrom() == from && ticket.getTo() == to) {
                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

}