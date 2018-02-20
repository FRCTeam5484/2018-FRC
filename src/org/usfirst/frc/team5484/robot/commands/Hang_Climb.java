package org.usfirst.frc.team5484.robot.commands;

import org.usfirst.frc.team5484.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Hang_Climb extends Command {

    public Hang_Climb() {
        requires(Robot.hangSystem);
    }

    protected void initialize() {
    	Robot.hangSystem.climb();
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.hangSystem.stop();
    }

    protected void interrupted() {
    	end();
    }
}
