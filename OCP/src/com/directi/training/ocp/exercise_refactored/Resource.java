package com.directi.training.ocp.exercise_refactored;

public abstract class Resource {
    private final int _id;

    public Resource(int id) {
        _id = id;
    }

    public int getId() {
        return _id;
    }

    public abstract boolean isFree();

    public abstract void markBusy(int resourceId);

    public abstract void markFree(int resourceId);

    public abstract int findFree();
}
