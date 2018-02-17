package org.usfirst.frc.team5484.robot.commands;

import org.usfirst.frc.team5484.robot.Robot;
import org.usfirst.frc.team5484.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class Lift_HoldLift extends Command {
	
	public double desiredPosition;

    public Lift_HoldLift() {
    	requires(Robot.liftSystem);
    }

    protected void initialize() {
    	desiredPosition = RobotMap.liftPOT.get();
    }

    protected void execute() {
    	Robot.liftSystem.enable();
    	Robot.liftSystem.setSetpoint(desiredPosition);
    }

    protected boolean isFinished() {
    	return Robot.liftSystem.onTarget();
    }

    protected void end() {
    	Robot.liftSystem.stopLift();
    }

    protected void interrupted() {
    	end();
    }
}
