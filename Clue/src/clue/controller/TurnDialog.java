package clue.controller;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

import clue.model.vo.Player;
import clue.model.vo.ui.GameStart;

public class TurnDialog extends JDialog {
	private JLabel orderLabel;
	private JButton DialogBtn;
	int next;
	
	public TurnDialog() {

	}

	public TurnDialog(Player[] playerArr, int index, JButton[] buttonArray, JLabel[] labelArray) {
		setTitle("안내");
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		setBounds(d.width / 2 - 150, d.height / 2 - 100, 300, 200);
		setLayout(null);
		for(int i=0;i<playerArr.length;i++) {
			if(playerArr[i].getStartPlayer()==index) {
				next = i;
			}
		}
		
		// 순서 정보 라벨 설정
		orderLabel = new JLabel(
				"다음순서는 " + playerArr[next].getCharacter() + "(" + playerArr[next].getName() + ") 입니다.");

		orderLabel.setBounds(27, 70, 250, 20);

		// 버튼설정
		DialogBtn = new JButton("확인");
		DialogBtn.setBounds(110, 120, 60, 30);

		// 버튼 이벤트
		DialogBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new GameStart(playerArr, index, buttonArray, labelArray);

			}
		});
		add(orderLabel);
		add(DialogBtn);
		setFocusable(true);
		setVisible(true);
	}
}
