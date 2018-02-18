package org.usfirst.frc.team5484.robot.subsystems;

import org.usfirst.frc.team5484.robot.Robot;
import org.usfirst.frc.team5484.robot.RobotMap;
import org.usfirst.frc.team5484.robot.commands.Lift_TeleopMode;

import com.mach.LightDrive.Color;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class Lift extends PIDSubsystem {
	
	public static final double Floor = 101;
	public static final double Switch = 89;
	public static final double MidScale = 55;
	public static final double HighScale = 41;
	public static final double TopScale = 36;
	
	private final AnalogPotentiometer liftPOT = RobotMap.liftPOT;	
    public static final SpeedController liftMotor = RobotMap.liftMotor;
    
    public Lift()
    {
    	super("Lift", 1.0, 0.0, 0.0);
        setAbsoluteTolerance(3);
        getPIDController().setContinuous(false);
    }
    
    public void initDefaultCommand() {
        setDefaultCommand(new Lift_TeleopMode());
    }
    public void moveLift() {
    	double speedValue = -Robot.oi.getDriverTwoStickValue(1);
    	//System.out.println("Stick Valeu: " + speedValue + " Top Limit: " + RobotMap.isTopLimitReached() + " Bottom Limit: " + RobotMap.isBottomLimitReached() +" POT Value: " + RobotMap.liftPOT.get());
    	if(RobotMap.isTopLimitReached() && speedValue > 0 || RobotMap.isBottomLimitReached() && speedValue < 0)
    	{
    		stopLift();
//    		RobotMap.ledIndicators.SetColor(2, Color.RED);
//    		RobotMap.ledIndicators.Update();
    	}
    	else {
//    		RobotMap.ledIndicators.SetColor(2, Color.GREEN);
//    		RobotMap.ledIndicators.Update();
    		if(speedValue > .8 || speedValue < -.8)
    		{
    			getPIDController().disable();
    			liftMotor.set(speedValue);
    		}
    		else
    		{
    			liftMotor.set(0);
    		}
    	}
    }
    public void raiseLift() {
    	liftMotor.set(1);
    }
    public void lowerLift() {
    	liftMotor.set(-1);
    }
    public void stopLift() {
    	liftMotor.set(0);
    }
    @Override
    protected double returnPIDInput() {
        return liftPOT.get();
    }
    @Override
    protected void usePIDOutput(double output) {
    	double reverseOutput = -output;
    	if(RobotMap.isTopLimitReached() && reverseOutput > 0 || RobotMap.isBottomLimitReached() && reverseOutput < 0)
    	{
    		RobotMap.ledIndicators.SetColor(2, Color.RED);
    		RobotMap.ledIndicators.Update();
    		stopLift();
    	}
    	else {
    		liftMotor.pidWrite(reverseOutput);
    	}
    }
}