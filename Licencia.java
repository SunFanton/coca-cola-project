import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class Licencia extends JFrame implements ActionListener, ChangeListener{
	
	private JLabel label1, label2;
	private JCheckBox check1;
	private JButton boton1, boton2;
	private JScrollPane scrollpane1;
	private JTextArea textarea1;
	String nombre = "";
	
	public Licencia(){
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Licencia de uso");
		setIconImage(new ImageIcon(getClass().getResource("images/icon.png")).getImage());
		//Recuperamos lo que tiene la variable del nombre de la interfaz Bienvenida:
		/*Como quiero recuperar una variable que esta en la clase Bienvenida,
		tengo que crear un objeto con esa clase que guarde
		lo que tiene la variable "texto" en Bienvenida*/
		Bienvenida ventanaBienvenida = new Bienvenida();
		nombre = ventanaBienvenida.texto;
		
		label1 = new JLabel("TÉRMINOS Y CONDICIONES");
		label1.setBounds(210,5,200,30);
		label1.setFont(new Font("Times New Roman", 1, 14));
		label1.setForeground(new Color(150,0,0));
		add(label1);
		
		textarea1 = new JTextArea();
		//Para que el usuario no pueda modificar el texto:
		textarea1.setEditable(false);
		textarea1.setFont(new Font("Times New Roman",0,9));
		textarea1.setText("\n\n          TÉRMINOS Y CONDICIONES" + 
				"\n\n          A.  PROHIBIDO SU VENTA Y/O DISTRIBUCION SIN AUTORIZACION DE PHOENIX DEVS." + 
				"\n          B.  PROHIBIDA LA ALTERACION DEL CODIGO FUENTE O EL DISEÑO DE LAS INTERFACES GRAFICAS." + 
				"\n          C.  PHOENIX DEVS NO SE HACE RESPONSABLE DEL MAL USO DE ESTE SOFTWARE." + 
				"\n\n          LOS ACUERDOS LEGALES EXPUESTOS A CONTINUACION RIGEN EL USO QUE USTED HAGA DE ESTE SOFTWARE" +
				"\n\n          PHOENIX DEVS NO SE RESPONSABILIZA DEL USO QUE USTED" +
				"\n          HAGA CON ESTE SOFTWARE Y SUS SERVICIOS. PARA ACEPTAR ESTOS TERMINOS HAGA CLICK EN (ACEPTO)" +
				"\n          SI USTED NO ESTA DE ACUERDO, HAGA CLICK EN (NO ACEPTO) Y NO UTILICE ESTE SOFTWARE" +
				"\n\n          PARA MAS INFORMACION SOBRE NUESTROS SERVICIOS, VISITE NUESTRA PAGINA OFICIAL DE PHOENIX DEVS");
		textarea1.setFont(new Font("Times New Roman",1,9));
		textarea1.setForeground(new Color(50,0,0));
		scrollpane1 = new JScrollPane(textarea1);
		scrollpane1.setBounds(10,40,575,200);
		add(scrollpane1);
		
		check1 = new JCheckBox("Yo " + nombre + " Acepto");
		check1.setBounds(10,250,300,30);
		check1.setFont(new Font("Times New Roman", 1, 14));
		check1.setForeground(new Color(0,0,0));
		check1.addChangeListener(this);
		add(check1);
		
		boton1 = new JButton("Continuar");
		boton1.setBounds(10,290,100,30);
		boton1.setBackground(new Color(255,255,255));
		boton1.setFont(new Font("Arial",1,12));
		boton1.setForeground(new Color(255,0,0));
		boton1.addActionListener(this);
		boton1.setEnabled(false);
		add(boton1);
		
		boton2 = new JButton("No Acepto");
		boton2.setBounds(120,290,100,30);
		boton2.setBackground(new Color(255,255,255));
		boton2.setFont(new Font("Arial",1,12));
		boton2.setForeground(new Color(255,0,0));
		boton2.addActionListener(this);
		boton2.setEnabled(true);
		add(boton2);
		
		ImageIcon imagen = new ImageIcon("images/logo-1.png");
		label2 = new JLabel(imagen);
		label2.setBounds(315,139,300,300);
		add(label2);
	}
	
	public void stateChanged(ChangeEvent e){
		if(check1.isSelected() == true){
			boton1.setEnabled(true);
			boton2.setEnabled(false);
		}else {
			boton1.setEnabled(false);
			boton2.setEnabled(true);
		}
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == boton1){
			Principal ventanaPrincipal = new Principal();
			ventanaPrincipal.setBounds(0,0,640,535);
			ventanaPrincipal.setVisible(true);
			ventanaPrincipal.setResizable(false);
			ventanaPrincipal.setLocationRelativeTo(null);
			this.setVisible(false);
		}else if(e.getSource() == boton2){
			Bienvenida ventanabienvenida = new Bienvenida();
			ventanabienvenida.setBounds(0,0,350,450);
			ventanabienvenida.setVisible(true);
			ventanabienvenida.setResizable(false);
			ventanabienvenida.setLocationRelativeTo(null);
			this.setVisible(false);
		}
	}
	
	public static void main(String args[]){
		Licencia ventanalicencia = new Licencia();
		ventanalicencia.setBounds(0,0,610,380);
		ventanalicencia.setVisible(true);
		ventanalicencia.setResizable(false);
		ventanalicencia.setLocationRelativeTo(null);
	}
}