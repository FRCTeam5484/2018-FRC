package org.usfirst.frc.team5484.robot.commands;

import org.usfirst.frc.team5484.robot.Robot;
import org.usfirst.frc.team5484.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class RaiseCube extends Command {
	
	public RaiseCube() {
    	requires(Robot.liftSystem);
    }
    protected void initialize() {
    	Robot.liftSystem.raiseLift();
    }
    protected void execute() {
    	
    }
    protected boolean isFinished() {
        return RobotMap.isTopLimitReached();
    }
    protected void end() {
    	Robot.liftSystem.stopLift();
    }
    protected void interrupted() {
    	end();
    }
}