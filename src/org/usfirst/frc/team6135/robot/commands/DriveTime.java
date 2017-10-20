package org.usfirst.frc.team6135.robot.commands;

import org.usfirst.frc.team6135.robot.Robot;
import org.usfirst.frc.team6135.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.command.TimedCommand;

/**
 *
 */
public class DriveTime extends TimedCommand {

    public DriveTime(double timeout) {
        super(timeout);
        // Use requires() here to declare subsystem dependencies
        requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        Robot.drivetrain.setMotorsVBus(1,1);
    }

    // Called once after timeout
    protected void end() {
        Robot.drivetrain.setMotorsVBus(0,0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        Robot.drivetrain.setMotorsVBus(0,0);
    }
}
