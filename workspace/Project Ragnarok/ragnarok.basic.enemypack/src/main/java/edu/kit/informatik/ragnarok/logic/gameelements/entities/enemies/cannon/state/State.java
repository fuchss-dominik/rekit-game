package edu.kit.informatik.ragnarok.logic.gameelements.entities.enemies.cannon.state;

import edu.kit.informatik.ragnarok.logic.gameelements.entities.enemies.cannon.StateMachine;
import edu.kit.informatik.ragnarok.primitives.time.Timer;

public abstract class State {
	
	protected StateMachine parent;
	protected Timer timer;
	
	public State() {
		this.timer = new Timer(getTimerTime());
	}
	
	public void enter(StateMachine parent) {
		this.parent = parent;
	}
	
	public void leave() {
		// Do nothing
	}
	
	public float getTargetAngle() {
		// default: return DOWN
		return 0;
	}
	
	public float getCannonShake() {
		// default: no shaking
		return 0;
	}
	
	public void logicLoop(float deltaTime) {
		timer.removeTime(deltaTime);
		if (timer.timeUp()) {
			parent.setNextState(this.getNextState());
		}
	}
	
	public abstract State getNextState();
	
	public abstract float getTimerTime();
	
	public void hitSomething() {
		// Do nothing
	}
	
}
