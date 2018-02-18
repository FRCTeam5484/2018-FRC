/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5484.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import java.util.Random;

import org.usfirst.frc.team5484.robot.commands.*;
import org.usfirst.frc.team5484.robot.subsystems.*;

import com.mach.LightDrive.Color;

public class Robot extends TimedRobot {
	public static DriveTrain driveTrain;
	public static Intake intakeSystem;
	public static Lift liftSystem;
	public static OI oi;
	public static String RobotStatus = "Good";
	public static String FieldSetup;

	Command autonomousCommand;
	SendableChooser<Command> autoChooser = new SendableChooser<>();

	@Override
	public void robotInit() {
		RobotMap.init();
		driveTrain = new DriveTrain();
		intakeSystem = new Intake();
		liftSystem = new Lift();
		oi = new OI();
		
		if(DriverStation.getInstance().isFMSAttached())
		{
			FieldSetup = DriverStation.getInstance().getGameSpecificMessage();
		}
		else
		{
			Random r = new Random();
			String options = "LR";
			FieldSetup = Character.toString(options.charAt(r.nextInt(2))) + Character.toString(options.charAt(r.nextInt(2))) + Character.toString(options.charAt(r.nextInt(2))); 
		}
		
		//CameraServer.getInstance().startAutomaticCapture();
		
		//autoChooser.addDefault("Drive Forward", new DriveTrain_GoForwardFor12Inches());
		autoChooser.addObject("Drive for 1 second", new DriveTrain_GoForwardForOneSecond());
		SmartDashboard.putData("Auto mode", autoChooser);
		//SmartDashboard.putNumber("Gyro", RobotMap.driveTrainGyro.getAngle());
		SmartDashboard.putString("Field Setup: ", FieldSetup);
		SmartDashboard.putNumber("Lift POT: ", RobotMap.liftPOT.get());
		
	}

	@Override
	public void disabledInit() {
		if(RobotStatus.equals("Good"))
		{
			RobotMap.ledIndicators.SetColor(1, Color.GREEN);
			RobotMap.ledIndicators.SetColor(2, Color.GREEN);
			RobotMap.ledIndicators.SetColor(3, Color.GREEN);
			RobotMap.ledIndicators.SetColor(4, Color.GREEN);
			RobotMap.ledIndicators.Update();
		}
		else
		{
			RobotMap.ledIndicators.SetColor(1, Color.RED);
			RobotMap.ledIndicators.SetColor(2, Color.RED);
			RobotMap.ledIndicators.SetColor(3, Color.RED);
			RobotMap.ledIndicators.SetColor(4, Color.RED);
			RobotMap.ledIndicators.Update();
		}
		
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void autonomousInit() {
		autonomousCommand = autoChooser.getSelected();
		if (autonomousCommand != null) {
			autonomousCommand.start();
		}
	}

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		if (autonomousCommand != null) {
			autonomousCommand.cancel();
		}
		RobotMap.ledIndicators.SetColor(1, Color.OFF);
		RobotMap.ledIndicators.SetColor(2, Color.OFF);
		RobotMap.ledIndicators.SetColor(3, Color.OFF);
		RobotMap.ledIndicators.SetColor(4, Color.OFF);
		RobotMap.ledIndicators.Update();
	}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();		
	}

	@Override
	public void testPeriodic() {
	}
}
