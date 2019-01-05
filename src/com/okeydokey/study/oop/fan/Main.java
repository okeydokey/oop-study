package com.okeydokey.study.oop.fan;

import com.okeydokey.study.oop.fan.modelA.api.FakeModelAApi;
import com.okeydokey.study.oop.fan.modelA.api.ModelAApi;
import com.okeydokey.study.oop.fan.modelA.api.Pollable;
import com.okeydokey.study.oop.fan.modelA.control.ModelAUI;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        FakeModelAApi api = (FakeModelAApi) ModelAApi.instance();

        ModelAUI ui = new ModelAUI(api);

        List<Pollable> pollables = new ArrayList<>();
        pollables.add(ui);

        ui.powerOn();

        ui.changeWindSpeed(3);
        ui.changeWindSpeed(1);

        ui.setTimeOut(1);

        ui.toggleRotationStatus();
        ui.toggleRotationStatus();
        ui.toggleRotationStatus();

        while(true) {
            Thread.sleep(100);  // 0.1초
            for (Pollable pollable : pollables) {
                pollable.poll();
            }

            if(!api.getPowerButtonStatus()) {
                break;
            }
        }
    }
}
