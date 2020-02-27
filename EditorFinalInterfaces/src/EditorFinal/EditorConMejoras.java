package EditorFinal;

import java.awt.Color;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.text.DefaultEditorKit;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledEditorKit;

public class EditorConMejoras {
	public static void main(String args[]) {
		MarcoVentana gui = new MarcoVentana(); 
	}
}

class MarcoVentana extends JFrame {
	
	 //Boolean para comprobar si esta en el idioma español o no
	 boolean espanyol = true;
	 
	//Declaramos los componentes que van en el menu
	 //Selector de colores
	 JColorChooser ccColor;
	 //Lector de archivos
	 JFileChooser explorador;
	 //Imagenes
	 ImageIcon espanyaImage, inglaterraImage, abrirImage, guardarImage, cerrarImage, negritaImage, cursivaImage, subrayadoImage, izquierdaImage, centroImage, derechaImage, fullImage;
	 //Barra de menu
	 JMenuBar barraMenu = new JMenuBar();
	 //Menus
	 JMenu mArchivo, mFuente, mEstilo, mParrafo, mTamanyo, mColor, mInfo, mIdioma;
	 //Items
	 JMenuItem miEspanyol, miIngles, miAcerca, miColor, miAbrir, miGuardar, miSalir, miArial, miVerdana, miCourier, miImpact, miIzquierda, miCentro, miDerecha, miFull;
	 JCheckBoxMenuItem miNegrita, miCursiva, miSubrayado;
	 ButtonGroup grupoBotones = new ButtonGroup();
	 JRadioButtonMenuItem mi10, mi14, mi18, mi22;

	 //El JPanel
	 Lamina l = new Lamina(this);
	
	public MarcoVentana() {
		setTitle("Mi editor de fuentes");
		ImageIcon icon = new ImageIcon("imagenes/word.png");

		 setIconImage(icon.getImage());
		 setBounds(100,100,500,400);
		 //setResizable(false);
		 
		 add(l);
		 
		 //Inicializamos todo lo declarado antes
		 
		 explorador = new JFileChooser();
		 
		 espanyaImage = new ImageIcon("imagenes/espanya.png");
		 inglaterraImage = new ImageIcon("imagenes/inglaterra.png");
		 abrirImage = new ImageIcon("imagenes/abrir.png");
		 guardarImage = new ImageIcon("imagenes/guardar.png");
		 cerrarImage = new ImageIcon("imagenes/salir.png");
		 negritaImage = new ImageIcon("imagenes/bold.png");
		 cursivaImage = new ImageIcon("imagenes/italic.png");
		 subrayadoImage = new ImageIcon("imagenes/underline.png");
		 izquierdaImage = new ImageIcon("imagenes/alignleft.png");
		 centroImage = new ImageIcon("imagenes/aligncenter.png");
		 derechaImage = new ImageIcon("imagenes/alignright.png");
		 fullImage = new ImageIcon("imagenes/alignfull.png");
		 
		 mArchivo = new JMenu("Archivo");
		 mFuente = new JMenu("Fuente");
		 mEstilo = new JMenu("Estilo");
		 mParrafo = new JMenu("Párrafo");
		 mTamanyo = new JMenu("Tamaño");
		 mColor = new JMenu("Color");
		 mInfo = new JMenu("Información");
		 mIdioma = new JMenu("Idioma");
		 barraMenu.add(mArchivo);
		 barraMenu.add(mFuente);
		 barraMenu.add(mEstilo);
		 barraMenu.add(mParrafo);
		 barraMenu.add(mTamanyo);
		 barraMenu.add(mColor);
		 barraMenu.add(mInfo);
		 barraMenu.add(mIdioma);
		 
		 miEspanyol = new JMenuItem("Español", espanyaImage);
		 //Atajo de teclado
		 miEspanyol.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, InputEvent.CTRL_DOWN_MASK));
		 miEspanyol.addActionListener(new ActionListener() {

	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	mArchivo.setText (ResourceBundle.getBundle("EditorFinal.etiquetas").getString("etiqueta_menu_archivo"));
	            	miAbrir.setText (ResourceBundle.getBundle("EditorFinal.etiquetas").getString("etiqueta_item_abrir"));
	            	miGuardar.setText (ResourceBundle.getBundle("EditorFinal.etiquetas").getString("etiqueta_item_guardar"));
	            	miSalir.setText (ResourceBundle.getBundle("EditorFinal.etiquetas").getString("etiqueta_item_salir"));
	            	mFuente.setText (ResourceBundle.getBundle("EditorFinal.etiquetas").getString("etiqueta_menu_fuente"));
	            	mEstilo.setText (ResourceBundle.getBundle("EditorFinal.etiquetas").getString("etiqueta_menu_estilo"));
	            	miNegrita.setText (ResourceBundle.getBundle("EditorFinal.etiquetas").getString("etiqueta_item_negrita"));
	            	miCursiva.setText (ResourceBundle.getBundle("EditorFinal.etiquetas").getString("etiqueta_item_cursiva"));
	            	miSubrayado.setText (ResourceBundle.getBundle("EditorFinal.etiquetas").getString("etiqueta_item_subrayado"));
	            	mParrafo.setText (ResourceBundle.getBundle("EditorFinal.etiquetas").getString("etiqueta_menu_parrafo"));
	            	miIzquierda.setText (ResourceBundle.getBundle("EditorFinal.etiquetas").getString("etiqueta_item_izquierda"));
	            	miCentro.setText (ResourceBundle.getBundle("EditorFinal.etiquetas").getString("etiqueta_item_centro"));
	            	miDerecha.setText (ResourceBundle.getBundle("EditorFinal.etiquetas").getString("etiqueta_item_derecha"));
	            	miFull.setText (ResourceBundle.getBundle("EditorFinal.etiquetas").getString("etiqueta_item_full"));
	            	mTamanyo.setText (ResourceBundle.getBundle("EditorFinal.etiquetas").getString("etiqueta_menu_tamanyo"));
	            	mColor.setText (ResourceBundle.getBundle("EditorFinal.etiquetas").getString("etiqueta_menu_color"));
	            	miColor.setText (ResourceBundle.getBundle("EditorFinal.etiquetas").getString("etiqueta_item_color_fuente"));
	            	mInfo.setText (ResourceBundle.getBundle("EditorFinal.etiquetas").getString("etiqueta_menu_info"));
	            	miAcerca.setText (ResourceBundle.getBundle("EditorFinal.etiquetas").getString("etiqueta_item_acerca"));
	            	mIdioma.setText (ResourceBundle.getBundle("EditorFinal.etiquetas").getString("etiqueta_menu_idioma"));
	            	miEspanyol.setText (ResourceBundle.getBundle("EditorFinal.etiquetas").getString("etiqueta_item_espanyol"));
	            	miIngles.setText (ResourceBundle.getBundle("EditorFinal.etiquetas").getString("etiqueta_item_ingles"));
	            	l.lbFuentes.setText (ResourceBundle.getBundle("EditorFinal.etiquetas").getString("etiqueta_label_fuente"));
	            	l.lbTamanyo.setText (ResourceBundle.getBundle("EditorFinal.etiquetas").getString("etiqueta_label_tamanyo"));
	            	l.mcCopiar.setText (ResourceBundle.getBundle("EditorFinal.etiquetas").getString("etiqueta_item_mccopiar"));
	            	l.mcCortar.setText (ResourceBundle.getBundle("EditorFinal.etiquetas").getString("etiqueta_item_mccortar"));
	            	l.mcPegar.setText (ResourceBundle.getBundle("EditorFinal.etiquetas").getString("etiqueta_item_mcpegar"));
	            	l.mcNegrita.setText (ResourceBundle.getBundle("EditorFinal.etiquetas").getString("etiqueta_item_negrita"));
	            	l.mcCursiva.setText (ResourceBundle.getBundle("EditorFinal.etiquetas").getString("etiqueta_item_cursiva"));
	            	l.mcSubrayado.setText (ResourceBundle.getBundle("EditorFinal.etiquetas").getString("etiqueta_item_subrayado"));
	            	l.mcIzquierda.setText (ResourceBundle.getBundle("EditorFinal.etiquetas").getString("etiqueta_item_izquierda"));
	            	l.mcCentro.setText (ResourceBundle.getBundle("EditorFinal.etiquetas").getString("etiqueta_item_centro"));
	            	l.mcDerecha.setText (ResourceBundle.getBundle("EditorFinal.etiquetas").getString("etiqueta_item_derecha"));
	            	l.mcFull.setText (ResourceBundle.getBundle("EditorFinal.etiquetas").getString("etiqueta_item_full"));
	            	l.lbIdioma.setText("Idioma : Español");
	            	
	            }
			});
		 miIngles = new JMenuItem("Inglés", inglaterraImage);
		 miIngles.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.CTRL_DOWN_MASK));
		 miIngles.addActionListener(new ActionListener() {

	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	mArchivo.setText (ResourceBundle.getBundle("EditorFinal.etiquetas_en").getString("etiqueta_menu_archivo"));
	            	miAbrir.setText (ResourceBundle.getBundle("EditorFinal.etiquetas_en").getString("etiqueta_item_abrir"));
	            	miGuardar.setText (ResourceBundle.getBundle("EditorFinal.etiquetas_en").getString("etiqueta_item_guardar"));
	            	miSalir.setText (ResourceBundle.getBundle("EditorFinal.etiquetas_en").getString("etiqueta_item_salir"));
	            	mFuente.setText (ResourceBundle.getBundle("EditorFinal.etiquetas_en").getString("etiqueta_menu_fuente"));
	            	mEstilo.setText (ResourceBundle.getBundle("EditorFinal.etiquetas_en").getString("etiqueta_menu_estilo"));
	            	miNegrita.setText (ResourceBundle.getBundle("EditorFinal.etiquetas_en").getString("etiqueta_item_negrita"));
	            	miCursiva.setText (ResourceBundle.getBundle("EditorFinal.etiquetas_en").getString("etiqueta_item_cursiva"));
	            	miSubrayado.setText (ResourceBundle.getBundle("EditorFinal.etiquetas_en").getString("etiqueta_item_subrayado"));
	            	mParrafo.setText (ResourceBundle.getBundle("EditorFinal.etiquetas_en").getString("etiqueta_menu_parrafo"));
	            	miIzquierda.setText (ResourceBundle.getBundle("EditorFinal.etiquetas_en").getString("etiqueta_item_izquierda"));
	            	miCentro.setText (ResourceBundle.getBundle("EditorFinal.etiquetas_en").getString("etiqueta_item_centro"));
	            	miDerecha.setText (ResourceBundle.getBundle("EditorFinal.etiquetas_en").getString("etiqueta_item_derecha"));
	            	miFull.setText (ResourceBundle.getBundle("EditorFinal.etiquetas_en").getString("etiqueta_item_full"));
	            	mTamanyo.setText (ResourceBundle.getBundle("EditorFinal.etiquetas_en").getString("etiqueta_menu_tamanyo"));
	            	mColor.setText (ResourceBundle.getBundle("EditorFinal.etiquetas_en").getString("etiqueta_menu_color"));
	            	miColor.setText (ResourceBundle.getBundle("EditorFinal.etiquetas_en").getString("etiqueta_item_color_fuente"));
	            	mInfo.setText (ResourceBundle.getBundle("EditorFinal.etiquetas_en").getString("etiqueta_menu_info"));
	            	miAcerca.setText (ResourceBundle.getBundle("EditorFinal.etiquetas_en").getString("etiqueta_item_acerca"));
	            	mIdioma.setText (ResourceBundle.getBundle("EditorFinal.etiquetas_en").getString("etiqueta_menu_idioma"));
	            	miEspanyol.setText (ResourceBundle.getBundle("EditorFinal.etiquetas_en").getString("etiqueta_item_espanyol"));
	            	miIngles.setText (ResourceBundle.getBundle("EditorFinal.etiquetas_en").getString("etiqueta_item_ingles"));
	            	l.lbFuentes.setText (ResourceBundle.getBundle("EditorFinal.etiquetas_en").getString("etiqueta_label_fuente"));
	            	l.lbTamanyo.setText (ResourceBundle.getBundle("EditorFinal.etiquetas_en").getString("etiqueta_label_tamanyo"));
	            	l.mcCopiar.setText (ResourceBundle.getBundle("EditorFinal.etiquetas_en").getString("etiqueta_item_mccopiar"));
	            	l.mcCortar.setText (ResourceBundle.getBundle("EditorFinal.etiquetas_en").getString("etiqueta_item_mccortar"));
	            	l.mcPegar.setText (ResourceBundle.getBundle("EditorFinal.etiquetas_en").getString("etiqueta_item_mcpegar"));
	            	l.mcNegrita.setText (ResourceBundle.getBundle("EditorFinal.etiquetas_en").getString("etiqueta_item_negrita"));
	            	l.mcCursiva.setText (ResourceBundle.getBundle("EditorFinal.etiquetas_en").getString("etiqueta_item_cursiva"));
	            	l.mcSubrayado.setText (ResourceBundle.getBundle("EditorFinal.etiquetas_en").getString("etiqueta_item_subrayado"));
	            	l.mcIzquierda.setText (ResourceBundle.getBundle("EditorFinal.etiquetas_en").getString("etiqueta_item_izquierda"));
	            	l.mcCentro.setText (ResourceBundle.getBundle("EditorFinal.etiquetas_en").getString("etiqueta_item_centro"));
	            	l.mcDerecha.setText (ResourceBundle.getBundle("EditorFinal.etiquetas_en").getString("etiqueta_item_derecha"));
	            	l.mcFull.setText (ResourceBundle.getBundle("EditorFinal.etiquetas_en").getString("etiqueta_item_full"));
	            	l.lbIdioma.setText("Language : English");
	            	
	            }
			});
		 
		 miAcerca = new JMenuItem("Acerca de");
		 miAcerca.addActionListener(new ActionListener() {

	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	JOptionPane.showMessageDialog(null, "Creado por Miguel Ángel Sánchez Soriano");
	            	

	            	
	            }
			});
		 miColor = new JMenuItem("Color de Fuente");
		 miColor.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.CTRL_DOWN_MASK));
		 miColor.addActionListener(new ActionListener() {

	            @Override
	            public void actionPerformed(ActionEvent e) {
	            Color color = ccColor.showDialog(null, "Seleccione un Color", Color.gray);
	               Action colorAction = new StyledEditorKit.ForegroundAction("color", color);
	               colorAction.actionPerformed(e); 
	            }
			});
		 miAbrir = new JMenuItem("Abrir", abrirImage);
		 miAbrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_DOWN_MASK));

		 miAbrir.addActionListener(new ActionListener() {

	            @Override
	            public void actionPerformed(ActionEvent e) {
	     
	       		 if (explorador.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
	       			 String ruta = explorador.getSelectedFile().getPath();
	       			 try {
	       				 BufferedReader reader = new BufferedReader(new FileReader(ruta));
	       				 String textoTotal="";
	       				 String linea = reader.readLine();
	       				 while (linea != null)
	       				 {
	       					 textoTotal = textoTotal + linea + System.getProperty("line.separator");
	       					 linea = reader.readLine();
	       				 }
	       				 l.ta1.setText(textoTotal);
	       				 reader.close();
	       			 }catch (Exception e1) {
	       				 System.out.println(e1.getMessage());
	       			 }
	       		 }
	            }
			});
		 miGuardar = new JMenuItem("Guardar", guardarImage);
		 miGuardar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_DOWN_MASK));
		 miGuardar.addActionListener(new ActionListener() {

	            @Override
	            public void actionPerformed(ActionEvent e) {
	     
	            	if (JFileChooser.APPROVE_OPTION == explorador.showSaveDialog(null))
	            	{
	            		String ruta = explorador.getSelectedFile().getPath();
	            		try
	            		{
	            			PrintWriter writer = new PrintWriter(ruta);
	            			writer.print(l.ta1.getText());
	            			writer.close();
	            		}catch (Exception e2)
	            		{
	            			System.out.println(e2.getMessage());
	            		}
	            	}
	            }
			});
		 miSalir = new JMenuItem("Salir", cerrarImage);
		 miSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK));

		 miSalir.addActionListener(new ActionListener() {

	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	Object[] options = { "Si", "No" };
	            	int n = JOptionPane.showOptionDialog(null, "¿Realmente quiere salir del editor de texto?", "Confirmación de cierre",
	            	JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
	            	null, options, options[0]);
	            	

	            	if (n == JOptionPane.YES_OPTION) {
	            		dispose();
	            	}
	            }
			});
		 miArial = new JMenuItem("Arial");
		 miVerdana = new JMenuItem("Verdana");
		 miCourier = new JMenuItem("Courier");
		 miImpact = new JMenuItem("Impact");
		 miNegrita = new JCheckBoxMenuItem("Negrita", negritaImage);
		 miCursiva = new JCheckBoxMenuItem("Cursiva", cursivaImage);
		 miSubrayado = new JCheckBoxMenuItem("Subrayado", subrayadoImage);
		 miIzquierda = new JMenuItem("Izquierda", izquierdaImage);
		 miCentro = new JMenuItem("Centro", centroImage);
		 miDerecha = new JMenuItem("Derecha", derechaImage);
		 miFull = new JMenuItem("Full", fullImage);
		 mi10 = new JRadioButtonMenuItem("10pt");
		 mi14 = new JRadioButtonMenuItem("14pt");
		 mi18 = new JRadioButtonMenuItem("18pt");
		 mi22 = new JRadioButtonMenuItem("22pt");
		 grupoBotones.add(mi10);
		 grupoBotones.add(mi14);
		 grupoBotones.add(mi18);
		 grupoBotones.add(mi22);
		 mArchivo.add(miAbrir);
		 mArchivo.add(miGuardar);
		 mArchivo.add(miSalir);
		 mFuente.add(miArial);
		 mFuente.add(miCourier);
		 mFuente.add(miImpact);
		 mFuente.add(miVerdana);
		 mEstilo.add(miCursiva);
		 mEstilo.add(miNegrita);
		 mEstilo.add(miSubrayado);
		 mParrafo.add(miIzquierda);
		 mParrafo.add(miCentro);
		 mParrafo.add(miDerecha);
		 mParrafo.add(miFull);
		 mTamanyo.add(mi10);
		 mTamanyo.add(mi14);
		 mTamanyo.add(mi18);
		 mTamanyo.add(mi22);
		 mColor.add(miColor);
		 mInfo.add(miAcerca);
		 mIdioma.add(miEspanyol);
		 mIdioma.add(miIngles);
		 
		 miArial.addActionListener(new StyledEditorKit.FontFamilyAction("arial","Arial"));
		 miVerdana.addActionListener(new StyledEditorKit.FontFamilyAction("verdana","Verdana"));
		 miCourier.addActionListener(new StyledEditorKit.FontFamilyAction("courier","Courier"));
		 miImpact.addActionListener(new StyledEditorKit.FontFamilyAction("impact","Impact"));
		 miNegrita.addActionListener(new StyledEditorKit.BoldAction());
		 miNegrita.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
		 miCursiva.addActionListener(new StyledEditorKit.ItalicAction());
		 miCursiva.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, InputEvent.CTRL_DOWN_MASK));
		 miSubrayado.addActionListener(new StyledEditorKit.UnderlineAction());
		 miSubrayado.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
		 miIzquierda.addActionListener(new StyledEditorKit.AlignmentAction("izq", StyleConstants.ALIGN_LEFT));
		 miIzquierda.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_DOWN_MASK));
		 miCentro.addActionListener(new StyledEditorKit.AlignmentAction("cen", StyleConstants.ALIGN_CENTER));
		 miCentro.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.CTRL_DOWN_MASK));
		 miDerecha.addActionListener(new StyledEditorKit.AlignmentAction("der", StyleConstants.ALIGN_RIGHT));
		 miDerecha.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_DOWN_MASK));
		 miFull.addActionListener(new StyledEditorKit.AlignmentAction("ful", StyleConstants.ALIGN_JUSTIFIED));
		 miFull.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_J, InputEvent.CTRL_DOWN_MASK));
		 mi10.addActionListener(new StyledEditorKit.FontSizeAction("10", 10));
		 mi14.addActionListener(new StyledEditorKit.FontSizeAction("14", 14));
		 mi18.addActionListener(new StyledEditorKit.FontSizeAction("18", 18));
		 mi22.addActionListener(new StyledEditorKit.FontSizeAction("22", 22));
		 
		 setJMenuBar(barraMenu);
		 l.setLayout(null);
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 //Para ponerlo en pantalla completa.
		 setExtendedState(JFrame.MAXIMIZED_BOTH); 
		 setVisible(true);
	}


	
	
}



class Lamina extends JPanel{

	JLabel colorFondo;
	JButton bFondo;
	ImageIcon fondoImage;
	
	int nCaracteres = 0;
	String textoDelPanel;
	
	JLabel numeroCaracteres, lbIdioma;
	
	JColorChooser ccColor;
	
	JFileChooser explorador;
	JOptionPane mensaje;

	JButton bAbrir, bGuardar, bSalir, bColor;

	ImageIcon abrirImage, guardarImage, salirImage, colorImage;
	
	JPopupMenu menuContextual;

	JMenuItem mcCopiar, mcPegar, mcCortar, mcNegrita, mcCursiva, mcSubrayado, mcIzquierda, mcCentro, mcDerecha, mcFull;
	
	//Lista con todas las fuentes del ordenador

	String listaFuentes[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
	
	//Textarea con scroll

	JTextPane ta1 = new JTextPane();

	JScrollPane sp = new JScrollPane(ta1);

	JButton negrita;
	ImageIcon negritaImage;
	
	JButton cursiva;
	ImageIcon cursivaImage;
	//Boton con subrayado
	JButton subrayado;
	ImageIcon subrayadoImage;
	
	JButton izquierda;
	ImageIcon izquierdaImage;
	
	JButton centro;
	ImageIcon centroImage;
	
	JButton derecha;
	ImageIcon derechaImage;
	
	JButton full;
	ImageIcon fullImage;
	
	JLabel lbFuentes;
	JComboBox fuentes = new JComboBox();
	
	JLabel lbTamanyo;
	JComboBox tamanyos;
	ArrayList<Integer> numerosTamanyo = new ArrayList<>();


	public Lamina(JFrame frame) {
		
		colorFondo = new JLabel();
		colorFondo.setLocation(780, 15);
		colorFondo.setSize(100, 25);
		colorFondo.setText("Color fondo");
		add(colorFondo);
		colorImage = new ImageIcon("imagenes/fondo.png");
		bFondo = new JButton(colorImage);
		bFondo.setLocation(850, 15);
		bFondo.setSize(25, 25);
		bFondo.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            Color color = ccColor.showDialog(null, "Seleccione un Color", Color.gray);
               ta1.setBackground(color);
            }
		});
		add(bFondo);
		
		lbIdioma = new JLabel();
		lbIdioma.setLocation(10, 740);
		lbIdioma.setSize(125, 25);
		lbIdioma.setText("Idioma : Español");
		add(lbIdioma);
		textoDelPanel = ta1.getText();
		 numeroCaracteres = new JLabel();
		 numeroCaracteres.setLocation(10, 715);
		 numeroCaracteres.setSize(100, 25);
		 numeroCaracteres.setText(Integer.toString(nCaracteres));
		 add(numeroCaracteres);
	
		ccColor = new JColorChooser();

		colorImage = new ImageIcon("imagenes/color.png");
		bColor = new JButton(colorImage);
		bColor.setLocation(730, 15);
		bColor.setSize(25, 25);
		bColor.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            Color color = ccColor.showDialog(null, "Seleccione un Color", Color.gray);
               Action colorAction = new StyledEditorKit.ForegroundAction("color", color);
               colorAction.actionPerformed(e); 
            }
		});
		add(bColor);
		
		explorador = new JFileChooser();
		mensaje = new JOptionPane();
		
		abrirImage = new ImageIcon("imagenes/abrir.png");
		bAbrir = new JButton(abrirImage);
		bAbrir.setLocation(10, 15);
		bAbrir.setSize(25, 25);
		bAbrir.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
     
       		 if (explorador.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
       			 String ruta = explorador.getSelectedFile().getPath();
       			 try {
       				 BufferedReader reader = new BufferedReader(new FileReader(ruta));
       				 String textoTotal="";
       				 String linea = reader.readLine();
       				 while (linea != null)
       				 {
       					 textoTotal = textoTotal + linea + System.getProperty("line.separator");
       					 linea = reader.readLine();
       				 }
       				 ta1.setText(textoTotal);
       				 reader.close();
       			 }catch (Exception e1) {
       				 System.out.println(e1.getMessage());
       			 }
       		 }
            }
		});
		add(bAbrir);
		
		guardarImage = new ImageIcon("imagenes/guardar.png");
		bGuardar = new JButton(guardarImage);
		bGuardar.setLocation(40, 15);
		bGuardar.setSize(25, 25);
		bGuardar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
     
            	if (JFileChooser.APPROVE_OPTION == explorador.showSaveDialog(null))
            	{
            		String ruta = explorador.getSelectedFile().getPath();
            		try
            		{
            			PrintWriter writer = new PrintWriter(ruta);
            			writer.print(ta1.getText());
            			writer.close();
            		}catch (Exception e2)
            		{
            			System.out.println(e2.getMessage());
            		}
            	}
            }
		});
		add(bGuardar);
		
		salirImage = new ImageIcon("imagenes/salir.png");
		bSalir = new JButton(salirImage);
		bSalir.setLocation(70, 15);
		bSalir.setSize(25, 25);
		//No va.
		bSalir.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	Object[] options = { "Si", "No" };
            	int n = JOptionPane.showOptionDialog(null, "¿Realmente quiere salir del editor de texto?", "Confirmación de cierre",
            	JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
            	null, options, options[0]);
            	

            	if (n == JOptionPane.YES_OPTION) {
            		frame.dispose();
            	}
            }
		});
		add(bSalir);
		
		lbTamanyo = new JLabel("Tamaño");
		lbTamanyo.setLocation(380, 15);
		lbTamanyo.setSize(50, 18);
		add(lbTamanyo);
		numerosTamanyo.add(8);
		numerosTamanyo.add(9);
		numerosTamanyo.add(10);
		numerosTamanyo.add(11);
		numerosTamanyo.add(12);
		numerosTamanyo.add(14);
		numerosTamanyo.add(16);
		numerosTamanyo.add(18);
		numerosTamanyo.add(20);
		numerosTamanyo.add(22);
		numerosTamanyo.add(24);
		numerosTamanyo.add(26);
		numerosTamanyo.add(28);
		numerosTamanyo.add(36);
		numerosTamanyo.add(48);
		numerosTamanyo.add(72);
		tamanyos = new JComboBox(numerosTamanyo.toArray());
		//Para cambiar dinamicamente el tamaño con el combobox
		tamanyos.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               int size = (Integer) tamanyos.getSelectedItem();
               Action fontAction = new StyledEditorKit.FontSizeAction(String
                     .valueOf(size), size);
               fontAction.actionPerformed(e); 
        }
		});
		
		tamanyos.setLocation(430, 17);
		tamanyos.setSize(40, 20);
		add(tamanyos);
		
		mcCopiar = new JMenuItem("Copiar");
		mcCopiar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));
		mcCopiar.addActionListener(new DefaultEditorKit.CopyAction());
		mcPegar = new JMenuItem("Pegar");
		mcPegar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_DOWN_MASK));
		mcPegar.addActionListener(new DefaultEditorKit.PasteAction());
		mcCortar = new JMenuItem("Cortar");
		mcCortar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_DOWN_MASK));
		mcCortar.addActionListener(new DefaultEditorKit.CutAction());
		mcNegrita = new JMenuItem("Negrita", negritaImage);
		mcNegrita.addActionListener(new StyledEditorKit.BoldAction());
		mcCursiva = new JMenuItem("Cursiva", cursivaImage);
		mcCursiva.addActionListener(new StyledEditorKit.ItalicAction());
		mcSubrayado = new JMenuItem("Subrayado", subrayadoImage);
		mcSubrayado.addActionListener(new StyledEditorKit.UnderlineAction());
		mcIzquierda = new JMenuItem("Izquierda", izquierdaImage);
		mcIzquierda.addActionListener(new StyledEditorKit.AlignmentAction("izquierda", StyleConstants.ALIGN_LEFT));
		mcCentro = new JMenuItem("Centro", centroImage);
		mcCentro.addActionListener(new StyledEditorKit.AlignmentAction("centro", StyleConstants.ALIGN_CENTER));
		mcDerecha = new JMenuItem("Derecha", derechaImage);
		mcDerecha.addActionListener(new StyledEditorKit.AlignmentAction("derecha", StyleConstants.ALIGN_RIGHT));
		mcFull = new JMenuItem("Justificado", fullImage);
		mcFull.addActionListener(new StyledEditorKit.AlignmentAction("full", StyleConstants.ALIGN_JUSTIFIED));

		izquierdaImage = new ImageIcon("imagenes/alignleft.png");
		izquierda = new JButton();
		izquierda.setIcon(izquierdaImage);
		izquierda.setLocation(590, 15);
		izquierda.setSize(25, 25);
		izquierda.addActionListener(new StyledEditorKit.AlignmentAction("left", StyleConstants.ALIGN_LEFT));
		add(izquierda);
		
		centroImage = new ImageIcon("imagenes/aligncenter.png");
		centro = new JButton();
		centro.setIcon(centroImage);
		centro.setLocation(620, 15);
		centro.setSize(25, 25);
		centro.addActionListener(new StyledEditorKit.AlignmentAction("center", StyleConstants.ALIGN_CENTER));
		add(centro);
		
		derechaImage = new ImageIcon("imagenes/alignright.png");
		derecha = new JButton();
		derecha.setIcon(derechaImage);
		derecha.setLocation(650, 15);
		derecha.setSize(25, 25);
		derecha.addActionListener(new StyledEditorKit.AlignmentAction("right", StyleConstants.ALIGN_RIGHT));
		add(derecha);
		
		fullImage = new ImageIcon("imagenes/alignfull.png");
		full = new JButton();
		full.setIcon(fullImage);
		full.setLocation(680, 15);
		full.setSize(25, 25);
		full.addActionListener(new StyledEditorKit.AlignmentAction("left", StyleConstants.ALIGN_JUSTIFIED));
		add(full);
		
		sp.setLocation(5, 70);
		//Con 740 (altura) se queda un poco sin cubrir, y con 1590 de ancho tambien se queda igual
		sp.setSize(1590, 650);
		add(sp);
		
		//negritaImage = new ImageIcon(getClass().getResource("/imagenes/bold.png"));
		negritaImage = new ImageIcon("imagenes/bold.png");
		negrita = new JButton();
		negrita.setIcon(negritaImage);
		negrita.setLocation(500, 15);
		negrita.setSize(25, 25);
		//negrita.addChangeListener(new EventoSpinner());
		negrita.addActionListener(new StyledEditorKit.BoldAction());
		
		add(negrita);
		
		cursivaImage = new ImageIcon("imagenes/italic.png");
		cursiva = new JButton();
		cursiva.setIcon(cursivaImage);
		cursiva.setLocation(530, 15);
		cursiva.setSize(25, 25);
		//cursiva.addChangeListener(new EventoSpinner());
		cursiva.addActionListener(new StyledEditorKit.ItalicAction());
		add(cursiva);
		
		subrayadoImage = new ImageIcon("imagenes/underline.png");
		subrayado = new JButton();
		subrayado.setIcon(subrayadoImage);
		subrayado.setLocation(560, 15);
		subrayado.setSize(25, 25);
		subrayado.addActionListener(new StyledEditorKit.UnderlineAction());
		add(subrayado);

		lbFuentes = new JLabel("Fuente");
		lbFuentes.setLocation(105, 15);
		lbFuentes.setSize(50, 18);

		add(lbFuentes);
		fuentes.setModel(new DefaultComboBoxModel(listaFuentes));
		fuentes.setLocation(150, 15);
		fuentes.setSize(220, 20);
		
		fuentes.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               String size = (String) fuentes.getSelectedItem();
               Action fontAction = new StyledEditorKit.FontFamilyAction(String
                     .valueOf(size), size);
               fontAction.actionPerformed(e); 
        }
		});
		
		add(fuentes);
		
		menuContextual = new JPopupMenu();
		menuContextual.add(mcCopiar);
		menuContextual.add(mcPegar);
		menuContextual.add(mcCortar);
		menuContextual.add(mcNegrita);
		menuContextual.add(mcCursiva);
		menuContextual.add(mcSubrayado);
		menuContextual.add(mcIzquierda);
		menuContextual.add(mcCentro);
		menuContextual.add(mcDerecha);
		menuContextual.add(mcFull);
		
		ta1.setComponentPopupMenu(menuContextual);
		ta1.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent ke) {
				if(ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
					nCaracteres = nCaracteres -2;
					numeroCaracteres.setText("Caracteres = " + nCaracteres);
				} 
			}

			@Override
			public void keyReleased(KeyEvent ke) {}

			@Override
			public void keyTyped(KeyEvent ke) {
				if(ke.getKeyCode() != KeyEvent.VK_BACK_SPACE) {
					nCaracteres++;
					numeroCaracteres.setText("Caracteres = " + nCaracteres);
				}

			}
			
		});

	}
}


