package jp.addmee.jchess.exception;

/**
 * このクラスは、コマンド実行時の例外を表現したクラスです。
 * 
 * @since 1.0.0
 * @version 1.0.0 2012/09/30
 * @author Kawakicchi
 */
public class CommandException extends Exception {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 7726277016833841022L;

	/**
	 * player
	 */
	private int player;

	/**
	 * コンストラクタ
	 * 
	 * @param aPlayer プレイヤー
	 * @param aMessage メッセージ
	 */
	public CommandException(final int aPlayer, final String aMessage) {
		super(aMessage);
		player = aPlayer;
	}

	/**
	 * プレイヤーを取得します。
	 * 
	 * @return プレイヤー
	 */
	public int getPlayer() {
		return player;
	}
}
