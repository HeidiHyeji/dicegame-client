package DiceController;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

import DiceView.ClientFrame;
import DiceView.GameFrame;
import DiceView.MainFrame;
import DiceView.ScoreFrame;
import client.ClientState;
import main.ClientMain;

public class MainController extends MouseAdapter {
	public ClientState clienetState = null;

	ScoreFrame scoreFrame;

	public void mousePressed(MouseEvent e) {
		clienetState = ClientFrame.getInstance().chat.getClient();
		JButton btn = (JButton) e.getSource();

		if (btn.getText().equals("게임시작")) {

			clienetState.handleMessageFromClientUI("게임시작");

			boolean checkAccept = clienetState.isConnected();

			if (checkAccept) {
				GameFrame.getInstance().setVisible(true);
			} else {
				//?에러인가 연결이 안되어있다는 것이지?
			}

		} else if (btn.getText().equals("최고점수")) {
			clienetState.handleMessageFromClientUI("최고점수");
			scoreFrame = new ScoreFrame();
			scoreFrame.setVisible(true);

		} else if (btn.getText().equals("로그아웃")) {
			ClientFrame.getInstance().chat.getClient().handleMessageFromClientUI("로그아웃");
			System.exit(0); // 프로그램 종료
		}
	}
	
	//이걸 왜 나눈거야? 같은 함수에 있으면 안돌아가나?
	public void mouseReleased(MouseEvent e) {
		clienetState = ClientFrame.getInstance().chat.getClient();
		JButton btn = (JButton) e.getSource();
		if (btn.getText().equals("최고점수")) {
			String listmember = ClientFrame.getInstance().chat.getClient().highScore;
			scoreFrame.list.append(listmember);
		}
	}
}
