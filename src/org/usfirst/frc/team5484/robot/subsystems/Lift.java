package org.usfirst.frc.team5484.robot.subsystems;

import org.usfirst.frc.team5484.robot.OI;
import org.usfirst.frc.team5484.robot.Robot;
import org.usfirst.frc.team5484.robot.RobotMap;
import org.usfirst.frc.team5484.robot.commands.Lift_TeleopMode;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Lift extends Subsystem {

    public static final SpeedController lift = RobotMap.liftMotor;
    
    public void initDefaultCommand() {
        setDefaultCommand(new Lift_TeleopMode());
    }
    public void moveLift() {
    	System.out.println("Limit Switch: " + RobotMap.isTopLimitReached());
    	double speedValue = -Robot.oi.getDriverTwoStickValue(1);
    	if(RobotMap.isTopLimitReached() && speedValue > 0)
    	{
    		stopLift();
    	}
    	else {
    		lift.set(speedValue);
    	}
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