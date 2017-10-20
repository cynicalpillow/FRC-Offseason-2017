package org.usfirst.frc.team6135.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team6135.robot.RobotMap;
import org.usfirst.frc.team6135.robot.commands.TeleopDrive;

/**
 *
 */
public class Drivetrain extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void setMotorsVBus(double leftVBus, double rightVBus){
        RobotMap.leftMasterDriveMotor.set(leftVBus);
        RobotMap.rightMasterDriveMotor.set(-1*rightVBus);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new TeleopDrive());
    }
}

