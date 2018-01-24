package org.usfirst.frc.team5484.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5484.robot.Robot;
import org.usfirst.frc.team5484.robot.RobotMap;
/**
 *
 */
public class DriveForwardFor12Inches extends Command {

	double startDistance;
	
    public DriveForwardFor12Inches() {
        requires(Robot.driveTrain);
    }
    protected void initialize() {
    	startDistance = RobotMap.driveTrainUltrasonic.getRangeInches();
    	Robot.driveTrain.driveForward(.5);
    }
    protected void execute() {
    }
    protected boolean isFinished() {
    	return (startDistance-RobotMap.driveTrainUltrasonic.getRangeInches()) > 12;
    }
    protected void end() {
    	Robot.driveTrain.stopMotors();
    }
    protected void interrupted() {
    	end();
    }
}
