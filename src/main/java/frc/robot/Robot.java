/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.*;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import frc.robot.subsystems.*;
import static frc.robot.RobotMap.*;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private Command m_autonomousCommand;
  ///private RobotContainer m_robotContainer;


  private Joystick controller = new Joystick(0);

  private Drivetrain s_Drivetrain = new Drivetrain();
  private final Intake s_Intake = new Intake();
  private final Arm s_Arm = new Arm();

  //Buttons for Intake
  private final JoystickButton intakeButton = new JoystickButton(controller, 1);
  private final JoystickButton outakeButton = new JoystickButton(controller, 2);

  //D-Pad Buttons for Arm
  private final POVButton armUp = new POVButton(controller, 0);
  private final POVButton armScore = new POVButton(controller, 90);
  private final POVButton armDown = new POVButton(controller, 180);
  

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.
    ///m_robotContainer = new RobotContainer();
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
  }

  /**
   * This autonomous runs the autonomous command selected by your {@link RobotContainer} class.
   */
  @Override
  public void autonomousInit() {
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    //Intaking and Outaking
    intakeButton.whenPressed(() -> s_Intake.runIntake(INTAKEPOWER)).whenReleased(() -> s_Intake.runIntake(0));
    outakeButton.whenPressed(() -> s_Intake.runIntake(OUTAKEPOWER)).whenReleased(() -> s_Intake.runIntake(0));
        
    //Controlling the Arm
    armUp.whenPressed(new RunCommand(() -> s_Arm.moveArm(ARMSTOWEDPOSITION))).whenReleased(() -> doNothing());
    armScore.whenPressed(new RunCommand(() -> s_Arm.moveArm(ARMSCORINGPOSITION))).whenReleased(() -> doNothing());
    armDown.whenPressed(new RunCommand(() -> s_Arm.moveArm(ARMINTAKEPOSITION))).whenReleased(() -> doNothing());

    //GTA Drive
    s_Drivetrain.justDrive(controller.getRawAxis(2), controller.getRawAxis(3), controller.getRawAxis(0));
  }



  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }

  public void doNothing() {

  }
}
