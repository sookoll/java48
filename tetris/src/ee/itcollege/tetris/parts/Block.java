package ee.itcollege.tetris.parts;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Block extends Rectangle {

	public static final int SIZE = 20;

	public Block(int x, int y) {
		super(x * SIZE, y * SIZE, SIZE - 1, SIZE - 1);
		setFill(Color.BLACK);
	}

}
