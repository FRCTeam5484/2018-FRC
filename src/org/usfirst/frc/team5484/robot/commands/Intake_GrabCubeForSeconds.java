package org.usfirst.frc.team5484.robot.commands;

import org.usfirst.frc.team5484.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class Intake_GrabCubeForSeconds extends Command {

    Timer time;
    public static double totalSeconds;
    
	public Intake_GrabCubeForSeconds(double seconds) {
    	requires(Robot.intakeSystem);
    	totalSeconds = seconds;
    }

    protected void initialize() {
    	time = new Timer();
    	time.start();
    	Robot.intakeSystem.grabCube(.6);
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
