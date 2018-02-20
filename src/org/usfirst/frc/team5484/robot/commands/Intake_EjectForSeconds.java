package org.usfirst.frc.team5484.robot.commands;

import org.usfirst.frc.team5484.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class Intake_EjectForSeconds extends Command {
	
	public static double totalSeconds;
    Timer time;
	public Intake_EjectForSeconds(double seconds) {
    	requires(Robot.intakeSystem);
    	totalSeconds = seconds;  	
    }

    protected void initialize() {
    	time = new Timer();
    	time.start();
    	Robot.intakeSystem.ejectCube(.5);
    }

    protected void execute() {    	
    }

    protected boolean isFinished() {
        if(time.get() > totalSeconds)
        {
        	return true;
        }
        else
        {
        	return false;
        }
    }

    protected void end() {
    	Robot.intakeSystem.stopIntake();
    }

    protected void interrupted() {
    	end();
    }
}
