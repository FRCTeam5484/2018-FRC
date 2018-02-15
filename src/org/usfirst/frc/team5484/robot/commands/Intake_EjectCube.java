package org.usfirst.frc.team5484.robot.commands;
import org.usfirst.frc.team5484.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class Intake_EjectCube extends Command {
	
	private double speedLevel;
	
    public Intake_EjectCube(double powerLevel) {
    	requires(Robot.intakeSystem);
    	speedLevel = powerLevel;
    }
    
    protected void initialize() {
    	Robot.intakeSystem.ejectCube(speedLevel);
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
