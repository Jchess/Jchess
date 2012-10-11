package jp.addmee.jchess.command;

import jp.addmee.jchess.entity.ChessmenEntity;
import jp.addmee.jchess.entity.PositionEntity;

/**
 * ���̃N���X�́A���u���R�}���h�N���X�ł��B
 * 
 * @since 1.0.0
 * @version 1.0.0 2012/10/04
 * @author Kawakicchi
 */
public class PutCommand extends AbstractCommand {

	/**
	 * �R���X�g���N�^
	 * 
	 * @param chessmen �u����
	 * @param position �u���ʒu
	 */
	public PutCommand(final ChessmenEntity chessmen, final PositionEntity position) {
		super(chessmen, position, false, false);
	}

}
