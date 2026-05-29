package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {
    private int size;
    private Map<Integer, Integer> jumpMap = new HashMap<>();

    public Board(int size, List<BoardEntity> entities) {
        this.size = size;
        for (BoardEntity entity: entities) {
            if (jumpMap.containsKey(entity.getStart())) {
                throw new IllegalArgumentException("Multiple entities at same start position: " + entity.getStart());
            }
            jumpMap.put(entity.getStart(), entity.getEnd());
        }
    }

    public int getSize() {
        return size;
    }

    public int getNextPosition(int position) {
        return jumpMap.getOrDefault(position, position);
    }

    public static class Player {
        private String name;
        private int position;

        public Player(String name) {
            this.name = name;
            this.position = 0;
        }

        public String getName() {
            return name;
        }

        public int getPosition() {
            return position;
        }

        public void setPosition(int position) {
            this.position = position;
        }
    }
}
