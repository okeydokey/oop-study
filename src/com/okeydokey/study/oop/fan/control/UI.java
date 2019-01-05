package com.okeydokey.study.oop.fan.control;

public interface UI {

    // 선풍기 켬
    void powerOn();

    // 선풍기 끔
    void powerOff();

    // 바람 세기를 1-3 단계로 조절
    void changeWindSpeed(int speed);

    // 바람을 회전 또는 고정
    void toggleRotationStatus();

    // 타이머 지정
    void setTimeOut(int minutes);
}
