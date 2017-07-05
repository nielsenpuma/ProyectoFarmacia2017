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
import java.util.Date;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

import entidades.ECliente;
import entidades.EEmpleado;
import controlador.CCliente;
import controlador.CEmpleado;
import javax.swing.border.TitledBorder;
import com.toedter.calendar.JDateChooser;

public class FrmEmpleado extends JFrame {
	
	// Campos o atributos
		private CEmpleado ObjC = new CEmpleado();
		private ArrayList<EEmpleado> MiLista;

	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtPat;
	private JTextField txtMat;
	private JTextField txtCodCargo;
	private JTextField txtusuario;
	private JTextField txtpassword;
	private JTable table;
	private DefaultTableModel MiTabla;
	private JPanel panel_1;
	private JDateChooser dcNac;
	private JDateChooser dcIng;
	
	
	
	
	public void LimpiarCajas(){
		txtCodigo.setText("");
		txtNombre.setText("");
		txtPat.setText("");
		txtMat.setText("");
		dcNac.setDate(new Date());
		dcIng.setDate(new Date());
		txtusuario.setText("");
		txtpassword.setText("");
		txtCodCargo.setText("");
		txtCodigo.requestFocus();
	}

	
	
	
	// Cargar el JTable
		public void CargarJTable(){
			MiLista = new ArrayList<>();
			MiLista = ObjC.Listar();
			
			MiTabla = new DefaultTableModel();
			// Cargar los nombres de Columnas
			String Columnas[]={"codigo", "Nombre", "Apellido Paterno",
								"Apellido Materno", "Fec. Nacimiento",
								"Fec. Ingreso", "Usuario","Password","Codigo cargo"};
			for(String Obj:Columnas)
			{
				MiTabla.addColumn(Obj);
										}
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
		lblCodigoEmpleado.setBounds(20, 72, 108, 14);
		contentPane.add(lblCodigoEmpleado);
		
		JLabel lblNombre = new JLabel("Nombres :");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNombre.setBounds(20, 97, 108, 14);
		contentPane.add(lblNombre);
		
		JLabel lblApPaterno = new JLabel("Ap. Paterno :");
		lblApPaterno.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblApPaterno.setBounds(20, 122, 108, 14);
		contentPane.add(lblApPaterno);
		
		JLabel lblApMaterno = new JLabel("Ap. Materno :");
		lblApMaterno.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblApMaterno.setBounds(20, 147, 108, 14);
		contentPane.add(lblApMaterno);
		
		JLabel lblFecNacimiento = new JLabel("Fec. Nacimiento :");
		lblFecNacimiento.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFecNacimiento.setBounds(20, 172, 108, 14);
		contentPane.add(lblFecNacimiento);
		
		JLabel lblFecIngreso = new JLabel("Fec. Ingreso :");
		lblFecIngreso.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFecIngreso.setBounds(20, 197, 108, 14);
		contentPane.add(lblFecIngreso);
		
		JLabel lblUsuario = new JLabel("Usuario :");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUsuario.setBounds(405, 59, 84, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblPassword = new JLabel("Password : ");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPassword.setBounds(405, 84, 84, 14);
		contentPane.add(lblPassword);
		
		JLabel lblCodigoCargo = new JLabel("Codigo Cargo :");
		lblCodigoCargo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCodigoCargo.setBounds(20, 222, 108, 14);
		contentPane.add(lblCodigoCargo);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(138, 70, 195, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(138, 95, 195, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtPat = new JTextField();
		txtPat.setBounds(138, 120, 195, 20);
		contentPane.add(txtPat);
		txtPat.setColumns(10);
		
		txtMat = new JTextField();
		txtMat.setBounds(138, 145, 195, 20);
		contentPane.add(txtMat);
		txtMat.setColumns(10);
		
		txtCodCargo = new JTextField();
		txtCodCargo.setBounds(138, 220, 195, 20);
		contentPane.add(txtCodCargo);
		txtCodCargo.setColumns(10);
		
		txtusuario = new JTextField();
		txtusuario.setBounds(499, 57, 195, 20);
		contentPane.add(txtusuario);
		txtusuario.setColumns(10);
		
		txtpassword = new JTextField();
		txtpassword.setBounds(499, 82, 195, 20);
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
		panel.setBorder(new TitledBorder(null, "Lista Empleados", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 251, 934, 240);
		contentPane.add(panel);
		{
			panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(null, "Mantenimiento", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_1.setBounds(718, 30, 226, 233);
			contentPane.add(panel_1);
			panel_1.setLayout(null);
			
			JButton btnNuevo = new JButton("NUEVO");
			btnNuevo.setBounds(25, 50, 180, 23);
			panel_1.add(btnNuevo);
			
			JButton btnBuscar = new JButton("BUSCAR");
			btnBuscar.setBounds(25, 84, 180, 23);
			panel_1.add(btnBuscar);
			
			JButton btnInsertar = new JButton("INSERTAR");
			btnInsertar.setBounds(25, 118, 180, 23);
			panel_1.add(btnInsertar);
			
			JButton btnModificar = new JButton("MODIFICAR");
			btnModificar.setBounds(25, 152, 180, 23);
			panel_1.add(btnModificar);
			
			JButton btnEliminar = new JButton("ELIMINAR");
			btnEliminar.setBounds(25, 186, 180, 23);
			panel_1.add(btnEliminar);
		}
		{
			dcNac = new JDateChooser();
			dcNac.setDateFormatString("yyyy-MMM-dd");
			dcNac.setBounds(138, 172, 130, 20);
			contentPane.add(dcNac);
		}
		{
			dcIng = new JDateChooser();
			dcIng.setDateFormatString("yyyy-MMM-dd");
			dcIng.setBounds(138, 197, 130, 20);
			contentPane.add(dcIng);
		}
		
		
		//cargar inicialmente el formulario
		MiLista= new ArrayList<>();
		MiLista=ObjC.Listar();
		CargarJTable();
	}
}
