package jp.addmee.jchess.command;

import jp.addmee.jchess.entity.ChessmenEntity;
import jp.addmee.jchess.entity.PositionEntity;

/**
 * このクラスは、駒の移動を行うコマンドクラスです。
 * 
 * @since 1.0.0
 * @version 1.0.0 2012/10/04
 * @author Kawakicchi
 */
public class MoveCommand extends AbstractCommand {

	/**
	 * コンストラクタ
	 * 
	 * @param chessmen 駒移動
	 * @param position 移動位置
	 */
	public MoveCommand(final ChessmenEntity chessmen, final PositionEntity position) {
		super(chessmen, position, false, false);
	}

	/**
	 * コンストラクタ
	 * 
	 * @param chessmen 移動駒
	 * @param position 移動位置
	 * @param promote 成り
	 */
	public MoveCommand(final ChessmenEntity chessmen, final PositionEntity position, final boolean promote) {
		super(chessmen, position, promote, false);
	}

}
