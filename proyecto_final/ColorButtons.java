package proyecto_final;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;


public class ColorButtons extends JPanel implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	private static JButton red, green, blue, yellow, black, white, col1, col2, col3, col4, col5, col6;
	private static Color currentColor;
	private List<Color> colors;
	
	public ColorButtons() {
		components();
		
		setSize(400, 200);
		setLayout(null);
		//setBackground(Color.white);
		setVisible(true);				
	}
		
	
	private void components() {
		
		red = new JButton("");
		green = new JButton("");
		blue = new JButton("");
		yellow = new JButton("");
		black = new JButton("");
		white = new JButton("");
		col1 = new JButton("");
		col2 = new JButton("");
		col3 = new JButton("");
		col4 = new JButton("");
		col5 = new JButton("");
		col6 = new JButton("");
		colors = new ArrayList<Color>();
		
		colors.add(Color.red);
		colors.add(Color.green);
		colors.add(Color.blue);
		colors.add(Color.yellow);
		colors.add(Color.black);
		colors.add(Color.white);
		
		red.setBounds(10, 5, 40, 40);
		red.setOpaque(true);
		red.setBackground(Color.red);
		red.setBorderPainted(false);
		red.addActionListener(this);
		
		green.setBounds(60, 5, 40, 40);
		green.setOpaque(true);
		green.setBackground(Color.green);
		green.setBorderPainted(false);
		green.addActionListener(this);
		
		blue.setBounds(110, 5, 40, 40);
		blue.setOpaque(true);
		blue.setBackground(Color.blue);
		blue.setBorderPainted(false);
		blue.addActionListener(this);
		
		yellow.setBounds(160, 5, 40, 40);
		yellow.setOpaque(true);
		yellow.setBackground(Color.yellow);
		yellow.setBorderPainted(false);
		yellow.addActionListener(this);
		
		black.setBounds(210, 5, 40, 40);
		black.setOpaque(true);
		black.setBackground(Color.black);
		black.setBorderPainted(false);
		black.addActionListener(this);
		
		white.setBounds(260, 5, 40, 40);
		white.setOpaque(true);
		white.setBackground(Color.white);
		white.setBorderPainted(false);
		white.addActionListener(this);
		
		col1.setBounds(10, 55, 40, 40);
		col1.setOpaque(true);
		col1.setBackground(new Color(80, 80, 80));
		col1.setBorderPainted(false);
		
		col2.setBounds(60, 55, 40, 40);
		col2.setOpaque(true);
		col2.setBackground(new Color(80, 80, 80));
		col2.setBorderPainted(false);
		
		col3.setBounds(110, 55, 40, 40);
		col3.setOpaque(true);
		col3.setBackground(new Color(80, 80, 80));
		col3.setBorderPainted(false);
		
		col4.setBounds(160, 55, 40, 40);
		col4.setOpaque(true);
		col4.setBackground(new Color(80, 80, 80));
		col4.setBorderPainted(false);
		
		col5.setBounds(210, 55, 40, 40);
		col5.setOpaque(true);
		col5.setBackground(new Color(80, 80, 80));
		col5.setBorderPainted(false);
		
		col6.setBounds(260, 55, 40, 40);
		col6.setOpaque(true);
		col6.setBackground(new Color(80, 80, 80));
		col6.setBorderPainted(false);
		
		add(red);
		add(green);
		add(blue);
		add(yellow);
		add(black);
		add(white);
		add(col1);
		add(col2);
		add(col3);
		add(col4);
		add(col5);
		add(col6);
		
	}

	public void setColor(Color c) {
		
		if(colors.indexOf(c) == -1) {
			
			switch (colors.size()) {
				case 6:
					col1.setBackground(c);
					col1.addActionListener(this);
					break;
					
				case 7:
					col2.setBackground(c);
					col2.addActionListener(this);
					break;
				
				case 8:
					col3.setBackground(c);
					col3.addActionListener(this);
					break;
				
				case 9:
					col4.setBackground(c);
					col4.addActionListener(this);
					break;
					
				case 10:
					col5.setBackground(c);
					col5.addActionListener(this);
					break;
					
				case 11:
					col6.setBackground(c);
					col6.addActionListener(this);
					break;
					
				
				case 12:
					colors.remove(col1.getBackground());
					col1.setBackground(col2.getBackground());
					col2.setBackground(col3.getBackground());
					col3.setBackground(col4.getBackground());
					col4.setBackground(col5.getBackground());
					col5.setBackground(col6.getBackground());
					col6.setBackground(c);
					break;
					
				default:
					break;
					
			}
			colors.add(c);
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton) e.getSource();
		currentColor = source.getBackground();
		ColorSliders.setColor(currentColor);
	}
}
