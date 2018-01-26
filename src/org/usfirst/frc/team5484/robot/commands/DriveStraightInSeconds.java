package org.usfirst.frc.team5484.robot.commands;

import org.usfirst.frc.team5484.robot.Robot;
import org.usfirst.frc.team5484.robot.RobotMap;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveStraightInSeconds extends Command implements PIDOutput{

	ADXRS450_Gyro robotGyro = RobotMap.driveTrainGyro;
	PIDController turnController;
	double requestedSpeed;
	double requestedSeconds;
	double rotateToAngleRate;
	final double kP = 0.03;
	final double kI = 0.00;
	final double kD = 1.00;
	final double kF = 0.00;
	final double kToleranceDegrees = 2.0f;
	Timer timer;
	
    public DriveStraightInSeconds(double speed, double seconds) {
    	requires(Robot.driveTrain);
    	requestedSpeed = speed;
    	requestedSeconds = seconds;
    }

    protected void initialize() {
    	robotGyro.reset();
    	timer = new Timer();
    	turnController = new PIDController(kP, kI, kD, kF, robotGyro, this);
        turnController.setInputRange(-180.0f,  180.0f);
        turnController.setOutputRange(-1.0, 1.0);
        turnController.setAbsoluteTolerance(kToleranceDegrees);
        turnController.setContinuous(true);
        turnController.setSetpoint(0);
        turnController.enable();
    	timer.start();
    }

    protected void execute() {
    	Robot.driveTrain.driveStraight(requestedSpeed, rotateToAngleRate);
    }

    protected boolean isFinished() {
        return timer.get() > requestedSeconds;
    }

    protected void end() {
    	Robot.driveTrain.stopMotors();
    	timer.stop();
    	timer.reset();
    }

    protected void interrupted() {
    	end();
    }
    
    @Override
    public void pidWrite(double output) {
        rotateToAngleRate = output;
    }
}
