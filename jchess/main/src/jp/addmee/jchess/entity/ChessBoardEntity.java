package jp.addmee.jchess.entity;

import java.util.List;

/**
 * このクラスは、将棋盤情報を保持するクラスです。
 * 
 * @since 1.0.0
 * @version 1.0.0 2012/09/30
 * @author Kawakicchi
 */
public final class ChessBoardEntity {

	/**
	 * 駒情報リスト
	 */
	private List<ChessmenEntity> chessmens;

	/**
	 * コンストラクタ
	 * 
	 * @param aChessmens 駒リスト
	 */
	public ChessBoardEntity(final List<ChessmenEntity> aChessmens) {
		chessmens = aChessmens;
	}

	/**
	 * すべての駒情報を取得します。
	 * 
	 * @return
	 */
	public List<ChessmenEntity> getChessmens() {
		return chessmens;
	}

}
