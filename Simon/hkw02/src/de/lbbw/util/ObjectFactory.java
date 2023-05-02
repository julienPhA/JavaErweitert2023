package de.lbbw.util;

public interface ObjectFactory {

	public Object create(String classname);
	public Object create(String classname, String type);
	
}
