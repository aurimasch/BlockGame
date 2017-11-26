package blockgame;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class NextPiece extends JPanel {

	private static final long serialVersionUID = 1L;
	private Shape next;
	int squereSize = 20;

	public NextPiece() {
		next = new Shape();
		next.rotateRight();
		next.rotateRight();
		next.setRandomShape();
	}

	public Shape getNext() {
		return next;
	}

	public void nextTetromino(Tetrominoes t) {
		next.setType(t);
		repaint();
	}

	public void setNext(Shape next) {
		this.next = next;
		repaint();
	}

	public void paint(Graphics g) {

		super.paint(g);
		for (int i = 0; i < 4; i++) {
			drawShape(g, next.getX(i), -next.getY(i), next.getType());
		}

	}

	public void drawShape(Graphics g, int x, int y, Tetrominoes t) {

		int offy = 50;
		int offx = 25;

		Color c = Board.shapeToColor(t);
		c = c.darker();
		g.setColor(c);
		g.fillRect(x * squereSize + offx, y * squereSize + offy, squereSize, squereSize);

		c = c.brighter();
		g.setColor(c);
		g.fillRect((x * squereSize) + 1 + offx, (y * squereSize) + 1 + offy, squereSize - 2, squereSize - 2);

	}

}
