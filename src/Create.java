import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.lang.*;

public class Create extends JFrame {
    private JPanel panel1;
    private JComboBox comboBox1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JTextField textField9;
    private JTextField textField10;
    private JButton resetButton;
    private JButton submitButton;

    Statement stmt;
    ResultSet rs;
    int count;

    public Create() {
        setContentPane(panel1);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/airline_management",
                            "root", "$Dishak123$");


                    PreparedStatement ps=conn.prepareStatement("insert into airline_management.passengers(FlightNo,TravelDate,FName,LName,Age,Gender,Address,Phone,Class,Status)values(?,?,?,?,?,?,?,?,?,?)");

                    String age = textField3.getText();
                    String ph= textField8.getText();
                    ps.setString(2,textField10.getText());
                    ps.setString(1,textField9.getText());
                    ps.setString(3,textField2.getText());
                    ps.setString(4,textField1.getText());
                    ps.setInt(5,Integer.parseInt(age));
                    ps.setString(6,textField4.getText());
                    ps.setString(7,textField6.getText());
                    ps.setInt(8, (Integer.parseInt(ph)));
                    ps.setString(9,textField7.getText());
                    ps.setString(10,textField5.getText());
                    ps.executeUpdate();




                    if(textField8.getText().equals(String.valueOf('F')))
                    {
                        String str = "update airline_management.check set FSeats=FSeats-1 where FlightNo=? and TravelDate = ?";
                        ps = conn.prepareStatement(str);
                        ps.setString(1,textField10.getText());
                        ps.setString(2,textField1.getText());
                        count = ps.executeUpdate();
                    }
                    if(textField8.getText().equals(String.valueOf('B')))
                    {
                        String str = "update airline_management.check set BSeats=BSeats-1 where FlightNo=? and TravelDate = ?";
                        ps = conn.prepareStatement(str);
                        ps.setString(1,textField10.getText());
                        ps.setString(2,textField1.getText());
                        count = ps.executeUpdate();
                    }

                    if(textField8.getText().equals(String.valueOf('E')))
                    {
                        String str = "update airline_management.check set ESeats=ESeats-1 where FlightNo=? and TravelDate = ?";
                        ps = conn.prepareStatement(str);
                        ps.setString(1,textField10.getText());
                        ps.setString(2,textField1.getText());
                        count = ps.executeUpdate();
                    }





//                    conn.close();
                    textField1.setText("");
                    textField2.setText("");
                    textField3.setText("");
                    textField4.setText("");
                    textField5.setText("");
                    textField6.setText("");
                    textField7.setText("");
                    textField8.setText("");
                    textField9.setText("");
                    textField10.setText("");

                    Ticket t = new Ticket();
                    //setVisible(false);
                    t.setSize(400,500);
                    t.setVisible(true);
                    t.setTitle("Ticket Screen");




                }

                catch(SQLException exc)
                {
                    System.out.println("2 Error : "+exc);
                }
                catch(Exception ex)
                {
                    System.out.println("Error 1:"+ex);
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
                textField6.setText("");
                textField7.setText("");
                textField8.setText("");
                textField9.setText("");
                textField10.setText("");

            }
        });

    }

    public static void main(String args[])
    {

        Create v = new Create();
        v.setSize(400,500);
        v.setVisible(true);
        v.setTitle("Create Passenger Screen");


    }
}
