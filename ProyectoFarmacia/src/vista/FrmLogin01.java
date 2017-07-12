package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.CEmpleado;
import entidades.EEmpleado;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class FrmLogin01 extends JFrame implements ActionListener {
	
	private CEmpleado objE = new CEmpleado();
	private EEmpleado emp;

	private JPanel contentPane;
	private JLabel lblUsuario;
	private JLabel lblPassword;
	private JTextField txtUser;
	private JTextField txtPassword;
	private JButton btnIngresar;
	private JButton btnSalir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmLogin01 frame = new FrmLogin01();
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
	public FrmLogin01() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblUsuario = new JLabel("Usuario:");
			lblUsuario.setBounds(26, 44, 87, 16);
			contentPane.add(lblUsuario);
		}
		{
			lblPassword = new JLabel("Password:");
			lblPassword.setBounds(26, 110, 87, 16);
			contentPane.add(lblPassword);
		}
		{
			txtUser = new JTextField();
			txtUser.setBounds(150, 39, 130, 26);
			contentPane.add(txtUser);
			txtUser.setColumns(10);
		}
		{
			txtPassword = new JTextField();
			txtPassword.setBounds(150, 105, 130, 26);
			contentPane.add(txtPassword);
			txtPassword.setColumns(10);
		}
		{
			btnIngresar = new JButton("Ingresar");
			btnIngresar.addActionListener(this);
			btnIngresar.setBounds(56, 176, 117, 29);
			contentPane.add(btnIngresar);
		}
		{
			btnSalir = new JButton("Salir");
			btnSalir.addActionListener(this);
			btnSalir.setBounds(214, 176, 117, 29);
			contentPane.add(btnSalir);
		}
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSalir) {
			actionPerformedBtnSalir(e);
		}
		if (e.getSource() == btnIngresar) {
			actionPerformedBtnIngresar(e);
		}
	}
	protected void actionPerformedBtnIngresar(ActionEvent e) {
		emp = objE.Autentificar(txtUser.getText(), txtPassword.getText());
		if (emp!=null) {
			JOptionPane.showMessageDialog(this, "Bienvenido");
		}else{
			JOptionPane.showMessageDialog(this, "Usuario incorrecto");
		}
	}
	protected void actionPerformedBtnSalir(ActionEvent e) {
		System.exit(0);
	}
}
