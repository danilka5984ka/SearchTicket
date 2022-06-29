package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketTest {
    Ticket ticket1 = new Ticket(1, 1299, "SVO", "KZN", 95);
    Ticket ticket2 = new Ticket(2, 1299, "SVO", "KZN", 95);
    Ticket ticket3 = new Ticket(3, 2399, "VKO", "KZN", 95);
    Ticket ticket4 = new Ticket(4, 2269, "VKO", "KZN", 95);
    Ticket ticket5 = new Ticket(5, 2287, "VKO", "KZN", 95);

    TicketRepository repo = new TicketRepository();
    TicketManager manager = new TicketManager(repo);

    @Test
    public void shouldSaveAllTickets() {
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        repo.save(ticket4);
        repo.save(ticket5);

        Ticket[] actual = repo.findAll();
        Ticket[] expected = { ticket1, ticket2, ticket3, ticket4, ticket5 };

        assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldRemoveByIdOne() {
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        repo.save(ticket4);
        repo.save(ticket5);

        repo.removeById(3);

        Ticket[] actual = repo.findAll();
        Ticket[] expected = { ticket1, ticket2, ticket4, ticket5 };

        assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldRemoveByIdTwo() {
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        repo.save(ticket4);
        repo.save(ticket5);

        repo.removeById(3);
        repo.removeById(5);

        Ticket[] actual = repo.findAll();
        Ticket[] expected = { ticket1, ticket2, ticket4 };

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAdd() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] actual = repo.findAll();
        Ticket[] expected = { ticket1, ticket2, ticket3, ticket4, ticket5 };

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchOne() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] actual = manager.searchBy("SVO", "KZN");
        Ticket[] expected = {ticket1, ticket2};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchTwo() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] actual = manager.searchBy("VKO", "KZN");
        Ticket[] expected = {ticket4, ticket5, ticket3};

        assertArrayEquals(expected, actual);
    }
}