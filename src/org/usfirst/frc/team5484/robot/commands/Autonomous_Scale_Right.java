package org.usfirst.frc.team5484.robot.commands;

import org.usfirst.frc.team5484.robot.Robot;
import org.usfirst.frc.team5484.robot.subsystems.Lift;
import org.usfirst.frc.team5484.robot.MatchData;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Autonomous_Scale_Right extends CommandGroup {
	
	private MatchData.OwnedSide scaleSide = null;

    public Autonomous_Scale_Right() {
    	scaleSide = MatchData.getOwnedSide(MatchData.GameFeature.SCALE);
    	if (scaleSide == MatchData.OwnedSide.LEFT) {
        	addParallel(new Lift_MoveToPosition(Lift.Switch),12);
    		addSequential(new DriveTrain_DriveStraightForInches(.9, 148));
    		addSequential(new DriveTrain_TurnToAngle(-95));
    		addSequential(new DriveTrain_DriveStraightForInches(.9, 139));
    		addSequential(new DriveTrain_TurnToAngle(82), 2);    	
	        addSequential(new Lift_MoveToPosition(Lift.HighScale),12);
	        addSequential(new DriveTrain_DriveStraightForInches(.7, 24));
	        addSequential(new Intake_EjectForSeconds(1));
	        addParallel(new DriveTrain_DriveStraightForInches(-.8, 10));
	        addSequential(new Lift_MoveToPosition(Lift.Floor), 5);
	        addSequential(new DriveTrain_TurnToAngle(160));
	        addParallel(new Intake_GrabCubeForSeconds(4.5), 4.5);
    	    addSequential(new DriveTrain_DriveStraightForInches(.6, 53)); 
    	    addSequential(new Lift_MoveToPosition(Lift.Switch));
        } else if (scaleSide == MatchData.OwnedSide.RIGHT) {
        	addParallel(new Lift_MoveToPosition(Lift.HighScale), 12);
    		addSequential(new DriveTrain_DriveStraightForInches(.95, 185), 3);
    		addSequential(new DriveTrain_TurnToAngle(-45), 2);
	        addSequential(new Intake_EjectForSeconds(1));
	        addParallel(new Lift_MoveToPosition(Lift.Floor), 12);
	        addSequential(new DriveTrain_TurnToAngle(-105));
	        addParallel(new Intake_GrabCubeForSeconds(4.5), 4);
    	    addSequential(new DriveTrain_DriveStraightForInches(.7, 53)); 
    	    addSequential(new Lift_MoveToPosition(Lift.Switch)); 	
        } else {
        	addParallel(new Lift_MoveToPosition(Lift.Switch), 4);
    		addSequential(new DriveTrain_DriveStraightForInches(.6, 140));
        }
    } 
}