package jp.addmee.jchess.command;

import jp.addmee.jchess.entity.ChessmenEntity;
import jp.addmee.jchess.entity.PositionEntity;

/**
 * ���̃N���X�́A�����̃R�}���h�@�\������������N���X�ł��B
 * 
 * @since 1.0.0
 * @version 1.0.0 2012/09/29
 * @author Kawakicchi
 */
public class AbstractCommand implements Command {

	/**
	 * ��
	 */
	private ChessmenEntity chessmen;

	/**
	 * �ʒu
	 */
	private PositionEntity pos;

	/**
	 * ����
	 */
	private boolean promote;

	/**
	 * ����
	 */
	private boolean giveup;

	/**
	 * �R���X�g���N�^
	 * 
	 * @param aChessmen �Ώۋ�
	 * @param aPosition �ړ���
	 * @param aPromote ����
	 * @param aGiveup ����
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
