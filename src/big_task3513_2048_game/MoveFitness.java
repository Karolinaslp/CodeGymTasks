package big_task3513_2048_game;

public class MoveFitness implements Comparable<MoveFitness>{
    private final int numberOfEmptyTiles;
    private final int score;
    private final Move move;

    public MoveFitness(int numberOfEmptyTiles, int score, Move move) {
        this.numberOfEmptyTiles = numberOfEmptyTiles;
        this.score = score;
        this.move = move;
    }

    public Move getMove() {
        return move;
    }

    @Override
    public int compareTo(MoveFitness o) {
        if (numberOfEmptyTiles > o.numberOfEmptyTiles){
            return  1;
        } else if (numberOfEmptyTiles < o.numberOfEmptyTiles) {
            return  -1;
        } else {
            if (score > o.score) {
                return 1;
            } else if (score < o.score) {
                return -1;
            }
        }
        return 0;
    }
}
