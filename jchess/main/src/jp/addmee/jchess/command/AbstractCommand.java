package jp.addmee.jchess.command;

import jp.addmee.jchess.entity.ChessmenEntity;
import jp.addmee.jchess.entity.PositionEntity;

/**
 * このクラスは、将棋のコマンド機能を実装する基底クラスです。
 * 
 * @since 1.0.0
 * @version 1.0.0 2012/09/29
 * @author Kawakicchi
 */
public class AbstractCommand implements Command {

	/**
	 * 駒
	 */
	private ChessmenEntity chessmen;

	/**
	 * 位置
	 */
	private PositionEntity pos;

	/**
	 * 成り
	 */
	private boolean promote;

	/**
	 * 投了
	 */
	private boolean giveup;

	/**
	 * コンストラクタ
	 * 
	 * @param aChessmen 対象駒
	 * @param aPosition 移動先
	 * @param aPromote 成る
	 * @param aGiveup 投了
	 */
	public AbstractCommand(final ChessmenEntity aChessmen, final PositionEntity aPosition, final boolean aPromote, final boolean aGiveup) {
		chessmen = aChessmen;
		pos = aPosition;
		promote = aPromote;
		giveup = aGiveup;
	}

	@Override
	public final ChessmenEntity getChessmen() {
		return chessmen;
	}

	@Override
	public final PositionEntity getPosition() {
		return pos;
	}

	@Override
	public final boolean isPromote() {
		return promote;
	}

	@Override
	public final boolean isGiveup() {
		return giveup;
	}
}
