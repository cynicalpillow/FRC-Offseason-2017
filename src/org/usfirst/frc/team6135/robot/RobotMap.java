package org.usfirst.frc.team6135.robot;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;

    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;

    public static final int WHEEL_DIAMETER = 8; //inches
    public static final double WHEEL_CIRCUMFERENCE = WHEEL_DIAMETER * Math.PI;
    public static final int DRIVE_ENCODER_PPR = 2048;
    /***
     * EDIT THESE VALUES TO CHANGE SPEEDS
     * 
     * SPEEDS HAVE A MAX VALUE OF 1.0
     * AUTO_DISTANCE IS IN INCHES
     */
    public static final double AUTO_DISTANCE = 24;
    public static final double DRIVE_SPEED = 1.0;
    public static final double CLIMBER_SPEED = 0.6;
    public static final double GEAR_INTAKE_SPEED = 0.7;
    public static final double AUTO_SPEED = 0.5;

    public static CANTalon leftSlaveDriveMotor = new CANTalon(0);
    public static CANTalon leftMasterDriveMotor = new CANTalon(1);
    public static CANTalon rightSlaveDriveMotor = new CANTalon(2);
    public static CANTalon rightMasterDriveMotor = new CANTalon(3);

    public static Encoder leftDriveEncoder = new Encoder(0, 1, true, EncodingType.k4X);
    public static Encoder rightDriveEncoder = new Encoder(2, 3, false, EncodingType.k4X);

    public static ADXRS450_Gyro gyro = new ADXRS450_Gyro();
    
    //Climber
	public static VictorSP climberMotor = new VictorSP(5); //Change port for later
	
	//Gear Intake
	public static VictorSP fuelIntakeVictor = new VictorSP(6);

    public static void init() {
    	leftSlaveDriveMotor.changeControlMode(TalonControlMode.Follower);
    	leftSlaveDriveMotor.set(leftMasterDriveMotor.getDeviceID());
    	rightSlaveDriveMotor.changeControlMode(TalonControlMode.Follower);
    	rightSlaveDriveMotor.set(rightMasterDriveMotor.getDeviceID());

//    	leftMasterDriveMotor.setSafetyEnabled(true);
    	leftMasterDriveMotor.set(0);
//    	rightMasterDriveMotor.setSafetyEnabled(true);
    	rightMasterDriveMotor.set(0);
    	
    	leftMasterDriveMotor.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	leftMasterDriveMotor.configEncoderCodesPerRev(DRIVE_ENCODER_PPR);
    	rightMasterDriveMotor.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	rightMasterDriveMotor.configEncoderCodesPerRev(DRIVE_ENCODER_PPR);
    	
//    	RobotMap.leftMasterDriveMotor.setEncPosition(0);
//      RobotMap.leftMasterDriveMotor.reverseOutput(false);
//      RobotMap.leftMasterDriveMotor.reverseSensor(false);
//        RobotMap.rightMasterDriveMotor.setEncPosition(0);
    	rightMasterDriveMotor.reverseSensor(true);
//    	RobotMap.rightMasterDriveMotor.reverseOutput(false);

    	   	
        gyro.calibrate();
        Timer.delay(3);
    }
}
