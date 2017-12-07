package progrLab2;

import java.awt.Graphics;

import javax.swing.JPanel;

public class TerrariumPanel extends JPanel {

	private Terrarium terrarium;
	
	public TerrariumPanel(Terrarium aq){
		updateTerrariumPanel(aq);
	}
	
	public void updateTerrariumPanel(Terrarium aq){
		this.terrarium=aq;
		repaint();
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		terrarium.Draw(g);
	}
}
