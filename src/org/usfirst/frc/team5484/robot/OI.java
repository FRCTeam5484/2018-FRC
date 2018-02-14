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
	public static JoystickButton grabCubeButton;
	public static JoystickButton ejectCubeButton;
	
	public static JoystickButton liftLevel1Button;
	public static JoystickButton liftLevel2Button;
	public static JoystickButton liftLevel3Button;
	public static JoystickButton liftLevel4Button;
	public static JoystickButton liftLevel5Button;
	public static JoystickButton liftLevel6Button;
	
	public static JoystickButton liftSTOP;
	
    public static Joystick driverOne;
    public static Joystick driverTwo;

    public OI() {
        driverOne = new Joystick(0);
        driverTwo = new Joystick(1);
        
        liftLevel1Button = new JoystickButton(driverTwo, 2);
        liftLevel1Button.whenPressed(new Lift_MoveToPosition(101));
        
        liftLevel2Button = new JoystickButton(driverTwo, 3);
        liftLevel2Button.whenPressed(new Lift_MoveToPosition(85));
        
        liftLevel3Button = new JoystickButton(driverTwo, 4);
        liftLevel3Button.whenPressed(new Lift_MoveToPosition(61));
        
        liftLevel4Button = new JoystickButton(driverTwo, 6);
        liftLevel4Button.whenPressed(new Lift_MoveToPosition(52));
        
        liftLevel5Button = new JoystickButton(driverTwo, 7);
        liftLevel5Button.whenPressed(new Lift_MoveToPosition(44));
        
        liftLevel6Button = new JoystickButton(driverTwo, 8);
        liftLevel6Button.whenPressed(new Lift_MoveToPosition(35));
        
        liftSTOP = new JoystickButton(driverTwo, 1);
        liftSTOP.whenPressed(new Lift_StopLift());
        
        grabCubeButton = new JoystickButton(driverTwo, 9);
        grabCubeButton.whileHeld(new Intake_GrabCube());
        
        ejectCubeButton = new JoystickButton(driverTwo, 10);
        ejectCubeButton.whileHeld(new Intake_EjectCube());        
        
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
