package DiceView;

import DiceController.GameControl;
//import client.ClientState;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;


import javax.swing.JButton;

public class GameFrame extends JFrame {
	
	//GameController, MainController에서 씀 -> 같은 객체여야함
	private static  GameFrame gameFrame = null;

	public static  GameFrame getInstance() {
		if (gameFrame == null) {
			gameFrame = new  GameFrame();
		}
		return gameFrame;
	}
	
	//private ClientState chatClient = null;
	
	public JPanel gamePane;

	public JLabel nameLb;
	public JLabel scoreLb;
	public JLabel turnLb;
	public JLabel die1Lb;
	public JLabel die2Lb;

	public JButton rollBt;
	public JButton cancelBt;

	//
	public void GameFrameReset() {
		scoreLb.setText("점수 : " + 0);
		turnLb.setText("횟수 : " + 0);
		die1Lb.setText("주사위1 : " + 0);
		die2Lb.setText("주사위2 : " + 0);
	}

	// 생성자
	public GameFrame() {

		setTitle("게임 시작!");
		setBounds(400, 280, 640, 400);

		gamePane = new JPanel();
		gamePane.setBackground(Color.WHITE);
		gamePane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(gamePane);
		gamePane.setLayout(null);

		// 라벨
		nameLb = new JLabel("이름 : " + ClientFrame.getInstance().chat.getClient().getUserID());
		nameLb.setBounds(64, 66, 200, 40);
		nameLb.setFont(new Font("나눔고딕", Font.PLAIN, 22));

		scoreLb = new JLabel("점수 : " + 0);
		scoreLb.setBounds(281, 66, 130, 40);
		scoreLb.setFont(new Font("나눔고딕", Font.PLAIN, 22));

		turnLb = new JLabel("횟수 : " + 0);
		turnLb.setBackground(Color.WHITE);
		turnLb.setBounds(467, 66, 120, 40);
		turnLb.setFont(new Font("나눔고딕", Font.PLAIN, 22));

		die1Lb = new JLabel("주사위1 : " +0);
		die1Lb.setForeground(Color.BLUE);
		die1Lb.setFont(new Font("나눔고딕", Font.PLAIN, 20));
		die1Lb.setBounds(168, 149, 120, 40);

		die2Lb = new JLabel("주사위2 : " + 0);
		die2Lb.setForeground(Color.BLUE);
		die2Lb.setFont(new Font("나눔고딕", Font.PLAIN, 20));
		die2Lb.setBounds(363, 149, 130, 40);

		// 버튼
		rollBt = new JButton("굴리기");
		rollBt.setBackground(Color.WHITE);
		rollBt.setFont(new Font("나눔고딕", Font.PLAIN, 22));
		rollBt.setBounds(146, 239, 125, 35);
		rollBt.addMouseListener(new GameControl());

		cancelBt = new JButton("나가기");
		cancelBt.setBackground(Color.WHITE);
		cancelBt.setFont(new Font("나눔고딕", Font.PLAIN, 22));
		cancelBt.setBounds(350, 239, 125, 35);
		cancelBt.addMouseListener(new GameControl());

		gamePane.add(nameLb);
		gamePane.add(scoreLb);
		gamePane.add(turnLb);
		gamePane.add(die1Lb);
		gamePane.add(die2Lb);
		gamePane.add(rollBt);
		gamePane.add(cancelBt);
	}


}
