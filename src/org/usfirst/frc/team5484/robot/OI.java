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
	public static JoystickButton driveForward;
	public static JoystickButton stopMotors;
	public static JoystickButton makeASquare;
	public static JoystickButton driveStraightFor1Second;
	public static JoystickButton turn90Degrees;
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
        liftLevel1Button = new JoystickButton(driverTwo, 1);
        turn90Degrees = new JoystickButton(driverOne, 1);
        driveStraightFor1Second = new JoystickButton(driverOne, 2);
        makeASquare = new JoystickButton(driverOne, 3);
        stopMotors = new JoystickButton(driverOne, 4);
        driveForward = new JoystickButton(driverOne, 8);
        
        grabCubeButton.whileHeld(new IntakeGrabCube());
        ejectCubeButton.whileHeld(new IntakeEjectCube());
        liftLevel1Button.whenPressed(new IntakeGrabCube());
        turn90Degrees.whenPressed(new DriveToAngle(.2,90));
        driveStraightFor1Second.whenPressed(new DriveStraightInSeconds(.5, 1));
        makeASquare.whenPressed(new MakeASquare());
        stopMotors.whenPressed(new stopAllMotors());
        driveForward.whenPressed(new DriverForwardForOneSecond());
        
        SmartDashboard.putData("Take Cube In", new IntakeGrabCube());
        SmartDashboard.putData("Eject Cube Out", new IntakeEjectCube());
    }
    
    public double getDriverStickValue(int joyStickAxis){
    	return driverOne.getRawAxis(joyStickAxis);
    }
    
}
