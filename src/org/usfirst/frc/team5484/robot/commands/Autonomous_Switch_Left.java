package org.usfirst.frc.team5484.robot.commands;

import org.usfirst.frc.team5484.robot.Robot;
import org.usfirst.frc.team5484.robot.subsystems.Lift;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Autonomous_Switch_Left extends CommandGroup {
	
    public Autonomous_Switch_Left() {
    	if(Robot.FieldSetup.charAt(0) == 'L')
    	{
	        addParallel(new Lift_MoveToPosition(Lift.Switch), 4);
	        addSequential(new DriveTrain_DriveStraightForInches(.7, 113));
	        addSequential(new Intake_EjectForSeconds(1));
	        addSequential(new DriveTrain_DriveStraightForInches(-.7, 4));
    	}
    	else
    	{	        
	        addSequential(new DriveTrain_DriveStraightForInches(.7, 30));
	        addSequential(new DriveTrain_TurnToAngle(90));
	        addSequential(new DriveTrain_DriveStraightForInches(.7, 105));
	        addSequential(new DriveTrain_TurnToAngle(-93));
	        addParallel(new Lift_MoveToPosition(Lift.Switch), 4);
	        addSequential(new DriveTrain_DriveStraightForInches(.7, 76));
	        addSequential(new Intake_EjectForSeconds(1));
	        addSequential(new DriveTrain_DriveStraightForInches(-.7, 4));
    	}
    }
}
