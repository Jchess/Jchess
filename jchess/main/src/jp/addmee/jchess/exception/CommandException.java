package jp.addmee.jchess.exception;

/**
 * ���̃N���X�́A�R�}���h���s���̗�O��\�������N���X�ł��B
 * 
 * @since 1.0.0
 * @version 1.0.0 2012/09/30
 * @author Kawakicchi
 */
public class CommandException extends Exception {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 7726277016833841022L;

	/**
	 * player
	 */
	private int player;

	/**
	 * �R���X�g���N�^
	 * 
	 * @param aPlayer �v���C���[
	 * @param aMessage ���b�Z�[�W
	 */
	public CommandException(final int aPlayer, final String aMessage) {
		super(aMessage);
		player = aPlayer;
	}

	/**
	 * �v���C���[���擾���܂��B
	 * 
	 * @return �v���C���[
	 */
	public int getPlayer() {
		return player;
	}
}
