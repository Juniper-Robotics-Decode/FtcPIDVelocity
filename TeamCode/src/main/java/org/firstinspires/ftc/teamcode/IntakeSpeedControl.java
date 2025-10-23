package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.navigation.AngleUnit.RADIANS;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.arcrobotics.ftclib.controller.PIDController;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

@TeleOp
@Config
public class IntakeSpeedControl extends LinearOpMode {

    private Motor intakeMotor;
    private PIDController pidController;
    public static double p = 0.1, i = 0, d = 0.0015;
    private double currentVelocity;
    public static double targetVelocity = 0.5;
    public static final double TICKS_PER_ROT = 145.1;
    private double power = 0;

    @Override
    public void runOpMode() {
        intakeMotor = new Motor(hardwareMap, "IM", Motor.GoBILDA.RPM_1150);
        intakeMotor.setRunMode(Motor.RunMode.VelocityControl);
        pidController = new PIDController(p, i, d);
        this.telemetry = new MultipleTelemetry(telemetry, FtcDashboard.getInstance().getTelemetry());

        waitForStart();
        while (opModeIsActive()) {
            pidController.setPID(p, i, d);
            currentVelocity = intakeMotor.get();
            power += pidController.calculate(currentVelocity, targetVelocity);

            intakeMotor.set(power);

            telemetry.addData("Current Velocity (rot/sec): ", currentVelocity);
            telemetry.addData("Target Velocity (rot/sec): ", targetVelocity);
            telemetry.update();
        }
    }
}




















