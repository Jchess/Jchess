package jp.addmee.jchess;

import jp.addmee.jchess.command.Command;
import jp.addmee.jchess.entity.JchessEntity;
import jp.addmee.jchess.exception.CommandException;
import jp.addmee.jchess.player.CUIPlayer;
import jp.addmee.jchess.player.Player;

/**
 * このクラスは、将棋のメインクラスです。
 * 
 * @since 1.0.0
 * @version 1.0.0 2012/09/29
 * @author Kawakicchi
 */
public final class Jchess {

	/**
	 * 先手プレイヤー
	 */
	private Player player1;

	/**
	 * 後手プレイヤー
	 */
	private Player player2;

	/**
	 * 将棋情報
	 */
	private JchessData data = new JchessData();

	/**
	 * コンストラクタ
	 */
	public Jchess() {
	}

	/**
	 * 先手プレイヤーを設定する。
	 * 
	 * @param player プレイヤー
	 */
	public void setPlayer1(final Player player) {
		player1 = player;
	}

	/**
	 * 後手プレイヤーを設定する。
	 * 
	 * @param player
	 */
	public void setPlayer2(final Player player) {
		player2 = player;
	}

	/**
	 * 初期化処理を行う。
	 */
	public void initialize() {
		player1.initialize();
		player2.initialize();
	}

	/**
	 * 解放処理を行う。
	 */
	public void destroy() {
		player1.destroy();
		player2.destroy();
	}

	/**
	 * 将棋を開始する。
	 */
	public void play() {

		long no = 1;
		try {

			while (true) {
				if (1 == (no % 2)) {
					JchessEntity jchess = new JchessEntity(data.generate(1));
					Command cmd = player1.play(jchess);
					if (cmd.isGiveup()) {
						throw new CommandException(1, "投了しました。");
					}
					data.command(1, cmd);
				} else {
					JchessEntity jchess = new JchessEntity(data.generate(2));
					Command cmd = player2.play(jchess);
					if (cmd.isGiveup()) {
						throw new CommandException(1, "投了しました。");
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
		jchess.setPlayer1(new CUIPlayer("プレイヤー1"));
		jchess.setPlayer2(new CUIPlayer("プレイヤー2"));
		jchess.initialize();
		jchess.play();
		jchess.destroy();
	}
}
