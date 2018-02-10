package org.usfirst.frc.team5484.robot.subsystems;

import org.usfirst.frc.team5484.robot.RobotMap;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class CubeLift extends Subsystem {

    public static final SpeedController lift = RobotMap.liftMotor;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void raiseLift() {
    	lift.set(1);
    }
    public void lowerLift() {
    	lift.set(-1);
    }
    public void stopLift() {
    	lift.set(0);
    }
}