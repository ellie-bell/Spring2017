import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class Etch_A_Sketch implements MouseListener, MouseMotionListener, ActionListener // NOTE multiple interfaces
{
	JFrame window;
	Container content;
	int mouseX,mouseY,oldX,oldY;
	JLabel coords;
	JButton colorChanger;
	Color currColor;
	int colorIndex = 0;
	
	public Etch_A_Sketch()
	{
		JFrame window = new JFrame("Classic Etch a Sketch");
		colorChanger = new JButton ("Change Color");
		content = window.getContentPane();
		content.setLayout( new FlowLayout() );
		coords = new JLabel();
		coords.setFont(new Font("TimesRoman", Font.ITALIC + Font.BOLD, 32));
		content.add( coords); 
		content.add(colorChanger);
		content.addMouseListener(this);        // "this" is the class that implements that listener
		content.addMouseMotionListener(this);  // "this" is the class that implements that listener
		colorChanger.addActionListener(this);
		window.setSize(640,480);
		window.setVisible(true);
	}
	// ..............................................................
	// IMPLEMENTING MOUSELISTENER REQUIRES YOU TO WRITE (OVER-RIDE) THESE METHODS 

	//when you press & release with NO MOVEMENT while pressed
	public void mouseClicked( MouseEvent me)
	{
		mouseX = me.getX();
		mouseY = me.getY();

		
	}
	
	// when you press 
	public void mousePressed( MouseEvent me)
	{
		mouseX = me.getX();
		mouseY = me.getY();

	}

	//when you let release after dragging
	public void mouseReleased( MouseEvent me)
	{
		mouseX = me.getX();
		mouseY = me.getY();

	}

	// the mouse just moved off of the JFrame
	public void mouseExited( MouseEvent me)
	{
		mouseX = me.getX();
		mouseY = me.getY();

	}
	
	// the mouse just moved onto the JFrame
	public void mouseEntered( MouseEvent me)
	{
		mouseX = me.getX();
		mouseY = me.getY();
	
	}
	// ...............................................................
	// IMPLEMENTING MOUSEMOTIONLISTENER REQUIRES YOU WRITE (OVER-RIDE) THESE METHODS 

	// mouse is moving while pressed
	public void mouseDragged( MouseEvent me)
	{
		mouseX = me.getX();
		mouseY = me.getY();

		if (oldX ==0 )
		{
			oldX=mouseX;
			oldY=mouseY;
			return;
		}
		
		// draw  dot (actually small line segment) between old (x,y) and current (x,y)
		
		Graphics g = content.getGraphics(); // use g to draw onto the pane
		g.setColor(currColor);
		g.drawLine( oldX,oldY, mouseX, mouseY );
		oldX = mouseX;
		oldY = mouseY;
		
	}
	
	// moved mouse but not pressed
	public void mouseMoved( MouseEvent me)
	{
		mouseX = me.getX();
		mouseY = me.getY();

	}


	// ..............................................................


	public void actionPerformed(ActionEvent e)
	{
		Color [] theColors = {Color.RED, Color.BLUE, Color.YELLOW, Color.GREEN,Color.BLACK, };
		currColor = theColors[colorIndex];
		colorIndex = (colorIndex+1) % theColors.length;
	}
	
	public static void main( String[] args)
	{
		new Etch_A_Sketch();
	}
	// a helper utility
	private void reportEventCoords( String msg )
	{
		coords.setText( msg ); 
	}
}
//EOF