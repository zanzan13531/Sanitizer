package org.firstinspires.ftc.teamcode.robot;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;

public class Hardware {
    public DcMotor frontLeftDrive = null;
    public DcMotor frontRightDrive = null;
    public DcMotor backLeftDrive = null;
    public DcMotor backRightDrive = null;

//    public DcMotor leftEncoder;
//    public DcMotor rightEncoder;

    public DcMotor leftEncoder = null;

    HardwareMap hwMap = null;

    public Hardware()
    {
        // Constructor
    }

    public void init(HardwareMap ahwMap) {

        hwMap = ahwMap;

        // At convenience, change names and config of RL and RR to BL and BR, respectively.

        frontLeftDrive      = hwMap.get(DcMotor.class,      "FL");
        frontRightDrive     = hwMap.get(DcMotor.class,      "FR");
        backLeftDrive       = hwMap.get(DcMotor.class,      "BL");
        backRightDrive      = hwMap.get(DcMotor.class,      "BR");

//        leftEncoder         = hwMap.get(DcMotor.class,      "LeftEncoder");
//
//        leftEncoder         = hwMap.dcMotor.get("leftEncoder");

        frontLeftDrive. setDirection(DcMotor.Direction.FORWARD); // Set to REVERSE if using AndyMark motors
        frontRightDrive.setDirection(DcMotor.Direction.REVERSE);
        backLeftDrive.  setDirection(DcMotor.Direction.FORWARD);
        backRightDrive. setDirection(DcMotor.Direction.REVERSE);
    }
}
