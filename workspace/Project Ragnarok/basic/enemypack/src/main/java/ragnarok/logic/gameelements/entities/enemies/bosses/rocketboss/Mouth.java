package ragnarok.logic.gameelements.entities.enemies.bosses.rocketboss;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import ragnarok.core.GameGrid;
import ragnarok.primitives.geometry.Vec;
import ragnarok.primitives.image.RGBColor;
import ragnarok.primitives.time.Timer;

public class Mouth {

	private RocketBoss parent;

	private Vec pos;
	private Vec size;
	private RGBColor col;

	private Timer mouthCurveTimer = new Timer(50);
	private Vec mouthCurvePos;
	private List<Vec> mouthCurve = new LinkedList<>();

	public Mouth(RocketBoss parent, Vec pos, Vec size, RGBColor col) {
		this.parent = parent;
		this.pos = pos;
		this.size = size;
		this.col = col;
	}

	public void logicLoop(float calcX, float deltaX) {
		this.mouthCurvePos = parent.getPos().add(this.pos).addX(0.5f * this.size.getX()).addX(-calcX);
		mouthCurveTimer.logicLoop();
		float maxDelta = this.size.getY() * 0.5f;
		while (mouthCurveTimer.timeUp()) {
			mouthCurveTimer.reset();
			Vec newVec = new Vec(calcX, (float) (Math.tan(calcX * 10) * Math.sin(calcX * 4) * Math.cos(calcX * 0.5f) * maxDelta));
			if (newVec.getY() > maxDelta) {
				newVec = newVec.setY(maxDelta);
			}
			if (newVec.getY() < -maxDelta) {
				newVec = newVec.setY(-maxDelta);
			}
			mouthCurve.add(newVec);
		}
		Iterator<Vec> it = mouthCurve.iterator();
		while (it.hasNext()) {
			if (it.next().getX() <= calcX - this.size.getX()) {
				it.remove();
			}
		}
	}

	public void internalRender(GameGrid f) {
		f.drawRectangle(this.parent.getPos().add(this.pos), this.size, this.col);
		f.drawPath(mouthCurvePos, mouthCurve, new RGBColor(0, 0, 0));
	}
}
