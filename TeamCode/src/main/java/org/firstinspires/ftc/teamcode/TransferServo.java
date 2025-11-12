package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.config.Config;

import com.arcrobotics.ftclib.util.Timing;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import java.util.concurrent.TimeUnit;

@TeleOp
@Config
public class TransferServo extends LinearOpMode {
    public Servo transferServo;
    public static double position = 0;

    public void runOpMode() {
        Timing.Timer timer = new Timing.Timer(1000, TimeUnit.MILLISECONDS);

        transferServo = hardwareMap.get(Servo.class, "TS");

        if (gamepad2.dpad_up) {
            transferServo.setPosition(.25);
        }

        if (gamepad2.dpad_down) {
            transferServo.setPosition(.75);
        }

        waitForStart();

        while (opModeIsActive()) {
            if (!timer.isTimerOn() && transferServo.getPosition() != position) {
                transferServo.setPosition(position);
                timer.start();
            }


            if (timer.done()) {
                timer.pause();
                telemetry.addData("Position Reached: ", true);
            }
            telemetry.addData("Elapsed Time: ", timer.elapsedTime());
            telemetry.addData("Current Position Get", transferServo.getPosition());
            telemetry.addData("Current Position ", position);
            telemetry.update();

        }
    }
}


