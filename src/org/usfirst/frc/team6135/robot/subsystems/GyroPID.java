package org.usfirst.frc.team6135.robot.subsystems;

import org.usfirst.frc.team6135.robot.RobotMap;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class GyroPID extends PIDSubsystem {

    private static double kP=0.0,kI=0.0,kD=0.0;
    private ADXRS450_Gyro gyro = RobotMap.gyro;
    private double angleFix=0;
    public GyroPID() {
    	super(kP, kI, kD);
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
        return gyro.getAngle();
    }

    protected void usePIDOutput(double output) {
    	angleFix=output;
    }
    public double getAngleFix()
    {
    	return angleFix;
    }
}
