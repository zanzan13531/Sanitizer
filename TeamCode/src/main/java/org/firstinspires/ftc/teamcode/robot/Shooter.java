package org.firstinspires.ftc.teamcode.robot;

import com.qualcomm.robotcore.hardware.Gamepad;
import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Shooter {
    Hardware robot;

    public Shooter(Hardware hardware) {
        robot = hardware;
    }

    public void shoot(Gamepad gamepad, Telemetry telemetryInstance) {
        robot.shooter0.setPower(gamepad.right_trigger);
        robot.shooter1.setPower(gamepad.right_trigger);

        telemetryInstance.addData("Shooter Power: ", robot.shooter0.getPower());
    }
}
