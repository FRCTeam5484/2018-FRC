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

public class OI 
{
	public static JoystickButton raiseLiftButton;
	public static JoystickButton lowerLiftButton;
	public static JoystickButton grabCubeButton;
	public static JoystickButton ejectCubeButton;
	
	public static JoystickButton liftLevel1Button;
	
    public static Joystick driverOne;
    public static Joystick driverTwo;

    public OI() {
        driverOne = new Joystick(0);
        driverTwo = new Joystick(1);
        grabCubeButton = new JoystickButton(driverTwo, 9);
        ejectCubeButton = new JoystickButton(driverTwo, 10);        
        raiseLiftButton = new JoystickButton(driverTwo, 1);
        lowerLiftButton = new JoystickButton(driverTwo, 2);
        
        
        grabCubeButton.whileHeld(new Intake_GrabCube());
        ejectCubeButton.whileHeld(new Intake_EjectCube());
        raiseLiftButton.whileHeld(new RaiseCube());
        lowerLiftButton.whileHeld(new LowerCube());
        
        SmartDashboard.putData("Take Cube In", new Intake_GrabCube());
        SmartDashboard.putData("Eject Cube Out", new Intake_EjectCube());
    }
    
    public double getDriverOneStickValue(int joyStickAxis){
    	return driverOne.getRawAxis(joyStickAxis);
    }
    public double getDriverTwoStickValue(int joyStickAxis){
    	return driverTwo.getRawAxis(joyStickAxis);
    }
    
}
