/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oghbs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mohit
 */
public class GuestLoginTest {
    
    ArrayList<String> arrusername = new ArrayList<String>();
    ArrayList<String> arrpassword = new ArrayList<String>();

    public GuestLoginTest() {
     
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gdbase", "root", "1996");
            String query = "Select * from guestdb";
            PreparedStatement st = conn.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            if (!rs.next()) {
                System.out.println("Something went wrong.");
            }
            //rs.beforeFirst();
            while (rs.next()) {
                arrusername.add(rs.getString("username"));
                arrpassword.add(rs.getString("password"));
            }

        } catch (Exception e) {
        }
    }
    
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class GuestLogin.
     */
   @Test
    public void test1() {
        GuestLogin login = new GuestLogin();
        login.setUsername("sg");
        login.setPassword("sg");
        login.loginclick();
        int flag = login.getflag();
        assertEquals(1, flag);
    }
    
   
    @Test
    public void test2() {
        GuestLogin login = new GuestLogin();
        login.setUsername("sg");
        login.setPassword("123");
        login.loginclick();
        int flag = login.getflag();
        assertEquals(1, flag);
    }
    
    @Test
    public void test3() {
        GuestLogin login = new GuestLogin();
        login.setUsername("xyz");
        login.setPassword("sg");
        login.loginclick();
        int flag = login.getflag();
        assertEquals(1, flag);
    }
    @Test
    public void test4() {
        GuestLogin login = new GuestLogin();
        login.setUsername("jjj");
        login.setPassword("kkk");
        login.loginclick();
        int flag = login.getflag();
        assertEquals(1, flag);
    }
    /*
    @Test
    public void testFriend() {
        for (int i = 0; i < arrusername.size(); i++) {
            for (int j = 1; j <= 3; j++) {
                if (j == 1) {
                    GuestLogin login = new GuestLogin();
                    login.setUsername(arrusername.get(i));
                    login.setPassword(arrpassword.get(i));
                    login.loginclick();
                    int flag = login.getflag();
                    assertEquals(1, flag);
                }
                if (j == 2) {
                    GuestLogin login = new GuestLogin();
                    login.setUsername(arrusername.get(i) + "123");
                    login.setPassword(arrpassword.get(i));
                    login.loginclick();
                    int flag = login.getflag();
                    assertEquals(1, flag);
                }
                if (j == 3) {
                    GuestLogin login = new GuestLogin();
                    login.setUsername(arrusername.get(i));
                    login.setPassword(arrpassword.get(i) + "123");
                    login.loginclick();
                    int flag = login.getflag();
                    assertEquals(1, flag);
                }
            }
        }

    }*/
}
