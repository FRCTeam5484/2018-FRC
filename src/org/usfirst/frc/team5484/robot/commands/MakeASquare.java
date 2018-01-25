package org.usfirst.frc.team5484.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class MakeASquare extends CommandGroup {

    public MakeASquare() {
    	addSequential(new DriveStraightInSeconds(.2, 1));
    	addSequential(new DriveToAngle(.2, 90));
    	addSequential(new DriveStraightInSeconds(.2, 1));
    	addSequential(new DriveToAngle(.2, 90));
    	addSequential(new DriveStraightInSeconds(.2, 1));
    	addSequential(new DriveToAngle(.2, 90));
    	addSequential(new DriveStraightInSeconds(.2, 1));
    	addSequential(new DriveToAngle(.2, 90));
    }
}
