package edu.kit.informatik.ragnarok.logic.gameelements.inanimate;

import edu.kit.informatik.ragnarok.logic.gameelements.Field;
import edu.kit.informatik.ragnarok.primitives.Vec;
import edu.kit.informatik.ragnarok.util.RGBColor;

public class InanimateDoor extends InanimateBox {

	public InanimateDoor(Vec pos) {
		super(pos, new Vec(1, 7), new RGBColor(130, 130, 130));
	}

	@Override
	public void render(Field f) {
		f.drawRectangle(this.getPos(), this.size, this.color);

		Vec start = this.getPos().add(this.size.multiply(-(1 / 2f))).add(new Vec(0.1f, 0.1f));
		Vec end = start.add(this.size).add(new Vec(-0.2f, -0.2f));

		for (float x = start.getX(); x <= end.getX(); x += 0.2) {
			f.drawCircle(new Vec(x, start.getY()), new Vec(0.12f), new RGBColor(80, 80, 80));
			f.drawCircle(new Vec(x, end.getY()), new Vec(0.12f), new RGBColor(80, 80, 80));
		}

		for (float y = start.getY(); y <= end.getY(); y += 0.2) {
			f.drawCircle(new Vec(start.getX(), y), new Vec(0.12f), new RGBColor(80, 80, 80));
			f.drawCircle(new Vec(end.getX(), y), new Vec(0.12f), new RGBColor(80, 80, 80));

		}
	}

}
