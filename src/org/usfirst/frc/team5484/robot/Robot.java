/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5484.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoMode;
import edu.wpi.cscore.VideoMode.PixelFormat;
import edu.wpi.first.wpilibj.CameraServer;
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
	public static Hang hangSystem;
	public static OI oi;
	public static String RobotStatus = "Good";
	public static String FieldSetup = "RRR";

	Command autonomousCommand;
	SendableChooser<Command> autoChooser = new SendableChooser<>();

	@Override
	public void robotInit() {
		RobotMap.init();
		
		driveTrain = new DriveTrain();
		intakeSystem = new Intake();
		liftSystem = new Lift();
		hangSystem = new Hang();
		oi = new OI();
		
		UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
		camera.setVideoMode(PixelFormat.kMJPEG, 520, 240, 30);
		//camera.setFPS(15);
		
		autoChooser.addDefault("Cross Line", new Autonomous_CrossLine());
		autoChooser.addObject("Left-Switch", new Autonomous_Switch_Left());
		autoChooser.addObject("Left-Scale", new Autonomous_Scale_Left());
		autoChooser.addObject("Left-Scale-Switch", new Autonomous_ScaleSwitch_Left());
		autoChooser.addObject("Right-Switch", new Autonomous_Switch_Right());
		autoChooser.addObject("Right-Scale", new Autonomous_Scale_Right());
		autoChooser.addObject("Right-Scale-Switch", new Autonomous_ScaleSwitch_Right());
		SmartDashboard.putData("Auto mode", autoChooser);
		SmartDashboard.putString("Field Setup: ", FieldSetup);
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
		if(DriverStation.getInstance().isFMSAttached())
		{
			try {FieldSetup = DriverStation.getInstance().getGameSpecificMessage();}
			catch(Exception ex){}
		}
	}

	@Override
	public void autonomousInit() {		
		FieldSetup = "";
		try { FieldSetup = DriverStation.getInstance().getGameSpecificMessage(); } catch(Exception ex) {}
		
		if(FieldSetup.length() < 2)
		{
			int pullAttempts = 100;
			while(FieldSetup.length() < 2 && pullAttempts > 0)
			{
				pullAttempts--;
				try {
					Thread.sleep(10);
					FieldSetup = DriverStation.getInstance().getGameSpecificMessage();
				} catch(Exception ex){}
			}
			if(FieldSetup.length() < 2)
			{
				autonomousCommand = new Autonomous_CrossLine();
				autonomousCommand.start();
			}
			else {
				autonomousCommand = autoChooser.getSelected();
				autonomousCommand.start();
			}
		}
		else
		{
			autonomousCommand = autoChooser.getSelected();
			if (autonomousCommand == null) {
				autonomousCommand = new Autonomous_CrossLine();
				autonomousCommand.start();
			}
			else
			{
				autonomousCommand.start();
			}				
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
