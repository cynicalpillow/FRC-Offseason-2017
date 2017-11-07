
package org.usfirst.frc.team6135.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team6135.robot.commands.DriveStraightDistance;
import org.usfirst.frc.team6135.robot.commands.DriveTime;
import org.usfirst.frc.team6135.robot.commands.SmartDashboardPrint;
import org.usfirst.frc.team6135.robot.subsystems.Climber;
import org.usfirst.frc.team6135.robot.subsystems.Drivetrain;
import org.usfirst.frc.team6135.robot.subsystems.GearIntake;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

    public static OI oi;
    public static Drivetrain drivetrain;
    public static SmartDashboard smartdashboard;
    public static Climber climber;
    public static GearIntake gearIntake;
    public static SendableChooser<Command> autoChooser;
    public static SmartDashboardPrint smartDashboardPrint;

	Command autonomousCommand;
//	SendableChooser<Command> chooser = new SendableChooser<>();

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    @Override
    public void robotInit() {
        RobotMap.init();
        
        smartdashboard = new SmartDashboard();
        drivetrain = new Drivetrain();
        climber = new Climber();
        gearIntake = new GearIntake();
        
        autoChooser = new SendableChooser<Command>();
        autoChooser.addObject("Drive past baseline", new DriveTime(1));
        SmartDashboard.putData("Autonomous", autoChooser);
        
        oi = new OI();
        
        //Camera feed initialization
        CameraServer.getInstance().startAutomaticCapture();
        
//		chooser.addDefault("Default Auto", new ExampleCommand());
        // chooser.addObject("My Auto", new MyAutoCommand());
//		SmartDashboard.putData("Auto mode", chooser);
    }

    /**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
     * the robot is disabled.
     */
    @Override
    public void disabledInit() {
//        Timer.delay(.5);
//        RobotMap.leftDriveEncoder.reset();
//        RobotMap.rightDriveEncoder.reset();
//        RobotMap.gyro.calibrate();
//        Timer.delay(3);
    }

    @Override
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
        RobotMap.leftMasterDriveMotor.setEncPosition(0);
        RobotMap.rightMasterDriveMotor.setEncPosition(0);
    }

    /**
     * This autonomous (along with the chooser code above) shows how to select
     * between different autonomous modes using the dashboard. The sendable
     * chooser code works with the Java SmartDashboard. If you prefer the
     * LabVIEW Dashboard, remove all of the chooser code and uncomment the
     * getString code to get the auto name from the text box below the Gyro
     * <p>
     * You can add additional auto modes by adding additional commands to the
     * chooser code above (like the commented example) or additional comparisons
     * to the switch structure below with additional strings & commands.
     */
    @Override
    public void autonomousInit() {
		autonomousCommand = autoChooser.getSelected();

		/*
         * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

        // schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();

       // DriveStraightDistance driveStraightDistance = new DriveStraightDistance(24);
       // driveStraightDistance.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    @Override
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        }

    @Override
    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
    	smartDashboardPrint = new SmartDashboardPrint();
		if (autonomousCommand != null)
			autonomousCommand.cancel();
    	
    }

    /**
     * This function is called periodically during operator control
     */
    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        SmartDashboard.putNumber("Climber speed", RobotMap.climberMotor.getSpeed());
        smartDashboardPrint.start();
    }

    /**
     * This function is called periodically during test mode
     */
    @Override
    public void testPeriodic() {
        LiveWindow.run();
    }
    public String AllianceColor()
    {
    	return DriverStation.getInstance().getAlliance()==DriverStation.Alliance.Blue ? "Blue":"Red";
    }
}
