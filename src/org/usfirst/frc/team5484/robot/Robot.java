/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5484.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoMode.PixelFormat;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team5484.robot.commands.*;
import org.usfirst.frc.team5484.robot.subsystems.*;

import com.mach.LightDrive.Color;

public class Robot extends TimedRobot {
	public static DriveTrain driveTrain;
	public static Intake intakeSystem;
	public static Lift liftSystem;
	public static Hang hangSystem;
	public static OI oi;

	Command autonomousCommand;
	SendableChooser<String> autoChooser = new SendableChooser<>();

	@Override
	public void robotInit() {
		RobotMap.init();
		
		driveTrain = new DriveTrain();
		intakeSystem = new Intake();
		liftSystem = new Lift();
		hangSystem = new Hang();
		oi = new OI();
		
		UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
		camera.setVideoMode(PixelFormat.kMJPEG, 320, 240, 10);

		autoChooser.addDefault("Cross Line", "CrossLine");
		autoChooser.addObject("Middle-Switch", "MiddleSwitch");
		autoChooser.addObject("Left Cross Line (Switch Priority)", "LeftCrossLineSwitchOption");
		autoChooser.addObject("Left-Scale (Switch Priority)", "LeftScaleSwitchPriority");
		autoChooser.addObject("Right Cross Line (Switch Priority)", "RightCrossLineSwitchOption");
		autoChooser.addObject("Right-Scale (Switch Priority)", "RightScaleSwitchPriority");
		SmartDashboard.putData("Auto mode: ", autoChooser);
	}

	@Override
	public void disabledInit() {
		
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void autonomousInit() {	
		String chooserCommand = autoChooser.getSelected();
		if(chooserCommand.equals("LeftCrossLineSwitchOption")) {
			autonomousCommand = new Autonomous_CrossLineSwitchOption_Left();
		}
		else if(chooserCommand.equals("RightCrossLineSwitchOption")) {
			autonomousCommand = new Autonomous_CrossLineSwitchOption_Right();
		}
		else if(chooserCommand.equals("MiddleSwitch")) {
			autonomousCommand = new Autonomous_Switch_Middle();
		}
		else if(chooserCommand.equals("LeftScaleSwitchPriority")) {
			autonomousCommand = new Autonomous_ScaleSwitchPriority_Left();
		}
		else if(chooserCommand.equals("RightScaleSwitchPriority")) {
			autonomousCommand = new Autonomous_ScaleSwitchPriority_Right();
		}
		if (autonomousCommand != null) {
			autonomousCommand.start();
		}
		else
		{
			autonomousCommand = new Autonomous_CrossLine();
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
