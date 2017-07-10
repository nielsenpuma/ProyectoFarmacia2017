package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.jdesktop.swingx.rollover.TableRolloverProducer;

import controlador.CProveedor;
import entidades.EProveedor;

import javax.swing.JButton;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class FrmProveedor extends JFrame implements MouseListener {

	// Campos o Atributos
	private CProveedor ObjC = new CProveedor();
	private ArrayList<EProveedor> MiLista;

	private DefaultTableModel MiTabla;

	private DefaultComboBoxModel<EProveedor> comboPrv;

	private JPanel contentPane;
	private JLabel lblProveedor;
	private JLabel lblCodProv;
	private JLabel lblRazSocial;
	private JLabel lblApPaterno;
	private JLabel lblApMaterno;
	private JTextField txtCodPrv;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JPanel panel;
	private JButton btnNuevo;
	private JButton btnEditar;
	private JButton btnGuardar;
	private JButton btnEliminar;
	private JButton btnCancelar;
	private JButton btnSalir;
	private JPanel panel_1;
	private JComboBox cmbPrv;
	private JTable tablaProveedor;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmProveedor frame = new FrmProveedor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Cargar JTable
	public void CargarJTable() {
		MiTabla = new DefaultTableModel();
		String columnas[] = { "Cod.", "Raz. Social", "Dirección", "Teléfono" };

		for (String obj : columnas) {
			MiTabla.addColumn(obj);
		}

		Object filas[][] = new Object[MiLista.size()][4];

		for (int i = 0; i < MiLista.size(); i++) {
			filas[i][0] = MiLista.get(i).getCod_prv();
			filas[i][1] = MiLista.get(i).getRaz_soc_prv();
			filas[i][2] = MiLista.get(i).getDir_prv();
			filas[i][3] = MiLista.get(i).getTlf();

			MiTabla.addRow(filas[i]);
		}
		tablaProveedor.setModel(MiTabla);
	}

	// Llenar JCombo con la lista
	void llenarCombo() {
		cmbPrv.removeAllItems();
		comboPrv = new DefaultComboBoxModel<>();

		cmbPrv.setModel(comboPrv);

		MiLista = ObjC.Listar();

		for (EProveedor eProveedor : MiLista) {
			comboPrv.addElement(eProveedor);
		}
	}

	/**
	 * Create the frame.
	 */
	public FrmProveedor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 564, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblProveedor = new JLabel("Proveedor");
			lblProveedor.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblProveedor.setBounds(237, 11, 83, 14);
			contentPane.add(lblProveedor);
		}
		{
			lblCodProv = new JLabel("Cod. Prov.:");
			lblCodProv.setBounds(10, 42, 83, 14);
			contentPane.add(lblCodProv);
		}
		{
			lblRazSocial = new JLabel("Raz. Social:");
			lblRazSocial.setBounds(10, 67, 83, 14);
			contentPane.add(lblRazSocial);
		}
		{
			lblApPaterno = new JLabel("Direcci\u00F3n:");
			lblApPaterno.setBounds(10, 92, 83, 14);
			contentPane.add(lblApPaterno);
		}
		{
			lblApMaterno = new JLabel("Tel\u00E9fono");
			lblApMaterno.setBounds(10, 117, 83, 14);
			contentPane.add(lblApMaterno);
		}
		{
			txtCodPrv = new JTextField();
			txtCodPrv.setBounds(95, 39, 86, 20);
			contentPane.add(txtCodPrv);
			txtCodPrv.setColumns(10);
		}
		{
			txtDireccion = new JTextField();
			txtDireccion.setBounds(95, 92, 173, 20);
			contentPane.add(txtDireccion);
			txtDireccion.setColumns(10);
		}
		{
			txtTelefono = new JTextField();
			txtTelefono.setBounds(95, 117, 173, 20);
			contentPane.add(txtTelefono);
			txtTelefono.setColumns(10);
		}
		{
			panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Matenimiento", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(340, 42, 198, 219);
			contentPane.add(panel);
			panel.setLayout(null);
			{
				btnNuevo = new JButton("Nuevo");
				btnNuevo.setBounds(21, 22, 89, 23);
				panel.add(btnNuevo);
			}
			{
				btnEditar = new JButton("Editar");
				btnEditar.setBounds(21, 56, 89, 23);
				panel.add(btnEditar);
			}
			{
				btnGuardar = new JButton("Guardar");
				btnGuardar.setBounds(21, 89, 89, 23);
				panel.add(btnGuardar);
			}
			{
				btnEliminar = new JButton("Eliminar");
				btnEliminar.setBounds(21, 118, 89, 23);
				panel.add(btnEliminar);
			}
			{
				btnCancelar = new JButton("Cancelar");
				btnCancelar.setBounds(21, 152, 89, 23);
				panel.add(btnCancelar);
			}
			{
				btnSalir = new JButton("Salir");
				btnSalir.setBounds(21, 186, 89, 23);
				panel.add(btnSalir);
			}
		}
		{
			panel_1 = new JPanel();
			panel_1.setBorder(
					new TitledBorder(null, "Lista Proveedores", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_1.setBounds(10, 266, 528, 168);
			contentPane.add(panel_1);
			panel_1.setLayout(null);
			{
				scrollPane = new JScrollPane();
				scrollPane.setBounds(18, 28, 484, 122);
				panel_1.add(scrollPane);
				{
					tablaProveedor = new JTable();
					tablaProveedor.addMouseListener(this);
					scrollPane.setViewportView(tablaProveedor);
				}
			}
		}
		{
			cmbPrv = new JComboBox();
			cmbPrv.setModel(
					new DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" }));
			cmbPrv.setBounds(95, 62, 210, 27);
			AutoCompleteDecorator.decorate(this.cmbPrv);
			contentPane.add(cmbPrv);
		}

		// cargando al inicio los datos en la tabla
		MiLista = new ArrayList<>();
		MiLista = ObjC.Listar();
		CargarJTable();

		llenarCombo();
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tablaProveedor) {
			mouseClickedTablaProveedor(e);
		}
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void mouseClickedTablaProveedor(MouseEvent e) {
		int filaSelect = tablaProveedor.getSelectedRow();
		
		if(filaSelect != -1){
			txtCodPrv.setText(tablaProveedor.getValueAt(filaSelect, 0).toString());
			//txtRazSocial.setText(tablaProveedor.getValueAt(filaSelect, 1).toString());
			txtDireccion.setText(tablaProveedor.getValueAt(filaSelect, 2).toString());
			txtTelefono.setText(tablaProveedor.getValueAt(filaSelect, 3).toString());
			
			cmbPrv.setSelectedItem(tablaProveedor.getValueAt(filaSelect, 1));
		}
	}
}
