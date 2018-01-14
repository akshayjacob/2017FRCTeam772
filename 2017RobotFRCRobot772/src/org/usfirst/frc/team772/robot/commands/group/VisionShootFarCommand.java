package org.usfirst.frc.team772.robot.commands.group;

import org.usfirst.frc.team772.robot.commands.AutoTurnCommand;
import org.usfirst.frc.team772.robot.commands.LightCommand;
import org.usfirst.frc.team772.robot.commands.ShootCommand;
import org.usfirst.frc.team772.robot.commands.visionBoiler.TargetBoilerSortCommand;
import org.usfirst.frc.team772.robot.commands.visionBoiler.VisionBoilerTargetCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class VisionShootFarCommand extends CommandGroup {

    public VisionShootFarCommand() {
    	addParallel(new LightCommand(0.5));
		addSequential(new VisionBoilerTargetCommand("targets"));
		addSequential(new TargetBoilerSortCommand());
		addSequential(new AutoTurnCommand());
		addSequential(new ShootCommand(true,1));
    }
}
