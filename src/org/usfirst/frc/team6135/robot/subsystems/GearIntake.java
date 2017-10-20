package org.usfirst.frc.team6135.robot.subsystems;

import org.usfirst.frc.team6135.robot.RobotMap;
import org.usfirst.frc.team6135.robot.commands.StopGearIntake;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearIntake extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	private final VictorSP intakeVictor = RobotMap.fuelIntakeVictor;
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new StopGearIntake());
    }
    public void set(double vel) {
    	intakeVictor.set(vel);
    }
}

