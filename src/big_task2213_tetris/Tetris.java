package big_task2213_tetris;

public class Tetris {
    static Tetris game;

    private Field field;
    private GamePiece gamePiece;

    public static void main(String[] args) {
        game = new Tetris();
        game.run();
    }

    void run() {

    }

    void step() {

    }

    public Field getField() {
        return field;
    }

    public GamePiece getGamePiece() {
        return gamePiece;
    }
}