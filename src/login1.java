import javax.management.remote.JMXConnectorFactory;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class login1 extends JFrame {

    private JButton button1;
    private JButton submitButton;
    private JButton resetButton;
    private JButton closeButton;

    private JTextField textField1;
    private JPanel mainpanel;
    private JPasswordField passwordField1;
    private JLabel LoginMessageLabel;


    public login1(){
        setContentPane(mainpanel);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userName = textField1.getText();
                String password = passwordField1.getText();
                try {
                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/airline_management",
                            "root", "$Dishak123$");

                    PreparedStatement st = (PreparedStatement) connection
                            .prepareStatement("Select username, password from user_account where username=? and password=?");

                    st.setString(1, userName);
                    st.setString(2, password);
                    ResultSet rs = st.executeQuery();
                    if (rs.next()) {


                        JOptionPane.showMessageDialog(LoginMessageLabel, "You have successfully logged in");
                        MainMenu m = new MainMenu();
                        setVisible(false);
                        m.setSize(400,400);
                        m.setVisible(true);
                        m.setTitle("Main Menu");
                    } else {
                        JOptionPane.showMessageDialog(LoginMessageLabel, "Wrong Username & Password");
                    }
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }



            }


        });
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText("");
                passwordField1.setText("");
            }
        });
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

//    public static void main(String[] args) {
//        login1 c=new login1();
//
//
//    }





}
