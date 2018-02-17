package org.usfirst.frc.team5484.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

import org.usfirst.frc.team5484.robot.RobotMap;
import org.usfirst.frc.team5484.robot.commands.*;

import com.mach.LightDrive.Color;

public class Intake extends Subsystem {

    public static final SpeedControllerGroup intake = RobotMap.intakeSystem;

    public void initDefaultCommand() {
    	setDefaultCommand(new Intake_TeleopMode());
    }
    public void grabCube(double powerLevel) {
    	intake.set(powerLevel);
    	CheckLight();
    }
    public void ejectCube(double powerLevel) {
    	intake.set(-powerLevel);
    	CheckLight();
    }
    public void stopIntake() {
    	intake.set(0);
    	CheckLight();
    }
    public void CheckLight()
    {
//    	if(RobotMap.isCubeSeated())
//    	{
//    		RobotMap.ledIndicators.SetColor(1, Color.GREEN);
//    		RobotMap.ledIndicators.Update();
//    	}
//    	else
//    	{
//    		RobotMap.ledIndicators.SetColor(1, Color.RED);
//    		RobotMap.ledIndicators.Update();
//    	}
    }
}