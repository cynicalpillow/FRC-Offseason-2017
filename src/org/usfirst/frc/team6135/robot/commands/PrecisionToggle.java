package org.usfirst.frc.team6135.robot.commands;

import org.usfirst.frc.team6135.robot.RobotMap;
import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class PrecisionToggle extends InstantCommand {

    public PrecisionToggle() {
    	super();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	RobotMap.PRECISION_SCALAR = RobotMap.PRECISION_SCALAR == 1.0 ? 0.5 : 1.0;
    }
}
