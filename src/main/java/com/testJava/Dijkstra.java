package com.testJava;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Dijkstra {
	static HashMap<String, Map<String, Integer>> graph = null;
	static HashMap<String, Integer> cost = null;
	static HashMap<String, String> parent = null;
	static ArrayList<String> processed = null;
	
	public Dijkstra() {
		graph = this.setGraph();
		cost = this.setCost();
		parent = this.setParent();
		processed = new ArrayList<String>();
		
		printMap("init");
	}
	
	public static void main(String[] args) {
		Dijkstra di = new Dijkstra();
		
		for (int i = 0; i < cost.keySet().size() - 1; i++) {
			String lowestNode = di.lowestCost(cost, processed); //cost중에 가장 null이 아니면서 가장 싼 요소를 찾는다.
			System.out.println("lowestNode: " + lowestNode);
			
			if (!processed.contains(lowestNode)) { 
				Map<String, Integer> inNode = graph.get(lowestNode);
				Integer weight = cost.get(lowestNode); // 현재 정점의 cost
				
				if (inNode != null) {
					for (String key : inNode.keySet()) {
						if (cost.get(key) == null) { // 해당 키로 cost Map에 null인게 있으면 값을 graph의 값을 넣어줌
							cost.put(key, graph.get(lowestNode).get(key) + weight);
							parent.put(key, lowestNode);
						} else {
							// inNode 안에 있는 것들 중에서 그 value가 cost내 현재 자신의 key 값을 더한 것보다 작으면 변환함
							Integer inNodeValue = inNode.get(key); // if Graph의 b의 a라고 하면
							Integer costValue = cost.get(key); // cost의 a값
							
							if (inNodeValue + weight < costValue) { // 현재 자신의 가중치와 전의 가중치를 더한 값이 cost의 값보다 작으면 변동!
								cost.put(key, inNodeValue + weight);
								parent.put(key, lowestNode);
							}
						}
					}
					processed.add(lowestNode);
				}				
			}
			printMap(lowestNode);
		}
				
		
	}
	
	public HashMap<String, Map<String, Integer>> setGraph() {
		HashMap<String, Map<String, Integer>> graph = new HashMap<String, Map<String, Integer>>();
		
		Map<String, Integer> start = new HashMap<String, Integer>();
		start.put("a", 6);
		start.put("b", 2);
		graph.put("start", start);
		
		Map<String, Integer> a = new HashMap<String, Integer>();
		a.put("fin", 1);
		graph.put("a", a);
		
		Map<String, Integer> b = new HashMap<String, Integer>();
		b.put("a", 3);
		b.put("fin", 5);
		graph.put("b", b);
		
		Map<String, Integer> fin = new HashMap<String, Integer>();
		graph.put("fin", fin);
		
		return graph;
	}

	public HashMap<String, Integer> setCost() {
		HashMap<String, Integer> cost = new HashMap<String, Integer>();
		cost.put("a", 6);
		cost.put("b", 2);
		cost.put("fin", null);
		
		return cost;
	}
	
	public HashMap<String, String> setParent() {
		HashMap<String, String> parent = new HashMap<String, String>();
		parent.put("a", "start");
		parent.put("b", "start");
		parent.put("fin", null);
		
		return parent;
	}

	public String lowestCost(Map<String, Integer> cost, ArrayList<String> processed) {
		String node = null;
		Integer containValue = null;
		
		for (String key : cost.keySet() ) {
			if (containValue == null) { // 만약 cost의 값이 널이면 실행
				node = key;
				containValue = cost.get(key);
				continue;
			}
			
			if (processed.contains(key)) {
				continue;
			}
			
			if (cost.get(key) != null) {
				Integer value = cost.get(key);

				if (value < containValue) {
					node = key;
					containValue = value;
				}
				
			}
			
		}
		
		return node;
	}

	public static void printMap(String msg) {
		System.out.println(msg + "(Graph)     --> " + graph);
		System.out.println(msg + "(Cost)      --> " + cost);
		System.out.println(msg + "(Parent)    -->" + parent);
		System.out.println(msg + "(processed) --> " + processed);
	}
}
