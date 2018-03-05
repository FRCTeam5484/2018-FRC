package org.usfirst.frc.team5484.robot.commands;

import org.usfirst.frc.team5484.robot.MatchData;
import org.usfirst.frc.team5484.robot.subsystems.Lift;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Autonomous_Switch_Middle extends CommandGroup {

	private MatchData.OwnedSide switchSide = null;
	
    public Autonomous_Switch_Middle() {
    	switchSide = MatchData.getOwnedSide(MatchData.GameFeature.SWITCH);
    	if (switchSide == MatchData.OwnedSide.LEFT) {
	        addSequential(new DriveTrain_DriveStraightForInches(.65, 10), 7);
	        addSequential(new DriveTrain_TurnToAngle(-45));
	        addParallel(new Lift_MoveToPosition(Lift.Switch), 3);
	        addSequential(new DriveTrain_DriveStraightForInches(.65, 100), 5);
	        addSequential(new DriveTrain_TurnToAngle(45));
	        addSequential(new DriveTrain_DriveStraightForInches(.65, 10), 2);
	        addSequential(new Intake_EjectForSeconds(1));
	        addParallel(new Lift_MoveToPosition(Lift.Floor), 4);
	        addSequential(new DriveTrain_DriveStraightForInches(-.9, 10));
        } else if (switchSide == MatchData.OwnedSide.RIGHT) {
        	addSequential(new DriveTrain_DriveStraightForInches(.65, 10), 7);
	        addSequential(new DriveTrain_TurnToAngle(45));
	        addParallel(new Lift_MoveToPosition(Lift.Switch), 3);
	        addSequential(new DriveTrain_DriveStraightForInches(.65, 100), 5);
	        addSequential(new DriveTrain_TurnToAngle(-45));
	        addSequential(new DriveTrain_DriveStraightForInches(.65, 10), 2);
	        addSequential(new Intake_EjectForSeconds(1));
	        addParallel(new Lift_MoveToPosition(Lift.Floor), 4);
	        addSequential(new DriveTrain_DriveStraightForInches(-.9, 10));
        } else {
        	addParallel(new Lift_MoveToPosition(Lift.Switch), 4);
    		addSequential(new DriveTrain_DriveStraightForInches(.6, 140));
        }
    }
}
