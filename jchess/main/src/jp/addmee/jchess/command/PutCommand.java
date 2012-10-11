package jp.addmee.jchess.command;

import jp.addmee.jchess.entity.ChessmenEntity;
import jp.addmee.jchess.entity.PositionEntity;

/**
 * このクラスは、駒を置くコマンドクラスです。
 * 
 * @since 1.0.0
 * @version 1.0.0 2012/10/04
 * @author Kawakicchi
 */
public class PutCommand extends AbstractCommand {

	/**
	 * コンストラクタ
	 * 
	 * @param chessmen 置く駒
	 * @param position 置く位置
	 */
	public PutCommand(final ChessmenEntity chessmen, final PositionEntity position) {
		super(chessmen, position, false, false);
	}

}
