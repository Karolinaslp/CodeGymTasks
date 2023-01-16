package big_task3513_2048_game;

// Monitor keystrokes during the game
public class Controller {
    private Model model;
    private View view;

    public Tile[][] getGameTiles() {
        return model.getGameTiles();
    }

    public int getScore() {
        return model.score;
    }
}
