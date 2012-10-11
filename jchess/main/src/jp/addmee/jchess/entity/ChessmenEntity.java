package jp.addmee.jchess.entity;

/**
 * このクラスは、将棋駒情報を保持するクラスです。
 * 
 * @since 1.0.0
 * @version 1.0.0 2012/09/30
 * @author Kawakicchi
 */
public final class ChessmenEntity {

	/**
	 * このEnumは、駒の種類を表現するEnumです。
	 * 
	 * @since 1.0.0
	 * @version 1.0.0 2012/10/02
	 * @author Kawakicchi
	 */
	public enum Type {
		/** 王将(K) */
		King("K", "王将"),
		/** 飛車(R) */
		Rook("R", "飛車"),
		/** 角行(B) */
		Bishop("B", "角行"),
		/** 金将(G) */
		Gold("G", "金将"),
		/** 銀将(S) */
		Silver("S", "銀将"),
		/** 桂馬(N) */
		Knight("N", "桂馬"),
		/** 香車(L) */
		Lance("L", "香車"),
		/** 歩(P) */
		Pawn("P", "歩");

		/**
		 * code
		 */
		private String code;

		/**
		 * name
		 */
		private String name;

		/**
		 * コンストラクタ
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
	 * 駒種類
	 */
	private Type type;

	/**
	 * 位置情報
	 */
	private PositionEntity position;

	/**
	 * 自駒フラグ
	 */
	private boolean player;

	/**
	 * 盤上フラグ
	 */
	private boolean board;

	/**
	 * 成りフラグ
	 */
	private boolean promote;

	/**
	 * コンストラクタ
	 * 
	 * @param aId 駒ID
	 * @param aType 駒種類
	 * @param aPosition 位置情報
	 * @param aPlayer 自駒フラグ
	 * @param aBoard 盤上フラグ
	 * @param aPromote 成りフラグ
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
	 * IDを取得する。
	 * 
	 * @return ID
	 */
	public int getId() {
		return id;
	}

	/**
	 * 自分の駒か判断する。
	 * 
	 * @return 自分の駒の場合、<code>true</code>を返す。
	 */
	public boolean isPlayer() {
		return player;
	}

	/**
	 * 駒が盤上にあるかを判断する。
	 * 
	 * @return 盤上の場合、<code>true</code>を返す。
	 */
	public boolean isBoard() {
		return board;
	}

	/**
	 * 駒の位置情報を取得する。
	 * 
	 * @return 位置情報
	 */
	public PositionEntity getPosition() {
		return position;
	}

	/**
	 * 駒の種類を取得する。
	 * 
	 * @return 種類
	 */
	public Type getType() {
		return type;
	}

	/**
	 * 駒が成りか判断する。
	 * 
	 * @return 駒が成りの場合、<code>true</code>を返す。
	 */
	public boolean isPromote() {
		return promote;
	}
}
