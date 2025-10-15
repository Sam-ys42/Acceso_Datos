// NO TOUES NADA//


package UNIT1;


import java.awt.event.KeyEvent;
import java.awt.BorderLayout;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.util.Scanner;

public class proyectoClaseMario extends JFrame
implements KeyListener
{
	JTextField textField = new JTextField(20);
	JTextField displayField = new JTextField (20);
	
	
	public proyectoClaseMario() {
		setTitle("Ventanita bien bonita ");
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addKeyListener(this);
		setVisible(true);
		
		
		setLayout(new BorderLayout());
		add(textField, BorderLayout.NORTH);
		add(displayField, BorderLayout.SOUTH);
		
		
		textField.addKeyListener(this);
		
		displayField.setEditable(false);
	}
	 
	@Override
	public void keyTyped(KeyEvent e) {
		// Nada (ni idea)
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		displayField.setText(e.getKeyText(e.getKeyCode()));
		if(KeyEvent.getKeyText(e.getKeyCode()).equals("1")) {
			System.out.println("PARA");
		}
		if(KeyEvent.getKeyText(e.getKeyCode()).equals("3")) {
			System.out.println("solo puedes escribir: si/ no");
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

		//System.out.println(e.getKeyText(e.getKeyCode()));
		
	}
	
	
	public static void main (String[]args) {
		new proyectoClaseMario();
		System.out.println("Dime un número");
		Scanner número = new Scanner(System.in);
		
		
		
	}
	
}