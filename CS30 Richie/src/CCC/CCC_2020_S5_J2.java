package CCC;
import java.util.*;
import java.io.*;
public class CCC_2020_S5_J2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int R = readInt(), C = readInt(), maxVal = (int)1e6;
		List<Integer> adj [] = new ArrayList[maxVal + 1];
		for(int i=1; i<adj.length; i++) adj[i] = new ArrayList<>();
		for(int i=1; i<=R; i++) {
			for(int j=1; j<=C; j++) 

				adj[i*j].add(readInt());
			
		}
		Queue<Integer> q = new LinkedList(); 
		boolean vis[] = new boolean[maxVal+1];
		q.add(1); vis[1] = true;
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int nxt : adj[cur]) {
				if(!vis[nxt]) { q.add(nxt); vis[nxt]=true; }
			}
			if(vis[R*C]) { System.out.println("yes"); return; }
		}
		System.out.println("no");
	}
	static String next () throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}
	static long readLong () throws IOException {
		return Long.parseLong(next());
	}
	static int readInt () throws IOException {
		return Integer.parseInt(next());
	}
	static double readDouble () throws IOException {
		return Double.parseDouble(next());
	}
	static char readCharacter () throws IOException {
		return next().charAt(0);
	}
	static String readLine () throws IOException {
		return br.readLine().trim();
	}
}
