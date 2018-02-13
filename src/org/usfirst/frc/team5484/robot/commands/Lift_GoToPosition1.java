package org.usfirst.frc.team5484.robot.commands;

import org.usfirst.frc.team5484.robot.Robot;
import org.usfirst.frc.team5484.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class Lift_GoToPosition1 extends Command {

    public static double liftPosition;
    public static double desiredPosition = 5;
    
	public Lift_GoToPosition1() {
        requires(Robot.liftSystem);
    }

    protected void initialize() {
    }

    protected void execute() {
    	 liftPosition = RobotMap.getLiftPOTValue();
    	 if(liftPosition < 5)
    	 {
    		 Robot.liftSystem.raiseLift();
    	 }
    	 else
    	 {
    		 Robot.liftSystem.lowerLift();
    	 }
    }
    protected boolean isFinished() {
        if(6 > liftPosition && liftPosition > 4)
        {
        	return true;
        }
        else
        {
        	return false;
        }
    }
    protected void end() {
    	Robot.liftSystem.stopLift();
    }

    protected void interrupted() {
    	end();
    }
}