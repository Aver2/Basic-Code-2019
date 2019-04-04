/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Compressor;
/**
 * Add your docs here.
 */
public class Arm extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

 public TalonSRX armTalon = new TalonSRX(1);
 public DoubleSolenoid armSolenoid = new DoubleSolenoid(0,1); 
 public AnalogInput pressureSensor = new AnalogInput(0);
 Compressor compressor = new Compressor(0);
 public void Punch(boolean bob) {
  if (bob == true) 
    armSolenoid.set(DoubleSolenoid.Value.kForward);

   else 
    armSolenoid.set(DoubleSolenoid.Value.kReverse);
}
public double getPressure(){
  double rawVoltage = pressureSensor.getVoltage();
  return ( 250*(rawVoltage/5) - 25);
}
    public void Pivot(double move) {
    armTalon.set(ControlMode.PercentOutput,move);
    }
    
    @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
