package org.usfirst.frc.team772.robot.commands.visionGear;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import org.usfirst.frc.team772.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class OpenGearSocketCommand extends Command {

    public OpenGearSocketCommand() {
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	SmartDashboard.putString("DB/String 8", "Connecting to GearPI");
    	try {
			Robot.echoSocketGear = new Socket("10.7.72.9", 5803);
			Robot.outtGear = new ObjectOutputStream(Robot.echoSocketGear.getOutputStream());					
			Robot.innGear = new ObjectInputStream(Robot.echoSocketGear.getInputStream()); 
			SmartDashboard.putString("DB/String 8", "Connected To GearPI");
		} catch (IOException e) {
			SmartDashboard.putString("DB/String 8", "Not Connected To GearPI");
		}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
