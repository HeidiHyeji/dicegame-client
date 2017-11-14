package DiceView;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import DiceController.ClientController;
import main.ClientMain;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClientFrame extends JFrame {
	
	//ClientContller,ClientMain에서 쓰임! -> 같은 객체이여야함
	private static ClientFrame clientFrame = null;
	
	public static ClientFrame getInstance() {
		if (clientFrame == null) {
			clientFrame = new ClientFrame();
		}
		return clientFrame;
	}
	
	private JPanel contentPane;
	public JTextField serverIPTf;
	public JTextField serverPortTf;
	
	JLabel serverIPLb;
	JLabel serverPortLb;
	
	JButton connecBt;
	JButton quitBt;

	public ClientMain chat; //많이 쓰이는데 여기저기서 생성자 파라미터때문에 여기에 넣은듯
	
	public ClientFrame() {
		super("서버 연결");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 280, 638, 482);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//서버 IP주소
		serverIPLb = new JLabel("서버주소"); //라벨
		serverIPLb.setFont(new Font("굴림", Font.PLAIN, 22));
		serverIPLb.setBounds(104, 117, 118, 40);
		serverIPTf = new JTextField(); 		  //텍스트필드
		serverIPTf.setFont(new Font("굴림", Font.PLAIN, 22));
		serverIPTf.setBounds(239, 117, 252, 40);
		serverIPTf.setColumns(10);
		
		//서버 포트번호
		serverPortLb = new JLabel("포트번호"); 
		serverPortLb.setFont(new Font("굴림", Font.PLAIN, 22));
		serverPortLb.setBounds(104, 185, 118, 40);
		serverPortTf = new JTextField();
		serverPortTf.setFont(new Font("굴림", Font.PLAIN, 22));
		serverPortTf.setBounds(239, 185, 252, 40);
		serverPortTf.setColumns(10);
		
		//서버 연결만
		connecBt = new JButton("연결");
		connecBt.setBackground(Color.PINK);
		connecBt.setFont(new Font("굴림", Font.PLAIN, 22));
		connecBt.setBounds(153, 283, 125, 40);
		connecBt.addMouseListener(new ClientController());
		
		//창 닫힘
		quitBt = new JButton("종료");
		quitBt.setBackground(Color.PINK);
		quitBt.setFont(new Font("굴림", Font.PLAIN, 22));
		quitBt.setBounds(346, 283, 125, 40);
		quitBt.addMouseListener(new ClientController());	
		
		contentPane.add(serverIPLb);
		contentPane.add(serverIPTf);
		
		contentPane.add(serverPortLb);
		contentPane.add(serverPortTf);
		
		contentPane.add(connecBt);
		contentPane.add(quitBt);
	}
}
