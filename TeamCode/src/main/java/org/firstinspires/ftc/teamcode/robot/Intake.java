package org.firstinspires.ftc.teamcode.robot;

import com.qualcomm.robotcore.hardware.Gamepad;
import org.firstinspires.ftc.robotcore.external.Telemetry;

/* Class for drive functionality. Called in other classes.
 */

public class Intake {
    Hardware robot;

    public Intake(Hardware hardware) {
        robot = hardware; // Constructor
    }

    public void intake(Gamepad gamepad, Telemetry telemetryInstance){ // The called method.

        if (gamepad.right_bumper) {
            robot.intakeLeft.setPower(0.5);
            robot.intakeRight.setPower(0.5);
        } else if (gamepad.left_bumper){
            robot.intakeLeft.setPower(-0.5);
            robot.intakeRight.setPower(-0.5);
        } else {
            robot.intakeLeft.setPower(0);
            robot.intakeRight.setPower(0);
        }

        telemetryInstance.addData("Intake Power: ", robot.intakeLeft.getPower());

    }
}
