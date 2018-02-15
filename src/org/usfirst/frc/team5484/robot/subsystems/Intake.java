package org.usfirst.frc.team5484.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

import org.usfirst.frc.team5484.robot.RobotMap;
import org.usfirst.frc.team5484.robot.commands.*;

public class Intake extends Subsystem {

    public static final SpeedControllerGroup intake = RobotMap.intakeSystem;

    public void initDefaultCommand() {
    	setDefaultCommand(new Intake_TeleopMode());
    }
    public void grabCube(double powerLevel) {
    	intake.set(powerLevel);
    }
    public void ejectCube(double powerLevel) {
    	intake.set(-powerLevel);
    }
    public void stopIntake() {
    	intake.set(0);
    }
}