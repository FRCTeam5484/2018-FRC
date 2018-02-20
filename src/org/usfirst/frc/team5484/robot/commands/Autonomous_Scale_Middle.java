package org.usfirst.frc.team5484.robot.commands;

import org.usfirst.frc.team5484.robot.Robot;
import org.usfirst.frc.team5484.robot.subsystems.Lift;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Autonomous_Scale_Middle extends CommandGroup {

    public Autonomous_Scale_Middle() {
    	if(Robot.FieldSetup.charAt(1) == 'L')
    	{
    		addSequential(new DriveTrain_DriveStraightForInches(.7, 24));
    		//addSequential(new DriveTrain_TurnLeft90(-90));
    		addSequential(new DriveTrain_DriveStraightForInches(.7, 240), 10);
    		//addSequential(new DriveTrain_TurnLeft90(-90));
    		addSequential(new DriveTrain_DriveStraightForInches(.7, 180), 10);
    		//addSequential(new DriveTrain_TurnLeft90(90));
	    	addParallel(new DriveTrain_DriveStraightForInches(.7, 24), 10);
	        addSequential(new Lift_MoveToPosition(Lift.MidScale));
	        addSequential(new Intake_EjectCube(.5));
    	}
    	else
    	{
    		addSequential(new DriveTrain_DriveStraightForInches(.7, 240), 10);
	    	addParallel(new DriveTrain_DriveStraightForInches(.7, 24), 10);
	        addSequential(new Lift_MoveToPosition(Lift.MidScale));
	        //addSequential(new DriveTrain_TurnLeft90(-45));
	        addSequential(new Intake_EjectCube(.5));
    	}
    }
}
