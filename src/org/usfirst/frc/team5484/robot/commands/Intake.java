package org.usfirst.frc.team5484.robot.commands;

import org.usfirst.frc.team5484.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Intake extends Command {

	Timer intakeTimer = new Timer();
	
    public Intake() {
        // Use requires() here to declare subsystem dependencies
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	intakeTimer.start();
    	RobotMap.intakeMotor.set(0.5);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(intakeTimer.get() >= 5000)
        {
        	return true;
        }
        else
        {
        	return false;
        }
    }

    // Called once after isFinished returns true
    protected void end() {
    	RobotMap.intakeMotor.set(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
