/*

DAVID LETTIER

(C) 2013.

http://www.lettier.com/

*/

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class CheckerboardApplet extends Applet {
	public void init() {
		add(new Checkerboard(this));
	}	
}

class Checkerboard extends Canvas {
	public Checkerboard(Applet parentApplet) {
		setSize(407, 407);
	}
		
	public void paint(Graphics g) {
		int hBorderHeight = (int)(getHeight() * (BORDER_PCT / 2)); 
		int vBorderWidth = (int)(getWidth() * (BORDER_PCT / 2)); 
		int upperLeftBoardX = vBorderWidth;
		int upperLeftBoardY = hBorderHeight;
		int boxHeight = (getHeight() - 2 * hBorderHeight) / BOARD_SIZE;
		int boxWidth = (getWidth() - 2 * vBorderWidth) / BOARD_SIZE;
		setBackground( new Color( 188, 142, 30 ));

		for (int rows= 0; rows < BOARD_SIZE; rows++)
			for (int cols= 0; cols < BOARD_SIZE; cols++) {
				g.setColor(rows % 2 == 0 ^ cols % 2  == 0 ? new Color( 188, 142, 30 ) : Color.WHITE);
				g.fillRect(upperLeftBoardX + cols * boxWidth,
						upperLeftBoardY + rows * boxHeight,
						boxWidth, boxHeight);
			}
		
		for ( int rows = 0; rows < BOARD_SIZE; rows++ )
		{
			for ( int cols = 0; cols < BOARD_SIZE; cols++ )
			{
				if ( rows >= 5 ) { g.setColor( Color.BLACK ); }
				else { g.setColor( Color.RED ); }
				
				if ( checks[rows][cols] == 1 )
				{
					g.fillOval( upperLeftBoardX + cols * boxWidth, upperLeftBoardY + rows * boxHeight, boxWidth, boxHeight );
				}
			}
		}
	}

	private static double BORDER_PCT= .1;	
	private int hBorderHeight, vBorderWidth;	
	private int boxWidth, boxHeight;
	private static final int BOARD_SIZE = 8;
	
	private final static int[][] checks =  {	{  0,  1, 0, 1,  0, 1, 0, 1 },
                 						 	{  1,  0, 1, 0,  1, 0, 1, 0 },
                  						 	{  0,  1, 0, 1,  0, 1, 0, 1 },
                  						 	{  0,  0, 0, 0,  0, 0, 0, 0 },
                  						 	{  0,  0, 0, 0,  0, 0, 0, 0 },
                  						 	{  1,  0, 1, 0,  1, 0, 1, 0 },
                  							{  0,  1, 0, 1,  0, 1, 0, 1 },
                  							{  1,  0, 1, 0,  1, 0, 1, 0 }
              						    };
}

