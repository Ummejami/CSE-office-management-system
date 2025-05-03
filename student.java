
package student;
import java.sql.*;
import java.awt.Color;
import java.awt.print.PrinterException;
import javax.swing.JOptionPane;
import java.lang.Object;
import javax.swing.table.DefaultTableModel;
import java.lang.String;
import student.connection;
import student.Stu;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JTable;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JOptionPane.showMessageDialog;




public class student extends javax.swing.JFrame {

    Stu student = new Stu();

    int xx, xy;
    private DefaultTableModel model;
    private int rowIndex;

    public student() {
        initComponents();
        init();
    }

    @SuppressWarnings("unchecked")


    
    public void init()
    {
        TableViewStudent();
        jTextField12.setText(String.valueOf(student.getMax()));
        
    }
    private void TableViewStudent()
    {
       // student.getStudentValue(jTable1,"");
        getStudentValue(jTable1,"");
      
        model = (DefaultTableModel) jTable1.getModel();
        jTable1.setRowHeight(30);
        jTable1.setShowGrid(true);
        jTable1.setGridColor(Color.black);
        jTable1.setBackground(Color.white);
        
        
    }
    
    
    
    //GET STUDENT VALUE
    
    public void getStudentValue(JTable table, String searchValue) {

        PreparedStatement st = null;
        ResultSet rs = null;
        String url = "jdbc:mysql://localhost:3306/cseoffice";
        String user = "root";
        String password = "";

        try {
        
                 //Class.forName("com.mysql.cj.jdbc.Driver");
            //Connection conn = DriverManager.getConnection(url,user,password);
            Connection conn = connection.getConnection();

            String sql = "SELECT * FROM student_information WHERE CONCAT(Serial_Number, Email, Phone_Number, Roll_Number, Registration) LIKE ? ORDER BY Serial_Number ASC";
            st = conn.prepareStatement(sql);
            st.setString(1, "%" + searchValue + "%");

            rs = st.executeQuery();

            model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                Object[] row = new Object[12];
                row[0] = rs.getInt(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                row[4] = rs.getString(5);
                row[5] = rs.getString(6);
                row[6] = rs.getString(7);
                row[7] = rs.getString(8);
                row[8] = rs.getString(9);
                row[9] = rs.getString(10);
                row[10] = rs.getString(11);
                row[11] = rs.getString(12);

                model.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Stu.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }

    
   
    public boolean isEmptyStudent()
    {
        if(jTextField1.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Student Name Is Missing");
            return false;
        }
        if(jTextField2.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Student Father's Name Is Missing");
            return false;
        }
        if(jTextField3.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Student Mother's Name Is Missing");
            return false;
        }
        if(jTextField4.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Parmanent Address Is Missing");
            return false;
        }
        if(jTextField5.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Present Address Is Missing");
            return false;
        }
        if(jTextField6.getText().matches("^.+%.+\\..+$"))
        {
            JOptionPane.showMessageDialog(this, "E-mail Is Invalid");
            return false;
        }
        if(jTextField7.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, " Phone Number Is Missing");
            return false;
        }
        if(jTextField8.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, " Roll Number Is Missing");
            return false;
        }
        if(jTextField10.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, " Registration Number Is Missing");
            return false;
        }
        if(jTextField11.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, " Previous Session Is Missing");
            return false;
        }
        if(jTextField13.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Session Is Missing");
            return false;
        }
        return true;
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 5, true));
        jPanel1.setForeground(new java.awt.Color(0, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("    Student Details");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 21, 380, 50));

        jPanel2.setBackground(new java.awt.Color(0, 51, 51));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 5, true));
        jPanel2.setForeground(new java.awt.Color(204, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Student Name");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 103, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("Father's Name");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 112, -1));
        jPanel2.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 233, -1));
        jPanel2.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 233, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("Mother's Name");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 110, -1));
        jPanel2.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 233, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("Parmanent Address");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));
        jPanel2.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 233, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("Present Address");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 133, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 204));
        jLabel7.setText("E-mail");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 109, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 204, 204));
        jLabel8.setText("Phone Number");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 125, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 204, 204));
        jLabel9.setText("Roll Number");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 109, -1));
        jPanel2.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, 233, -1));
        jPanel2.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 270, 233, -1));
        jPanel2.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 310, 230, -1));
        jPanel2.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 350, 240, -1));

        jPanel3.setBackground(new java.awt.Color(0, 51, 51));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 5, true));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 430, 170));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(204, 204, 204));
        jLabel13.setText("Registration");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 100, -1));
        jPanel2.add(jTextField10, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 390, 240, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(204, 204, 204));
        jLabel14.setText("Previous Session");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 120, -1));
        jPanel2.add(jTextField11, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 430, 240, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(204, 204, 204));
        jLabel15.setText("Serial Number");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 100, -1));
        jPanel2.add(jTextField12, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 230, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 204, 204));
        jLabel11.setText("Session");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, -1, -1));
        jPanel2.add(jTextField13, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 470, 240, -1));

        jPanel5.setBackground(new java.awt.Color(0, 51, 51));
        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 5, true));
        jPanel5.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel5MouseDragged(evt);
            }
        });
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel5MousePressed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 204, 204));
        jLabel10.setText("Search Student");

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setText("Search");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setText("Refreash");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton10.setText("Close");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(112, 112, 112)
                .addComponent(jButton3)
                .addGap(70, 70, 70)
                .addComponent(jButton10)
                .addContainerGap(90, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton10))
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(0, 51, 51));
        jPanel6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 153), 5, true));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Student ID", "Student Name", "Father's  Name", "Mother's Name", "Parmanent Address", "Present Address", "E-mail", "Phone Number", "Roll Number", "Registration", "Previous Session", "Session"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1040, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
        );

        jPanel8.setBackground(new java.awt.Color(0, 51, 51));
        jPanel8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 153), 5, true));

        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton4.setText("ADD");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton5.setText("UPDATE");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton6.setText("DELETE");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton7.setText("PRINT");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton8.setText("CLEAR");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton9.setText("LOG OUT");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(573, 573, 573))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(1043, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(460, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        int id = Integer.parseInt(jTextField12.getText());
        if(student.isIdExist(id))
        {
            delete(id);
            jTable1.setModel(new DefaultTableModel(null, new Object[]{"Student ID", "Student Name", "Father Name", "Mother Name", "Permanent Address", "Present Address", "Email", "Phone Number", "Roll Number", "Registration", "Previous Session", "Session"}));
            getStudentValue(jTable1, "");
            clearStudent();
        }
        else
        {
            JOptionPane.showMessageDialog(this,"Student ID dosen't Exist");
        }
                
                    
                
    }                                        

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {                                         
          int a = JOptionPane.showConfirmDialog(this,"Do You Want To LogOut Now?","Select",JOptionPane.YES_NO_OPTION);
          if(a==0)
          {
              this.dispose();
          }
    }                                        

    private void jPanel5MouseDragged(java.awt.event.MouseEvent evt) {                                     
                 int x = evt.getXOnScreen();
                 int y = evt.getYOnScreen();
                 this.setLocation(x- xx , y-xy);
    }                                    

    private void jPanel5MousePressed(java.awt.event.MouseEvent evt) {                                     
        // TODO add your handling code here:
        xx = evt.getX();
        xy = evt.getY();
    }                                    
    private void clearStudent()
    {
          jTextField12.setText(String.valueOf(student.getMax()));
          //jTextField12.setText(null);
          jTextField1.setText(null);
          jTextField2.setText(null);
          jTextField3.setText(null);
          jTextField4.setText(null);
          jTextField5.setText(null);
          jTextField6.setText(null);
          jTextField7.setText(null);
          jTextField8.setText(null);
          jTextField10.setText(null);
          jTextField11.setText(null);
          jTextField13.setText(null);
          jTable1.clearSelection();
    }
    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {                                         
          clearStudent();
    }                                        

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        if(isEmptyStudent())
        {
            
             
             int serialNumber = student.getMax();
             String studentName = jTextField1.getText();
             String fathersName = jTextField2.getText();
             String mothersName = jTextField3.getText();
             String permanentAddress = jTextField4.getText();
             String presentAddress = jTextField5.getText();
             String email = jTextField6.getText();
             String phoneNumber = jTextField7.getText();
             String rollNumber = jTextField8.getText();
             String registration = jTextField10.getText();
             String previousSession = jTextField11.getText();
             String session = jTextField13.getText();
             insert(serialNumber,studentName,fathersName, mothersName,permanentAddress,presentAddress,email,phoneNumber,rollNumber,registration,previousSession,session);
             
            
             jTable1.setModel(new DefaultTableModel(null,new Object[]{"Student ID","Student Name","Father Name","Mother Name","Permanent Address","Present Address","Email","Phone Number","Roll Number","Registration","Previous Session","Session"}));
             getStudentValue(jTable1,"");
              clearStudent();
        }
    }                                        

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {                                     
           model = (DefaultTableModel) jTable1.getModel();
           rowIndex = jTable1.getSelectedRow();
           jTextField12.setText(model.getValueAt(rowIndex, 0).toString());
           jTextField1.setText(model.getValueAt(rowIndex, 1).toString());
           jTextField2.setText(model.getValueAt(rowIndex, 2).toString());
           jTextField3.setText(model.getValueAt(rowIndex, 3).toString());
           jTextField4.setText(model.getValueAt(rowIndex, 4).toString());
           jTextField5.setText(model.getValueAt(rowIndex, 5).toString());
           jTextField6.setText(model.getValueAt(rowIndex, 6).toString());
           jTextField7.setText(model.getValueAt(rowIndex, 7).toString());
           jTextField8.setText(model.getValueAt(rowIndex, 8).toString());
           jTextField10.setText(model.getValueAt(rowIndex, 9).toString());
           jTextField11.setText(model.getValueAt(rowIndex, 10).toString());
           jTextField13.setText(model.getValueAt(rowIndex, 11).toString());
           
    }                                    

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        if(isEmptyStudent())
        {
            int serialNumber = Integer.parseInt(jTextField12.getText());
            String studentName = jTextField1.getText();
            String fathersName = jTextField2.getText();
            String mothersName = jTextField3.getText();
            String permanentAddress = jTextField4.getText();
            String presentAddress = jTextField5.getText();
            String email = jTextField6.getText();
            String phoneNumber = jTextField7.getText();
            String rollNumber = jTextField8.getText();
            String registration = jTextField10.getText();
            String previousSession = jTextField11.getText();
            String session = jTextField13.getText();
           
           update(serialNumber,studentName,fathersName, mothersName,permanentAddress,presentAddress,email,phoneNumber,rollNumber,registration,previousSession,session);
             
            
             jTable1.setModel(new DefaultTableModel(null,new Object[]{"Student ID","Student Name","Father Name","Mother Name","Permanent Address","Present Address","Email","Phone Number","Roll Number","Registration","Previous Session","Session"}));
             getStudentValue(jTable1,"");
             clearStudent();
            
        }
    }                                        

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        if(jTextField9.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this,"Please Enter Roll Number");
        }
        else
        {
             jTable1.setModel(new DefaultTableModel(null,new Object[]{"Student ID","Student Name","Father Name","Mother Name","Permanent Address","Present Address","Email","Phone Number","Roll Number","Registration","Previous Session","Session"}));
             getStudentValue(jTable1,jTextField9.getText());
             clearStudent();
            
        }
    }                                        

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        
             jTable1.setModel(new DefaultTableModel(null,new Object[]{"Student ID","Student Name","Father Name","Mother Name","Permanent Address","Present Address","Email","Phone Number","Roll Number","Registration","Previous Session","Session"}));
             getStudentValue(jTable1,"");
             clearStudent();
             jTextField9.setText(null);
            
    }                                        

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        try {
            // TODO add your handling code here:
            MessageFormat header = new MessageFormat("Student Information");
            MessageFormat footer = new MessageFormat("Page{0,number,integer}");
            jTable1.print(JTable.PrintMode.FIT_WIDTH,header,footer);
        } catch (PrinterException ex) {
            Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
        }
    }                                        

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        setVisible(false);
    }                                         

    
    
    
    public void insert(int Serial_Number, String Name, String Father_Name, String Mother_Name, String ParmanentAddress, String PresentAddress, String Email, String Phone_Number, String Roll_Number, String Registration, String Pre_Session, String Sesssion) {

        String url = "jdbc:mysql://localhost:3306/cseoffice";
        String user = "root";
        String password = "";
        //Serial_Number, Name, Father_Name, Mother_Name, ParmanentAddress, PresentAddress, Email, Phone_Number, Roll_Number, Registration,Pre_Sesssion, Session
        PreparedStatement statement;
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);

            String sql = "INSERT INTO student_information(Serial_Number, Name, Father_Name, Mother_Name, ParmanentAddress, PresentAddress, Email, Phone_Number, Roll_Number, Registration,Pre_Session, Sesssion) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            statement = conn.prepareStatement(sql);

            //jTextField12.setText(String.valueOf(getMax()));
            statement.setInt(1, Serial_Number);
            statement.setString(2, Name);
            statement.setString(3, Father_Name);
            statement.setString(4, Mother_Name);
            statement.setString(5, ParmanentAddress);
            statement.setString(6, PresentAddress);
            statement.setString(7, Email);
            statement.setString(8, Phone_Number);
            statement.setString(9, Roll_Number);
            statement.setString(10, Registration);
            statement.setString(11, Pre_Session);
            statement.setString(12, Sesssion);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(this, "New Row has been created successfully...");
            // update();

        } catch (Exception e) {
            showMessageDialog(null, e);
        }
    }
            
    
    public void update(int Serial_Number, String Name, String Father_Name, String Mother_Name, String ParmanentAddress, String PresentAddress, String Email, String Phone_Number, String Roll_Number, String Registration, String Pre_Session, String Sesssion) {

        String url = "jdbc:mysql://localhost:3306/cseoffice";
        String user = "root";
        String password = "";
        PreparedStatement statement;
        String sql = "update student_information set  Name=?, Father_Name=?, Mother_Name=?, ParmanentAddress=?,PresentAddress=?,Email=?, Phone_Number=?, Roll_Number=?,  Registration=?,Pre_Session=?, Sesssion=? where Serial_Number=? ";

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);

            statement = conn.prepareStatement(sql);

            statement.setString(1, Name);
            statement.setString(2, Father_Name);
            statement.setString(3, Mother_Name);
            statement.setString(4, ParmanentAddress);
            statement.setString(5, PresentAddress);
            statement.setString(6, Email);
            statement.setString(7, Phone_Number);
            statement.setString(8, Roll_Number);
            statement.setString(9, Registration);
            statement.setString(10, Pre_Session);
            statement.setString(11, Sesssion);
            statement.setInt(12, Serial_Number);

            statement.executeUpdate();
            JOptionPane.showMessageDialog(this, " Row has been Updated successfully...");

        } catch (Exception e) {
            showMessageDialog(null, e);
        }
    }
    
   public void delete(int Serial_Number) {

    String url = "jdbc:mysql://localhost:3306/cseoffice";
    String user = "root";
    String password = "";
    PreparedStatement statement;

    int yesOrno = JOptionPane.showConfirmDialog(null, "All Data Will be Deleted Permanently", "Student Delete", JOptionPane.OK_CANCEL_OPTION, 0);
    if (yesOrno == JOptionPane.OK_OPTION) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);

            String sql = "DELETE FROM student_information WHERE Serial_Number=?";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, Serial_Number);
            statement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Student Information Deleted successfully...");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "An error occurred while deleting the student:\n" + e.getMessage());
        } catch (Exception e) { // Catch other unexpected exceptions
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "An unexpected error occurred.");
        } 
    }
}
        
    public static void main(String args[])
    {
       
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run()
            {
                new student().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration                   
}
