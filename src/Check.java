import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class Check extends JFrame{
    private JPanel panel1;
    private JButton submitButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JLabel travel;
    private JLabel flight;
    private JLabel first;
    private JLabel business;
    private JLabel economy;
    private JButton resetButton;
    private JComboBox comboBox1;
    private JButton button1;

    Connection con;
//    PreparedStatement ps;
    Statement stmt;
    ResultSet rs;
    int count;

    public Check() {
        setContentPane(panel1);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try
                {
                     con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/airline_management",
                            "root", "$Dishak123$");

                    PreparedStatement ps = (PreparedStatement) con
                            .prepareStatement("Select * from airline_management.check where TravelDate=? and FlightNo=?");


                    ps.setString(1,textField2.getText());
                    ps.setString(2,textField1.getText());

                    rs=ps.executeQuery();
                    rs.next();

                    textField3.setText(Integer.toString(rs.getInt(3)));
                    textField4.setText(Integer.toString(rs.getInt(4)));
                    textField5.setText(Integer.toString(rs.getInt(5)));


                    con.close();
                }

                catch(Exception ex)
                {
                    System.out.println("2 Error : "+ex);
                }

            }
        });
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                textField1.setText("");
                textField2.setText("");
                textField3.setText("");
                textField4.setText("");
                textField5.setText("");

            }
        });
    }
}
