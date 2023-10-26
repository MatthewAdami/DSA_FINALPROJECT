import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import javax.sound.sampled.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class GIFStart extends JFrame {
    private Clip clip;
    JFrame gifframe;

    public GIFStart() {
        initialize();
    }

    private void initialize() {
        gifframe = new JFrame();
        gifframe.setIconImage(Toolkit.getDefaultToolkit().getImage(GIFStart.class.getResource("/PictureProject/Bake It Sweet - Icon.png")));
        gifframe.setBounds(100, 100, 1440, 810);
        gifframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gifframe.getContentPane().setLayout(null);
        gifframe.setLocationRelativeTo(null);
        gifframe.setTitle("BAKE IT SWEET");

        JLabel GIF = new JLabel("");
        GIF.setIcon(new ImageIcon(GIFStart.class.getResource("/PictureProject/My Video3.gif")));
        GIF.setBounds(0, 0, 1435, 771);
        gifframe.getContentPane().add(GIF);

        JLabel nextbutton = new JLabel("");
        nextbutton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (clip != null && clip.isRunning()) {
                    clip.stop();
                }
                CupcakeMaker simulator = new CupcakeMaker();
                simulator.setVisible(true);
                gifframe.dispose();
            }
        });

        nextbutton.setBounds(420, 273, 814, 362);
        gifframe.getContentPane().add(nextbutton);

        // Initialize and play the background music
        try {
            File audioFile = new File("C:\\Users\\matt\\eclipse-workspace\\DSAProject\\src\\bgMusics\\BgmusicUpdated.wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                GIFStart window = new GIFStart();
                window.gifframe.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
