package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import controlador.CProducto;
import entidades.ECategoria;
import entidades.ELaboratorio;
import entidades.EProducto;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmProducto extends JFrame implements ActionListener {
	//atributos
	private CProducto objP = new CProducto();
	private ArrayList<EProducto> MiLista;
	private DefaultTableModel MiTabla;

	private JPanel contentPane;
	public JPanel panel;
	public JLabel lblProductos;
	public JPanel panel_1;
	public JLabel lblCodigoProducto;
	public JLabel lblDescripcion;
	public JLabel lblPrecioProducto;
	public JLabel lblStockActivo;
	public JLabel lblStockMinimo;
	public JLabel lblUnidadDeMedida;
	public JTextField txtCodPro;
	public JTextField txtDescPro;
	public JTextField txtPrecioPro;
	public JTextField txtStokAct;
	public JTextField txtStkMin;
	public JTextField txtUnidMed;
	public JLabel lblFechaVencimiento;
	public JLabel lblCodigoLaboratorio;
	public JLabel lblCodigoCategoria;
	public JTextField txtFecVen;
	public JTextField txtCodLab;
	public JTextField txtCodCat;
	public JPanel panel_2;
	public JButton btnNuevo;
	public JButton btnEditar;
	public JButton btnGuardar;
	public JButton btnEliminar;
	public JButton btnBuscar;
	public JButton btnSalir;
	public JPanel panel_3;
	public JTable tablaProductos;
	public JScrollPane scrollPane;
	//Cargar JTable
	public void CargarJTable(){
		MiTabla = new DefaultTableModel();
		String columnas[]={"Codigo", "Descripcion","Precio","Stock Act","Stock Min","Unidad Med","Fecha Ven","Cod. Lab","Cod.Cat"};
		for (String obj : columnas) {
			MiTabla.addColumn(obj);
		}
		Object filas[][] = new Object[MiLista.size()][9];
		for (int i = 0; i < MiLista.size(); i++) {
			filas[i][0] = MiLista.get(i).getCod_pro();
			filas[i][1] = MiLista.get(i).getDesc_pro();
			filas[i][2] = MiLista.get(i).getPre_pro();
			filas[i][3] = MiLista.get(i).getStk_act();
			filas[i][4] = MiLista.get(i).getStk_min();
			filas[i][5] = MiLista.get(i).getUnid_med();
			filas[i][6] = MiLista.get(i).getFec_ven();
			filas[i][7] = MiLista.get(i).getCod_lab().getDesc_lab();
			filas[i][8] = MiLista.get(i).getCod_cat().getDesc_cat();			
			MiTabla.addRow(filas[i]);
		}
		tablaProductos.setModel(MiTabla);
	}
	void limpiar(){
		txtCodPro.setText("");
		txtDescPro.setText("");
		txtPrecioPro.setText("");
		txtStokAct.setText("");
		txtStkMin.setText("");
		txtUnidMed.setText("");
		txtFecVen.setText("");
		txtCodLab.setText("");
		txtCodCat.setText("");
	}
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmProducto frame = new FrmProducto();
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
	public FrmProducto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 830, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			panel = new JPanel();
			panel.setBounds(0, 0, 814, 47);
			contentPane.add(panel);
			panel.setLayout(null);
			{
				lblProductos = new JLabel("Productos");
				lblProductos.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblProductos.setBounds(345, 22, 88, 14);
				panel.add(lblProductos);
			}
		}
		{
			panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(null, "Datos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_1.setBounds(10, 58, 662, 206);
			contentPane.add(panel_1);
			panel_1.setLayout(null);
			{
				lblCodigoProducto = new JLabel("Codigo Producto:");
				lblCodigoProducto.setBounds(10, 21, 138, 14);
				panel_1.add(lblCodigoProducto);
			}
			{
				lblDescripcion = new JLabel("Descripcion:");
				lblDescripcion.setBounds(10, 46, 138, 14);
				panel_1.add(lblDescripcion);
			}
			{
				lblPrecioProducto = new JLabel("Precio Producto:");
				lblPrecioProducto.setBounds(10, 71, 138, 14);
				panel_1.add(lblPrecioProducto);
			}
			{
				lblStockActivo = new JLabel("Stock Activo:");
				lblStockActivo.setBounds(10, 96, 138, 14);
				panel_1.add(lblStockActivo);
			}
			{
				lblStockMinimo = new JLabel("Stock Minimo:");
				lblStockMinimo.setBounds(10, 121, 138, 14);
				panel_1.add(lblStockMinimo);
			}
			{
				lblUnidadDeMedida = new JLabel("Unidad de Medida:");
				lblUnidadDeMedida.setBounds(10, 147, 138, 14);
				panel_1.add(lblUnidadDeMedida);
			}
			{
				txtCodPro = new JTextField();
				txtCodPro.setBounds(158, 18, 86, 20);
				panel_1.add(txtCodPro);
				txtCodPro.setColumns(10);
			}
			{
				txtDescPro = new JTextField();
				txtDescPro.setBounds(158, 43, 189, 20);
				panel_1.add(txtDescPro);
				txtDescPro.setColumns(10);
			}
			{
				txtPrecioPro = new JTextField();
				txtPrecioPro.setBounds(158, 68, 86, 20);
				panel_1.add(txtPrecioPro);
				txtPrecioPro.setColumns(10);
			}
			{
				txtStokAct = new JTextField();
				txtStokAct.setBounds(158, 93, 86, 20);
				panel_1.add(txtStokAct);
				txtStokAct.setColumns(10);
			}
			{
				txtStkMin = new JTextField();
				txtStkMin.setBounds(158, 118, 86, 20);
				panel_1.add(txtStkMin);
				txtStkMin.setColumns(10);
			}
			{
				txtUnidMed = new JTextField();
				txtUnidMed.setBounds(158, 144, 86, 20);
				panel_1.add(txtUnidMed);
				txtUnidMed.setColumns(10);
			}
			{
				lblFechaVencimiento = new JLabel("Fecha Vencimiento:");
				lblFechaVencimiento.setBounds(366, 21, 144, 14);
				panel_1.add(lblFechaVencimiento);
			}
			{
				lblCodigoLaboratorio = new JLabel("Codigo Laboratorio:");
				lblCodigoLaboratorio.setBounds(366, 46, 144, 14);
				panel_1.add(lblCodigoLaboratorio);
			}
			{
				lblCodigoCategoria = new JLabel("Codigo categoria:");
				lblCodigoCategoria.setBounds(366, 71, 144, 14);
				panel_1.add(lblCodigoCategoria);
			}
			{
				txtFecVen = new JTextField();
				txtFecVen.setBounds(541, 18, 86, 20);
				panel_1.add(txtFecVen);
				txtFecVen.setColumns(10);
			}
			{
				txtCodLab = new JTextField();
				txtCodLab.setBounds(541, 43, 86, 20);
				panel_1.add(txtCodLab);
				txtCodLab.setColumns(10);
			}
			{
				txtCodCat = new JTextField();
				txtCodCat.setBounds(541, 68, 86, 20);
				panel_1.add(txtCodCat);
				txtCodCat.setColumns(10);
			}
		}
		{
			panel_2 = new JPanel();
			panel_2.setBorder(new TitledBorder(null, "Mantenimiento", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_2.setBounds(682, 58, 122, 206);
			contentPane.add(panel_2);
			panel_2.setLayout(null);
			{
				btnNuevo = new JButton("Nuevo");
				btnNuevo.addActionListener(this);
				btnNuevo.setBounds(10, 24, 89, 23);
				panel_2.add(btnNuevo);
			}
			{
				btnEditar = new JButton("Editar");
				btnEditar.addActionListener(this);
				btnEditar.setBounds(10, 55, 89, 23);
				panel_2.add(btnEditar);
			}
			{
				btnGuardar = new JButton("Guardar");
				btnGuardar.addActionListener(this);
				btnGuardar.setBounds(10, 83, 89, 23);
				panel_2.add(btnGuardar);
			}
			{
				btnEliminar = new JButton("Eliminar");
				btnEliminar.addActionListener(this);
				btnEliminar.setBounds(10, 111, 89, 23);
				panel_2.add(btnEliminar);
			}
			{
				btnBuscar = new JButton("Buscar");
				btnBuscar.addActionListener(this);
				btnBuscar.setBounds(10, 141, 89, 23);
				panel_2.add(btnBuscar);
			}
			{
				btnSalir = new JButton("Salir");
				btnSalir.addActionListener(this);
				btnSalir.setBounds(10, 172, 89, 23);
				panel_2.add(btnSalir);
			}
		}
		{
			panel_3 = new JPanel();
			panel_3.setBorder(new TitledBorder(null, "Lista Productos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_3.setBounds(10, 275, 794, 165);
			contentPane.add(panel_3);
			panel_3.setLayout(null);
			{
				scrollPane = new JScrollPane();
				scrollPane.setBounds(10, 23, 774, 131);
				panel_3.add(scrollPane);
				{
					tablaProductos = new JTable();
					scrollPane.setViewportView(tablaProductos);
				}
			}
		}
		//cargar
		
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnSalir) {
			do_btnSalir_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnBuscar) {
			do_btnBuscar_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnEliminar) {
			do_btnEliminar_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnGuardar) {
			do_btnGuardar_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnEditar) {
			do_btnEditar_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnNuevo) {
			do_btnNuevo_actionPerformed(arg0);
		}
	}
	protected void do_btnNuevo_actionPerformed(ActionEvent arg0) {
		limpiar();
	}
	protected void do_btnEditar_actionPerformed(ActionEvent arg0) {
		ELaboratorio l = new ELaboratorio();
		int cod = Integer.parseInt(txtCodLab.getText());
		ECategoria c = new ECategoria();
	/*	EProducto obj = new EProducto(
				txtCodPro.getText(),
				txtDescPro.getText(),
				Double.parseDouble(txtPrecioPro.getText()),
				Integer.parseInt(txtStokAct.getText()),
				Integer.parseInt(txtStkMin.getText()),
				txtUnidMed.getText(),
				txtFecVen.getText(),
				txtCodLab.getText(),
				txtCodCat.getText()
				);
		objP.Modificar(obj);*/
	}
	protected void do_btnGuardar_actionPerformed(ActionEvent arg0) {
	}
	protected void do_btnEliminar_actionPerformed(ActionEvent arg0) {
	}
	protected void do_btnBuscar_actionPerformed(ActionEvent arg0) {
		String des = txtDescPro.getText();
		objP.Buscar(des);
		MiLista=objP.Buscar(des);
		CargarJTable();
		
	}
	protected void do_btnSalir_actionPerformed(ActionEvent arg0) {
		dispose();
	}
	void mensaje(String s){
		JOptionPane.showMessageDialog(this, s);
	}
}
