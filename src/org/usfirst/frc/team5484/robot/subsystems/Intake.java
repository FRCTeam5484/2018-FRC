package org.usfirst.frc.team5484.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

import org.usfirst.frc.team5484.robot.RobotMap;

public class Intake extends Subsystem {

    public static final SpeedControllerGroup intake = RobotMap.intakeSystem;

    public void initDefaultCommand() {
    }
    public void grabCube() {
    	intake.set(.7);
    }
    public void ejectCube() {
    	intake.set(-.8);
    }
    public void stopIntake() {
    	intake.set(0);
    }
}