package org.usfirst.frc.team5484.robot.commands;

import org.usfirst.frc.team5484.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LowerCube extends Command {

    public LowerCube() {
        requires(Robot.cubeLift);
    }
    protected void initialize() {
    	Robot.cubeLift.lowerLift();
    }
    protected void execute() {
    }
    protected boolean isFinished() {
        return false;
    }
    protected void end() {
    	Robot.cubeLift.stopLift();
    }
    protected void interrupted() {
    	end();
    }
}
