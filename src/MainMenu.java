import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame {
    private JPanel panel1;


    private JButton closeButton;
    private JMenu Mymenu1;
    private JMenuItem item1;
    private JMenuItem item2;
    private JMenuBar JmenuBar2;
    private JMenu Mymenu2;
    private JMenuItem item3;
    private JMenuItem item4;
    private JMenuBar JMenuBar1;
    private JPanel menu;

    public MainMenu() {
        setContentPane(menu);

        panel1.setBackground(Color.pink);
        item1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                {
                    Reservation r = new Reservation();
                    r.setSize(400,400);
                    r.setVisible(true);
                    r.setTitle("Reservation Screen");

                }

            }
        });



        item2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                {
                    Cancellation c = new Cancellation();
                    c.setSize(400,400);
                    c.setVisible(true);
                    c.setTitle("Cancellation Screen");


                }

            }
        });

        item3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                {
                    Reports wr = new Reports();
                    wr.setSize(400,400);
                    wr.setVisible(true);
                    wr.setTitle("Waiting List");


                }

            }
        });
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
