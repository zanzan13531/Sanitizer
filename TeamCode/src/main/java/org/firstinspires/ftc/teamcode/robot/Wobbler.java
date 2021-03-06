package org.firstinspires.ftc.teamcode.robot;

import com.qualcomm.robotcore.hardware.Gamepad;
import java.lang.Math;
import org.firstinspires.ftc.robotcore.external.Telemetry;

/* Class for drive functionality. Called in other classes.
 */

public class Wobbler {
    Hardware robot;

    float MASTER_DRIVE_MULTIPLIER = 0.8f; // was 0.6// Multipliers
    float FORWARDNESS_MULTIPLIER = 0.5f; // was 0.5
    float STRAFENESS_MULTIPLIER = 0.8f;
    float TURNYNESS_MULTIPLIER = 0.8f;

    Boolean a_pressed = false;

    public Wobbler(Hardware hardware) {
        robot = hardware; // Constructor
    }

    public void wobble(Gamepad gamepad, Telemetry telemetryInstance){ // The called method.

        /* Telemetry for reference, debugging.
         */

        telemetryInstance.addData("Left Claw Pos: ", robot.clawLeft.getPosition());
        telemetryInstance.addData("Right Claw Pos: ", robot.clawLeft.getPosition());
        telemetryInstance.addData("Arm Pos: ", robot.clawLeft.getPosition());
        telemetryInstance.update();

    }
}
