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
public class PaymentTest {
    
    ArrayList<String> arrdebit = new ArrayList<String>();
    ArrayList<String> arrpin = new ArrayList<String>();

    public PaymentTest() {
     
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gdbase", "root", "1996");
            String query = "Select * from bankdb";
            PreparedStatement st = conn.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            if (!rs.next()) {
                System.out.println("Something went wrong.");
            }
            //rs.beforeFirst();
            while (rs.next()) {
                arrdebit.add(rs.getString("debitcardno"));
                arrpin.add(Integer.toString(rs.getInt("pin")));
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

    
    @Test
    public void test1() {
        Payment p = new Payment(1,null,"", 11,"", "",500);
        p.setUsername("1212");
        p.setPassword("1212");
        p.loginclick();
        int flag = p.getflag();
        assertEquals(1, flag);
    }
    
    @Test
    public void test2() {
        Payment p = new Payment(1,null,"", 11,"", "",500);
        p.setUsername("1212");
        p.setPassword("89");
        p.loginclick();
        int flag = p.getflag();
        assertEquals(1, flag);
    }
    @Test
    public void test3() {
        Payment p = new Payment(1,null,"", 11,"", "",500);
        p.setUsername("00");
        p.setPassword("1212");
        p.loginclick();
        int flag = p.getflag();
        assertEquals(1, flag);
    }
    @Test
    public void test4() {
        Payment p = new Payment(1,null,"", 11,"", "",500);
        p.setUsername("00");
        p.setPassword("00");
        p.loginclick();
        int flag = p.getflag();
        assertEquals(1, flag);
    }
    
}