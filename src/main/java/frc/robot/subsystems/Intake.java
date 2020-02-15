package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.SupplyCurrentLimitConfiguration;
import static frc.robot.RobotMap.*;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
    public TalonSRX mIntake;

    public SupplyCurrentLimitConfiguration IntakeSupplyLimit = new SupplyCurrentLimitConfiguration(
        INTAKEENABLECURRENTLIMIT, 
        INTAKECONTINUOUSCURRENTLIMIT, 
        INTAKEPEAKCURRENT, 
        INTAKEPEAKCURRENTDURATION);


    public Intake() {
        mIntake = new TalonSRX(INTAKETALON);

        mIntake.setInverted(true);
        mIntake.configSupplyCurrentLimit(IntakeSupplyLimit, 20);
        mIntake.setNeutralMode(NeutralMode.Coast);
    }
    
    public void runIntake(double intakeSpeed) {
        mIntake.set(ControlMode.PercentOutput, intakeSpeed);
    }


}