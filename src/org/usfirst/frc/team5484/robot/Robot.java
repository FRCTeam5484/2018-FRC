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

import org.usfirst.frc.team5484.robot.commands.DriveForwardFor12Inches;
import org.usfirst.frc.team5484.robot.commands.DriverForwardForOneSecond;
import org.usfirst.frc.team5484.robot.subsystems.DriveTrain;
import org.usfirst.frc.team5484.robot.subsystems.Intake;

public class Robot extends TimedRobot {
	public static DriveTrain driveTrain;
	public static Intake intakeSystem;
	public static OI oi;

	Command autonomousCommand;
	SendableChooser<Command> autoChooser = new SendableChooser<>();

	@Override
	public void robotInit() {
		RobotMap.init();
		driveTrain = new DriveTrain();
		intakeSystem = new Intake();
		oi = new OI();

		autoChooser.addDefault("Drive Forward", new DriveForwardFor12Inches());
		autoChooser.addObject("Drive for 1 second", new DriverForwardForOneSecond());
		SmartDashboard.putData("Auto mode", autoChooser);
		SmartDashboard.putNumber("Gyro", RobotMap.driveTrainGyro.getAngle());
		
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
	}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void testPeriodic() {
	}
}
