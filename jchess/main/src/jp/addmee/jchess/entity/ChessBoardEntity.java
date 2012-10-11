package jp.addmee.jchess.entity;

import java.util.List;

/**
 * ���̃N���X�́A�����Տ���ێ�����N���X�ł��B
 * 
 * @since 1.0.0
 * @version 1.0.0 2012/09/30
 * @author Kawakicchi
 */
public final class ChessBoardEntity {

	/**
	 * ���񃊃X�g
	 */
	private List<ChessmenEntity> chessmens;

	/**
	 * �R���X�g���N�^
	 * 
	 * @param aChessmens ��X�g
	 */
	public ChessBoardEntity(final List<ChessmenEntity> aChessmens) {
		chessmens = aChessmens;
	}

	/**
	 * ���ׂĂ̋�����擾���܂��B
	 * 
	 * @return
	 */
	public List<ChessmenEntity> getChessmens() {
		return chessmens;
	}

}
