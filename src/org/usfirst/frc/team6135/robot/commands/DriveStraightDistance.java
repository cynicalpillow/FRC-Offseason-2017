package org.usfirst.frc.team6135.robot.commands;

import org.usfirst.frc.team6135.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team6135.robot.RobotMap;


/**
 * heading_radians = (leftEncoderDistance - rightEncoderDistance)/TrackWidth
 */
public class DriveStraightDistance extends Command {

    private static double m_targetDistance;

    private static double leftDistance;
    private static double rightDistance;
    private static double leftError;
    private static double rightError;
    private static double leftSpeedVBus;
    private static double rightSpeedVBus;

    private static final double SPEED_ADJUSTMENT = 0.1;

    public DriveStraightDistance(double targetDistance) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.drivetrain);
        m_targetDistance = targetDistance;
        leftSpeedVBus = RobotMap.AUTO_SPEED;
        rightSpeedVBus = RobotMap.AUTO_SPEED;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        RobotMap.leftDriveEncoder.reset();
        RobotMap.rightDriveEncoder.reset();
        Robot.drivetrain.setMotorsVBus(leftSpeedVBus, rightSpeedVBus);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        leftDistance = RobotMap.leftDriveEncoder.getDistance();
        rightDistance = RobotMap.rightDriveEncoder.getDistance();
        leftError = m_targetDistance - leftDistance;
        rightError = m_targetDistance - rightDistance;

        if (leftError - rightError > 0.5) { //left error greater therefore right side is closer to setpoint

        } else if (leftError - rightError < -0.5) { //left error smaller therefore left side is closer to setpoint

        } else {
            leftSpeedVBus = RobotMap.AUTO_SPEED;
            rightSpeedVBus = RobotMap.AUTO_SPEED;
        }

        if (leftDistance - rightDistance > 0.5) {
            if (rightSpeedVBus == RobotMap.AUTO_SPEED) {
//                leftSpeedVBus = 0;
                leftSpeedVBus -= SPEED_ADJUSTMENT;
            } else {
//                rightSpeedVBus = 1;
                rightSpeedVBus += SPEED_ADJUSTMENT;
            }
        } else if (rightDistance - leftDistance > 0.5){
            if (leftSpeedVBus == RobotMap.AUTO_SPEED) {
//                rightSpeedVBus = 0;
                rightSpeedVBus -= SPEED_ADJUSTMENT;
            } else {
//                leftSpeedVBus = 1;
                leftSpeedVBus += SPEED_ADJUSTMENT;
            }
        } else{
            leftSpeedVBus = RobotMap.AUTO_SPEED;
            rightSpeedVBus = RobotMap.AUTO_SPEED;
        }
        Robot.drivetrain.setMotorsVBus(Math.copySign(leftSpeedVBus, m_targetDistance), Math.copySign(rightSpeedVBus, m_targetDistance));
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (Math.abs(leftDistance) >= Math.abs(m_targetDistance) && Math.abs(rightDistance) >= Math.abs(m_targetDistance)) {
            return true;
        } else {
            return false;
        }
    }

    // Called once after isFinished returns true
    protected void end() {
        Robot.drivetrain.setMotorsVBus(0, 0);
//        RobotMap.leftDriveEncoder.reset();
//        RobotMap.rightMasterDriveMotor.reset();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        Robot.drivetrain.setMotorsVBus(0, 0);
    }
}
