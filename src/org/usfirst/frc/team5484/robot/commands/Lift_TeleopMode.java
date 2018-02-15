package org.usfirst.frc.team5484.robot.commands;

import org.usfirst.frc.team5484.robot.Robot;
import org.usfirst.frc.team5484.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

public class Lift_TeleopMode extends Command {

	//public static final Joystick driverOne = Robot.oi.driverOne;
	
    public Lift_TeleopMode() {
        requires(Robot.liftSystem);
    }

    protected void initialize() {
    }

    protected void execute() {
    	//Robot.liftSystem.disable();
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
