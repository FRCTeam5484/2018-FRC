package org.usfirst.frc.team5484.robot.commands;

import org.usfirst.frc.team5484.robot.RobotMap;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.command.Command;

public class SensorData_Gyro extends Command {
	AHRS robotGyro = RobotMap.driveTrainGyro;
    public SensorData_Gyro() {
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	robotGyro.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	System.out.println("Angle: " + robotGyro.getAngle());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
