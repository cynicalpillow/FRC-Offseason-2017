package org.usfirst.frc.team6135.robot.commands;

import org.usfirst.frc.team6135.robot.Robot;
import org.usfirst.frc.team6135.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class TeleopDrive extends Command {
    private static final int X_AXIS = 4;
    private static final int Y_AXIS = 1;

    private static final double DEADZONE = 0.15;

    public TeleopDrive() {
        requires(Robot.drivetrain);
    }

    protected void initialize() {
    }

    protected boolean isFinished() {
        return false;
    }

    protected void execute() {
//        double x;
//        double y;
//        double l;
//        double r;
//        x = xReverse * Robot.oi.xboxDrive.getRawAxis(X_AXIS);
//        y = yReverse * Robot.oi.xboxDrive.getRawAxis(Y_AXIS);
//
//        if (Math.abs(x) < 0.1) {
//            x = 0;
//        }
//        if (Math.abs(y) < 0.1) {
//            y = 0;
//        }
//
//        if (y > 0.0) {
//            if (x > 0.0) {
//                r = y - x;
//                l = Math.max(y, x);
//            } else {
//                r = Math.max(y, -x);
//                l = y + x;
//            }
//        } else {
//            if (x > 0.0) {
//                r = -Math.max(-y, x);
//                l = y + x;
//            } else {
//                r = y - x;
//                l = -Math.max(-y, -x);
//            }
//        }
//
        double x = Math.abs(Robot.oi.xboxController.getRawAxis(X_AXIS))>DEADZONE?Robot.oi.xboxController.getRawAxis(X_AXIS):0;
        double y = Math.abs(Robot.oi.xboxController.getRawAxis(Y_AXIS))>DEADZONE?-Robot.oi.xboxController.getRawAxis(Y_AXIS):0;
        double l = Math.max(-RobotMap.DRIVE_SPEED, Math.min(RobotMap.DRIVE_SPEED, y + x));//constrain to [-1,1]
        double r = Math.max(-RobotMap.DRIVE_SPEED, Math.min(RobotMap.DRIVE_SPEED, y - x));
        Robot.drivetrain.setMotorsVBus(l, r);
        //Robot.climber.set(l);
    }

    protected void end() { //never happens
        Robot.drivetrain.setMotorsVBus(0, 0);
    }

    protected void interrupted() {
        Robot.drivetrain.setMotorsVBus(0,0);
    }
}
