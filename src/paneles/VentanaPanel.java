package paneles;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class VentanaPanel extends JFrame {

	private JPanel contentPane;
	private JButton btnP1 = new JButton("Panel 1");
	private JButton btnP2 = new JButton("Panel 2");
	JButton panelBtn=new JButton("HOLA");
	private JPanel panel = new JPanel();
	private JPanel panel2 = new JPanel();
	private JTextPane textPane = new JTextPane();
	private final JLabel lblP2 = new JLabel("Pulsame!");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPanel frame = new VentanaPanel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPanel() {
		setTitle("Ventana Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		btnP1.setBounds(10, 42, 89, 23);
		contentPane.add(btnP1);
		btnP1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				pasarPanel1(e);
				
			}
			
		});
		
		btnP2.setBounds(134, 42, 89, 23);
		contentPane.add(btnP2);
		btnP2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				pasarPanel2(e);
				
			}
			
		});
		panel.setBackground(Color.CYAN);
		
		
		panel.setBounds(0, 108, 434, 153);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		textPane.setBounds(36, 11, 364, 117);
		textPane.setText("Hola gente, esto es un texto");
		panel.add(textPane);
		
		panel2.setBounds(0, 108, 434, 153);
		contentPane.add(panel2);
		panel2.setLayout(null);
		panel2.setBackground(Color.orange);
		panel2.add(panelBtn);
		panelBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(rootPane, "Esto es una ventana que te saluda :D");
				
			}
			
		});
		panelBtn.setBounds(50, 50, 150, 50);
		lblP2.setBounds(0, 0, 135, 14);
		
		panel2.add(lblP2);
	}
	
	public void pasarPanel1(ActionEvent e) {
		if(e.getSource()==btnP1) {
			panel2.setVisible(false);
			panel.setVisible(true);
		}
	}
	public void pasarPanel2(ActionEvent e) {
		if(e.getSource()==btnP2) {
			panel.setVisible(false);
			panel2.setVisible(true);
			
		}
	}
}
