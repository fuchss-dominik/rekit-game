package edu.kit.informatik.ragnarok.logic;

import java.util.Iterator;

import edu.kit.informatik.ragnarok.logic.gameelements.GameElement;
import edu.kit.informatik.ragnarok.logic.gameelements.entities.Entity;
import edu.kit.informatik.ragnarok.logic.gameelements.gui.GuiElement;

/**
 * This Interface defines the Model for the MVC
 *
 * @author Dominik Fuchß
 *
 */
public interface Model {
	/**
	 * Get the model
	 *
	 * @return the model
	 */
	static Model getModel() {
		return new GameModel();
	}

	/**
	 * Get an Iterator over all {@link GameElement GameElements}
	 * 
	 * @return the iterator
	 */
	Iterator<GameElement> getGameElementIterator();
	
	/**
	 * Get an Iterator over all {@link GuiElement GuiElements}
	 * 
	 * @return the iterator
	 */
	Iterator<GuiElement> getGuiElementIterator();

	/**
	 * Get the Player
	 * 
	 * @return the player
	 */
	Entity getPlayer();

	/**
	 * Get the current score of the Player
	 * 
	 * @return the score
	 */
	int getScore();

	/**
	 * Get the current highscore
	 * 
	 * @return the highscore
	 */
	int getHighScore();

	/**
	 * Get the camera offset
	 * 
	 * @return the camera offset
	 */
	float getCameraOffset();

	/**
	 * Start the model
	 */
	void start();

}
