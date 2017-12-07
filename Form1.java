package progrLab2;

import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JColorChooser;

import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Form1 {

	private JFrame frame;

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
	 private Terrarium terrarium;

	 private Interface1 inter;
	 private JTextField textField;
	 
	public Form1() {
		terrarium=new Terrarium();
		color=Color.green;
		dopColor=Color.YELLOW;
		maxSpeed=150;
		maxCountMouse=15;
		maxCountBirds=29;
		height=200;
		initialize();
	}

	    
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 723, 401);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		TerrariumPanel panelBig = new TerrariumPanel(terrarium);
		panelBig.setBounds(10, 11, 503, 340);
		frame.getContentPane().add(panelBig);
		SnakePanel panelSmall = new SnakePanel();
		panelSmall.setBounds(537, 231, 160, 120);
		frame.getContentPane().add(panelSmall);
		
		JButton button1 = new JButton("\u0417\u0430\u0434\u0430\u0442\u044C \u0437\u043C\u0435\u044E");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Interface1 inter = new PoisonousSnake(maxSpeed, maxCountMouse,maxCountBirds, height, color, dopColor);
				int place = terrarium.putSnakeInTerrarium(inter);
				if (place > -1) {
					panelBig.updateTerrariumPanel(terrarium);
					JOptionPane.showMessageDialog(null, "Ваше место: " + (place + 1), "",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Мест нет", "", JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		});
		button1.setBounds(574, 11, 123, 23);
		frame.getContentPane().add(button1);
		
		JButton button2 = new JButton("\u0417\u0430\u0434\u0430\u0442\u044C \u044F\u0434\u043E\u0432\u0438\u0442\u0443\u044E \u0437\u043C\u0435\u044E");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Interface1 inter = new Kobra(maxSpeed,maxCountMouse,maxCountBirds,height,color,true,true,dopColor);
				int place = terrarium.putSnakeInTerrarium(inter);
				if (place > -1) {
					panelBig.updateTerrariumPanel(terrarium);
					JOptionPane.showMessageDialog(null, "Ваше место: " + (place + 1), "",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Мест нет:", "", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		button2.setBounds(537, 45, 160, 23);
		frame.getContentPane().add(button2);
		
		JButton button3 = new JButton("\u0417\u0430\u0431\u0440\u0430\u0442\u044C \u0437\u043C\u0435\u044E");
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText() != "") {
					Interface1 inter = terrarium.getSnakeInTerrarium(Integer.parseInt(textField.getText()) - 1);
					if (inter != null) {
						inter.setPosition(25, 55);
						panelBig.updateTerrariumPanel(terrarium);
						panelSmall.updatePanel(inter);
					} else {
						JOptionPane.showMessageDialog(null, "На таком месте нет змеи", "", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		button3.setBounds(550, 197, 139, 23);
		frame.getContentPane().add(button3);
		
		JLabel label = new JLabel("\u041C\u0435\u0441\u0442\u043E:");
		label.setBounds(550, 172, 54, 14);
		frame.getContentPane().add(label);
		
		textField = new JTextField();
		textField.setBounds(611, 166, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		

	}
}
