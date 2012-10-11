package jp.addmee.jchess.command;

import jp.addmee.jchess.entity.ChessmenEntity;
import jp.addmee.jchess.entity.PositionEntity;

/**
 * このインターフェースは、将棋のコマンド機能を表現するインターフェースです。
 * 
 * @since 1.0.0
 * @version 1.0.0 2012/10/04
 * @author Kawakicchi
 */
public interface Command {

	/**
	 * 駒を取得する。
	 * 
	 * @return 駒
	 */
	public ChessmenEntity getChessmen();

	/**
	 * 位置を取得する。
	 * 
	 * @return　位置
	 */
	public PositionEntity getPosition();

	/**
	 * 成りを判断する。
	 * 
	 * @return 成り
	 */
	public boolean isPromote();

	/**
	 * 投了か判断する。
	 * 
	 * @return 投了
	 */
	public boolean isGiveup();

}
