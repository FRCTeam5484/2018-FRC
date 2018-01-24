/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5484.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

import org.usfirst.frc.team5484.robot.Robot;
import org.usfirst.frc.team5484.robot.RobotMap;
import org.usfirst.frc.team5484.robot.commands.DriveWithJoysticks;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class DriveTrain extends Subsystem {
	private static final SpeedController left1 = RobotMap.driveTrainLeft1;	
    private static final SpeedController left2 = RobotMap.driveTrainLeft2;
    
    private static final SpeedController right1 = RobotMap.driveTrainRight1;
    private static final SpeedController right2 = RobotMap.driveTrainRight2;
	
	private static final SpeedControllerGroup m_left = new SpeedControllerGroup(left1,left2);
	private static final SpeedControllerGroup m_right = new SpeedControllerGroup(right1,right2);
	
	public static DifferentialDrive robotDrive = new DifferentialDrive(m_left,m_right);
	
	public void initDefaultCommand() 
	{
		setDefaultCommand(new DriveWithJoysticks());
	}
	
	public void tankDrive()
	{
		robotDrive.tankDrive(Robot.oi.getDriverStickValue(1), Robot.oi.getDriverStickValue(5), true);
	}
	public void stopMotors()
	{
		robotDrive.tankDrive(0, 0);
	}
	public void driveForward(double speed)
	{
		robotDrive.tankDrive(speed, speed, true);
	}
}
