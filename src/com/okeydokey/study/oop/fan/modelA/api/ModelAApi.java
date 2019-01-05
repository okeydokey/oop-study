package com.okeydokey.study.oop.fan.modelA.api;

public abstract class ModelAApi {

    public abstract void setTimeOut(int milliseconds);

    public enum WindSpeed {LEVEL0, LEVEL1, LEVEL2, LEVEL3}

    public abstract void setSpeed(WindSpeed speed);
    public abstract void turnOn();
    public abstract void turnOff();
    public abstract void startRotation();
    public abstract void stopRotation();

    public abstract boolean getPowerButtonStatus();
    public abstract WindSpeed getSpeedButtonStatus();
    public abstract boolean getRotationButtonStatus();

    public abstract boolean isTimeout();

    public static ModelAApi instance() {
        return new FakeModelAApi();
    }
}
