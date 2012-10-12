package jp.addmee.jchess.player;

import java.util.List;

import jp.addmee.jchess.command.Command;
import jp.addmee.jchess.entity.ChessBoardEntity;
import jp.addmee.jchess.entity.ChessmenEntity;
import jp.addmee.jchess.entity.JchessEntity;
import jp.addmee.jchess.entity.PositionEntity;
import jp.addmee.jchess.util.JchessUtility;

/**
 * このクラスは、プレイヤー機能を実装する基底クラスです。
 * 
 * @since 1.0.0
 * @version 1.0.0 2012/09/29
 * @author Kawakicchi
 */
public abstract class AbstractPlayer implements Player {

	/**
	 * jchess
	 */
	private JchessEntity jchess;

	@Override
	public final void initialize() {
		doInitialize();
	}

	@Override
	public final void destroy() {
		doDestroy();
	}

	@Override
	public final Command play(final JchessEntity aJchess) {
		jchess = aJchess;
		return doPlay();
	}

	/**
	 * 初期化処理を行います。
	 */
	protected abstract void doInitialize();

	/**
	 * 解放処理を行います。
	 */
	protected abstract void doDestroy();

	/**
	 * 将棋を指します。
	 * 
	 * @param jchess 将棋情報
	 * @return コマンド情報
	 */
	protected abstract Command doPlay();

	/**
	 * 盤情報を取得します。
	 * 
	 * @return 盤情報
	 */
	protected final ChessBoardEntity getBoard() {
		return jchess.getBoard();
	}

	/**
	 * 自分の駒の一覧を取得します。
	 * 
	 * @return 駒一覧
	 */
	protected final List<ChessmenEntity> getMyChessmens() {
		return JchessUtility.getMyChessmens(jchess.getBoard());
	}

	/**
	 * 自分の盤上駒の一覧を取得します。
	 * 
	 * @return 駒一覧
	 */
	protected final List<ChessmenEntity> getMyBoardChessmens() {
		return JchessUtility.getMyBoardChessmens(jchess.getBoard());
	}

	/**
	 * 自分の持ち駒の一覧を取得します。
	 * 
	 * @return 駒一覧
	 */
	protected final List<ChessmenEntity> getMyStockChessmens() {
		return JchessUtility.getMyStockChessmens(jchess.getBoard());
	}

	/**
	 * 指定位置に駒が存在するか判断します。
	 * 
	 * @param p 位置
	 * @return 駒が存在する場合、<code>true</code>を返す。
	 */
	protected final boolean isChessmen(final PositionEntity p) {
		return JchessUtility.isChessmen(jchess.getBoard(), p);
	}

	/**
	 * 指定位置に存在する駒を取得します。
	 * 
	 * @param p 位置
	 * @return 駒。存在するしない場合、<code>null</code>を返す。
	 */
	protected final ChessmenEntity getChessmen(final PositionEntity p) {
		return JchessUtility.getChessmen(jchess.getBoard(), p);
	}

	/**
	 * 指定位置に自分の駒が存在するか判断します。
	 * 
	 * @param p 位置
	 * @return 自分の駒が存在する場合、<code>true</code>を返す。
	 */
	protected final boolean isMyChessmen(final PositionEntity p) {
		return JchessUtility.isMyChessmen(jchess.getBoard(), p);
	}

	/**
	 * 指定位置に存在する自分の駒を取得します。
	 * 
	 * @param p 位置
	 * @return 駒。存在するしない場合または相手の駒の場合、<code>null</code>を返す。
	 */
	protected final ChessmenEntity getMyChessmen(final PositionEntity p) {
		return JchessUtility.getMyChessmen(jchess.getBoard(), p);
	}

	/**
	 * 指定の駒が移動可能な位置の一覧を取得します。
	 * 
	 * @param c 駒
	 * @return 位置一覧
	 */
	protected List<PositionEntity> getMovePositions(final ChessmenEntity c) {
		return JchessUtility.getMovePositions(jchess.getBoard(), c);
	}

	/**
	 * 指定位置に駒を移動出来るか判断します。
	 * 
	 * @param c 駒
	 * @param p 移動位置
	 * @return 移動可能な場合、<code>true</code>を返す。
	 */
	protected final boolean isMoveChessmen(final ChessmenEntity c, final PositionEntity p) {
		return isMoveChessmen(c, p, false);
	}

	/**
	 * 指定位置に駒を移動出来るか判断します。
	 * 
	 * @param c 駒
	 * @param p 移動位置
	 * @param promote 成る
	 * @return 移動可能な場合、<code>true</code>を返す。
	 */
	protected final boolean isMoveChessmen(final ChessmenEntity c, final PositionEntity p, final boolean promote) {
		return JchessUtility.isMoveChessmen(jchess.getBoard(), c, p, promote);
	}

	/**
	 * 指定位置に持ち駒を置けるか判断します。
	 * 
	 * @param c 駒
	 * @param p 置き位置
	 * @return 置き可能な場合、<code>true</code>を返す。
	 */
	protected final boolean isPutChessmen(final ChessmenEntity c, final PositionEntity p) {
		return JchessUtility.isPutChessmen(jchess.getBoard(), c, p);
	}

	// OpponentStock

	public void print() {
		int no;
		List<ChessmenEntity> chessmens = jchess.getBoard().getChessmens();

		String crlf = "\n";
		try {
			crlf = System.getProperty("line.separator");
		} catch (SecurityException e) {
		}

		StringBuffer s = new StringBuffer();
		s.append("相手").append(crlf);
		s.append(" [");
		for (ChessmenEntity c : chessmens) {
			if (!c.isPlayer() && !c.isBoard()) {
				s.append(c.getType().getCode());
			}
		}
		s.append("]").append(crlf);
		s.append("  9   8   7   6   5   4   3   2   1  ").append(crlf);
		s.append("┌───┬───┬───┬───┬───┬───┬───┬───┬───┐").append(crlf);
		for (int y = 0; y < 9; y++) {
			s.append("│");
			for (int x = 0; x < 9; x++) {
				ChessmenEntity coma = getChessmen(new PositionEntity(x, y));
				if (null != coma) {
					if (coma.isPlayer()) {
						s.append("+");
					} else {
						s.append("-");
					}
					s.append(coma.getType().getCode());
					if (coma.isPromote()) {
						s.append("*");
					} else {
						s.append(" ");
					}
				} else {
					s.append("   ");
				}
				s.append("│");
			}
			s.append(new Character((char) ('A' + y)));
			s.append(crlf);
		}
		s.append("└───┴───┴───┴───┴───┴───┴───┴───┴───┘").append(crlf);
		s.append("自分").append(crlf);
		s.append(" [");
		no = 1;
		for (ChessmenEntity c : getMyStockChessmens()) {
			if (1 != no) {
				s.append(", ");
			}
			s.append(no + ":" + c.getType().getCode());
			no++;
		}
		s.append("]").append(crlf);

		System.out.println(s.toString());
	}
}
