package org.usfirst.frc.team5484.robot.subsystems;

import org.usfirst.frc.team5484.robot.Robot;
import org.usfirst.frc.team5484.robot.RobotMap;
import org.usfirst.frc.team5484.robot.commands.Lift_TeleopMode;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class Lift extends PIDSubsystem {

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
    	if(RobotMap.isTopLimitReached() && speedValue > 0 || RobotMap.isBottomLimitReached() && speedValue < 0)
    	{
    		stopLift();
    	}
    	else {
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
    		stopLift();
    	}
    	else {
    		liftMotor.pidWrite(reverseOutput);
    	}
    }
}