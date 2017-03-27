package practice.algorithms.strings;

public class TriMain {
	final static  int MAX_NODE = 26;
	public static void main(String[] args) {
		 
		TrieNode root = new TrieNode(MAX_NODE);
		char[] str = new char[]{'b','a','l','l'};
		char[] str1 = new char[]{'b','a','l','l','s'};
		char[] str2 = new char[]{'b','a','l','l'};
		char[] str3 = new char[]{'b','a','l'};
		char[] str4 = new char[]{'b','e','l','l'};
		char[] str5 = new char[]{'b','a','l','l','o','n'};
		char[] str6= new char[]{'z','o','o'};
		
		root.insert(root,str,0);
		root.insert(root,str1,0);
		root.insert(root,str2,0);
		root.insert(root,str3,0);
		root.insert(root,str4,0);
		root.insert(root,str5,0);
		root.insert(root,str6,0);
		
		System.out.println(new String(str).toString() + " --> Found " + root.search(root,str,0));
		System.out.println(new String(str1).toString() + " --> Found " + root.search(root,str1,0));
		System.out.println(new String(str2).toString() + " --> Found " + root.search(root,str2,0));
		System.out.println(new String(str3).toString() + " --> Found " + root.search(root,str3,0));
		System.out.println(new String(str4).toString() + " --> Found " + root.search(root,str4,0));
		System.out.println(new String(str5).toString() + " --> Found " + root.search(root,str5,0));
		System.out.println(new String(str6).toString() + " --> Found " + root.search(root,str6,0));
		System.out.println(new String(new char[]{'z','a','o'}).toString() + " --> Found " + root.search(root,new char[]{'z','a','o'},0));
		System.out.println(new String(new char[]{'b','a','o'}).toString() + " --> Found " + root.search(root,new char[]{'b','a','o'},0));
		System.out.println(new String(new char[]{'b','a'}).toString() + " --> Found " + root.search(root,new char[]{'b','a'},0));
		
	}
}
