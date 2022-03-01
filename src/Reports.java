import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Reports extends JFrame {

    private JPanel waiting;
    private JPanel WAITING;
    private JTextField textField1;
    private JTextField textField2;
    private JButton submitButton;
    private JLabel MSG;
    PreparedStatement ps;
    Statement stmt;
    ResultSet rs;

    public Reports(){
        setContentPane(WAITING);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection connec = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/airline_management",
                            "root", "$Dishak123$");
                    ps = connec.prepareStatement("Select Status from airline_management.passengers where PRN=?");
//            String pnrno = textField1.getText();
                    ps.setString(1, (textField1.getText()));
                    rs=ps.executeQuery();

                    if (rs.next()) {
                        textField2.setText(rs.getString(1));
                        JOptionPane.showMessageDialog(MSG, "DONE");
                    } else {
                        JOptionPane.showMessageDialog(MSG, "Wrong PRN");
                    }

                    connec.close();

                }

                catch(Exception exception)
                {
                    System.out.println("Error : "+exception);
                }


            }
        });
    }
    public static void main(String args[])
    {

        Reports wr = new Reports();
        wr.setSize(400,400);
        wr.setVisible(true);
        wr.setTitle("Waiting List");


    }
}
