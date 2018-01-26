package org.usfirst.frc.team5484.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5484.robot.Robot;

/**
 *
 */
public class DriveTrain_GoForwardForOneSecond extends Command {
	Timer pastMilliseconds;
	
    public DriveTrain_GoForwardForOneSecond() {
        requires(Robot.driveTrain);
    }
    protected void initialize() {
    	pastMilliseconds = new Timer();
    	pastMilliseconds.start();
    	
    }
    protected void execute() {
    	Robot.driveTrain.driveForward(.5);
    }
    protected boolean isFinished() {
        return pastMilliseconds.get() > 1;
    }
    protected void end() {
    	Robot.driveTrain.stopMotors();
    	pastMilliseconds.stop();
    	pastMilliseconds.reset();
    }
    protected void interrupted() {
    	end();
    }
}