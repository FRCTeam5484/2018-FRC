package org.usfirst.frc.team5484.robot.commands;

import org.usfirst.frc.team5484.robot.Robot;
import org.usfirst.frc.team5484.robot.subsystems.Lift;
import org.usfirst.frc.team5484.robot.MatchData;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Autonomous_ScaleSwitch_Left extends CommandGroup {

    public Autonomous_ScaleSwitch_Left() {
    	MatchData.OwnedSide side = MatchData.getOwnedSide(MatchData.GameFeature.SCALE);
        if (side == MatchData.OwnedSide.LEFT) {
        	addParallel(new Lift_MoveToPosition(Lift.Switch), 4);
    		addSequential(new DriveTrain_DriveStraightForInches(.95, 242));
    		addSequential(new DriveTrain_TurnToAngle(38));
    		addSequential(new Lift_MoveToPosition(Lift.HighScale), 12);
	        addSequential(new Intake_EjectForSeconds(1));
	        addParallel(new Lift_MoveToPosition(Lift.Floor), 12);
	        addSequential(new DriveTrain_TurnToAngle(105));
	        addParallel(new Intake_GrabCubeForSeconds(4.5), 4.5);
    	    addSequential(new DriveTrain_DriveStraightForInches(.9, 48), 4); 
    	    addSequential(new Lift_MoveToPosition(Lift.Switch));
    	    MatchData.OwnedSide switchside = MatchData.getOwnedSide(MatchData.GameFeature.SWITCH);
    	    if(switchside == MatchData.OwnedSide.LEFT)
    	    {
	    	    addSequential(new DriveTrain_DriveStraightForInches(.9, 5));
	    	    addSequential(new Intake_EjectForSeconds(1));
	    	    addSequential(new DriveTrain_DriveStraightForInches(-.9, 6));
	    	    addParallel(new Lift_MoveToPosition(Lift.Floor), 12);
    	    }
    	    else if(switchside == MatchData.OwnedSide.RIGHT)
    	    {
    	    	addSequential(new DriveTrain_DriveStraightForInches(-.9, 6));
    	    	addSequential(new DriveTrain_TurnToAngle(-45));
    	    	addSequential(new DriveTrain_DriveStraightForInches(.9, 184));
    	    	addSequential(new Lift_MoveToPosition(Lift.Switch));
    	    }
        } else if (side == MatchData.OwnedSide.RIGHT) {
        	addParallel(new Lift_MoveToPosition(Lift.Switch),12);
    		addSequential(new DriveTrain_DriveStraightForInches(.9, 225));
    		addSequential(new DriveTrain_TurnToAngle(98));
    		addSequential(new DriveTrain_DriveStraightForInches(.9, 184));
    		addSequential(new DriveTrain_TurnToAngle(-90));    	
	        addSequential(new Lift_MoveToPosition(Lift.MidScale),12);
	        addSequential(new DriveTrain_DriveStraightForInches(.75, 35));
	        addSequential(new Intake_EjectForSeconds(1));
	        addParallel(new DriveTrain_DriveStraightForInches(-.6, 6));
	        addSequential(new Lift_MoveToPosition(Lift.Floor), 12);
	        addSequential(new DriveTrain_TurnToAngle(-105));
	        addParallel(new Intake_GrabCubeForSeconds(4.5), 4.5);
    	    addSequential(new DriveTrain_DriveStraightForInches(.75, 53)); 
    	    addSequential(new Lift_MoveToPosition(Lift.Switch));
    	    MatchData.OwnedSide switchside = MatchData.getOwnedSide(MatchData.GameFeature.SWITCH);
    	    if(switchside == MatchData.OwnedSide.RIGHT)
    	    {
	    	    addSequential(new DriveTrain_DriveStraightForInches(.9, 5));
	    	    addSequential(new Intake_EjectForSeconds(1));
	    	    addSequential(new DriveTrain_DriveStraightForInches(-.9, 6));
	    	    addParallel(new Lift_MoveToPosition(Lift.Floor), 12);
    	    }
    	    else if(switchside == MatchData.OwnedSide.LEFT)
    	    {
    	    	addSequential(new DriveTrain_DriveStraightForInches(-.7, 6));
    	    	addSequential(new DriveTrain_TurnToAngle(-45));
    	    	addSequential(new DriveTrain_DriveStraightForInches(.9, 180));
    	    	addSequential(new Lift_MoveToPosition(Lift.Switch));
    	    }
        } else {
        	addParallel(new Lift_MoveToPosition(Lift.Switch), 4);
    		addSequential(new DriveTrain_DriveStraightForInches(.6, 140));
        }
    }
}
