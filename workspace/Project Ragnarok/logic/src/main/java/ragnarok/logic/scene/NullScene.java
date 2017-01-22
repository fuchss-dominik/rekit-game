package ragnarok.logic.scene;

import ragnarok.logic.GameModel;
import ragnarok.logic.gui.menu.MenuItem;

/**
 * This class realizes a Scene as a placeholder.
 */
final class NullScene extends Scene {
	/**
	 * Create a new NullScene.
	 * 
	 * @param model
	 *            the model
	 */
	public NullScene(GameModel model) {
		super(model);
	}

	@Override
	public int getScore() {
		return 0;
	}

	@Override
	public int getHighScore() {
		return 0;
	}

	@Override
	public MenuItem getMenu() {
		return null;
	}

	/**
	 * Create method of the scene.
	 *
	 * @param model
	 *            the model
	 * @param options
	 *            the options
	 * @return a new arcade scene.
	 */
	public static Scene create(GameModel model, String[] options) {
		return new NullScene(model);
	}

}