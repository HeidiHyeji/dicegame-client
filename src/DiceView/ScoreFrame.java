package DiceView;

import java.awt.*;
import javax.swing.*;

//메인프레임->버튼->리스너->클릭하면실행
public class ScoreFrame extends JFrame {
	

	public JTextArea list;
	JPanel scorePane; //컨테이너
	JScrollPane scrollPane;
	//String listmember;
	
	public ScoreFrame(){
		setTitle("고득점 보기");
		setBounds(400, 280, 400,600);
		
		scorePane = new JPanel();
		setContentPane(scorePane);
		scorePane.setLayout(new FlowLayout());
	//	listmember=ClientFrame.getInstance().chat.getClient().highScore;
		
		list = new JTextArea("");
		list.setEditable(false);
		list.setSize(350, 500);
		list.setFont(new Font("나눔고딕", Font.PLAIN, 24));
		scrollPane = new JScrollPane(list);
		scrollPane.setPreferredSize(new Dimension(350,530));
		scorePane.add(scrollPane);
		
		
	}
	
}

