package edu.kit.informatik.ragnarok.logic.gui.menu;

import edu.kit.informatik.ragnarok.logic.scene.Scene;
import edu.kit.informatik.ragnarok.primitives.geometry.Vec;

/**
 *
 * This class realizes a {@link MenuSubMenu}. In this SubMenu Items will be
 * arranged as Grid
 *
 */
public class MenuGrid extends MenuSubMenu {
	/**
	 * Number of columns
	 */
	private int colCount;
	/**
	 * Number of rows
	 */
	private int rowCount;

	/**
	 * Create a MenuGrid
	 * 
	 * @param scene
	 *            the scene
	 * @param text
	 *            the text (name)
	 * @param colCount
	 *            the column count
	 */
	public MenuGrid(Scene scene, String text, int colCount) {
		super(scene, text);
		this.colCount = colCount;
		this.setItemSize(new Vec(100));
	}

	@Override
	public void up() {
		if (this.selected) {
			this.menuItems.get(this.index).setHover(false);
			this.index -= this.colCount;

			if (this.index < 0) {
				this.index += this.rowCount * this.colCount;
				if (this.index >= this.menuItems.size()) {
					this.index -= this.colCount;
				}
			}

			this.menuItems.get(this.index).setHover(true);
		} else {
			this.menuItems.get(this.index).up();
		}
	}

	@Override
	public void down() {
		if (this.selected) {
			this.menuItems.get(this.index).setHover(false);
			this.index += this.colCount;
			if (this.index >= this.menuItems.size()) {
				this.index %= this.colCount;
			}
			this.menuItems.get(this.index).setHover(true);
		} else {
			this.menuItems.get(this.index).down();
		}
	}

	@Override
	public void left() {
		if (this.selected) {
			this.menuItems.get(this.index).setHover(false);
			this.index -= 1;
			if (this.index < 0) {
				this.index = this.menuItems.size() - 1;
			}
			this.menuItems.get(this.index).setHover(true);
		} else {
			this.menuItems.get(this.index).up();
		}
	}

	@Override
	public void right() {
		if (this.selected) {
			this.menuItems.get(this.index).setHover(false);
			this.index += 1;
			if (this.index >= this.menuItems.size()) {
				this.index = 0;
			}
			this.menuItems.get(this.index).setHover(true);
		} else {
			this.menuItems.get(this.index).down();
		}
	}

	@Override
	protected void calcItemPos() {
		// render menu as grid with max colCount items per row
		this.rowCount = this.menuItems.size() / this.colCount + 1;
		final Vec startOffset = new Vec(-((this.colCount - 1) * this.itemSize.getY()) / 2, -((this.rowCount - 1) * this.itemSize.getY()) / 2);
		Vec offset = startOffset.clone();

		int curCol = 0;
		for (final MenuItem menuItem : this.menuItems) {
			menuItem.setPos(this.getPos().add(offset));
			if (++curCol >= this.colCount) {
				offset = offset.setX(startOffset.getX());
				offset = offset.addY(this.itemSize.getY());
				curCol = 0;
			} else {
				offset = offset.addX(this.itemSize.getX());
			}
		}
	}

}