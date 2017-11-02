package org.usfirst.frc.team6135.robot.commands;

import org.usfirst.frc.team6135.robot.RobotMap;
import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class ChangeDefaultGearSpeed extends InstantCommand {

    public ChangeDefaultGearSpeed() {
    	super();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	RobotMap.GEAR_INTAKE_DEFAULT_SPEED = RobotMap.GEAR_INTAKE_DEFAULT_SPEED == 0 ? 0.1 : 0;
    }
}
