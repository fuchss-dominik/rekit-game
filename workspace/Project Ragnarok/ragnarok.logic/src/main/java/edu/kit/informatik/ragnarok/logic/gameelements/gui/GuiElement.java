package edu.kit.informatik.ragnarok.logic.gameelements.gui;

import edu.kit.informatik.ragnarok.logic.gameelements.Field;
import edu.kit.informatik.ragnarok.logic.scene.Scene;
import edu.kit.informatik.ragnarok.primitives.Vec;

public abstract class GuiElement {

	protected boolean visible = true;
	private Vec pos = new Vec(0);

	private Scene scene;

	public GuiElement(Scene scene) {
		this.scene = scene;
	}

	public boolean isVisible() {
		return this.visible;
	}

	public void setPos(Vec value) {
		this.pos = value;
	}

	public Vec getPos() {
		return this.pos;
	}

	public Scene getScene() {
		return this.scene;
	}

	public int getZ() {
		return 0;
	}

	public void logicLoop(float deltaTime) {
		// Do nothing
	}

	public final void render(Field f) {
		if (this.isVisible()) {
			this.internRender(f);
		}
	}

	public abstract void internRender(Field f);

}
