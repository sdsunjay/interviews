public interface FirstCommonAncestor {
 
    /**
     * Given two nodes of a tree,
     * method should return the deepest common ancestor of those nodes.
     *
     *          A
     *         / \
     *        B   C
     *       / \
     *      D   E
     *         / \
     *        G   F
     *
     *  commonAncestor(D, F) = B
     *  commonAncestor(C, G) = A
     *  commonAncestor(E, B) = B
     */

	/*
	 *  commonAncestor(3,6) = 1
	 *          0
	 *         / \
	 *        1   2
	 *       / \
	 *      3   4
	 *         / \
	 *        5  6
	 */
	Node commonAncestor(Node one, Node two);
}
