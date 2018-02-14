package org.usfirst.frc.team5484.robot.commands;

import org.usfirst.frc.team5484.robot.Robot;
import org.usfirst.frc.team5484.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class Lift_MoveToPosition extends Command {
	
	public double liftPosition;
	public double desiredPosition;
	public double highLevel;
	public double lowLevel;

    public Lift_MoveToPosition(double positionValue) {
        requires(Robot.liftSystem);
        desiredPosition = positionValue;
        highLevel = desiredPosition + 2;
        lowLevel = desiredPosition - 2;
        //System.out.println("Passed Value: " + positionValue + "  HighLevel: " + highLevel + "  LowLevel: " + lowLevel);
    }

    protected void initialize() {
    	liftPosition = RobotMap.getLiftPOTValue();
    }

   protected void execute() {
	   liftPosition = RobotMap.getLiftPOTValue();
	   System.out.println("Desired Position: " + desiredPosition + "  POT Value: " + liftPosition);
  	   if(desiredPosition < liftPosition)
  	   {
  		   if(!RobotMap.isTopLimitReached())
  		   {
  			   Robot.liftSystem.raiseLift();
  		   }
  		   else
  		   {
  			   end();
  		   }
  	   }
  	   else
  	   {
  		   Robot.liftSystem.lowerLift();
  	   }
    }

    protected boolean isFinished() {
    	if(highLevel > liftPosition && liftPosition > lowLevel)
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
