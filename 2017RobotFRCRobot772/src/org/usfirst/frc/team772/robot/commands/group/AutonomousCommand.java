package org.usfirst.frc.team772.robot.commands.group;

import org.usfirst.frc.team772.robot.Robot;
import org.usfirst.frc.team772.robot.commands.AutoDriveCommand;
import org.usfirst.frc.team772.robot.commands.AutoDriveUltraSonicBackwardCommand;
import org.usfirst.frc.team772.robot.commands.AutoDriveUltraSonicForwardCommand;
import org.usfirst.frc.team772.robot.commands.AutoTurnCommand;
import org.usfirst.frc.team772.robot.commands.EnvelopeCommand;
import org.usfirst.frc.team772.robot.commands.GearShiftCommand;
import org.usfirst.frc.team772.robot.commands.IntakeCommand;
import org.usfirst.frc.team772.robot.commands.LightCommand;
import org.usfirst.frc.team772.robot.commands.ShootCommand;
import org.usfirst.frc.team772.robot.commands.TurnWithPIDCommand;
import org.usfirst.frc.team772.robot.commands.TurnWithoutPIDCommand;
import org.usfirst.frc.team772.robot.commands.WaitCommand;
import org.usfirst.frc.team772.robot.commands.WaitWithoutCheckCommand;
import org.usfirst.frc.team772.robot.commands.visionBoiler.OpenBoilerSocketCommand;
import org.usfirst.frc.team772.robot.commands.visionBoiler.TargetBoilerSortCommand;
import org.usfirst.frc.team772.robot.commands.visionBoiler.VisionBoilerTargetCommand;
import org.usfirst.frc.team772.robot.commands.visionGear.OpenGearSocketCommand;
import org.usfirst.frc.team772.robot.commands.visionGear.TargetGearSortCommand;
import org.usfirst.frc.team772.robot.commands.visionGear.VisionGearTargetCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AutonomousCommand extends CommandGroup {

    public AutonomousCommand(int side, int autoMode, int delay) {
    	switch(side){
    	case 0: redSide(autoMode, delay);
    		break;
    	case 1: blueSide(autoMode, delay);
    		break;
    	default: defult();
			break;
    	}
    }
    
    public void redSide(int autoMode, int delay){
    	switch(autoMode){
    	case 0: defult();
    		break;
    	case 1: autoMode1Red(delay);
    		break;
    	case 2: autoMode2Red(delay);
			break;
    	case 3: autoMode3Red(delay);
			break;
    	case 4: autoMode4Red(delay);
			break;
    	case 5: autoMode5Red(delay);
			break;
    	case 6: autoMode6Red(delay);
			break;
    	default: defult();
			break;
    	}
    }
    
    public void blueSide(int autoMode, int delay){
    	switch(autoMode){
    	case 0: defult();
    		break;
    	case 1: autoMode1Blue(delay);
    		break;
    	case 2: autoMode2Blue(delay);
			break;
    	case 3: autoMode3Blue(delay);
			break;
    	case 4: autoMode4Blue(delay);
			break;
    	case 5: autoMode5Blue(delay);
			break;
    	case 6: autoMode6Blue(delay);
			break;
    	default: defult();
			break;
    	}
    }
    
    /*
     * red side auto modes
     * 
     * Mode1:Use for middle gear. Hangs gear then shoot. Human player has 1.5 seconds to get gear out
     * Mode2:Use for side gear(
     * 
     */
    public void autoMode1Red(int delay){
    	addParallel(new LightCommand(0.5));
//		addSequential(new OpenGearSocketCommand());
//		addSequential(new OpenBoilerSocketCommand());
    	addParallel(new EnvelopeCommand(true));
    	addSequential(new AutoDriveUltraSonicForwardCommand(.7, 7));
    	addSequential(new WaitCommand(2));
//    	if(Robot.envelopeSubsystem.gearCheck()){
//    		addParallel(new EnvelopeCommand(false));
//    		addSequential(new AutoDriveUltraSonicBackwardCommand(-.7, 35));
//    		addSequential(new VisionGearTargetCommand("targets"));
//    		addSequential(new TargetGearSortCommand());
//    		addSequential(new AutoTurnCommand());
//    		addParallel(new EnvelopeCommand(true));
//        	addSequential(new AutoDriveUltraSonicForwardCommand(.6, 7));
//    		addSequential(new WaitCommand(2));
//    	}
    	addParallel(new EnvelopeCommand(false));
    	addSequential(new AutoDriveUltraSonicBackwardCommand(-.7, 50));
    	addSequential(new TurnWithPIDCommand(-100));
    	addSequential(new AutoDriveUltraSonicForwardCommand(1, 45));
    	addSequential(new VisionBoilerTargetCommand("targets"));
		addSequential(new TargetBoilerSortCommand());
		addSequential(new AutoTurnCommand());
    	addSequential(new ShootCommand(true,0.85));
    	
    }
    public void autoMode2Red(int delay){
    	addParallel(new LightCommand(0.5));
//    	addSequential(new OpenGearSocketCommand());
//		addSequential(new OpenBoilerSocketCommand());
    	addSequential(new AutoDriveCommand(-8));
    	addSequential(new TurnWithPIDCommand(90));
    	addSequential(new AutoDriveUltraSonicForwardCommand(.7, 15));
    	addSequential(new WaitCommand(1));
    	addSequential(new AutoDriveUltraSonicBackwardCommand(-.5,2));
    	addSequential(new TurnWithPIDCommand(-90));
    	addParallel(new IntakeCommand(true));
    	addSequential(new VisionBoilerTargetCommand("targets"));
		addSequential(new TargetBoilerSortCommand());
		addSequential(new AutoTurnCommand());
    	addSequential(new AutoDriveUltraSonicForwardCommand(1, 50));
    	addSequential(new ShootCommand(true,0.85));
    	
    }
//	if(Robot.envelopeSubsystem.gearCheck()){
//	addParallel(new EnvelopeCommand(true));
//	addSequential(new AutoDriveUltraSonicBackwardCommand(-.7, 35));
//	addSequential(new VisionGearTargetCommand("targets"));
//	addSequential(new TargetGearSortCommand());
//	addSequential(new AutoTurnCommand());
////	addParallel(new EnvelopeCommand(false));
//	addSequential(new AutoDriveUltraSonicForwardCommand(.6, 7));
//	addSequential(new WaitCommand(3));
//	
//	addSequential(new AutoDriveUltraSonicBackwardCommand(-.7, 50));
//	addSequential(new TurnWithPIDCommand(190));
//	addSequential(new VisionBoilerTargetCommand("targets"));
//	addSequential(new TargetBoilerSortCommand());
//	addSequential(new AutoTurnCommand());
//	addSequential(new AutoDriveUltraSonicForwardCommand(1, 15));
//}else{
//	addSequential(new AutoDriveCommand(-2));
    public void autoMode3Red(int delay){
    	addParallel(new LightCommand(0.25));
//    	addSequential(new OpenGearSocketCommand());
//		addSequential(new OpenBoilerSocketCommand());
    	addSequential(new AutoDriveCommand(6.5));
    	addSequential(new TurnWithPIDCommand(60));
    	addSequential(new WaitWithoutCheckCommand(.5));
    	addSequential(new VisionGearTargetCommand("targets"));
    	addSequential(new TargetGearSortCommand());
    	addParallel(new EnvelopeCommand(true));
    	addSequential(new AutoTurnCommand());
    	addSequential(new AutoDriveUltraSonicForwardCommand(.6, 7));
    	addSequential(new WaitCommand(2));
    	addSequential(new AutoDriveUltraSonicBackwardCommand(-1, 40));
    	addParallel(new LightCommand(0.5));
    	addParallel(new EnvelopeCommand(false));
    	addSequential(new TurnWithoutPIDCommand(170));
    	addSequential(new VisionBoilerTargetCommand("targets"));
    	addSequential(new TargetBoilerSortCommand());
    	addSequential(new AutoTurnCommand());
    	addSequential(new AutoDriveUltraSonicForwardCommand(1, 15));
    	addSequential(new ShootCommand(true,0.85));
    }
    public void autoMode4Red(int delay){
//    	SmartDashboard.putString("DB/String 3", "Red, Left Hook");
    	addParallel(new LightCommand(0.25));
//    	addSequential(new OpenGearSocketCommand());
//		addSequential(new OpenBoilerSocketCommand());
    	addSequential(new AutoDriveCommand(6));
    	addSequential(new TurnWithPIDCommand(-45));  
    	addSequential(new WaitWithoutCheckCommand(.5));
    	addSequential(new VisionGearTargetCommand("targets"));
    	addSequential(new TargetGearSortCommand());
    	addSequential(new AutoTurnCommand());
    	addParallel(new EnvelopeCommand(true));
    	addSequential(new AutoDriveUltraSonicForwardCommand(.6, 7));
    	addSequential(new WaitCommand(2));
//    	if(Robot.envelopeSubsystem.gearCheck()){
//    		addParallel(new EnvelopeCommand(false));
//    		addSequential(new AutoDriveUltraSonicBackwardCommand(-.7, 35));
//    		addSequential(new VisionGearTargetCommand("targets"),0.5);
//    		addSequential(new TargetGearSortCommand(),0.5);
//    		addSequential(new AutoTurnCommand());
//    		addParallel(new EnvelopeCommand(true));
//        	addSequential(new AutoDriveUltraSonicForwardCommand(.6, 7));
//    		addSequential(new WaitCommand(2));
//    	}else{
//    	
//    	}
    }
    public void autoMode5Red(int delay){
    	
    }
    public void autoMode6Red(int delay){
    	
    }
    
    /*
     * blue side auto modes
     * 
     * 
     */
    public void autoMode1Blue(int delay){
    	addParallel(new LightCommand(0.5));
//    	addSequential(new OpenGearSocketCommand());
//		addSequential(new OpenBoilerSocketCommand());
		addParallel(new EnvelopeCommand(true));
    	addSequential(new AutoDriveUltraSonicForwardCommand(.6, 7));
    	addSequential(new WaitCommand(2));
//    	if(Robot.envelopeSubsystem.gearCheck()){
//    		addParallel(new EnvelopeCommand(false));
//    		addSequential(new AutoDriveUltraSonicBackwardCommand(-.7, 35));
//    		addSequential(new VisionGearTargetCommand("targets"));
//    		addSequential(new TargetGearSortCommand());
//    		addSequential(new AutoTurnCommand());
//    		addParallel(new EnvelopeCommand(true));
//        	addSequential(new AutoDriveUltraSonicForwardCommand(.6, 7));
//    		addSequential(new WaitCommand(2));
//    	}
    	addParallel(new EnvelopeCommand(false));
    	addSequential(new AutoDriveCommand(-1));
    	addSequential(new TurnWithPIDCommand(100));
    	addSequential(new AutoDriveUltraSonicForwardCommand(1, 45));
    	addSequential(new VisionBoilerTargetCommand("targets"));
		addSequential(new TargetBoilerSortCommand());
		addSequential(new AutoTurnCommand());
    	addSequential(new ShootCommand(true,.85));
    	
    }
    public void autoMode2Blue(int delay){
    	addParallel(new LightCommand(0.5));
//    	addSequential(new OpenGearSocketCommand());
//		addSequential(new OpenBoilerSocketCommand());
    	addSequential(new AutoDriveCommand(-8));
    	addSequential(new TurnWithPIDCommand(-90));
    	addSequential(new AutoDriveUltraSonicForwardCommand(.7, 15));
    	addSequential(new WaitCommand(1));
    	addSequential(new AutoDriveUltraSonicBackwardCommand(-.5,2));
    	addSequential(new TurnWithPIDCommand(90));
    	addParallel(new IntakeCommand(true));
    	addSequential(new VisionBoilerTargetCommand("targets"));
		addSequential(new TargetBoilerSortCommand());
		addSequential(new AutoTurnCommand());
    	addSequential(new AutoDriveUltraSonicForwardCommand(1, 50));
    	addSequential(new ShootCommand(true,0.85));
    }
    public void autoMode3Blue(int delay){
    	addParallel(new LightCommand(0.25));
    	addSequential(new AutoDriveCommand(6.5));
//    	addSequential(new OpenGearSocketCommand());
//		addSequential(new OpenBoilerSocketCommand());
    	addSequential(new TurnWithPIDCommand(-60));    	
    	addSequential(new WaitCommand(.5));
    	addSequential(new VisionGearTargetCommand("targets"),0.5);
    	addSequential(new TargetGearSortCommand(),0.5);
    	addSequential(new AutoTurnCommand());
    	addParallel(new EnvelopeCommand(true));
    	addSequential(new AutoDriveUltraSonicForwardCommand(.6, 7));
    	addSequential(new WaitCommand(2));
//    	if(Robot.envelopeSubsystem.gearCheck()){
//    		addParallel(new EnvelopeCommand(false));
//    		addSequential(new AutoDriveUltraSonicBackwardCommand(-.7, 35));
//    		addSequential(new VisionGearTargetCommand("targets"),0.5);
//	    	addSequential(new TargetGearSortCommand(),0.5);
//	    	addSequential(new AutoTurnCommand());
//	    	addParallel(new EnvelopeCommand(true));
//	    	addSequential(new AutoDriveUltraSonicForwardCommand(.6, 7));
//	    	addSequential(new WaitCommand(2));
//    	}else{
//    	
//    	}
    	addSequential(new AutoDriveUltraSonicBackwardCommand(-1, 40));
    	addParallel(new LightCommand(0.5));
    	addSequential(new TurnWithPIDCommand(-170));
    	addSequential(new VisionBoilerTargetCommand("targets"));
    	addSequential(new TargetBoilerSortCommand());
    	addSequential(new AutoTurnCommand());
    	addSequential(new AutoDriveUltraSonicForwardCommand(1, 15));
    	addSequential(new ShootCommand(true,0.85));
    }
    public void autoMode4Blue(int delay){
    	addParallel(new LightCommand(0.25));
//    	addSequential(new OpenGearSocketCommand());
//		addSequential(new OpenBoilerSocketCommand());
    	addSequential(new AutoDriveCommand(6));
    	addSequential(new TurnWithPIDCommand(45));    
    	addSequential(new WaitCommand(0.5));
    	addSequential(new VisionGearTargetCommand("targets"),0.5);
    	addSequential(new TargetGearSortCommand(),0.5);
    	addSequential(new AutoTurnCommand());
    	addParallel(new EnvelopeCommand(true));
    	addSequential(new AutoDriveUltraSonicForwardCommand(.6, 7));
    	addSequential(new WaitCommand(2));
//    	if(Robot.envelopeSubsystem.gearCheck()){
//    		addParallel(new EnvelopeCommand(false));
//    		addSequential(new AutoDriveUltraSonicBackwardCommand(-.7, 35));
//    		addSequential(new VisionGearTargetCommand("targets"),0.5);
//    		addSequential(new TargetGearSortCommand(),0.5);
//    		addSequential(new AutoTurnCommand());
//    		addParallel(new EnvelopeCommand(true));
//        	addSequential(new AutoDriveUltraSonicForwardCommand(.6, 7));
//    		addSequential(new WaitCommand(2));
//    	}else{
//    	
//    	}
    	
    }
    public void autoMode5Blue(int delay){
    	
    }
    public void autoMode6Blue(int delay){
    	
    }
    
    public void defult(){
    	addSequential(new AutoDriveCommand(7));
    }
}
