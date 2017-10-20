package org.usfirst.frc.team6135.robot.subsystems;

import org.usfirst.frc.team6135.robot.commands.SmartDashboardPrint;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class SmartDashboard extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new SmartDashboardPrint());
    }
}

