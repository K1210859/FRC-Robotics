package org.usfirst.frc.team5427.robot.subsystems;


import org.usfirst.frc.team5427.robot.Robot;
import org.usfirst.frc.team5427.util.Config;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Arm extends Subsystem
{

    private SpeedController aM;
    public double aA;

    public Arm(SpeedController armMotor)
    {
        this.aM = armMotor;
    }

    public void moveArm(double armSpeed)
    {
        if((armSpeed > 0 && Robot.armPot.get() >= Config.ARM_LIMIT_TOP) 
        || (armSpeed < 0 && Robot.armPot.get() <= Config.ARM_LIMIT_BOTTOM))
            aM.set(armSpeed);
        else
            aM.set(0);
    }

    public void stop(){
        aM.set(0);
    }

    @Override
    protected void initDefaultCommand()
    {

    }

    public void setArmAngle(double angle)
    {
        this.aA = angle;
    }

    public double getArmAngle()
    {
        return aA;
    }
}