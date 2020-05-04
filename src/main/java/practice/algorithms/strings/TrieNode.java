package practice.algorithms.strings;

public class TrieNode {

	char character;

	TrieNode[] child = null;

	boolean isEndOfData = false;

	public TrieNode(int maxNode) {
		child = new TrieNode[maxNode];
	}

	public void insert(TrieNode root, char[] str, int index) {
		if(null == str)
			return ;

		TrieNode node = root.child[str[index]-'a'];
		if(null == root.child[str[index]-'a']){
			node = new TrieNode(TriMain.MAX_NODE);
			root.child[str[index]-'a'] = node; 
			node.character = str[index];
		}
		if(index == str.length -1){
			node.isEndOfData = true;
			return;
		}
		insert(node, str, ++index);
	}

	public boolean search(TrieNode root, char[] str, int index) {
		boolean result = false; 
		if(null == str)
			return false;

		if(index > str.length -1)
			return false;
		
		TrieNode node = root.child[str[index]-'a'];
		if(null == root.child[str[index]-'a']){
			return false;
		}
		if(node.character != str[index]){
			return false;
		}

		if(index == str.length -1 && node.isEndOfData == true){
			return true;
		}else{
			result = search(node, str, ++index);
		}

		return result;
	}

}
