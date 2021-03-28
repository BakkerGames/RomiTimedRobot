package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;

public class ControllerInput {

    public static void ManageInput(XboxController controller, RobotCommand command) {
        double y = controller.getY(Hand.kLeft);
        double x = controller.getX(Hand.kRight);
        if (Math.abs(y) >= 0.1)
        {
            command.driveSpeed = y;
        }
        command.turnDirection = Math.signum(x);
    }
}
