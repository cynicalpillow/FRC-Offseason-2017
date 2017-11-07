package org.usfirst.frc.team6135.robot;

import org.usfirst.frc.team6135.robot.commands.ChangeDefaultGearSpeed;
import org.usfirst.frc.team6135.robot.commands.OperateClimber;
import org.usfirst.frc.team6135.robot.commands.OperateGearIntake;
import org.usfirst.frc.team6135.robot.commands.PrecisionToggle;
import org.usfirst.frc.team6135.robot.commands.StopClimber;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
	public static final double LEFT_JS_DEADZONE_LIMIT = 0.3; // Deadzone limit for the left stick	
	public static final double RIGHT_JS_DEADZONE_LIMIT = 0.3; // Deadzone limit for the right stick	
	public static Joystick xboxController;
	public static JoystickButton climberClockwise;
	public static JoystickButton climberCounterClockwise;
	public static JoystickButton gearIntake;
	public static JoystickButton toggleGearDefaultSpeed;
	public static JoystickButton togglePrecisionMode;
	public OI(){
		xboxController = new Joystick(0);
		
		//Climber
		climberClockwise = new JoystickButton(xboxController, 5);
		climberCounterClockwise = new JoystickButton(xboxController, 6);
		climberClockwise.whenPressed(new OperateClimber(1, RobotMap.CLIMBER_SPEED));
		climberClockwise.whenReleased(new StopClimber());
		climberCounterClockwise.whenPressed(new OperateClimber(-1, RobotMap.CLIMBER_SPEED));
		climberCounterClockwise.whenReleased(new StopClimber());
		
		//Gear intake
		gearIntake = new JoystickButton(xboxController, 4);
		gearIntake.toggleWhenPressed(new OperateGearIntake(RobotMap.GEAR_INTAKE_SPEED));
		
		//Toggle buttons
		toggleGearDefaultSpeed = new JoystickButton(xboxController, 3);
		toggleGearDefaultSpeed.whenReleased(new ChangeDefaultGearSpeed());
		togglePrecisionMode = new JoystickButton(xboxController, 2);
		togglePrecisionMode.whenReleased(new PrecisionToggle());
	}
	public double applyDeadzone(double val, double dzLimit) {
    	return (Math.abs(val) > Math.abs(dzLimit)) ? val : 0.0;
    	/*double newVal = (Math.abs(val) - dzLimit * Math.signum(val)) / (1 - dzLimit * Math.signum(val));
    	return (Math.abs(val) > dzLimit) ? newVal : 0.0;*/ 
    }
}
