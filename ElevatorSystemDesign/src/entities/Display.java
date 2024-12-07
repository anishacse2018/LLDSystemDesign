package entities;

import enums.Direction;

public class Display {

    Integer floorId;
    Direction direction;

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
    public void setFloorId(Integer floorId) {
        this.floorId = floorId;
    }
    public Direction getDirection() {
        return direction;
    }
    public Integer getFloorId() {
        return floorId;
    }
}

