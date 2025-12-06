package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.config.Config;

import org.firstinspires.ftc.robotcore.external.Telemetry;


@Config
public class BeltFSM {

    public enum State {
        STOPPED,
        MOVING,
        REVERSING
    }

    private Telemetry telemetry;
    private MotorWrapper transferMotor;
    public static double power = .8;
    public static double movePower = 1;
    public static double stopPower = 0;
    public static double reversePower = -1;

    public State State;

    public BeltFSM(Intaketransferhwmap intaketransferhwmap, Telemetry telemetry) {
        transferMotor = new MotorWrapper(intaketransferhwmap.getTransferMotor(), false, 1);
        this.telemetry = telemetry;
        State = State.STOPPED;
    }

    public void updateState() {
        updatePower();
        transferMotor.readVelocity();

        if (transferMotor.getVelocity() == 0) {
            State = State.STOPPED;
        }

        if (transferMotor.getVelocity() != 0) {
            State = State.MOVING;
        }

        if (transferMotor.getVelocity() < 0){
            State = State.REVERSING;
        }
        telemetry.addData("Current State ", State);
        telemetry.addData("Power ", power);
        telemetry.addData("Velocity ", transferMotor.getVelocity());
    }

    public void updatePower() {
        transferMotor.set(power);
    }

    public void Move() {
        power = movePower;
    }

    public void Stop() {
        power = stopPower;
    }

    public void Reverse() {
        power = reversePower;
    }

    public boolean MOVING() {
        return State == State.MOVING;
    }

    public boolean STOPPED() {
        return State == State.STOPPED;
    }

    public boolean REVERSING() {
        return State == State.REVERSING;
    }
}