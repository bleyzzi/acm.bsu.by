import java.io.*;
 import java.util.*;
 public class Node { private Integer value; private Node left; private Node right; Node(int value){ this.left = null; this.right = null; this.value = value; } public Node Insert( Node tree, int value){ if( tree == null){ return new Node(value); } if(tree.value.compareTo(value) == 1){ tree.left = Insert(tree.left,value); } if(tree.value.compareTo(value) == -1){ tree.right = Insert(tree.right,value); } return tree; } void Print(PrintWriter out){ out.println(this.value); } public void DirectLeft(PrintWriter out){ Print(out); if (left!=null) left.DirectLeft(out); if (right!=null) right.DirectLeft(out); } public static void main(String [] args)throws IOException{ BufferedReader br = new BufferedReader(new FileReader("input.txt")); PrintWriter out = new PrintWriter(new FileWriter("output.txt")); String line; List<Integer> list = new ArrayList<>(); while ((line = br.readLine()) != null) { list.add(Integer.parseInt(line)); } Iterator<Integer> it = list.iterator(); Node tree = new Node(it.next()); while(it.hasNext()){ tree = tree.Insert(tree,it.next()); } tree.DirectLeft(out); out.flush(); } }