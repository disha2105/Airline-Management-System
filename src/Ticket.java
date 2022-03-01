import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Ticket extends JFrame {
    private JButton submitButton;
    Connection con;
    PreparedStatement ps;
    Statement stmt;
    ResultSet rs;
    private JPanel panel1;
    private JPanel ticketpanel;
    private JTextField textField1;
    private JTextField age;
    private JTextField fname;
    private JTextField traveldate;
    private JTextField lastname;
    private JTextField gender;
    private JTextField flightno;
    private JTextField address;
    private JTextField ph;
    private JTextField Class;
    private JTextField status;
    private JLabel MSG;

    public Ticket() {
        setContentPane(ticketpanel);


        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/airline_management",
                            "root", "$Dishak123$");

                    PreparedStatement ps = (PreparedStatement) con
                            .prepareStatement("Select * from airline_management.passengers where PRN=?");
                    ps.setString(1, (textField1.getText()));


                    rs=ps.executeQuery();

                    if (rs.next()) {
                        fname.setText(rs.getString(3));
                        lastname.setText(rs.getString(4));
                        age.setText(String.valueOf(rs.getInt(5)));
                        gender.setText(rs.getString(6));
                        address.setText(rs.getString(7));
                        ph.setText(String.valueOf(rs.getInt(8)));
                        flightno.setText(rs.getString(2));
                        traveldate.setText(rs.getString(1));
                        Class.setText(rs.getString(9));
                        status.setText(rs.getString(10));
                        JOptionPane.showMessageDialog(MSG, "DONE");

//
                    } else {
                        JOptionPane.showMessageDialog(MSG, "Wrong PRN");
                    }


                    con.close();

                }

                catch(Exception ex)
                {
                    System.out.println("2 Error : "+ex);
                }


            }
        });
    }
    public static void main(String args[])
    {

        Ticket t = new Ticket();
        t.setSize(400,500);
        t.setVisible(true);
        t.setTitle("Ticket Screen");


    }
}
