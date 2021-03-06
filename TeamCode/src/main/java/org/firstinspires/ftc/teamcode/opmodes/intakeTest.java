package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.robot.Drive;
import org.firstinspires.ftc.teamcode.robot.Hardware;

@TeleOp(name = "Test: Billy", group = "Test")
public class intakeTest extends LinearOpMode {
    Hardware robot = new Hardware();
    Drive drive = new Drive(robot);

    public void runOpMode() {

        robot.init(hardwareMap);

        waitForStart();

        while(opModeIsActive()) {

            if (gamepad1.right_bumper) {
                robot.intakeLeft.setPower(0.5);
                robot.intakeRight.setPower(0.5);
            } else if (gamepad1.left_bumper){
                robot.intakeLeft.setPower(-0.5);
                robot.intakeRight.setPower(-0.5);
            } else {
                robot.intakeLeft.setPower(0);
                robot.intakeRight.setPower(0);
            }

            telemetry.update();

            sleep(25);
        }
    }
}
