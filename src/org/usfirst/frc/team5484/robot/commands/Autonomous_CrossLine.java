package org.usfirst.frc.team5484.robot.commands;

import org.usfirst.frc.team5484.robot.RobotMap;
import org.usfirst.frc.team5484.robot.subsystems.Lift;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Autonomous_CrossLine extends CommandGroup {

    public Autonomous_CrossLine() {
        addParallel(new DriveTrain_DriveStraightForInches(.7, 60), 10);
        addSequential(new Lift_MoveToPosition(Lift.Switch));
    }
}
