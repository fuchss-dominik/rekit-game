package edu.kit.informatik.ragnarok.logic.gameelements.inanimate.filters;

import edu.kit.informatik.ragnarok.core.Field;
import edu.kit.informatik.ragnarok.core.GameElement;
import edu.kit.informatik.ragnarok.logic.filters.GrayScaleMode;
import edu.kit.informatik.ragnarok.logic.gameelements.inanimate.InanimateBox;
import edu.kit.informatik.ragnarok.logic.gameelements.type.DynamicInanimate;
import edu.kit.informatik.ragnarok.primitives.geometry.Direction;
import edu.kit.informatik.ragnarok.primitives.geometry.Vec;
import edu.kit.informatik.ragnarok.primitives.image.Filter;
import edu.kit.informatik.ragnarok.primitives.image.RGBAColor;
import edu.kit.informatik.ragnarok.util.ReflectUtils.LoadMe;

@LoadMe
public class GrayBox extends DynamicInanimate {
	/**
	 * The inner inanimate box
	 */
	protected InanimateBox innerBox;
	/**
	 * The current time offset
	 */
	protected long offset = 0;
	/**
	 * The gray-filter
	 */
	private final Filter filter = new GrayScaleMode();

	/**
	 * Prototype Constructor
	 */
	public GrayBox() {
		super();
	}

	/**
	 * Creaze a BoostBox
	 *
	 * @param pos
	 *            the position
	 * @param size
	 *            the size
	 * @param color
	 *            the color
	 */
	protected GrayBox(Vec pos, Vec size, RGBAColor color) {
		super(pos, size, color);
		// create inner InanimateBox with given position
		this.innerBox = (InanimateBox) InanimateBox.staticCreate(pos);
	}

	@Override
	public void reactToCollision(GameElement element, Direction dir) {
		this.getScene().getModel().setFilter(this.filter);
		this.innerBox.reactToCollision(element, dir);
	}

	@Override
	public void internalRender(Field f) {
		this.innerBox.internalRender(f);
	}

	@Override
	public GrayBox create(Vec startPos, String[] options) {
		return new GrayBox(startPos, new Vec(1), new RGBAColor(80, 80, 255, 255));
	}
}
