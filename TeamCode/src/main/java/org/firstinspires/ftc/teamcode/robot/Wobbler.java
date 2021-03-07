package org.firstinspires.ftc.teamcode.robot;

import com.qualcomm.robotcore.hardware.Gamepad;
import org.firstinspires.ftc.robotcore.external.Telemetry;

/* Class for drive functionality. Called in other classes.
 */

public class Wobbler {
    Hardware robot;

    public Wobbler(Hardware hardware) {
        robot = hardware;
    }

    public void setArmPosition(double position) {
        robot.wobbleArm1.setPosition(position);
        robot.wobbleArm2.setPosition(position);
        robot.wobbleArm3.setPosition(position);
        robot.wobbleArm4.setPosition(position);
    }

    public double getArmPosition() {
        return robot.wobbleArm1.getPosition();
    }

    public boolean isSynced() {
        return (robot.wobbleArm1.getPosition() == (1 - robot.wobbleArm2.getPosition()) &&
                robot.wobbleArm1.getPosition() == robot.wobbleArm3.getPosition()) &&
                robot.wobbleArm1.getPosition() == (1 - robot.wobbleArm4.getPosition());
    }

    public void wobble(Gamepad gamepad, Telemetry telemetryInstance) { // The called method.

        /* Telemetry for reference, debugging.
         */

        if (gamepad.x) {
            robot.wobbleClawLeft.setPosition(0.42);
            robot.wobbleClawRight.setPosition(0.16);
        } else {
            robot.wobbleClawLeft.setPosition(0.2);
            robot.wobbleClawRight.setPosition(0.4);
        }

        if (gamepad.dpad_up) {
            robot.wobbleArm1.setPosition(robot.wobbleArm1.getPosition() + 0.01);
            robot.wobbleArm2.setPosition(robot.wobbleArm2.getPosition() + 0.01);
            robot.wobbleArm3.setPosition(robot.wobbleArm3.getPosition() + 0.01);
            robot.wobbleArm4.setPosition(robot.wobbleArm4.getPosition() + 0.01);
        }

        if (gamepad.dpad_down) {
            robot.wobbleArm1.setPosition(robot.wobbleArm1.getPosition() - 0.01);
            robot.wobbleArm2.setPosition(robot.wobbleArm2.getPosition() - 0.01);
            robot.wobbleArm3.setPosition(robot.wobbleArm3.getPosition() - 0.01);
            robot.wobbleArm4.setPosition(robot.wobbleArm4.getPosition() - 0.01);
        }

        telemetryInstance.addData("Left Claw Pos: ", robot.wobbleClawLeft.getPosition());
        telemetryInstance.addData("Right Claw Pos: ", robot.wobbleClawRight.getPosition());
        telemetryInstance.addData("Arm Pos: ", getArmPosition());
        telemetryInstance.addData("Arm Pos 2: ", robot.wobbleArm2.getPosition());
        telemetryInstance.addData("Synchronized: ", isSynced());

    }
}
