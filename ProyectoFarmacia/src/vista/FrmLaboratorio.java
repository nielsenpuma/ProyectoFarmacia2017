package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
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

public class FrmLaboratorio extends JFrame {
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
	public JButton btnCancelar;
	public JButton btnSalir;
	public JPanel panel_3;
	public JTable tablaLaboratorio;
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
				filas[i][0] = MiLista.get(i).getCod_lab();
				filas[i][1] = MiLista.get(i).getDesc_lab();
				MiTabla.addRow(filas[i]);
			}
			tablaLaboratorio.setModel(MiTabla);
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
				btnNuevo.setBounds(10, 17, 89, 23);
				panel_2.add(btnNuevo);
			}
			{
				btnEditar = new JButton("Editar");
				btnEditar.setBounds(11, 48, 89, 23);
				panel_2.add(btnEditar);
			}
			{
				btnGuardar = new JButton("Guardar");
				btnGuardar.setBounds(11, 77, 89, 23);
				panel_2.add(btnGuardar);
			}
			{
				btnEliminar = new JButton("Eliminar");
				btnEliminar.setBounds(12, 107, 89, 23);
				panel_2.add(btnEliminar);
			}
			{
				btnCancelar = new JButton("Cancelar");
				btnCancelar.setBounds(13, 137, 89, 23);
				panel_2.add(btnCancelar);
			}
			{
				btnSalir = new JButton("Salir");
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
				MiLista = new ArrayList<>();
				MiLista = objC.Listar();
				CargarJTable();
	}
}
