package big_task3513_2048_game;

import java.util.*;

// Contain the game logic and store the game board
public class Model {
    private Tile[][] gameTiles;
    private static final int FIELD_WIDTH = 4;
    int maxTile = 2;
    int score = 0;

    private final Stack<Tile[][]> previousStates = new Stack<>();
    private final Stack<Integer> previousScores = new Stack<>();
    boolean isSaveNeeded = true;

    public Model() {
        resetGameTiles();
    }

    public Tile[][] getGameTiles() {
        return gameTiles;
    }

    void resetGameTiles() {
        gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int row = 0; row < FIELD_WIDTH; row++) {
            for (int col = 0; col < FIELD_WIDTH; col++) {
                gameTiles[row][col] = new Tile();
            }
        }
        addTile();
        addTile();
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
        final List<Tile> list = new ArrayList<>();
        for (Tile[] tileArray : gameTiles) {
            for (Tile t : tileArray)
                if (t.isEmpty()) {
                    list.add(t);
                }
        }
        return list;
    }

    private boolean consolidateTiles(Tile[] tiles) {
        int insertPosition = 0;
        boolean result = false;
        for (int i = 0; i < FIELD_WIDTH; i++) {
            if (!tiles[i].isEmpty()) {
                if (i != insertPosition) {
                    tiles[insertPosition] = tiles[i];
                    tiles[i] = new Tile();
                    result = true;
                }
                insertPosition++;
            }
        }
        return result;
    }

    private boolean mergeTiles(Tile[] tiles) {
        boolean result = false;
        LinkedList<Tile> tilesList = new LinkedList<>();
        for (int i = 0; i < FIELD_WIDTH; i++) {
            if (tiles[i].isEmpty()) {
                continue;
            }

            if (i < FIELD_WIDTH - 1 && tiles[i].value == tiles[i + 1].value) {
                int updatedValue = tiles[i].value * 2;
                if (updatedValue > maxTile) {
                    maxTile = updatedValue;
                }
                score += updatedValue;
                tilesList.addLast(new Tile(updatedValue));
                tiles[i + 1].value = 0;
                result = true;
            } else {
                tilesList.addLast(new Tile(tiles[i].value));
            }
            tiles[i].value = 0;
        }

        for (int i = 0; i < tilesList.size(); i++) {
            tiles[i] = tilesList.get(i);
        }

        return result;
    }

    private Tile[][] rotateClockwise(Tile[][] tiles) {
        final int N = tiles.length;
        Tile[][] result = new Tile[N][N];
        for (int row = 0; row < N; row++) {
            for (int column = 0; column < N; column++) {
                result[column][N - 1 - row] = tiles[row][column];
            }
        }
        return result;
    }

    public void left() {
        if (isSaveNeeded) {
            saveState(gameTiles);
        }
        boolean moveFlag = false;
        for (int i = 0; i < FIELD_WIDTH; i++) {
            if (consolidateTiles(gameTiles[i]) | mergeTiles(gameTiles[i])) {
                moveFlag = true;
            }
        }
        if (moveFlag) {
            addTile();
        }
        isSaveNeeded = true;
    }

    public void right() {
        saveState(gameTiles);
        gameTiles = rotateClockwise(gameTiles);
        gameTiles = rotateClockwise(gameTiles);
        left();
        gameTiles = rotateClockwise(gameTiles);
        gameTiles = rotateClockwise(gameTiles);
    }

    public void up() {
        saveState(gameTiles);
        gameTiles = rotateClockwise(gameTiles);
        gameTiles = rotateClockwise(gameTiles);
        gameTiles = rotateClockwise(gameTiles);
        left();
        gameTiles = rotateClockwise(gameTiles);
    }

    public void down() {
        saveState(gameTiles);
        gameTiles = rotateClockwise(gameTiles);
        left();
        gameTiles = rotateClockwise(gameTiles);
        gameTiles = rotateClockwise(gameTiles);
        gameTiles = rotateClockwise(gameTiles);
    }

    private int getEmptyTilesCount() {
        return getEmptyTiles().size();
    }

    private boolean isFull() {
        return getEmptyTilesCount() == 0;
    }

    public boolean canMove() {
        if (!isFull()) {
            return true;
        }

        for (int row = 0; row < FIELD_WIDTH; row++) {
            for (int column = 0; column < FIELD_WIDTH; column++) {
                Tile t = gameTiles[row][column];
                if ((row < FIELD_WIDTH - 1 && t.value == gameTiles[row + 1][column].value)
                        || ((column < FIELD_WIDTH - 1) && t.value == gameTiles[row][column + 1].value)) {
                    return true;
                }
            }
        }
        return false;
    }

    private void saveState(Tile[][] tiles) {
        Tile[][] tempTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int row = 0; row < FIELD_WIDTH; row++) {
            for (int column = 0; column < FIELD_WIDTH; column++) {
                tempTiles[row][column] = new Tile(tiles[row][column].value);
            }
        }
        previousStates.push(tempTiles);
        previousScores.push(score);
        isSaveNeeded = false;
    }

    public void rollback() {
        if (!previousStates.isEmpty() && !previousScores.isEmpty()) {
            gameTiles = previousStates.pop();
            score = previousScores.pop();
        }
    }

    public void randomMove() {
        int n = ((int) (Math.random() * 100)) % 4;
        switch (n) {
            case 0 -> left();
            case 1 -> right();
            case 2 -> up();
            case 3 -> down();
        }
    }

    private boolean hasBoardChanged() {
        for (int row = 0; row < FIELD_WIDTH; row++) {
            for (int column = 0; column < FIELD_WIDTH; column++) {
                if (gameTiles[row][column].value != previousStates.peek()[row][column].value) {
                    return true;
                }
            }
        }
        return false;
    }

    private MoveFitness getMoveFitness(Move move) {
        MoveFitness moveFitness = new MoveFitness(-1, 0, move);
        move.move();
        if (hasBoardChanged()) {
            moveFitness = new MoveFitness(getEmptyTilesCount(), score, move);
        }
        rollback();
        return moveFitness;
    }

    void autoMove() {
        PriorityQueue<MoveFitness> priorityQueue = new PriorityQueue<>(4, Collections.reverseOrder());

        priorityQueue.offer(getMoveFitness(this::left));
        priorityQueue.offer(getMoveFitness(this::right));
        priorityQueue.offer(getMoveFitness(this::down));
        priorityQueue.offer(getMoveFitness(this::up));

        assert priorityQueue.peek() != null;
        priorityQueue.peek().getMove().move();
    }
}
