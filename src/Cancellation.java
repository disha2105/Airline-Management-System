import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Cancellation extends JFrame{
    private JPanel panel1;
    private JLabel label1;
    private JTextField textField1;
    private JButton clearButton;
    private JButton submitButton;
    private JPanel cancel;
    PreparedStatement ps;
    Statement stmt;
    ResultSet rs;
    int count;

    public Cancellation() {
        setContentPane(cancel);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection connec = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/airline_management",
                            "root", "$Dishak123$");
                    ps = connec.prepareStatement("select FlightNo,TravelDate,Class from airline_management.passengers where PRN=?");
                    String pnrno = textField1.getText();
                    ps.setInt(1, Integer.parseInt(pnrno));
                    rs = ps.executeQuery();
                    rs.next();

                    System.out.println(rs.getString(1) + "" + rs.getString(2) + " " + rs.getString(3));

                    ps=connec.prepareStatement("delete from airline_management.passengers where PRN=?");
                    ps.setInt(1,Integer.parseInt(pnrno));
                    count = ps.executeUpdate();
                    connec.close();
                    textField1.setText("");


                }

                catch(Exception exception)
                {
                    System.out.println("Error : "+exception);
                }


            }
        });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText("");
            }
        });
    }
}
