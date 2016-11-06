import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class Start extends JPanel implements KeyListener, Runnable {
	
	//we're hiring respectable variables
	public static final int width = 400; 
	public static final int height = 630; 
	public static final Font main = new Font("Calibri", Font.PLAIN, 28);
	
	//to execute everything everytime
	private Thread Start;
	private boolean run; 
	//all of the graphics for no flickers lifestyle, order yours now
	private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

	/*the fuck is you*/
	private static final long serialVersionUID = 1L;
	
	//keep track of time
	private long startTime; 
	private long elapsed; 
	private boolean set;
	
	public Start(){
		setFocusable(true); //pour le clavier 
		setPreferredSize(new Dimension(width, height));
		addKeyListener(this);
	}
	
	//for the glory of fps >> 60 overkill headshot
	private void update(){
		//gon do that later fuck this shite
	}

	private void render(){
		Graphics2D graphs = (Graphics2D) image.getGraphics(); //geo, transformation, layout and all the pretties 
		graphs.setColor(new Color(241,241,241)); //coulda been white but eh
		graphs.fillRect(0, 0, width, height);
		//do the render later i'm gon destroy shit
	}
	
	@Override
	public void run() {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
}
