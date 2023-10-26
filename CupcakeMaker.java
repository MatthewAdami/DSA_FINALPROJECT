
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Stack;
import javax.sound.sampled.*;
import javax.swing.border.EmptyBorder;
public class CupcakeMaker extends JFrame {
	private Stack<String> toppingsStack = new Stack<>();
	private JTextArea toppingList;
	  private Clip clip;
	  private boolean isMuted = false;
	  private ImageIcon muteIcon = new ImageIcon(CupcakeMaker.class.getResource("/PictureProject/unmute updated.png"));
	  private ImageIcon unmuteIcon = new ImageIcon(CupcakeMaker.class.getResource("/PictureProject/mute updated.png"));
	  
	public CupcakeMaker() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CupcakeMaker.class.getResource("/PictureProject/Bake It Sweet - Icon.png")));
		setTitle("BAKE IT SWEET");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1440, 810);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		
		
		JButton muteButton = new JButton("");
		muteButton.setBackground(new Color(94, 53, 38));
		muteButton.setIcon(new ImageIcon(CupcakeMaker.class.getResource("/PictureProject/mute updated.png")));
		muteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toggleMute();
				muteButton.setIcon(isMuted ? muteIcon : unmuteIcon);
				
			}
		});
		toppingList = new JTextArea(5, 6);
		toppingList.setEditable(false);
		toppingList.setTabSize(5);
		toppingList.setFont(new Font("Monospaced", Font.BOLD, 42));
		toppingList.setOpaque(false);
		toppingList.setForeground(Color.BLACK);

		// Add custom line spacing between items
		StringBuilder toppingsText = new StringBuilder();
		for (String topping : toppingsStack) {
		    toppingsText.append(topping).append("\n\n"); // Add extra newline for spacing
		}
		toppingList.setText(toppingsText.toString());

		toppingList.setBounds(28, 145, 389, 572);
		getContentPane().add(toppingList);

		
		JLabel list = new JLabel("");
		list.setIcon(new ImageIcon(CupcakeMaker.class.getResource("/PictureProject/list.png")));
		list.setBounds(10, 11, 420, 728);
		getContentPane().add(list);
		
		muteButton.setBounds(471, 609, 284, 79);
		getContentPane().add(muteButton);
		JButton strawberriesButton = new JButton("");
		strawberriesButton.setBorder(null);
		strawberriesButton.setBackground(new Color(94, 53, 38));
		strawberriesButton.setIcon(new ImageIcon(CupcakeMaker.class.getResource("/PictureProject/Strawberry_button.png")));
		strawberriesButton.setBounds(471, 40, 284, 262);
		getContentPane().add(strawberriesButton);
		
		
		strawberriesButton.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        String topping = "Strawberries";
		        if (!toppingsStack.contains(topping)) {
		            toppingsStack.push(topping);
		            updateToppingList();
		        } else {
		            // Display a message to the user
		            JOptionPane.showMessageDialog(CupcakeMaker.this, "The topping cannot be repeated.", "Topping Error", JOptionPane.ERROR_MESSAGE);
		        
		        }
		    }
		});

		JButton vanillaicingButton = new JButton("");
		vanillaicingButton.setBorder(null);
		vanillaicingButton.setBackground(new Color(94, 53, 38));
		vanillaicingButton.setIcon(new ImageIcon(CupcakeMaker.class.getResource("/PictureProject/VanillaIcing_button.png")));
		vanillaicingButton.setBounds(782, 325, 284, 262);
		getContentPane().add(vanillaicingButton);
		JButton deleteToppingButton = new JButton("");
		deleteToppingButton.setIcon(new ImageIcon(CupcakeMaker.class.getResource("/PictureProject/remove updated.png")));
		deleteToppingButton.setBounds(782, 609, 284, 79);
		getContentPane().add(deleteToppingButton);
		JButton doneButton = new JButton("");
		doneButton.setIcon(new ImageIcon(CupcakeMaker.class.getResource("/PictureProject/done updated.png")));
		doneButton.setBounds(1088, 609, 284, 79);
		getContentPane().add(doneButton);

		// Create buttons for each topping
		JButton chocolateSprinklesButton = new JButton("");
		chocolateSprinklesButton.setBorder(null);
		chocolateSprinklesButton.setBackground(new Color(94, 53, 38));
		chocolateSprinklesButton.setIcon(new ImageIcon(CupcakeMaker.class.getResource("/PictureProject/Chocolate_button.png")));
		chocolateSprinklesButton.setBounds(782, 40, 284, 262);
		getContentPane().add(chocolateSprinklesButton);
		JButton blueberryButton = new JButton("");
		blueberryButton.setBorder(null);
		blueberryButton.setBackground(new Color(94, 53, 38));
		blueberryButton.setIcon(new ImageIcon(CupcakeMaker.class.getResource("/PictureProject/Blueberry_button.png")));
		blueberryButton.setBounds(471, 325, 284, 262);
		getContentPane().add(blueberryButton);
		JButton cherryButton = new JButton("");
		cherryButton.setBorder(null);
		cherryButton.setBackground(new Color(94, 53, 38));
		cherryButton.setIcon(new ImageIcon(CupcakeMaker.class.getResource("/PictureProject/Cherry_button.png")));
		cherryButton.setBounds(1088, 40, 284, 262);
		getContentPane().add(cherryButton);
		JButton chocolateicingButton = new JButton("");
		chocolateicingButton.setBorder(null);
		chocolateicingButton.setBackground(new Color(94, 53, 38));
		chocolateicingButton.setIcon(new ImageIcon(CupcakeMaker.class.getResource("/PictureProject/ChocolateIcing_button.png")));
		chocolateicingButton.setBounds(1088, 325, 284, 262);
		getContentPane().add(chocolateicingButton);
		
		JLabel makerbg = new JLabel("");
		makerbg.setBounds(0, 0, 1434, 797);
		getContentPane().add(makerbg);
		makerbg.setIcon(new ImageIcon(CupcakeMaker.class.getResource("/PictureProject/CupcakeMakerBackground.png")));

		chocolateicingButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				 String topping = "Chocolate Icing";
			        if (!toppingsStack.contains(topping)) {
			            toppingsStack.push(topping);
			            updateToppingList();
			        } else {
			            // Display a message to the user
			            JOptionPane.showMessageDialog(CupcakeMaker.this, "The topping cannot be repeated.", "Topping Error", JOptionPane.ERROR_MESSAGE);
			        }
			}
		});

		cherryButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				 String topping = "Cherry";
			        if (!toppingsStack.contains(topping)) {
			            toppingsStack.push(topping);
			            updateToppingList();
			        } else {
			            // Display a message to the user
			            JOptionPane.showMessageDialog(CupcakeMaker.this, "The topping cannot be repeated.", "Topping Error", JOptionPane.ERROR_MESSAGE);
			        
			        }
			}
		});

		blueberryButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String topping = "Blueberry";
		        if (!toppingsStack.contains(topping)) {
		            toppingsStack.push(topping);
		            updateToppingList();
		        } else {
		            // Display a message to the user
		            JOptionPane.showMessageDialog(CupcakeMaker.this, "The topping cannot be repeated.", "Topping Error", JOptionPane.ERROR_MESSAGE);
		        
		        }
			}
		});

		// Action listeners for topping buttons
		chocolateSprinklesButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String topping = "Chocolate Bar";
		        if (!toppingsStack.contains(topping)) {
		            toppingsStack.push(topping);
		            updateToppingList();
		        } else {
		            // Display a message to the user
		            JOptionPane.showMessageDialog(CupcakeMaker.this, "The topping cannot be repeated.", "Topping Error", JOptionPane.ERROR_MESSAGE);
		        
		        }
			}
		});

		doneButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				displayFinalProduct();
			}
		});
		deleteToppingButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!toppingsStack.isEmpty()) {
					toppingsStack.pop();
					updateToppingList();
				}
			} 
		});

		vanillaicingButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String topping = "Vanilla Icing";
		        if (!toppingsStack.contains(topping)) {
		            toppingsStack.push(topping);
		            updateToppingList();
		        } else {
		            // Display a message to the user
		            JOptionPane.showMessageDialog(CupcakeMaker.this, "The topping cannot be repeated.", "Topping Error", JOptionPane.ERROR_MESSAGE);
		        
		        }
			}
		});
		playBackgroundMusic();
		updateToppingList();
	}

	private void updateToppingList() {
		StringBuilder toppingsText = new StringBuilder();
		for (String topping : toppingsStack) {
			toppingsText.append(topping).append("\n");
		}
		toppingList.setText(toppingsText.toString());
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
	            	CupcakeMaker simulator = new CupcakeMaker();
	                simulator.setVisible(true);
	                
	            }
	        });
	    }
	



	private void displayFinalProduct() {
		JFrame finalProductFrame = new JFrame("BAKE IT SWEET");
		finalProductFrame.setSize(1440, 810);
		 finalProductFrame.setLocationRelativeTo(null);
		finalProductFrame.getContentPane().setLayout(new BorderLayout());

		ImageIcon imageIcon;

		// Construct the selected toppings string
		String selectedTopping = String.join(" + ", toppingsStack);

		// Add image display logic based on selectedToppings here
		if ("Blueberry + Strawberries + Vanilla Icing".equals(selectedTopping)) {
			imageIcon = new ImageIcon(
					"C:\\Users\\matt\\eclipse-workspace\\DSAProject\\src\\PictureProject\\Vanilla Icing Blueberry Strawberry.png");
		} else if ("Vanilla Icing + Strawberries".equals(selectedTopping)) {
			imageIcon = new ImageIcon(
					"C:\\Users\\matt\\eclipse-workspace\\DSAProject\\src\\PictureProject\\Vanilla Icing and strawberry.png");
		} else if ("Vanilla Icing + Cherry".equals(selectedTopping)) {
			imageIcon = new ImageIcon(
					"C:\\Users\\matt\\eclipse-workspace\\DSAProject\\src\\PictureProject\\Vanilla Icing Cherry.png");
		} else if ("Vanilla Icing + Chocolate Icing + Blueberry + Strawberries + Cherry".equals(selectedTopping)) {
			imageIcon = new ImageIcon(
					"C:\\Users\\matt\\eclipse-workspace\\DSAProject\\src\\PictureProject\\Vanilla Icing Chocolate Icing Blueberry Chocolate Bar Strawberry Cherry.png");
		} else if ("Vanilla Icing + Chocolate Icing + Blueberry + Strawberries + Cherry".equals(selectedTopping)) {
			imageIcon = new ImageIcon(
					"C:\\Users\\matt\\eclipse-workspace\\DSAProject\\src\\PictureProject\\Vanilla Icing Chocolate Icing Blueberry Chocolate Bar Strawberry Cherry.png");
		} else if ("Vanilla Icing + Chocolate Icing + Blueberry + Chocolate Bar + Strawberries + Cherry".equals(selectedTopping)) {
			imageIcon = new ImageIcon(
					"C:\\Users\\matt\\eclipse-workspace\\DSAProject\\src\\PictureProject\\Vanilla Icing Chocolate Icing Blueberry Chocolate Bar Strawberry Cherry.png");
		} else if ("Chocolate Icing + Cherry".equals(selectedTopping)) {
			imageIcon = new ImageIcon(
					"C:\\Users\\matt\\eclipse-workspace\\DSAProject\\src\\PictureProject\\Chocolate Icing Cherry.png");
		} else if ("Vanilla Icing + Chocolate Bar".equals(selectedTopping)) {
			imageIcon = new ImageIcon(
					"C:\\Users\\matt\\eclipse-workspace\\DSAProject\\src\\PictureProject\\Vanilla Icing Chocolate Bar.png");
		} else if ("Blueberry + Chocolate Icing".equals(selectedTopping)) {
			imageIcon = new ImageIcon(
					"C:\\Users\\matt\\eclipse-workspace\\DSAProject\\src\\PictureProject\\Blueberry Chocolate Icing.png");
		} else if ("Chocolate Icing + Blueberry".equals(selectedTopping)) {
			imageIcon = new ImageIcon(
					"C:\\Users\\matt\\eclipse-workspace\\DSAProject\\src\\PictureProject\\Chocolate Icing Blueberry.png");
		} else if ("Chocolate Icing + Blueberry + Cherry".equals(selectedTopping)) {
			imageIcon = new ImageIcon(
					"C:\\Users\\matt\\eclipse-workspace\\DSAProject\\src\\PictureProject\\Chocolate Blueberry Cherry.png");
		} else if ("Vanilla Icing + Vanilla Icing + Vanilla Icing".equals(selectedTopping)) {
			imageIcon = new ImageIcon(
					"C:\\Users\\matt\\eclipse-workspace\\DSAProject\\src\\PictureProject\\Vanilla Icing 3 Layers.png");
		} else if ("Chocolate Icing + Chocolate Icing + Chocolate Icing".equals(selectedTopping)) {
			imageIcon = new ImageIcon(
					"C:\\Users\\matt\\eclipse-workspace\\DSAProject\\src\\PictureProject\\Chocolate Icing 3 Layers.png");
		} else if ("Chocolate Icing + Vanilla Icing + Chocolate Icing".equals(selectedTopping)) {
			imageIcon = new ImageIcon(
					"C:\\Users\\matt\\eclipse-workspace\\DSAProject\\src\\PictureProject\\Chocolate_Vanilla_Chocolate.png");
		} else if ("Chocolate Icing + Chocolate Icing + Vanilla Icing".equals(selectedTopping)) {
			imageIcon = new ImageIcon(
					"C:\\Users\\matt\\eclipse-workspace\\DSAProject\\src\\PictureProject\\Chocolate Chocolate Vanilla.png");
		} else if ("Chocolate Icing + Blueberry + Cherry + Chocolate Bar".equals(selectedTopping)) {
			imageIcon = new ImageIcon(
					"C:\\Users\\matt\\eclipse-workspace\\DSAProject\\src\\PictureProject\\Chocolate Icing Blueberry Chocolate Bar Cherry.png");
		} else if ("Vanilla Icing + Strawberries + Chocolate Bar".equals(selectedTopping)) {
			imageIcon = new ImageIcon(
					"C:\\Users\\matt\\eclipse-workspace\\DSAProject\\src\\PictureProject\\Vanilla Icing Strawberry Chocolate Bar.png");
		} else if ("Blueberry + Vanilla Icing".equals(selectedTopping)) {
			imageIcon = new ImageIcon(
					"C:\\Users\\matt\\eclipse-workspace\\DSAProject\\src\\PictureProject\\Blueberry Vanilla Icing.png");
		} else if ("Vanilla Icing + Blueberry".equals(selectedTopping)) {
			imageIcon = new ImageIcon(
					"C:\\Users\\matt\\eclipse-workspace\\DSAProject\\src\\PictureProject\\Vanilla Icing Blueberry.png");
		} else if ("Strawberries + Vanilla Icing".equals(selectedTopping)) {
			imageIcon = new ImageIcon(
					"C:\\Users\\matt\\eclipse-workspace\\DSAProject\\src\\PictureProject\\Strawberry_Vanilla Icing.png");
		}else if ("Chocolate Icing + Strawberries".equals(selectedTopping)) {
				imageIcon = new ImageIcon(
						"C:\\Users\\matt\\eclipse-workspace\\DSAProject\\src\\PictureProject\\Chocolate Icing Strawberry.png");
		}else if ("Vanilla Icing + Cherry + Chocolate Bar".equals(selectedTopping)) {
			imageIcon = new ImageIcon(
					"C:\\Users\\matt\\eclipse-workspace\\DSAProject\\src\\PictureProject\\Vanilla Icing_Cherry_Chocolate Bar.png");
		}else if ("Vanilla Icing + Cherry + Strawberries".equals(selectedTopping)) {
			imageIcon = new ImageIcon(
					"C:\\Users\\matt\\eclipse-workspace\\DSAProject\\src\\PictureProject\\Vanilla Icing_Cherry_Strawberry.png");
		} else if ("Strawberries".equals(selectedTopping)) {
			imageIcon = new ImageIcon(
					"C:\\Users\\matt\\eclipse-workspace\\DSAProject\\src\\PictureProject\\Strawberry only.png");
		} else if ("Vanilla Icing".equals(selectedTopping)) {
			imageIcon = new ImageIcon(
					"C:\\Users\\matt\\eclipse-workspace\\DSAProject\\src\\PictureProject\\VanillaFinish.png");
		} else if ("Blueberry".equals(selectedTopping)) {
			imageIcon = new ImageIcon(
					"C:\\Users\\matt\\eclipse-workspace\\DSAProject\\src\\PictureProject\\Blueberry only.png");
		} else if ("Cherry".equals(selectedTopping)) {
			imageIcon = new ImageIcon(
					"C:\\Users\\matt\\eclipse-workspace\\DSAProject\\src\\PictureProject\\Cherry only.png");
		} else if ("Chocolate Icing".equals(selectedTopping)) {
			imageIcon = new ImageIcon(
					"C:\\Users\\matt\\eclipse-workspace\\DSAProject\\src\\PictureProject\\ChocolateIcingFinish.png");
		} else if ("Chocolate Bar".equals(selectedTopping)) {
			imageIcon = new ImageIcon(
					"C:\\Users\\matt\\eclipse-workspace\\DSAProject\\src\\PictureProject\\Chocolate only.png");
		} else {
			// Load a default image for other toppings
			imageIcon = new ImageIcon(
					"C:\\Users\\matt\\eclipse-workspace\\DSAProject\\src\\PictureProject\\default-image.jpg");
		}

		JLabel finalProductLabel = new JLabel(imageIcon);
		finalProductFrame.getContentPane().add(finalProductLabel, BorderLayout.CENTER);
		finalProductFrame.setVisible(true);
	}

}