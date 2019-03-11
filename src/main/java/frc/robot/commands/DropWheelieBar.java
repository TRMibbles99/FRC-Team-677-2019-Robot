/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import com.revrobotics.CANSparkMax.IdleMode;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.Robot;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Lift;

public class DropWheelieBar extends Command {
  //Spins in a circle to drop the wheelie bar
  //Also runs the lift motor backwards to prevent it from lifting up

  double initTime;

  public DropWheelieBar() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.drivetrain);
    requires(Robot.lift);

  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Drivetrain.drive(0, 0, 0);
    Lift.liftMotor(0);

    Drivetrain.leftFront.setIdleMode(IdleMode.kCoast);
    Drivetrain.leftBack.setIdleMode(IdleMode.kCoast);
    Drivetrain.rightFront.setIdleMode(IdleMode.kCoast);
    Drivetrain.rightBack.setIdleMode(IdleMode.kCoast);

    initTime = Timer.getFPGATimestamp();
  }
  

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if (Timer.getFPGATimestamp() - initTime >= 2) {
      Drivetrain.drive(0, 0, 0);
      Lift.liftMotor(0);
    } else {
      Drivetrain.drive(0, 0, .7);
      Lift.liftMotor(.2);
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return Timer.getFPGATimestamp() - initTime >= 4;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Drivetrain.drive(0, 0, 0);
    Lift.liftMotor(0);

    Drivetrain.leftFront.setIdleMode(IdleMode.kBrake);
    Drivetrain.leftBack.setIdleMode(IdleMode.kBrake);
    Drivetrain.rightFront.setIdleMode(IdleMode.kBrake);
    Drivetrain.rightBack.setIdleMode(IdleMode.kBrake);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Drivetrain.drive(0, 0, 0);
    Lift.liftMotor(0);

    
    Drivetrain.leftFront.setIdleMode(IdleMode.kBrake);
    Drivetrain.leftBack.setIdleMode(IdleMode.kBrake);
    Drivetrain.rightFront.setIdleMode(IdleMode.kBrake);
    Drivetrain.rightBack.setIdleMode(IdleMode.kBrake);

//    Scheduler.getInstance().
  }
}