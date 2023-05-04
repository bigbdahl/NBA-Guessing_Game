package application;

public class Player {
	String name;
	String conf;
	String div;
	String team;
	int num;
	int ht;
	int wt;
	String pos;
	int relevancy;

	public Player() {
		name = "?";
		conf = "?";
		div = "?";
		team = "?";
		num = -1;
		ht = -1;
		wt = -1;
		pos = "?";
		relevancy = -1;
	}

	public Player(String z, String a, String b, String c, int d, int e, int f, String g, int h) {
		name = z; // name
		conf = a; // conference
		div = b; // division
		team = c; // team
		num = d; // number
		ht = e; // height
		wt = f; // weight
		pos = g; // position
		relevancy = h; // 0 means not relevant, 1 means relevant
	}

	public String getName() {
		return name;
	}

	public String getConf() {
		return conf;
	}

	public String getDiv() {
		return div;
	}

	public String getTeam() {
		return team;
	}

	public int getNum() {
		return num;
	}

	public int getHt() {
		return ht;
	}

	public int getWt() {
		return wt;
	}

	public String getPos() {
		return pos;
	}

	public int getRelevancy() {
		return relevancy;
	}

	public String toString() {
		return name + " " + conf + " " + div + " " + team + " " + num + " " + ht + " " + wt + " " + pos;
	}

}
