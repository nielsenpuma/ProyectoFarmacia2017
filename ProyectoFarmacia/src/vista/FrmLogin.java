package vista;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import org.edisoncor.gui.panel.PanelImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import jpass.JRPasswordField;
import app.bolivia.swing.JCTextField;
import controlador.CEmpleado;
import entidades.EEmpleado;
import principal.MaterialButtomRectangle;
import principal.MaterialButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;

public class FrmLogin extends JFrame implements ActionListener {
	private CEmpleado objE = new CEmpleado();
	public static EEmpleado emp;

	private JPanel contentPane;
	private JPanel panel;
	private PanelImage panelImage;
	private PanelImage panelImage_1;
	private JLabel lblUsuario;
	private PanelImage panelImage_2;
	private PanelImage panelImage_3;
	private PanelImage panelImage_4;
	private JRPasswordField txtPassword;
	private JCTextField txtUser;
	private MaterialButtomRectangle mtrlbtmrctnglAcceder;
	private MaterialButton mtrlbtnX;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmLogin frame = new FrmLogin();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmLogin() {
		setUndecorated(true);		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 539, 487);
		contentPane = new JPanel();
		contentPane.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(51, 153, 204)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			panel = new JPanel();
			panel.setBounds(10, 11, 514, 457);
			contentPane.add(panel);
			panel.setLayout(null);
			{
				panelImage = new PanelImage();
				panelImage.setIcon(new ImageIcon(FrmLogin.class.getResource("/img/img1.png")));
				panelImage.setBounds(171, 11, 170, 170);
				panel.add(panelImage);
			}
			{
				panelImage_1 = new PanelImage();
				panelImage_1.setIcon(new ImageIcon(FrmLogin.class.getResource("/img/campos.png")));
				panelImage_1.setBounds(49, 243, 415, 60);
				panel.add(panelImage_1);
				panelImage_1.setLayout(null);
				{
					panelImage_2 = new PanelImage();
					panelImage_2.setBounds(10, 11, 33, 40);
					panelImage_1.add(panelImage_2);
					panelImage_2.setIcon(new ImageIcon(FrmLogin.class.getResource("/img/icono1.png")));
				}
				{
					txtUser = new JCTextField();
					txtUser.setFont(new Font("Tahoma", Font.BOLD, 16));
					txtUser.setPlaceholder("Usuario");
					txtUser.setBounds(60, 11, 345, 40);
					txtUser.setBorder(null);					
					panelImage_1.add(txtUser);
				}
			}
			{
				lblUsuario = new JLabel("ACCESO AL SISTEMA \"SYSFARMA\"");
				lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
				lblUsuario.setForeground(Color.LIGHT_GRAY);
				lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 20));
				lblUsuario.setBounds(47, 192, 417, 40);
				panel.add(lblUsuario);
			}
			{
				panelImage_3 = new PanelImage();
				panelImage_3.setIcon(new ImageIcon(FrmLogin.class.getResource("/img/campos.png")));
				panelImage_3.setLayout(null);
				panelImage_3.setBounds(49, 314, 415, 60);
				panel.add(panelImage_3);
				{
					panelImage_4 = new PanelImage();
					panelImage_4.setIcon(new ImageIcon(FrmLogin.class.getResource("/img/password1.png")));
					panelImage_4.setBounds(10, 11, 40, 40);
					panelImage_3.add(panelImage_4);
				}
				{
					txtPassword = new JRPasswordField();
					txtPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
					txtPassword.setPlaceholder("Contrase\u00F1a");
					txtPassword.setBounds(60, 11, 345, 40);
					txtPassword.setBorder(null);
					panelImage_3.add(txtPassword);
				}
			}
			{
				mtrlbtmrctnglAcceder = new MaterialButtomRectangle();
				mtrlbtmrctnglAcceder.addActionListener(this);
				mtrlbtmrctnglAcceder.setFont(new Font("Tahoma", Font.BOLD, 18));
				mtrlbtmrctnglAcceder.setForeground(Color.WHITE);
				mtrlbtmrctnglAcceder.setBackground(new Color(0, 153, 204));
				mtrlbtmrctnglAcceder.setText("Ingresar");
				mtrlbtmrctnglAcceder.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
				mtrlbtmrctnglAcceder.setBounds(49, 385, 415, 60);
				panel.add(mtrlbtmrctnglAcceder);
			}
			{
				mtrlbtnX = new MaterialButton();
				mtrlbtnX.addActionListener(this);
				mtrlbtnX.setForeground(new Color(255, 255, 255));
				mtrlbtnX.setBackground(new Color(0, 153, 204));
				mtrlbtnX.setFont(new Font("Arial Black", Font.BOLD, 20));
				mtrlbtnX.setText("X");
				mtrlbtnX.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
				mtrlbtnX.setBounds(454, 0, 60, 60);
				panel.add(mtrlbtnX);
			}
		}
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == mtrlbtmrctnglAcceder) {
			actionPerformedMtrlbtmrctnglAcceder(arg0);
		}
		if (arg0.getSource() == mtrlbtnX) {
			actionPerformedMtrlbtnX(arg0);
		}
	}
	protected void actionPerformedMtrlbtnX(ActionEvent arg0) {
		System.exit(0);
	}
	protected void actionPerformedMtrlbtmrctnglAcceder(ActionEvent arg0) {
		emp = objE.Autentificar(txtUser.getText(), txtPassword.getText());
		if (emp!=null) {
			JOptionPane.showMessageDialog(this, "Bienvenido");
			FrmPrincipalMD frm = new FrmPrincipalMD();
			frm.setVisible(true);
			this.dispose();
			
		}else{
			JOptionPane.showMessageDialog(this, "Usuario incorrecto");
		}
	}
}
