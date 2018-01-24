package org.usfirst.frc.team5484.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5484.robot.Robot;

/**
 *
 */
public class DriverForwardForOneSecond extends Command {
	Timer pastMilliseconds = new Timer();
	
    public DriverForwardForOneSecond() {
        requires(Robot.driveTrain);
    }
    protected void initialize() {
    	pastMilliseconds.start();
    	Robot.driveTrain.driveForward(.5);
    }
    protected void execute() {
    }
    protected boolean isFinished() {
        return (pastMilliseconds.get()/1000) > 1;
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