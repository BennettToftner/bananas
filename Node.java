import java.util.ArrayList;

public class Node<T> {
	
	private T data;
	
	private ArrayList<Node<T>> children;
	
	private Node<T> parent;
	
	public Node(T data)
	{
		this.data = data;
		children = new ArrayList<Node<T>>();
		parent = null;
	}
	
	public T getData()
	{
		return data;
	}
	
	public boolean sameData(T otherData)
	{
		return data.equals(otherData);
	}
	
	public void setData(T newData)
	{
		data = newData;
	}
	
	public void addChild(Node<T> child)
	{
		child.setParent(this);
		children.add(child);
	}
	
	public void setParent(Node<T> mom)
	{
		parent = mom;
	}
	
	public boolean hasAncestor(Node<T> ancestor)
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
