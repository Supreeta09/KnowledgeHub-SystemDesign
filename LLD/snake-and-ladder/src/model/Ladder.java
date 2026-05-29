package model;

public class Ladder extends BoardEntity {
    public Ladder(int start, int end) {
        super(start, end);
        if (start >= end) {
            throw new IllegalArgumentException("model.Ladder start must be < end");
        }
    }
}
