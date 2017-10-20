package org.usfirst.frc.team6135.robot.subsystems;

import org.usfirst.frc.team6135.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class EncoderPID extends PIDSubsystem {

    // Initialize your subsystem here
	private static double kP=0;
	private static double kI=0;
	private static double kD=0;
//	private Encoder leftEnc=RobotMap.leftDriveEncoder;
//	private Encoder rightEnc=RobotMap.rightDriveEncoder;
	private double velocity=0;
    public EncoderPID() {
    	super(kP,kI,kD);
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    protected double returnPIDInput() {
    	return 0.0;
//        return (leftEnc.getDistance()+rightEnc.getDistance())/2;
    }
    protected void usePIDOutput(double output) {
    	velocity=output;
    }
    public double getVelocity()
    {
    	return velocity;
    }
}
