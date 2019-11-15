/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.DriveWithJoystick;

/**
 * Add your docs here.
 */
public class DriveTrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  //left
  private WPI_VictorSPX leftFront = new WPI_VictorSPX(RobotMap.Left_Front_Id);
  private WPI_VictorSPX leftMiddle = new WPI_VictorSPX(RobotMap.Left_Middle_Id);
  private WPI_TalonSRX leftBack = new WPI_TalonSRX(RobotMap.Left_Back_Id);

  //right
  private WPI_VictorSPX rightFront = new WPI_VictorSPX(RobotMap.Right_Front_ID);
  private WPI_VictorSPX rightMiddle = new WPI_VictorSPX(RobotMap.Right_Middle_ID);
  private WPI_TalonSRX rightBack = new WPI_TalonSRX(RobotMap.Right_Back_ID);

  private static NeutralMode DRIVE_NEUTRAL_MODE = NeutralMode.Brake;

  private DifferentialDrive drive;


  public DriveTrain(){
    leftFront.configFactoryDefault();
    leftMiddle.configFactoryDefault();
    leftBack.configFactoryDefault();

    rightFront.configFactoryDefault();
    rightMiddle.configFactoryDefault();
    rightBack.configFactoryDefault();

    leftFront.setNeutralMode(DRIVE_NEUTRAL_MODE);
    leftMiddle.setNeutralMode(DRIVE_NEUTRAL_MODE);
    leftBack.setNeutralMode(DRIVE_NEUTRAL_MODE);

    rightFront.setNeutralMode(DRIVE_NEUTRAL_MODE);
    rightMiddle.setNeutralMode(DRIVE_NEUTRAL_MODE);
    rightBack.setNeutralMode(DRIVE_NEUTRAL_MODE);

    leftFront.follow(leftBack);
    leftMiddle.follow(leftBack);

    rightFront.follow(rightBack);
    rightMiddle.follow(rightBack);

    drive = new DifferentialDrive(leftBack, rightBack);
  }
  
  public void arcadeDrive(double speed, double rotation){
    drive.arcadeDrive(speed, rotation);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
     setDefaultCommand(new DriveWithJoystick());
  }
}
