package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class FrmProducto extends JFrame {

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
	public JTextField textField_3;
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
	public JButton btnCancelar;
	public JButton btnSalir;
	public JPanel panel_3;
	public JTable tablaProductos;
	public JScrollPane scrollPane;

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
				textField_3 = new JTextField();
				textField_3.setBounds(158, 144, 86, 20);
				panel_1.add(textField_3);
				textField_3.setColumns(10);
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
				btnNuevo.setBounds(10, 24, 89, 23);
				panel_2.add(btnNuevo);
			}
			{
				btnEditar = new JButton("Editar");
				btnEditar.setBounds(10, 55, 89, 23);
				panel_2.add(btnEditar);
			}
			{
				btnGuardar = new JButton("Guardar");
				btnGuardar.setBounds(10, 83, 89, 23);
				panel_2.add(btnGuardar);
			}
			{
				btnEliminar = new JButton("Eliminar");
				btnEliminar.setBounds(10, 111, 89, 23);
				panel_2.add(btnEliminar);
			}
			{
				btnCancelar = new JButton("Cancelar");
				btnCancelar.setBounds(10, 141, 89, 23);
				panel_2.add(btnCancelar);
			}
			{
				btnSalir = new JButton("Salir");
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
	}

}
