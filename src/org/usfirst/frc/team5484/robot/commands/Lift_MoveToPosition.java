package org.usfirst.frc.team5484.robot.commands;

import org.usfirst.frc.team5484.robot.Robot;
import org.usfirst.frc.team5484.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class Lift_MoveToPosition extends Command {
	
	public double desiredPosition;

    public Lift_MoveToPosition(double positionValue) {
        requires(Robot.liftSystem);
        desiredPosition = positionValue;
    }

    protected void initialize() {
    }

    protected void execute() {
	   if(RobotMap.liftPOT.get() < 10)
	   {
		   Robot.liftSystem.disable();
	   }
	   else
	   {
		   Robot.liftSystem.enable();
	   	   Robot.liftSystem.setSetpoint(desiredPosition);
	   }
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
