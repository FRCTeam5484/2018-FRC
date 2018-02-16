package org.usfirst.frc.team5484.robot.commands;

import org.usfirst.frc.team5484.robot.Robot;
import org.usfirst.frc.team5484.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class Lift_DropLift extends Command {

    public Lift_DropLift() {
        requires(Robot.liftSystem);
    }

    protected void initialize() {
    	Robot.liftSystem.disable();
    	Robot.liftSystem.lowerLift();
    }

    protected void execute() {
    }

    protected boolean isFinished() {
    	if(RobotMap.isBottomLimitReached() || RobotMap.liftPOT.get() > 95)
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
