package blockgame;

import java.util.Random;
import java.lang.Math;

public class Shape {

	private Tetrominoes type;
	
	private int pixels[][];
	
	private int x,y;
	
	private final int[][][] ALL_SHAPES = { 
		    { { 0, 0 },   { 0, 0 },  { 0, 0 },  { 0, 0 } },
			{ { 0, -1 },  { 0, 0 },  { -1, 0 }, { -1, 1 } }, 
			{ { 0, -1 },  { 0, 0 },  { 1, 0 },  { 1, 1 } },
			{ { 0, -1 },  { 0, 0 },  { 0, 1 },  { 0, 2 } }, 
			{ { -1, 0 },  { 0, 0 },  { 1, 0 },  { 0, 1 } },
			{ { 0, 0 },   { 1, 0 },  { 0, 1 },  { 1, 1 } }, 
			{ { -1, -1 }, { 0, -1 }, { 0, 0 },  { 0, 1 } },
			{ { 1, -1 },  { 0, -1 }, { 0, 0 }, { 0, 1 } } };

	public Shape() {
		pixels = new int[4][2];
		setType(Tetrominoes.NoShape);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setType(Tetrominoes type) {

		int[][] shapePixels = ALL_SHAPES[type.ordinal()];
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 2; ++j) {
				pixels[i][j] = shapePixels[i][j];
			}
		}
		this.type = type;

	}

	private void setX(int index, int x) {
		pixels[index][0] = x;
	}

	private void setY(int index, int y) {
		pixels[index][1] = y;
	}

	public int getX(int index) {
		return pixels[index][0];
	}

	public int getY(int index) {
		return pixels[index][1];
	}

	public Tetrominoes getType() {
		return type;
	}

	public void setRandomShape() {
		Random r = new Random();
		int x = Math.abs(r.nextInt()) % 7 + 1;
		Tetrominoes[] values = Tetrominoes.values();
		setType(values[x]);
	}

	public int getMinX() {
		int m = pixels[0][0];
		for (int i = 0; i < 4; i++) {
			m = Math.min(m, pixels[i][0]);
		}
		return m;
	}

	public int getMinY() {
		int m = pixels[0][1];
		for (int i = 0; i < 4; i++) {
			m = Math.min(m, pixels[i][1]);
		}
		return m;
	}

	public Shape rotateLeft() {
		if (type == Tetrominoes.SquareShape)
			return this;

		Shape result = new Shape();
		result.type = type;

		for (int i = 0; i < 4; ++i) {
			result.setX(i, getY(i));
			result.setY(i, -getX(i));
		}
		return result;
	}

	public  Shape rotateRight() {
		if (type == Tetrominoes.SquareShape)
			return this;

		Shape result = new Shape();
		result.type = type;

		for (int i = 0; i < 4; ++i) {
			result.setX(i, -getY(i));
			result.setY(i, getX(i));
		}
		result.setX(this.x);
		result.setY(this.y);
		return result;
	}
	

	public int[][] getPixels() {
		return pixels;
	}

	public void setPixels(int[][] coords) {
		this.pixels = coords;
	}
}