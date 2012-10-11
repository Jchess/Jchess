package jp.addmee.jchess.util;

import java.util.ArrayList;
import java.util.List;

import jp.addmee.jchess.entity.ChessBoardEntity;
import jp.addmee.jchess.entity.ChessmenEntity;
import jp.addmee.jchess.entity.ChessmenEntity.Type;
import jp.addmee.jchess.entity.PositionEntity;
import jp.addmee.jchess.rule.JchessRule;

/**
 * ���̃N���X�́A�����̃��[�e�B���e�B��񋟂���N���X�ł��B
 * 
 * @since 1.0.0
 * @version 1.0.0 2012/10/04
 * @author Kawakicchi
 */
public final class JchessUtility {

	/**
	 * �R���X�g���N�^
	 * <p>
	 * �C���X�^���X�������֎~
	 * </p>
	 */
	private JchessUtility() {

	}

	/**
	 * �Տ����R�s�[���܂��B
	 * 
	 * @param aBoard �R�s�[���Տ��
	 * @return �Տ��
	 */
	public static ChessBoardEntity copyBoard(final ChessBoardEntity aBoard) {
		return copyBoard(aBoard, false);
	}

	/**
	 * �Տ����R�s�[���܂��B
	 * <p>
	 * ���]���s���ƁA�v���C���[���_�𔽓]������ԂŃR�s�[���܂��B
	 * </p>
	 * 
	 * @param aBoard �R�s�[���Տ��
	 * @param aReverse ���]
	 * @return �Տ��
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
	 * �ʒu�����R�s�[���܂��B
	 * 
	 * @param aPosition �R�s�[���ʒu���
	 * @return �ʒu���
	 */
	public static PositionEntity copyPosition(final PositionEntity aPosition) {
		return copyPosition(aPosition, false);
	}

	/**
	 * �ʒu�����R�s�[���܂��B
	 * <p>
	 * ���]���s���ƁA�v���C���[���_�𔽓]������ԂŃR�s�[���܂��B
	 * </p>
	 * 
	 * @param aPosition �R�s�[���ʒu���
	 * @param aReverse ���]
	 * @return �ʒu���
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
	 * �v���C���[���R�s�[���܂��B
	 * 
	 * @param aPlayer �R�s�[���v���C���[
	 * @return �v���C���[
	 */
	public static boolean copyPlayer(final boolean aPlayer) {
		return copyPlayer(aPlayer, false);
	}

	/**
	 * �v���C���[���R�s�[���܂��B
	 * <p>
	 * ���]���s���ƁA�v���C���[���_�𔽓]������ԂŃR�s�[���܂��B
	 * </p>
	 * 
	 * @param aPlayer �R�s�[���v���C���[
	 * @param aReverse ���]
	 * @return �v���C���[
	 */
	public static boolean copyPlayer(final boolean aPlayer, final boolean aReverse) {
		if (aReverse) {
			return !(aPlayer);
		} else {
			return (aPlayer);
		}
	}

	/**
	 * �Վ��_�Ŏ���ƂȂ��̈ꗗ���擾���܂��B
	 * 
	 * @param aBoard �Տ��
	 * @return ��ꗗ
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
	 * �Վ��_�Ŏ���ƂȂ�Տ��̈ꗗ���擾���܂��B
	 * 
	 * @param aBoard �Տ��
	 * @return ��ꗗ
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
	 * �Վ��_�Ŏ���ƂȂ鎝����̈ꗗ���擾���܂��B
	 * 
	 * @param aBoard �Տ��
	 * @return ��ꗗ
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
	 * �Տ�̎w��ʒu�ɋ���݂��邩���f���܂��B
	 * 
	 * @param aBoard �Տ��
	 * @param p �ʒu
	 * @return ����݂���ꍇ�A<code>true</code>��Ԃ��B
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
	 * �Տ�̎w��ʒu�ɑ��݂������擾���܂��B
	 * 
	 * @param aBoard �Տ��
	 * @param p �ʒu
	 * @return ��B���݂��邵�Ȃ��ꍇ�A<code>null</code>��Ԃ��B
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
	 * �w��ʒu�ɔՎ��_�Ŏ���ƂȂ����݂��邩���f���܂��B
	 * 
	 * @param aBoard �Տ��
	 * @param p �ʒu
	 * @return �����̋���݂���ꍇ�A<code>true</code>��Ԃ��B
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
	 * �w��ʒu�ɑ��݂���Վ��_�Ŏ���ƂȂ����擾���܂��B
	 * 
	 * @param aBoard �Տ��
	 * @param p �ʒu
	 * @return ��B���݂��邵�Ȃ��ꍇ�܂��͑���̋�̏ꍇ�A<code>null</code>��Ԃ��B
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
	 * �w��̋�ړ��\�Ȉʒu�̈ꗗ���擾���܂��B
	 * 
	 * @param b ��
	 * @param c ��
	 * @return �ʒu�ꗗ
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
	 * �w��ʒu�ɋ���ړ��o���邩���f���܂��B
	 * 
	 * @param b ��
	 * @param c ��
	 * @param p �ړ��ʒu
	 * @param promote ����
	 * @return �ړ��\�ȏꍇ�A<code>true</code>��Ԃ��B
	 */
	public static boolean isMoveChessmen(final ChessBoardEntity b, final ChessmenEntity c, final PositionEntity p, final boolean promote) {
		boolean result = false;
		do {
			if (null == c || null == p) {
				break;
			}

			if (!c.isPlayer()) {
				// ����̋�𑀍삵�悤�Ƃ��܂����B
				break;
			}
			if (!c.isBoard()) {
				// �Տ�̋�ł͂���܂���B
				break;
			}
			if (0 > p.getX() || 9 <= p.getX() || 0 > p.getY() || 9 <= p.getY()) {
				// �Ք͈͊O���w�肳��܂����B
				break;
			}
			if (!JchessRule.isMove(c.getType(), p.getX() - c.getPosition().getX(), p.getY() - c.getPosition().getY(), c.isPromote())) {
				// ���̋�ł͈ړ��o���Ȃ��ʒu���w�肳��܂����B
				break;
			}
			if (!isSkipMove(b, c, p)) {
				// �ړ��r���ɋ���݂��܂��B
				break;
			}

			ChessmenEntity cto = getChessmen(b, p);
			if (null != cto) {
				if (cto.isPlayer()) {
					// ���̈ʒu�ɂ͊��Ɏ�����݂��܂��B
					break;
				}
			}

			if (promote) {
				if (2 < p.getY()) {
					// ���̏ꏊ�ł͐��邱�Ƃ͏o���܂���B
					break;
				}
				if (c.isPromote()) {
					// ���ɐ����Ă��܂��B
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
	 * �w��ʒu�Ɏ������u���邩���f���܂��B
	 * 
	 * @param b ��
	 * @param c ��
	 * @param p �u���ʒu
	 * @return �u���\�ȏꍇ�A<code>true</code>��Ԃ��B
	 */
	public static boolean isPutChessmen(final ChessBoardEntity b, final ChessmenEntity c, final PositionEntity p) {
		boolean result = false;
		do {
			if (null == c || null == p) {
				break;
			}

			if (!c.isPlayer()) {
				// �����̋�łȂ��ł��B
				break;
			}
			if (c.isBoard()) {
				// �Տ�̋�ł��B
				break;
			}
			if (isChessmen(b, p)) {
				// ���ɋ���݂��܂��B
				break;
			}

			if (is2Pawn(b, c, p)) {
				// 2��
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
	 * �Վ��_�Ŏw��ʒu�ɋ���݂��邩���f���܂��B
	 * 
	 * @param board ��
	 * @param x X�ʒu
	 * @param y Y�ʒu
	 * @return ����݂���ꍇ�A<code>true</code>��Ԃ��B
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
	 * �Վ��_�Ŏw��ʒu�ɑ��݂������擾���܂��B
	 * 
	 * @param ��
	 * @param x X�ʒu
	 * @param y Y�ʒu
	 * @return ��B���݂��邵�Ȃ��ꍇ�A<code>null</code>��Ԃ��B
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
						// "�ړ��r���ɋ���݂��܂��B";
						break;
					}
					y--;
				}
			} else if (Type.Rook == c.getType()) {
				if (fromY > toY) {
					int y = fromY - 1;
					while (toY < y) {
						if (isChessmen(board, toX, y)) {
							// "�ړ��r���ɋ���݂��܂��B"
							break;
						}
						y--;
					}
				} else if (fromY < toY) {
					int y = fromY + 1;
					while (toY > y) {
						if (isChessmen(board, toX, y)) {
							// "�ړ��r���ɋ���݂��܂��B"
							break;
						}
						y++;
					}
				} else if (fromX < toX) {
					int x = fromX + 1;
					while (toX > x) {
						if (isChessmen(board, x, toY)) {
							// "�ړ��r���ɋ���݂��܂��B"
							break;
						}
						x++;
					}
				} else if (fromX > toX) {
					int x = fromX - 1;
					while (toX < x) {
						if (isChessmen(board, x, toY)) {
							// "�ړ��r���ɋ���݂��܂��B"
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
							// "�ړ��r���ɋ���݂��܂��B");
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
							// "�ړ��r���ɋ���݂��܂��B");
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
							// "�ړ��r���ɋ���݂��܂��B");
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
							// "�ړ��r���ɋ���݂��܂��B");
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
