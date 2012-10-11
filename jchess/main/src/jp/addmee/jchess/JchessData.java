package jp.addmee.jchess;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.addmee.jchess.command.Command;
import jp.addmee.jchess.entity.ChessBoardEntity;
import jp.addmee.jchess.entity.ChessmenEntity;
import jp.addmee.jchess.entity.PositionEntity;
import jp.addmee.jchess.entity.ChessmenEntity.Type;
import jp.addmee.jchess.exception.CommandException;
import jp.addmee.jchess.rule.JchessRule;

/**
 * ���̃N���X�́A�����̔Տ����ێ������N���X�ł��B
 * 
 * @since 1.0.0
 * @version 1.0.0 2012/09/29
 * @author Kawakicchi
 */
public final class JchessData {

	/**
	 * max x
	 */
	private static int MAX_X = 9;

	/**
	 * max y
	 */
	private static int MAX_Y = 9;

	/**
	 * coma map
	 */
	private Map<Integer, ChessmenData> chessmens = new HashMap<Integer, JchessData.ChessmenData>();

	/**
	 * �R���X�g���N�^
	 */
	public JchessData() {
		chessmens = create();
	}

	/**
	 * �R�}���h�����s���܂��B
	 * 
	 * @param aPlayer �v���C���[
	 * @param aCommand �R�}���h
	 * @throws CommandException �R�}���h���s�Ɏ��s�����ꍇ
	 */
	public void command(final int aPlayer, final Command aCommand) throws CommandException {

		ChessmenEntity coma = aCommand.getChessmen();
		PositionEntity pos = aCommand.getPosition();
		if (coma.isPlayer()) {
			ChessmenData target = chessmens.get(coma.getId());
			int toX = pos.getX(); // �ړ��摊��X
			int toY = pos.getY(); // �ړ��摊��Y
			int toFixX = convertX(aPlayer, toX); // �ړ�����X
			int toFixY = convertY(aPlayer, toY); // �ړ�����Y
			// System.out.println("to=" + toX + ":" + toY);
			// System.out.println("toFix=" + toFixX + ":" + toFixY);

			if (0 > toFixX || MAX_X <= toFixX || 0 > toFixY || MAX_Y <= toFixY) {
				throw new CommandException(aPlayer, "�Ք͈͊O���w�肳��܂����B");
			}

			if (target.isBoard()) {
				int fromFixX = target.getFixX(); // �ړ������X
				int fromFixY = target.getFixY(); // �ړ������Y
				int fromX = convertX(aPlayer, fromFixX); // �ړ�������X
				int fromY = convertY(aPlayer, fromFixY); // �ړ�������Y
				// System.out.println("from=" + fromX + ":" + fromY);
				// System.out.println("fromFix=" + fromFixX + ":" + fromFixY);

				if (!JchessRule.isMove(target.getType(), toX - fromX, toY - fromY, target.isPromote())) {
					throw new CommandException(aPlayer, "���̋�ł͈ړ��o���Ȃ��ʒu���w�肳��܂����B");
				}

				if (Type.Lance == target.getType()) {
					int y = fromY - 1;
					while (y > toY) {
						if (isChessmen(fromX, y)) {
							throw new CommandException(aPlayer, "�ړ��r���ɋ���݂��܂��B");
						}
						y--;
					}
				} else if (Type.Rook == target.getType()) {
					if (fromY > toY) {
						int y = fromY - 1;
						while (toY < y) {
							if (isChessmen(aPlayer, toX, y)) {
								throw new CommandException(aPlayer, "�ړ��r���ɋ���݂��܂��B");
							}
							y--;
						}
					} else if (fromY < toY) {
						int y = fromY + 1;
						while (toY > y) {
							if (isChessmen(aPlayer, toX, y)) {
								throw new CommandException(aPlayer, "�ړ��r���ɋ���݂��܂��B");
							}
							y++;
						}
					} else if (fromX < toX) {
						int x = fromX + 1;
						while (toX > x) {
							if (isChessmen(aPlayer, x, toY)) {
								throw new CommandException(aPlayer, "�ړ��r���ɋ���݂��܂��B");
							}
							x++;
						}
					} else if (fromX > toX) {
						int x = fromX - 1;
						while (toX < x) {
							if (isChessmen(aPlayer, x, toY)) {
								throw new CommandException(aPlayer, "�ړ��r���ɋ���݂��܂��B");
							}
							x--;
						}
					}
				} else if (Type.Bishop == target.getType()) {
					if (fromY > toY && fromX < toX) {
						int x = fromX + 1;
						int y = fromY - 1;
						while (toX > x && toY < y) {
							if (isChessmen(aPlayer, x, y)) {
								throw new CommandException(aPlayer, "�ړ��r���ɋ���݂��܂��B");
							}
							x++;
							y--;
						}
					} else if (fromY > toY && fromX > toX) {
						int x = fromX - 1;
						int y = fromY - 1;
						while (toX < x && toY < y) {
							if (isChessmen(aPlayer, y, y)) {
								throw new CommandException(aPlayer, "�ړ��r���ɋ���݂��܂��B");
							}
							x--;
							y--;
						}
					} else if (fromY < toY && fromX < toX) {
						int x = fromX + 1;
						int y = fromY + 1;
						while (toX > x && toY > y) {
							if (isChessmen(aPlayer, x, y)) {
								throw new CommandException(aPlayer, "�ړ��r���ɋ���݂��܂��B");
							}
							x++;
							y++;
						}
					} else if (fromY < toY && fromX > toX) {
						int x = fromX - 1;
						int y = fromY + 1;
						while (toX < x && toY > y) {
							if (isChessmen(aPlayer, x, y)) {
								throw new CommandException(aPlayer, "�ړ��r���ɋ���݂��܂��B");
							}
							x--;
							y++;
						}
					}
				}

				ChessmenData toComa = getChessmen(toFixX, toFixY);
				if (null != toComa) {
					if (toComa.getPlayer() == aPlayer) {
						throw new CommandException(aPlayer, "���̈ʒu�ɂ͊��Ɏ�����݂��܂��B");
					}
					// ������ɂ���
					toComa.setPlayer(aPlayer);
					toComa.setBoard(false);
					toComa.setPromote(false);
					toComa.setFixX(-1);
					toComa.setFixY(-1);
				}

				// ��ړ�
				target.setFixX(toFixX);
				target.setFixY(toFixY);
				if (aCommand.isPromote()) {
					if (2 < toY) {
						throw new CommandException(aPlayer, "���̏ꏊ�ł͐��邱�Ƃ͏o���܂���B");
					}
					target.setPromote(true);
				}

			} else {
				if (isChessmen(toFixX, toFixY)) {
					throw new CommandException(aPlayer, "���ɋ�ł���Ă��܂��B");
				}

				// 2���`�F�b�N
				if (Type.Pawn == target.getType()) {
					for (int y = 0; y < MAX_Y; y++) {
						ChessmenData check = getChessmen(toFixX, y);
						if (null != check) {
							if (check.getPlayer() == aPlayer && Type.Pawn == check.getType() && !check.isPromote()) {
								throw new CommandException(aPlayer, "2�����ł���܂����B");
							}
						}
					}
				}

				// ��z�u
				target.setBoard(true);
				target.setPromote(false);
				target.setFixX(toFixX);
				target.setFixY(toFixY);
			}
		} else {
			throw new CommandException(aPlayer, "����̋�𑀍삵�悤�Ƃ��܂����B");
		}

		// TODO history
	}

	/**
	 * �v���C�����_�̏����Տ��𐶐����܂��B
	 * 
	 * @param player �v���C��
	 * @return �����Տ��
	 */
	public ChessBoardEntity generate(final int aPlayer) {
		List<ChessmenEntity> lsComa = new ArrayList<ChessmenEntity>();
		for (Integer id : chessmens.keySet()) {
			ChessmenData chessmen = chessmens.get(id);
			lsComa.add(createChessmen(aPlayer, chessmen));
		}
		ChessBoardEntity board = new ChessBoardEntity(lsComa);
		return board;
	}

	private Map<Integer, ChessmenData> create() {
		Map<Integer, ChessmenData> chessmens = new HashMap<Integer, JchessData.ChessmenData>();
		// Player1
		chessmens.put(100, new ChessmenData(100, 1, Type.King, 4, 8));
		chessmens.put(101, new ChessmenData(101, 1, Type.Gold, 3, 8));
		chessmens.put(102, new ChessmenData(102, 1, Type.Gold, 5, 8));
		chessmens.put(103, new ChessmenData(103, 1, Type.Silver, 2, 8));
		chessmens.put(104, new ChessmenData(104, 1, Type.Silver, 6, 8));
		chessmens.put(105, new ChessmenData(105, 1, Type.Knight, 1, 8));
		chessmens.put(106, new ChessmenData(106, 1, Type.Knight, 7, 8));
		chessmens.put(107, new ChessmenData(107, 1, Type.Lance, 0, 8));
		chessmens.put(108, new ChessmenData(108, 1, Type.Lance, 8, 8));
		chessmens.put(109, new ChessmenData(109, 1, Type.Bishop, 1, 7));
		chessmens.put(110, new ChessmenData(110, 1, Type.Rook, 7, 7));
		for (int x = 0; x < MAX_X; x++) {
			chessmens.put(111 + x, new ChessmenData(111 + x, 1, Type.Pawn, x, 6));
		}
		// Player2
		chessmens.put(200, new ChessmenData(200, 2, Type.King, 4, 0));
		chessmens.put(201, new ChessmenData(201, 2, Type.Gold, 3, 0));
		chessmens.put(202, new ChessmenData(202, 2, Type.Gold, 5, 0));
		chessmens.put(203, new ChessmenData(203, 2, Type.Silver, 2, 0));
		chessmens.put(204, new ChessmenData(204, 2, Type.Silver, 6, 0));
		chessmens.put(205, new ChessmenData(205, 2, Type.Knight, 1, 0));
		chessmens.put(206, new ChessmenData(206, 2, Type.Knight, 7, 0));
		chessmens.put(207, new ChessmenData(207, 2, Type.Lance, 0, 0));
		chessmens.put(208, new ChessmenData(208, 2, Type.Lance, 8, 0));
		chessmens.put(209, new ChessmenData(209, 2, Type.Bishop, 7, 1));
		chessmens.put(210, new ChessmenData(210, 2, Type.Rook, 1, 1));
		for (int x = 0; x < MAX_X; x++) {
			chessmens.put(211 + x, new ChessmenData(211 + x, 2, Type.Pawn, x, 2));
		}
		return chessmens;
	}

	/**
	 * �w����W�ɋ���݂��邩���f����B
	 * 
	 * @param fixX ��΍��WX
	 * @param fixY ��΍��WY
	 * @return ���݂���ꍇ�A<code>true</code>��Ԃ��B
	 */
	private boolean isChessmen(final int fixX, final int fixY) {
		for (Integer id : chessmens.keySet()) {
			ChessmenData chessmen = chessmens.get(id);
			if (chessmen.getFixX() == fixX && chessmen.getFixY() == fixY) {
				return true;
			}
		}
		return false;
	}

	/**
	 * �w����W�ɋ���݂��邩���f����B
	 * 
	 * @param x ���΍��WX
	 * @param y ���΍��WY
	 * @return ���݂���ꍇ�A<code>true</code>��Ԃ��B
	 */
	private boolean isChessmen(final int player, final int x, final int y) {
		int fixX = convertX(player, x);
		int fixY = convertY(player, y);
		for (Integer id : chessmens.keySet()) {
			ChessmenData chessmen = chessmens.get(id);
			if (chessmen.getFixX() == fixX && chessmen.getFixY() == fixY) {
				return true;
			}
		}
		return false;
	}

	/**
	 * �w����W�̋���擾����B
	 * 
	 * @param fixX ��΍��WX
	 * @param fixY ��΍��WY
	 * @return ��B���݂��Ȃ��ꍇ�A<code>null</code>��Ԃ��B
	 */
	private ChessmenData getChessmen(final int fixX, final int fixY) {
		for (Integer id : chessmens.keySet()) {
			ChessmenData chessmen = chessmens.get(id);
			if (chessmen.getFixX() == fixX && chessmen.getFixY() == fixY) {
				return chessmen;
			}
		}
		return null;
	}

	private ChessmenEntity createChessmen(final int aPlayer, final ChessmenData aChessmen) {
		boolean player = true;
		if (aPlayer != aChessmen.getPlayer()) {
			player = false;
		}
		int x = convertX(aPlayer, aChessmen.getFixX());
		int y = convertY(aPlayer, aChessmen.getFixY());
		PositionEntity position = new PositionEntity(x, y);
		return new ChessmenEntity(aChessmen.getId(), aChessmen.getType(), position, player, aChessmen.isBoard(), aChessmen.isPromote());
	}

	/**
	 * ���΍��W���΍��W��ϊ�����B
	 * 
	 * @param aPlayer �v���C���[
	 * @param aX ���WX
	 * @return �ϊ����WX
	 */
	private int convertX(final int aPlayer, final int aX) {
		if (2 == aPlayer) {
			return 8 - aX;
		} else {
			return aX;
		}
	}

	/**
	 * ���΍��W���΍��W��ϊ�����B
	 * 
	 * @param aPlayer �v���C���[
	 * @param aY ���WY
	 * @return �ϊ����WY
	 */
	private int convertY(final int aPlayer, final int aY) {
		if (2 == aPlayer) {
			return 8 - aY;
		} else {
			return aY;
		}
	}

	private static final class ChessmenData {
		private int id;
		private int player;
		private Type type;
		private boolean promote;
		private int fixX;
		private int fixY;
		private boolean board;

		public ChessmenData(final int aId, final int aPlayer, final Type aType, final int aFixX, final int aFixY) {
			id = aId;
			player = aPlayer;
			type = aType;
			promote = false;
			fixX = aFixX;
			fixY = aFixY;
			board = true;
		}

		public int getId() {
			return id;
		}

		public void setPlayer(final int aPlayer) {
			player = aPlayer;
		}

		public int getPlayer() {
			return player;
		}

		public Type getType() {
			return type;
		}

		public void setPromote(final boolean aPromote) {
			promote = aPromote;
		}

		public boolean isPromote() {
			return promote;
		}

		public void setFixX(final int aFixX) {
			fixX = aFixX;
		}

		public int getFixX() {
			return fixX;
		}

		public void setFixY(final int aFixY) {
			fixY = aFixY;
		}

		public int getFixY() {
			return fixY;
		}

		public void setBoard(final boolean aBoard) {
			board = aBoard;
		}

		public boolean isBoard() {
			return board;
		}
	}

}
