package jp.addmee.jchess.entity;

/**
 * このクラスは、将棋情報を保持するクラスです。
 * 
 * @since 1.0.0
 * @version 1.0.0 2012/09/30
 * @author Kawakicchi
 */
public final class JchessEntity {

	/**
	 * 将棋盤
	 */
	private ChessBoardEntity board;

	/**
	 * コンストラクタ
	 * 
	 * @param aBoard 将棋盤情報
	 */
	public JchessEntity(final ChessBoardEntity aBoard) {
		board = aBoard;
	}

	/**
	 * 将棋盤情報を取得します。
	 * 
	 * @return 将棋盤
	 */
	public ChessBoardEntity getBoard() {
		return board;
	}

}
