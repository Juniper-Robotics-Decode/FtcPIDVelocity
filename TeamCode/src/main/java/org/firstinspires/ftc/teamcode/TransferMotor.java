package org.firstinspires.ftc.teamcode;


import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;


import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

@TeleOp
@Config
public class TransferMotor extends LinearOpMode {

    public MotorEx transferMotor;
    public static double power = .5;

    @Override
    public void runOpMode() {

        transferMotor = new MotorEx(hardwareMap, "TM", Motor.GoBILDA.RPM_1150);
        this.telemetry = new MultipleTelemetry(telemetry, FtcDashboard.getInstance().getTelemetry());


        waitForStart();
        while (opModeIsActive()) {


            transferMotor.set(power);

            telemetry.addData("Current Power: ", power);
            telemetry.update();
        }
    }
}



