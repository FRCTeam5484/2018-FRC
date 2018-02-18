package org.usfirst.frc.team5484.robot.commands;

import java.util.ArrayList;

import org.usfirst.frc.team5484.robot.Robot;
import org.usfirst.frc.team5484.robot.RobotMap;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveTrain_TurnToAngle extends Command implements PIDOutput {
	
	ADXRS450_Gyro robotGyro = RobotMap.driveTrainGyro;
	PIDController turnController;
	double requestedAngle;
	double rotateToAngleRate;
	double currentDegree;
	Timer timer;
    // Gets speed and angle and stores is for PIDController
	public DriveTrain_TurnToAngle(double targetAngle) {
    	requires(Robot.driveTrain);
    	requestedAngle = targetAngle;
    }
    
	// Sets all the parameters for the PIDController
    protected void initialize() {
    	robotGyro.reset();
    	timer = new Timer();
    	timer.start();
    	turnController = new PIDController(0.03, 0, 0, 0, robotGyro, this);
        turnController.setInputRange(-180.0f,  180.0f);
        turnController.setOutputRange(-0.5, 0.5);
        turnController.setAbsoluteTolerance(2);
        turnController.setContinuous(true);
        turnController.setSetpoint(requestedAngle);
        turnController.enable();
    }
    
    // Turn robot at rate
    protected void execute() {
    	Robot.driveTrain.turnToAngle(rotateToAngleRate);
    	currentDegree = robotGyro.getAngle();
    }
    
    // If not asking to turn, its finished
    protected boolean isFinished() {
    	System.out.println("Error Correction: " + rotateToAngleRate + " Current Angle: " + currentDegree);
    	return timer.get() > 2;
    	//return false;
//    	double HighValue = requestedAngle + kToleranceDegrees;
//    	double LowValue = requestedAngle - kToleranceDegrees;
//    	if(0.08 > rotateToAngleRate && (HighValue > currentDegree && currentDegree > LowValue))
//    	{
//    		return true;
//    	}
//    	else
//    	{
//    		return false;
//    	}
    }

    protected void end() {
    	Robot.driveTrain.stopMotors();
    }

    protected void interrupted() {
    	end();
    }
    
    // Sets the rate to rotate to the PID calculation
    @Override
    public void pidWrite(double output) {
        rotateToAngleRate = output;
    }
}
