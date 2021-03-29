package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.robot.Shooter;
import org.firstinspires.ftc.teamcode.robot.Hardware;

@TeleOp(name = "Test: Shooter", group = "Test")
public class ShooterTest extends LinearOpMode {
    Hardware robot = new Hardware();
    Shooter shooter = new Shooter(robot);

    public void runOpMode() {

        robot.init(hardwareMap);

        waitForStart();

        while(opModeIsActive()) {

            shooter.shoot(gamepad1, telemetry);

            telemetry.update();

            sleep(25);
        }
    }
}
