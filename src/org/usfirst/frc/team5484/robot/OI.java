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
        
        grabCubeButton.whileHeld(new Intake_GrabCube());
        ejectCubeButton.whileHeld(new Intake_EjectCube());
        liftLevel1Button.whenPressed(new Intake_GrabCube());
        turn90Degrees.whenPressed(new DriveTrain_TurnToAngle(.2,90));
        driveStraightFor1Second.whenPressed(new DriveTrain_GoStraightBySeconds(.5, 1));
        makeASquare.whenPressed(new CommandGroup_DriveInASquare());
        stopMotors.whenPressed(new DriveTrain_StopAllMotors());
        driveForward.whenPressed(new DriveTrain_GoForwardForOneSecond());
        
        SmartDashboard.putData("Take Cube In", new Intake_GrabCube());
        SmartDashboard.putData("Eject Cube Out", new Intake_EjectCube());
    }
    
    public double getDriverStickValue(int joyStickAxis){
    	return driverOne.getRawAxis(joyStickAxis);
    }
    
}
