package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import controlador.CLaboratorio;
import entidades.ELaboratorio;

import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmLaboratorio extends JFrame implements ActionListener {
	//campos o atributos
	private CLaboratorio objC=new CLaboratorio();
	private ArrayList<ELaboratorio> MiLista;
	private DefaultTableModel MiTabla;

	private JPanel contentPane;
	public JPanel panel;
	public JLabel lblLaboratorio;
	public JPanel panel_1;
	public JLabel lblNewLabel;
	public JLabel lblDescripcion;
	public JTextField txtCodLab;
	public JTextField txtDescLab;
	public JPanel panel_2;
	public JButton btnNuevo;
	public JButton btnEditar;
	public JButton btnGuardar;
	public JButton btnEliminar;
	public JButton btnBuscar;
	public JButton btnSalir;
	public JPanel panel_3;
	public JTable tablaLaboratorio;
	public JScrollPane scrollPane;
	
	//Cargar JTable
		public void CargarJTable(){
			MiLista = new ArrayList<>();
			MiLista = objC.Listar();
			MiTabla = new DefaultTableModel();
			String columnas[]={"Codigo", "Descripcion"};
			for (String obj : columnas) {
				MiTabla.addColumn(obj);
			}
			Object filas[][] = new Object[MiLista.size()][2];
			for (int i = 0; i < MiLista.size(); i++) {
				filas[i][0] = MiLista.get(i).getCod_lab();
				filas[i][1] = MiLista.get(i).getDesc_lab();
				MiTabla.addRow(filas[i]);
			}
			tablaLaboratorio.setModel(MiTabla);
		}
		//Limpíar cajas
		public void LimpiarCajas(){
			txtCodLab.setText("");
			txtDescLab.setText("");
		}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmLaboratorio frame = new FrmLaboratorio();
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
	public FrmLaboratorio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 562, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			panel = new JPanel();
			panel.setBounds(0, 0, 543, 35);
			contentPane.add(panel);
			panel.setLayout(null);
			{
				lblLaboratorio = new JLabel("Laboratorio");
				lblLaboratorio.setBounds(228, 9, 81, 17);
				lblLaboratorio.setFont(new Font("Tahoma", Font.BOLD, 14));
				panel.add(lblLaboratorio);
			}
		}
		{
			panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(null, "Datos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_1.setBounds(10, 46, 357, 110);
			contentPane.add(panel_1);
			panel_1.setLayout(null);
			{
				lblNewLabel = new JLabel("Codigo Laboratorio:");
				lblNewLabel.setBounds(10, 25, 126, 14);
				panel_1.add(lblNewLabel);
			}
			{
				lblDescripcion = new JLabel("Descripcion:");
				lblDescripcion.setBounds(10, 56, 126, 14);
				panel_1.add(lblDescripcion);
			}
			{
				txtCodLab = new JTextField();
				txtCodLab.setBounds(167, 22, 86, 20);
				panel_1.add(txtCodLab);
				txtCodLab.setColumns(10);
			}
			{
				txtDescLab = new JTextField();
				txtDescLab.setBounds(167, 53, 178, 20);
				panel_1.add(txtDescLab);
				txtDescLab.setColumns(10);
			}
		}
		{
			panel_2 = new JPanel();
			panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Mantenimiento", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel_2.setBounds(373, 52, 167, 203);
			contentPane.add(panel_2);
			panel_2.setLayout(null);
			{
				btnNuevo = new JButton("Nuevo");
				btnNuevo.addActionListener(this);
				btnNuevo.setBounds(10, 17, 89, 23);
				panel_2.add(btnNuevo);
			}
			{
				btnEditar = new JButton("Editar");
				btnEditar.addActionListener(this);
				btnEditar.setBounds(11, 48, 89, 23);
				panel_2.add(btnEditar);
			}
			{
				btnGuardar = new JButton("Guardar");
				btnGuardar.addActionListener(this);
				btnGuardar.setBounds(11, 77, 89, 23);
				panel_2.add(btnGuardar);
			}
			{
				btnEliminar = new JButton("Eliminar");
				btnEliminar.addActionListener(this);
				btnEliminar.setBounds(12, 107, 89, 23);
				panel_2.add(btnEliminar);
			}
			{
				btnBuscar = new JButton("Buscar");
				btnBuscar.addActionListener(this);
				btnBuscar.setBounds(13, 137, 89, 23);
				panel_2.add(btnBuscar);
			}
			{
				btnSalir = new JButton("Salir");
				btnSalir.addActionListener(this);
				btnSalir.setBounds(14, 164, 89, 23);
				panel_2.add(btnSalir);
			}
		}
		{
			panel_3 = new JPanel();
			panel_3.setBorder(new TitledBorder(null, "Listado Laboratorio", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_3.setBounds(4, 258, 536, 165);
			contentPane.add(panel_3);
			panel_3.setLayout(null);
			{
				scrollPane = new JScrollPane();
				scrollPane.setBounds(8, 19, 519, 136);
				panel_3.add(scrollPane);
				{
					tablaLaboratorio = new JTable();
					scrollPane.setViewportView(tablaLaboratorio);
				}
			}
		}
		//cargando al inicio los datos en la tabla
				CargarJTable();
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnBuscar) {
			do_btnBuscar_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnSalir) {
			do_btnSalir_actionPerformed(arg0);
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
		LimpiarCajas();
	}
	protected void do_btnBuscar_actionPerformed(ActionEvent arg0) {
		try {
			int cod=Integer.parseInt(txtCodLab.getText());
			objC.Buscar(cod);
			txtCodLab.setText(objC.Buscar(cod).getCod_lab()+"");
			txtDescLab.setText(objC.Buscar(cod).getDesc_lab());	
		} catch (Exception e) {
			// TODO: handle exception
			mensaje("No existe el codigo");
		}
					
	}
	protected void do_btnEditar_actionPerformed(ActionEvent arg0) {
	ELaboratorio obj =new ELaboratorio(
				Integer.parseInt(txtCodLab.getText()),
				txtDescLab.getText()
				);
		objC.Modificar(obj);
		CargarJTable();
	}
	protected void do_btnGuardar_actionPerformed(ActionEvent arg0) {
		ELaboratorio obj = new ELaboratorio(
				Integer.parseInt(txtCodLab.getText()),
				txtDescLab.getText()
				);
		objC.Insertar(obj);
		CargarJTable();
	}
	protected void do_btnEliminar_actionPerformed(ActionEvent arg0) {
		int id=Integer.parseInt(txtCodLab.getText());
		objC.Eliminar(id);
		CargarJTable();
	}
	protected void do_btnSalir_actionPerformed(ActionEvent arg0) {
		dispose();
	}
	//MENSAJE
  	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}


}
