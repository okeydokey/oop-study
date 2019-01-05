package com.okeydokey.study.oop.fan.modelA.control;

import com.okeydokey.study.oop.fan.control.UI;
import com.okeydokey.study.oop.fan.modelA.api.ModelAApi;
import com.okeydokey.study.oop.fan.modelA.api.Pollable;

import java.util.Arrays;

// 파워 상태에 따른 방어 코드 생략
public class ModelAUI implements UI, Pollable {

    private ModelAApi api;

    public ModelAUI(ModelAApi api) {
        this.api = api;
    }

    @Override
    public void poll() {
        boolean isTimeOut = api.isTimeout();
        if(isTimeOut) {
            api.turnOff();
        }
    }

    @Override
    public void powerOn() {
        api.turnOn();
    }

    @Override
    public void powerOff() {
        api.turnOff();
    }

    @Override
    public void changeWindSpeed(int speed) {
        api.setSpeed(toWindSpeed(speed));
    }

    private ModelAApi.WindSpeed toWindSpeed(int speed) {
        return Arrays.stream(ModelAApi.WindSpeed.values()).filter(e -> e.ordinal() == speed).findFirst().get();
    }

    @Override
    public void toggleRotationStatus() {
        if (api.getRotationButtonStatus()) {
            api.stopRotation();
        } else {
            api.startRotation();
        }
    }

    @Override
    public void setTimeOut(int minutes) {
        int milliseconds = minutes * 60 * 1000;
        api.setTimeOut(milliseconds);
    }
}
