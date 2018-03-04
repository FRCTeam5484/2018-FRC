package org.usfirst.frc.team5484.robot.commands;

import org.usfirst.frc.team5484.robot.Robot;
import org.usfirst.frc.team5484.robot.MatchData;
import org.usfirst.frc.team5484.robot.subsystems.Lift;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Autonomous_ScaleSwitch_Right extends CommandGroup {
	
	private MatchData.OwnedSide ownedSide = null;
	private MatchData.OwnedSide switchSide = null;

    public Autonomous_ScaleSwitch_Right() {
    	ownedSide = MatchData.getOwnedSide(MatchData.GameFeature.SCALE);
    	switchSide = MatchData.getOwnedSide(MatchData.GameFeature.SWITCH);
    	if (ownedSide == MatchData.OwnedSide.LEFT) {
        	addParallel(new Lift_MoveToPosition(Lift.Switch),12);
    		addSequential(new DriveTrain_DriveStraightForInches(.9, 225));
    		addSequential(new DriveTrain_TurnToAngle(-87));
    		addSequential(new DriveTrain_DriveStraightForInches(.85, 184));
    		addSequential(new DriveTrain_TurnToAngle(90));    	
	        addSequential(new Lift_MoveToPosition(Lift.TopScale),12);
	        addSequential(new DriveTrain_DriveStraightForInches(.75, 40));
	        addSequential(new Intake_EjectForSeconds(1));
	        addParallel(new DriveTrain_DriveStraightForInches(-.6, 6));
	        addSequential(new Lift_MoveToPosition(Lift.Floor), 12);
	        addSequential(new DriveTrain_TurnToAngle(105));
	        addParallel(new Intake_GrabCubeForSeconds(4.5), 4.5);
    	    addSequential(new DriveTrain_DriveStraightForInches(.75, 53)); 
    	    addSequential(new Lift_MoveToPosition(Lift.Switch));
    	    if(switchSide == MatchData.OwnedSide.LEFT)
    	    {
	    	    addSequential(new DriveTrain_DriveStraightForInches(.9, 5));
	    	    addSequential(new Intake_EjectForSeconds(1));
	    	    addSequential(new DriveTrain_DriveStraightForInches(-.7, 6));
	    	    addParallel(new Lift_MoveToPosition(Lift.Floor), 12);
    	    }
    	    else if(switchSide == MatchData.OwnedSide.RIGHT)
    	    {
    	    	addSequential(new DriveTrain_DriveStraightForInches(-.9, 6));
    	    	addSequential(new DriveTrain_TurnToAngle(45));
    	    	addSequential(new DriveTrain_DriveStraightForInches(.9, 180));
    	    	addSequential(new Lift_MoveToPosition(Lift.Switch));
    	    }
        } else if (ownedSide == MatchData.OwnedSide.RIGHT) {
        	addParallel(new Lift_MoveToPosition(Lift.Switch), 4);
    		addSequential(new DriveTrain_DriveStraightForInches(.95, 242));
    		addSequential(new DriveTrain_TurnToAngle(-38));
    		addSequential(new Lift_MoveToPosition(Lift.HighScale), 12);
	        addSequential(new Intake_EjectForSeconds(1));
	        addParallel(new Lift_MoveToPosition(Lift.Floor), 12);
	        addSequential(new DriveTrain_TurnToAngle(-105));
	        addParallel(new Intake_GrabCubeForSeconds(4.5), 4.5);
    	    addSequential(new DriveTrain_DriveStraightForInches(.6, 53)); 
    	    addSequential(new Lift_MoveToPosition(Lift.Switch));
    	    if(switchSide == MatchData.OwnedSide.RIGHT)
    	    {
	    	    addSequential(new DriveTrain_DriveStraightForInches(.9, 5));
	    	    addSequential(new Intake_EjectForSeconds(1));
	    	    addSequential(new DriveTrain_DriveStraightForInches(-.7, 6));
	    	    addParallel(new Lift_MoveToPosition(Lift.Floor), 12);
    	    }
    	    else if(switchSide == MatchData.OwnedSide.LEFT)
    	    {
    	    	addSequential(new DriveTrain_DriveStraightForInches(-.7, 6));
    	    	addSequential(new DriveTrain_TurnToAngle(45));
    	    	addSequential(new DriveTrain_DriveStraightForInches(.9, 180));
    	    	addSequential(new Lift_MoveToPosition(Lift.Switch));
    	    }
        } else {
        	addParallel(new Lift_MoveToPosition(Lift.Switch), 4);
    		addSequential(new DriveTrain_DriveStraightForInches(.6, 140));
        }
    }
}