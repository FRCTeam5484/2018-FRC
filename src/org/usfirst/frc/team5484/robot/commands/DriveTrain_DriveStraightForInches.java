package org.usfirst.frc.team5484.robot.commands;

import org.usfirst.frc.team5484.robot.Robot;
import org.usfirst.frc.team5484.robot.RobotMap;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.command.Command;

public class DriveTrain_DriveStraightForInches extends Command implements PIDOutput {

	ADXRS450_Gyro robotGyro = RobotMap.driveTrainGyro;
	PIDController turnController;
	double rotateToAngle;
	double inchesToMove;
	double driveTo;
	double driveSpeed;
	
    public DriveTrain_DriveStraightForInches(double speed, double inches) {
        requires(Robot.driveTrain);
        inchesToMove = inches;
        driveSpeed = speed;
    }

    protected void initialize() {
    	driveTo = RobotMap.driveTrainRightEncoder.getDistance() + inchesToMove;
    	robotGyro.reset();
    	turnController = new PIDController(0.03, 0, 0, 0, robotGyro, this);
        turnController.setInputRange(-10.0f,  10.0f);
        turnController.setOutputRange(-0.5, 0.5);
        turnController.setAbsoluteTolerance(2);
        turnController.setContinuous(true);
        turnController.setSetpoint(0);
        turnController.enable();
    }
    protected void execute() {
    	Robot.driveTrain.driveStraight(driveSpeed, rotateToAngle);
    }

    protected boolean isFinished() {
        if(driveTo < RobotMap.driveTrainRightEncoder.getDistance())
        {
        	return true;
        }
        else
        {
        	return false;
        }
    }
    protected void end() {
    	Robot.driveTrain.stopMotors();
    }
    protected void interrupted() {
    	end();
    }
    @Override
    public void pidWrite(double output) {
        rotateToAngle = output;
    }
}
