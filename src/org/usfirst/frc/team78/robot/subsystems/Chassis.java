package org.usfirst.frc.team78.robot.subsystems;

import org.usfirst.frc.team78.robot.Robot;
import org.usfirst.frc.team78.robot.RobotMap;
import org.usfirst.frc.team78.robot.commands.DriveWithJoysticks;

import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Chassis extends Subsystem
	{
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	Victor leftDrive1 = new Victor(RobotMap.LEFT_DRIVE_1);
	Victor leftDrive2 = new Victor(RobotMap.LEFT_DRIVE_2);
	Victor rightDrive1 = new Victor(RobotMap.RIGHT_DRIVE_1);
	Victor rightDrive2 = new Victor(RobotMap.RIGHT_DRIVE_2);
	
	RobotDrive drive = new RobotDrive(leftDrive1, leftDrive2, rightDrive1, rightDrive2);
	
	

	
	//sensors
	
	Gyro gyro = new Gyro(RobotMap.GYRO);
	
	
	
    public void initDefaultCommand() 
    {
        // Set the default command for a subsystem here.
        setDefaultCommand (new DriveWithJoysticks());
  
    }//end initDefaultCommand
    
    
  //___________________________________________________________________________________________________________________________________________________
    
  //drive methods
    
    
    public void driveWithJoysticks(){
    	double left = Robot.oi.getDriverLeftStick();
    	double right = Robot.oi.getDriverRightStick();
    	drive.setSafetyEnabled(false);
    	drive.tankDrive(left, right);
   
    }//end driveWithJoysticks
    
    public void driveStraight(){
    	double power = Robot.oi.getDriverLeftStick();
    	drive.tankDrive(power, power);
    	
    }
    
    public void stopDrive()
    {
    	drive.tankDrive(0, 0);
    }
    
    //turn methods
     public void setSpeedLeft(double speed)
    {
    	drive.tankDrive(-speed, speed);
    } 
     
    public boolean hasTurnedDegrees(int degrees){
    	if(gyro.getAngle() < degrees){
    	return true;
    	}
    	return false;
    }

   //_____________________________________________________________________________________________________________________________________________________
    
     //sensor methods
     
     public double getGyro()
    {
    	return gyro.getAngle();
    }
   
}

