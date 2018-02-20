package org.usfirst.frc.team5484.robot;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
//import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import com.mach.LightDrive.LightDriveCAN;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;

//import edu.wpi.first.wpilibj.Ultrasonic;
//import edu.wpi.first.wpilibj.ADXRS450_Gyro;

public class RobotMap {
	// Drive Train Hardware
	public static SpeedController driveTrainLeft1;
    public static SpeedController driveTrainLeft2;    
    public static SpeedController driveTrainRight1;
    public static SpeedController driveTrainRight2;
    //public static Ultrasonic driveTrainUltrasonic;
    public static Encoder driveTrainRightEncoder;
    //public static ADXRS450_Gyro driveTrainGyro;
    public static AHRS driveTrainGyro;
    
    // Intake Hardware
    public static SpeedController intakeMotorLeft;
    public static SpeedController intakeMotorRight;
    public static SpeedControllerGroup intakeSystem;
    public static DigitalInput intakeLimitSwitch;
    
    // Lift Hardware
    public static SpeedController liftMotor;
    public static DigitalInput liftTopLimitSwitch;
    public static DigitalInput liftBottomLimitSwitch;
    public static AnalogPotentiometer liftPOT;
    
    // Hang Hardware
    public static SpeedController hangMotor;
    
    // LED Indicator Controller (LightDrive12)
    public static LightDriveCAN ledIndicators;
    
    public static void init() {
    	// Initialize Left Motor Controllers
        driveTrainLeft1 = new Spark(0);
        driveTrainLeft1.setInverted(true);
        driveTrainLeft2 = new Spark(1);
        driveTrainLeft2.setInverted(true);
        // Initialize Right Motor Controllers
        driveTrainRight1 = new Spark(2);
        driveTrainRight1.setInverted(true);
        driveTrainRight2 = new Spark(3);
        driveTrainRight2.setInverted(true);
        // Initialize Ultrasonic Range Finder
//        driveTrainUltrasonic = new Ultrasonic(1,1);
//        driveTrainUltrasonic.setAutomaticMode(true);
        // Initialize Encoders On DriveTrain
        driveTrainRightEncoder = new Encoder(3, 4, true, Encoder.EncodingType.k4X);
        driveTrainRightEncoder.setDistancePerPulse(-0.058);
        // Initialize Gyro on DriveTrain
        try {
        	driveTrainGyro = new AHRS(SPI.Port.kMXP);
		}
		catch(RuntimeException ex)
		{
			DriverStation.reportError("Error instantiating navX-MXP:  " + ex.getMessage(), true);
		}
        
        // Initialize Intake Hardware
        intakeMotorLeft = new Talon(4);
        intakeMotorRight = new Talon(5);
        intakeMotorRight.setInverted(true);
        intakeSystem = new SpeedControllerGroup(intakeMotorLeft, intakeMotorRight);
        intakeLimitSwitch = new DigitalInput(2);
        
        // Initialize Lift Hardware
        liftMotor = new Talon(6);
        liftTopLimitSwitch = new DigitalInput(0);
        liftBottomLimitSwitch = new DigitalInput(1);
        liftPOT = new AnalogPotentiometer(0, 108, 2);
        
        hangMotor = new Talon(7);
        hangMotor.setInverted(true);
        
        // Initialize LightDrive12
        ledIndicators = new LightDriveCAN();
                
    }    
    public static boolean isTopLimitReached()
    {
    	return !liftTopLimitSwitch.get();
    }
    public static boolean isBottomLimitReached()
    {
    	return !liftBottomLimitSwitch.get();
    }
    public static boolean isCubeSeated()
    {
    	return !intakeLimitSwitch.get();
    }
}