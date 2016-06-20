package edu.kit.informatik.ragnarok.logic.levelcreator;

import java.util.HashMap;
import java.util.Random;

import edu.kit.informatik.ragnarok.config.GameConf;
import edu.kit.informatik.ragnarok.logic.GameModel;
import edu.kit.informatik.ragnarok.logic.gameelements.entities.enemies.bosses.RektSmasher;
import edu.kit.informatik.ragnarok.primitives.Vec2D;


public class InfiniteLevelCreator extends LevelCreator {
	
	public InfiniteLevelCreator(GameModel model) {
		super(model);
		
		this.bossRooms = new HashMap<Integer, BossRoom>();
		
		// first boss room after 100 units in x direction
		this.bossRooms.put(10, new BossRoom(
		new RektSmasher(new Vec2D()),
		new LevelStructure(new int[][] {
		  {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
		  {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
		  {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
		  {1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
		  {1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0},
		  {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
		  {1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
		  {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
		  {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
		}), this));
	}

	private final int[][][] structures = new int[][][]{
			new int[][] {
					{1},
					{5},
					{1},
					{1}
			},
			new int[][] {
					{4},
					{0},
					{1}
			},

			new int[][] {
					{4},
					{0},
					{0},
					{1}
			},
			new int[][] {
					{4},
					{0},
					{0},
					{0},
					{1}
			},
			
			new int[][] {
					{3},
					{1}
			},
			new int[][] {
					{3},
					{0},
					{1}
			},
			new int[][] {
					{3},
					{0},
					{0},
					{1}
			},
			new int[][] {
					{3},
					{0},
					{0},
					{0},
					{1}
			},
			new int[][] {
					{3},
					{0},
					{0},
					{0},
					{0},
					{1}
			},
			new int[][] {
					{3},
					{0},
					{0},
					{0},
					{0},
					{0},
					{1}
			},
			
			new int[][] {
					{1},
					{1},
			},
			new int[][] {
					{1},
					{1},
					{1}
			},
			new int[][] {
				{1, 0, 0, 1}
			},
			new int[][] {
					{4, 1, 0},
					{1, 1, 1},
					{1, 1, 1},
			},
			new int[][] {
					{1, 0, 4},
					{1, 1, 1},
					{1, 1, 1}
			},
			new int[][] {
					{0, 2, 1},
					{1, 1, 1},
					{1, 1, 1}
			},
			new int[][] {
					{1, 0, 1},
					{1, 0, 1},
					{1, 0, 1}
			},
			new int[][] {
					{0, 0, 0, 1},
					{0, 0, 1, 1},
					{0, 1, 1, 1},
					{1, 1, 1, 1},
					{1, 1, 1, 1}
			},
			new int[][] {
					{1, 1},
					{0, 0},
					{1, 1}
			},
			new int[][] {
					{0, 2},
					{1, 1},
					{0, 0},
					{0, 0},
					{1, 1}
			},
			new int[][] {
					{1, 1, 1},
					{0, 0, 1},
					{0, 0, 1}
			},
			new int[][] {
					{0, 0, 0, 0, 2, 0, 0},
					{0, 2, 0, 0, 1, 1, 1},
					{1, 1, 1, 0, 0, 1, 0},
					{0, 1, 0, 0, 0, 1, 0},
					{1, 1, 0, 0, 0, 1, 1}
			},
			new int[][] {
					{0, 2, 0, 0, 1, 1},
					{1, 1, 0, 0, 1, 1},
					{1, 1, 0, 0, 1, 1},
					{1, 1, 0, 0, 1, 1}
			},
			new int[][] {
					{0, 0, 0, 2, 1},
					{0, 2, 1, 0, 1},
					{1, 0, 1, 0, 1},
					{1, 0, 1, 0, 1}
			},
			new int[][] {
					{0, 0, 0, 0, 0, 0, 1},
					{0, 0, 0, 0, 0, 0, 1},
					{0, 0, 0, 2, 1, 0, 1},
					{0, 2, 1, 0, 1, 0, 1},
					{1, 0, 1, 0, 1, 0, 1}
			},
			new int[][] {
					{0, 0, 0, 0, 0, 0, 1},
					{0, 0, 0, 0, 0, 0, 1},
					{0, 0, 0, 0, 0, 2, 1},
					{0, 0, 1, 0, 1, 0, 1},
					{0, 0, 1, 0, 1, 0, 0},
					{1, 0, 1, 0, 1, 0, 0},
					{1, 0, 1, 0, 1, 1, 1}
			},
			new int[][] {
					{0, 0, 0, 0, 5},
					{0, 2, 1, 1, 1},
					{0, 0, 0, 1, 0},
					{1, 0, 0, 1, 0},
					{1, 0, 0, 1, 0},
					{1, 0, 0, 1, 1}
			},
			new int[][] {
					{0, 0, 0, 0, 1},
					{0, 0, 0, 0, 0},
					{0, 0, 0, 0, 0},
					{0, 0, 0, 0, 1},
					{0, 0, 1, 0, 1},
					{1, 0, 1, 0, 1},
					{1, 0, 1, 0, 1}
			},
			new int[][] {
					{0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
					{0, 0, 0, 0, 0, 5, 0, 2, 0, 0},
					{0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
					{0, 0, 0, 2, 0, 0, 0, 0, 0, 0},
					{1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
					{0, 0, 0, 0, 0, 20, 0, 0, 2, 0},
					{0, 0, 0, 0, 0, 1, 0, 0, 0, 1}
			},
			new int[][] {
					{0, 0, 0, 0, 0, 0, 0},
					{0, 0, 0, 0, 0, 0, 0},
					{0, 0, 0, 0, 0, 0, 0},
					{0, 0, 0, 0, 0, 0, 0},
					{1, 2, 0, 1, 0, 2, 1},
					{1, 0, 0, 0, 0, 0, 1},
					{1, 1, 1, 1, 1, 1, 1}
			},
			new int[][] {
					{0, 0, 0, 0, 0, 1},
					{0, 0, 0, 0, 0, 1},
					{0, 0, 0, 0, 0, 1},
					{0, 1, 0, 2, 0, 1},
					{0, 1, 0, 0, 0, 1},
					{1, 1, 0, 0, 0, 0},
					{1, 1, 1, 1, 1, 1}
			},
			new int[][] {
					{0, 0, 0, 1, 0, 0, 0},
					{0, 0, 1, 0, 1, 0, 0},
					{0, 1, 0, 0, 0, 1, 5},
					{1, 0, 0, 2, 0, 0, 1},
					{1, 1, 1, 1, 1, 1, 1}
			},
			new int[][] {
					{0, 1, 0, 2, 0, 0, 0, 1},
					{0, 1, 0, 0, 2, 0, 0, 1},
					{1, 1, 0, 0, 0, 0, 1, 1},
					{1, 1, 0, 0, 0, 0, 1, 1},
					{1, 1, 1, 1, 1, 1, 1, 1}
			},
			new int[][] {
					{0, 1},
					{4, 1},
					{1, 1},
					{1, 1},
					{1, 1}
			},
			new int[][] {
					{0, 1},
					{0, 1},
					{0, 4},
					{0, 0},
					{1, 1}
			},
			new int[][] {
					{0, 0, 0, 0, 0, 0, 0, 0, 3},
					{0, 0, 0, 0, 0, 1, 1, 0, 0},
					{0, 1, 1, 0, 0, 0, 0, 0, 0},
					{0, 0, 0, 2, 0, 0, 0, 0, 0},
					{1, 0, 0, 0, 0, 0, 0, 0, 0}
			},
			new int[][] {
					{0, 0, 0, 0, 0, 0, 0, 0},
					{0, 0, 0, 0, 0, 1, 1, 1},
					{0, 0, 1, 0, 0, 0, 1, 0},
					{0, 1, 1, 1, 0, 0, 0, 0},
					{0, 0, 0, 0, 0, 0, 0, 0}
			},
			new int[][] {
					{0, 0, 0, 0, 0, 0, 0, 0},
					{0, 0, 0, 0, 0, 0, 1, 1},
					{0, 0, 0, 0, 0, 1, 1, 1},
					{0, 0, 0, 5, 0, 0, 0, 0},
					{0, 0, 1, 1, 0, 0, 0, 0},
					{0, 0, 1, 1, 1, 0, 0, 0},
					{1, 0, 0, 0, 0, 0, 0, 0},
			},
			new int[][] {
					{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
					{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
					{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
					{0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
					{0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
					{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			}
	};
	
	
	private HashMap<Integer, BossRoom> bossRooms;
	
	public void generate(int max) {
		

		while (this.generatedUntil < max) {
			// Save current x to where level was generated yet
			int lastGeneratedUntil = this.generatedUntil;
			
			// Randomly select structure
			Random r = new Random();
			int randId = r.nextInt(structures.length);
			
			// Randomly determine gap between this structure and the next
			int gap = r.nextInt(2) + 1;
			
			// Get structure and all required info
			LevelStructure struc = new LevelStructure(this.structures[randId]);
			
			// Calculate where to generate structure
			int ix = generatedUntil + 1;
			int iy = GameConf.gridH;
			
			// build structure
			struc.buildStructure(this, ix, iy);
			
			// build gap after structure
			int aw = struc.getWidth();
			generateEvenFloor(generatedUntil + 1 + aw, generatedUntil + aw + gap);
			
			this.generatedUntil += aw;
			
			for (int i = lastGeneratedUntil; i <= this.generatedUntil; i++) {
				if (this.bossRooms.containsKey(i)) {
					this.bossRooms.get(i).generate(this.generatedUntil);
				}
			}
		}
	}
	
}
