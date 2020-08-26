package boj_19236;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ19236_청소년상어 {
	final static int MAX = 4;
	static int[][] arr = new int[MAX][MAX];
	static FISH[] fish = new FISH[MAX * MAX + 1];
	static FISH shark;
	
	static int[] Y = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] X = {0, -1, -1, -1, 0, 1, 1, 1};
	
	static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		result = 0;
		
		for(int y = 0; y<MAX; y++) {
			st = new StringTokenizer(in.readLine());
			for(int x = 0; x< MAX; x++) {
				int num = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				
				fish[num] = new FISH(y, x, dir - 1, true);
				arr[y][x] = num;
			}
		}
		
		// ��� ��ġ
		int num = arr[0][0];
		shark = new FISH(0, 0, fish[num].dir, true);
		fish[num].live = false;
		arr[0][0] = -1;
		
		moveShark(shark, num);
		
		System.out.println(result);
	}
	
	public static void print() {
		for(int y = 0; y<MAX; y++) {
			for(int x = 0; x< MAX; x++) {
				System.out.print(arr[y][x] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
		for(int i = 1; i<=16; i++) {
			System.out.println(i+ "��° ����� - y:" + fish[i].y + ", x:" + fish[i].x + ", dir:" + fish[i].dir + ", live:" + fish[i].live);
		}
	}
	
	public static void moveShark(FISH now, int sum) {
		//print();
		int[][] temp = new int[MAX][MAX];
		copyArr(temp, arr);
		FISH[] fishTemp = new FISH[MAX *MAX + 1];
		for(int i = 1; i<= MAX*MAX; i++) {
			fishTemp[i] = new FISH(fish[i].y, fish[i].x, fish[i].dir, fish[i].live);
		}
		moveFish();
				
		if(sum > result)
			result = sum;
		for(int i = 1; i<= 3; i++) {
			FISH next = new FISH();
			next.y = now.y + Y[now.dir] * i;
			next.x = now.x + X[now.dir] * i;
			next.live = true;
			next.dir = now.dir;
			
			if(next.y<0 || next.x <0 || next.x >= MAX || next.y >=MAX)
				continue;
			if(arr[next.y][next.x] == 0)
				continue;
			
			int num = arr[next.y][next.x];
			next.dir = fish[num].dir;
			fish[num].live = false;
			arr[next.y][next.x] = -1;
			arr[now.y][now.x]= 0; 
			
			moveShark(next, sum + num);
			
			arr[next.y][next.x] = num;
			arr[now.y][now.x]= -1; 
			fish[num].live = true;
		}
		copyArr(arr, temp);
		for(int i = 1; i<= MAX*MAX; i++) {
			fish[i].y = fishTemp[i].y;
			fish[i].x = fishTemp[i].x;
			fish[i].dir = fishTemp[i].dir;
			fish[i].live = fishTemp[i].live;
		}

	}
	
	public static void copyArr(int[][] copy, int[][] origin) {
		for(int y = 0; y<MAX; y++) {
			for(int x = 0; x< MAX; x++) {
				copy[y][x] = origin[y][x];
			}
		}
	}
	public static void moveFish() {
		for(int i = 1; i<=MAX*MAX; i++) {
			if(!fish[i].live)
				continue;
			
			FISH now = fish[i];
			for(int j = 0; j<8; j++) {
				int dir = (fish[i].dir + j) % 8;
				
				FISH next = new FISH();
				
				next.y = now.y + Y[dir];
				next.x = now.x + X[dir];
				next.dir = dir;
				next.live = true;
				
				if(next.y<0 || next.x <0 || next.x >= MAX || next.y >=MAX)
					continue;
				if(arr[next.y][next.x] == -1)
					continue;
				
				if(arr[next.y][next.x] != 0) {
					int num = arr[next.y][next.x];
					fish[num].y = now.y;
					fish[num].x = now.x;
					arr[now.y][now.x] = num;
				} else {
					arr[now.y][now.x] = 0; 
				}
				arr[next.y][next.x] = i;
				fish[i] = next;
				//System.out.println(i + "��°");
				//print();
				break;
			}
		}
		
	}
	
	static class FISH {
		int y, x;
		int dir;
		boolean live;
		
		public FISH() {
		}
		public FISH(int y, int x, int dir, boolean live) {
			this.y = y;
			this.x = x;
			this.dir = dir;
			this.live = live;
		}
		
	}
}
