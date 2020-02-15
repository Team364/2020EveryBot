package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.SupplyCurrentLimitConfiguration;

import static frc.robot.RobotMap.*;



public class Arm extends SubsystemBase {
    
    public TalonSRX mArm;

    public SupplyCurrentLimitConfiguration ArmSupplyLimit = new SupplyCurrentLimitConfiguration(
    ARMENABLECURRENTLIMIT, 
    ARMCONTINUOUSCURRENTLIMIT, 
    ARMPEAKCURRENT, 
    ARMPEAKCURRENTDURATION);



    public Arm() {
        mArm = new TalonSRX(ARMTALON);

        mArm.configFactoryDefault();

        mArm.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
        mArm.setSelectedSensorPosition(0);

        mArm.config_kP(0, ARMKP);
        mArm.config_kI(0, ARMKI);
        mArm.config_kD(0, ARMKD);

        mArm.setInverted(true);
        mArm.setSensorPhase(false);
        mArm.configSupplyCurrentLimit(ArmSupplyLimit, 20);
        mArm.setNeutralMode(NeutralMode.Coast);

    }
    public void moveArm(double moveArm) {
        mArm.set(ControlMode.Position, moveArm);
    }
}