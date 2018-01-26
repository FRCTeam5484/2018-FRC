package org.usfirst.frc.team5484.robot.commands;

import org.usfirst.frc.team5484.robot.Robot;
import org.usfirst.frc.team5484.robot.RobotMap;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveToAngle extends Command implements PIDOutput {
	
	ADXRS450_Gyro robotGyro = RobotMap.driveTrainGyro;
	PIDController turnController;
	double requestedSpeed;
	double requestedAngle;
	double rotateToAngleRate;
	final double kP = 0.03;
	final double kI = 0.00;
	final double kD = 0.00;
	final double kF = 0.00;
	final double kToleranceDegrees = 2.0f;
	
    // Gets speed and angle and stores is for PIDController
	public DriveToAngle(double speed, double targetAngle) {
    	requires(Robot.driveTrain);
    	requestedSpeed = speed;
    	requestedAngle = targetAngle;
    }
    
	// Sets all the parameters for the PIDController
    protected void initialize() {
    	robotGyro.reset();
    	turnController = new PIDController(kP, kI, kD, kF, robotGyro, this);
        turnController.setInputRange(-180.0f,  180.0f);
        turnController.setOutputRange(-1.0, 1.0);
        turnController.setAbsoluteTolerance(kToleranceDegrees);
        turnController.setContinuous(true);
        turnController.setSetpoint(requestedAngle);
        turnController.enable();
    }
    
    // Turn robot at rate
    protected void execute() {
    	Robot.driveTrain.turnToAngle(.3, rotateToAngleRate);
    }
    
    // If not asking to turn, its finished
    protected boolean isFinished() {
    	return rotateToAngleRate == 0;
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
