import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class UF2ACT3Grafica extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UF2ACT3Grafica frame = new UF2ACT3Grafica();
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
	public UF2ACT3Grafica() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		setBounds(100, 100, 280, 240);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		UF2ACT3 iniciarSesio = new UF2ACT3();
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		
		JLabel lblUsuari = new JLabel("Usuari:");
		panel_2.add(lblUsuari);
		
		textField = new JTextField();
		panel_2.add(textField);
		textField.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		panel.add(panel_3);
		
		JLabel lblContrsenya = new JLabel("Contrsenya:");
		panel_3.add(lblContrsenya);
		
		textField_1 = new JTextField();
		panel_3.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		
		JRadioButton rdbtnPreparedstatement = new JRadioButton("PreparedStatement");
		panel_1.add(rdbtnPreparedstatement);
		
		// Creem un listener del boto
		JButton btnIniciarSessio = new JButton("Iniciar Sessio");
		btnIniciarSessio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				// Si el radio button esta seleccionat cridem al metode PreparedStatement
				if (rdbtnPreparedstatement.isSelected()){
					
					UF2ACT3.PreparedStatement(textField.getText(),textField_1.getText());
					
				// Sino esta seleccionat cridem al metode Statement
				} else {
					
					UF2ACT3.Statement(textField.getText(),textField_1.getText());
				}
			}
		});
		panel_1.add(btnIniciarSessio);
	}

}
