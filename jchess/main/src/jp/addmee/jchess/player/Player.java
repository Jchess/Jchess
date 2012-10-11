package jp.addmee.jchess.player;

import jp.addmee.jchess.command.Command;
import jp.addmee.jchess.entity.JchessEntity;

/**
 * ���̃C���^�[�t�F�[�X�́A�v���C���[�@�\��\������C���^�[�t�F�[�X�ł��B
 * 
 * @since 1.0.0
 * @version 1.0.0 2012/09/29
 * @author Kawakicchi
 */
public interface Player {

	/**
	 * �v���C���[�����擾����B
	 * 
	 * @return �v���C���[��
	 */
	String getName();

	/**
	 * �������������s���܂��B
	 * 
	 */
	void initialize();

	/**
	 * ����������s���܂��B
	 * 
	 */
	void destroy();

	/**
	 * �������w���܂��B
	 * 
	 * @param jchess �������
	 * @return �R�}���h���
	 */
	Command play(final JchessEntity jchess);

}
