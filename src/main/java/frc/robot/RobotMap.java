package frc.robot;

public class RobotMap {
    //Arm Positions
    public static final double ARMSTOWEDPOSITION = -300;
    public static final double ARMSCORINGPOSITION = 1500;
    public static final double ARMINTAKEPOSITION = 3000;

    //Intaking and Outaking Speeds
    public static final double INTAKEPOWER = 1;
    public static final double OUTAKEPOWER = -1;

    //Talon SRX CAN ID's
    public static final int DRIVERIGHTTALON = 1;
    public static final int DRIVERIGHTSLAVETALON = 2;
    public static final int DRIVELEFTTALON = 3;
    public static final int DRIVELEFTSLAVETALON = 4;
    public static final int INTAKETALON = 5;
    public static final int ARMTALON = 6;

    //Arm PID Constants
    public static final double ARMKP = 0.5;
    public static final double ARMKI = 0.001;
    public static final double ARMKD = 100;

    //Supply Current Limits
    public static final int DRIVECONTINUOUSCURRENTLIMIT = 35;
    public static final int DRIVEPEAKCURRENT = 60;
    public static final double DRIVEPEAKCURRENTDURATION = 0.1;
    public static final boolean DRIVEENABLECURRENTLIMIT = true;

    public static final int ARMCONTINUOUSCURRENTLIMIT = 25;
    public static final int ARMPEAKCURRENT = 30;
    public static final double ARMPEAKCURRENTDURATION = 0.1;
    public static final boolean ARMENABLECURRENTLIMIT = true;

    public static final int INTAKECONTINUOUSCURRENTLIMIT = 25;
    public static final int INTAKEPEAKCURRENT = 30;
    public static final double INTAKEPEAKCURRENTDURATION = 0.1;
    public static final boolean INTAKEENABLECURRENTLIMIT = true;
}
