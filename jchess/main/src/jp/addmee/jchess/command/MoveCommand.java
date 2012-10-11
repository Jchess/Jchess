package jp.addmee.jchess.command;

import jp.addmee.jchess.entity.ChessmenEntity;
import jp.addmee.jchess.entity.PositionEntity;

/**
 * ���̃N���X�́A��̈ړ����s���R�}���h�N���X�ł��B
 * 
 * @since 1.0.0
 * @version 1.0.0 2012/10/04
 * @author Kawakicchi
 */
public class MoveCommand extends AbstractCommand {

	/**
	 * �R���X�g���N�^
	 * 
	 * @param chessmen ��ړ�
	 * @param position �ړ��ʒu
	 */
	public MoveCommand(final ChessmenEntity chessmen, final PositionEntity position) {
		super(chessmen, position, false, false);
	}

	/**
	 * �R���X�g���N�^
	 * 
	 * @param chessmen �ړ���
	 * @param position �ړ��ʒu
	 * @param promote ����
	 */
	public MoveCommand(final ChessmenEntity chessmen, final PositionEntity position, final boolean promote) {
		super(chessmen, position, promote, false);
	}

}
