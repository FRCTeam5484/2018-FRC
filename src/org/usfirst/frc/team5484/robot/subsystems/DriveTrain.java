/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5484.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import org.usfirst.frc.team5484.robot.Robot;
import org.usfirst.frc.team5484.robot.RobotMap;
import org.usfirst.frc.team5484.robot.RobotMap.LiftLevel;
import org.usfirst.frc.team5484.robot.commands.DriveTrain_TeleopMode;

public class DriveTrain extends Subsystem {
	private static final SpeedController left1 = RobotMap.driveTrainLeft1;	
    private static final SpeedController left2 = RobotMap.driveTrainLeft2;
    
    private static final SpeedController right1 = RobotMap.driveTrainRight1;
    private static final SpeedController right2 = RobotMap.driveTrainRight2;
	
	private static final SpeedControllerGroup m_left = new SpeedControllerGroup(left1,left2);
	private static final SpeedControllerGroup m_right = new SpeedControllerGroup(right1,right2);
	
	public static DifferentialDrive robotDrive = new DifferentialDrive(m_left,m_right);
	
	private static final AnalogPotentiometer liftPOT = RobotMap.liftPOT;
		
	public void initDefaultCommand()	{
		setDefaultCommand(new DriveTrain_TeleopMode());
	}
    
	public void tankDrive()	{
		double potValue = liftPOT.get();
		double leftSide = Robot.oi.getDriverOneStickValue(1);
		double rightSide = Robot.oi.getDriverOneStickValue(5);
		if(potValue > 80)
		{
			// Full Power;
		}
		else if(potValue > 70)
		{
			leftSide = leftSide*.9;
			rightSide = rightSide*.9;
		}
		else if(potValue > 50)
		{
			leftSide = leftSide*.8;
			rightSide = rightSide*.8;
		}
		else if(potValue > 38)
		{
			leftSide = leftSide*.7;
			rightSide = rightSide*.7;
		}
		else if(potValue > 30)
		{
			leftSide = leftSide*.6;
			rightSide = rightSide*.6;
		}	
		else if (potValue < 0)
		{
			// Full Power
		}
		robotDrive.tankDrive(leftSide, rightSide, true);
		RobotMap.driveTrainRightEncoder.setDistancePerPulse(-0.058);
		System.out.println(RobotMap.driveTrainRightEncoder.getDistance());

	}
	public void stopMotors() {
		robotDrive.arcadeDrive(0, 0);
	}
	public void driveForward(double speed)	{
		robotDrive.arcadeDrive(speed, 0);
	}
	public void turnToAngle(double angle)	{
		robotDrive.arcadeDrive(0, -angle);
	}
	public void driveStraight(double speed, double angle)	{
		robotDrive.arcadeDrive(-speed, -angle);
	}
}
