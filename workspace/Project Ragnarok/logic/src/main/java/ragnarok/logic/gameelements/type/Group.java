package ragnarok.logic.gameelements.type;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import ragnarok.logic.gameelements.GameElementFactory;

/**
 * This annotation defines a group. If an abstract class has this annotation,
 * this class is expected to have a static method <b>{@code Set<? extends
 * GameElement> getPrototypes()}</b>
 *
 * @author Dominik Fuchss
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Group {
	/**
	 * Get the name of the group. If unset {@link GameElementFactory} will use
	 * the classes SimpleName.
	 *
	 * @return the name of the group
	 */
	String value() default "";
}