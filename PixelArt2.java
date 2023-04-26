package aplly;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;

public class PixelArt2 extends JFrame implements ActionListener {
    protected int cellSize = 20;
    protected int gridWidth = 20;
    protected int gridHeight = 20;
    protected Color currentColor = Color.BLACK;
    protected Color[] colors = {Color.BLACK, Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.MAGENTA};
    protected JToggleButton[] colorButtons = new JToggleButton[colors.length];
    public BufferedImage gridImage = new BufferedImage(gridWidth * cellSize, gridHeight * cellSize, BufferedImage.TYPE_INT_RGB);
    public GridLabel gridLabel = new GridLabel(new ImageIcon(gridImage));
    protected JSlider redSlider = new JSlider(0, 255, 0);
    protected JSlider greenSlider = new JSlider(0, 255, 0);
    protected JSlider blueSlider = new JSlider(0, 255, 0);
    protected JLabel colorLabel = new JLabel();

    public PixelArt2() {
        setTitle("Pixel Art");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800,800);							// tamaño de la ventana
		setLocationRelativeTo(null);					// centra la ventana
		setLayout(new FlowLayout());								// elimina plantillas
		setResizable(true);							// no permite modificar el tamaño de la ventana
		setVisible(true);
        //setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());
        topPanel.setBackground(Color.gray);
        topPanel.setBounds(0,0,500,500);
        for (int i = 0; i < colors.length; i++) {
            colorButtons[i] = new JToggleButton();
            colorButtons[i].setBackground(colors[i]);
            colorButtons[i].setPreferredSize(new Dimension(cellSize * 2, cellSize * 2));
            colorButtons[i].addActionListener(this);
            topPanel.add(colorButtons[i]);
        }
        add(topPanel, BorderLayout.NORTH);
        gridLabel.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                drawPixel(e.getX(), e.getY());
            }
        });
        gridLabel.addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                drawPixel(e.getX(), e.getY());
            }
        });
        
        topPanel.add(gridLabel);
        add(topPanel);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());
        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileFilter(new FileNameExtensionFilter("PNG Images", "png"));
            if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try {
                    ImageIO.write(gridImage, "png", file);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        bottomPanel.add(saveButton);

        JButton loadButton = new JButton("Load");
        loadButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileFilter(new FileNameExtensionFilter("PNG Images", "png"));
            if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try {
                    BufferedImage loadedImage = ImageIO.read(file);
                    Graphics g = gridImage.getGraphics();
                    g.drawImage(loadedImage, 0, 0, null);
                    g.dispose();
                    gridLabel.repaint();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        bottomPanel.add(loadButton);
        ChangeListener sliderListener = new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                currentColor = new Color(redSlider.getValue(), greenSlider.getValue(), blueSlider.getValue());
                colorLabel.setBackground(currentColor);
                for (JToggleButton button : colorButtons) {
                    button.setSelected(false);
                }
            }
        };
        redSlider.addChangeListener(sliderListener);
        greenSlider.addChangeListener(sliderListener);
        blueSlider.addChangeListener(sliderListener);

        bottomPanel.add(new JLabel("R"));
        bottomPanel.add(redSlider);
        bottomPanel.add(new JLabel("G"));
        bottomPanel.add(greenSlider);
        bottomPanel.add(new JLabel("B"));
        bottomPanel.add(blueSlider);

        colorLabel.setOpaque(true);
        colorLabel.setBackground(currentColor);
        colorLabel.setPreferredSize(new Dimension(cellSize * 2, cellSize * 2));
        bottomPanel.add(colorLabel);

        add(bottomPanel, BorderLayout.SOUTH);

        pack();
    }

    protected void drawPixel(int x, int y) {
        x /= cellSize;
        y /= cellSize;
        if (x >= 0 && x < gridWidth && y >= 0 && y < gridHeight) {
            Graphics g = gridImage.getGraphics();
            g.setColor(currentColor);
            g.fillRect(x * cellSize, y * cellSize, cellSize, cellSize);
            g.dispose();
            gridLabel.repaint();
        }
    }

    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < colors.length; i++) {
            if (e.getSource() == colorButtons[i]) {
                currentColor = colors[i];
                colorButtons[i].setSelected(true);
                redSlider.setValue(currentColor.getRed());
                greenSlider.setValue(currentColor.getGreen());
                blueSlider.setValue(currentColor.getBlue());
            } else {
                colorButtons[i].setSelected(false);
            }
        }
    }

    class GridLabel extends JLabel {
        public GridLabel(Icon image) {
            super(image);
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.LIGHT_GRAY);
            for (int x = 0; x < gridWidth; x++) {
                g.drawLine(x * cellSize, 0, x * cellSize, gridHeight * cellSize);
            }
            for (int y = 0; y < gridHeight; y++) {
                g.drawLine(0, y * cellSize, gridWidth * cellSize, y * cellSize);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PixelArt2().setVisible(true));
    }
}