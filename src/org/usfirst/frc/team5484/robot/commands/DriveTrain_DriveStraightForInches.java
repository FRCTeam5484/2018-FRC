package org.usfirst.frc.team5484.robot.commands;

import org.usfirst.frc.team5484.robot.Robot;
import org.usfirst.frc.team5484.robot.RobotMap;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.command.Command;

public class DriveTrain_DriveStraightForInches extends Command implements PIDOutput {

	AHRS robotGyro = RobotMap.driveTrainGyro;
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
    	RobotMap.driveTrainRightEncoder.reset();
    	driveTo = RobotMap.driveTrainRightEncoder.getDistance() + inchesToMove;
    	robotGyro.reset();
    	turnController = new PIDController(0.03, 0, 0, 0, robotGyro, this);
        turnController.setInputRange(-10.0f,  10.0f);
        turnController.setOutputRange(-0.9, 0.9);
        turnController.setAbsoluteTolerance(0);
        turnController.setContinuous(true);
        turnController.setSetpoint(0);
        turnController.enable();
    }
    protected void execute() {
    	//System.out.println("POT Value: " + RobotMap.liftPOT.get() + " Encoder: " + RobotMap.driveTrainRightEncoder.getDistance());
    	Robot.driveTrain.driveStraight(driveSpeed, rotateToAngle);
    }

    protected boolean isFinished() {
    	//return turnController.onTarget();
        if(driveTo < Math.abs(RobotMap.driveTrainRightEncoder.getDistance()))
        {
        	turnController.disable();
        	return true;
        }
        else
        {
        	return false;
        }
    }
    protected void end() {
    	turnController.disable();
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
