package org.usfirst.frc.team5484.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

import org.usfirst.frc.team5484.robot.RobotMap;

public class Intake extends Subsystem {

    public static final SpeedControllerGroup intake = RobotMap.intakeSystem;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void grabCube() {
    	intake.set(.5);
    }
    public void ejectCube() {
    	intake.set(-.8);
    }
    public void stopIntake() {
    	intake.set(0);
    }
}

