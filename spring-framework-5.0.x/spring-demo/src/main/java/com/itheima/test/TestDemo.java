package com.itheima.test;

public class TestDemo {
	static Node nodeFirst , nodeSecond, nodeThree,nodefour, nodeFive;

	static {
		nodeFirst = new Node();
		nodeFirst.setBefore(null);
		nodeFirst.setCount(1);
		nodeSecond = new Node();
		nodeFirst.setAfter(nodeSecond);
		nodeSecond.setBefore(nodeFirst);
		nodeSecond.setCount(2);
		nodeThree = new Node();
		nodeSecond.setAfter(nodeThree);
		nodeThree.setBefore(nodeSecond);
		nodeThree.setCount(3);
		nodefour = new Node();
		nodeThree.setAfter(nodefour);
		nodefour.setBefore(nodeThree);
		nodefour.setCount(4);
		nodeFive = new Node();
		nodefour.setAfter(nodeFive);
		nodeFive.setBefore(nodefour);
		nodeFive.setCount(5);
	}

	public static void main(String[] args) {

		foreach(nodeThree);

		System.out.println("======================================");
		swapNode(nodeSecond,nodefour);

		foreach(nodeThree);

		System.out.println("======================================");
		swapNode(nodeFirst,nodeFive);

		foreach(nodeThree);

	}

	private static void swapNode(Node swapNodeBefore, Node swapNodeAfter) {
		Node findNode = swapNodeAfter;
		while (true){
			if (findNode.getCount() == swapNodeBefore.getCount()){
				swap(swapNodeBefore, swapNodeAfter);
				break;
			}
			findNode = findNode.getBefore();
			if (findNode == null){
				break;
			}
		}
	}

	// 修改了两个需要交换的值, 所以需要改四个引用 , 双向链表修改位置,需要改八个引用
	private static void swap(Node swapNodeBefore, Node swapNodeAfter) {
		swapBefore(swapNodeBefore,swapNodeAfter);
		swapAfter(swapNodeBefore,swapNodeAfter);
	}

	private static void swapAfter(Node swapNodeBefore, Node swapNodeAfter) {
		Node swapNodeBeforeAfter = swapNodeBefore.getAfter();
		Node swapNodeAfterAfter = swapNodeAfter.getAfter();

		// 修改需要交换的两个值
		Node tempSwapNodeBeforeAfter = swapNodeBefore.getAfter();
		swapNodeBefore.setAfter(swapNodeAfter.getAfter());
		swapNodeAfter.setAfter(tempSwapNodeBeforeAfter);

		// 修改两个之前对应的值
		if (swapNodeBeforeAfter != null){
			swapNodeBeforeAfter.setBefore(swapNodeAfter);
		}
		if (swapNodeAfterAfter != null){
			swapNodeAfterAfter.setBefore(swapNodeBefore);
		}
	}

	private static void swapBefore(Node swapNodeBefore, Node swapNodeAfter) {
		Node swapNodeBeforeBefore = swapNodeBefore.getBefore();
		Node swapNodeAfterBefore = swapNodeAfter.getBefore();

		// 修改需要交换的两个值
		Node tempSwapNodeBeforeBefore = swapNodeBefore.getBefore();
		swapNodeBefore.setBefore(swapNodeAfter.getBefore());
		swapNodeAfter.setBefore(tempSwapNodeBeforeBefore);

		// 修改两个之前对应的值
		if (swapNodeBeforeBefore != null){
			swapNodeBeforeBefore.setAfter(swapNodeAfter);
		}
		if (swapNodeAfterBefore != null){
			swapNodeAfterBefore.setAfter(swapNodeBefore);
		}


	}

	private static void foreach(Node node){
		if (node.getBefore() == null){
			foreachHead(node);
		}else {
			Node nodeHead = findHead(node);
			foreachHead(nodeHead);
		}

	}

	private static Node findHead(Node node) {
		while (node.getBefore() != null){
			node = node.getBefore();
		}
		return node;
	}

	private static void foreachHead(Node node) {
		do {
			System.out.println(node.getCount());
			node = node.getAfter();
		}
		while (node != null);
	}

	static class Node{

		public Node getAfter() {
			return after;
		}

		public void setAfter(Node after) {
			this.after = after;
		}

		public Node getBefore() {
			return before;
		}

		public void setBefore(Node before) {
			this.before = before;
		}

		public int getCount() {
			return count;
		}

		public void setCount(int count) {
			this.count = count;
		}

		Node after;
		Node before;
		int count;
	}
}
