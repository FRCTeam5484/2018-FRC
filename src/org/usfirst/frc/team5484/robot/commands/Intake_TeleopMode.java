package org.usfirst.frc.team5484.robot.commands;

import org.usfirst.frc.team5484.robot.Robot;

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
    	if(leftTrigger > .2)
    	{
    		Robot.intakeSystem.grabCube(leftTrigger);
    	}
    	else if (rightTrigger > .2) {
    		Robot.intakeSystem.ejectCube(-rightTrigger);
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
