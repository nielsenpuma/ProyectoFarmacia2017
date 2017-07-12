package vista;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.ScrollPaneConstants;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Window.Type;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;
import java.awt.SystemColor;
import java.util.ArrayList;
import java.text.DateFormat;
import com.toedter.calendar.JDateChooser;
import controlador.CCliente;
import entidades.ECliente;
import javax.swing.JProgressBar;

public class FrmCliente extends JFrame {	
	// Campos o atributos
	private CCliente ObjC = new CCliente();
	private JDateChooser JDCFechaReg = new JDateChooser();
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
		JDCFechaReg.setCalendar(null);
		txtTelfCliente.setText("");
		txtCodCliente.requestFocus();
	}	
		// Método para cargar el JTable
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
						 "¿Seguro que desea salir?", 
						 "Advertencia", JOptionPane.YES_NO_OPTION);     
					    if (confirmed == JOptionPane.YES_OPTION) {
					      dispose();
					    }
			}
		});
		
		setType(Type.UTILITY);
		setTitle("Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 666, 532);
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
		
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCliente.setBounds(10, 11, 75, 14);
		contentPane.add(lblCliente);
		
		JLabel lblListarClientes = new JLabel("Listar clientes:");
		lblListarClientes.setBounds(10, 265, 89, 14);
		contentPane.add(lblListarClientes);
		
		JLabel lblMantenimiento = new JLabel("Mantenimiento");
		lblMantenimiento.setBounds(491, 25, 86, 14);
		contentPane.add(lblMantenimiento);
		
		JLabel lblCantidadDeClientes = new JLabel("Cantidad de clientes:");
		lblCantidadDeClientes.setBounds(10, 470, 150, 14);
		contentPane.add(lblCantidadDeClientes);
		
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
		
		JDCFechaReg.setDateFormatString("yyyy/MM/dd");
		JDCFechaReg.setBounds(95, 179, 122, 20);
		contentPane.add(JDCFechaReg);
		
		tablaCliente = new JTable();
		tablaCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {			
				int fila = tablaCliente.getSelectedRow();
				txtCodCliente.setText(MiLista.get(fila).getCod_cli());
				txtNomCliente.setText(MiLista.get(fila).getNom_cli());
				txtApPaternoCliente.setText(MiLista.get(fila).getApat_cli());
				txtApMaternoCliente.setText(MiLista.get(fila).getAmaT_cli());
				JDCFechaReg.setDate(MiLista.get(fila).getFec_reg_cli());
				txtTelfCliente.setText(MiLista.get(fila).getTlf_cliente());		
			}
		});
		
		JButton btnNuevo = new JButton("Insertar");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ECliente ObjP = new ECliente(
						txtCodCliente.getText(),
						txtNomCliente.getText(),
						txtApPaternoCliente.getText(),
						txtApMaternoCliente.getText(),
						JDCFechaReg.getDate(),
						txtTelfCliente.getText());
					ObjC.InsertarCliente(ObjP);
					Inicializar();
					CargarJTable();
					LimpiarCajas();
					JOptionPane.showMessageDialog(null,"El cliente se añadió con éxito");
			}
		});
		btnNuevo.setBounds(458, 60, 150, 23);
		contentPane.add(btnNuevo);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ECliente ObjP = new ECliente(
						txtCodCliente.getText(),
						txtNomCliente.getText(),
						txtApPaternoCliente.getText(),
						txtApMaternoCliente.getText(),
						JDCFechaReg.getDate(),
						txtTelfCliente.getText());
				ObjC.ModificarCliente(ObjP);
				LimpiarCajas();
				Inicializar();
				CargarJTable();	
				JOptionPane.showMessageDialog(null,"Cliente moodificado");
			}
		});
		btnEditar.setBounds(458, 120, 150, 23);
		contentPane.add(btnEditar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ObjC.BuscarCliente(txtCodCliente.getText());
				Inicializar();
				CargarJTable();			
				LimpiarCajas();	
			}
		});
		btnBuscar.setBounds(458, 90, 150, 23);
		contentPane.add(btnBuscar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ObjC.EliminarCliente(txtCodCliente.getText());
				Inicializar();
				CargarJTable();			
				LimpiarCajas();
				JOptionPane.showMessageDialog(null,"Cliente eliminado");
			}
		});
		btnEliminar.setBounds(458, 150, 150, 23);
		contentPane.add(btnEliminar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnCancelar.setBounds(458, 180, 150, 23);
		contentPane.add(btnCancelar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(20, 298, 608, 152);
		scrollPane.setViewportView(tablaCliente);
		contentPane.add(scrollPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 288, 630, 177);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(419, 42, 221, 217);
		contentPane.add(panel_2);
		
		// Llamar a Inicializar y VerRegistro	 
		Inicializar();
		CargarJTable();
		
	}
}

