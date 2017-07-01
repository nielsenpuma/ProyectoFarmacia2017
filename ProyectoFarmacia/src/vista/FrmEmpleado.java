package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

import entidades.ECliente;
import entidades.EEmpleado;
import controlador.CCliente;
import controlador.CEmpleado;

public class FrmEmpleado extends JFrame {
	
	// Campos o atributos
		private CEmpleado ObjC = new CEmpleado();
		private ArrayList<EEmpleado> MiLista;

	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtPat;
	private JTextField txtMat;
	private JTextField txtNaci;
	private JTextField txtFecIng;
	private JTextField txtCodCargo;
	private JTextField txtusuario;
	private JTextField txtpassword;
	private JTable table;
	private DefaultTableModel MiTabla;
	
	
	
	public void Inicializar(){
		MiLista = new ArrayList<>();
		MiLista = ObjC.Listar();
	}
	
	public void LimpiarCajas(){
		txtCodigo.setText("");
		txtNombre.setText("");
		txtPat.setText("");
		txtMat.setText("");
		txtNaci.setText("");
		txtFecIng.setText("");
		txtusuario.setText("");
		txtpassword.setText("");
		txtCodCargo.setText("");
		txtCodigo.requestFocus();
	}
	
	
	
	// Cargar el JTable
	public void CargarJTable(){
		MiTabla = new DefaultTableModel();
		// Cargar los nombres de Columnas
		String Columnas[]={"codigo", "Nombre", "Apellido Paterno", "Apellido Materno", "Fec. Nacimiento", "Fec. Ingreso,"
				+ "Usuario"+"Password"+"Codigo cargo"};
		for(String Obj:Columnas)MiTabla.addColumn(Obj);
		// Cargar las filas
		Object Filas[][] = new Object[MiLista.size()][9];
		for (int i = 0; i < MiLista.size(); i++) {
			Filas[i][0] = MiLista.get(i).getCod_emp();
			Filas[i][1] = MiLista.get(i).getNom_emp();
			Filas[i][2] = MiLista.get(i).getApat_emp();
			Filas[i][3] = MiLista.get(i).getAmat_emp();
			Filas[i][4] = MiLista.get(i).getFec_nac_emp();
			Filas[i][5] = MiLista.get(i).getFec_ing_emp();
			Filas[i][6] = MiLista.get(i).getUser_emp();
			Filas[i][7] = MiLista.get(i).getPass_emp();
			Filas[i][8] = MiLista.get(i).getCod_cargo();
			
			MiTabla.addRow(Filas[i]);
		}
		// Cargar en el JTabla
		table.setModel(MiTabla);
	}
	
	
	
	
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmEmpleado frame = new FrmEmpleado();
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
	public FrmEmpleado() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1006, 554);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCodigoEmpleado = new JLabel("Codigo Empleado :");
		lblCodigoEmpleado.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCodigoEmpleado.setBounds(10, 59, 108, 14);
		contentPane.add(lblCodigoEmpleado);
		
		JLabel lblNombre = new JLabel("Nombres :");
		lblNombre.setBounds(10, 84, 108, 14);
		contentPane.add(lblNombre);
		
		JLabel lblApPaterno = new JLabel("Ap. Paterno :");
		lblApPaterno.setBounds(10, 109, 108, 14);
		contentPane.add(lblApPaterno);
		
		JLabel lblApMaterno = new JLabel("Ap. Materno :");
		lblApMaterno.setBounds(10, 137, 108, 14);
		contentPane.add(lblApMaterno);
		
		JLabel lblFecNacimiento = new JLabel("Fec. Nacimiento :");
		lblFecNacimiento.setBounds(10, 162, 108, 14);
		contentPane.add(lblFecNacimiento);
		
		JLabel lblFecIngreso = new JLabel("Fec. Ingreso :");
		lblFecIngreso.setBounds(10, 187, 108, 14);
		contentPane.add(lblFecIngreso);
		
		JLabel lblUsuario = new JLabel("Usuario :");
		lblUsuario.setBounds(348, 60, 84, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblPassword = new JLabel("Password : ");
		lblPassword.setBounds(348, 84, 84, 14);
		contentPane.add(lblPassword);
		
		JLabel lblCodigoCargo = new JLabel("Codigo Cargo :");
		lblCodigoCargo.setBounds(10, 223, 108, 14);
		contentPane.add(lblCodigoCargo);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(143, 53, 98, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(143, 81, 195, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtPat = new JTextField();
		txtPat.setBounds(143, 106, 98, 20);
		contentPane.add(txtPat);
		txtPat.setColumns(10);
		
		txtMat = new JTextField();
		txtMat.setBounds(143, 134, 98, 20);
		contentPane.add(txtMat);
		txtMat.setColumns(10);
		
		txtNaci = new JTextField();
		txtNaci.setBounds(143, 159, 98, 20);
		contentPane.add(txtNaci);
		txtNaci.setColumns(10);
		
		txtFecIng = new JTextField();
		txtFecIng.setBounds(143, 184, 98, 20);
		contentPane.add(txtFecIng);
		txtFecIng.setColumns(10);
		
		txtCodCargo = new JTextField();
		txtCodCargo.setBounds(143, 220, 98, 20);
		contentPane.add(txtCodCargo);
		txtCodCargo.setColumns(10);
		
		txtusuario = new JTextField();
		txtusuario.setBounds(430, 57, 86, 20);
		contentPane.add(txtusuario);
		txtusuario.setColumns(10);
		
		txtpassword = new JTextField();
		txtpassword.setBounds(430, 81, 86, 20);
		contentPane.add(txtpassword);
		txtpassword.setColumns(10);
		
		JLabel lblEmpleados = new JLabel("EMPLEADOS");
		lblEmpleados.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEmpleados.setBounds(422, 11, 108, 14);
		contentPane.add(lblEmpleados);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(43, 287, 873, 191);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setBounds(30, 274, 914, 217);
		contentPane.add(panel);
		
		JLabel lblListarEmpleados = new JLabel("Listar Empleados");
		lblListarEmpleados.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblListarEmpleados.setBounds(20, 248, 128, 14);
		contentPane.add(lblListarEmpleados);
		
		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.setBounds(589, 128, 108, 23);
		contentPane.add(btnBuscar);
		
		JButton btnInsertar = new JButton("INSERTAR");
		btnInsertar.setBounds(589, 153, 108, 23);
		contentPane.add(btnInsertar);
		
		JButton btnModificar = new JButton("MODIFICAR");
		btnModificar.setBounds(589, 183, 108, 23);
		contentPane.add(btnModificar);
		
		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setBounds(589, 214, 108, 23);
		contentPane.add(btnEliminar);
		
		JButton btnNuevo = new JButton("NUEVO");
		btnNuevo.setBounds(589, 75, 108, 23);
		contentPane.add(btnNuevo);
		
		
		// Llamar a Inicializar y VerRegistro
				Inicializar();
				CargarJTable();
	}
}
