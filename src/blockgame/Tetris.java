package blockgame;

import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Tetris extends JFrame {
	
	private static final long serialVersionUID = 5576418388229482198L;
	JLabel statusbar;
	
	public Tetris()
	{
		Box box =  Box.createHorizontalBox();
		Box box2 = Box.createHorizontalBox();
		
		
		statusbar = new JLabel("0");
		box2.add(statusbar, BorderLayout.CENTER);	
		
        NextPiece next = new NextPiece();
        box2.add(next);
		
        Board b = new Board(this, next);
      
        box.add(b);
        

        box.add(box2);
        add(box);

        setSize(350, 450);
        setTitle("Tetris");
        setLocationRelativeTo(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
		
	}

	public JLabel getStatusBar() {
		return statusbar;
	}

	public static void main(String[] args) {
        Tetris game = new Tetris();
        game.setLocationRelativeTo(null);
        game.setVisible(true);

	}

}
