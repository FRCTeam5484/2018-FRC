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
	
    public DriveToAngle(double speed, double targetAngle) {
    	requires(Robot.driveTrain);
    	requestedSpeed = speed;
    	requestedAngle = targetAngle;
    }
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
    protected void execute() {
    	Robot.driveTrain.turnToAngle(requestedSpeed, rotateToAngleRate);
    }

    protected boolean isFinished() {
    	return false;
    }

    protected void end() {
    	Robot.driveTrain.stopMotors();
    }

    protected void interrupted() {
    	end();
    }
    @Override
    public void pidWrite(double output) {
        rotateToAngleRate = output;
    }
}
