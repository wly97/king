package Goldpoint;

public class person {
	private String name;
    private int num;
    private int score;

     public person() {
        // TODO Auto-generated constructor stub
         super();
    }
    public person(String tname,int tnum,int tscore) {
        // TODO Auto-generated constructor stub
        super();
        name=tname;
        num=tnum;
        score=tscore;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }


}
