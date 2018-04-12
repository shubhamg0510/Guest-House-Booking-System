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
public class StaffLoginTest {
    
    ArrayList<String> arrusername = new ArrayList<String>();
    ArrayList<String> arrpassword = new ArrayList<String>();

    public StaffLoginTest() {
     
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gdbase", "root", "1996");
            String query = "Select * from staffdb";
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
     * Test of main method, of class StaffLogin.
     */
   
      @Test
    public void test1() {
        StaffLogin login = new StaffLogin();
        login.setUsername("staffa1");
        login.setPassword("staffa1");
        login.loginclick();
        int flag = login.getflag();
        assertEquals(1, flag);
    }
    
    @Test
    public void test2() {
        StaffLogin login = new StaffLogin();
        login.setUsername("staffa1");
        login.setPassword("hh");
        login.loginclick();
        int flag = login.getflag();
        assertEquals(1, flag);
    }
    
    @Test
    public void test3() {
        StaffLogin login = new StaffLogin();
        login.setUsername("pp");
        login.setPassword("staffa1");
        login.loginclick();
        int flag = login.getflag();
        assertEquals(1, flag);
    }
    @Test
    public void test4() {
        StaffLogin login = new StaffLogin();
        login.setUsername("jjj");
        login.setPassword("kkk");
        login.loginclick();
        int flag = login.getflag();
        assertEquals(1, flag);
    }
    
}
