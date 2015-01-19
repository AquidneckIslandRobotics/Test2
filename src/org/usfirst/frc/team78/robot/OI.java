package org.usfirst.frc.team78.robot;

import org.usfirst.frc.team78.robot.commands.TurnLeft;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;



/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */




public class OI {
	
 public JoystickButton turnLeftButton;
	public Joystick driverStick;
	public Button straight;
		
    
public OI(){
		driverStick = new Joystick(1);
		turnLeftButton = new JoystickButton(driverStick, 1);
		turnLeftButton.whenPressed(new TurnLeft());
		straight = new JoystickButton(driverStick, 2);
		
	}
	

	
	
	
	
	public double getDriverLeftStick(){
		return driverStick.getY();
	}
	public double getDriverRightStick(){
		return driverStick.getThrottle();
	}
	
	
}

