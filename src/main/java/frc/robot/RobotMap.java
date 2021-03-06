/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;


/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  //Drivetrain ports
  public static int LEFT_DRIVE_PORT_FRONT = 1;
  public static int RIGHT_DRIVE_PORT_FRONT = 2;
  public static int LEFT_DRIVE_PORT_BACK = 3;
  public static int RIGHT_DRIVE_PORT_BACK = 4;

  //Solenoid ports
  public static final int CLAW_SOL_A_PORT = 3;
  public static final int CLAW_SOL_B_PORT = 7;

  public static final int WHEELIE_SOL_A_PORT = 0;
  public static final int WHEELIE_SOL_B_PORT = 6;

  //Lift port
  public static final int LIFT_PORT = 7;

  //Wheel Ports
  public static final int LEFT_WHEEL = 6;
  public static final int RIGHT_WHEEL = 5;
  


  
}
