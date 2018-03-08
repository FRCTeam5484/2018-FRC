package org.usfirst.frc.team5484.robot.commands;

import org.usfirst.frc.team5484.robot.MatchData;
import org.usfirst.frc.team5484.robot.subsystems.Lift;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Autonomous_CrossLineSwitchOption_Right extends CommandGroup {

	private MatchData.OwnedSide switchSide = null;
	
    public Autonomous_CrossLineSwitchOption_Right() {
    	switchSide = MatchData.getOwnedSide(MatchData.GameFeature.SWITCH);
    	addParallel(new Lift_MoveToPosition(Lift.Switch), 4);
		addSequential(new DriveTrain_DriveStraightForInches(.8, 140));
		if(switchSide == MatchData.OwnedSide.RIGHT)
		{
			addSequential(new DriveTrain_TurnToAngle(-90));
			addSequential(new DriveTrain_DriveStraightForInches(.8, 6));
			addSequential(new Intake_EjectForSeconds(2));
		}
    }
}
