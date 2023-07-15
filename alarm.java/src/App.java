import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.text.SimpleDateFormat;
import java.util.Date;

public class App {
    public static void main(String[] args) {

        JFrame f = new JFrame();

        JTextField tf = new JTextField();
        JLabel label = new JLabel("Note:Alarm for 5:10 AM input 05:10 and for 5:10 PM input 17:10");
        label.setBounds(5,100,500,30);
        tf.setBounds(100, 50, 150, 30);
        f.add(tf);
        f.add(label);
        f.setLayout(null);
        f.setVisible(true);
        f.setSize(500,300);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JButton btn = new JButton("Set ALarm");
        btn.setBounds(90, 150, 180, 30);
        f.add(btn);


        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae){


                String message = "Alarm has been set!";
                String title = "Alert";

                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                JOptionPane.showMessageDialog(frame, message, title, JOptionPane.INFORMATION_MESSAGE);

                String usertime = tf.getText();

                SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

                while (true) {
                    Date currentTime = new Date();
                    String systemTime = timeFormat.format(currentTime);

                    System.out.println(usertime);
                    System.out.println(systemTime);
        
        
                    if (systemTime.equals(usertime)) {

                        System.out.println("match");

                        JFrame g = new JFrame(null, null);
                        JButton b = new JButton("Exit!", null);
                        b.setBounds(20, 50, 100, 30);
                        g.add( b);
                
                        g.setSize(400, 500);
                        g.setLayout(null);
                        g.setVisible(true);
                
                        g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                
                        b.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent ae){
                
                                System.exit(0);
                
                
                     }
                    });

                        SwingUtilities.invokeLater(() -> {
        
                            int beepCount = 250;
                            for (int i = 0; i < beepCount; ++i) {
                                
                                System.out.println("Beep : " + i);
            
                                java.awt.Toolkit.getDefaultToolkit().beep();
                                try {
                                    Thread.sleep(20); // introduce delay
                                } catch (InterruptedException e) {
                                }
                            }

                        });
        
                        break; // Exit the loop when there is a match
                    }
        
                    try {
                        Thread.sleep(1000); // Delay for 1 second
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }


     }
    });

    }
}