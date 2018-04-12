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
public class Register2Test {
    
    ArrayList<String> arrname = new ArrayList<String>();
    ArrayList<String> arrdob = new ArrayList<String>();
    ArrayList<String> arrgender = new ArrayList<String>();
    ArrayList<String> arrmobnum = new ArrayList<String>();
    ArrayList<String> arrid = new ArrayList<String>();
    ArrayList<String> arraddress = new ArrayList<String>();
    ArrayList<String> arremail = new ArrayList<String>();
    ArrayList<String> arrusername = new ArrayList<String>();
    ArrayList<String> arrpassword = new ArrayList<String>();
    
    public Register2Test() {
      
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
                arrname.add(rs.getString("name"));
                arrdob.add(rs.getString("dob"));
                arrgender.add(rs.getString("gender"));
                arrmobnum.add(rs.getString("mobnum"));
                arrid.add(rs.getString("id"));
                arraddress.add(rs.getString("address"));
                arremail.add(rs.getString("email"));
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
     * Test of main method, of class Register2.
     */
        
    @Test
    public void test1() {
        Register2 login = new Register2();
        login.setUsername("wwwa");
        login.setPassword("ww");
        login.setgender("F");
        login.setdob("1/1/1996");
        login.setmobnum("1234567890");
        login.setName("ww");
        login.setid("11");
        login.setaddress("aaaa");
        login.setemail("ww");
        login.loginclick();
        int flag = login.getflag();
        assertEquals(1, flag);
    }
    
    @Test
    public void test2() {
        Register2 login = new Register2();
        login.setUsername("sg");
        login.setPassword("ww");
        login.setgender("F");
        login.setdob("1/1/1996");
        login.setmobnum("1234567890");
        login.setName("ww");
        login.setid("11");
        login.setaddress("aaaa");
        login.setemail("ww");
        login.loginclick();
        int flag = login.getflag();
        assertEquals(1, flag);
    }
    @Test
    public void test3() {
        Register2 login = new Register2();
        login.setUsername("ww");
        login.setPassword("ww");
        login.setgender("h");
        login.setdob("1/1/1996");
        login.setmobnum("1234567890");
        login.setName("ww");
        login.setid("11");
        login.setaddress("aaaa");
        login.setemail("ww");
        login.loginclick();
        int flag = login.getflag();
        assertEquals(1, flag);
    }
    @Test
    public void test4() {
        Register2 login = new Register2();
        login.setUsername("ww");
        login.setPassword("ww");
        login.setgender("F");
        login.setdob("1/1/1996");
        login.setmobnum("1234567890");
        login.setName("");
        login.setid("11");
        login.setaddress("aaaa");
        login.setemail("ww");
        login.loginclick();
        int flag = login.getflag();
        assertEquals(1, flag);
    }
}
