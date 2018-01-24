package org.usfirst.frc.team5484.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5484.robot.Robot;

public class DriveWithJoysticks extends Command {

    public DriveWithJoysticks() {
    	requires(Robot.driveTrain);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.driveTrain.tankDrive();
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
