package net.javaguides.todoapp.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class UserTest {

    private User user;

    @Before
    public void setUp() {
        user = new User();
    }

    // Equivalence Class Testing
    @Test
    public void testUsername_Valid() {
        user.setUsername("user123");
        assertEquals("user123", user.getUsername());
    }

    @Test
    public void testUsername_Empty() {
        user.setUsername("");
        assertEquals("", user.getUsername());
    }

    @Test
    public void testUsername_Null() {
        user.setUsername(null);
        assertNull(user.getUsername());
    }

    // Boundary Value Analysis
    @Test
    public void testPassword_MinLength() {
        user.setPassword("a");
        assertEquals("a", user.getPassword());
    }

    @Test
    public void testPassword_MaxLength() {
        String maxPassword = new String(new char[50]).replace("\0", "a");
        user.setPassword(maxPassword);
        assertEquals(maxPassword, user.getPassword());
    }

    // Robustness Testing
    @Test
    public void testFirstName_SpecialCharacters() {
        user.setFirstName("@#$%^");
        assertEquals("@#$%^", user.getFirstName());
    }

    @Test
    public void testUsername_TooLong() {
        String longUsername = new String(new char[1000]).replace("\0", "a");
        user.setUsername(longUsername);
        assertEquals(longUsername, user.getUsername());
    }
}
