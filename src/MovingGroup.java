

/**
 * MovingGroup helped me to generalize between singular objects and groups of
 * objects.
 * 
 * @author Tian Low ttl2132
 *
 */
public interface MovingGroup extends MovingObject {
	/**
	 * Adds the Moving Object to the ArrayList in the subclass instance.
	 * 
	 * @param myObj
	 *            the moving object to be added
	 */
	public void add(MovingObject myObj);
}
