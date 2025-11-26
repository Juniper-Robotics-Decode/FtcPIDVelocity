
package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;

import com.qualcomm.robotcore.hardware.HardwareMap;

public class Intaketransferhwmap {
    private final MotorEx intakeMotor;

    public Intaketransferhwmap(HardwareMap hardwareMap) {
        intakeMotor = new MotorEx(hardwareMap, "IM", Motor.GoBILDA.RPM_1150);


    }

    public MotorEx getIntakeMotor() {
        return intakeMotor;
    }
}




