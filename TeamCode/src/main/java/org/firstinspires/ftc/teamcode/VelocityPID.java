package org.firstinspires.ftc.teamcode;
import static org.firstinspires.ftc.robotcore.external.navigation.AngleUnit.normalizeDegrees;

import com.arcrobotics.ftclib.controller.PIDFController;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

public class VelocityPID extends LinearOpMode{
    DcMotorEx motor;
    static public double vP = 0.0;
    static public double vI = 0.0;
    static public double vD = 0.0;
    static public double vF = 0.0;

    public double targetVelocity = 0;

    private PIDFController pidfController;

    @Override
    public void runOpMode(){
        motor = hardwareMap.get(DcMotorEx.class, "Motor");
        pidfController = new PIDFController(0,0,0,0);
        waitForStart();
        while (opModeIsActive()){
            updatePID();
        }
    }

    public void updatePID() { // This method is used to update position every loop.

        double measuredVelocity = motor.getVelocity();


            // The error - sign (which finds velocity)
            double error = targetVelocity - measuredVelocity;

            // We use zero because we already calculate for error
            double power = pidfController.calculate(0, error);
            motor.setVelocity(power);
        }

}
