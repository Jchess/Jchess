package jp.addmee.jchess.entity;

/**
 * ���̃N���X�́A���������ێ�����N���X�ł��B
 * 
 * @since 1.0.0
 * @version 1.0.0 2012/09/30
 * @author Kawakicchi
 */
public final class ChessmenEntity {

	/**
	 * ����Enum�́A��̎�ނ�\������Enum�ł��B
	 * 
	 * @since 1.0.0
	 * @version 1.0.0 2012/10/02
	 * @author Kawakicchi
	 */
	public enum Type {
		/** ����(K) */
		King("K", "����"),
		/** ���(R) */
		Rook("R", "���"),
		/** �p�s(B) */
		Bishop("B", "�p�s"),
		/** ����(G) */
		Gold("G", "����"),
		/** �⏫(S) */
		Silver("S", "�⏫"),
		/** �j�n(N) */
		Knight("N", "�j�n"),
		/** ����(L) */
		Lance("L", "����"),
		/** ��(P) */
		Pawn("P", "��");

		/**
		 * code
		 */
		private String code;

		/**
		 * name
		 */
		private String name;

		/**
		 * �R���X�g���N�^
		 * 
		 * @param aCode code
		 * @param aName name
		 */
		private Type(final String aCode, final String aName) {
			code = aCode;
			name = aName;
		}

		/**
		 * get code
		 * 
		 * @return code
		 */
		public String getCode() {
			return code;
		}

		/**
		 * get name
		 * 
		 * @return name
		 */
		public String getName() {
			return name;
		}
	}

	/**
	 * id
	 */
	private int id;

	/**
	 * ����
	 */
	private Type type;

	/**
	 * �ʒu���
	 */
	private PositionEntity position;

	/**
	 * ����t���O
	 */
	private boolean player;

	/**
	 * �Տ�t���O
	 */
	private boolean board;

	/**
	 * ����t���O
	 */
	private boolean promote;

	/**
	 * �R���X�g���N�^
	 * 
	 * @param aId ��ID
	 * @param aType ����
	 * @param aPosition �ʒu���
	 * @param aPlayer ����t���O
	 * @param aBoard �Տ�t���O
	 * @param aPromote ����t���O
	 */
	public ChessmenEntity(final int aId, final Type aType, final PositionEntity aPosition, final boolean aPlayer, final boolean aBoard,
			final boolean aPromote) {
		id = aId;
		player = aPlayer;
		board = aBoard;
		position = aPosition;
		type = aType;
		promote = aPromote;
	}

	public ChessmenEntity(final ChessmenEntity chessmen) {
		id = chessmen.getId();
		player = chessmen.isPlayer();
		board = chessmen.isBoard();
		position = new PositionEntity(chessmen.getPosition());
		type = chessmen.getType();
		promote = chessmen.isPromote();
	}

	/**
	 * ID���擾����B
	 * 
	 * @return ID
	 */
	public int getId() {
		return id;
	}

	/**
	 * �����̋���f����B
	 * 
	 * @return �����̋�̏ꍇ�A<code>true</code>��Ԃ��B
	 */
	public boolean isPlayer() {
		return player;
	}

	/**
	 * ��Տ�ɂ��邩�𔻒f����B
	 * 
	 * @return �Տ�̏ꍇ�A<code>true</code>��Ԃ��B
	 */
	public boolean isBoard() {
		return board;
	}

	/**
	 * ��̈ʒu�����擾����B
	 * 
	 * @return �ʒu���
	 */
	public PositionEntity getPosition() {
		return position;
	}

	/**
	 * ��̎�ނ��擾����B
	 * 
	 * @return ���
	 */
	public Type getType() {
		return type;
	}

	/**
	 * ����肩���f����B
	 * 
	 * @return �����̏ꍇ�A<code>true</code>��Ԃ��B
	 */
	public boolean isPromote() {
		return promote;
	}
}
