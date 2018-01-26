package org.usfirst.frc.team5484.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CommandGroup_DriveInASquare extends CommandGroup {

    public CommandGroup_DriveInASquare() {
    	addSequential(new DriveTrain_GoStraightBySeconds(.2, 1));
    	addSequential(new DriveTrain_TurnToAngle(.2, 90));
    	addSequential(new DriveTrain_GoStraightBySeconds(.2, 1));
    	addSequential(new DriveTrain_TurnToAngle(.2, 90));
    	addSequential(new DriveTrain_GoStraightBySeconds(.2, 1));
    	addSequential(new DriveTrain_TurnToAngle(.2, 90));
    	addSequential(new DriveTrain_GoStraightBySeconds(.2, 1));
    	addSequential(new DriveTrain_TurnToAngle(.2, 90));
    }
}
