package Goldpoint;

import java.util.Scanner;

public class King {
    static person persons[];
    private static int SCORE_START=100;
    private static int SCORE_INCRE=20;


    public static void main(String[] args) throws InterruptedException {
//      System.out.println("***************************");
//      System.out.println("**********       ***********");
//      System.out.println("********* 黄金点游戏 *********");
//      System.out.println("**********       ***********");
//      System.out.println("***************************");

        System.out.println("游戏选项：");
        while (true) {
            System.err.println("1、开始游戏\n2、查看当前游戏结果\n3、游戏设置\n4、退出");
            Scanner scanner=new Scanner(System.in);
            int choice=scanner.nextInt();
            switch (choice) {
            case 1:
                welcome();
                break;
            case 2:
                showMessage();
                break;
            case 3:
                gameSetting();
                break;
            case 4:
                System.out.println("欢迎下次使用！程序即将退出！");
                Thread.currentThread().sleep(2000);
                System.exit(0);
                break;
            default:
                break;
            }
        }

    }

    private static void gameSetting() {
        // TODO Auto-generated method stub
        System.out.println("请输入玩家初试分数：");
        Scanner scanner=new Scanner(System.in);
        SCORE_START=scanner.nextInt();
        System.out.println("请输入玩家扣加分分数：");
        SCORE_INCRE=scanner.nextInt();
        System.out.println("设置完成");
    }

    /**
     * 输入游戏人数
     */
    private static void welcome() {
        // TODO Auto-generated method stub
//
//      System.out.println("****欢迎使用黄金点游戏！****");
        System.out.println("游戏默认初试玩家的分数为100");
        System.out.print("请输入游戏人数： ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        creatPlayer(n);
    }

    /**
     * 创建对象数组
     * 
     * @param n
     */
    private static void creatPlayer(int n) {
        // TODO Auto-generated method stub
        persons = new person[n];
        for (int i = 0; i < persons.length; i++) {
            persons[i] = new person();
        }
        for (int i = 0; i < n; i++) {
            Scanner scanner = new Scanner(System.in);
            int temp = 0;
            temp = i + 1;
            System.out.print("请输入第" + temp + "个玩家的姓名:");
            persons[i].setName(scanner.next());
            persons[i].setScore(SCORE_START);
        }
        System.out.println("****输入完成****");

        try {
            playGame();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * 输入数值开始游戏
     * 
     * @throws InterruptedException
     */
    private static void playGame() throws InterruptedException {
        // TODO Auto-generated method stub
        System.out.println("****游戏开始****");
        //Thread.currentThread().sleep(2000);
        for (int i = 0; i < persons.length; i++) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("请" + persons[i].getName() + "输入数值：");
            persons[i].setNum(scanner.nextInt());
        }

        // showMessage();
        // 获取G值
        int numG = getG();

        int recordMax = 0;
        int max = Math.abs(persons[0].getNum() - numG);
        for (int i = 0; i < persons.length; i++) {
            if (max < (Math.abs(persons[i].getNum() - numG))) {
                max = Math.abs(persons[i].getNum() - numG);
                recordMax = i;
            }
        }
        // System.out.println("i"+recordMax);

        int min = Math.abs(persons[0].getNum() - numG);
        int recordMin = 0;
        for (int i = 0; i < persons.length; i++) {
            if (min > Math.abs(persons[i].getNum() - numG)) {
                min = Math.abs(persons[i].getNum() - numG);
                recordMin = i;
            }
        }
        // System.out.println(recordMin);
        System.out.println("******************************");
        System.out.println("相信信息如下：");
        persons[recordMin].setScore(persons[recordMin].getScore()+SCORE_INCRE);
        persons[recordMax].setScore(persons[recordMax].getScore()-SCORE_INCRE);
        showMessage();
        System.out.println("G值为:" + numG);
        System.out.println("大吉大利，今晚吃鸡！" + persons[recordMin].getName());

        System.out.println("玩家：" + persons[recordMax].getName() + "输了");

        System.out.println("******************************");
    }

    private static int getG() {
        // TODO Auto-generated method stub
        int sum = 0;
        for (int i = 0; i < persons.length; i++) {
            sum += persons[i].getNum();
        }
        return (int) ((sum / persons.length) * 0.618);

    }

    private static void showMessage() {
        // TODO Auto-generated method stub
        System.out.println();
        //System.out.println("***************************");
        System.out.println("姓名" + "\t" + "输入的数"+"\t"+"成绩");
        for (int i = 0; i < persons.length; i++) {
            System.out.println(persons[i].getName() + "\t" + persons[i].getNum()+"\t"+persons[i].getScore());
        }
        //System.out.println("***************************");
        System.out.println();
    }

}