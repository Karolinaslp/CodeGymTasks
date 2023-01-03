package big_task3513_2048_game;

// Contain the game logic and store the game board
public class Model {
    private static final int FIELD_WIDTH = 4;
    private final Tile[][] gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];

    public Model() {
        for (int row = 0; row < gameTiles.length; row++) {
            for (int col = 0; col < gameTiles[row].length; col++) {
                gameTiles[row][col] = new Tile();
            }
        }
    }
}

