/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.PIDCommand;
import frc.robot.Robot;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.LimeLight;


public class AutoTarget extends PIDCommand {

  static double kP = 2.0;
  static double kI = 2.0;
  static double kD = 2.0;

  public AutoTarget() {
    super("AutoTarget",kP,kI,kD);
    requires(Robot.driveTrain);
    setSetpoint(0);
    //getPIDController(this.getPIDController().setTolerance(0.1));
  }

  @Override
  protected double returnPIDInput() {
    return Robot.limeLight.getTX();
  }

  @Override
  protected void usePIDOutput(double output) {
    Robot.driveTrain.arcadeDrive(0, output);
  }

  @Override
  protected boolean isFinished() {
    return false;
  }
  
   
}
