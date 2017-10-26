package Goldpoint;

import java.util.Scanner;

public class King {
    static person persons[];
    private static int SCORE_START=100;
    private static int SCORE_INCRE=20;


    public static void main(String[] args) throws InterruptedException {
//      System.out.println("***************************");
//      System.out.println("**********       ***********");
//      System.out.println("********* �ƽ����Ϸ *********");
//      System.out.println("**********       ***********");
//      System.out.println("***************************");

        System.out.println("��Ϸѡ�");
        while (true) {
            System.err.println("1����ʼ��Ϸ\n2���鿴��ǰ��Ϸ���\n3����Ϸ����\n4���˳�");
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
                System.out.println("��ӭ�´�ʹ�ã����򼴽��˳���");
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
        System.out.println("��������ҳ��Է�����");
        Scanner scanner=new Scanner(System.in);
        SCORE_START=scanner.nextInt();
        System.out.println("��������ҿۼӷַ�����");
        SCORE_INCRE=scanner.nextInt();
        System.out.println("�������");
    }

    /**
     * ������Ϸ����
     */
    private static void welcome() {
        // TODO Auto-generated method stub
//
//      System.out.println("****��ӭʹ�ûƽ����Ϸ��****");
        System.out.println("��ϷĬ�ϳ�����ҵķ���Ϊ100");
        System.out.print("��������Ϸ������ ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        creatPlayer(n);
    }

    /**
     * ������������
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
            System.out.print("�������" + temp + "����ҵ�����:");
            persons[i].setName(scanner.next());
            persons[i].setScore(SCORE_START);
        }
        System.out.println("****�������****");

        try {
            playGame();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * ������ֵ��ʼ��Ϸ
     * 
     * @throws InterruptedException
     */
    private static void playGame() throws InterruptedException {
        // TODO Auto-generated method stub
        System.out.println("****��Ϸ��ʼ****");
        //Thread.currentThread().sleep(2000);
        for (int i = 0; i < persons.length; i++) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("��" + persons[i].getName() + "������ֵ��");
            persons[i].setNum(scanner.nextInt());
        }

        // showMessage();
        // ��ȡGֵ
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
        System.out.println("������Ϣ���£�");
        persons[recordMin].setScore(persons[recordMin].getScore()+SCORE_INCRE);
        persons[recordMax].setScore(persons[recordMax].getScore()-SCORE_INCRE);
        showMessage();
        System.out.println("GֵΪ:" + numG);
        System.out.println("�󼪴���������Լ���" + persons[recordMin].getName());

        System.out.println("��ң�" + persons[recordMax].getName() + "����");

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
        System.out.println("����" + "\t" + "�������"+"\t"+"�ɼ�");
        for (int i = 0; i < persons.length; i++) {
            System.out.println(persons[i].getName() + "\t" + persons[i].getNum()+"\t"+persons[i].getScore());
        }
        //System.out.println("***************************");
        System.out.println();
    }

}