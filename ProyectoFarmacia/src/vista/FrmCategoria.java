package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
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

public class FrmCategoria extends JFrame {
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
	public JButton btnCancelar;
	public JButton btnSalir;
	public JPanel panel_3;
	public JTable tablaCategoria;
	public JScrollPane scrollPane;
	//Cargar JTable
			public void CargarJTable(){
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
				btnNuevo.setBounds(10, 22, 89, 23);
				panel_2.add(btnNuevo);
			}
			{
				btnEditar = new JButton("Editar");
				btnEditar.setBounds(10, 52, 89, 23);
				panel_2.add(btnEditar);
			}
			{
				btnGuardar = new JButton("Guardar");
				btnGuardar.setBounds(10, 86, 89, 23);
				panel_2.add(btnGuardar);
			}
			{
				btnEliminar = new JButton("Eliminar");
				btnEliminar.setBounds(10, 120, 89, 23);
				panel_2.add(btnEliminar);
			}
			{
				btnCancelar = new JButton("Cancelar");
				btnCancelar.setBounds(10, 154, 89, 23);
				panel_2.add(btnCancelar);
			}
			{
				btnSalir = new JButton("Salir");
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
		MiLista = new ArrayList<>();
		MiLista = objC.Listar();
		CargarJTable();
	}

}
