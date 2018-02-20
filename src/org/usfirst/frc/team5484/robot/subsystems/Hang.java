package org.usfirst.frc.team5484.robot.subsystems;

import org.usfirst.frc.team5484.robot.RobotMap;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Hang extends Subsystem {
	
	public static final SpeedController hang = RobotMap.hangMotor;

    public void initDefaultCommand() {
        
    }
    public void climb()
    {
    	hang.set(1);
    }
    public void descent()
    {
    	hang.set(-1);
    }
    public void stop()
    {
    	hang.set(0);
    }
}

