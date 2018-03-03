package org.usfirst.frc.team5484.robot.commands;

import org.usfirst.frc.team5484.robot.Robot;
import org.usfirst.frc.team5484.robot.MatchData;
import org.usfirst.frc.team5484.robot.subsystems.Lift;

import edu.wpi.first.wpilibj.command.CommandGroup;
public class Autonomous_Switch_Right extends CommandGroup {
	
	private MatchData.OwnedSide ownedSide = null;

    public Autonomous_Switch_Right() {
    	if (ownedSide == MatchData.OwnedSide.LEFT) {
        	addParallel(new Lift_MoveToPosition(Lift.Switch), 4);
    		addSequential(new DriveTrain_DriveStraightForInches(.9, 30));
    		addSequential(new DriveTrain_TurnToAngle(-80));
    		addSequential(new DriveTrain_DriveStraightForInches(.9, 140));
    		addSequential(new DriveTrain_TurnToAngle(90));
    		addSequential(new DriveTrain_DriveStraightForInches(.85, 0), 5);
    		addSequential(new Intake_EjectCube(.5));
    		addParallel(new Lift_MoveToPosition(Lift.Floor), 4);
	        addSequential(new DriveTrain_DriveStraightForInches(-.9, 10));
        } else if (ownedSide == MatchData.OwnedSide.RIGHT) {
        	addParallel(new Lift_MoveToPosition(Lift.Switch), 4);
	        addSequential(new DriveTrain_DriveStraightForInches(.65, 136), 7);
	        addSequential(new Intake_EjectForSeconds(1));
	        addParallel(new Lift_MoveToPosition(Lift.Floor), 4);
	        addSequential(new DriveTrain_DriveStraightForInches(-.9, 10));	
        } else {
        	addParallel(new Lift_MoveToPosition(Lift.Switch), 4);
    		addSequential(new DriveTrain_DriveStraightForInches(.6, 140));
        }
    }
    @Override
    public void initialize() {
    	ownedSide = MatchData.getOwnedSide(MatchData.GameFeature.SCALE);
    }
}