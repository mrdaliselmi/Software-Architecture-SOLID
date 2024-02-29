package com.directi.training.isp.exercise_refactored;

import java.util.Random;

public class Sensor {
    public void register(SensorDependant obj) {
        while (true) {
            if (isPersonClose()) {
                obj.proximityCallback();
                break;
            }
        }
    }

    private boolean isPersonClose() {
        return new Random().nextBoolean();
    }
}
