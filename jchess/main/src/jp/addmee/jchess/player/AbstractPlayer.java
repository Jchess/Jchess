package jp.addmee.jchess.player;

import java.util.List;

import jp.addmee.jchess.command.Command;
import jp.addmee.jchess.entity.ChessBoardEntity;
import jp.addmee.jchess.entity.ChessmenEntity;
import jp.addmee.jchess.entity.JchessEntity;
import jp.addmee.jchess.entity.PositionEntity;
import jp.addmee.jchess.util.JchessUtility;

/**
 * ���̃N���X�́A�v���C���[�@�\������������N���X�ł��B
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
	 * �������������s���܂��B
	 */
	protected abstract void doInitialize();

	/**
	 * ����������s���܂��B
	 */
	protected abstract void doDestroy();

	/**
	 * �������w���܂��B
	 * 
	 * @param jchess �������
	 * @return �R�}���h���
	 */
	protected abstract Command doPlay();

	/**
	 * �Տ����擾���܂��B
	 * 
	 * @return �Տ��
	 */
	protected final ChessBoardEntity getBoard() {
		return jchess.getBoard();
	}

	/**
	 * �����̋�̈ꗗ���擾���܂��B
	 * 
	 * @return ��ꗗ
	 */
	protected final List<ChessmenEntity> getMyChessmens() {
		return JchessUtility.getMyChessmens(jchess.getBoard());
	}

	/**
	 * �����̔Տ��̈ꗗ���擾���܂��B
	 * 
	 * @return ��ꗗ
	 */
	protected final List<ChessmenEntity> getMyBoardChessmens() {
		return JchessUtility.getMyBoardChessmens(jchess.getBoard());
	}

	/**
	 * �����̎�����̈ꗗ���擾���܂��B
	 * 
	 * @return ��ꗗ
	 */
	protected final List<ChessmenEntity> getMyStockChessmens() {
		return JchessUtility.getMyStockChessmens(jchess.getBoard());
	}

	/**
	 * �w��ʒu�ɋ���݂��邩���f���܂��B
	 * 
	 * @param p �ʒu
	 * @return ����݂���ꍇ�A<code>true</code>��Ԃ��B
	 */
	protected final boolean isChessmen(final PositionEntity p) {
		return JchessUtility.isChessmen(jchess.getBoard(), p);
	}

	/**
	 * �w��ʒu�ɑ��݂������擾���܂��B
	 * 
	 * @param p �ʒu
	 * @return ��B���݂��邵�Ȃ��ꍇ�A<code>null</code>��Ԃ��B
	 */
	protected final ChessmenEntity getChessmen(final PositionEntity p) {
		return JchessUtility.getChessmen(jchess.getBoard(), p);
	}

	/**
	 * �w��ʒu�Ɏ����̋���݂��邩���f���܂��B
	 * 
	 * @param p �ʒu
	 * @return �����̋���݂���ꍇ�A<code>true</code>��Ԃ��B
	 */
	protected final boolean isMyChessmen(final PositionEntity p) {
		return JchessUtility.isMyChessmen(jchess.getBoard(), p);
	}

	/**
	 * �w��ʒu�ɑ��݂��鎩���̋���擾���܂��B
	 * 
	 * @param p �ʒu
	 * @return ��B���݂��邵�Ȃ��ꍇ�܂��͑���̋�̏ꍇ�A<code>null</code>��Ԃ��B
	 */
	protected final ChessmenEntity getMyChessmen(final PositionEntity p) {
		return JchessUtility.getMyChessmen(jchess.getBoard(), p);
	}

	/**
	 * �w��̋�ړ��\�Ȉʒu�̈ꗗ���擾���܂��B
	 * 
	 * @param c ��
	 * @return �ʒu�ꗗ
	 */
	protected List<PositionEntity> getMovePositions(final ChessmenEntity c) {
		return JchessUtility.getMovePositions(jchess.getBoard(), c);
	}

	/**
	 * �w��ʒu�ɋ���ړ��o���邩���f���܂��B
	 * 
	 * @param c ��
	 * @param p �ړ��ʒu
	 * @return �ړ��\�ȏꍇ�A<code>true</code>��Ԃ��B
	 */
	protected final boolean isMoveChessmen(final ChessmenEntity c, final PositionEntity p) {
		return isMoveChessmen(c, p, false);
	}

	/**
	 * �w��ʒu�ɋ���ړ��o���邩���f���܂��B
	 * 
	 * @param c ��
	 * @param p �ړ��ʒu
	 * @param promote ����
	 * @return �ړ��\�ȏꍇ�A<code>true</code>��Ԃ��B
	 */
	protected final boolean isMoveChessmen(final ChessmenEntity c, final PositionEntity p, final boolean promote) {
		return JchessUtility.isMoveChessmen(jchess.getBoard(), c, p, promote);
	}

	/**
	 * �w��ʒu�Ɏ������u���邩���f���܂��B
	 * 
	 * @param c ��
	 * @param p �u���ʒu
	 * @return �u���\�ȏꍇ�A<code>true</code>��Ԃ��B
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
		s.append("����").append(crlf);
		s.append(" [");
		for (ChessmenEntity c : chessmens) {
			if (!c.isPlayer() && !c.isBoard()) {
				s.append(c.getType().getCode());
			}
		}
		s.append("]").append(crlf);
		s.append("  9   8   7   6   5   4   3   2   1  ").append(crlf);
		s.append("��������������������������������������������������������������������������").append(crlf);
		for (int y = 0; y < 9; y++) {
			s.append("��");
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
				s.append("��");
			}
			s.append(new Character((char) ('A' + y)));
			s.append(crlf);
		}
		s.append("��������������������������������������������������������������������������").append(crlf);
		s.append("����").append(crlf);
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
