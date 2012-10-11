package jp.addmee.jchess.player;

import jp.addmee.jchess.command.Command;
import jp.addmee.jchess.entity.JchessEntity;

/**
 * このインターフェースは、プレイヤー機能を表現するインターフェースです。
 * 
 * @since 1.0.0
 * @version 1.0.0 2012/09/29
 * @author Kawakicchi
 */
public interface Player {

	/**
	 * プレイヤー名を取得する。
	 * 
	 * @return プレイヤー名
	 */
	String getName();

	/**
	 * 初期化処理を行います。
	 * 
	 */
	void initialize();

	/**
	 * 解放処理を行います。
	 * 
	 */
	void destroy();

	/**
	 * 将棋を指します。
	 * 
	 * @param jchess 将棋情報
	 * @return コマンド情報
	 */
	Command play(final JchessEntity jchess);

}
