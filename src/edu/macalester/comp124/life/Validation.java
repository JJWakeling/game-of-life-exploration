package edu.macalester.comp124.life;

/**
 * validations, once constructed, expose a method for checking the validity of their ctor args
 */
public interface Validation {
	boolean valid() throws Exception;
}
