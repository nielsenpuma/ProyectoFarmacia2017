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
import javax.swing.DefaultComboBoxModel;

public class FrmVentasMD extends JFrame implements ActionListener, MouseListener {
	
	//private CProveedor ObjC = new CProveedor();
	private CProducto ObjCPR = new CProducto();
	
	private ArrayList<EProducto> MiListaProducto;
	Date fecha = new Date();
	
	private DefaultTableModel MiTabla;
	
	private String accion = "guardar";

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblProveedores;
	private JPanel panel_2;
	private JLabel lblCod;
	private JLabel lblCliente;
	private JLabel lblDireccin;
	private JLabel lblTelfono;
	private PanelImage panelImage;
	private PanelImage panelImage_3;
	private JCTextField txtCodigo;
	private JCTextField txtNroVenta;
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
	private JLabel lblSubtotal;
	private PanelImage panelImage_6;
	private JCTextField txtSubTotal;
	private JScrollPane scrollPane_1;
	private PanelImage panelImage_7;
	private JCTextField txtIGV;
	private JLabel lblIgv;
	private MaterialButtomRectangle btnEliminar;
	private MaterialButtomRectangle btnProcesarVenta;
	private MaterialButtomRectangle btnCancelar;
	private PanelImage panelImage_8;
	private JCTextField txtTotal;
	private JLabel lblTotal_1;
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
					FrmVentasMD frame = new FrmVentasMD();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	//LLenar Productos
	void LlenarProductos(){
		MiListaProducto = new ArrayList<>();
		MiListaProducto = ObjCPR.Listar();
		
		MiTabla = new DefaultTableModel();
		String columnas[] = { "COD.", "PRODUCTO", "PRECIO", "STOCK", "LABORATORIO", "CATEGORIA" };

		for (String obj : columnas) {
			MiTabla.addColumn(obj);
		}

		Object filas[][] = new Object[MiListaProducto.size()][6];
		
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
	
	
	//Método cargar JTable
	
	
	//Filtrar tabla
	
	
	void habilitar(){
		txtCodigo.setEnabled(true);
		
		//txtProveedor.setEnabled(true);
		//txtDireccion.setEnabled(true);
		txtNroVenta.setEnabled(true);
		
		//btnGuardar.setEnabled(true);
		btnCancelar.setEnabled(true);
		btnEliminar.setEnabled(true);
		
		txtCodigo.setText("");
		//txtProveedor.setText("");
		//txtDireccion.setText("");
		txtNroVenta.setText("");
	}
	
	void inhabilitar(){
		txtCodigo.setEnabled(false);
		txtNroVenta.setEnabled(false);
		
		txtCodigo.setText("");
	}

	/**
	 * Create the frame.
	 */
	public FrmVentasMD() {
		setTitle("Compras");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 780, 636);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			panel = new JPanel();
			panel.setBackground(new Color(240, 240, 240));
			panel.setBounds(6, 6, 760, 594);
			contentPane.add(panel);
			panel.setLayout(null);
			{
				lblProveedores = new JLabel("VENTAS");
				lblProveedores.setForeground(new Color(105, 105, 105));
				lblProveedores.setHorizontalAlignment(SwingConstants.CENTER);
				lblProveedores.setFont(new Font("Lucida Grande", Font.BOLD, 24));
				lblProveedores.setBounds(6, 6, 720, 30);
				panel.add(lblProveedores);
			}
			{
				{
					panel_3 = new JPanel();
					panel_3.setLayout(null);
					panel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "DETALLE VENTA", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(105, 105, 105)));
					panel_3.setBounds(6, 232, 744, 348);
					panel.add(panel_3);
					{
						lblSubtotal = new JLabel("SUBTOTAL:");
						lblSubtotal.setBounds(358, 220, 100, 29);
						panel_3.add(lblSubtotal);
					}
					{
						panelImage_6 = new PanelImage();
						panelImage_6.setIcon(new ImageIcon(FrmVentasMD.class.getResource("/img/campos.png")));
						panelImage_6.setLayout(null);
						panelImage_6.setBorder(null);
						panelImage_6.setBounds(470, 220, 190, 29);
						panel_3.add(panelImage_6);
						{
							txtSubTotal = new JCTextField();
							txtSubTotal.setText("0.0");
							txtSubTotal.setPlaceholder("Medicamento");
							txtSubTotal.setFont(new Font("Lucida Grande", Font.BOLD, 14));
							txtSubTotal.setBorder(null);
							txtSubTotal.setBounds(6, 0, 184, 29);
							panelImage_6.add(txtSubTotal);
						}
					}
					{
						scrollPane_1 = new JScrollPane();
						scrollPane_1.setBounds(20, 119, 654, 90);
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
						panelImage_7 = new PanelImage();
						panelImage_7.setIcon(new ImageIcon(FrmVentasMD.class.getResource("/img/campos.png")));
						panelImage_7.setLayout(null);
						panelImage_7.setBorder(null);
						panelImage_7.setBounds(470, 261, 190, 29);
						panel_3.add(panelImage_7);
						{
							txtIGV = new JCTextField();
							txtIGV.setText("0.0");
							txtIGV.setPlaceholder("Categor\u00EDa");
							txtIGV.setFont(new Font("Lucida Grande", Font.BOLD, 14));
							txtIGV.setBorder(null);
							txtIGV.setBounds(6, 0, 184, 29);
							panelImage_7.add(txtIGV);
						}
					}
					{
						lblIgv = new JLabel("I.G.V.:");
						lblIgv.setBounds(368, 261, 100, 29);
						panel_3.add(lblIgv);
					}
					{
						btnEliminar = new MaterialButtomRectangle();
						btnEliminar.setText("ELIMINAR");
						btnEliminar.setForeground(Color.WHITE);
						btnEliminar.setBackground(new Color(0, 153, 204));
						btnEliminar.setBounds(16, 215, 150, 40);
						panel_3.add(btnEliminar);
					}
					{
						btnProcesarVenta = new MaterialButtomRectangle();
						btnProcesarVenta.setText("PROCESAR VENTA");
						btnProcesarVenta.setForeground(Color.WHITE);
						btnProcesarVenta.setBackground(new Color(0, 153, 204));
						btnProcesarVenta.setBounds(167, 220, 150, 74);
						panel_3.add(btnProcesarVenta);
					}
					{
						btnCancelar = new MaterialButtomRectangle();
						btnCancelar.addActionListener(this);
						btnCancelar.setText("CANCELAR");
						btnCancelar.setForeground(Color.WHITE);
						btnCancelar.setBackground(new Color(0, 153, 204));
						btnCancelar.setBounds(16, 256, 150, 40);
						panel_3.add(btnCancelar);
					}
					{
						panelImage_8 = new PanelImage();
						panelImage_8.setIcon(new ImageIcon(FrmVentasMD.class.getResource("/img/campos.png")));
						panelImage_8.setLayout(null);
						panelImage_8.setBorder(null);
						panelImage_8.setBounds(470, 302, 190, 29);
						panel_3.add(panelImage_8);
						{
							txtTotal = new JCTextField();
							txtTotal.setText("0.0");
							txtTotal.setFont(new Font("Lucida Grande", Font.BOLD, 14));
							txtTotal.setBorder(null);
							txtTotal.setBounds(6, 0, 184, 29);
							panelImage_8.add(txtTotal);
						}
					}
					{
						lblTotal_1 = new JLabel("TOTAL:");
						lblTotal_1.setBounds(358, 302, 100, 29);
						panel_3.add(lblTotal_1);
					}
					{
						panelImage = new PanelImage();
						panelImage.setBounds(114, 37, 133, 29);
						panel_3.add(panelImage);
						panelImage.setBorder(null);
						panelImage.setIcon(new ImageIcon(FrmVentasMD.class.getResource("/img/campos.png")));
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
						lblCod = new JLabel("C\u00D3DIGO:");
						lblCod.setBounds(16, 37, 86, 29);
						panel_3.add(lblCod);
						lblCod.setHorizontalAlignment(SwingConstants.RIGHT);
					}
					{
						btnBuscar = new MaterialButtomRectangle();
						btnBuscar.setBounds(287, 32, 109, 40);
						panel_3.add(btnBuscar);
						btnBuscar.addActionListener(this);
						btnBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
						btnBuscar.setText("BUSCAR");
						btnBuscar.setForeground(Color.WHITE);
						btnBuscar.setBackground(new Color(0, 153, 204));
					}
					{
						lblCliente = new JLabel("CLIENTE:");
						lblCliente.setBounds(16, 78, 86, 29);
						panel_3.add(lblCliente);
						lblCliente.setHorizontalAlignment(SwingConstants.RIGHT);
					}
					{
						cmbProveedor = new JComboBox();
						cmbProveedor.setBounds(114, 78, 270, 30);
						panel_3.add(cmbProveedor);
						cmbProveedor.addMouseListener(this);
						cmbProveedor.addActionListener(this);
						cmbProveedor.setModel(new DefaultComboBoxModel(new String[] {"Item 1", "Item 2"}));
						cmbProveedor.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
						cmbProveedor.setBorder(null);
					}
					{
						lblDireccin = new JLabel("FECHA:");
						lblDireccin.setBounds(408, 37, 86, 29);
						panel_3.add(lblDireccin);
						lblDireccin.setHorizontalAlignment(SwingConstants.RIGHT);
					}
					{
						dcFecha = new JDateChooser();
						dcFecha.setBounds(506, 37, 208, 26);
						panel_3.add(dcFecha);
						dcFecha.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
						dcFecha.setBackground(new Color(255, 255, 255));
						dcFecha.setBorder(null);
					}
					dcFecha.setDate(fecha);
					{
						lblTelfono = new JLabel("VENTA N\u00BA:");
						lblTelfono.setBounds(408, 80, 86, 27);
						panel_3.add(lblTelfono);
						lblTelfono.setHorizontalAlignment(SwingConstants.RIGHT);
					}
					{
						panelImage_3 = new PanelImage();
						panelImage_3.setBounds(506, 78, 208, 29);
						panel_3.add(panelImage_3);
						panelImage_3.setIcon(new ImageIcon(FrmVentasMD.class.getResource("/img/campos.png")));
						panelImage_3.setBorder(null);
						panelImage_3.setLayout(null);
						{
							txtNroVenta = new JCTextField();
							txtNroVenta.addActionListener(this);
							txtNroVenta.setPlaceholder("Nro. Venta");
							txtNroVenta.setFont(new Font("Lucida Grande", Font.BOLD, 14));
							txtNroVenta.setBorder(null);
							txtNroVenta.setBounds(6, 0, 196, 29);
							panelImage_3.add(txtNroVenta);
						}
					}
				}
				panel_2 = new JPanel();
				panel_2.setBounds(6, 48, 744, 170);
				panel.add(panel_2);
				panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "BUSCAR MEDICAMENTO", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(105, 105, 105)));
				panel_2.setLayout(null);
				{
					lblBuscar = new JLabel("MEDICAMENTO:");
					lblBuscar.setBounds(6, 28, 100, 29);
					panel_2.add(lblBuscar);
				}
				{
					panelImage_4 = new PanelImage();
					panelImage_4.setIcon(new ImageIcon(FrmVentasMD.class.getResource("/img/campos.png")));
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
					panelImage_5.setIcon(new ImageIcon(FrmVentasMD.class.getResource("/img/campos.png")));
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
				
				//CargarTabla();
				//inhabilitar();
				//llenarCombo();
				//Date fecha = new Date();
				
				LlenarProductos();
			}
			{
				
			}
		}
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
		if (e.getSource() == cmbProveedor) {
			actionPerformedCmbProveedor(e);
		}
		if (e.getSource() == brnAgregar) {
			actionPerformedBtnSalir(e);
		}
		if (e.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(e);
		}
		if (e.getSource() == txtNroVenta) {
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
		
		
	}
	protected void actionPerformedTxtCodigo(ActionEvent e) {
		txtCodigo.transferFocus();
	}
	protected void actionPerformedTxtTelefono(ActionEvent e) {
		txtNroVenta.transferFocus();
	}
	protected void actionPerformedBtnBuscar(ActionEvent e) {
		
	}
	protected void actionPerformedBtnSalir(ActionEvent e) {
		
	}
	protected void actionPerformedCmbProveedor(ActionEvent e) {
		
	}
	protected void mouseClickedCmbProveedor(MouseEvent e) {
		
	}
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		
	}
}
