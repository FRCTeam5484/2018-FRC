package org.usfirst.frc.team5484.robot.commands;

import org.usfirst.frc.team5484.robot.MatchData;
import org.usfirst.frc.team5484.robot.subsystems.Lift;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Autonomous_ScaleSwitchPriority_Right extends CommandGroup {

	private MatchData.OwnedSide scaleSide = null;
	private MatchData.OwnedSide switchSide = null;

    public Autonomous_ScaleSwitchPriority_Right() {
    	scaleSide = MatchData.getOwnedSide(MatchData.GameFeature.SCALE);
    	switchSide = MatchData.getOwnedSide(MatchData.GameFeature.SWITCH);
    	if (switchSide == MatchData.OwnedSide.RIGHT) {
    		addParallel(new Lift_MoveToPosition(Lift.Switch));
    		addSequential(new DriveTrain_DriveStraightForInches(.75, 130));
    		addSequential(new DriveTrain_TurnToAngle(-90));
	        addSequential(new DriveTrain_DriveStraightForInches(.75, 7), 2);
	        addSequential(new Intake_EjectForSeconds(1));
	        //addParallel(new Lift_MoveToPosition(Lift.Floor));
	        addSequential(new DriveTrain_DriveStraightForInches(-.6, 10));
        } else if (scaleSide == MatchData.OwnedSide.LEFT) {
        	addParallel(new Lift_MoveToPosition(Lift.Switch),12);
    		addSequential(new DriveTrain_DriveStraightForInches(.75, 160));
    		addSequential(new DriveTrain_TurnToAngle(-75));
//    		addSequential(new DriveTrain_DriveStraightForInches(.9, 135));
//    		addSequential(new DriveTrain_TurnToAngle(82));    	
//	        addSequential(new Lift_MoveToPosition(Lift.HighScale),12);
//	        addSequential(new DriveTrain_DriveStraightForInches(.7, 30));
//	        addSequential(new Intake_EjectForSeconds(1));
//	        addParallel(new DriveTrain_DriveStraightForInches(-.8, 10));
//	        addSequential(new Lift_MoveToPosition(Lift.Floor), 5);
//	        addSequential(new DriveTrain_TurnToAngle(160));
//	        addParallel(new Intake_GrabCubeForSeconds(4.5), 4.5);
//    	    addSequential(new DriveTrain_DriveStraightForInches(.6, 53)); 
//    	    addSequential(new Lift_MoveToPosition(Lift.Switch));
        } else if (scaleSide == MatchData.OwnedSide.RIGHT) {
        	addParallel(new Lift_MoveToPosition(Lift.HighScale), 12);
    		addSequential(new DriveTrain_DriveStraightForInches(.95, 170));
    		addSequential(new DriveTrain_TurnToAngle(-20), 1);
	        addSequential(new Intake_EjectForSeconds(1));
	        addParallel(new Lift_MoveToPosition(Lift.Floor), 12);
	        addSequential(new DriveTrain_TurnToAngle(-120));
	        addParallel(new Intake_GrabCubeForSeconds(4.5), 4);
    	    addSequential(new DriveTrain_DriveStraightForInches(.6, 53));
        } else {
        	addParallel(new Lift_MoveToPosition(Lift.Switch), 4);
    		addSequential(new DriveTrain_DriveStraightForInches(.6, 140));
        }
    }
}
