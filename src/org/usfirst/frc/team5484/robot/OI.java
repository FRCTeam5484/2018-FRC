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
	public static JoystickButton button1;
	public static JoystickButton button2;
	public static JoystickButton button3;
	public static JoystickButton button4;
	public static JoystickButton button5;
	public static JoystickButton button6;
	public static JoystickButton button7;
	public static JoystickButton button8;
	public static JoystickButton button9;
	public static JoystickButton button10;
	
	public static JoystickButton liftLevel1Button;
	
    public static Joystick driverOne;
    public static Joystick driverTwo;

    public OI() {
        driverOne = new Joystick(0);
        driverTwo = new Joystick(1);
        button9 = new JoystickButton(driverTwo, 9);
        button10 = new JoystickButton(driverTwo, 10);
        liftLevel1Button = new JoystickButton(driverTwo, 1);
        
        button9.whileHeld(new IntakeGrabCube());
        button10.whileHeld(new IntakeEjectCube());
        liftLevel1Button.whenPressed(new IntakeGrabCube());
        
        SmartDashboard.putData("Take Cube In", new IntakeGrabCube());
        SmartDashboard.putData("Eject Cube Out", new IntakeEjectCube());
    }
//    public Joystick getbuttonBox() {
//        return driverOne;
//    }
    public double getDriverStickValue(int joyStickAxis){
    	return driverOne.getRawAxis(joyStickAxis);
    }
    
}
