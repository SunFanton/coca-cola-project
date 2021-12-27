import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Bienvenida extends JFrame implements ActionListener{
	
	private JTextField textfield1;
	private JLabel label1, label2, label3, label4;
	private JButton boton1;
	/*Variable de acceso publico para que otra interfaz (o clase) que
	no esta en este codigo tenga acceso a ella (en este caso, el nombre
	que ingresa el usuario): */
	public static String texto = "";
	
	public Bienvenida(){
		
		setLayout(null);
		/*La siguiente linea es para que se pueda cerrar la aplicacion
		apretando en la "x" de la ventana: */
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Bienvenido/a");
		getContentPane().setBackground(new Color(255,0,0));
		//Agregar imagen al icono de la ventana:
		setIconImage(new ImageIcon(getClass().getResource("images/icon.png")).getImage());
		
		//Etiqueta 1 con imagen de Coca-Cola
		ImageIcon imagen = new ImageIcon("images/logo-2.png");
		label1 = new JLabel(imagen);
		label1.setBounds(25,15,300,150);
		add(label1);
		
		//Etiqueta 2 de color blanco y tipografia especial
		label2 = new JLabel("Sistema de Control Vacacional");
		label2.setBounds(27,135,300,30);
		/*Si yo quiero que el texto se vea normal, se escribe 0
		Si yo quiero que el texto se vea en negrita, se escribe 1
		Si yo quiero que el texto se vea en cursiva, se escribe 2
		Si yo quiero que el texto se vea en negrita y cursiva, se escribe 3*/
		label2.setFont(new Font("Arial", 3, 20));
		//Y ahora le doy color a las letras:
		label2.setForeground(new Color(255,255,255));
		add(label2);
		
		//Etiqueta 3
		label3 = new JLabel("Ingrese su nombre");
		label3.setBounds(40,212,200,30);
		label3.setFont(new Font("Times New Roman", 1, 16));
		label3.setForeground(new Color(255,255,255));
		add(label3);
		
		//Etiqueta 4
		label4 = new JLabel("©2021 The Coca-Cola Company");
		label4.setBounds(75,375,300,30);
		label4.setFont(new Font("Times New Roman", 1, 14));
		label4.setForeground(new Color(255,255,255));
		add(label4);
		
		textfield1 = new JTextField();
		textfield1.setBounds(40,240,255,25);
		textfield1.setBackground(new Color(224,224,224));
		textfield1.setFont(new Font("Arial", 1, 14));
		textfield1.setForeground(new Color(255,0,0));
		add(textfield1);
		
		boton1 = new JButton("Ingresar");
		boton1.setBounds(120,280,100,30);
		boton1.setBackground(new Color(255,255,255));
		boton1.setFont(new Font("Arial", 1, 14));
		boton1.setForeground(new Color(255,0,0));
		boton1.addActionListener(this);
		add(boton1);
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == boton1){
			/*trim() borra los espacios del nombre*/
			texto = textfield1.getText().trim();
			if(texto.equals("")){
				/*Si el usuario no ingreso nada,
				se le muestra un mensaje de que debe 
				ingresar su nombre*/
				JOptionPane.showMessageDialog(null, "Debes ingresar tu nombre");
			}else {
				/*Si el usuario ingreso un nombre (que es lo que corresponde)
				entonces se lo envia a la siguiente interfaz (que es la de
				terminos y condiciones). Para eso, se copian y pegan a 
				continuacion las lineas de codigo que corresponden a 
				dicha interfaz: */
				
				//Caracteristicas interfaz del archivo Licencia:
				Licencia ventanalicencia = new Licencia();
				ventanalicencia.setBounds(0,0,610,380);
				ventanalicencia.setVisible(true);
				ventanalicencia.setResizable(false);
				ventanalicencia.setLocationRelativeTo(null);
				
				//Y ahora hago que la interfaz de Bienvenida(esta interfaz) ya no se vea mas:
				this.setVisible(false);
			}
		}
	}
	
	public static void main(String args[]){
		Bienvenida ventanabienvenida = new Bienvenida();
		ventanabienvenida.setBounds(0,0,350,450);
		ventanabienvenida.setVisible(true);
		ventanabienvenida.setResizable(false);
		ventanabienvenida.setLocationRelativeTo(null);
	}
}