package org.usfirst.frc.team772.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team772.robot.Robot;

/**
 *
 */
public class WaitCommand extends Command {
	double wait;
	public WaitCommand(double wait) {
		this.wait = wait;
		// Use requires() here to declare subsystem dependencies
		requires(Robot.exampleSubsystem);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		setTimeout(wait);
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return isTimedOut() || !Robot.envelopeSubsystem.gearCheck();
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		System.out.println(Robot.envelopeSubsystem.gearCheck());
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}
