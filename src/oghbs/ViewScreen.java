/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oghbs;

/**
 *
 * @author Shubham Gautam
 */
import java.awt.Font;
import java.awt.HeadlessException;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.DefaultTableModel;

public class ViewScreen extends javax.swing.JFrame {

    /**
     * Creates new form ViewScreen
     */
    public ViewScreen() {
        initComponents();
    }
    public ResultSet rs;
    String username;

    public ViewScreen(ResultSet rs) {
        this.rs = rs;
        try {
            username = rs.getString("Username");
        } catch (Exception e) {

        }

        initComponents();
        show_result();
    }

    Connection connec = null;
    ResultSet rsd = null;
    ResultSet ry = null;
    String qw;
    String dis;
    String name2;
    int gg;
    int roomid1;

    public void show_result() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connec = DriverManager.getConnection("jdbc:mysql://localhost:3306/gdbase", "root", "1996");
            qw = "select Name from guestdb " + " where username = '" + username + "' ";
            Statement er = connec.createStatement();
            ry = er.executeQuery(qw);

            while (ry.next()) {
                name2 = ry.getString("Name");
            }

            String xx = "select * from bookingdba " + "where name = '" + name2 + "' ";
            Statement tt = connec.createStatement();
            ResultSet rr = tt.executeQuery(xx);

            String yy = "select * from bookingdbb " + "where name = '" + name2 + "' ";
            Statement qq = connec.createStatement();
            ResultSet ss = qq.executeQuery(yy);

            String zz = "select * from waitinglistdb " + "where name = '" + name2 + "' ";
            Statement mm = connec.createStatement();
            ResultSet nn = mm.executeQuery(zz);

            String aa = "select * from waitinglistdbb " + "where name = '" + name2 + "' ";
            Statement bb = connec.createStatement();
            ResultSet cc = bb.executeQuery(aa);

            if (rr.next()) {
                gg = 1;
            } else {
                if (ss.next()) {
                    gg = 2;
                } else {
                    if (nn.next()) {
                        gg = 3;
                    } else {
                        if (cc.next()) {
                            gg = 4;
                        }
                    }
                }
            }

            if (gg == 1) {
                dis = "select * from bookingdba " + "where Name='" + name2 + "'";
                Statement o1 = connec.createStatement();
                rsd = o1.executeQuery(dis);
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                rsd.next();
                roomid1 = rsd.getInt("RoomId");
                model.addRow(new Object[]{rsd.getInt("RoomId"), rsd.getString("Name"), rsd.getString("Gender"), rsd.getString("Address"), rsd.getString("CheckInDate"), rsd.getString("CheckOutDate")});
            }
            if (gg == 2) {
                dis = "select * from bookingdbb " + "where Name='" + name2 + "'";
                Statement o1 = connec.createStatement();
                rsd = o1.executeQuery(dis);
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                rsd.next();
                roomid1 = rsd.getInt("RoomId");
                model.addRow(new Object[]{rsd.getInt("RoomId"), rsd.getString("Name"), rsd.getString("Gender"), rsd.getString("Address"), rsd.getString("CheckInDate"), rsd.getString("CheckOutDate")});
            }
            if (gg == 3) {
                dis = "select * from waitinglistdb " + "where Name='" + name2 + "'";
                Statement o1 = connec.createStatement();
                rsd = o1.executeQuery(dis);
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                rsd.next();
                roomid1 = rsd.getInt("RoomId");
                model.addRow(new Object[]{rsd.getInt("RoomId"), rsd.getString("Name"), rsd.getString("Gender"), rsd.getString("Address"), rsd.getString("CheckInDate"), rsd.getString("CheckOutDate")});
            }
            if (gg == 4) {
                dis = "select * from waitinglistdbb " + "where Name='" + name2 + "'";
                Statement o1 = connec.createStatement();
                rsd = o1.executeQuery(dis);
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                rsd.next();
                roomid1 = rsd.getInt("RoomId");
                model.addRow(new Object[]{rsd.getInt("RoomId"), rsd.getString("Name"), rsd.getString("Gender"), rsd.getString("Address"), rsd.getString("CheckInDate"), rsd.getString("CheckOutDate")});
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(137, 196, 244));
        jPanel1.setPreferredSize(new java.awt.Dimension(1200, 800));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("View/Book Rooms");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton3.setText("Cancel Booking");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton4.setText("Check Booking Status");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton5.setText("Check Out");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Room ID", "Name", "Gender", "Address", "Check In Date", "Check Out Date"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Current Booking");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setText("Guest Home");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addGap(130, 130, 130))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(111, 111, 111))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 651, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(248, 248, 248)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(257, 257, 257)
                        .addComponent(jLabel3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3))
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addGap(79, 79, 79))
        );

        jPanel4.setBackground(new java.awt.Color(129, 207, 224));

        jButton6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton6.setText("Exit");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Welcome");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText(username);

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setText("Log Out");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jButton2)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(157, 157, 157)
                .addComponent(jButton2)
                .addGap(69, 69, 69)
                .addComponent(jButton6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(58, 83, 155));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Online Guest House Booking System");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 599, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 675, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(4, 4, 4))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    Connection conn = null;
    PreparedStatement pst = null;
    String name;
    int roomid;
    int price;
    int g = 0;
    int refund;
    int r;
    String e1, e2, e3, e4, e5;
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        try {

            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gdbase", "root", "1996");

            String sql = "select Name from guestdb " + " where username = '" + username + "' ";
            Statement stmt = conn.createStatement();
            ResultSet rg = stmt.executeQuery(sql);

            while (rg.next()) {
                name = rg.getString("Name");
            }

            String sql1 = "select * from bookingdba " + "where name = '" + name + "' ";
            Statement p1 = conn.createStatement();
            ResultSet rs1 = p1.executeQuery(sql1);

            String sql2 = "select * from bookingdbb " + "where name = '" + name + "' ";
            Statement p2 = conn.createStatement();
            ResultSet rs2 = p2.executeQuery(sql2);

            String sql3 = "select * from waitinglistdb " + "where name = '" + name + "' ";
            Statement p3 = conn.createStatement();
            ResultSet rs3 = p3.executeQuery(sql3);

            String sql4 = "select * from waitinglistdbb " + "where name = '" + name + "' ";
            Statement p4 = conn.createStatement();
            ResultSet rs4 = p4.executeQuery(sql4);

            if (rs1.next()) {
                g = 1;
            } else {
                if (rs2.next()) {
                    g = 2;
                } else {
                    if (rs3.next()) {
                        g = 3;
                    } else {
                        if (rs4.next()) {
                            g = 4;
                        } else {
                            UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Verdana", Font.BOLD, 32)));
                            JOptionPane.showMessageDialog(null, "No Booking Exists");
                        }
                    }
                }
            }


            //Confirmed Bookingfor A
            if (g == 1) {
                String w1 = "select RoomId from bookingdba " + " where name = '" + name + "' ";
                Statement i1 = conn.createStatement();
                ResultSet a1 = i1.executeQuery(w1);

                while (a1.next()) {
                    roomid = a1.getInt("RoomId");
                }

                String y = "Y";
                String w2 = "UPDATE roomdb " + "SET Availability = '" + y + "' WHERE RoomID = '" + roomid + "' ";
                Statement i2 = conn.createStatement();
                i2.executeUpdate(w2);

                Statement i3 = conn.createStatement();
                String w3 = "DELETE FROM bookingdba " + "WHERE RoomID = '" + roomid + "'";
                i3.executeUpdate(w3);


                String w4 = "select Price from roomdb " + " where roomid = '" + roomid + "' ";
                Statement i4 = conn.createStatement();
                ResultSet a4 = i4.executeQuery(w4);
                while (a4.next()) {
                    price = a4.getInt("Price");
                    refund = price / 5 - 100;
                }

                String wt = "select * from waitinglistdb " + " where Roomid = '" + roomid + "' ";
                Statement ik = conn.createStatement();
                ResultSet ap = ik.executeQuery(wt);

                while (ap.next()) {
                    r = ap.getInt("RoomID");
                    e1 = ap.getString("Name");
                    e2 = ap.getString("Gender");
                    e3 = ap.getString("Address");
                    e4 = ap.getString("CheckInDate");
                    e5 = ap.getString("CheckOutDate");
                }

                String su = "insert into bookingdba (roomid, name, gender, address, checkindate, checkoutdate)values(?,?,?,?,?,?)";
                PreparedStatement statement6 = conn.prepareStatement(su);
                statement6.setInt(1, r);
                statement6.setString(2, e1);
                statement6.setString(3, e2);
                statement6.setString(6, e3);
                statement6.setString(4, e4);
                statement6.setString(5, e5);
                statement6.executeUpdate();

                Statement ip = conn.createStatement();
                String wx = "DELETE FROM waitinglistdb " + "WHERE RoomID = '" + roomid + "'";
                ip.executeUpdate(wx);

                this.dispose();
                new Cancel2(rs, roomid, price, refund).setVisible(true);
            }

            //For Confirmed Booking from B
            if (g == 2) {
                String x1 = "select RoomId from bookingdbb " + " where name = '" + name + "' ";
                Statement j1 = conn.createStatement();
                ResultSet b1 = j1.executeQuery(x1);

                while (b1.next()) {
                    roomid = b1.getInt("RoomId");
                }

                String y = "Y";
                String x2 = "UPDATE roomdbb " + "SET Availability = '" + y + "' WHERE RoomID = '" + roomid + "' ";
                Statement j2 = conn.createStatement();
                j2.executeUpdate(x2);

                
                Statement j3 = conn.createStatement();
                String x3 = "DELETE FROM bookingdbb " + "WHERE RoomID = '" + roomid + "'";
                j3.executeUpdate(x3);

                
                String x4 = "select Price from roomdbb " + " where roomid = '" + roomid + "' ";
                Statement j4 = conn.createStatement();
                ResultSet b4 = j4.executeQuery(x4);
                while (b4.next()) {
                    price = b4.getInt("Price");
                    refund = price / 5 - 100;
                }

                String wt = "select * from waitinglistdbb " + " where Roomid = '" + roomid + "' ";
                Statement ik = conn.createStatement();
                ResultSet ap = ik.executeQuery(wt);

                while (ap.next()) {
                    r = ap.getInt("RoomID");
                    e1 = ap.getString("Name");
                    e2 = ap.getString("Gender");
                    e3 = ap.getString("Address");
                    e4 = ap.getString("CheckInDate");
                    e5 = ap.getString("CheckOutDate");
                }

                String su = "insert into bookingdbb (roomid, name, gender, address, checkindate, checkoutdate)values(?,?,?,?,?,?)";
                PreparedStatement statement6 = conn.prepareStatement(su);
                statement6.setInt(1, r);
                statement6.setString(2, e1);
                statement6.setString(3, e2);
                statement6.setString(6, e3);
                statement6.setString(4, e4);
                statement6.setString(5, e5);
                statement6.executeUpdate();

                Statement ip = conn.createStatement();
                String wx = "DELETE FROM waitinglistdbb " + "WHERE RoomID = '" + roomid + "'";
                ip.executeUpdate(wx);

                this.dispose();
                new Cancel2(rs, roomid, price, refund).setVisible(true);
            }

            //Waiting Booking For A
            if (g == 3) {
                String y1 = "select RoomId from waitinglistdb " + " where name = '" + name + "' ";
                Statement k1 = conn.createStatement();
                ResultSet c1 = k1.executeQuery(y1);

                while (c1.next()) {
                    roomid = c1.getInt("RoomId");
                }

                Statement k3 = conn.createStatement();
                String y3 = "DELETE FROM waitinglistdb " + "WHERE RoomID = '" + roomid + "'";
                k3.executeUpdate(y3);

                String y4 = "select Price from roomdb " + " where roomid = '" + roomid + "' ";
                Statement k4 = conn.createStatement();
                ResultSet c4 = k4.executeQuery(y4);
                while (c4.next()) {
                    price = c4.getInt("Price");
                    refund = price / 5 - 100;
                }
                this.dispose();
                new Cancel2(rs, roomid, price, refund).setVisible(true);
            }

            //Waiting Bookinf for B
            if (g == 4) {
                String z1 = "select RoomId from waitinglistdbb " + " where name = '" + name + "' ";
                Statement l1 = conn.createStatement();
                ResultSet d1 = l1.executeQuery(z1);

                while (d1.next()) {
                    roomid = d1.getInt("RoomId");
                }

                Statement l3 = conn.createStatement();
                String z3 = "DELETE FROM waitinglistdbb " + "WHERE RoomID = '" + roomid + "'";
                l3.executeUpdate(z3);

                String z4 = "select Price from roomdbb " + " where roomid = '" + roomid + "' ";
                Statement l4 = conn.createStatement();
                ResultSet d4 = l4.executeQuery(z4);
                while (d4.next()) {
                    price = d4.getInt("Price");
                    refund = price / 5 - 100;
                }
                this.dispose();
                new Cancel2(rs, roomid, price, refund).setVisible(true);
            }

        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Verdana", Font.BOLD, 32)));
            JOptionPane.showMessageDialog(null, e);
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new ViewRoom1(rs).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new LoginScreen().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    Connection con = null;
    PreparedStatement st = null;
    String name1;
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        try {

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gdbase", "root", "1996");

            String sql1 = "select Name from guestdb " + " where username = '" + username + "' ";
            Statement smt = con.createStatement();
            ResultSet rs1 = smt.executeQuery(sql1);

            while (rs1.next()) {
                name1 = rs1.getString("Name");
            }

            String sql2 = "select * from bookingdba " + "where name = '" + name1 + "' ";
            Statement pst = con.createStatement();
            ResultSet rs2 = pst.executeQuery(sql2);

            String sql3 = "select * from waitinglistdb " + "where name = '" + name1 + "' ";
            Statement p = con.createStatement();
            ResultSet rs3 = p.executeQuery(sql3);

            String sql4 = "select * from bookingdbb " + "where name = '" + name1 + "' ";
            Statement pst4 = con.createStatement();
            ResultSet rs4 = pst4.executeQuery(sql4);

            String sql5 = "select * from waitinglistdbb " + "where name = '" + name1 + "' ";
            Statement p5 = con.createStatement();
            ResultSet rs5 = p5.executeQuery(sql5);

            if (rs2.next() || rs4.next()) {
                UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Verdana", Font.BOLD, 32)));
                JOptionPane.showMessageDialog(null, "Booking is Confirmed");
            } else {
                if (rs3.next() || rs5.next()) {
                    UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Verdana", Font.BOLD, 32)));
                    JOptionPane.showMessageDialog(null, "Booking is in Waiting");
                } else {
                    UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Verdana", Font.BOLD, 32)));
                    JOptionPane.showMessageDialog(null, "No Booking Exists");
                }
            }
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Verdana", Font.BOLD, 32)));
            JOptionPane.showMessageDialog(null, "Exception e");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    Connection conn1 = null;
    PreparedStatement st1 = null;
    int ghg;
    String nameg;
    int r1;
    String e11,e21,e31,e41,e51;
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        ghg = roomid1 / 10;
        try {

            Class.forName("com.mysql.jdbc.Driver");
            conn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/gdbase", "root", "1996");

            String sql1 = "select Name from guestdb " + " where username = '" + username + "' ";
            Statement smt2 = conn1.createStatement();
            ResultSet rsp = smt2.executeQuery(sql1);

            while (rsp.next()) {
                nameg = rsp.getString("Name");
            }

            String sql12 = "select * from bookingdba " + "where roomid = '" + roomid1 + "' and name = '"+ nameg+"' ";
            Statement p12 = conn1.createStatement();
            ResultSet rs12 = p12.executeQuery(sql12);

            String sql22 = "select * from bookingdbb " + "where roomid = '" + roomid1 + "'  and name = '"+ nameg+"'";
            Statement p22 = conn1.createStatement();
            ResultSet rs22 = p22.executeQuery(sql22);

            String as = "select * from waitinglistdb " + "where roomid = '" + roomid1 + "'  and name = '"+ nameg+"'";
            Statement df = conn1.createStatement();
            ResultSet hj = df.executeQuery(as);

            String er = "select * from waitinglistdbb " + "where roomid = '" + roomid1 + "'  and name = '"+ nameg+"'";
            Statement ty = conn1.createStatement();
            ResultSet ui = ty.executeQuery(er);

            if (hj.next() || ui.next()) {
                UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Verdana", Font.BOLD, 32)));
                JOptionPane.showMessageDialog(null, "Option Not Available");
            } else {

                if (rs12.next()) {
                    ghg = 1;
                } else {
                    if (rs22.next()) {
                        ghg = 2;
                    } else {
                        UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Verdana", Font.BOLD, 32)));
                        JOptionPane.showMessageDialog(null, "No Booking Exists");

                    }
                }
                if (ghg == 1) {

                    String y = "Y";
                    String w2 = "UPDATE roomdb " + "SET Availability = '" + y + "' WHERE RoomID = '" + roomid1 + "' ";
                    Statement i2 = conn1.createStatement();
                    i2.executeUpdate(w2);

                    Statement i3 = conn1.createStatement();
                    String w3 = "DELETE FROM bookingdba " + "WHERE RoomID = '" + roomid1 + "'";
                    i3.executeUpdate(w3);

                    String wt1 = "select * from waitinglistdb " + " where Roomid = '" + roomid1 + "' ";
                    Statement ik1 = conn1.createStatement();
                    ResultSet ap1 = ik1.executeQuery(wt1);

                    while (ap1.next()) {
                        r1 = ap1.getInt("RoomID");
                        e11 = ap1.getString("Name");
                        e21 = ap1.getString("Gender");
                        e31 = ap1.getString("Address");
                        e41 = ap1.getString("CheckInDate");
                        e51 = ap1.getString("CheckOutDate");
                    }

                    
                    String su1 = "insert into bookingdba (roomid, name, gender, address, checkindate, checkoutdate)values(?,?,?,?,?,?)";
                    PreparedStatement statement8 = conn1.prepareStatement(su1);
                    statement8.setInt(1, r1);
                    statement8.setString(2, e11);
                    statement8.setString(3, e21);
                    statement8.setString(6, e31);
                    statement8.setString(4, e41);
                    statement8.setString(5, e51);
                    statement8.executeUpdate();
                    
                    Statement ip1 = conn1.createStatement();
                    String wx1 = "DELETE FROM waitinglistdb " + "WHERE RoomID = '" + roomid1 + "'";
                    ip1.executeUpdate(wx1);
                    

                    this.dispose();
                    new FeedbackForm(ghg, rs, roomid1).setVisible(true);
                }

                //For Confirmed Booking from B
                if (ghg == 2) {

                    String y = "Y";
                    String x2 = "UPDATE roomdbb " + "SET Availability = '" + y + "' WHERE RoomID = '" + roomid1 + "' ";
                    Statement j2 = conn1.createStatement();
                    j2.executeUpdate(x2);

                    Statement j3 = conn1.createStatement();
                    String x3 = "DELETE FROM bookingdbb " + "WHERE RoomId = '" + roomid1 + "' ";
                    j3.executeUpdate(x3);

                    String wt1 = "select * from waitinglistdbb " + " where Roomid = '" + roomid1 + "' ";
                    Statement ik1 = conn1.createStatement();
                    ResultSet ap1 = ik1.executeQuery(wt1);

                    while (ap1.next()) {
                        r1 = ap1.getInt("RoomID");
                        e11 = ap1.getString("Name");
                        e21 = ap1.getString("Gender");
                        e31 = ap1.getString("Address");
                        e41 = ap1.getString("CheckInDate");
                        e51 = ap1.getString("CheckOutDate");
                    }

                    
                    String su1 = "insert into bookingdbb (roomid, name, gender, address, checkindate, checkoutdate)values(?,?,?,?,?,?)";
                    PreparedStatement statement8 = conn1.prepareStatement(su1);
                    statement8.setInt(1, r1);
                    statement8.setString(2, e11);
                    statement8.setString(3, e21);
                    statement8.setString(6, e31);
                    statement8.setString(4, e41);
                    statement8.setString(5, e51);
                    statement8.executeUpdate();
                    
                    Statement ip1 = conn1.createStatement();
                    String wx1 = "DELETE FROM waitinglistdbb " + "WHERE RoomID = '" + roomid1 + "'";
                    ip1.executeUpdate(wx1);

                    this.dispose();
                    new FeedbackForm(ghg, rs, roomid1).setVisible(true);
                }
            }
        } catch (Exception e) {
        }

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton6ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Verdana", Font.BOLD, 32)));

        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
