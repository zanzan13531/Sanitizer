package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.robot.Hardware;
import org.firstinspires.ftc.teamcode.robot.Wobbler;

@TeleOp(name = "Test: Wobbler", group = "Test")
public class WobblerTest extends LinearOpMode {
    Hardware robot = new Hardware();
    Wobbler wobbler = new Wobbler(robot);

    public void runOpMode() {

        robot.init(hardwareMap);
//        wobbler.init();

        waitForStart();

        while(opModeIsActive()) {

            wobbler.wobble(gamepad1, telemetry);

            telemetry.update();

            sleep(25);
        }
    }

}
