/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Global;
import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.subsystems.Drivetrain;

public class FullSpeedAhead extends Command {
  public FullSpeedAhead() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.drivetrain);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Drivetrain.drive(0, 0, 0);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if (Math.abs(OI.driveCont.getRawAxis(1)) <= Global.DEADZONE) {
      Drivetrain.drive(0, 0, 0);
    }else{
      Drivetrain.drive(0, -OI.driveCont.getRawAxis(1), 0);
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Drivetrain.drive(0, 0, 0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Drivetrain.drive(0, 0, 0);
  }
}
