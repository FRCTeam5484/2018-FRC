package org.usfirst.frc.team5484.robot.commands;

import org.usfirst.frc.team5484.robot.Robot;
import org.usfirst.frc.team5484.robot.subsystems.Lift;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Autonomous_Scale_Right extends CommandGroup {

    public Autonomous_Scale_Right() {
    	if(Robot.FieldSetup.charAt(1) == 'L')
    	{
    		addParallel(new Lift_MoveToPosition(Lift.Switch), 4);
    		addSequential(new DriveTrain_DriveStraightForInches(.9, 230));
    		addSequential(new DriveTrain_TurnToAngle(-85));
    		addSequential(new DriveTrain_DriveStraightForInches(.9, 170));
    		addSequential(new DriveTrain_TurnToAngle(113));    	
	        addSequential(new Lift_MoveToPosition(Lift.HighScale), 12);
	        addSequential(new DriveTrain_DriveStraightForInches(.65, 30));
	        addSequential(new Intake_EjectForSeconds(1));
	        addSequential(new DriveTrain_GoBackwardsForSeconds(2));
	        addSequential(new Lift_MoveToPosition(Lift.Floor), 12);
    	}
    	else
    	{
    		addParallel(new Lift_MoveToPosition(Lift.Switch), 7);
    		addSequential(new DriveTrain_DriveStraightForInches(.8, 275));
    		addSequential(new DriveTrain_TurnToAngle(-45));
    		//addSequential(new DriveTrain_DriveStraightForInches(-.7, 6));
    		addSequential(new Lift_MoveToPosition(Lift.MidScale), 12);
    		//addSequential(new DriveTrain_DriveStraightForInches(.6, 10));
    	    addSequential(new Intake_EjectForSeconds(1));   
    	    addParallel(new Lift_MoveToPosition(Lift.Floor), 2);   	    	
    	}
    }
}