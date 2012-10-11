package jp.addmee.jchess.rule;

import jp.addmee.jchess.entity.ChessmenEntity.Type;

/**
 * ���̃N���X�́A�����̃��[�����`�����N���X�ł��B
 * 
 * @since 1.0.0
 * @version 1.0.0 2012/10/03
 * @author Kawakicchi
 */
public final class JchessRule {

	/**
	 * �R���X�g���N�^
	 * <p>
	 * �C���X�^���X�������֎~
	 * </p>
	 */
	private JchessRule() {

	}

	/**
	 * ��ړ��o����L���Ȉʒu�����f���܂��B
	 * 
	 * @param type �^�C�v
	 * @param x X�ړ�
	 * @param y Y�ړ�
	 * @param promote ����
	 * @return �ړ��\�ȏꍇ�A<code>true</code>��Ԃ��B
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
	 * ��ړ��o����L���Ȉʒu�����f���܂��B
	 * <p>
	 * <p>
	 * <table cellspacing="0">
	 * <tr>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * ��</td>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * ��</td>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * ��</td>
	 * </tr>
	 * <tr>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * ��</td>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * ��</td>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * ��</td>
	 * </tr>
	 * <tr>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * ��</td>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * ��</td>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * ��</td>
	 * </tr>
	 * </table>
	 * </p>
	 * <p>
	 * 
	 * @param x X�ړ�
	 * @param y Y�ړ�
	 * @param promote ����
	 * @return �ړ��\�ȏꍇ�A<code>true</code>��Ԃ��B
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
	 * ��ړ��o����L���Ȉʒu�����f���܂��B
	 * <p>
	 * <p>
	 * <table cellspacing="0">
	 * <tr>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * </td>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * ��</td>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * </td>
	 * </tr>
	 * <tr>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * ��</td>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * ��</td>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * ��</td>
	 * </tr>
	 * <tr>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * </td>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * ��</td>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * </td>
	 * </tr>
	 * </table>
	 * </p>
	 * <p>
	 * 
	 * @param x X�ړ�
	 * @param y Y�ړ�
	 * @param promote ����
	 * @return �ړ��\�ȏꍇ�A<code>true</code>��Ԃ��B
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
	 * ��ړ��o����L���Ȉʒu�����f���܂��B
	 * <p>
	 * <p>
	 * <table cellspacing="0">
	 * <tr>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * ��</td>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * </td>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * ��</td>
	 * </tr>
	 * <tr>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * </td>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * �p</td>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * </td>
	 * </tr>
	 * <tr>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * ��</td>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * </td>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * ��</td>
	 * </tr>
	 * </table>
	 * </p>
	 * <p>
	 * 
	 * @param x X�ړ�
	 * @param y Y�ړ�
	 * @param promote ����
	 * @return �ړ��\�ȏꍇ�A<code>true</code>��Ԃ��B
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
	 * ��ړ��o����L���Ȉʒu�����f���܂��B
	 * <p>
	 * <p>
	 * <table cellspacing="0">
	 * <tr>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * ��</td>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * ��</td>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * ��</td>
	 * </tr>
	 * <tr>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * ��</td>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * ��</td>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * ��</td>
	 * </tr>
	 * <tr>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * </td>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * ��</td>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * </td>
	 * </tr>
	 * </table>
	 * </p>
	 * <p>
	 * 
	 * @param x X�ړ�
	 * @param y Y�ړ�
	 * @param promote ����
	 * @return �ړ��\�ȏꍇ�A<code>true</code>��Ԃ��B
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
	 * ��ړ��o����L���Ȉʒu�����f���܂��B
	 * <p>
	 * <p>
	 * <table cellspacing="0">
	 * <tr>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * ��</td>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * ��</td>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * ��</td>
	 * </tr>
	 * <tr>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * </td>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * ��</td>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * </td>
	 * </tr>
	 * <tr>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * ��</td>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * </td>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * ��</td>
	 * </tr>
	 * </table>
	 * </p>
	 * <p>
	 * 
	 * @param x X�ړ�
	 * @param y Y�ړ�
	 * @param promote ����
	 * @return �ړ��\�ȏꍇ�A<code>true</code>��Ԃ��B
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
	 * ��ړ��o����L���Ȉʒu�����f���܂��B
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
	 * �n</td>
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
	 * @param x X�ړ�
	 * @param y Y�ړ�
	 * @param promote ����
	 * @return �ړ��\�ȏꍇ�A<code>true</code>��Ԃ��B
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
	 * ��ړ��o����L���Ȉʒu�����f���܂��B
	 * <p>
	 * <p>
	 * <table cellspacing="0">
	 * <tr>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * </td>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * ��</td>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * </td>
	 * </tr>
	 * <tr>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * </td>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * ��</td>
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
	 * @param x X�ړ�
	 * @param y Y�ړ�
	 * @param promote ����
	 * @return �ړ��\�ȏꍇ�A<code>true</code>��Ԃ��B
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
	 * ��ړ��o����L���Ȉʒu�����f���܂��B
	 * <p>
	 * <p>
	 * <table cellspacing="0">
	 * <tr>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * </td>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * ��</td>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * </td>
	 * </tr>
	 * <tr>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * </td>
	 * <td style="border: solid 1px; text-align: center; width: 20px; height: 20px;">
	 * ��</td>
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
	 * @param x X�ړ�
	 * @param y Y�ړ�
	 * @param promote ����
	 * @return �ړ��\�ȏꍇ�A<code>true</code>��Ԃ��B
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
