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
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.cscore.UsbCamera;

import java.util.Random;

import org.usfirst.frc.team5484.robot.commands.DriveTrain_GoForwardFor12Inches;
import org.usfirst.frc.team5484.robot.commands.DriveTrain_GoForwardForOneSecond;
import org.usfirst.frc.team5484.robot.subsystems.Lift;
import org.usfirst.frc.team5484.robot.subsystems.DriveTrain;
import org.usfirst.frc.team5484.robot.subsystems.Intake;

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
		
		UsbCamera camera;
		camera = CameraServer.getInstance().startAutomaticCapture();
		camera.setResolution(640, 480);
		camera.setFPS(5);
		
		autoChooser.addDefault("Drive Forward", new DriveTrain_GoForwardFor12Inches());
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
			RobotMap.ledIndicators.SetColor(1, Color.GREEN, (float)0.5);
			RobotMap.ledIndicators.SetColor(2, Color.GREEN, (float)0.5);
			RobotMap.ledIndicators.SetColor(3, Color.GREEN, (float)0.5);
			RobotMap.ledIndicators.SetColor(4, Color.GREEN, (float)0.5);
			RobotMap.ledIndicators.Update();
		}
		else
		{
			RobotMap.ledIndicators.SetColor(1, Color.RED, (float)0.5);
			RobotMap.ledIndicators.SetColor(2, Color.RED, (float)0.5);
			RobotMap.ledIndicators.SetColor(3, Color.RED, (float)0.5);
			RobotMap.ledIndicators.SetColor(4, Color.RED, (float)0.5);
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
