package jevTree.model;

import java.util.List;

public interface IJevTreeNode {
	IJevTreeNode clone();
	String getName();
	void setName(String value);
    boolean isEditable();
    boolean getAllowsChildren();
    boolean hasChildren();
    List<IJevTreeNode> getChildren();
    void addChild(IJevTreeNode child);
    void removeChild(IJevTreeNode child);
    boolean isSerializable();
    Class getChildrenClass();
    @Override
	String toString();
}