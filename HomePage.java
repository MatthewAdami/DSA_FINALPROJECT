import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class HomePage {

    private JFrame homeFrame;
    private Clip clip;
    private boolean isMuted = false;
    private ImageIcon muteIcon = new ImageIcon(HomePage.class.getResource("/PictureProject/mute.png"));
    private ImageIcon unmuteIcon = new ImageIcon(HomePage.class.getResource("/PictureProject/unmute.png"));
    private CupcakeMaker cupcakeMakerFrame; // Reference to the CupcakeMaker frame
  
    public HomePage(Clip clip) {
        this.clip = clip; // Initialize the Clip object passed from GIFStart
        initialize();
    }
    public HomePage() {
        initialize();
    }

    private void initialize() {
    	
    	homeFrame = new JFrame();
    	homeFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(HomePage.class.getResource("/PictureProject/Bake It Sweet - Icon.png")));
    	homeFrame.setTitle("BAKE IT SWEET");
    	homeFrame.setBounds(100, 100, 1440, 810);
    	homeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	homeFrame.getContentPane().setLayout(null);
    	homeFrame.setLocationRelativeTo(null);
    	
    	


        JButton muteButton = new JButton("");
        muteButton.setBorder(null);
        muteButton.setIcon(unmuteIcon);
        muteButton.setBackground(new Color(255, 130, 151));
        muteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                toggleMute();
                muteButton.setIcon(isMuted ? muteIcon : unmuteIcon);
            }
        });
        muteButton.setBounds(1310, 661, 70, 70);
        homeFrame.getContentPane().add(muteButton);

        JButton exitButton = new JButton("");
        exitButton.setIcon(new ImageIcon(HomePage.class.getResource("/PictureProject/ExitButton.png")));
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                homeFrame.dispose();
            }
        });
        exitButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        exitButton.setBackground(new Color(255, 255, 255));
        exitButton.setBounds(738, 462, 394, 151);
        homeFrame.getContentPane().add(exitButton);

        JButton startButton = new JButton("");
        startButton.setIcon(new ImageIcon(HomePage.class.getResource("/PictureProject/StartButton.png")));
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Show the CupcakeMaker frame
            
            }
        });
        startButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        startButton.setBackground(new Color(255, 255, 255));
        startButton.setBounds(319, 462, 394, 151);
        homeFrame.getContentPane().add(startButton);

        JLabel bg = new JLabel("");
        bg.setIcon(new ImageIcon(HomePage.class.getResource("/PictureProject/Homepage.png")));
        bg.setBounds(0, 0, 1424, 771);
        homeFrame.getContentPane().add(bg);
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Stop the background music
                if (clip.isRunning()) {
                    clip.stop();
                }
                
                // Show the CupcakeMaker frame
                GIFStart window = new GIFStart();
                window.gifframe.setVisible(true);
                homeFrame.dispose();
                

                
            }
        });
    }

    private void playBackgroundMusic() {
        try {
            File audioFile = new File("C:\\Users\\matt\\eclipse-workspace\\DSAProject\\src\\bgMusics\\BgmusicUpdated.wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void toggleMute() {
        if (isMuted) {
            clip.start();
        } else {
            clip.stop();
        }
        isMuted = !isMuted;
    }
    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                HomePage simulator = new HomePage();
                simulator.homeFrame.setVisible(true);
                simulator.playBackgroundMusic();
            }
        });
    }
}
