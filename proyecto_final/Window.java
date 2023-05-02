package proyecto_final;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JFrame implements MouseListener{
	
	private static final long serialVersionUID = 1L;
	public int width, height;
	private JPanel contentPane;
	private Canvas canvas;
	private ColorSliders rgb;
	private ColorButtons colors;
	private Archivo archivos;
	public Toolkit toolkit = Toolkit.getDefaultToolkit();
	public Dimension screenSize = toolkit.getScreenSize();
	
	public Window() {
		this.width = (int) (screenSize.width*0.9);
		this.height = (int) (screenSize.height*0.9);
		
		
		components();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // al cerrar la ventana se detiene el programa
		setSize(width, height);		
		//setBackground(Color.white);	        // tamaño de la ventana
		setLocationRelativeTo(null);			// centra la ventana
		setLayout(null);				// elimina plantillas
		setResizable(true);				// no permite modificar el tamaño de la ventana
		setVisible(true);				// muestra la ventana	
	}
	
			
	private void components()
	{
		contentPane = new JPanel();
		canvas = new Canvas();
		rgb = new ColorSliders();
		colors = new ColorButtons();
		archivos = new Archivo();
		
		contentPane.setLayout(null);
		rgb.setBackground(new Color(249, 249, 249));
		colors.setBackground(Color.gray);
		//contentPane.setBackground(Color.white);
		contentPane.setBounds(0,0,width,height);

		canvas.setBounds((int) (width*.01), (int) (height*.02), (int) (width*.6), (int) (height*.99));//---	
		canvas.addMouseListener(this);
		add(canvas);
		
		rgb.setBounds((int) (width*.65), (int) (height*.10), (int) (width*.4), (int) (height*.68));
		add(rgb);
		
		colors.setBounds((int) (width*.67), (int) (height*.8), (int) (width*.36), (int) (height*.5));
		add(colors);
		
		archivos.setBounds((int) (width*.63), (int) (height*.03), (int) (width*.5), (int) (height*.3));
		add(archivos);
		
		add(contentPane);
	}

	public void mouseClicked(MouseEvent e) {
		Color c = rgb.getColor();
		canvas.getGraphic().setColor(c);
		colors.setColor(c);
		
	}

	public void mousePressed(MouseEvent e) {
		Color c = rgb.getColor();
		canvas.getGraphic().setColor(c);
		colors.setColor(c);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
