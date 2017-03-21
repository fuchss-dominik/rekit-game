package rekit.logic.level.parser;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import rekit.logic.level.Level;
import rekit.logic.level.Structure;
import rekit.logic.level.StructureManager;
import rekit.logic.level.parser.token.Token;
import rekit.logic.level.parser.token.TokenType;
import rekit.logic.level.parser.token.Tokenizer;
import rekit.logic.level.parser.token.UnexpectedTokenException;

/**
 * This class shall be implemented from all classes which want to parse a
 * {@link Level} to a {@link StructureManager}.
 *
 * @author Dominik Fuchss
 *
 */
public final class LevelParser {
	/**
	 * Parse a level.
	 *
	 * @param input
	 *            the definitions
	 * @param manager
	 *            the manager of structure
	 */
	public static final void parseLevel(String input, StructureManager manager) {
		new LevelParser(input).parse(manager);
	}

	/**
	 * The original string.
	 */
	private final String input;

	/**
	 * The tokenizer.
	 */
	private Tokenizer tokenizer;
	/**
	 * The look ahead Token.
	 */
	private Token lookAhead;

	/**
	 * Instantiate the parser by the input string.
	 *
	 * @param input
	 *            the input string
	 */
	private LevelParser(String input) {
		if (input == null) {
			throw new IllegalArgumentException("Input for LevelParser cannot be null");
		}
		this.input = "" + input;
		this.tokenizer = new Tokenizer(this.input);
	}

	/**
	 * Parse the level to the {@link StructureManager}.
	 *
	 * @param manager
	 *            the structure manager
	 */
	public void parse(StructureManager manager) {
		if (manager == null) {
			throw new IllegalArgumentException("manager cannot be null");
		}
		this.lookAhead = this.tokenizer.nextToken();
		this.parseStructure(manager);
		this.readToken(TokenType.EOS);
		this.reset();
	}

	/**
	 * Parse a {@link Structure}.
	 *
	 * @param manager
	 *            the manager
	 */
	private void parseStructure(StructureManager manager) {
		if (this.isToken(TokenType.ALIAS)) {
			this.parseAlias(manager);
		}
		if (this.isToken(TokenType.SETTING)) {
			this.parseSetting(manager);
		}
		if (this.isToken(TokenType.BOSS_SETTING)) {
			this.parseBossSetting(manager);
		}
		if (this.isToken(TokenType.BEGIN)) {
			this.parseLevel(manager);
		}
		if (this.isToken(TokenType.ALIAS, TokenType.SETTING, TokenType.BOSS_SETTING, TokenType.BEGIN)) {
			this.parseStructure(manager);
		}
	}

	/**
	 * Parse a {@link Level}.
	 *
	 * @param manager
	 *            the manager
	 */
	private void parseLevel(StructureManager manager) {
		this.readToken(TokenType.BEGIN);
		List<String[]> lines = new LinkedList<>();
		while (this.isToken(TokenType.BEGIN)) {
			this.readLevelLine(lines);
		}
		this.readToken(TokenType.END);
		Structure s = new Structure(lines, manager.getAlias());
		manager.addStructure(s);
	}

	/**
	 * Read / Parse level lines.
	 *
	 * @param lines
	 *            the lines
	 */
	private void readLevelLine(List<String[]> lines) {
		this.readToken(TokenType.BEGIN);

		List<String> line = new ArrayList<>();

		while (!this.isToken(TokenType.END)) {
			line.add(this.readToken(TokenType.RAW).getValue());
		}
		this.readToken(TokenType.END);
		String[] res = new String[line.size()];
		line.toArray(res);
		lines.add(res);
	}

	/**
	 * Parse an alias.
	 *
	 * @param manager
	 *            the manager
	 */
	private void parseAlias(StructureManager manager) {
		this.readToken(TokenType.ALIAS);
		this.readToken(TokenType.DELIMITER);
		String[] mapping = this.parseMapping();
		manager.setAlias(mapping[0], mapping[1]);
	}

	/**
	 * Parse a setting.
	 *
	 * @param manager
	 *            the manager
	 */
	private void parseSetting(StructureManager manager) {
		this.readToken(TokenType.SETTING);
		this.readToken(TokenType.DELIMITER);
		String[] mapping = this.parseMapping();
		manager.setSetting(mapping[0], mapping[1]);
	}

	/**
	 * Parse an boss setting.
	 *
	 * @param manager
	 *            the manager
	 */
	private void parseBossSetting(StructureManager manager) {
		this.readToken(TokenType.BOSS_SETTING);
		this.readToken(TokenType.DELIMITER);
		String[] mapping = this.parseMapping();
		manager.bossSettings.setSetting(mapping[0], mapping[1]);
	}

	/**
	 * Parse a mapping.
	 *
	 * @return String[0] -> String[1]
	 */
	private String[] parseMapping() {
		return this.readToken(TokenType.MAPPING).getValue().split("->");
	}

	/**
	 * Reset parser.
	 */
	private void reset() {
		this.tokenizer = new Tokenizer(this.input);
		this.lookAhead = null;
	}

	/**
	 * Checks if is token of one of the types.
	 *
	 * @param types
	 *            the types
	 * @return true, if is token
	 */
	private boolean isToken(TokenType... types) {
		TokenType type = this.lookAhead.getType();
		for (TokenType t : types) {
			if (type == t) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Read token.
	 *
	 * @param type
	 *            the type
	 * @return the token
	 */
	private Token readToken(TokenType type) {
		if (!this.isToken(type)) {
			throw new UnexpectedTokenException(this.lookAhead, type);
		}
		Token token = this.lookAhead;
		this.lookAhead = this.tokenizer.nextToken();
		return token;

	}

}