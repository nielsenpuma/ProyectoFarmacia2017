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

import controlador.CCategoria;
import entidades.ECategoria;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmCategoria extends JFrame implements ActionListener {
	//atributos
	private CCategoria objC = new CCategoria();
	private ArrayList<ECategoria> MiLista;
	private DefaultTableModel MiTabla;

	private JPanel contentPane;
	public JPanel panel;
	public JLabel lblCategoria;
	public JPanel panel_1;
	public JLabel lblCodigoCategoria;
	public JLabel lblDescripcion;
	public JTextField txtCodCat;
	public JTextField txtDescCat;
	public JPanel panel_2;
	public JButton btnNuevo;
	public JButton btnEditar;
	public JButton btnGuardar;
	public JButton btnEliminar;
	public JButton btnBuscar;
	public JButton btnSalir;
	public JPanel panel_3;
	public JTable tablaCategoria;
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
					filas[i][0] = MiLista.get(i).getCod_cat();
					filas[i][1] = MiLista.get(i).getDesc_cat();
					MiTabla.addRow(filas[i]);
				}
				tablaCategoria.setModel(MiTabla);
			}
			//limpiar cajas
			public void Limpiar(){
				txtCodCat.setText("");
				txtDescCat.setText("");
			}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCategoria frame = new FrmCategoria();
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
	public FrmCategoria() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 474);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			panel = new JPanel();
			panel.setBounds(0, 0, 574, 51);
			contentPane.add(panel);
			panel.setLayout(null);
			{
				lblCategoria = new JLabel("Categoria");
				lblCategoria.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblCategoria.setBounds(232, 11, 99, 29);
				panel.add(lblCategoria);
			}
		}
		{
			panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(null, "Datos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_1.setBounds(10, 62, 374, 146);
			contentPane.add(panel_1);
			panel_1.setLayout(null);
			{
				lblCodigoCategoria = new JLabel("Codigo Categoria:");
				lblCodigoCategoria.setBounds(10, 26, 144, 14);
				panel_1.add(lblCodigoCategoria);
			}
			{
				lblDescripcion = new JLabel("Descripcion:");
				lblDescripcion.setBounds(10, 63, 144, 14);
				panel_1.add(lblDescripcion);
			}
			{
				txtCodCat = new JTextField();
				txtCodCat.setBounds(164, 23, 86, 20);
				panel_1.add(txtCodCat);
				txtCodCat.setColumns(10);
			}
			{
				txtDescCat = new JTextField();
				txtDescCat.setBounds(164, 60, 200, 20);
				panel_1.add(txtDescCat);
				txtDescCat.setColumns(10);
			}
		}
		{
			panel_2 = new JPanel();
			panel_2.setBorder(new TitledBorder(null, "Mantenimiento", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_2.setBounds(394, 62, 170, 216);
			contentPane.add(panel_2);
			panel_2.setLayout(null);
			{
				btnNuevo = new JButton("Nuevo");
				btnNuevo.addActionListener(this);
				btnNuevo.setBounds(10, 22, 89, 23);
				panel_2.add(btnNuevo);
			}
			{
				btnEditar = new JButton("Editar");
				btnEditar.addActionListener(this);
				btnEditar.setBounds(10, 52, 89, 23);
				panel_2.add(btnEditar);
			}
			{
				btnGuardar = new JButton("Guardar");
				btnGuardar.addActionListener(this);
				btnGuardar.setBounds(10, 86, 89, 23);
				panel_2.add(btnGuardar);
			}
			{
				btnEliminar = new JButton("Eliminar");
				btnEliminar.addActionListener(this);
				btnEliminar.setBounds(10, 120, 89, 23);
				panel_2.add(btnEliminar);
			}
			{
				btnBuscar = new JButton("Buscar");
				btnBuscar.addActionListener(this);
				btnBuscar.setBounds(10, 154, 89, 23);
				panel_2.add(btnBuscar);
			}
			{
				btnSalir = new JButton("Salir");
				btnSalir.addActionListener(this);
				btnSalir.setBounds(10, 182, 89, 23);
				panel_2.add(btnSalir);
			}
		}
		{
			panel_3 = new JPanel();
			panel_3.setBorder(new TitledBorder(null, "Lista Categoria", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_3.setBounds(10, 280, 554, 144);
			contentPane.add(panel_3);
			panel_3.setLayout(null);
			{
				scrollPane = new JScrollPane();
				scrollPane.setBounds(10, 22, 534, 111);
				panel_3.add(scrollPane);
				{
					tablaCategoria = new JTable();
					scrollPane.setViewportView(tablaCategoria);
				}
			}
		}
		//cargando al inicio los datos en la tabla
		CargarJTable();
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
		Limpiar();
	}
	protected void do_btnEditar_actionPerformed(ActionEvent arg0) {
		ECategoria obj = new ECategoria(
				Integer.parseInt(txtCodCat.getText()),
				txtDescCat.getText()
				);
		objC.Modificar(obj);
		CargarJTable();
	}
	protected void do_btnGuardar_actionPerformed(ActionEvent arg0) {
		ECategoria obj = new ECategoria(
				Integer.parseInt(txtCodCat.getText()),
				txtDescCat.getText()
				);
		objC.Insertar(obj);
		CargarJTable();
	}
	protected void do_btnEliminar_actionPerformed(ActionEvent arg0) {
		int Id = Integer.parseInt(txtCodCat.getText());
		objC.Eliminar(Id);
		CargarJTable();
	}
	protected void do_btnBuscar_actionPerformed(ActionEvent arg0) {
		try {
			int Id = Integer.parseInt(txtCodCat.getText());
			objC.Buscar(Id);
			txtCodCat.setText(objC.Buscar(Id).getCod_cat()+"");
			txtDescCat.setText(objC.Buscar(Id).getDesc_cat());
			// TODO: handle exception
		} catch (Exception e) {
			mensaje("El codigo no existe");
		}
	}
	protected void do_btnSalir_actionPerformed(ActionEvent arg0) {
		dispose();
	}
	//MENSAJE
  	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}
	
}
