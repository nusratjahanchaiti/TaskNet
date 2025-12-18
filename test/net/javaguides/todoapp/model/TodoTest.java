package net.javaguides.todoapp.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TodoTest {

    private Todo todo;

    @Before
    public void setUp() {
        todo = new Todo();
    }

    // Equivalence Class Testing
    @Test
    public void testTitle_Valid() {
        todo.setTitle("Finish Assignment");
        assertEquals("Finish Assignment", todo.getTitle());
    }

    @Test
    public void testTitle_Empty() {
        todo.setTitle("");
        assertEquals("", todo.getTitle());
    }

    @Test
    public void testTitle_Null() {
        todo.setTitle(null);
        assertNull(todo.getTitle());
    }

    // Boundary Value Analysis
    @Test
    public void testDescription_MaxLength() {
        String desc = new String(new char[200]).replace("\0", "x");
        todo.setDescription(desc);
        assertEquals(desc, todo.getDescription());
    }

    // Robustness Testing
    @Test
    public void testDescription_SpecialCharacters() {
        todo.setDescription("!@#$%^&*()");
        assertEquals("!@#$%^&*()", todo.getDescription());
    }
}
