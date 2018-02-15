package org.usfirst.frc.team5484.robot.commands;
import org.usfirst.frc.team5484.robot.Robot;

//import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class Intake_GrabCube extends Command {

	private double speedLevel;
	
    public Intake_GrabCube(double powerLevel) {
    	requires(Robot.intakeSystem);
    	speedLevel = powerLevel;
    }

    protected void initialize() {
    	Robot.intakeSystem.grabCube(speedLevel);
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
