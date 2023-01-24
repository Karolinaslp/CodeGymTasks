package big_task3513_2048_game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

// Monitor keystrokes during the game
public class Controller extends KeyAdapter {
    private final Model model;
    private final View view;

    private static final int WINNING_TILE = 2048;

    public Controller(Model model) {
        this.model = model;
        view = new View(this);
    }

    public Tile[][] getGameTiles() {
        return model.getGameTiles();
    }

    public int getScore() {
        return model.score;
    }

    public View getView() {
        return view;
    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            resetGame();
        }
        if (!model.canMove()) {
            view.isGameLost = true;
        }
        if (!view.isGameLost && !view.isGameWon) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT -> model.left();
                case KeyEvent.VK_RIGHT -> model.right();
                case KeyEvent.VK_UP -> model.up();
                case KeyEvent.VK_DOWN -> model.down();
                case KeyEvent.VK_Z -> model.rollback();
                case KeyEvent.VK_R -> model.randomMove();
            }
        }
        if (WINNING_TILE == model.maxTile) {
            view.isGameWon = true;
        }
        view.repaint();
    }

    public void resetGame() {
        model.score = 0;
        view.isGameLost = false;
        view.isGameWon = false;
        model.resetGameTiles();
    }
}

