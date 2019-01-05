package com.okeydokey.study.oop.fan.modelA.api;

public class FakeModelAApi extends ModelAApi {

    private final static int pollSpeedMilliseconds = 100;

    private WindSpeed speed = WindSpeed.LEVEL0;
    private boolean isPowerButtonOn;
    private boolean isRotationButtonOn;
    private int timeOutMilliseconds;

    @Override
    public void setTimeOut(int milliseconds) {
        this.timeOutMilliseconds = milliseconds;
    }

    @Override
    public void setSpeed(WindSpeed speed) {
        this.speed = speed;
        System.out.println("바람 속도 변경 : " + speed.name());
    }

    @Override
    public void turnOn() {
        this.isPowerButtonOn = true;
        System.out.println("선풍기 켬");
    }

    @Override
    public void turnOff() {
        this.isPowerButtonOn = false;
        System.out.println("선풍기 끔");
    }

    @Override
    public void startRotation() {
        this.isRotationButtonOn = true;
        System.out.println("회전 켬");
    }

    @Override
    public void stopRotation() {
        this.isRotationButtonOn = false;
        System.out.println("회전 끔");
    }

    @Override
    public boolean getPowerButtonStatus() {
        return isPowerButtonOn;
    }

    @Override
    public WindSpeed getSpeedButtonStatus() {
        return speed;
    }

    @Override
    public boolean getRotationButtonStatus() {
        return isRotationButtonOn;
    }

    @Override
    public boolean isTimeout() {
        if(timeOutMilliseconds > 0) {
            reduceTimeOut();
            return false;
        } else {
            return true;
        }
    }

    private void reduceTimeOut() {
        timeOutMilliseconds = timeOutMilliseconds - pollSpeedMilliseconds;

        if(timeOutMilliseconds < 0) {
            timeOutMilliseconds = 0;
        }
    }
}
