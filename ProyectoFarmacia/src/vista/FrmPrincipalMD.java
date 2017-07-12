package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Font;
import org.edisoncor.gui.panel.PanelImage;

import entidades.EEmpleado;

import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class FrmPrincipalMD extends JFrame implements ActionListener, MouseListener, KeyListener {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnInicio;
	private JMenu mnNewMenu;
	private JMenu mnCompras;
	private JMenu mnVentas;
	private JMenu mnAcercaDe;
	private JPanel panel;
	private JButton btnCompras;
	private JButton btnVentas;
	private JButton btnCerrarSesin;
	private PanelImage panelImage;
	private JMenuItem mntmClientes;
	private JMenuItem mntmProveedores;
	private JMenuItem mntmProductos;
	private JMenuItem mntmCategora;
	private JMenuItem mntmLaboratorio;
	private JMenuItem mntmUsuarios;
	private JMenuItem mntmCerrarSesin;
	private JMenuItem mntmSalir;
	
	void validar(){
		EEmpleado emp=FrmLogin.emp;
		int cargo = emp.getCod_cargo();
		
		if(cargo == 1){ //Administrador
			
		}else{//vendedor
			
		}
		
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPrincipalMD frame = new FrmPrincipalMD();
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
	public FrmPrincipalMD() {
		setTitle("BIENVENIDO A \"SYSFARMA\"");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 348);
		{
			menuBar = new JMenuBar();
			setJMenuBar(menuBar);
			{
				mnInicio = new JMenu("INICIO");
				mnInicio.setFont(new Font("Lucida Grande", Font.BOLD, 14));
				menuBar.add(mnInicio);
				{
					mntmCerrarSesin = new JMenuItem("CERRAR SESI\u00D3N");
					mnInicio.add(mntmCerrarSesin);
				}
				{
					mntmSalir = new JMenuItem("SALIR");
					mntmSalir.addActionListener(this);
					mnInicio.add(mntmSalir);
				}
			}
			{
				mnNewMenu = new JMenu("MANTENIMIENTO");
				mnNewMenu.setFont(new Font("Lucida Grande", Font.BOLD, 14));
				menuBar.add(mnNewMenu);
				{
					mntmClientes = new JMenuItem("CLIENTES");
					mntmClientes.addActionListener(this);
					mnNewMenu.add(mntmClientes);
				}
				{
					mntmProveedores = new JMenuItem("PROVEEDORES");
					mntmProveedores.addActionListener(this);
					mnNewMenu.add(mntmProveedores);
				}
				{
					mntmProductos = new JMenuItem("PRODUCTOS");
					mntmProductos.addActionListener(this);
					mnNewMenu.add(mntmProductos);
				}
				{
					mntmCategora = new JMenuItem("CATEGOR\u00CDA");
					mntmCategora.addActionListener(this);
					mnNewMenu.add(mntmCategora);
				}
				{
					mntmLaboratorio = new JMenuItem("LABORATORIO");
					mntmLaboratorio.addActionListener(this);
					mnNewMenu.add(mntmLaboratorio);
				}
				{
					mntmUsuarios = new JMenuItem("EMPLEADOS");
					mntmUsuarios.addActionListener(this);
					mnNewMenu.add(mntmUsuarios);
				}
			}
			{
				mnCompras = new JMenu("COMPRAS");
				mnCompras.addMouseListener(this);
				mnCompras.addActionListener(this);
				mnCompras.setFont(new Font("Lucida Grande", Font.BOLD, 14));
				menuBar.add(mnCompras);
			}
			{
				mnVentas = new JMenu("VENTAS");
				mnVentas.addMouseListener(this);
				mnVentas.addKeyListener(this);
				mnVentas.addActionListener(this);
				mnVentas.setFont(new Font("Lucida Grande", Font.BOLD, 14));
				menuBar.add(mnVentas);
			}
			{
				mnAcercaDe = new JMenu("ACERCA DE");
				mnAcercaDe.setFont(new Font("Lucida Grande", Font.BOLD, 14));
				menuBar.add(mnAcercaDe);
			}
		}
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		{
			panel = new JPanel();
			contentPane.add(panel, BorderLayout.WEST);
			panel.setLayout(new GridLayout(3, 3, 0, 0));
			{
				btnVentas = new JButton("VENTAS");
				btnVentas.addActionListener(this);
				btnVentas.setFont(new Font("Lucida Grande", Font.BOLD, 15));
				panel.add(btnVentas);
			}
			{
				btnCompras = new JButton("COMPRAS");
				btnCompras.addActionListener(this);
				btnCompras.setFont(new Font("Lucida Grande", Font.BOLD, 15));
				panel.add(btnCompras);
			}
			{
				btnCerrarSesin = new JButton("CERRAR SESI\u00D3N");
				btnCerrarSesin.setFont(new Font("Lucida Grande", Font.BOLD, 15));
				panel.add(btnCerrarSesin);
			}
			{
				panelImage = new PanelImage();
				panelImage.setIcon(new ImageIcon(FrmPrincipalMD.class.getResource("/img/fondo.jpg")));
				contentPane.add(panelImage, BorderLayout.CENTER);
			}
			
			this.setExtendedState(MAXIMIZED_BOTH);
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmUsuarios) {
			actionPerformedMntmUsuarios(e);
		}
		if (e.getSource() == mnVentas) {
			actionPerformedMnVentas(e);
		}
		if (e.getSource() == mnCompras) {
			actionPerformedMnCompras(e);
		}
		if (e.getSource() == mntmLaboratorio) {
			actionPerformedMntmLaboratorio(e);
		}
		if (e.getSource() == mntmCategora) {
			actionPerformedMntmCategora(e);
		}
		if (e.getSource() == mntmProductos) {
			actionPerformedMntmProductos(e);
		}
		if (e.getSource() == mntmProveedores) {
			actionPerformedMntmProveedores(e);
		}
		if (e.getSource() == mntmClientes) {
			actionPerformedMntmClientes(e);
		}
		if (e.getSource() == btnCompras) {
			actionPerformedBtnCompras(e);
		}
		if (e.getSource() == btnVentas) {
			actionPerformedBtnVentas(e);
		}
		if (e.getSource() == mntmSalir) {
			actionPerformedMntmSalir(e);
		}
	}
	protected void actionPerformedMntmSalir(ActionEvent e) {
		int rpta = JOptionPane.showConfirmDialog(rootPane, "Está seguro de salir", "Salir",
				JOptionPane.YES_NO_OPTION);
		if(rpta == JOptionPane.YES_OPTION){
			System.exit(0);
		}
	}
	protected void actionPerformedBtnVentas(ActionEvent e) {
		FrmVentasMD frm = new FrmVentasMD();
		frm.setVisible(true);
	}
	protected void actionPerformedBtnCompras(ActionEvent e) {
		FrmComprasMD frm = new FrmComprasMD();
		frm.setVisible(true);
	}
	protected void actionPerformedMntmClientes(ActionEvent e) {
		FrmCliente frm = new FrmCliente();
		frm.setVisible(true);
	}
	protected void actionPerformedMntmProveedores(ActionEvent e) {
		FrmProveedorMD frm = new FrmProveedorMD();
		frm.setVisible(true);
	}
	protected void actionPerformedMntmProductos(ActionEvent e) {
		FrmProducto frm = new FrmProducto();
		frm.setVisible(true);
	}
	protected void actionPerformedMntmCategora(ActionEvent e) {
		FrmCategoria frm = new FrmCategoria();
		frm.setVisible(true);
	}
	protected void actionPerformedMntmLaboratorio(ActionEvent e) {
		FrmLaboratorio frm = new FrmLaboratorio();
		frm.setVisible(true);
	}
	protected void actionPerformedMnCompras(ActionEvent e) {
		FrmComprasMD frm = new FrmComprasMD();
		frm.setVisible(true);
		
	}
	protected void actionPerformedMnVentas(ActionEvent e) {
		FrmVentasMD frm = new FrmVentasMD();
		frm.setVisible(true);
	}
	protected void actionPerformedMntmUsuarios(ActionEvent e) {
		FrmEmpleado frm = new FrmEmpleado();
		frm.setVisible(true);
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == mnVentas) {
			mouseClickedMnVentas(e);
		}
		if (e.getSource() == mnCompras) {
			mouseClickedMnCompras(e);
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
	protected void mouseClickedMnCompras(MouseEvent e) {
		FrmComprasMD frm = new FrmComprasMD();
		frm.setVisible(true);
	}
	public void keyPressed(KeyEvent e) {
		if (e.getSource() == mnVentas) {
			keyPressedMnVentas(e);
		}
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
	}
	protected void keyPressedMnVentas(KeyEvent e) {
		/*FrmVentasMD frm = new FrmVentasMD();
		frm.setVisible(true);*/
	}
	protected void mouseClickedMnVentas(MouseEvent e) {
		FrmVentasMD frm = new FrmVentasMD();
		frm.setVisible(true);
	}
}
