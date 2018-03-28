package org.usfirst.frc.team5484.robot.commands;

import org.usfirst.frc.team5484.robot.Robot;
import org.usfirst.frc.team5484.robot.RobotMap;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;

public class Intake_TeleopMode extends Command {

    public Intake_TeleopMode() {
        requires(Robot.intakeSystem);
    }

    protected void initialize() {
    }

    protected void execute() {
    	double leftTrigger = Robot.oi.driverOne.getTriggerAxis(Hand.kLeft);
    	double rightTrigger = Robot.oi.driverOne.getTriggerAxis(Hand.kRight);
    	System.out.println(RobotMap.liftPOT.get());
    	if(rightTrigger > .05)
    	{
    		Robot.intakeSystem.grabCube(rightTrigger);
    	}
    	else if (leftTrigger > .05) {
    		Robot.intakeSystem.ejectCube(leftTrigger);
    	}
    	else
    	{
    		Robot.intakeSystem.stopIntake();
    	}
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
