package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import controlador.CCliente;
import entidades.ECliente;

import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ScrollPaneConstants;
import com.toedter.calendar.JDateChooser;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Date;
import java.awt.Component;

//Campos o Atributos

public class FrmCliente extends JFrame {
	// Campos o atributos
	private CCliente ObjC = new CCliente();
	private ArrayList<ECliente> MiLista;
	
	private JPanel contentPane;
	private JTextField txtCodCliente;
	private JTextField txtNomCliente;
	private JTextField txtApPaternoCliente;
	private JTextField txtApMaternoCliente;
	private JTextField txtTelfCliente;
	private JTable tablaCliente;
	private DefaultTableModel MiTabla;
	
	public void Inicializar(){
		MiLista = new ArrayList<>();
		MiLista = ObjC.Listar();
	}
	
	public void LimpiarCajas(){
		txtCodCliente.setText("");
		txtNomCliente.setText("");
		txtApPaternoCliente.setText("");
		txtApMaternoCliente.setText("");
	
		txtTelfCliente.setText("");
		txtCodCliente.requestFocus();
	}
	
		// Cargar el JTable
		public void CargarJTable(){
			MiTabla = new DefaultTableModel();
			// Cargar los nombres de Columnas
			String Columnas[]={"Código", "Nombre", "Apellido Paterno", "Apellido Materno", "Fec. Registro", "Teléfono"};
			for(String Obj:Columnas){
				MiTabla.addColumn(Obj);
			}
			// Cargar las filas
			Object Filas[][] = new Object[MiLista.size()][6];
			for (int i = 0; i < MiLista.size(); i++) {
				Filas[i][0] = MiLista.get(i).getCod_cli();
				Filas[i][1] = MiLista.get(i).getNom_cli();
				Filas[i][2] = MiLista.get(i).getApat_cli();
				Filas[i][3] = MiLista.get(i).getAmaT_cli();
				Filas[i][4] = MiLista.get(i).getFec_reg_cli();
				Filas[i][5] = MiLista.get(i).getTlf_cliente();
				MiTabla.addRow(Filas[i]);
				
			}
			// Cargar en el JTabla
			tablaCliente.setModel(MiTabla);
			
		}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCliente frame = new FrmCliente();
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
	public FrmCliente() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				 int confirmed = JOptionPane.showConfirmDialog(null, 
					        "¿Seguro que desea salir?", "Advertencia",
					        JOptionPane.YES_NO_OPTION);

					    if (confirmed == JOptionPane.YES_OPTION) {
					      dispose();
					    }
			}
		});
		setType(Type.UTILITY);
		setTitle("Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 546, 515);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCodCliente = new JLabel("Cod. Cliente:");
		lblCodCliente.setBounds(10, 60, 75, 14);
		contentPane.add(lblCodCliente);
		
		JLabel lblNombres = new JLabel("Nombres:");
		lblNombres.setBounds(10, 90, 75, 14);
		contentPane.add(lblNombres);
		
		JLabel lblApPaterno = new JLabel("Ap. Paterno:");
		lblApPaterno.setBounds(10, 120, 75, 14);
		contentPane.add(lblApPaterno);
		
		JLabel lblApMaterno = new JLabel("Ap. Materno:");
		lblApMaterno.setBounds(10, 150, 75, 14);
		contentPane.add(lblApMaterno);
		
		JLabel lblFechaReg = new JLabel("Fecha Reg:");
		lblFechaReg.setBounds(10, 180, 75, 14);
		contentPane.add(lblFechaReg);
		
		JLabel lblTelfono = new JLabel("Teléfono");
		lblTelfono.setBounds(10, 210, 75, 14);
		contentPane.add(lblTelfono);
		
		txtCodCliente = new JTextField();
		txtCodCliente.setBounds(95, 60, 100, 20);
		contentPane.add(txtCodCliente);
		txtCodCliente.setColumns(10);
		
		txtNomCliente = new JTextField();
		txtNomCliente.setBounds(95, 90, 200, 20);
		contentPane.add(txtNomCliente);
		txtNomCliente.setColumns(10);
		
		txtApPaternoCliente = new JTextField();
		txtApPaternoCliente.setBounds(95, 120, 200, 20);
		contentPane.add(txtApPaternoCliente);
		txtApPaternoCliente.setColumns(10);
		
		txtApMaternoCliente = new JTextField();
		txtApMaternoCliente.setBounds(95, 150, 200, 20);
		contentPane.add(txtApMaternoCliente);
		txtApMaternoCliente.setColumns(10);
		
		txtTelfCliente = new JTextField();
		txtTelfCliente.setBounds(95, 210, 100, 20);
		contentPane.add(txtTelfCliente);
		txtTelfCliente.setColumns(10);
		JDateChooser txtFechaReg = new JDateChooser();
		txtFechaReg.getCalendarButton().setHorizontalAlignment(SwingConstants.TRAILING);
		txtFechaReg.setDateFormatString("yyyy-MM-dd");
		
		tablaCliente = new JTable();
		tablaCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {			
				int fila = tablaCliente.getSelectedRow();
				txtCodCliente.setText(MiLista.get(fila).getCod_cli());
				txtNomCliente.setText(MiLista.get(fila).getNom_cli());
				txtApPaternoCliente.setText(MiLista.get(fila).getApat_cli());
				txtApMaternoCliente.setText(MiLista.get(fila).getAmaT_cli());
				txtFechaReg.setDateFormatString(MiLista.get(fila).getFec_reg_cli());
				txtTelfCliente.setText(MiLista.get(fila).getTlf_cliente());		
			}
		});
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ECliente ObjP = new ECliente(
						txtCodCliente.getText(),
						txtNomCliente.getText(),
						txtApPaternoCliente.getText(),
						txtApMaternoCliente.getText(),
						txtFechaReg.getDateFormatString(),
						txtTelfCliente.getText());
				ObjC.InsertarCliente(ObjP);
				JOptionPane.showMessageDialog(null,"CLIENTE AÑADIDO");
				CargarJTable();
				LimpiarCajas();
			}
		});
		btnNuevo.setBounds(370, 60, 116, 23);
		contentPane.add(btnNuevo);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ECliente ObjP = new ECliente(
						txtCodCliente.getText(),
						txtNomCliente.getText(),
						txtApPaternoCliente.getText(),
						txtApMaternoCliente.getText(),
						txtFechaReg.getDateFormatString(),
						txtTelfCliente.getText());
				ObjC.ModificarCliente(ObjP);
				JOptionPane.showMessageDialog(null,"CLIENTE MODIFICADO");
				
				CargarJTable();
				LimpiarCajas();		
			}
		});
		btnEditar.setBounds(370, 120, 116, 23);
		contentPane.add(btnEditar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ObjC.BuscarCliente(txtCodCliente.getText());
				CargarJTable();			
				LimpiarCajas();	
			}
		});
		btnBuscar.setBounds(370, 90, 116, 23);
		contentPane.add(btnBuscar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ObjC.EliminarCliente(txtCodCliente.getText());
				JOptionPane.showMessageDialog(null,"CLIENTE ELIMINADO");
				CargarJTable();			
				LimpiarCajas();	
			}
		});
		btnEliminar.setBounds(370, 150, 116, 23);
		contentPane.add(btnEliminar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(370, 180, 116, 23);
		contentPane.add(btnCancelar);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(334, 42, 186, 217);
		contentPane.add(panel);
		
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCliente.setForeground(new Color(0, 0, 0));
		lblCliente.setBounds(237, 11, 58, 14);
		contentPane.add(lblCliente);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(20, 298, 490, 152);
		contentPane.add(scrollPane);
	
		scrollPane.setViewportView(tablaCliente);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		panel_1.setBounds(10, 288, 510, 177);
		contentPane.add(panel_1);
		
		JLabel lblListarClientes = new JLabel("Listar clientes:");
		lblListarClientes.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblListarClientes.setBackground(SystemColor.menu);
		lblListarClientes.setBounds(20, 273, 89, 14);
		contentPane.add(lblListarClientes);
		
		JLabel lblMantenimiento = new JLabel("Mantenimiento");
		lblMantenimiento.setBounds(384, 25, 86, 14);
		contentPane.add(lblMantenimiento);
		lblMantenimiento.setBackground(SystemColor.control);
		lblMantenimiento.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		txtFechaReg.setBounds(95, 180, 121, 20);
		contentPane.add(txtFechaReg);
		
		JLabel lblCantidadDeClientes = new JLabel("Cantidad de clientes:");
		lblCantidadDeClientes.setBounds(334, 273, 116, 14);
		contentPane.add(lblCantidadDeClientes);
			
		// Llamar a Inicializar y VerRegistro	 
		Inicializar();
		CargarJTable();
		
	}
}
