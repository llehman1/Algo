package labor3.vorbereitung;

/**
 * 
 * @author larslehmann
 * @since 2018-11-22
 */
public interface INodeAdminUser extends INodeUser {
	/**
	 * the method return the next Node. if there is no other node, it returns null
	 * 
	 * @return Object from the interface INodeAdminUser
	 */
	public INodeAdminUser getNext();

}
