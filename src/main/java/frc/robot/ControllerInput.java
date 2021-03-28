package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;

public class ControllerInput {

    final static double DEAD_ZONE = 0.2;

    public static void ManageInput(XboxController controller, RobotCommand command) {
        double y = controller.getY(Hand.kLeft);
        double x = controller.getX(Hand.kRight);
        if (Math.abs(y) >= DEAD_ZONE) {
            if (Math.abs(y) > 1.0)
                y = 1.0 * Math.signum(y);
            command.driveSpeed = y;
        } else {
            command.driveSpeed = 0;
        }
        if (Math.abs(x) >= DEAD_ZONE) {
            if (Math.abs(x) > 1.0)
                x = 1.0 * Math.signum(x);
            command.turnDirection = Math.signum(x);
            command.turnSpeed = x;
        } else {
            command.turnDirection = 0;
            command.turnSpeed = 0;
        }
    }

}
