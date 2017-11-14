package DiceView;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DiceController.MainController;
import main.ClientMain;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;

import javax.swing.ImageIcon;
import java.awt.Font;

public class MainFrame extends JFrame {

	
	private JPanel mainPane;
	//public ClientMain chat;
	JLabel diceIcon;
	
	JButton startBt;
	JButton scoreBt;
	JButton quitBt;
	public ClientMain chat;
	public MainFrame() {
		setTitle("FUSE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //프로그램 종료
		setBounds(300, 100, 800, 550);
		
		mainPane = new JPanel();
		mainPane.setBackground(Color.WHITE);
		mainPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPane);
		mainPane.setLayout(null);		
		
		diceIcon = new JLabel(""); //주사위 사진
		diceIcon.setForeground(Color.BLACK);
		diceIcon.setIcon(new ImageIcon(MainFrame.class.getResource("/DiceView/dice.jpg")));
		diceIcon.setBackground(Color.WHITE);
		diceIcon.setBounds(97, 33, 533, 291);
		
			
		startBt = new JButton("게임시작");
		startBt.setFont(new Font("나눔고딕", Font.PLAIN, 22));
		startBt.setForeground(Color.BLACK);
		startBt.setBackground(Color.WHITE);
		startBt.setBounds(97, 387, 125, 40);
		startBt.addMouseListener(new MainController());
			
		scoreBt = new JButton("최고점수");
		scoreBt.setForeground(Color.BLACK);
		scoreBt.setBackground(Color.WHITE);
		scoreBt.setFont(new Font("나눔고딕", Font.PLAIN, 22));
		scoreBt.setBounds(313, 387, 155, 40);
		scoreBt.addMouseListener(new MainController());
			
		quitBt  = new JButton("로그아웃");
		quitBt.setForeground(Color.BLACK);
		quitBt.setBackground(Color.WHITE);
		quitBt.setFont(new Font("나눔고딕", Font.PLAIN, 22));
		quitBt.setBounds(539, 387, 125, 40);
		quitBt.addMouseListener(new MainController());
		
		mainPane.add(diceIcon);
		mainPane.add(scoreBt);
		mainPane.add(startBt);
		mainPane.add(quitBt);	
	}
}
