package jp.addmee.jchess.util;

import java.util.ArrayList;
import java.util.List;

import jp.addmee.jchess.entity.ChessBoardEntity;
import jp.addmee.jchess.entity.ChessmenEntity;
import jp.addmee.jchess.entity.ChessmenEntity.Type;
import jp.addmee.jchess.entity.PositionEntity;
import jp.addmee.jchess.rule.JchessRule;

/**
 * このクラスは、将棋のユーティリティを提供するクラスです。
 * 
 * @since 1.0.0
 * @version 1.0.0 2012/10/04
 * @author Kawakicchi
 */
public final class JchessUtility {

	/**
	 * コンストラクタ
	 * <p>
	 * インスタンス生成を禁止
	 * </p>
	 */
	private JchessUtility() {

	}

	/**
	 * 盤情報をコピーします。
	 * 
	 * @param aBoard コピー元盤情報
	 * @return 盤情報
	 */
	public static ChessBoardEntity copyBoard(final ChessBoardEntity aBoard) {
		return copyBoard(aBoard, false);
	}

	/**
	 * 盤情報をコピーします。
	 * <p>
	 * 反転を行うと、プレイヤー視点を反転した状態でコピーします。
	 * </p>
	 * 
	 * @param aBoard コピー元盤情報
	 * @param aReverse 反転
	 * @return 盤情報
	 */
	public static ChessBoardEntity copyBoard(final ChessBoardEntity aBoard, final boolean aReverse) {
		List<ChessmenEntity> chessmens = new ArrayList<ChessmenEntity>();
		for (ChessmenEntity chessmen : aBoard.getChessmens()) {
			int id = chessmen.getId();
			Type type = chessmen.getType();
			PositionEntity position = copyPosition(chessmen.getPosition(), aReverse);
			boolean player = copyPlayer(chessmen.isPlayer(), aReverse);
			boolean board = chessmen.isBoard();
			boolean promote = chessmen.isPromote();
			ChessmenEntity c = new ChessmenEntity(id, type, position, player, board, promote);
			chessmens.add(c);
		}
		ChessBoardEntity board = new ChessBoardEntity(chessmens);
		return board;
	}

	/**
	 * 位置情報をコピーします。
	 * 
	 * @param aPosition コピー元位置情報
	 * @return 位置情報
	 */
	public static PositionEntity copyPosition(final PositionEntity aPosition) {
		return copyPosition(aPosition, false);
	}

	/**
	 * 位置情報をコピーします。
	 * <p>
	 * 反転を行うと、プレイヤー視点を反転した状態でコピーします。
	 * </p>
	 * 
	 * @param aPosition コピー元位置情報
	 * @param aReverse 反転
	 * @return 位置情報
	 */
	public static PositionEntity copyPosition(final PositionEntity aPosition, final boolean aReverse) {
		int x;
		int y;
		if (aReverse) {
			x = 8 - aPosition.getX();
			y = 8 - aPosition.getY();
		} else {
			x = aPosition.getX();
			y = aPosition.getY();
		}
		return new PositionEntity(x, y);
	}

	/**
	 * プレイヤーをコピーします。
	 * 
	 * @param aPlayer コピー元プレイヤー
	 * @return プレイヤー
	 */
	public static boolean copyPlayer(final boolean aPlayer) {
		return copyPlayer(aPlayer, false);
	}

	/**
	 * プレイヤーをコピーします。
	 * <p>
	 * 反転を行うと、プレイヤー視点を反転した状態でコピーします。
	 * </p>
	 * 
	 * @param aPlayer コピー元プレイヤー
	 * @param aReverse 反転
	 * @return プレイヤー
	 */
	public static boolean copyPlayer(final boolean aPlayer, final boolean aReverse) {
		if (aReverse) {
			return !(aPlayer);
		} else {
			return (aPlayer);
		}
	}

	/**
	 * 盤視点で自駒となる駒の一覧を取得します。
	 * 
	 * @param aBoard 盤情報
	 * @return 駒一覧
	 */
	public static List<ChessmenEntity> getMyChessmens(final ChessBoardEntity aBoard) {
		List<ChessmenEntity> result = new ArrayList<ChessmenEntity>();
		List<ChessmenEntity> chessmens = aBoard.getChessmens();
		for (ChessmenEntity c : chessmens) {
			if (c.isPlayer()) {
				result.add(c);
			}
		}
		return result;
	}

	/**
	 * 盤視点で自駒となる盤上駒の一覧を取得します。
	 * 
	 * @param aBoard 盤情報
	 * @return 駒一覧
	 */
	public static List<ChessmenEntity> getMyBoardChessmens(final ChessBoardEntity aBoard) {
		List<ChessmenEntity> result = new ArrayList<ChessmenEntity>();
		List<ChessmenEntity> chessmens = aBoard.getChessmens();
		for (ChessmenEntity c : chessmens) {
			if (c.isPlayer()) {
				if (c.isBoard()) {
					result.add(c);
				}
			}
		}
		return result;
	}

	/**
	 * 盤視点で自駒となる持ち駒の一覧を取得します。
	 * 
	 * @param aBoard 盤情報
	 * @return 駒一覧
	 */
	public static List<ChessmenEntity> getMyStockChessmens(final ChessBoardEntity aBoard) {
		List<ChessmenEntity> result = new ArrayList<ChessmenEntity>();
		List<ChessmenEntity> chessmens = aBoard.getChessmens();
		for (ChessmenEntity c : chessmens) {
			if (c.isPlayer()) {
				if (!c.isBoard()) {
					result.add(c);
				}
			}
		}
		return result;
	}

	/**
	 * 盤上の指定位置に駒が存在するか判断します。
	 * 
	 * @param aBoard 盤情報
	 * @param p 位置
	 * @return 駒が存在する場合、<code>true</code>を返す。
	 */
	public static boolean isChessmen(final ChessBoardEntity aBoard, final PositionEntity p) {
		boolean result = false;
		if (null != p) {
			List<ChessmenEntity> chessmens = aBoard.getChessmens();
			for (ChessmenEntity c : chessmens) {
				if (p.getX() == c.getPosition().getX() && p.getY() == c.getPosition().getY()) {
					result = true;
					break;
				}
			}
		}
		return result;
	}

	/**
	 * 盤上の指定位置に存在する駒を取得します。
	 * 
	 * @param aBoard 盤情報
	 * @param p 位置
	 * @return 駒。存在するしない場合、<code>null</code>を返す。
	 */
	public static ChessmenEntity getChessmen(final ChessBoardEntity aBoard, final PositionEntity p) {
		ChessmenEntity result = null;
		if (null != p) {
			List<ChessmenEntity> chessmens = aBoard.getChessmens();
			for (ChessmenEntity c : chessmens) {
				if (p.getX() == c.getPosition().getX() && p.getY() == c.getPosition().getY()) {
					result = c;
					break;
				}
			}
		}
		return result;
	}

	/**
	 * 指定位置に盤視点で自駒となる駒が存在するか判断します。
	 * 
	 * @param aBoard 盤情報
	 * @param p 位置
	 * @return 自分の駒が存在する場合、<code>true</code>を返す。
	 */
	public static boolean isMyChessmen(final ChessBoardEntity aBoard, final PositionEntity p) {
		boolean result = false;
		if (null != p) {
			List<ChessmenEntity> chessmens = aBoard.getChessmens();
			for (ChessmenEntity c : chessmens) {
				if (c.isPlayer()) {
					if (p.getX() == c.getPosition().getX() && p.getY() == c.getPosition().getY()) {
						result = true;
						break;
					}
				}
			}
		}
		return result;
	}

	/**
	 * 指定位置に存在する盤視点で自駒となる駒を取得します。
	 * 
	 * @param aBoard 盤情報
	 * @param p 位置
	 * @return 駒。存在するしない場合または相手の駒の場合、<code>null</code>を返す。
	 */
	public static ChessmenEntity getMyChessmen(final ChessBoardEntity aBoard, final PositionEntity p) {
		ChessmenEntity result = null;
		if (null != p) {
			List<ChessmenEntity> chessmens = aBoard.getChessmens();
			for (ChessmenEntity c : chessmens) {
				if (c.isPlayer()) {
					if (p.getX() == c.getPosition().getX() && p.getY() == c.getPosition().getY()) {
						result = c;
						break;
					}
				}
			}
		}
		return result;
	}

	/**
	 * 指定の駒が移動可能な位置の一覧を取得します。
	 * 
	 * @param b 盤
	 * @param c 駒
	 * @return 位置一覧
	 */
	public static List<PositionEntity> getMovePositions(final ChessBoardEntity b, final ChessmenEntity c) {
		List<PositionEntity> result = null;
		if (null != c && c.isPlayer()) {
			if (c.isBoard()) {
				if (Type.King == c.getType()) {
					result = getMovePositionsKing(b, c);
				} else if (Type.Rook == c.getType()) {
					result = getMovePositionsRook(b, c);
				} else if (Type.Bishop == c.getType()) {
					result = getMovePositionsBishop(b, c);
				} else if (Type.Gold == c.getType()) {
					result = getMovePositionsGold(b, c);
				} else if (Type.Silver == c.getType()) {
					result = getMovePositionsSilver(b, c);
				} else if (Type.Knight == c.getType()) {
					result = getMovePositionsKnight(b, c);
				} else if (Type.Lance == c.getType()) {
					result = getMovePositionsLance(b, c);
				} else if (Type.Pawn == c.getType()) {
					result = getMovePositionsPawn(b, c);
				} else {
					result = new ArrayList<PositionEntity>();
				}
			} else {
				result = new ArrayList<PositionEntity>();
				for (int y = 0; y < 9; y++) {
					for (int x = 0; x < 9; x++) {
						PositionEntity p = new PositionEntity(x, y);
						if (!isChessmen(b, p)) {
							result.add(p);
						}
					}
				}
			}
		} else {
			result = new ArrayList<PositionEntity>();
		}
		return result;
	}

	private static List<PositionEntity> getMovePositionsKing(final ChessBoardEntity b, final ChessmenEntity c) {
		List<PositionEntity> result = new ArrayList<PositionEntity>();
		PositionEntity p = null;
		p = new PositionEntity(c.getPosition().getX() - 1, c.getPosition().getY() - 1);
		if (enablePosition(b, p)) {
			result.add(p);
		}
		p = new PositionEntity(c.getPosition().getX(), c.getPosition().getY() - 1);
		if (enablePosition(b, p)) {
			result.add(p);
		}
		p = new PositionEntity(c.getPosition().getX() + 1, c.getPosition().getY() - 1);
		if (enablePosition(b, p)) {
			result.add(p);
		}
		p = new PositionEntity(c.getPosition().getX() - 1, c.getPosition().getY());
		if (enablePosition(b, p)) {
			result.add(p);
		}
		p = new PositionEntity(c.getPosition().getX() + 1, c.getPosition().getY());
		if (enablePosition(b, p)) {
			result.add(p);
		}
		p = new PositionEntity(c.getPosition().getX() - 1, c.getPosition().getY() + 1);
		if (enablePosition(b, p)) {
			result.add(p);
		}
		p = new PositionEntity(c.getPosition().getX(), c.getPosition().getY() + 1);
		if (enablePosition(b, p)) {
			result.add(p);
		}
		p = new PositionEntity(c.getPosition().getX() + 1, c.getPosition().getY() + 1);
		if (enablePosition(b, p)) {
			result.add(p);
		}
		return result;
	}

	private static List<PositionEntity> getMovePositionsRook(final ChessBoardEntity b, final ChessmenEntity c) {
		List<PositionEntity> result = new ArrayList<PositionEntity>();
		PositionEntity p = null;
		if (c.isPromote()) {
			p = new PositionEntity(c.getPosition().getX() - 1, c.getPosition().getY() - 1);
			if (enablePosition(b, p)) {
				result.add(p);
			}
			p = new PositionEntity(c.getPosition().getX() + 1, c.getPosition().getY() - 1);
			if (enablePosition(b, p)) {
				result.add(p);
			}
			p = new PositionEntity(c.getPosition().getX() + 1, c.getPosition().getY() + 1);
			if (enablePosition(b, p)) {
				result.add(p);
			}
			p = new PositionEntity(c.getPosition().getX() - 1, c.getPosition().getY() + 1);
			if (enablePosition(b, p)) {
				result.add(p);
			}
		}
		int x;
		int y;
		x = c.getPosition().getX();
		y = c.getPosition().getY() - 1;
		while (true) {
			p = new PositionEntity(x, y);
			if (!enablePosition(p)) {
				break;
			}
			ChessmenEntity target = getChessmen(b, p);
			if (null == target) {
				result.add(p);
			} else {
				if (!target.isPlayer()) {
					result.add(p);
				}
				break;
			}
			y--;
		}
		x = c.getPosition().getX();
		y = c.getPosition().getY() + 1;
		while (true) {
			p = new PositionEntity(x, y);
			if (!enablePosition(p)) {
				break;
			}
			ChessmenEntity target = getChessmen(b, p);
			if (null == target) {
				result.add(p);
			} else {
				if (!target.isPlayer()) {
					result.add(p);
				}
				break;
			}
			y++;
		}
		x = c.getPosition().getX() - 1;
		y = c.getPosition().getY();
		while (true) {
			p = new PositionEntity(x, y);
			if (!enablePosition(p)) {
				break;
			}
			ChessmenEntity target = getChessmen(b, p);
			if (null == target) {
				result.add(p);
			} else {
				if (!target.isPlayer()) {
					result.add(p);
				}
				break;
			}
			x--;
		}
		x = c.getPosition().getX() + 1;
		y = c.getPosition().getY();
		while (true) {
			p = new PositionEntity(x, y);
			if (!enablePosition(p)) {
				break;
			}
			ChessmenEntity target = getChessmen(b, p);
			if (null == target) {
				result.add(p);
			} else {
				if (!target.isPlayer()) {
					result.add(p);
				}
				break;
			}
			x++;
		}
		return result;
	}

	private static List<PositionEntity> getMovePositionsBishop(final ChessBoardEntity b, final ChessmenEntity c) {
		List<PositionEntity> result = new ArrayList<PositionEntity>();
		PositionEntity p = null;
		if (c.isPromote()) {
			p = new PositionEntity(c.getPosition().getX(), c.getPosition().getY() - 1);
			if (enablePosition(b, p)) {
				result.add(p);
			}
			p = new PositionEntity(c.getPosition().getX() + 1, c.getPosition().getY());
			if (enablePosition(b, p)) {
				result.add(p);
			}
			p = new PositionEntity(c.getPosition().getX(), c.getPosition().getY() + 1);
			if (enablePosition(b, p)) {
				result.add(p);
			}
			p = new PositionEntity(c.getPosition().getX() - 1, c.getPosition().getY());
			if (enablePosition(b, p)) {
				result.add(p);
			}
		}
		int x;
		int y;
		x = c.getPosition().getX() - 1;
		y = c.getPosition().getY() - 1;
		while (true) {
			p = new PositionEntity(x, y);
			if (!enablePosition(p)) {
				break;
			}
			ChessmenEntity target = getChessmen(b, p);
			if (null == target) {
				result.add(p);
			} else {
				if (!target.isPlayer()) {
					result.add(p);
				}
				break;
			}
			x--;
			y--;
		}
		x = c.getPosition().getX() + 1;
		y = c.getPosition().getY() - 1;
		while (true) {
			p = new PositionEntity(x, y);
			if (!enablePosition(p)) {
				break;
			}
			ChessmenEntity target = getChessmen(b, p);
			if (null == target) {
				result.add(p);
			} else {
				if (!target.isPlayer()) {
					result.add(p);
				}
				break;
			}
			x++;
			y--;
		}
		x = c.getPosition().getX() + 1;
		y = c.getPosition().getY() + 1;
		while (true) {
			p = new PositionEntity(x, y);
			if (!enablePosition(p)) {
				break;
			}
			ChessmenEntity target = getChessmen(b, p);
			if (null == target) {
				result.add(p);
			} else {
				if (!target.isPlayer()) {
					result.add(p);
				}
				break;
			}
			x++;
			y++;
		}
		x = c.getPosition().getX() - 1;
		y = c.getPosition().getY() + 1;
		while (true) {
			p = new PositionEntity(x, y);
			if (!enablePosition(p)) {
				break;
			}
			ChessmenEntity target = getChessmen(b, p);
			if (null == target) {
				result.add(p);
			} else {
				if (!target.isPlayer()) {
					result.add(p);
				}
				break;
			}
			x--;
			y++;
		}
		return result;
	}

	private static List<PositionEntity> getMovePositionsGold(final ChessBoardEntity b, final ChessmenEntity c) {
		List<PositionEntity> result = new ArrayList<PositionEntity>();
		PositionEntity p = null;
		p = new PositionEntity(c.getPosition().getX() - 1, c.getPosition().getY() - 1);
		if (enablePosition(b, p)) {
			result.add(p);
		}
		p = new PositionEntity(c.getPosition().getX(), c.getPosition().getY() - 1);
		if (enablePosition(b, p)) {
			result.add(p);
		}
		p = new PositionEntity(c.getPosition().getX() + 1, c.getPosition().getY() - 1);
		if (enablePosition(b, p)) {
			result.add(p);
		}
		p = new PositionEntity(c.getPosition().getX() - 1, c.getPosition().getY());
		if (enablePosition(b, p)) {
			result.add(p);
		}
		p = new PositionEntity(c.getPosition().getX() + 1, c.getPosition().getY());
		if (enablePosition(b, p)) {
			result.add(p);
		}
		p = new PositionEntity(c.getPosition().getX(), c.getPosition().getY() + 1);
		if (enablePosition(b, p)) {
			result.add(p);
		}
		return result;
	}

	private static List<PositionEntity> getMovePositionsSilver(final ChessBoardEntity b, final ChessmenEntity c) {
		List<PositionEntity> result = null;
		if (c.isPromote()) {
			result = getMovePositionsGold(b, c);
		} else {
			result = new ArrayList<PositionEntity>();
			PositionEntity p = null;
			p = new PositionEntity(c.getPosition().getX() - 1, c.getPosition().getY() - 1);
			if (enablePosition(b, p)) {
				result.add(p);
			}
			p = new PositionEntity(c.getPosition().getX(), c.getPosition().getY() - 1);
			if (enablePosition(b, p)) {
				result.add(p);
			}
			p = new PositionEntity(c.getPosition().getX() + 1, c.getPosition().getY() - 1);
			if (enablePosition(b, p)) {
				result.add(p);
			}
			p = new PositionEntity(c.getPosition().getX() - 1, c.getPosition().getY() + 1);
			if (enablePosition(b, p)) {
				result.add(p);
			}
			p = new PositionEntity(c.getPosition().getX() + 1, c.getPosition().getY() + 1);
			if (enablePosition(b, p)) {
				result.add(p);
			}
		}
		return result;
	}

	private static List<PositionEntity> getMovePositionsKnight(final ChessBoardEntity b, final ChessmenEntity c) {
		List<PositionEntity> result = null;
		if (c.isPromote()) {
			result = getMovePositionsGold(b, c);
		} else {
			result = new ArrayList<PositionEntity>();
			PositionEntity p = null;
			p = new PositionEntity(c.getPosition().getX() - 1, c.getPosition().getY() - 2);
			if (enablePosition(b, p)) {
				result.add(p);
			}
			p = new PositionEntity(c.getPosition().getX() + 1, c.getPosition().getY() - 2);
			if (enablePosition(b, p)) {
				result.add(p);
			}
		}
		return result;
	}

	private static List<PositionEntity> getMovePositionsLance(final ChessBoardEntity b, final ChessmenEntity c) {
		List<PositionEntity> result = null;
		if (c.isPromote()) {
			result = getMovePositionsGold(b, c);
		} else {
			result = new ArrayList<PositionEntity>();
			PositionEntity p = null;
			int y = c.getPosition().getY() - 1;
			while (true) {
				p = new PositionEntity(c.getPosition().getX(), y);
				if (!enablePosition(p)) {
					break;
				}
				ChessmenEntity target = getChessmen(b, p);
				if (null == target) {
					result.add(p);
				} else {
					if (!target.isPlayer()) {
						result.add(p);
					}
					break;
				}
				y--;
			}
		}
		return result;
	}

	private static List<PositionEntity> getMovePositionsPawn(final ChessBoardEntity b, final ChessmenEntity c) {
		List<PositionEntity> result = null;
		if (c.isPromote()) {
			result = getMovePositionsGold(b, c);
		} else {
			result = new ArrayList<PositionEntity>();
			PositionEntity p = null;
			p = new PositionEntity(c.getPosition().getX(), c.getPosition().getY() - 1);
			if (enablePosition(b, p)) {
				result.add(p);
			}
		}
		return result;
	}

	private static boolean enablePosition(final ChessBoardEntity b, final PositionEntity p) {
		boolean result = false;
		if (enablePosition(p)) {
			if (!isMyChessmen(b, p)) {
				result = true;
			}
		}
		return result;
	}

	private static boolean enablePosition(final PositionEntity p) {
		boolean result = false;
		if (0 <= p.getX() && 9 > p.getX() && 0 <= p.getY() && 9 > p.getY()) {
			result = true;
		}
		return result;
	}

	/**
	 * 指定位置に駒を移動出来るか判断します。
	 * 
	 * @param b 盤
	 * @param c 駒
	 * @param p 移動位置
	 * @param promote 成る
	 * @return 移動可能な場合、<code>true</code>を返す。
	 */
	public static boolean isMoveChessmen(final ChessBoardEntity b, final ChessmenEntity c, final PositionEntity p, final boolean promote) {
		boolean result = false;
		do {
			if (null == c || null == p) {
				break;
			}

			if (!c.isPlayer()) {
				// 相手の駒を操作しようとしました。
				break;
			}
			if (!c.isBoard()) {
				// 盤上の駒ではありません。
				break;
			}
			if (0 > p.getX() || 9 <= p.getX() || 0 > p.getY() || 9 <= p.getY()) {
				// 盤範囲外が指定されました。
				break;
			}
			if (!JchessRule.isMove(c.getType(), p.getX() - c.getPosition().getX(), p.getY() - c.getPosition().getY(), c.isPromote())) {
				// その駒では移動出来ない位置が指定されました。
				break;
			}
			if (!isSkipMove(b, c, p)) {
				// 移動途中に駒が存在します。
				break;
			}

			ChessmenEntity cto = getChessmen(b, p);
			if (null != cto) {
				if (cto.isPlayer()) {
					// その位置には既に自駒が存在します。
					break;
				}
			}

			if (promote) {
				if (2 < p.getY()) {
					// その場所では成ることは出来ません。
					break;
				}
				if (c.isPromote()) {
					// 既に成っています。
					break;
				}
			}

			result = true;
		} while (false);
		return result;
	}

	public static ChessBoardEntity moveChessmen(final ChessBoardEntity b, final ChessmenEntity c, final PositionEntity p, final boolean promote) {
		ChessBoardEntity board = null;
		if (isMoveChessmen(b, c, p, promote)) {
			List<ChessmenEntity> chessmens = new ArrayList<ChessmenEntity>();
			for (ChessmenEntity chessmen : b.getChessmens()) {
				if (chessmen.getId() == c.getId()) {
					chessmens.add(new ChessmenEntity(chessmen.getId(), chessmen.getType(), new PositionEntity(p), chessmen.isPlayer(), chessmen
							.isBoard(), promote));
				} else if (chessmen.isBoard() && !chessmen.isPlayer() && chessmen.getPosition().getX() == p.getX()
						&& chessmen.getPosition().getY() == p.getY()) {
					chessmens.add(new ChessmenEntity(chessmen.getId(), chessmen.getType(), new PositionEntity(0, 0), true, false, false));
				} else {
					chessmens.add(new ChessmenEntity(chessmen));
				}
			}
			board = new ChessBoardEntity(chessmens);
		}
		return board;
	}

	/**
	 * 指定位置に持ち駒を置けるか判断します。
	 * 
	 * @param b 盤
	 * @param c 駒
	 * @param p 置き位置
	 * @return 置き可能な場合、<code>true</code>を返す。
	 */
	public static boolean isPutChessmen(final ChessBoardEntity b, final ChessmenEntity c, final PositionEntity p) {
		boolean result = false;
		do {
			if (null == c || null == p) {
				break;
			}

			if (!c.isPlayer()) {
				// 自分の駒でないです。
				break;
			}
			if (c.isBoard()) {
				// 盤上の駒です。
				break;
			}
			if (isChessmen(b, p)) {
				// 既に駒が存在します。
				break;
			}

			if (is2Pawn(b, c, p)) {
				// 2歩
				break;
			}

			result = true;
		} while (false);
		return result;
	}

	public static ChessBoardEntity putChessmen(final ChessBoardEntity b, final ChessmenEntity c, final PositionEntity p) {
		ChessBoardEntity board = null;
		if (isPutChessmen(b, c, p)) {
			List<ChessmenEntity> chessmens = new ArrayList<ChessmenEntity>();
			for (ChessmenEntity chessmen : b.getChessmens()) {
				if (chessmen.getId() == c.getId()) {
					chessmens.add(new ChessmenEntity(chessmen.getId(), chessmen.getType(), new PositionEntity(p), chessmen.isPlayer(), chessmen
							.isBoard(), chessmen.isPromote()));
				} else {
					chessmens.add(new ChessmenEntity(chessmen));
				}
			}
			board = new ChessBoardEntity(chessmens);
		}
		return board;
	}

	/**
	 * 盤視点で指定位置に駒が存在するか判断します。
	 * 
	 * @param board 盤
	 * @param x X位置
	 * @param y Y位置
	 * @return 駒が存在する場合、<code>true</code>を返す。
	 */
	private static boolean isChessmen(final ChessBoardEntity board, final int x, final int y) {
		boolean result = false;
		List<ChessmenEntity> chessmens = board.getChessmens();
		for (ChessmenEntity c : chessmens) {
			if (x == c.getPosition().getX() && y == c.getPosition().getY()) {
				result = true;
				break;
			}
		}
		return result;
	}

	/**
	 * 盤視点で指定位置に存在する駒を取得します。
	 * 
	 * @param 盤
	 * @param x X位置
	 * @param y Y位置
	 * @return 駒。存在するしない場合、<code>null</code>を返す。
	 */
	private static final ChessmenEntity getChessmen(final ChessBoardEntity board, final int x, final int y) {
		ChessmenEntity result = null;
		List<ChessmenEntity> chessmens = board.getChessmens();
		for (ChessmenEntity c : chessmens) {
			if (x == c.getPosition().getX() && y == c.getPosition().getY()) {
				result = c;
				break;
			}
		}
		return result;
	}

	private static boolean is2Pawn(final ChessBoardEntity board, final ChessmenEntity c, final PositionEntity p) {
		boolean result = false;
		for (int y = 0; y < 9; y++) {
			ChessmenEntity cto = getChessmen(board, p.getX(), y);
			if (null != cto) {
				if (cto.isPlayer() && Type.Pawn == cto.getType() && !cto.isPromote()) {
					result = true;
					break;
				}
			}
		}
		return result;
	}

	private static boolean isSkipMove(final ChessBoardEntity board, final ChessmenEntity c, final PositionEntity p) {
		boolean result = false;
		do {
			int fromX = c.getPosition().getX();
			int fromY = c.getPosition().getY();
			int toX = p.getX();
			int toY = p.getY();

			if (Type.Lance == c.getType()) {
				int y = fromY - 1;
				while (y > toY) {
					if (isChessmen(board, fromX, y)) {
						// "移動途中に駒が存在します。";
						break;
					}
					y--;
				}
			} else if (Type.Rook == c.getType()) {
				if (fromY > toY) {
					int y = fromY - 1;
					while (toY < y) {
						if (isChessmen(board, toX, y)) {
							// "移動途中に駒が存在します。"
							break;
						}
						y--;
					}
				} else if (fromY < toY) {
					int y = fromY + 1;
					while (toY > y) {
						if (isChessmen(board, toX, y)) {
							// "移動途中に駒が存在します。"
							break;
						}
						y++;
					}
				} else if (fromX < toX) {
					int x = fromX + 1;
					while (toX > x) {
						if (isChessmen(board, x, toY)) {
							// "移動途中に駒が存在します。"
							break;
						}
						x++;
					}
				} else if (fromX > toX) {
					int x = fromX - 1;
					while (toX < x) {
						if (isChessmen(board, x, toY)) {
							// "移動途中に駒が存在します。"
							break;
						}
						x--;
					}
				}
			} else if (Type.Bishop == c.getType()) {
				if (fromY > toY && fromX < toX) {
					int x = fromX + 1;
					int y = fromY - 1;
					while (toX > x && toY < y) {
						if (isChessmen(board, x, y)) {
							// throw new CommandException(aPlayer,
							// "移動途中に駒が存在します。");
							break;
						}
						x++;
						y--;
					}
				} else if (fromY > toY && fromX > toX) {
					int x = fromX - 1;
					int y = fromY - 1;
					while (toX < x && toY < y) {
						if (isChessmen(board, y, y)) {
							// throw new CommandException(aPlayer,
							// "移動途中に駒が存在します。");
							break;
						}
						x--;
						y--;
					}
				} else if (fromY < toY && fromX < toX) {
					int x = fromX + 1;
					int y = fromY + 1;
					while (toX > x && toY > y) {
						if (isChessmen(board, x, y)) {
							// throw new CommandException(aPlayer,
							// "移動途中に駒が存在します。");
							break;
						}
						x++;
						y++;
					}
				} else if (fromY < toY && fromX > toX) {
					int x = fromX - 1;
					int y = fromY + 1;
					while (toX < x && toY > y) {
						if (isChessmen(board, x, y)) {
							// throw new CommandException(aPlayer,
							// "移動途中に駒が存在します。");
							break;
						}
						x--;
						y++;
					}
				}
			}

			result = true;
		} while (false);
		return result;
	}
}
