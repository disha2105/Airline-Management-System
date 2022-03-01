import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reservation extends JFrame{
    private JPanel panel1;
    private JButton checkAvailabilityButton;
    private JButton createPassengerButton;
    private JPanel reserve;

    public Reservation() {
        setContentPane(reserve);


        panel1.setBackground(Color.pink);
        checkAvailabilityButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Check m = new Check();
                //setVisible(false);
                m.setSize(400,400);
                m.setVisible(true);
                m.setTitle("Check Availability Screen");

            }
        });
        createPassengerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Create v = new Create();
                //setVisible(false);
                v.setSize(400,500);
                v.setVisible(true);
                v.setTitle("Create Passenger Screen");

            }
        });
    }
}
