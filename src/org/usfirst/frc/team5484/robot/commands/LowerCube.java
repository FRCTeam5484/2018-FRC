package org.usfirst.frc.team5484.robot.commands;

import org.usfirst.frc.team5484.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LowerCube extends Command {

    public LowerCube() {
        requires(Robot.liftSystem);
    }
    protected void initialize() {
    	Robot.liftSystem.lowerLift();
    }
    protected void execute() {
    }
    protected boolean isFinished() {
        return false;
    }
    protected void end() {
    	Robot.liftSystem.stopLift();
    }
    protected void interrupted() {
    	end();
    }
}
