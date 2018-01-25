package org.usfirst.frc.team5484.robot.commands;

import org.usfirst.frc.team5484.robot.Robot;
import org.usfirst.frc.team5484.robot.RobotMap;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveToAngle extends Command {
	public static ADXRS450_Gyro robotGyro = RobotMap.driveTrainGyro;
	private static final double Kp = 0.03;
	private static double requestedSpeed;
	private static double requestedAngle;
	
    public DriveToAngle(double speed, double targetAngle) {
    	requires(Robot.driveTrain);
    	requestedSpeed = speed;
    	requestedAngle = targetAngle;
    }
    protected void initialize() {
    	robotGyro.reset();
    }
    protected void execute() {
    	Robot.driveTrain.turnToAngle(requestedSpeed, requestedAngle * Kp);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return isBetween(robotGyro.getAngle(), requestedAngle+2, requestedAngle-2);
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
    
    public static boolean isBetween(double numberToCheck, double firstNumber, double secondNumber) {
        return secondNumber > firstNumber ? numberToCheck > firstNumber && numberToCheck < secondNumber : numberToCheck > secondNumber && numberToCheck < firstNumber;
    }
}
