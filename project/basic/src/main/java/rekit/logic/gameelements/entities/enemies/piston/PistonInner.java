package rekit.logic.gameelements.entities.enemies.piston;

import rekit.config.GameConf;
import rekit.core.GameGrid;
import rekit.logic.gameelements.GameElement;
import rekit.logic.gameelements.entities.enemies.piston.state.PistonState;
import rekit.logic.gameelements.type.Enemy;
import rekit.primitives.geometry.Direction;
import rekit.primitives.geometry.Vec;
import rekit.primitives.image.RGBAColor;
import rekit.primitives.operable.OpProgress;

public class PistonInner extends Enemy {

	/**
	 * The {@link OpProgress} to switch between
	 * {@link Piston#PISTON_COLOR_1} and {@link Piston#PISTON_COLOR_2}.
	 */
	private OpProgress<RGBAColor> colorProgress;

	private Piston parent;
	
	PistonInner(Piston parent) {
		super(new Vec(), new Vec(), new Vec());
		this.parent = parent;
		this.colorProgress = new OpProgress<RGBAColor>(Piston.PISTON_COLOR_1, Piston.PISTON_COLOR_2);
		
		// this sets initial position and prevents deletion
		this.innerLogicLoop();
	}

	@Override
	public void reactToCollision(GameElement element, Direction dir) {
		if (this.getTeam().isHostile(element.getTeam())) {
			if (((PistonState) this.parent.machine.getState()).getCurrentHeight() > 0) {
				// if piston is currently open, do damage
				element.addDamage(1);
			}
		}
	}
	
	@Override
	public void innerLogicLoop() {
		PistonState currentState = (PistonState) this.parent.machine.getState();
		
		// calculate middle pos and size
		// Note: these position Vecs are relative to the middle of the
		// Pistons Base!
		// Also: in direction UP
		Vec btmPos = new Vec(0, -Piston.BASE_HEIGHT / 2f);

		Vec topPos = btmPos
				// Move current length up
				.addY(-currentState.getCurrentHeight() * this.parent.expansionLength)
				// Remove margin
				.addY(Piston.LOWER_MARGIN)
				// Add shaking upwards
				.addY(-Piston.SHAKING.getNow(GameConf.PRNG.nextFloat()));

		topPos = topPos.setY((topPos.y > btmPos.y) ? btmPos.y : topPos.y);

		Vec middlePos = btmPos.add(topPos).scalar(0.5f);
		Vec size = new Vec(Piston.PISTON_CIRCLE_WIDTHS[0], btmPos.y - topPos.y);

		// setting values for rendering and collision frame
		this.setPos(this.parent.getPos().add(this.parent.rotatePosToDir(middlePos)));
		this.setSize(this.parent.rotateSizeToDir(size));
	}

	@Override
	public void internalRender(GameGrid f) {

		int num = Piston.PISTON_CIRCLE_WIDTHS.length;
		for (int i = 0; i < num; ++i) {
			RGBAColor col = this.colorProgress.getNow(i / (float) num);

			// Draw Rectangle for beam
			Vec size = this.getSize();
			if (this.parent.direction == Direction.LEFT || this.parent.direction == Direction.RIGHT) {
				size = size.setY(Piston.PISTON_CIRCLE_WIDTHS[i] / 1.5f);
			} else {
				size = size.setX(Piston.PISTON_CIRCLE_WIDTHS[i] / 1.5f);
			}
			f.drawRectangle(this.getPos(), size, col);
		}

	}

	@Override
	public GameElement create(Vec startPos, String[] options) {
		return null;
	}

}