package org.usfirst.frc.team6135.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team6135.robot.Robot;
import org.usfirst.frc.team6135.robot.RobotMap;

/**
 *
 */
public class SmartDashboardPrint extends InstantCommand {

    public SmartDashboardPrint() {
        super();
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called once when the command executes
    protected void initialize() {
        //SmartDashboard.putNumber("Left Encoder Distance", RobotMap.leftDriveEncoder.getDistance());
        //SmartDashboard.putNumber("Right Encoder Distance", RobotMap.rightDriveEncoder.getDistance());
//        
       // SmartDashboard.putNumber("Left Encoder Velocity", RobotMap.leftDriveEncoder.getRate());
       // SmartDashboard.putNumber("Right Encoder Velocity", RobotMap.rightDriveEncoder.getRate());
    
        //SmartDashboard.putBoolean("Climber on", Robot.climber.isOn);
    }

}
