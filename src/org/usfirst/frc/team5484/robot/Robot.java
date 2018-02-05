/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5484.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team5484.robot.commands.DriveTrain_GoForwardFor12Inches;
import org.usfirst.frc.team5484.robot.commands.DriveTrain_GoForwardForOneSecond;
import org.usfirst.frc.team5484.robot.subsystems.CubeLift;
import org.usfirst.frc.team5484.robot.subsystems.DriveTrain;
import org.usfirst.frc.team5484.robot.subsystems.Intake;

import com.mach.LightDrive.Color;

public class Robot extends TimedRobot {
	public static DriveTrain driveTrain;
	public static Intake intakeSystem;
	public static CubeLift cubeLift;
	public static OI oi;
	public int ledCounter = 0;

	Command autonomousCommand;
	SendableChooser<Command> autoChooser = new SendableChooser<>();

	@Override
	public void robotInit() {
		RobotMap.init();
		driveTrain = new DriveTrain();
		intakeSystem = new Intake();
		cubeLift = new CubeLift();
		oi = new OI();

		autoChooser.addDefault("Drive Forward", new DriveTrain_GoForwardFor12Inches());
		autoChooser.addObject("Drive for 1 second", new DriveTrain_GoForwardForOneSecond());
		SmartDashboard.putData("Auto mode", autoChooser);
		SmartDashboard.putNumber("Gyro", RobotMap.driveTrainGyro.getAngle());
		
	}

	@Override
	public void disabledInit() {
		RobotMap.ledIndicators.SetColor(1, Color.BLUE, (float) 0.5);
		RobotMap.ledIndicators.SetColor(2, Color.RED, (float)0.5);
		RobotMap.ledIndicators.Update();
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
		RobotMap.ledIndicators.Update();
	}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		if(ledCounter++ < 100)
		{
			RobotMap.ledIndicators.SetColor(1, Color.RED);		
		}
		else if(ledCounter < 200)
		{
			RobotMap.ledIndicators.SetColor(1, Color.GREEN);	
		}
		else if(ledCounter < 400)
		{
			RobotMap.ledIndicators.SetColor(1, Color.BLUE);	
		}
		else if(ledCounter < 600)
		{
			RobotMap.ledIndicators.SetColor(1, Color.YELLOW);	
		}
		else if(ledCounter < 800)
		{
			RobotMap.ledIndicators.SetColor(1, Color.PURPLE);	
		}
		else if(ledCounter < 1000)
		{
			RobotMap.ledIndicators.SetColor(1, Color.TEAL);	
		}
		else if(ledCounter < 1200)
		{
			RobotMap.ledIndicators.SetColor(1, Color.WHITE);
		}
		else if(ledCounter < 1400)
		{
			RobotMap.ledIndicators.SetColor(1, Color.OFF);	
		}
		else if(ledCounter > 1600)
		{
			ledCounter = 0;
		}
		if(ledCounter % 2 == 0)
		{
			RobotMap.ledIndicators.SetColor(2, Color.RED);		
		}
		else
		{
			RobotMap.ledIndicators.SetColor(2, Color.BLUE);	
		}
		RobotMap.ledIndicators.Update();
		
	}

	@Override
	public void testPeriodic() {
	}
}
