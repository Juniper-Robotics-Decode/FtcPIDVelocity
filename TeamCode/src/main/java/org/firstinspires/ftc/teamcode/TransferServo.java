package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;

import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
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
        this.telemetry = new MultipleTelemetry(telemetry, FtcDashboard.getInstance().getTelemetry());

        transferServo = hardwareMap.get(Servo.class, "TS");

        if (gamepad2.dpad_up) {
            transferServo.setPosition(.25);
        }

        if (gamepad2.dpad_down) {
            transferServo.setPosition(.75);
        }

        waitForStart();

        while (opModeIsActive()) {
            double percentError = Math.abs((transferServo.getPosition() - position) / position);
            if (!timer.isTimerOn() && percentError >= 0.001) {
                transferServo.setPosition(position);
                timer.start();
            }

            if (timer.done()) {
                timer.pause();
                telemetry.addData("Position Reached: ", true);
            } else {
                telemetry.addData("Position Reached: ", false);
            }


            telemetry.addData("Elapsed Time: ", timer.elapsedTime());
            telemetry.addData("Current Position Get", transferServo.getPosition());
            telemetry.addData("Current Position ", position);
            telemetry.update();

        }
    }
}


