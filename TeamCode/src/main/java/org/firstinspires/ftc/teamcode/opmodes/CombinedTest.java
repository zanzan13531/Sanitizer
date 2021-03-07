package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.robot.Drive;
import org.firstinspires.ftc.teamcode.robot.Hardware;
import org.firstinspires.ftc.teamcode.robot.Intake;
import org.firstinspires.ftc.teamcode.robot.Wobbler;

@TeleOp(name = "Test: Combined", group = "Test")
public class CombinedTest extends LinearOpMode {
    Hardware robot = new Hardware();
    Drive drive = new Drive(robot);
    Intake intake = new Intake(robot);
    Wobbler wobbler = new Wobbler(robot);

    public void runOpMode() {

        robot.init(hardwareMap);

        waitForStart();

        while(opModeIsActive()) {

            drive.drive(gamepad1, telemetry);
            intake.intake(gamepad1, telemetry);
            wobbler.wobble(gamepad1, telemetry);

            telemetry.update();

            sleep(25);
        }
    }

}
