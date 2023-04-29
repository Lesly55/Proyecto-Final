package proyecto_final;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ColorSliders extends JPanel implements ActionListener, ChangeListener{
	
	private static final long serialVersionUID = 1L;
	private static JLabel color, rLbl, gLbl, bLbl;
	private static JSlider red, green, blue;
	private static JTextField rt, gt, bt;
	private static Color col;
	
	public ColorSliders() {
		components();
		
		setSize(400, 600);							// tamaño de la ventana
		setLayout(null);							// elimina plantillas
		setBackground(Color.white);
		setVisible(true);				
	}
		
	
	private void components() {
		red = new JSlider(0, 255);
		green = new JSlider(0, 255);
		blue = new JSlider(0, 255);
		rLbl = new JLabel("Red");
		gLbl = new JLabel("Green");
		bLbl = new JLabel("Blue");
		rt = new JTextField("127");
		gt = new JTextField("127");
		bt = new JTextField("127");
		color = new JLabel("");
		col = new Color(127, 127,127);
		
		
		// Color
		color.setBounds(80, 330, 120, 120);
		color.setBorder(BorderFactory.createLineBorder(Color.white));
		
		// Red slider 
		rLbl.setBounds(25, 50, 40, 30);
		rLbl.setForeground(Color.black);
		rLbl.setFont(new Font("SansSerif", Font.PLAIN, 20));
		red.setBounds(20, 80, 255, 50);
		red.addChangeListener(this); 
		red.setPaintLabels(true);
		red.setPaintTrack(true);
		red.setFont(new Font("SansSerif", Font.PLAIN, 15));
		red.setForeground(Color.black);
		red.setMajorTickSpacing(255);
		red.setBackground(Color.white);
		red.setOpaque(true);
		rt.setBounds(280, 85, 40, 40);
		rt.setHorizontalAlignment(JTextField.CENTER);
		rt.setFont(new Font("Serif", Font.PLAIN, 15));
		rt.addActionListener(this);
				
		// Green slider 
		gLbl.setBounds(25, 140, 100, 30);
		gLbl.setForeground(Color.black);
		gLbl.setFont(new Font("SansSerif", Font.PLAIN, 20));
		green.setBounds(20, 170, 255, 50);
		green.addChangeListener(this);	
		green.setPaintLabels(true);
		green.setPaintTrack(true);
		green.setFont(new Font("SansSerif", Font.PLAIN, 15));
		green.setForeground(Color.black);
		green.setMajorTickSpacing(255);
		green.setBackground(Color.white);
		green.setOpaque(true);
		gt.setBounds(280, 175, 40, 40);
		gt.setHorizontalAlignment(JTextField.CENTER);
		gt.setFont(new Font("SansSerif", Font.PLAIN, 15));
		gt.addActionListener(this);
				
		// Blue slider
		bLbl.setBounds(25, 230, 100, 30);
		bLbl.setForeground(Color.black);
		bLbl.setFont(new Font("SansSerif", Font.PLAIN, 20));
		blue.setBounds(20, 260, 255, 50);
		blue.addChangeListener(this);
		blue.setPaintLabels(true);
		blue.setPaintTrack(true);
		blue.setFont(new Font("SansSerif", Font.PLAIN, 15));
		blue.setForeground(Color.black);
		blue.setMajorTickSpacing(255);
		blue.setBackground(Color.white);
		blue.setOpaque(true);
		bt.setBounds(280, 265, 40, 40);
		bt.setHorizontalAlignment(JTextField.CENTER);
		bt.setFont(new Font("SansSerif", Font.PLAIN, 15));
		bt.addActionListener(this);
		
		add(red);
		add(green);
		add(blue);
		add(rLbl);
		add(rt);
		add(gLbl);
		add(gt);
		add(bLbl);
		add(bt);
		add(color);
	}
	
	public Color getColor() {
		return col;
	}
	
	public static void setColor(Color c) {
	
		int r = c.getRed();
		int g = c.getGreen();
		int b = c.getBlue();
		
	    rt.setText(Integer.toString(r));
	    gt.setText(Integer.toString(g));
	    bt.setText(Integer.toString(b));
	    
	    red.setValue(r);
	    green.setValue(g);
	    blue.setValue(b);
	    
	    
	    col = c;
	    color.setOpaque(true);
		color.setBackground(col);
		
		if (r + g + b > 400) {
			color.setBorder(BorderFactory.createLineBorder(Color.black));
		} else {
			color.setBorder(BorderFactory.createLineBorder(Color.white));
		}
	}
	
	private void setColor() {
		int r = red.getValue();
		int g = green.getValue();
		int b = blue.getValue();
		
	    rt.setText(Integer.toString(r));
	    gt.setText(Integer.toString(g));
	    bt.setText(Integer.toString(b));
	    
	    col = new Color(r, g, b);
	    color.setOpaque(true);
		color.setBackground(col);
		
		if (r + g + b > 400) {
			color.setBorder(BorderFactory.createLineBorder(Color.black));
		} else {
			color.setBorder(BorderFactory.createLineBorder(Color.white));
		}
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		setColor();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JTextField source = (JTextField) e.getSource();
		
		if (Integer.parseInt(source.getText()) > 255)
  		  source.setText("255");
			else if (Integer.parseInt(source.getText()) < 0)
  		  source.setText("0");
			
		if (source == rt)
			red.setValue(Integer.parseInt(source.getText()));
		else if (source == gt)
			green.setValue(Integer.parseInt(source.getText()));
		else if (source == bt)
			blue.setValue(Integer.parseInt(source.getText()));
	}
}
