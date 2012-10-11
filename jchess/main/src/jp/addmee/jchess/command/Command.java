package jp.addmee.jchess.command;

import jp.addmee.jchess.entity.ChessmenEntity;
import jp.addmee.jchess.entity.PositionEntity;

/**
 * ���̃C���^�[�t�F�[�X�́A�����̃R�}���h�@�\��\������C���^�[�t�F�[�X�ł��B
 * 
 * @since 1.0.0
 * @version 1.0.0 2012/10/04
 * @author Kawakicchi
 */
public interface Command {

	/**
	 * ����擾����B
	 * 
	 * @return ��
	 */
	public ChessmenEntity getChessmen();

	/**
	 * �ʒu���擾����B
	 * 
	 * @return�@�ʒu
	 */
	public PositionEntity getPosition();

	/**
	 * ����𔻒f����B
	 * 
	 * @return ����
	 */
	public boolean isPromote();

	/**
	 * ���������f����B
	 * 
	 * @return ����
	 */
	public boolean isGiveup();

}
