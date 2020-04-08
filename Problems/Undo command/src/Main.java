interface Movable {
    int getX();
    int getY();
    void setX(int newX);
    void setY(int newY);
}

interface Storable {
    int getInventoryLength();
    String getInventoryItem(int index);
    void setInventoryItem(int index, String item);
}

interface Command {
    void execute();
    void undo();
}

class CommandMove implements Command{
    Movable entity;
    int xMovement;
    int yMovement;

    @Override
    public void execute() {
        entity.setX(entity.getX() + xMovement);
        entity.setY(entity.getY() + yMovement);
    }

    @Override
    public void undo() {
        entity.setX(entity.getX() - xMovement);
        entity.setY(entity.getY() - yMovement);
    }
}

class CommandPickItem implements Command {
    Storable entity;
    String item;
    Integer usedSlot;

    @Override
    public void execute() {
        for (int i = 0; i < entity.getInventoryLength(); i++){
            if (entity.getInventoryItem(i) == null){
                entity.setInventoryItem(i, item);
                usedSlot = i;
                return;
            }
        }
    }

    @Override
    public void undo() {
        if (usedSlot != null){
            entity.setInventoryItem(usedSlot, null);
        }
    }
}