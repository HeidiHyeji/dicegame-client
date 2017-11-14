package DiceController;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import DiceView.ClientFrame;
import DiceView.GameFrame;
import client.ClientState;

public class GameControl extends MouseAdapter {
	ClientState chat = null;

	public void mousePressed(MouseEvent e) {
		chat = ClientFrame.getInstance().chat.getClient();
		JButton btn = (JButton) e.getSource();
		String host = chat.getHost();
		int port = chat.getPort();

		if (btn.getText().equals("굴리기")) {
			if (Integer.parseInt(chat.result[1]) <= 10) 
				chat.handleMessageFromClientUI("굴리기");
		} else if (btn.getText().equals("나가기")) {
			chat.handleMessageFromClientUI("나가기");
			int yes_OR_no = JOptionPane.showConfirmDialog(null, "정말 끝내시겠습니까?", "REALLY?", JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE);
			if (yes_OR_no == 0) { // yes버튼 누르면 발생하는 이벤트
				// 게임창도 닫힘
				GameFrame.getInstance().setVisible(false);
				GameFrame.getInstance().dispose();
				GameFrame.getInstance().GameFrameReset();
			}
		}
	}

	public void mouseReleased(MouseEvent e) {
		JButton btn = (JButton) e.getSource();

		if (btn.getText().equals("굴리기")) {

			if (Integer.parseInt(chat.result[1]) <= 10) {
				System.out.println(chat.result[1]);
				GameFrame.getInstance().scoreLb.setText("점수 : " + chat.result[0]);
				GameFrame.getInstance().turnLb.setText("횟수 : " + chat.result[1]);
				GameFrame.getInstance().die1Lb.setText("주사위1 : " + chat.result[2]);
				GameFrame.getInstance().die2Lb.setText("주사위2 : " + chat.result[3]);
			}
			if (Integer.parseInt(chat.result[1]) == 10) {///////////
				System.out.println("점수 : " + chat.result[0]);
				int endYes = JOptionPane.showConfirmDialog(null, "게임이 끝났습니다.", "END", JOptionPane.CLOSED_OPTION,
						JOptionPane.INFORMATION_MESSAGE);
				if (endYes == 0) { // 확인누르면
					chat.handleMessageFromClientUI("게임종료");
					chat.result[0]="0";
					chat.result[1]="0";
					chat.result[2]="0";
					chat.result[3]="0";
				}
			}

		}
	}
}
