package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.robot.Drive;
import org.firstinspires.ftc.teamcode.robot.Hardware;
import org.firstinspires.ftc.teamcode.robot.Odometry;

@TeleOp(name = "Test: Odometry", group = "Test")
public class OdometryTest extends LinearOpMode {
    Hardware robot = new Hardware();
    Drive drive = new Drive(robot);
    Odometry odometry = new Odometry(robot);

    public void runOpMode() {

        robot.init(hardwareMap);
        odometry.init();

        waitForStart();

        while(opModeIsActive()) {

            drive.drive(gamepad1, telemetry);
            odometry.updatePosition();

            telemetry.addData("X: ", odometry.getX());
            telemetry.addData("Y: ", odometry.getY());
            telemetry.addData("W: ", odometry.getW());

            telemetry.update();

            sleep(25);
        }
    }
}
