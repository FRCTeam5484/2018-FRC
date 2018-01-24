package org.usfirst.frc.team5484.robot.commands;
import org.usfirst.frc.team5484.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class IntakeGrabCube extends Command {

	
    public IntakeGrabCube() {
    	requires(Robot.intakeSystem);
    }

    protected void initialize() {
    	Robot.intakeSystem.grabCube();
    }

    protected void execute() {
    	
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.intakeSystem.stopIntake();
    }

    protected void interrupted() {
    	end();
    }
}