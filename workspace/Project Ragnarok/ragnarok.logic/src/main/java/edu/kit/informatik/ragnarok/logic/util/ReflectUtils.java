package edu.kit.informatik.ragnarok.logic.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.Set;

import org.reflections.Reflections;

public class ReflectUtils {
	@SuppressWarnings("unchecked")
	public static final <T> Set<T> get(String searchPath, Class<T> type) {
		Set<Class<? extends T>> classes = new Reflections(searchPath).getSubTypesOf(type);
		Set<T> objects = new HashSet<>();
		for (Class<?> clazz : classes) {
			if (Modifier.isAbstract(clazz.getModifiers())) {
				continue;
			}
			try {
				Constructor<?> c = clazz.getDeclaredConstructor();
				c.setAccessible(true);
				objects.add((T) c.newInstance());
			} catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
				System.err.println(clazz.getSimpleName() + " not loaded !");
			}
		}
		return objects;

	}
}
