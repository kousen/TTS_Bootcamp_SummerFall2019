package com.tts.database;

import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class ActorDAOTest {
    private ActorDAO dao = ActorDAO.getInstance();

    @Test
    public void findAll() {
        List<Actor> actors = dao.findAll();
        assertEquals(200, actors.size());
    }

    @Test
    public void findByIdThatExists() {
        Optional<Actor> actor = dao.findById(1);
        assertTrue(actor.isPresent());
        assertEquals("PENELOPE", actor.get().getFirstName());
        assertEquals("GUINESS", actor.get().getLastName());
    }

    @Test
    public void findByIdThatDoesNOTExist() {
        Optional<Actor> actor = dao.findById(999);
        assertFalse(actor.isPresent());
    }

    @Test
    public void insertAndDelete() {
        Actor actor = new Actor("Matt", "Damon");
        Actor result = dao.save(actor);
        assertTrue(result.getActorId() > 0);
        System.out.println(result);

        dao.delete(result);
    }
}