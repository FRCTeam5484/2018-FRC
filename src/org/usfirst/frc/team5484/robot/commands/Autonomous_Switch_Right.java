package org.usfirst.frc.team5484.robot.commands;

import org.usfirst.frc.team5484.robot.Robot;
import org.usfirst.frc.team5484.robot.MatchData;
import org.usfirst.frc.team5484.robot.subsystems.Lift;

import edu.wpi.first.wpilibj.command.CommandGroup;
public class Autonomous_Switch_Right extends CommandGroup {
	
	private MatchData.OwnedSide switchSide = null;

    public Autonomous_Switch_Right() {
    	switchSide = MatchData.getOwnedSide(MatchData.GameFeature.SWITCH);
    	if (switchSide == MatchData.OwnedSide.LEFT) {
        	addParallel(new Lift_MoveToPosition(Lift.Switch));
    		addSequential(new DriveTrain_DriveStraightForInches(.9, 35));
    		addSequential(new DriveTrain_TurnToAngle(-78));
    		addSequential(new DriveTrain_DriveStraightForInches(.9, 80));
    		addSequential(new DriveTrain_TurnToAngle(80));
    		addSequential(new DriveTrain_DriveStraightForInches(.85, 35), 3);
    		addSequential(new Intake_EjectForSeconds(1));
    		addParallel(new Lift_MoveToPosition(Lift.Floor));
	        addSequential(new DriveTrain_DriveStraightForInches(-.9, 10));
        } else if (switchSide == MatchData.OwnedSide.RIGHT) {
        	addParallel(new Lift_MoveToPosition(Lift.Switch));
	        addSequential(new DriveTrain_DriveStraightForInches(.65, 107), 5);
	        addSequential(new Intake_EjectForSeconds(1));
	        addParallel(new Lift_MoveToPosition(Lift.Floor));
	        addSequential(new DriveTrain_DriveStraightForInches(-.9, 10));	
        } else {
        	addParallel(new Lift_MoveToPosition(Lift.Switch), 4);
    		addSequential(new DriveTrain_DriveStraightForInches(.6, 107));
        }
    }
}