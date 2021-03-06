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
import frc.robot.subsystems.Lift;

public class LiftManual extends Command {

//This command lifts the arm, dependant on the second drivers left joystick
  public LiftManual() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.lift);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Lift.liftMotor(0);
  }

  // Called repeatedly when this Command is scheduled to run
  //When the joystick is positive then it runs at .45 speed and when it is fully negative it stalls the motor
  @Override
  protected void execute() {
    if (OI.auxCont.getRawAxis(1) < -Global.DEADZONE) {
      Lift.liftMotor(.7*OI.auxCont.getRawAxis(1));
    } else if (OI.auxCont.getRawAxis(1) > Global.DEADZONE) {
      Lift.liftMotor(.25*-OI.auxCont.getRawAxis(1));
    } else {
      Lift.liftMotor(0);
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
    Lift.liftMotor(0);

  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Lift.liftMotor(0);
  }

}
