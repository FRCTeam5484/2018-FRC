/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5484.robot;
import org.usfirst.frc.team5484.robot.commands.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.XboxController;

public class OI 
{
	public static JoystickButton driverOneButton_GrabCube;
	public static JoystickButton driverOneButton_EjectCube;
	
	public static JoystickButton driverTwoButton_LiftSwitch;
	public static JoystickButton driverTwoButton_LiftLowScale;
	public static JoystickButton driverTwoButton_LiftMidScale;
	public static JoystickButton driverTwoButton_LiftHighScale;
	public static JoystickButton driverTwoButton_LiftTopScale;
	public static JoystickButton driverTwoButton_IntakeGrab;
	public static JoystickButton driverTwoButton_IntakeEject;
	
	public static JoystickButton liftSTOP;
	
    public static XboxController driverOne;
    public static Joystick driverTwo;

    public OI() {
    	driverOne = new XboxController(0);
    	driverTwo = new Joystick(1);
        
        // Driver One Functions
    	driverOneButton_GrabCube = new JoystickButton(driverOne, 5);
    	driverOneButton_GrabCube.whileHeld(new Intake_GrabCube(.7));
        
    	driverOneButton_EjectCube = new JoystickButton(driverOne, 6);
    	driverOneButton_EjectCube.whileHeld(new Intake_EjectCube(.7));
        
        // Driver Two Functions
    	driverTwoButton_LiftSwitch = new JoystickButton(driverTwo, 4);
    	driverTwoButton_LiftSwitch.whenPressed(new Lift_MoveToPosition(RobotMap.LiftLevel.Switch.potValue()));
        
    	driverTwoButton_LiftLowScale = new JoystickButton(driverTwo, 5);
    	driverTwoButton_LiftLowScale.whenPressed(new Lift_MoveToPosition(RobotMap.LiftLevel.LowScale.potValue()));
        
    	driverTwoButton_LiftMidScale = new JoystickButton(driverTwo, 6);
    	driverTwoButton_LiftMidScale.whenPressed(new Lift_MoveToPosition(RobotMap.LiftLevel.MidScale.potValue()));
        
    	driverTwoButton_LiftHighScale = new JoystickButton(driverTwo, 7);
    	driverTwoButton_LiftHighScale.whenPressed(new Lift_MoveToPosition(RobotMap.LiftLevel.HighScale.potValue()));
        
    	driverTwoButton_LiftTopScale = new JoystickButton(driverTwo, 8);
    	driverTwoButton_LiftTopScale.whenPressed(new Lift_MoveToPosition(RobotMap.LiftLevel.TopScale.potValue()));
        
    	driverTwoButton_IntakeGrab = new JoystickButton(driverTwo, 9);
    	driverTwoButton_IntakeGrab.whileHeld(new Intake_GrabCube(.7));
        
    	driverTwoButton_IntakeEject = new JoystickButton(driverTwo, 10);
    	driverTwoButton_IntakeEject.whileHeld(new Intake_EjectCube(.7));
                
        SmartDashboard.putData("Take Cube In", new Intake_GrabCube(.7));
        SmartDashboard.putData("Eject Cube Out", new Intake_EjectCube(.7));
    }
    
    public double getDriverOneStickValue(int joyStickAxis){
    	return driverOne.getRawAxis(joyStickAxis);
    }
    public double getDriverTwoStickValue(int joyStickAxis){
    	return driverTwo.getRawAxis(joyStickAxis);
    }
    
}
