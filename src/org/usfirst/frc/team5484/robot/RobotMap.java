/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5484.robot;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Spark;
//import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
//import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;

public class RobotMap {
	// Drive Train Hardware
	public static SpeedController driveTrainLeft1;
    public static SpeedController driveTrainLeft2;    
    public static SpeedController driveTrainRight1;
    public static SpeedController driveTrainRight2;
    //public static Ultrasonic driveTrainUltrasonic;
    //public static Encoder driveTrainLeftEncoder;
    //public static Encoder driveTrainRightEncoder;
    public static ADXRS450_Gyro driveTrainGyro;
    
    // Intake Hardware
    public static SpeedController intakeMotorLeft;
    public static SpeedController intakeMotorRight;
    public static SpeedControllerGroup intakeSystem;
    
    // Lift Hardware
    public static AnalogPotentiometer intakePOT;
    public static SpeedController liftMotor;
    
    // Hang Hardware
    public static SpeedController hangMotor;
    
    
    public static void init() {
    	// Initialize Left Motor Controllers
        driveTrainLeft1 = new Spark(0);
        driveTrainLeft2 = new Spark(1);
        // Initialize Right Motor Controllers
        driveTrainRight1 = new Spark(2);
        driveTrainRight2 = new Spark(3);
        // Initialize Ultrasonic Range Finder
//        driveTrainUltrasonic = new Ultrasonic(1,1);
//        driveTrainUltrasonic.setAutomaticMode(true);
//        // Initialize Encoders On DriveTrain
//        driveTrainLeftEncoder = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
//        driveTrainRightEncoder = new Encoder(2, 3, true, Encoder.EncodingType.k4X);
        // Initialize Gyro on DriveTrain
        driveTrainGyro = new ADXRS450_Gyro();
        // Initialize Intake Motor Controller
        intakeMotorLeft = new Talon(4);
        intakeMotorRight = new Talon(5);
        intakeMotorRight.setInverted(true);
        intakeSystem = new SpeedControllerGroup(intakeMotorLeft, intakeMotorRight);
        // Initialize Intake POT
        //intakePOT = new AnalogPotentiometer(0, 84, 1);
        liftMotor = new Talon(6);
        hangMotor = new Talon(7);
    }
}