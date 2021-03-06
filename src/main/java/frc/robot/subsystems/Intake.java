/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Intake extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  // Activates Wheels
  public static TalonSRX leftWheel = new TalonSRX(RobotMap.LEFT_WHEEL);
  public static TalonSRX rightWheel = new TalonSRX(RobotMap.RIGHT_WHEEL);

  //This is the supsystem for the intake wheels
  public Intake() {
    
  }
  
  public static void runIntake(double speed){
    leftWheel.set(ControlMode.PercentOutput, speed);
    rightWheel.set(ControlMode.PercentOutput, speed);
  }

  
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
