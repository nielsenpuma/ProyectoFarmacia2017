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
import controlador.CProveedor;
import entidades.EProveedor;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class FrmProveedorMD extends JFrame implements ActionListener, MouseListener {
	
	private CProveedor ObjC = new CProveedor();
	private ArrayList<EProveedor> MiLista;
	
	private DefaultTableModel MiTabla;
	
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
	private PanelImage panelImage_1;
	private PanelImage panelImage_2;
	private PanelImage panelImage_3;
	private MaterialButtomRectangle btnNuevo;
	private MaterialButtomRectangle btnGuardar;
	private MaterialButtomRectangle btnCancelar;
	private JCTextField txtCodigo;
	private JCTextField txtProveedor;
	private JCTextField txtDireccion;
	private JCTextField txtTelefono;
	private JLabel lblBuscar;
	private PanelImage panelImage_4;
	private JCTextField txtBuscar;
	private MaterialButtomRectangle btnBuscar;
	private MaterialButtomRectangle btnEliminar;
	private MaterialButtomRectangle btnSalir;
	private JTable tablaProveedores;
	private JLabel lblTotalRegistros;
	private JLabel lblTotal;
	private JScrollPane scrollPane;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmProveedorMD frame = new FrmProveedorMD();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
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
		tablaProveedores.setModel(MiTabla);
		lblTotal.setText(""+tablaProveedores.getRowCount());
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
		tablaProveedores.setModel(MiTabla);
		lblTotal.setText(""+tablaProveedores.getRowCount());
	}
	
	void habilitar(){
		txtCodigo.setEnabled(true);
		
		txtProveedor.setEnabled(true);
		txtDireccion.setEnabled(true);
		txtTelefono.setEnabled(true);
		
		btnGuardar.setEnabled(true);
		btnCancelar.setEnabled(true);
		btnEliminar.setEnabled(true);
		
		txtCodigo.setText("");
		txtProveedor.setText("");
		txtDireccion.setText("");
		txtTelefono.setText("");
	}
	
	void inhabilitar(){
		txtCodigo.setEnabled(false);
		
		txtProveedor.setEnabled(false);
		txtDireccion.setEnabled(false);
		txtTelefono.setEnabled(false);
		
		btnGuardar.setEnabled(false);
		btnCancelar.setEnabled(false);
		btnEliminar.setEnabled(false);
		
		txtCodigo.setText("");
		txtProveedor.setText("");
		txtDireccion.setText("");
		txtTelefono.setText("");
	}

	/**
	 * Create the frame.
	 */
	public FrmProveedorMD() {
		setTitle("Proveedores");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 744, 456);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			panel = new JPanel();
			panel.setBackground(new Color(240, 240, 240));
			panel.setBounds(6, 6, 732, 422);
			contentPane.add(panel);
			panel.setLayout(null);
			{
				lblProveedores = new JLabel("Proveedores");
				lblProveedores.setForeground(new Color(105, 105, 105));
				lblProveedores.setHorizontalAlignment(SwingConstants.CENTER);
				lblProveedores.setFont(new Font("Lucida Grande", Font.BOLD, 24));
				lblProveedores.setBounds(6, 6, 720, 30);
				panel.add(lblProveedores);
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Registro de Proveedores", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(105, 105, 105)));
				panel_1.setBounds(6, 48, 329, 368);
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
					lblDireccin = new JLabel("DIRECCI\u00D3N:");
					lblDireccin.setHorizontalAlignment(SwingConstants.RIGHT);
					lblDireccin.setBounds(6, 113, 86, 29);
					panel_1.add(lblDireccin);
				}
				{
					lblTelfono = new JLabel("TEL\u00C9FONO:");
					lblTelfono.setHorizontalAlignment(SwingConstants.RIGHT);
					lblTelfono.setBounds(6, 158, 86, 27);
					panel_1.add(lblTelfono);
				}
				{
					panelImage = new PanelImage();
					panelImage.setBorder(null);
					panelImage.setIcon(new ImageIcon(FrmProveedorMD.class.getResource("/img/campos.png")));
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
					panelImage_1 = new PanelImage();
					panelImage_1.setIcon(new ImageIcon(FrmProveedorMD.class.getResource("/img/campos.png")));
					panelImage_1.setBorder(null);
					panelImage_1.setBounds(104, 72, 208, 29);
					panel_1.add(panelImage_1);
					panelImage_1.setLayout(null);
					{
						txtProveedor = new JCTextField();
						txtProveedor.addActionListener(this);
						txtProveedor.setPlaceholder("Nombre y/o Raz.");
						txtProveedor.setFont(new Font("Lucida Grande", Font.BOLD, 14));
						txtProveedor.setBorder(null);
						txtProveedor.setBounds(6, 0, 196, 29);
						panelImage_1.add(txtProveedor);
					}
				}
				{
					panelImage_2 = new PanelImage();
					panelImage_2.setIcon(new ImageIcon(FrmProveedorMD.class.getResource("/img/campos.png")));
					panelImage_2.setBorder(null);
					panelImage_2.setBounds(104, 113, 208, 29);
					panel_1.add(panelImage_2);
					panelImage_2.setLayout(null);
					{
						txtDireccion = new JCTextField();
						txtDireccion.addActionListener(this);
						txtDireccion.setPlaceholder("Direcci\u00F3n");
						txtDireccion.setFont(new Font("Lucida Grande", Font.BOLD, 14));
						txtDireccion.setBorder(null);
						txtDireccion.setBounds(6, 0, 196, 29);
						panelImage_2.add(txtDireccion);
					}
				}
				{
					panelImage_3 = new PanelImage();
					panelImage_3.setIcon(new ImageIcon(FrmProveedorMD.class.getResource("/img/campos.png")));
					panelImage_3.setBorder(null);
					panelImage_3.setBounds(104, 156, 208, 29);
					panel_1.add(panelImage_3);
					panelImage_3.setLayout(null);
					{
						txtTelefono = new JCTextField();
						txtTelefono.addActionListener(this);
						txtTelefono.setPlaceholder("Tel\u00E9fono");
						txtTelefono.setFont(new Font("Lucida Grande", Font.BOLD, 14));
						txtTelefono.setBorder(null);
						txtTelefono.setBounds(6, 0, 196, 29);
						panelImage_3.add(txtTelefono);
					}
				}
				{
					btnNuevo = new MaterialButtomRectangle();
					btnNuevo.addActionListener(this);
					btnNuevo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					btnNuevo.setForeground(new Color(255, 255, 255));
					btnNuevo.setBackground(new Color(0, 153, 204));
					btnNuevo.setText("NUEVO");
					btnNuevo.setBounds(6, 244, 150, 40);
					panel_1.add(btnNuevo);
				}
				{
					btnGuardar = new MaterialButtomRectangle();
					btnGuardar.addActionListener(this);
					btnGuardar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					btnGuardar.setText("GUARDAR");
					btnGuardar.setForeground(Color.WHITE);
					btnGuardar.setBackground(new Color(0, 153, 204));
					btnGuardar.setBounds(162, 244, 150, 40);
					panel_1.add(btnGuardar);
				}
				{
					btnCancelar = new MaterialButtomRectangle();
					btnCancelar.addActionListener(this);
					btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					btnCancelar.setText("CANCELAR");
					btnCancelar.setForeground(Color.WHITE);
					btnCancelar.setBackground(new Color(0, 153, 204));
					btnCancelar.setBounds(87, 296, 150, 40);
					panel_1.add(btnCancelar);
				}
			}
			{
				panel_2 = new JPanel();
				panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Listado de proveedores", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(105, 105, 105)));
				panel_2.setBounds(338, 48, 388, 368);
				panel.add(panel_2);
				panel_2.setLayout(null);
				{
					lblBuscar = new JLabel("BUSCAR:");
					lblBuscar.setBounds(6, 28, 100, 29);
					panel_2.add(lblBuscar);
				}
				{
					panelImage_4 = new PanelImage();
					panelImage_4.setIcon(new ImageIcon(FrmProveedorMD.class.getResource("/img/campos.png")));
					panelImage_4.setLayout(null);
					panelImage_4.setBorder(null);
					panelImage_4.setBounds(78, 28, 190, 29);
					panel_2.add(panelImage_4);
					{
						txtBuscar = new JCTextField();
						txtBuscar.setPlaceholder("Nombre y/o Raz.");
						txtBuscar.setFont(new Font("Lucida Grande", Font.BOLD, 14));
						txtBuscar.setBorder(null);
						txtBuscar.setBounds(6, 0, 184, 29);
						panelImage_4.add(txtBuscar);
					}
				}
				{
					btnBuscar = new MaterialButtomRectangle();
					btnBuscar.addActionListener(this);
					btnBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					btnBuscar.setText("BUSCAR");
					btnBuscar.setForeground(Color.WHITE);
					btnBuscar.setBackground(new Color(0, 153, 204));
					btnBuscar.setBounds(273, 23, 109, 40);
					panel_2.add(btnBuscar);
				}
				{
					btnEliminar = new MaterialButtomRectangle();
					btnEliminar.addActionListener(this);
					btnEliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					btnEliminar.setText("ELIMINAR");
					btnEliminar.setForeground(Color.WHITE);
					btnEliminar.setBackground(new Color(0, 153, 204));
					btnEliminar.setBounds(6, 69, 150, 40);
					panel_2.add(btnEliminar);
				}
				{
					btnSalir = new MaterialButtomRectangle();
					btnSalir.addActionListener(this);
					btnSalir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					btnSalir.setText("SALIR");
					btnSalir.setForeground(Color.WHITE);
					btnSalir.setBackground(new Color(0, 153, 204));
					btnSalir.setBounds(232, 69, 150, 40);
					panel_2.add(btnSalir);
				}
				{
					scrollPane = new JScrollPane();
					scrollPane.setBounds(6, 121, 376, 190);
					panel_2.add(scrollPane);
					{
						tablaProveedores = new JTable();
						tablaProveedores.addMouseListener(this);
						tablaProveedores.setSelectionBackground(new Color(135, 206, 235));
						tablaProveedores.setBackground(new Color(255, 255, 255));
						tablaProveedores.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
						tablaProveedores.getTableHeader().setPreferredSize(new java.awt.Dimension(0, 30));
						tablaProveedores.getTableHeader().setFont(new Font("Lucida Grande", Font.BOLD, 14));
						
						scrollPane.setViewportView(tablaProveedores);
					}
				}
				{
					lblTotalRegistros = new JLabel("TOTAL REGISTROS:");
					lblTotalRegistros.setBounds(6, 317, 138, 29);
					panel_2.add(lblTotalRegistros);
				}
				{
					lblTotal = new JLabel("0");
					lblTotal.setHorizontalAlignment(SwingConstants.CENTER);
					lblTotal.setFont(new Font("Lucida Grande", Font.BOLD, 13));
					lblTotal.setBounds(137, 317, 40, 29);
					panel_2.add(lblTotal);
				}
				
				CargarTabla();
				inhabilitar();
			}
			{
				
			}
		}
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnSalir) {
			actionPerformedBtnSalir(e);
		}
		if (e.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(e);
		}
		if (e.getSource() == txtTelefono) {
			actionPerformedTxtTelefono(e);
		}
		if (e.getSource() == txtDireccion) {
			actionPerformedTxtDireccion(e);
		}
		if (e.getSource() == txtProveedor) {
			actionPerformedTxtProveedor(e);
		}
		if (e.getSource() == txtCodigo) {
			actionPerformedTxtCodigo(e);
		}
		if (e.getSource() == btnGuardar) {
			actionPerformedBtnGuardar(e);
		}
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
		if (e.getSource() == btnNuevo) {
			actionPerformedBtnNuevo(e);
		}
	}
	protected void actionPerformedBtnNuevo(ActionEvent e) {
		habilitar();
		btnGuardar.setText("Guardar");
		accion = "guardar";
	}
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		inhabilitar();
	}
	protected void actionPerformedBtnGuardar(ActionEvent e) {
		if(txtCodigo.getText().length()==0){
			JOptionPane.showConfirmDialog(rootPane, "Debes ingresar codigo");
			txtCodigo.requestFocus();
			return;
		}
		if(txtProveedor.getText().length()==0){
			JOptionPane.showConfirmDialog(rootPane, "Debes ingresar proveedor");
			txtProveedor.requestFocus();
			return;
		}
		if(txtDireccion.getText().length()==0){
			JOptionPane.showConfirmDialog(rootPane, "Debes ingresar dirección");
			txtDireccion.requestFocus();
			return;
		}
		if(txtTelefono.getText().length()==0){
			JOptionPane.showConfirmDialog(rootPane, "Debes ingresar teléfono");
			txtTelefono.requestFocus();
			return;
		}
		
		EProveedor obj = new EProveedor();
		
		obj.setCod_prv(txtCodigo.getText());
		obj.setRaz_soc_prv(txtProveedor.getText());
		obj.setDir_prv(txtDireccion.getText());
		obj.setTlf(txtTelefono.getText());
		
		if(accion.equals("guardar")){
			ObjC.Insertar(obj);
			JOptionPane.showMessageDialog(rootPane, "Registro completado satisfactoriamente");
			CargarTabla();
			inhabilitar();
		}
		else if(accion.equalsIgnoreCase("editar")){
			int rpta = JOptionPane.showConfirmDialog(rootPane, "¿Está seguro de guardar al edición?", "Edición",
					JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			if(rpta==JOptionPane.YES_OPTION){
				ObjC.Modificar(obj);
				JOptionPane.showMessageDialog(rootPane, "Edición completado satisfactoriamente");
				CargarTabla();
				inhabilitar();
			}
		}
		
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tablaProveedores) {
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
		btnGuardar.setText("EDITAR");
		
		habilitar();
		btnEliminar.setEnabled(true);
		txtCodigo.setEnabled(false);
		accion = "editar";
		
		int fila = tablaProveedores.getSelectedRow();
		
		txtCodigo.setText(tablaProveedores.getValueAt(fila, 0).toString());
		txtProveedor.setText(tablaProveedores.getValueAt(fila, 1).toString());
		txtDireccion.setText(tablaProveedores.getValueAt(fila, 2).toString());
		txtTelefono.setText(tablaProveedores.getValueAt(fila, 3).toString());
	}
	protected void actionPerformedTxtCodigo(ActionEvent e) {
		txtCodigo.transferFocus();
	}
	protected void actionPerformedTxtProveedor(ActionEvent e) {
		txtProveedor.transferFocus();
	}
	protected void actionPerformedTxtDireccion(ActionEvent e) {
		txtDireccion.transferFocus();
	}
	protected void actionPerformedTxtTelefono(ActionEvent e) {
		txtTelefono.transferFocus();
	}
	protected void actionPerformedBtnBuscar(ActionEvent e) {
		if(txtBuscar.getText().length()!=0){
			
			FiltrarTabla("%"+txtBuscar.getText()+"%");
		
			
		}else{
			CargarTabla();
		}
	}
	protected void actionPerformedBtnSalir(ActionEvent e) {
		this.dispose();
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		int rpta = JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar el registro?","Eliminar",JOptionPane.YES_NO_OPTION,
				JOptionPane.WARNING_MESSAGE);
		
		if(rpta==JOptionPane.YES_OPTION){
			ObjC.Eliminar(txtCodigo.getText());
			CargarTabla();
		}else{
			inhabilitar();
		}
		
	}
}
