package org.usfirst.frc.team5484.robot.commands;

import org.usfirst.frc.team5484.robot.Robot;
import org.usfirst.frc.team5484.robot.subsystems.Lift;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Autonomous_Scale_Right extends CommandGroup {

    public Autonomous_Scale_Right() {
    	if(Robot.FieldSetup.charAt(1) == 'L')
    	{
    		addSequential(new DriveTrain_DriveStraightForInches(.7, 240), 10);
    		addSequential(new DriveTrain_TurnToAngle(-90));
    		addSequential(new DriveTrain_DriveStraightForInches(.7, 180), 10);
    		addSequential(new DriveTrain_TurnToAngle(90));
	    	addParallel(new DriveTrain_DriveStraightForInches(.7, 24), 10);
	        addSequential(new Lift_MoveToPosition(Lift.MidScale));
	        addSequential(new Intake_EjectCube(.5));
    	}
    	else
    	{
    		addSequential(new DriveTrain_DriveStraightForInches(.7, 240), 10);
	    	addParallel(new DriveTrain_DriveStraightForInches(.7, 24), 10);
	        addSequential(new Lift_MoveToPosition(Lift.MidScale));
	        addSequential(new DriveTrain_TurnToAngle(-45));
	        addSequential(new Intake_EjectCube(.5));
    	}
    }
}
