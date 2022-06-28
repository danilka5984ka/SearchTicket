package ru.netology.domain;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TicketTest {
    Ticket ticket1 = new Ticket(1, 1299, "SVO", "KZN", 95);
    Ticket ticket2 = new Ticket(2, 1299, "SVO", "KZN", 95);
    Ticket ticket3 = new Ticket(3, 1299, "SVO", "KZN", 95);
    Ticket ticket4 = new Ticket(4, 2199, "VKO", "KZN", 95);
    Ticket ticket5 = new Ticket(5, 2269, "VKO", "KZN", 95);
    Ticket ticket6 = new Ticket(6, 2287, "VKO", "KZN", 95);

    TicketRepository repo = new TicketRepository();
    TicketManager manager = new TicketManager(repo);

    @Test
    public void shouldSaveAllProducts() {
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        repo.save(ticket4);
        repo.save(ticket5);
        repo.save(ticket6);

        Ticket[] actual = repo.findAll();
        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdOne() {
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        repo.save(ticket4);
        repo.save(ticket5);
        repo.save(ticket6);

        repo.removeById(1);

        Ticket[] actual = repo.findAll();
        Ticket[] expected = {ticket2, ticket3, ticket4, ticket5, ticket6};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdTwo() {
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        repo.save(ticket4);
        repo.save(ticket5);
        repo.save(ticket6);

        repo.removeById(1);
        repo.removeById(6);

        Ticket[] actual = repo.findAll();
        Ticket[] expected = {ticket2, ticket3, ticket4, ticket5};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchOne() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

        Ticket[] actual = manager.findTickets("SVO", "KZN");
        Ticket[] expected = {ticket1, ticket2, ticket3};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAndSortOne() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

        Ticket[] actual = manager.findTickets("VKO", "KZN");
        Ticket[] expected = {ticket4, ticket5, ticket6};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAndSortTwo() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

        Ticket[] actual = manager.findTickets("dfdf", "dfdfs");
        Ticket[] expected = {};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFoundException() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

        assertThrows(NotFoundException.class, () -> {
            repo.removeById(32);
        });
    }
}