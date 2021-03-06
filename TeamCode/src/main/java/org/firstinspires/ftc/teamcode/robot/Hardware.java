package org.firstinspires.ftc.teamcode.robot;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
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

    public DcMotor intakeLeft = null;
    public DcMotor intakeRight = null;

//    public DcMotor leftEncoder;
//    public DcMotor rightEncoder;

    public DcMotorEx leftEncoder = null;
    public DcMotorEx rightEncoder = null;
    public DcMotorEx frontEncoder = null;

    HardwareMap hwMap = null;

    public Hardware()
    {
        // Constructor
    }

    public void init(HardwareMap ahwMap) {

        hwMap = ahwMap;

        // At convenience, change names and config of RL and RR to BL and BR, respectively.

        frontLeftDrive      = hwMap.get(DcMotor.class,      "leftFront");  //left odometry encoder
        frontRightDrive     = hwMap.get(DcMotor.class,      "rightFront");  //right odometry encoder
        backLeftDrive       = hwMap.get(DcMotor.class,      "leftRear");  //back/front odometry encoder
        backRightDrive      = hwMap.get(DcMotor.class,      "rightRear");

        intakeLeft = hwMap.get(DcMotor.class, "intakeLeft");
        intakeRight = hwMap.get(DcMotor.class, "intakeRight");

        //leftEncoder = hwMap.get(DcMotorEx.class, "leftEncoder");
        //rightEncoder = hwMap.get(DcMotorEx.class, "rightEncoder");
        //frontEncoder = hwMap.get(DcMotorEx.class, "frontEncoder");

//        leftEncoder         = hwMap.get(DcMotor.class,      "LeftEncoder");
//
//        leftEncoder         = hwMap.dcMotor.get("leftEncoder");

        frontLeftDrive. setDirection(DcMotor.Direction.FORWARD); // Set to REVERSE if using AndyMark motors
        frontRightDrive.setDirection(DcMotor.Direction.REVERSE);
        backLeftDrive.  setDirection(DcMotor.Direction.FORWARD);
        backRightDrive. setDirection(DcMotor.Direction.REVERSE);

        intakeLeft.  setDirection(DcMotor.Direction.FORWARD);
        intakeRight. setDirection(DcMotor.Direction.REVERSE);
    }
}
