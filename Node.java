import java.util.ArrayList;
import java.util.Arrays;

public class Node {
	
	private int[] data;
	
	private ArrayList<Node> children;
	
	private Node parent;
	
	public Node(int[] data)
	{
		this.data = data;
		children = new ArrayList<Node>();
		parent = null;
	}
	
	public int[] getData()
	{
		return data;
	}
	
	public boolean sameData(int[] otherData)
	{
		return Arrays.equals(this.getData(), otherData);
	}
	
	public void setData(int[] newData)
	{
		data = newData;
	}
	
	public void addChild(Node child)
	{
		child.setParent(this);
		children.add(child);
	}
	
	public void setParent(Node mom)
	{
		parent = mom;
	}
	
	public boolean hasAncestor(Node ancestor)
	{
		if (parent != null && parent.sameData(ancestor.getData()))
		{
			return true;
		}
		else if (parent != null)
		{
			return parent.hasAncestor(ancestor);
		}
		else
		{
			return false;
		}
	}
	
	public String printBloodline()
	{
		if (parent == null)
		{
			return data[0] + " " + data[1] + "\n";
		}
		return parent.printBloodline() + data[0] + " " + data[1] + "\n";
	}
	
	public String toString()
	{
		String result = "";
		result += data + "\n";
		for (int i = 0; i < children.size(); i++)
		{
			result += children.get(i);
		}
		return result;
	}
	
}
