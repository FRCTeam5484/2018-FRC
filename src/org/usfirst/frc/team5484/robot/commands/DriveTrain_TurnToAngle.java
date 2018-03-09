package org.usfirst.frc.team5484.robot.commands;

import java.util.ArrayList;

import org.usfirst.frc.team5484.robot.Robot;
import org.usfirst.frc.team5484.robot.RobotMap;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class DriveTrain_TurnToAngle extends Command implements PIDOutput {
	
	private AHRS robotGyro = RobotMap.driveTrainGyro;
	private PIDController turnController;
	private double rotateToAngleRate;
	private double rotateToAngle;
	private double currentDegree = 0;
	private Timer timer;
    
	// Gets speed and angle and stores is for PIDController
	public DriveTrain_TurnToAngle(double angle) {
    	requires(Robot.driveTrain);
    	rotateToAngle = angle;
    }
    
	// Sets all the parameters for the PIDController
    protected void initialize() {
    	robotGyro.reset();
    	currentDegree = 0;
    	timer = new Timer();
    	timer.start();
    	turnController = new PIDController(0.05, 0, 0, 0, robotGyro, this);
        turnController.setInputRange(-180,  180);
        turnController.setOutputRange(-.8, .8);
        turnController.setAbsoluteTolerance(2);
        turnController.setContinuous(false);
        turnController.setSetpoint(rotateToAngle);
        turnController.enable();
    }
    
    // Turn robot at rate
    protected void execute() {
    	Robot.driveTrain.turnToAngle(rotateToAngleRate);
    	currentDegree = robotGyro.getAngle();
    }
    
    // If not asking to turn, its finished
    protected boolean isFinished() {
    	//System.out.println("Error Correction: " + rotateToAngleRate + " Current Angle: " + currentDegree + " Current Targe: " + rotateToAngle);
    	return turnController.onTarget();
//    	if(timer.get() > 1.6)
//    	{
//    		return true;
//    	}
//    	else
//    	{
//    		return false;
//    	}
    }

    protected void end() {
    	turnController.disable();
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
