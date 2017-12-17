package blockgame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class InputHandler extends KeyAdapter {
	
	private BoardController  board;
	public InputHandler(BoardController board) {
		this.board = board;
	}
	@Override
	public void keyPressed(KeyEvent e) {

		int key = e.getKeyCode();

		if (key == KeyEvent.VK_P) {
			board.pause();
		}

		if (!board.getIsRunning()) {
			return;
		}

		switch (key) {
		case KeyEvent.VK_LEFT:
			board.moveLeft();
			break;
		case KeyEvent.VK_RIGHT:
			board.moveRight();
			break;
		case KeyEvent.VK_UP:
			board.rotate();
			break;
		case KeyEvent.VK_DOWN:
			board.fastDrop(true);
			break;
		default:
			break;
		}
	}
}