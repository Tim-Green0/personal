package com.testJava;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	public static void main(String[] args) {
		BFS test = new BFS();
		HashMap<String, ArrayList<String>> map = test.returnMap();
		Queue<String> queue = new LinkedList<>();

		for (int i = 0; i < map.get("you").size(); i++) {
			queue.add(map.get("you").get(i));
		}

		test.check(map, queue);
		

	}

	public HashMap<String, ArrayList<String>> returnMap() {
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

		ArrayList<String> arri = new ArrayList<String>();
		arri.add("alice");
		arri.add("bob");
		arri.add("claire");
		map.put("you", arri);

		ArrayList<String> arri1 = new ArrayList<String>();
		arri1.add("anuj");
		arri1.add("peggy");
		map.put("bob", arri1);

		ArrayList<String> arri2 = new ArrayList<String>();
		arri2.add("peggy");
		map.put("alice", arri2);

		ArrayList<String> arri3 = new ArrayList<String>();
		arri3.add("thom");
		arri3.add("jonny");
		map.put("claire", arri3);

		ArrayList<String> arri4 = new ArrayList<String>();
		map.put("anuj", arri4);

		ArrayList<String> arri5 = new ArrayList<String>();
		map.put("peggy", arri5);

		ArrayList<String> arri6 = new ArrayList<String>();
		map.put("thom", arri6);

		ArrayList<String> arri7 = new ArrayList<String>();
		map.put("jonny", arri7);

		return map;
	}

	public void check(HashMap<String, ArrayList<String>> map, Queue<String> queue) {
		ArrayList<String> searched = new ArrayList<String>();

		while (queue.size() != 0) {
			String name = queue.poll();
			Boolean startFlag = true;
			Boolean flag = false;

			for (int i = 0; i < searched.size(); i++) {
				if (searched.get(i).equals(name)) {
					// 전에 검색했었던 이름이면 더 이상 실행 안함.
					startFlag = false;
					break;
				}
			}
			
			if (startFlag) {
				if (name.charAt(name.length() - 1) == 'm') {
					// 이름의 마지막에 m 들어가면 찾은 거임.
					flag = true;
				}
				
				if (flag) {
					System.out.println("found: " + name);
					System.out.println(queue);
					System.out.println(searched);
				} else {
					ArrayList<String> arri = map.get(name);
					if (arri.size() != 0) {
						for (int j = 0; j < arri.size(); j++) {
							queue.add(arri.get(j));
						}
					}
					searched.add(name);
				}				
			}
		}
	}
}
