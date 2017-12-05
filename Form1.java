package progrLab2;

import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JColorChooser;

import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Form1 {

	private JFrame frame;
	private JTextField textFieldSpeed;
	private JTextField textFieldMouse;
	private JTextField textFieldBirds;
	private JTextField textFieldHeight;
	private JTextField textFieldPoison;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form1 window = new Form1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	
	 Color color;
	 Color dopColor;
	 int maxCountMouse;
	 int maxCountBirds;
	 int maxSpeed;
	 int height;

	 private Interface1 inter;
	 
	public Form1() {
		color=Color.green;
		dopColor=Color.YELLOW;
		maxSpeed=150;
		maxCountMouse=15;
		maxCountBirds=29;
		height=200;
		initialize();
	}

	  private boolean checkFields()
	    {
	        try {
	            Integer.parseInt(textFieldMouse.getText());
	            Integer.parseInt(textFieldSpeed.getText());
	            Integer.parseInt(textFieldBirds.getText());
	            Integer.parseInt(textFieldHeight.getText());
	            Integer.parseInt(textFieldPoison.getText());
	            return true;
	        } catch (NumberFormatException e) {
	            return true;
	        }
	    }
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 356);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 414, 187);
		frame.getContentPane().add(panel);
		
		JLabel lblSpeed = new JLabel("Speed:");
		lblSpeed.setBounds(10, 209, 83, 14);
		frame.getContentPane().add(lblSpeed);
		
		JLabel lblMouse = new JLabel("Mouse:");
		lblMouse.setBounds(10, 234, 46, 14);
		frame.getContentPane().add(lblMouse);
		
		JLabel lblBirds = new JLabel("Birds:");
		lblBirds.setBounds(10, 259, 46, 14);
		frame.getContentPane().add(lblBirds);
		
		JLabel lblHeight = new JLabel("Height:");
		lblHeight.setBounds(148, 209, 46, 14);
		frame.getContentPane().add(lblHeight);
		
		JLabel lblPoison = new JLabel("Poison:");
		lblPoison.setBounds(291, 209, 46, 14);
		frame.getContentPane().add(lblPoison);
		
		JLabel lblColor = new JLabel("Color1:");
		lblColor.setBounds(148, 234, 46, 14);
		frame.getContentPane().add(lblColor);
		
		JLabel lblColor_1 = new JLabel("Color2:");
		lblColor_1.setBounds(291, 234, 46, 14);
		frame.getContentPane().add(lblColor_1);
		
		JButton button1 = new JButton("\u0417\u0430\u0434\u0430\u0442\u044C \u0437\u043C\u0435\u044E");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			     if (checkFields())
	                {
	                    inter = new PoisonousSnake(maxSpeed, maxCountMouse, maxCountBirds,height, color,dopColor);
	                    Graphics gr = panel.getGraphics();
	                    gr.clearRect(0,0,panel.getWidth(),panel.getHeight());
	                    inter.drawAnimal(gr);
	                }
				
			}
		});
		button1.setBounds(4, 284, 123, 23);
		frame.getContentPane().add(button1);
		
		JButton button2 = new JButton("\u0417\u0430\u0434\u0430\u0442\u044C \u044F\u0434\u043E\u0432\u0438\u0442\u0443\u044E \u0437\u043C\u0435\u044E");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  if (checkFields())
	                {
	                    inter = new Kobra(maxSpeed, maxCountMouse, maxCountBirds,height, color,true,true,dopColor);
	                    Graphics gr = panel.getGraphics();
	                    gr.clearRect(0,0,panel.getWidth(),panel.getHeight());
	                    inter.drawAnimal(gr);
	                }
			}
		});
		button2.setBounds(137, 284, 160, 23);
		frame.getContentPane().add(button2);
		
		JButton button3 = new JButton("\u0414\u0432\u0438\u0436\u0435\u043D\u0438\u0435");
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if (inter != null)
	                {
	                    Graphics gr = panel.getGraphics();
	                    gr.clearRect(0,0,panel.getWidth(),panel.getHeight());
	                    inter.moveAnimal(gr);
	                }
			}
		});
		button3.setBounds(310, 284, 89, 23);
		frame.getContentPane().add(button3);
		
		JButton button4 = new JButton("Color");
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Color initialBackground = button4.getBackground();
	                Color newColor = JColorChooser.showDialog(null, "JColorChooser Sample", initialBackground);
	                if (newColor == null) {
	                    return;
	                }
	                color = newColor;
	                button4.setBackground(newColor);
			}
		});
		button4.setForeground(Color.GREEN);
		button4.setBackground(Color.GREEN);
		button4.setBounds(158, 255, 89, 23);
		frame.getContentPane().add(button4);
		
		JButton btnColor = new JButton("Color");
		btnColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Color initialBackground = btnColor.getBackground();
	                Color newColor = JColorChooser.showDialog(null, "JColorChooser Sample", initialBackground);
	                if (newColor == null) {
	                    return;
	                }
	                dopColor = newColor;
	                btnColor.setBackground(newColor);
			}
		});
		btnColor.setForeground(Color.YELLOW);
		btnColor.setBackground(Color.YELLOW);
		btnColor.setBounds(301, 255, 89, 23);
		frame.getContentPane().add(btnColor);
	
		textFieldSpeed = new JTextField();
		textFieldSpeed.setBounds(52, 206, 86, 20);
		frame.getContentPane().add(textFieldSpeed);
		textFieldSpeed.setColumns(10);
		
		textFieldMouse = new JTextField();
		textFieldMouse.setBounds(52, 231, 86, 20);
		frame.getContentPane().add(textFieldMouse);
		textFieldMouse.setColumns(10);
		
		textFieldBirds = new JTextField();
		textFieldBirds.setBounds(52, 259, 86, 20);
		frame.getContentPane().add(textFieldBirds);
		textFieldBirds.setColumns(10);
		
		textFieldHeight = new JTextField();
		textFieldHeight.setBounds(190, 206, 86, 20);
		frame.getContentPane().add(textFieldHeight);
		textFieldHeight.setColumns(10);
		
		textFieldPoison = new JTextField();
		textFieldPoison.setBounds(326, 206, 86, 20);
		frame.getContentPane().add(textFieldPoison);
		textFieldPoison.setColumns(10);
	}
}
