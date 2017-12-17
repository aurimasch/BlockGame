package blockgame;

import java.awt.Color;
import java.awt.Graphics;

public class BoardDrawer {

	private int squereSize;
	private int width, height;

	public BoardDrawer(int squereSize, int width, int height) {
		this.squereSize = squereSize;
		this.width = width;
		this.height = height;
	}
	
	public void drawFallenShapes(Graphics g, Tetrominoes[][] board) {
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				if (board[x][y] != Tetrominoes.NoShape) {
					Color color = shapeToColor(board[x][y]);
					drawShapePixel(g, x, y, color);
				}
			}
		}
	}

	public void drawGhostShape(Shape droping, Shape ghostShape, Graphics g) {
		Color c = shapeToColor(droping.getType());

		for (int i = 0; i < 4; i++) {
			g.setColor(c);
			g.drawRect((ghostShape.getX() + ghostShape.getX(i)) * (squereSize) + 1,
					(ghostShape.getY() - ghostShape.getY(i)) * squereSize + 1, squereSize - 2, squereSize - 2);
			c = c.darker();
			g.setColor(c);
			g.drawRect((ghostShape.getX() + ghostShape.getX(i)) * squereSize,
					(ghostShape.getY() - ghostShape.getY(i)) * squereSize, squereSize, squereSize);
			c = c.brighter();
		}
	}

	public void drawShape(Shape droping, Graphics g) {
		Color c = shapeToColor(droping.getType());
		for (int i = 0; i < 4; i++) {
			drawShapePixel(g, (droping.getX() + droping.getX(i)), (droping.getY() - droping.getY(i)), c);
		}
	}

	public void drawGrid(Graphics g) {

		g.setColor(new Color(180, 180, 180));
		for (int x = 0; x <= height; x++) {
			g.drawLine(0, x * squereSize, width * squereSize, x * squereSize);
		}
		for (int y = 0; y <= width; y++) {
			g.drawLine(y * squereSize, 0, y * squereSize, height * squereSize);
		}
	}

	public void drawShapePixel(Graphics g, int x, int y, Color c) {

		c = c.darker();
		g.setColor(c);
		g.fillRect(x * squereSize, y * squereSize, squereSize, squereSize);

		c = c.brighter();
		g.setColor(c);
		g.fillRect((x * squereSize) + 1, (y * squereSize) + 1, squereSize - 2, squereSize - 2);

	}

	public static Color shapeToColor(Tetrominoes shape) {
		if (shape == Tetrominoes.LineShape)
			return Color.CYAN;
		if (shape == Tetrominoes.SquareShape)
			return Color.YELLOW;
		if (shape == Tetrominoes.TShape)
			return Color.MAGENTA;
		if (shape == Tetrominoes.SShape)
			return Color.GREEN;
		if (shape == Tetrominoes.ZShape)
			return Color.RED;
		if (shape == Tetrominoes.MirroredLShape)
			return Color.BLUE;
		if (shape == Tetrominoes.LShape)
			return Color.ORANGE;

		return Color.BLACK;
	}

	public int getSquereSize() {
		return squereSize;
	}

	public void setSquereSize(int squereSize) {
		this.squereSize = squereSize;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
}
