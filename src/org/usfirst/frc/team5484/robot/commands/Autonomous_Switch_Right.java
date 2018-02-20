package org.usfirst.frc.team5484.robot.commands;

import org.usfirst.frc.team5484.robot.Robot;
import org.usfirst.frc.team5484.robot.subsystems.Lift;

import edu.wpi.first.wpilibj.command.CommandGroup;
public class Autonomous_Switch_Right extends CommandGroup {

    public Autonomous_Switch_Right() {
    	if(Robot.FieldSetup.charAt(1) == 'R')
    	{
	        addParallel(new Lift_MoveToPosition(Lift.Switch), 4);
	        addSequential(new DriveTrain_DriveStraightForInches(.9, 107));
	        addSequential(new Intake_EjectForSeconds(1));
	        addParallel(new Lift_MoveToPosition(Lift.Floor), 4);
	        addSequential(new DriveTrain_DriveStraightForInches(-.9, 10));
	        
    	}
    	else
    	{	        
    		addParallel(new Lift_MoveToPosition(Lift.Switch), 4);
    		addSequential(new DriveTrain_DriveStraightForInches(.92, 242));
    		addSequential(new DriveTrain_TurnToAngle(-38));
    		addSequential(new Lift_MoveToPosition(Lift.MidScale), 12);
	        addSequential(new Intake_EjectForSeconds(1));
	        addParallel(new Lift_MoveToPosition(Lift.Floor), 12);
	        addSequential(new DriveTrain_TurnToAngle(-105));
	        addParallel(new Intake_GrabCubeForSeconds(4.5), 4.5);
    	    addSequential(new DriveTrain_DriveStraightForInches(.6, 53)); 
    	    addSequential(new Lift_MoveToPosition(Lift.Switch));
    	    addSequential(new DriveTrain_DriveStraightForInches(.9, 5));
    	    addSequential(new Intake_EjectForSeconds(1));
    	    addSequential(new DriveTrain_DriveStraightForInches(-.9, 6));
    	    addParallel(new Lift_MoveToPosition(Lift.Floor), 12);
    	}
    }
}