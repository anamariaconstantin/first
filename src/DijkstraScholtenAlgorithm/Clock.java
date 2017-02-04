/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DijkstraScholtenAlgorithm;

/**
 *
 * @author ana-maria
 */
public class Clock {

	private int clockVal;

	public Clock(){
		setClockVal(0);
	}
	
	public synchronized void tick(int delay, int newTime) throws InterruptedException{
		Thread.sleep(delay); //Sleep for delayTime
		
		if(newTime>getClockVal()) //Set clock according to Lamport clock
			setClockVal(newTime+1);
		else
			setClockVal(getClockVal()+1);
	}
	
	public int getClockVal() {
		return clockVal;
	}

	public void setClockVal(int clockVal) {
		this.clockVal = clockVal;
	}
}
