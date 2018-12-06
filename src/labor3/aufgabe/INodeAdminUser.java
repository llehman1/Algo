package labor3.aufgabe;

/**
 * @author Lars Lehmann
 * @since 2018-11-22
 */
public interface INodeAdminUser extends INodeUser {
	/**
	 * the method return the next Node. if there is no other node, it returns null
	 * 
	 * @return Object from the interface INodeAdminUser
	 */
	public INodeAdminUser getNext();

	/**
	 * Set the next node to the new next(param: node ) node.
	 * 
	 * @param node:
	 *            the next node
	 */
	public void setNext(INodeAdminUser node);

}
