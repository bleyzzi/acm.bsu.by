import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;


class Node {
	public long key; 
	public Node left;
	public Node right;
	public int height = 0;  
	
	Node(long a)
	{
		key = a;
	}
}

class Tree {
	public Node root;
	
	Tree(){}
	
	Tree(Node a)
	{
		root = a;
	}

	public void insert(long val)
	{
		Node pv = root;
		Node prev = null;
		while (pv != null)
		{
			prev = pv;
			if (val < pv.key)
				pv = pv.left;
			else 
			{
				if (val > pv.key)
					pv = pv.right;
				else
					return;
			}
		}
		
		Node pnew = new Node(val);
		if (prev == null)
			root = pnew;
		else
		{
			pnew.height = prev.height + 1;
			if (val < prev.key)
				prev.left = pnew;
			else
				prev.right = pnew;
		}
	}
	public void print(PrintStream out)
	{
		Node p = root;
		doPrint(p, out);
	}
	public void doPrint(Node p, PrintStream out)
	{
		if (p != null)
		{
			out.println(p.key);
			doPrint(p.left, out);
			doPrint(p.right, out);
		}
	}
	
}

public class Main {
	
	public static void main(String[] args) throws FileNotFoundException {
		
			Scanner in = new Scanner(new FileInputStream("input.txt"));
			PrintStream out = new PrintStream(new FileOutputStream("output.txt"));
			
			Tree T = new Tree();
			
			while (in.hasNextLine())
			{
					T.insert(Long.parseLong(in.nextLine()));
			}
			T.print(out);
			
			in.close();
			out.close();
			System.exit(0);
		}
}
