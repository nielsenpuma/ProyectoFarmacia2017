package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.util.ArrayList;
import java.util.Date;

import org.edisoncor.gui.label.LabelHeader;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EtchedBorder;
import org.edisoncor.gui.panel.PanelImage;
import org.jdesktop.swingx.autocomplete.ListAdaptor;

import javax.swing.ImageIcon;
import principal.MaterialButtomRectangle;
import app.bolivia.swing.JCTextField;
import controlador.CProducto;
import controlador.CProveedor;
import entidades.EProducto;
import entidades.EProveedor;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.print.attribute.standard.PresentationDirection;
import javax.swing.DefaultComboBoxModel;

public class FrmComprasMD extends JFrame implements ActionListener, MouseListener {
	
	private CProveedor ObjC = new CProveedor();
	private CProducto ObjCP = new CProducto();
	private ArrayList<EProveedor> MiLista;
	private ArrayList<EProducto> MiListaProducto;
	
	private DefaultTableModel MiTabla;
	private DefaultComboBoxModel<EProveedor> modeloCombo;
	
	private String accion = "guardar";

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblProveedores;
	private JPanel panel_2;
	private JLabel lblCod;
	private JLabel lblProveedor;
	private JLabel lblDireccin;
	private JLabel lblTelfono;
	private PanelImage panelImage;
	private PanelImage panelImage_3;
	private JCTextField txtCodigo;
	private JCTextField txtNroCompra;
	private JLabel lblBuscar;
	private PanelImage panelImage_4;
	private JCTextField txtBuscarMedicamento;
	private MaterialButtomRectangle btnBuscar;
	private MaterialButtomRectangle brnAgregar;
	private JTable tablaMedicamentos;
	private JScrollPane scrollPane;
	private PanelImage panelImage_5;
	private JCTextField txtBuscarCategoria;
	private JLabel lblCategora;
	private JPanel panel_3;
	private JScrollPane scrollPane_1;
	private MaterialButtomRectangle btnEliminar;
	private MaterialButtomRectangle btnProcesarVenta;
	private MaterialButtomRectangle btnCancelar;
	private JTable tablaDetalleVenta;
	private JDateChooser dcFecha;
	private JComboBox cmbProveedor;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmComprasMD frame = new FrmComprasMD();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	//CargarDetalleCompra
	void CargarDetalle(){
		MiTabla = new DefaultTableModel();
		String columnas[] = { "COD","PRODUCTO", "CANTIDAD"};

		for (String obj : columnas) {
			MiTabla.addColumn(obj);
		}
		
		tablaDetalleVenta.setModel(MiTabla);
	}
	
	//LLenar Productos
	void LlenarProductos(){
		MiListaProducto = new ArrayList<>();
		MiListaProducto = ObjCP.Listar();
		
		MiTabla = new DefaultTableModel();
		String columnas[] = { "COD.", "PRODUCTO", "PRECIO", "STOCK", "LABORATORIO", "CATEGORIA" };

		for (String obj : columnas) {
			MiTabla.addColumn(obj);
		}

		Object filas[][] = new Object[MiLista.size()][6];
		
		for (int i = 0; i < MiListaProducto.size(); i++) {
			filas[i][0] = MiListaProducto.get(i).getCod_pro();
			filas[i][1] = MiListaProducto.get(i).getDesc_pro();
			filas[i][2] = MiListaProducto.get(i).getPre_pro();
			filas[i][3] = MiListaProducto.get(i).getStk_act();
			filas[i][4] = MiListaProducto.get(i).getCod_lab();
			filas[i][5] = MiListaProducto.get(i).getCod_cat();

			MiTabla.addRow(filas[i]);
		}
		tablaMedicamentos.setModel(MiTabla);
	}
	//Llenar Combo
	void llenarCombo() {
		cmbProveedor.removeAllItems();
		modeloCombo = new DefaultComboBoxModel<>();

		cmbProveedor.setModel(modeloCombo);

		MiLista = ObjC.Listar();

		for (EProveedor eProveedor : MiLista) {
			modeloCombo.addElement(eProveedor);
		}
	}
	
	//Método cargar JTable
	public void CargarTabla(){
		MiLista = new ArrayList<>();
		MiLista = ObjC.Listar();
		
		MiTabla = new DefaultTableModel();
		String columnas[] = { "COD.", "RAZ. SOCIAL", "DIRECCIÓN", "TELÉFONO" };

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
		tablaMedicamentos.setModel(MiTabla);
	}
	
	//Filtrar tabla
	public void FiltrarTabla(String id){
		MiLista = new ArrayList<>();
		MiLista = ObjC.Filtrar(id);
		
		MiTabla = new DefaultTableModel();
		String columnas[] = { "COD.", "RAZ. SOCIAL", "DIRECCIÓN", "TELÉFONO" };

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
		tablaMedicamentos.setModel(MiTabla);
		//lblTotal.setText(""+tablaMedicamentos.getRowCount());
	}
	
	void habilitar(){
		txtCodigo.setEnabled(true);
		
		//txtProveedor.setEnabled(true);
		//txtDireccion.setEnabled(true);
		txtNroCompra.setEnabled(true);
		
		//btnGuardar.setEnabled(true);
		btnCancelar.setEnabled(true);
		btnEliminar.setEnabled(true);
		
		txtCodigo.setText("");
		//txtProveedor.setText("");
		//txtDireccion.setText("");
		txtNroCompra.setText("");
	}
	
	void inhabilitar(){
		txtCodigo.setEnabled(false);
		txtNroCompra.setEnabled(false);
		
		txtCodigo.setText("");
	}

	/**
	 * Create the frame.
	 */
	public FrmComprasMD() {
		setTitle("Compras");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 775, 591);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			panel = new JPanel();
			panel.setBackground(new Color(240, 240, 240));
			panel.setBounds(6, 6, 760, 554);
			contentPane.add(panel);
			panel.setLayout(null);
			{
				lblProveedores = new JLabel("COMPRAS");
				lblProveedores.setForeground(new Color(105, 105, 105));
				lblProveedores.setHorizontalAlignment(SwingConstants.CENTER);
				lblProveedores.setFont(new Font("Lucida Grande", Font.BOLD, 24));
				lblProveedores.setBounds(6, 6, 720, 30);
				panel.add(lblProveedores);
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "COMPRA", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(105, 105, 105)));
				panel_1.setBounds(6, 48, 744, 127);
				panel.add(panel_1);
				panel_1.setLayout(null);
				{
					lblCod = new JLabel("C\u00D3DIGO:");
					lblCod.setHorizontalAlignment(SwingConstants.RIGHT);
					lblCod.setBounds(6, 31, 86, 29);
					panel_1.add(lblCod);
				}
				{
					lblProveedor = new JLabel("PROVEEDOR:");
					lblProveedor.setHorizontalAlignment(SwingConstants.RIGHT);
					lblProveedor.setBounds(6, 72, 86, 29);
					panel_1.add(lblProveedor);
				}
				{
					lblDireccin = new JLabel("FECHA:");
					lblDireccin.setHorizontalAlignment(SwingConstants.RIGHT);
					lblDireccin.setBounds(411, 31, 86, 29);
					panel_1.add(lblDireccin);
				}
				{
					lblTelfono = new JLabel("COMPRA N\u00BA:");
					lblTelfono.setHorizontalAlignment(SwingConstants.RIGHT);
					lblTelfono.setBounds(411, 74, 86, 27);
					panel_1.add(lblTelfono);
				}
				{
					panelImage = new PanelImage();
					panelImage.setBorder(null);
					panelImage.setIcon(new ImageIcon(FrmComprasMD.class.getResource("/img/campos.png")));
					panelImage.setBounds(104, 31, 133, 29);
					panel_1.add(panelImage);
					panelImage.setLayout(null);
					{
						txtCodigo = new JCTextField();
						txtCodigo.addActionListener(this);
						txtCodigo.setBorder(null);
						txtCodigo.setFont(new Font("Lucida Grande", Font.BOLD, 14));
						txtCodigo.setPlaceholder("C\u00F3digo");
						txtCodigo.setBounds(6, 0, 121, 29);
						panelImage.add(txtCodigo);
					}
				}
				{
					panelImage_3 = new PanelImage();
					panelImage_3.setIcon(new ImageIcon(FrmComprasMD.class.getResource("/img/campos.png")));
					panelImage_3.setBorder(null);
					panelImage_3.setBounds(509, 72, 208, 29);
					panel_1.add(panelImage_3);
					panelImage_3.setLayout(null);
					{
						txtNroCompra = new JCTextField();
						txtNroCompra.addActionListener(this);
						txtNroCompra.setPlaceholder("Nro. Compra");
						txtNroCompra.setFont(new Font("Lucida Grande", Font.BOLD, 14));
						txtNroCompra.setBorder(null);
						txtNroCompra.setBounds(6, 0, 196, 29);
						panelImage_3.add(txtNroCompra);
					}
				}
				{
					btnBuscar = new MaterialButtomRectangle();
					btnBuscar.setBounds(277, 26, 109, 40);
					panel_1.add(btnBuscar);
					btnBuscar.addActionListener(this);
					btnBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					btnBuscar.setText("BUSCAR");
					btnBuscar.setForeground(Color.WHITE);
					btnBuscar.setBackground(new Color(0, 153, 204));
				}
				{
					cmbProveedor = new JComboBox();
					cmbProveedor.addMouseListener(this);
					cmbProveedor.addActionListener(this);
					cmbProveedor.setBounds(104, 72, 270, 30);
					panel_1.add(cmbProveedor);
					cmbProveedor.setModel(new DefaultComboBoxModel(new String[] {"Item 1", "Item 2"}));
					cmbProveedor.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
					cmbProveedor.setBorder(null);
				}
				{
					dcFecha = new JDateChooser();
					dcFecha.setBounds(509, 31, 208, 26);
					panel_1.add(dcFecha);
					dcFecha.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
					dcFecha.setBackground(new Color(255, 255, 255));
					dcFecha.setBorder(null);
				}
			}
			{
				panel_2 = new JPanel();
				panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "BUSCAR MEDICAMENTO", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(105, 105, 105)));
				panel_2.setBounds(6, 187, 744, 170);
				panel.add(panel_2);
				panel_2.setLayout(null);
				{
					lblBuscar = new JLabel("MEDICAMENTO:");
					lblBuscar.setBounds(6, 28, 100, 29);
					panel_2.add(lblBuscar);
				}
				{
					panelImage_4 = new PanelImage();
					panelImage_4.setIcon(new ImageIcon(FrmComprasMD.class.getResource("/img/campos.png")));
					panelImage_4.setLayout(null);
					panelImage_4.setBorder(null);
					panelImage_4.setBounds(118, 28, 190, 29);
					panel_2.add(panelImage_4);
					{
						txtBuscarMedicamento = new JCTextField();
						txtBuscarMedicamento.setBounds(6, 0, 184, 29);
						panelImage_4.add(txtBuscarMedicamento);
						txtBuscarMedicamento.setPlaceholder("Medicamento");
						txtBuscarMedicamento.setFont(new Font("Lucida Grande", Font.BOLD, 14));
						txtBuscarMedicamento.setBorder(null);
					}
				}
				{
					scrollPane = new JScrollPane();
					scrollPane.setBounds(16, 69, 654, 78);
					panel_2.add(scrollPane);
					{
						tablaMedicamentos = new JTable();
						tablaMedicamentos.addMouseListener(this);
						tablaMedicamentos.setSelectionBackground(new Color(135, 206, 235));
						tablaMedicamentos.setBackground(new Color(255, 255, 255));
						tablaMedicamentos.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
						tablaMedicamentos.getTableHeader().setPreferredSize(new java.awt.Dimension(0, 30));
						tablaMedicamentos.getTableHeader().setFont(new Font("Lucida Grande", Font.BOLD, 14));
						
						scrollPane.setViewportView(tablaMedicamentos);
					}
				}
				{
					panelImage_5 = new PanelImage();
					panelImage_5.setIcon(new ImageIcon(FrmComprasMD.class.getResource("/img/campos.png")));
					panelImage_5.setLayout(null);
					panelImage_5.setBorder(null);
					panelImage_5.setBounds(417, 28, 190, 29);
					panel_2.add(panelImage_5);
					{
						txtBuscarCategoria = new JCTextField();
						txtBuscarCategoria.setPlaceholder("Categor\u00EDa");
						txtBuscarCategoria.setFont(new Font("Lucida Grande", Font.BOLD, 14));
						txtBuscarCategoria.setBorder(null);
						txtBuscarCategoria.setBounds(6, 0, 184, 29);
						panelImage_5.add(txtBuscarCategoria);
					}
				}
				{
					lblCategora = new JLabel("CATEGOR\u00CDA:");
					lblCategora.setBounds(320, 28, 100, 29);
					panel_2.add(lblCategora);
				}
				{
					brnAgregar = new MaterialButtomRectangle();
					brnAgregar.setFont(new Font("Dialog", Font.BOLD, 24));
					brnAgregar.setBounds(677, 81, 61, 49);
					panel_2.add(brnAgregar);
					brnAgregar.addActionListener(this);
					brnAgregar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					brnAgregar.setText("+");
					brnAgregar.setForeground(Color.WHITE);
					brnAgregar.setBackground(new Color(0, 153, 204));
				}
				{
					panel_3 = new JPanel();
					panel_3.setLayout(null);
					panel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "DETALLE ORDEN DE COMPRA", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(105, 105, 105)));
					panel_3.setBounds(6, 369, 744, 177);
					panel.add(panel_3);
					{
						scrollPane_1 = new JScrollPane();
						scrollPane_1.setBounds(20, 21, 654, 90);
						panel_3.add(scrollPane_1);
						{
							tablaDetalleVenta = new JTable();
							tablaDetalleVenta.setSelectionBackground(new Color(135, 206, 235));
							tablaDetalleVenta.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
							tablaDetalleVenta.setBackground(Color.WHITE);
							scrollPane_1.setViewportView(tablaDetalleVenta);
						}
					}
					{
						btnEliminar = new MaterialButtomRectangle();
						btnEliminar.addActionListener(this);
						btnEliminar.setText("ELIMINAR");
						btnEliminar.setForeground(Color.WHITE);
						btnEliminar.setBackground(new Color(0, 153, 204));
						btnEliminar.setBounds(16, 117, 150, 40);
						panel_3.add(btnEliminar);
					}
					{
						btnProcesarVenta = new MaterialButtomRectangle();
						btnProcesarVenta.addActionListener(this);
						btnProcesarVenta.setText("PROCESAR COMPRA");
						btnProcesarVenta.setForeground(Color.WHITE);
						btnProcesarVenta.setBackground(new Color(0, 153, 204));
						btnProcesarVenta.setBounds(214, 123, 200, 40);
						panel_3.add(btnProcesarVenta);
					}
					{
						btnCancelar = new MaterialButtomRectangle();
						btnCancelar.addActionListener(this);
						btnCancelar.setText("CANCELAR");
						btnCancelar.setForeground(Color.WHITE);
						btnCancelar.setBackground(new Color(0, 153, 204));
						btnCancelar.setBounds(524, 123, 150, 40);
						panel_3.add(btnCancelar);
					}
				}
				
				//CargarTabla();
				//inhabilitar();
				llenarCombo();
				Date fecha = new Date();
				dcFecha.setDate(fecha);
				
				LlenarProductos();
				
				CargarDetalle();
			}
			{
				
			}
		}
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnProcesarVenta) {
			actionPerformedBtnProcesarVenta(e);
		}
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
		if (e.getSource() == cmbProveedor) {
			actionPerformedCmbProveedor(e);
		}
		if (e.getSource() == brnAgregar) {
			actionPerformedBtnAgregar(e);
		}
		if (e.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(e);
		}
		if (e.getSource() == txtNroCompra) {
			actionPerformedTxtTelefono(e);
		}
		if (e.getSource() == txtCodigo) {
			actionPerformedTxtCodigo(e);
		}
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == cmbProveedor) {
			mouseClickedCmbProveedor(e);
		}
		if (e.getSource() == tablaMedicamentos) {
			mouseClickedTablaProveedores(e);
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
	protected void mouseClickedTablaProveedores(MouseEvent e) {
		//btnGuardar.setText("EDITAR");
		
		habilitar();
		btnEliminar.setEnabled(true);
		txtCodigo.setEnabled(false);
		accion = "editar";
		
		int fila = tablaMedicamentos.getSelectedRow();
		
		txtCodigo.setText(tablaMedicamentos.getValueAt(fila, 0).toString());
		//txtProveedor.setText(tablaMedicamentos.getValueAt(fila, 1).toString());
		//txtDireccion.setText(tablaMedicamentos.getValueAt(fila, 2).toString());
		txtNroCompra.setText(tablaMedicamentos.getValueAt(fila, 3).toString());
	}
	protected void actionPerformedTxtCodigo(ActionEvent e) {
		txtCodigo.transferFocus();
	}
	protected void actionPerformedTxtTelefono(ActionEvent e) {
		txtNroCompra.transferFocus();
	}
	protected void actionPerformedBtnBuscar(ActionEvent e) {
		if(txtBuscarMedicamento.getText().length()!=0){
			
			FiltrarTabla("%"+txtBuscarMedicamento.getText()+"%");
		
			
		}else{
			CargarTabla();
		}
	}
	protected void actionPerformedBtnAgregar(ActionEvent e) {
		int seleccion = tablaMedicamentos.getSelectedRow();
		
		
		
		if(seleccion != -1){
			int cantidad = Integer.parseInt( JOptionPane.showInputDialog("Ingrese la cantidad", "0"));
			
			Object producto[] = {
					tablaMedicamentos.getValueAt(seleccion, 0),
					tablaMedicamentos.getValueAt(seleccion, 1),
					cantidad
			};
			DefaultTableModel tmp = (DefaultTableModel) tablaDetalleVenta.getModel();
			
			tmp.addRow(producto);
		}else{
			JOptionPane.showConfirmDialog(rootPane, "Seleccione un producto");
		}
	}
	protected void actionPerformedCmbProveedor(ActionEvent e) {
		//txtCodigo.setText((String) cmbProveedor.getSelectedItem());
		/*EProveedor obj = new EProveedor();
		obj = (EProveedor) cmbProveedor.getSelectedItem();
		System.out.println(""+obj.getCod_prv());*/
	}
	protected void mouseClickedCmbProveedor(MouseEvent e) {
		EProveedor obj = (EProveedor) cmbProveedor.getSelectedItem();
		System.out.println(""+obj.getCod_prv());
		txtCodigo.setText(obj.getCod_prv());
	}
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		this.dispose();
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		int seleccion = tablaDetalleVenta.getSelectedRow();
		if(seleccion!=-1){
			DefaultTableModel tmp = (DefaultTableModel) tablaDetalleVenta.getModel();
			tmp.removeRow(seleccion);
		}
	}
	protected void actionPerformedBtnProcesarVenta(ActionEvent e) {
		//Para la orden de Compra guarde en la base de datos
	}
}
