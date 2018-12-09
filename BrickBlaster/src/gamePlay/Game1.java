package gamePlay;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import javax.swing.*;


public class Game1 extends JPanel implements KeyListener, ActionListener {
	
	private int height, width;
	private Timer t = new Timer(5, this);
	private boolean first;
	
	private HashSet<String> keys = new HashSet<String>();
	
	

	private final int SPEED = 1;
	private int padH = 10, padW = 40;
	private int bottomPadX, topPadX;
	private int inset = 10;
	private ArrayList<Rectangle2D> brickArr = new ArrayList<Rectangle2D>(); 
	private String status = "";
	//private int[] hits = {0,0,0,0,0,0,0};
	private int[] hits = {4,4,4,4,4,4,4};
	
	// ball
	private double ballX, ballY, velX = 1, velY = 1, ballSize = 20;
	
	// score
	private int scoreTop, scoreBottom;
	
	public Game1() {
		
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		first = true;
		t.setInitialDelay(100);
		t.start();
	}
	
	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D graphic = (Graphics2D) g;
		height = getHeight();
		width = getWidth();

		// initial positioning
		if (first) {
			bottomPadX = width / 2 - padW / 2;
			topPadX = bottomPadX;
			ballX = width / 2 - ballSize / 2;
			ballY = height / 2 - ballSize / 2;
			first = false;
		}
		
		// bottom pad
		Rectangle2D bottomPad = new Rectangle(bottomPadX, height - padH - inset, padW, padH);
		graphic.fill(bottomPad);
		
		
		// ball
		Ellipse2D ball = new Ellipse2D.Double(ballX, ballY, ballSize, ballSize);
		graphic.fill(ball);
		
		
		int gap = 0;
		for( int i = 0; i<7; i++) {
		Rectangle2D brickArr1 = new Rectangle(10+gap, 100, 50, 30);
		brickArr.add(brickArr1);
		
		graphic.setPaint(Color.BLACK);
		
		if(hits[i]==1) {
		
			graphic.setPaint(Color.RED);
			
		}else if (hits[i]==2) {
			
			graphic.setPaint(Color.ORANGE);
		
		}else if (hits[i]==3) {
			
			graphic.setPaint(Color.YELLOW);
		}
		
		graphic.fill(brickArr.get(i));
		gap = gap+70;
		}
		
		graphic.setFont(new Font("TimesRoman", Font.PLAIN, 60));
	    graphic.setColor(Color.red);
		graphic.drawString(status, width/2 -180, height / 2);
		
		
		
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// side walls
		if (ballX < 0 || ballX > width - ballSize) {
			velX = -velX;
		}
	
		if (ballY < 0) {
			velY = -velY;
		
		}
		
		if (ballY > this.getHeight() ) {
			velX=0;
			velY=0;
			status = "GAME OVER";
			
		}
		
		try {
		if (ballY < brickArr.get(0).getMaxY() 
				&& ballY + ballSize > brickArr.get(0).getMinY() 
			 	&& ballX < brickArr.get(0).getMaxX() 
			 	&& ballX + ballSize > brickArr.get(0).getMinX()
					) {
				velY = -velY;
				if(hits[0] == 3) {
					brickArr.get(0).setRect(0.0, 0.0, 0.0, 0.0);
				}
				hits[0] =hits[0]+1; 
				
				printArr(hits);
				winCheck(hits); 
				
			}
		}catch(IndexOutOfBoundsException u) {
			
		}
		
		try {
			if (ballY < brickArr.get(1).getMaxY() 
					&& ballY+ ballSize > brickArr.get(1).getMinY() 
				 	&& ballX < brickArr.get(1).getMaxX() 
				 	&& ballX + ballSize > brickArr.get(1).getMinX()
						) {
				velY = -velY;
				if(hits[1] == 3) {
					brickArr.get(1).setRect(0.0, 0.0, 0.0, 0.0);
				}
				hits[1] =hits[1]+1; 
				printArr(hits);
				winCheck(hits); 
				
				
			}
		}catch(IndexOutOfBoundsException u) {
			
		}
		
		try {
			if (ballY < brickArr.get(2).getMaxY() 
					&& ballY + ballSize > brickArr.get(2).getMinY() 
				 	&& ballX < brickArr.get(2).getMaxX() 
				 	&& ballX + ballSize > brickArr.get(2).getMinX()
						) {
			velY = -velY;
			if(hits[2] == 3) {
				brickArr.get(2).setRect(0.0, 0.0, 0.0, 0.0);
			}
			hits[2] =hits[2]+1; 
			printArr(hits);
			winCheck(hits); 
			
		}
		}catch(IndexOutOfBoundsException u) {
			
		}
		
		try {
			if (ballY < brickArr.get(3).getMaxY() 
					&& ballY+ ballSize > brickArr.get(3).getMinY() 
				 	&& ballX < brickArr.get(3).getMaxX() 
				 	&& ballX + ballSize  > brickArr.get(3).getMinX()
						) {
				velY = -velY;
				if(hits[3] == 3) {
					brickArr.get(3).setRect(0.0, 0.0, 0.0, 0.0);
				}
				hits[3] =hits[3]+1; 
				printArr(hits);
				winCheck(hits); 
				
			}
			}catch(IndexOutOfBoundsException u) {
				
			}
		
		try {
			if (ballY < brickArr.get(4).getMaxY() 
					&& ballY+ ballSize > brickArr.get(4).getMinY() 
				 	&& ballX < brickArr.get(4).getMaxX() 
				 	&& ballX + ballSize > brickArr.get(4).getMinX()
						) {
				velY = -velY;
				if(hits[4] == 3) {
					brickArr.get(4).setRect(0.0, 0.0, 0.0, 0.0);
				}
				hits[4] =hits[4]+1; 
				printArr(hits);
				winCheck(hits); 
				
			}
			}catch(IndexOutOfBoundsException u) {
				
			}
		
		try {
			if (ballY < brickArr.get(5).getMaxY() 
					&& ballY + ballSize > brickArr.get(5).getMinY() 
				 	&& ballX < brickArr.get(5).getMaxX() 
				 	&& ballX + ballSize > brickArr.get(5).getMinX()
						) {
				velY = -velY;
				if(hits[5] == 3) {
					brickArr.get(5).setRect(0.0, 0.0, 0.0, 0.0);
				}
				hits[5] =hits[5]+1; 
				printArr(hits);
				winCheck(hits); 
				
			}
			}catch(IndexOutOfBoundsException u) {
				
			}
		
		try {
			if (ballY < brickArr.get(6).getMaxY() 
					&& ballY + ballSize > brickArr.get(6).getMinY() 
				 	&& ballX < brickArr.get(6).getMaxX() 
				 	&& ballX + ballSize > brickArr.get(6).getMinX()
						) {
				velY = -velY;
				if(hits[6] == 3) {
					brickArr.get(6).setRect(0.0, 0.0, 0.0, 0.0);
				}
				hits[6] =hits[6]+1; 
				printArr(hits);
				winCheck(hits); 
				
			}
			}catch(IndexOutOfBoundsException u) {
				
			}
		
		if (ballY + ballSize >= height - padH - inset && velY > 0)
			if (ballX + ballSize >= bottomPadX && ballX <= bottomPadX + padW)
				velY = -velY;

	

		ballX += velX;
		ballY += velY;
		
		// pressed keys
		if (keys.size() == 1) {
			if (keys.contains("LEFT")) {
				bottomPadX -= (bottomPadX > 0) ? SPEED : 0;
			}
			else if (keys.contains("RIGHT")) {
				bottomPadX += (bottomPadX < width - padW) ? SPEED : 0;
			}
		}
		
		// AI
		double delta = ballX - topPadX;
		if (delta > 0) {
			topPadX += (topPadX < width - padW) ? SPEED : 0;
		}
		else if (delta < 0) {
			topPadX -= (topPadX > 0) ? SPEED : 0;
		}
		
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		switch (code) {
		case KeyEvent.VK_LEFT:
			keys.add("LEFT");
			break;
		case KeyEvent.VK_RIGHT:
			keys.add("RIGHT");
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		switch (code) {
		case KeyEvent.VK_LEFT:
			keys.remove("LEFT");
			break;
		case KeyEvent.VK_RIGHT:
			keys.remove("RIGHT");
			break;
		}
	}
	
	public void printArr(int[] arr) {
		
		for(int i = 0; i<arr.length;i++) {
			System.out.print(arr[i] + ", ");
		}
		System.out.println();
	}
	
	public void winCheck (int[] arr) {
		
	int[] win ={4,4,4,4,4,4,4}; 
		if ( arr == win) {
			status = "Winner!";
		}
	}
}
