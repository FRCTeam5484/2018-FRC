/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5484.robot;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;

public class RobotMap {
	public static SpeedController driveTrainLeft1;
    public static SpeedController driveTrainLeft2;
    
    public static SpeedController driveTrainRight1;
    public static SpeedController driveTrainRight2;
    
    public static SpeedController intakeMotor;
    
    public static void init() {
    
        driveTrainLeft1 = new Talon(2);
        driveTrainLeft1.setInverted(true);
        driveTrainLeft2 = new Talon(3);
        driveTrainLeft2.setInverted(true);
        
        driveTrainRight1 = new Talon(0);
        driveTrainRight1.setInverted(false);
        driveTrainRight2 = new Talon(1);
        driveTrainRight2.setInverted(false);
        
        intakeMotor = new Talon(4);
        intakeMotor.setInverted(true);
    }
}