package jp.addmee.jchess.entity;

/**
 * ���̃N���X�́A��������ێ�����N���X�ł��B
 * 
 * @since 1.0.0
 * @version 1.0.0 2012/09/30
 * @author Kawakicchi
 */
public final class JchessEntity {

	/**
	 * ������
	 */
	private ChessBoardEntity board;

	/**
	 * �R���X�g���N�^
	 * 
	 * @param aBoard �����Տ��
	 */
	public JchessEntity(final ChessBoardEntity aBoard) {
		board = aBoard;
	}

	/**
	 * �����Տ����擾���܂��B
	 * 
	 * @return ������
	 */
	public ChessBoardEntity getBoard() {
		return board;
	}

}
