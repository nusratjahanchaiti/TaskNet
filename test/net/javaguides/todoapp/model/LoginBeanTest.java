package net.javaguides.todoapp.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LoginBeanTest {

    private LoginBean login;

    @Before
    public void setUp() {
        login = new LoginBean();
    }

    // ECT
    @Test
    public void testUsername_Valid() {
        login.setUsername("user123");
        assertEquals("user123", login.getUsername());
    }

    @Test
    public void testUsername_Empty() {
        login.setUsername("");
        assertEquals("", login.getUsername());
    }

    @Test
    public void testUsername_Null() {
        login.setUsername(null);
        assertNull(login.getUsername());
    }

    // BVA
    @Test
    public void testPassword_MinLength() {
        login.setPassword("a"); // assume min 1 char
        assertEquals("a", login.getPassword());
    }

    @Test
    public void testPassword_MaxLength() {
        String maxPassword = new String(new char[50]).replace("\0", "a");
        login.setPassword(maxPassword);
        assertEquals(maxPassword, login.getPassword());
    }

    // Robustness
    @Test
    public void testPassword_SpecialCharacters() {
        login.setPassword("!@#$%^&*()");
        assertEquals("!@#$%^&*()", login.getPassword());
    }

    @Test
    public void testUsername_TooLong() {
        String longUsername = new String(new char[1000]).replace("\0", "a");
        login.setUsername(longUsername);
        assertEquals(longUsername, login.getUsername());
    }
}
