package org.usfirst.frc.team5484.robot.commands;

import org.usfirst.frc.team5484.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveTrain_GoBackwardsForSeconds extends Command {
    	Timer seconds;
    	double secondsToDrive;
    	
        public DriveTrain_GoBackwardsForSeconds(double seconds) {
            requires(Robot.driveTrain);
            secondsToDrive = seconds;
        }
        protected void initialize() {
        	seconds = new Timer();
        	seconds.start();
        }
        protected void execute() {
        	Robot.driveTrain.driveForward(-.5);
        }
        protected boolean isFinished() {
            return seconds.get() > secondsToDrive;
        }
        protected void end() {
        	Robot.driveTrain.stopMotors();
        }
        protected void interrupted() {
        	end();
        }
}
