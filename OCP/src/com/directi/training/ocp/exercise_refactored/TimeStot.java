package com.directi.training.ocp.exercise_refactored;

public class TimeStot extends Resource {

    public TimeStot(int id) {
        super(id);
    }

    @Override
    public boolean isFree() {
        throw new UnsupportedOperationException("Unimplemented method 'isFree'");
    }

    @Override
    public void markBusy(int resourceId) {
        throw new UnsupportedOperationException("Unimplemented method 'markBusy'");
    }

    @Override
    public void markFree(int resourceId) {
        throw new UnsupportedOperationException("Unimplemented method 'markFree'");
    }

    @Override
    public int findFree() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findFree'");
    }

}
