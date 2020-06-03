import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class GUIDemo extends JFrame {
	
	JRadioButton yesBtn;
	JRadioButton noBtn;
	JTextField reasoning;
	JButton submitButton;
	JLabel result;
	
	// Panels for the left and right sides
	JPanel left;
	JPanel right;

	public GUIDemo() {
		initialize();
	}
	
	public void initialize() {
		// set the window size
		this.setBounds(100, 100, 450, 300);
		
		// what to do when closing
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// a title
		this.setTitle("Our First GUI");
		
		this.getContentPane().setLayout(new BorderLayout(0,0));
		
		JPanel p = new JPanel();
		p.add(new JLabel("Should pineapple be a pizza topping?"));
		
		yesBtn = new JRadioButton("Yes");
		noBtn = new JRadioButton("No");
		ButtonGroup yesNo = new ButtonGroup();
		yesNo.add(yesBtn);
		yesNo.add(noBtn);
		
		// Let's add the action listener to our radio buttons!
		yesBtn.setActionCommand("radioSet");
		noBtn.setActionCommand("radioSet"); // they'll send the same command
		yesBtn.addActionListener(new ButtonListener());
		noBtn.addActionListener(new ButtonListener());
		
		p.add(yesBtn);
		p.add(noBtn);
		this.getContentPane().add(p, BorderLayout.CENTER);
		
		JPanel bottom = new JPanel();
		bottom.add(new JLabel("Why?"));
		reasoning = new JTextField(15);
		bottom.add(reasoning);
		
		submitButton = new JButton("Submit");
		submitButton.setActionCommand("submit");
		submitButton.addActionListener(new ButtonListener());
		bottom.add(submitButton);
	
		result = new JLabel();
		bottom.add(result);
		
		this.getContentPane().add(bottom, BorderLayout.SOUTH);
		
		// Image at the top of the window
		try {
			BufferedImage picture = ImageIO.read(new File("pineapple-pizza.jpg"));
			JLabel picLabel = new JLabel(new ImageIcon(picture));
			JPanel top = new JPanel();
			top.add(picLabel);
			this.getContentPane().add(top, BorderLayout.NORTH);
		} catch (Exception e) {
			System.out.println("Something went wrong");
		}
		
		// Empty panels at the left and right
		left = new JPanel();
		this.getContentPane().add(left, BorderLayout.WEST);
		right = new JPanel();
		this.getContentPane().add(right, BorderLayout.EAST);
	}
	
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// This handles if we click the submit button
			if (e.getActionCommand().equals("submit")) {
				if (yesBtn.isSelected()) {
					result.setText(":-( " + reasoning.getText());
					
				} else if (noBtn.isSelected()) {
					result.setText(":-)");
				}
			}
			
			// This handles if we click the radio buttons
			if (e.getActionCommand().equals("radioSet")) {
				if (yesBtn.isSelected()) {
					// change the color of left!
					left.setBackground(Color.RED);
					// remove the color from right
					right.setBackground(null);
				} else if (noBtn.isSelected()) {
					right.setBackground(Color.BLUE);
					left.setBackground(null);
				}
			}
		}
		
	}
	
	
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIDemo gui = new GUIDemo();
					
					gui.pack();
					
					// make gui visible
					gui.setVisible(true);
				} catch (Exception e) {
					System.out.println("Something went wrong!");
				}
			}
		});
	}
}
