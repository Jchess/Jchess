package jp.addmee.jchess.rule;

import jp.addmee.jchess.entity.ChessmenEntity.Type;

/**
 * このクラスは、将棋のルールを定義したクラスです。
 * 
 * @since 1.0.0
 * @version 1.0.0 2012/10/03
 * @author Kawakicchi
 */
public final class JchessRule {

	/**
	 * コンストラクタ
	 * <p>
	 * インスタンス生成を禁止
	 * </p>
	 */
	private JchessRule() {

	}

	/**
	 * 駒が移動出来る有効な位置か判断します。
	 * 
	 * @param type タイプ
	 * @param x X移動
	 * @param y Y移動
	 * @param promote 成り
	 * @return 移動可能な場合、<code>true</code>を返す。
	 */
	public static boolean isMove(final Type type, final int x, final int y, final boolean promote) {
		if (0 == x && 0 == y)
			return false;
		if (Type.King == type) {
			return isMoveKing(x, y, promote);
		} else if (Type.Rook == type) {
			return isMoveRook(x, y, promote);
		} else if (Type.Bishop == type) {
			return isMoveBishop(x, y, promote);
		} else if (Type.Gold == type) {
			return isMoveGold(x, y, promote);
		} else if (Type.Silver == type) {
			return isMoveSilver(x, y, promote);
		} else if (Type.Knight == type) {
			return isMoveKnight(x, y, promote);
		} else if (Type.Lance == type) {
			return isMoveLance(x, y, promote);
		} else if (Type.Pawn == type) {
			return isMovePawn(x, y, promote);
		}
		return false;
	}

	/**
	 * 駒が移動出来る有効な位置か判断します。
	 * <p>
	 * <p>
	 * <table cellspacing="0">
	 * <tr>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * ↑</td>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * ↑</td>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * ↑</td>
	 * </tr>
	 * <tr>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * ↑</td>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * 王</td>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * ↑</td>
	 * </tr>
	 * <tr>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * ↑</td>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * ↑</td>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * ↑</td>
	 * </tr>
	 * </table>
	 * </p>
	 * <p>
	 * 
	 * @param x X移動
	 * @param y Y移動
	 * @param promote 成り
	 * @return 移動可能な場合、<code>true</code>を返す。
	 */
	public static boolean isMoveKing(final int x, final int y, final boolean promote) {
		if (-1 == x && -1 == y)
			return true;
		else if (0 == x && -1 == y)
			return true;
		else if (1 == x && -1 == y)
			return true;
		else if (-1 == x && 0 == y)
			return true;
		else if (1 == x && 0 == y)
			return true;
		else if (-1 == x && 1 == y)
			return true;
		else if (0 == x && 1 == y)
			return true;
		else if (1 == x && 1 == y)
			return true;
		else
			return false;
	}

	/**
	 * 駒が移動出来る有効な位置か判断します。
	 * <p>
	 * <p>
	 * <table cellspacing="0">
	 * <tr>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * </td>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * ↑</td>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * </td>
	 * </tr>
	 * <tr>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * ↑</td>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * 飛</td>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * ↑</td>
	 * </tr>
	 * <tr>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * </td>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * ↑</td>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * </td>
	 * </tr>
	 * </table>
	 * </p>
	 * <p>
	 * 
	 * @param x X移動
	 * @param y Y移動
	 * @param promote 成り
	 * @return 移動可能な場合、<code>true</code>を返す。
	 */
	public static boolean isMoveRook(final int x, final int y, final boolean promote) {
		if (0 == x && 0 != y)
			return true;
		else if (0 != x && 0 == y)
			return true;
		if (promote) {
			if (-1 == x && -1 == y)
				return true;
			else if (0 == x && -1 == y)
				return true;
			else if (1 == x && -1 == y)
				return true;
			else if (-1 == x && 0 == y)
				return true;
			else if (1 == x && 0 == y)
				return true;
			else if (-1 == x && 1 == y)
				return true;
			else if (0 == x && 1 == y)
				return true;
			else if (1 == x && 1 == y)
				return true;
		}
		return false;
	}

	/**
	 * 駒が移動出来る有効な位置か判断します。
	 * <p>
	 * <p>
	 * <table cellspacing="0">
	 * <tr>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * ↑</td>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * </td>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * ↑</td>
	 * </tr>
	 * <tr>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * </td>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * 角</td>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * </td>
	 * </tr>
	 * <tr>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * ↑</td>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * </td>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * ↑</td>
	 * </tr>
	 * </table>
	 * </p>
	 * <p>
	 * 
	 * @param x X移動
	 * @param y Y移動
	 * @param promote 成り
	 * @return 移動可能な場合、<code>true</code>を返す。
	 */
	public static boolean isMoveBishop(final int x, final int y, final boolean promote) {
		int bx = (0 > x) ? x * -1 : x;
		int by = (0 > y) ? y * -1 : y;
		if (bx == by)
			return true;
		if (promote) {
			if (-1 == x && -1 == y)
				return true;
			else if (0 == x && -1 == y)
				return true;
			else if (1 == x && -1 == y)
				return true;
			else if (-1 == x && 0 == y)
				return true;
			else if (1 == x && 0 == y)
				return true;
			else if (-1 == x && 1 == y)
				return true;
			else if (0 == x && 1 == y)
				return true;
			else if (1 == x && 1 == y)
				return true;
		}
		return false;
	}

	/**
	 * 駒が移動出来る有効な位置か判断します。
	 * <p>
	 * <p>
	 * <table cellspacing="0">
	 * <tr>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * ↑</td>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * ↑</td>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * ↑</td>
	 * </tr>
	 * <tr>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * ↑</td>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * 金</td>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * ↑</td>
	 * </tr>
	 * <tr>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * </td>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * ↑</td>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * </td>
	 * </tr>
	 * </table>
	 * </p>
	 * <p>
	 * 
	 * @param x X移動
	 * @param y Y移動
	 * @param promote 成り
	 * @return 移動可能な場合、<code>true</code>を返す。
	 */
	public static boolean isMoveGold(final int x, final int y, final boolean promote) {
		if (-1 == x && -1 == y)
			return true;
		else if (0 == x && -1 == y)
			return true;
		else if (1 == x && -1 == y)
			return true;
		else if (-1 == x && 0 == y)
			return true;
		else if (1 == x && 0 == y)
			return true;
		else if (0 == x && 1 == y)
			return true;
		return false;
	}

	/**
	 * 駒が移動出来る有効な位置か判断します。
	 * <p>
	 * <p>
	 * <table cellspacing="0">
	 * <tr>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * ↑</td>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * ↑</td>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * ↑</td>
	 * </tr>
	 * <tr>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * </td>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * 銀</td>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * </td>
	 * </tr>
	 * <tr>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * ↑</td>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * </td>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * ↑</td>
	 * </tr>
	 * </table>
	 * </p>
	 * <p>
	 * 
	 * @param x X移動
	 * @param y Y移動
	 * @param promote 成り
	 * @return 移動可能な場合、<code>true</code>を返す。
	 */
	public static boolean isMoveSilver(final int x, final int y, final boolean promote) {
		if (promote) {
			if (-1 == x && -1 == y)
				return true;
			else if (0 == x && -1 == y)
				return true;
			else if (1 == x && -1 == y)
				return true;
			else if (-1 == x && 0 == y)
				return true;
			else if (1 == x && 0 == y)
				return true;
			else if (0 == x && 1 == y)
				return true;
		} else {
			if (-1 == x && -1 == y)
				return true;
			else if (0 == x && -1 == y)
				return true;
			else if (1 == x && -1 == y)
				return true;
			else if (-1 == x && 1 == y)
				return true;
			else if (1 == x && 1 == y)
				return true;
		}
		return false;
	}

	/**
	 * 駒が移動出来る有効な位置か判断します。
	 * <p>
	 * <p>
	 * <table cellspacing="0">
	 * <tr>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * </td>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * </td>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * </td>
	 * </tr>
	 * <tr>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * </td>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * 馬</td>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * </td>
	 * </tr>
	 * <tr>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * </td>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * </td>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * </td>
	 * </tr>
	 * </table>
	 * </p>
	 * <p>
	 * 
	 * @param x X移動
	 * @param y Y移動
	 * @param promote 成り
	 * @return 移動可能な場合、<code>true</code>を返す。
	 */
	public static boolean isMoveKnight(final int x, final int y, final boolean promote) {
		if (promote) {
			if (-1 == x && -1 == y)
				return true;
			else if (0 == x && -1 == y)
				return true;
			else if (1 == x && -1 == y)
				return true;
			else if (-1 == x && 0 == y)
				return true;
			else if (1 == x && 0 == y)
				return true;
			else if (0 == x && 1 == y)
				return true;
		} else {
			if (-1 == x && -2 == y)
				return true;
			else if (1 == x && -2 == y)
				return true;
		}
		return false;
	}

	/**
	 * 駒が移動出来る有効な位置か判断します。
	 * <p>
	 * <p>
	 * <table cellspacing="0">
	 * <tr>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * </td>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * ↑</td>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * </td>
	 * </tr>
	 * <tr>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * </td>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * 香</td>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * </td>
	 * </tr>
	 * <tr>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * </td>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * </td>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * </td>
	 * </tr>
	 * </table>
	 * </p>
	 * <p>
	 * 
	 * @param x X移動
	 * @param y Y移動
	 * @param promote 成り
	 * @return 移動可能な場合、<code>true</code>を返す。
	 */
	public static boolean isMoveLance(final int x, final int y, final boolean promote) {
		if (promote) {
			if (-1 == x && -1 == y)
				return true;
			else if (0 == x && -1 == y)
				return true;
			else if (1 == x && -1 == y)
				return true;
			else if (-1 == x && 0 == y)
				return true;
			else if (1 == x && 0 == y)
				return true;
			else if (0 == x && 1 == y)
				return true;
		} else {
			if (0 == x && -1 >= y)
				return true;
		}
		return false;
	}

	/**
	 * 駒が移動出来る有効な位置か判断します。
	 * <p>
	 * <p>
	 * <table cellspacing="0">
	 * <tr>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * </td>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * ↑</td>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * </td>
	 * </tr>
	 * <tr>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * </td>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * 歩</td>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * </td>
	 * </tr>
	 * <tr>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * </td>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * </td>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * </td>
	 * </tr>
	 * </table>
	 * </p>
	 * <p>
	 * 
	 * @param x X移動
	 * @param y Y移動
	 * @param promote 成り
	 * @return 移動可能な場合、<code>true</code>を返す。
	 */
	public static boolean isMovePawn(final int x, final int y, final boolean promote) {
		if (promote) {
			if (-1 == x && -1 == y)
				return true;
			else if (0 == x && -1 == y)
				return true;
			else if (1 == x && -1 == y)
				return true;
			else if (-1 == x && 0 == y)
				return true;
			else if (1 == x && 0 == y)
				return true;
			else if (0 == x && 1 == y)
				return true;
		} else {
			if (0 == x && -1 == y)
				return true;
		}
		return false;
	}
}
