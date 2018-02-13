package org.usfirst.frc.team5484.robot.commands;

import org.usfirst.frc.team5484.robot.Robot;
import org.usfirst.frc.team5484.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class Lift_TeleopMode extends Command {

    public Lift_TeleopMode() {
        requires(Robot.liftSystem);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.liftSystem.moveLift();
    }

    protected boolean isFinished() {
    	return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    	end();
    }
}
