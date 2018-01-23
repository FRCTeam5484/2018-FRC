package org.usfirst.frc.team5484.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5484.robot.OI;
import org.usfirst.frc.team5484.robot.Robot;
import edu.wpi.first.wpilibj.Joystick;
import org.usfirst.frc.team5484.robot.RobotMap;

/**
 *
 */
public class DriveWithJoysticks extends Command {

    public DriveWithJoysticks() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    protected void execute() {
    	Robot.driveTrain.tankDrive();
    }

    /*
     * isFinished - Our isFinished method always returns false meaning this command never completes on it's own. The reason we do this is that this command will be set as the default command for the subsystem. This means that whenever the subsystem is not running another command, it will run this command. If any other command is scheduled it will interrupt this command, then return to this command when the other command completes.
     */
    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }

}
