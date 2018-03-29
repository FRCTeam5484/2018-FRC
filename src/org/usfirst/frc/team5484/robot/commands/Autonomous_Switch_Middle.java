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
    		addSequential(new DriveTrain_DriveStraightForInches(.8, 10));
	        addSequential(new DriveTrain_TurnToAngle(-45), 1);
	        addParallel(new Lift_MoveToPosition(Lift.Switch), 3);
	        addSequential(new DriveTrain_DriveStraightForInches(.8, 55));
	        addSequential(new DriveTrain_TurnToAngle(35));
	        addSequential(new DriveTrain_DriveStraightForInches(.8, 22));
	        addSequential(new Intake_EjectForSeconds(1));
	        addParallel(new Lift_MoveToPosition(Lift.Floor), 4);
	        addSequential(new DriveTrain_DriveStraightForInches(-.8, 10));
        } else if (switchSide == MatchData.OwnedSide.RIGHT) {
        	addSequential(new DriveTrain_DriveStraightForInches(.8, 10));
	        addSequential(new DriveTrain_TurnToAngle(45));
	        addParallel(new Lift_MoveToPosition(Lift.Switch), 3);
	        addSequential(new DriveTrain_DriveStraightForInches(.8, 65));
	        addSequential(new DriveTrain_TurnToAngle(-35));
	        addSequential(new DriveTrain_DriveStraightForInches(.8, 22), 3);
	        addSequential(new Intake_EjectForSeconds(1));
	        addParallel(new Lift_MoveToPosition(Lift.Floor), 4);
	        addSequential(new DriveTrain_DriveStraightForInches(-.8, 10));
        } else {
        	addParallel(new Lift_MoveToPosition(Lift.Switch), 4);
    		addSequential(new DriveTrain_DriveStraightForInches(.6, 140));
        }
    }
}