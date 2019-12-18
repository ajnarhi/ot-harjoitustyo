/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import domain.Admin;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ajnarhi
 */
public class AdminTest {

    Admin admin;

    @Before
    public void setUp() {

        admin = new Admin();
    }

    @Test
    public void getPasswordReturnsPassword() {
        assertEquals("1234", admin.getPassword());
    }
}
