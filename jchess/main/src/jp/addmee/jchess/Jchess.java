package jp.addmee.jchess;

import jp.addmee.jchess.command.Command;
import jp.addmee.jchess.entity.JchessEntity;
import jp.addmee.jchess.exception.CommandException;
import jp.addmee.jchess.player.CUIPlayer;
import jp.addmee.jchess.player.Player;

/**
 * ���̃N���X�́A�����̃��C���N���X�ł��B
 * 
 * @since 1.0.0
 * @version 1.0.0 2012/09/29
 * @author Kawakicchi
 */
public final class Jchess {

	/**
	 * ���v���C���[
	 */
	private Player player1;

	/**
	 * ���v���C���[
	 */
	private Player player2;

	/**
	 * �������
	 */
	private JchessData data = new JchessData();

	/**
	 * �R���X�g���N�^
	 */
	public Jchess() {
	}

	/**
	 * ���v���C���[��ݒ肷��B
	 * 
	 * @param player �v���C���[
	 */
	public void setPlayer1(final Player player) {
		player1 = player;
	}

	/**
	 * ���v���C���[��ݒ肷��B
	 * 
	 * @param player
	 */
	public void setPlayer2(final Player player) {
		player2 = player;
	}

	/**
	 * �������������s���B
	 */
	public void initialize() {
		player1.initialize();
		player2.initialize();
	}

	/**
	 * ����������s���B
	 */
	public void destroy() {
		player1.destroy();
		player2.destroy();
	}

	/**
	 * �������J�n����B
	 */
	public void play() {

		long no = 1;
		try {

			while (true) {
				if (1 == (no % 2)) {
					JchessEntity jchess = new JchessEntity(data.generate(1));
					Command cmd = player1.play(jchess);
					if (cmd.isGiveup()) {
						throw new CommandException(1, "�������܂����B");
					}
					data.command(1, cmd);
				} else {
					JchessEntity jchess = new JchessEntity(data.generate(2));
					Command cmd = player2.play(jchess);
					if (cmd.isGiveup()) {
						throw new CommandException(1, "�������܂����B");
					}
					data.command(2, cmd);
				}
				no++;
			}

		} catch (CommandException ex) {
			System.out.println(ex.getPlayer() + ":" + ex.getMessage());
		}

	}

	public static void main(final String[] args) {
		Jchess jchess = new Jchess();
		jchess.setPlayer1(new CUIPlayer("�v���C���[1"));
		jchess.setPlayer2(new CUIPlayer("�v���C���[2"));
		jchess.initialize();
		jchess.play();
		jchess.destroy();
	}
}
