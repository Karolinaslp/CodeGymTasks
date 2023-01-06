package big_task3513_2048_game;

import java.util.ArrayList;
import java.util.List;

// Contain the game logic and store the game board
public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];

    public Model() {
        resetGameTiles();
    }

    private void addTile() {
        List<Tile> emptyTiles = getEmptyTiles();
        if (!emptyTiles.isEmpty()) {
            int index = (int) (Math.random() * emptyTiles.size()) % emptyTiles.size();
            Tile emptyTile = emptyTiles.get(index);
            emptyTile.value = Math.random() < 0.9 ? 2 : 4;
        }
    }

    private List<Tile> getEmptyTiles() {
        List<Tile> emptyTiles = new ArrayList<>();
        for (Tile[] tileArray : gameTiles) {
            for (Tile t : tileArray) {
                if (t.isEmpty()) {
                    emptyTiles.add(t);
                }
            }
        }
        return emptyTiles;
    }

    private void resetGameTiles() {
        gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int row = 0; row < FIELD_WIDTH; row++) {
            for (int col = 0; col < FIELD_WIDTH; col++) {
                gameTiles[row][col] = new Tile();
            }
        }
        addTile();
        addTile();
    }
}

