package clue.model.vo.ui;

import javax.swing.JButton;
import javax.swing.JLabel;

import clue.controller.ComputerMove;
import clue.model.vo.Player;

public class GameStart {
	public GameStart() {

	}

	public GameStart(Player[] playerArr, int index, JButton[] buttonArray, JLabel[] labelArray) {
		if (index == 6) {
			index = 0;
		}
		// 나일때
		if (playerArr[index].getName().equals("나")) {
			ComputerMove computer = new ComputerMove(playerArr, index, buttonArray, labelArray);
		}

		// 컴퓨터일때
		else {
			ComputerMove computer = new ComputerMove(playerArr, index, buttonArray, labelArray);
		}
	}
}
