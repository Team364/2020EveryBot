/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.SupplyCurrentLimitConfiguration;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.RobotMap.*;

public class Drivetrain extends SubsystemBase {
  private double steer;
  private double throttle;
  private double frontThrottle; 
  private double backThrottle;
  private double leftPower;
  private double rightPower;

  public TalonSRX leftDrive;
  public TalonSRX leftSlave;
  public TalonSRX rightDrive;
  public TalonSRX rightSlave;

  public SupplyCurrentLimitConfiguration DriveSupplyLimit = new SupplyCurrentLimitConfiguration(
    DRIVEENABLECURRENTLIMIT, 
    DRIVECONTINUOUSCURRENTLIMIT, 
    DRIVEPEAKCURRENT, 
    DRIVEPEAKCURRENTDURATION);


  public Drivetrain() {
      leftDrive = new TalonSRX(DRIVELEFTTALON);
      leftSlave = new TalonSRX(DRIVELEFTSLAVETALON);
      rightDrive = new TalonSRX(DRIVERIGHTTALON);
      rightSlave = new TalonSRX(DRIVERIGHTSLAVETALON);

      leftSlave.follow(leftDrive);
      rightSlave.follow(rightDrive);

      leftDrive.setInverted(false);
      rightDrive.setInverted(true);

      leftSlave.setInverted(InvertType.FollowMaster);
      rightSlave.setInverted(InvertType.FollowMaster);

      leftDrive.configSupplyCurrentLimit(DriveSupplyLimit, 20);
      leftSlave.configSupplyCurrentLimit(DriveSupplyLimit, 20);
      rightDrive.configSupplyCurrentLimit(DriveSupplyLimit, 20);
      rightSlave.configSupplyCurrentLimit(DriveSupplyLimit, 20);

      leftDrive.setNeutralMode(NeutralMode.Brake);
      leftSlave.setNeutralMode(NeutralMode.Brake);
      rightDrive.setNeutralMode(NeutralMode.Brake);
      rightSlave.setNeutralMode(NeutralMode.Brake);


  }

  public void openLoop(double leftPower, double rightPower){
    leftDrive.set(ControlMode.PercentOutput, leftPower);
    rightDrive.set(ControlMode.PercentOutput, rightPower);
  }

  public void justDrive(double frontThrottlePower, double backThrottlePower, double steerPower){
    frontThrottle = frontThrottlePower; // RightTrigger
    backThrottle = backThrottlePower; // LeftTrigger
    steer = steerPower; // X-axis of left Joystick

    throttle = backThrottle - frontThrottle;

    leftPower = throttle + steer;
    rightPower = throttle - steer;

    openLoop(leftPower, rightPower);
}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
