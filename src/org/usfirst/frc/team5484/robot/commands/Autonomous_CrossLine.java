package org.usfirst.frc.team5484.robot.commands;

import org.usfirst.frc.team5484.robot.RobotMap;
import org.usfirst.frc.team5484.robot.subsystems.Lift;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Autonomous_CrossLine extends CommandGroup {

    public Autonomous_CrossLine() {
    	addParallel(new Lift_MoveToPosition(Lift.Switch), 4);
		addSequential(new DriveTrain_DriveStraightForInches(.6, 140));
    }
}
