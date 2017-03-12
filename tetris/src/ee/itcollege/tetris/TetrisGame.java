package ee.itcollege.tetris;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import ee.itcollege.tetris.lib.CollisionDetector;
import ee.itcollege.tetris.lib.FigureGenerator;
import ee.itcollege.tetris.lib.TetrisCamera;
import ee.itcollege.tetris.parts.Block;
import ee.itcollege.tetris.parts.Figure;
import ee.itcollege.tetris.scene.GameOverScene;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class TetrisGame extends Application {

	public static final int FIELD_HEIGHT = 30;
	public static final int FIELD_WIDHT = 15;

	FigureGenerator figureGenerator = new FigureGenerator();
	Figure figure;
	ArrayList<Rectangle> gameBorders = new ArrayList<>();
	Pane layout = new Pane();
	Stage window;
	Scene scene = new Scene(layout, Block.SIZE * FIELD_WIDHT, Block.SIZE * FIELD_HEIGHT);
	Timer timer = new Timer();

	private void initGameField() {
		Rectangle border = new Rectangle(0, 0, Block.SIZE, Block.SIZE * FIELD_HEIGHT);
		border.setFill(Color.RED);
		gameBorders.add(border);

		border = new Rectangle((FIELD_WIDHT - 1) * Block.SIZE, 0, Block.SIZE, Block.SIZE * FIELD_HEIGHT);
		border.setFill(Color.RED);
		gameBorders.add(border);

		border = new Rectangle(0, (FIELD_HEIGHT - 1) * Block.SIZE, Block.SIZE * FIELD_WIDHT, Block.SIZE);
		border.setFill(Color.RED);
		gameBorders.add(border);

		layout.getChildren().addAll(gameBorders);
	}

	private void newFigure() {
		Platform.runLater(() -> {
			if (null != figure) {
				gameBorders.addAll(figure);
			}
			
			figure = figureGenerator.createFigure();
			figure.move(FIELD_WIDHT / 2, 0);
			layout.getChildren().addAll(figure);
			
			if (CollisionDetector.collide(figure, gameBorders)) {
				
				gameOver();
			}
		});
	}

	@Override
	public void start(Stage window) throws Exception {
		
		this.window = window;
		
		initGameField();
		newFigure();


		scene.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
			System.out.println(event.getCode());
			switch (event.getCode()) {
			case UP:
				figure.rotate();
				if (CollisionDetector.collide(figure, gameBorders)) {
					for (int i = 0; i < 3; i++) {
						figure.rotate();
					}
				}
				break;
			case DOWN:
				figure.moveIfPossible(0, 1, gameBorders);
				break;
			case LEFT:
				figure.moveIfPossible(-1, 0, gameBorders);
				break;
			case RIGHT:
				figure.moveIfPossible(1, 0, gameBorders);
				break;
			case SPACE:
				while (figure.moveIfPossible(0, 1, gameBorders))
				;
				break;
			default:
				break;
			}

		});

		// move automatically
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				if (!figure.moveIfPossible(0, 1, gameBorders)) {
					newFigure();
				}
			}
		}, 400, 400);
		
//		scene.setCamera(new TetrisCamera());

		window.setOnCloseRequest(e -> System.exit(0));
		window.setScene(scene);
		window.show();
	}
	
	private void gameOver () {
		timer.cancel();
		window.setScene(new GameOverScene(new VBox()));
		window.setWidth(500);
		window.setHeight(500);
	}
	
	public static void main(String[] args) {
		TetrisGame.launch(args);
	}

}
