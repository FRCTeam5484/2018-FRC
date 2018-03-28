package org.usfirst.frc.team5484.robot.commands;

import org.usfirst.frc.team5484.robot.MatchData;
import org.usfirst.frc.team5484.robot.subsystems.Lift;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Autonomous_CrossLineSwitchOption_Left extends CommandGroup {

	private MatchData.OwnedSide switchSide = null;
	
    public Autonomous_CrossLineSwitchOption_Left() {
    	switchSide = MatchData.getOwnedSide(MatchData.GameFeature.SWITCH);
    	if (switchSide == MatchData.OwnedSide.LEFT) {
        	addParallel(new Lift_MoveToPosition(Lift.Switch));
	        addSequential(new DriveTrain_DriveStraightForInches(.7, 115), 5);
	        addSequential(new DriveTrain_TurnToAngle(90), 2);
	        addSequential(new DriveTrain_DriveStraightForInches(.7, 10), 2);
	        addSequential(new Intake_EjectForSeconds(1));
	        addParallel(new Lift_MoveToPosition(Lift.Floor));
	        addSequential(new DriveTrain_DriveStraightForInches(-.9, 10));	
        }
    	else
    	{
    		addParallel(new Lift_MoveToPosition(Lift.Switch), 4);
    		addSequential(new DriveTrain_DriveStraightForInches(.7, 140));
    	}
    }
}