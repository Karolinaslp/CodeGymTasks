package big_task2213_tetris;

public class GamePiece {
    private final int x;
    private final int y;

    private final int[][] matrix;

    public GamePiece(int x, int y, int[][] matrix) {
        this.x = x;
        this.y = y;
        this.matrix = matrix;
    }

    public void left() {

    }

    public void right() {

    }

    public void down() {

    }

    public void up() {

    }

    public void rotate() {

    }

    public void downMaximum() {

    }

    public boolean isCurrentPositionAvailable() {
        return true;
    }

    public void land() {

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int[][] getMatrix() {
        return matrix;
    }
}

