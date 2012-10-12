package jp.addmee.jchess.player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import jp.addmee.jchess.command.Command;
import jp.addmee.jchess.command.GiveUpCommand;
import jp.addmee.jchess.command.MoveCommand;
import jp.addmee.jchess.command.PutCommand;
import jp.addmee.jchess.entity.ChessmenEntity;
import jp.addmee.jchess.entity.PositionEntity;

public final class CUIPlayer extends AbstractPlayer {

	private String name;

	BufferedReader reader = null;

	public CUIPlayer(final String aName) {
		name = aName;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	protected void doInitialize() {
		reader = new BufferedReader(new InputStreamReader(System.in));
	}

	@Override
	protected void doDestroy() {
		try {
			reader.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	protected Command doPlay() {
		Command cmd = null;
		try {
			print();

			String line;
			ChessmenEntity target = null;
			PositionEntity position = null;
			while (true) {
				System.out.print("ãÓÇëIëÇµÇƒÇ≠ÇæÇ≥Ç¢ÅÀ");
				line = reader.readLine();
				if ("end".equals(line.toLowerCase())) {
					cmd = new GiveUpCommand();
					break;
				}
				int no = getNumber(line);
				if (0 == no) {
					PositionEntity p = new PositionEntity(line);
					target = getMyChessmen(p);
					if (null == target) {
						continue;
					} else {
						break;
					}
				} else {
					List<ChessmenEntity> chessmens = getMyStockChessmens();
					if (chessmens.size() <= no) {
						continue;
					} else {
						target = chessmens.get(no - 1);
						break;
					}
				}
			}

			if (null == cmd) {
				while (true) {
					System.out.print("à íuÇëIëÇµÇƒÇ≠ÇæÇ≥Ç¢ÅÀ");
					line = reader.readLine();

					PositionEntity p = new PositionEntity(line);
					if (target.isBoard()) {
						if (isMoveChessmen(target, p)) {
							position = p;
							boolean promote = false;
							if (!target.isPromote()) {
								if (3 > p.getY()) {
									System.out.print("Ç»ÇËÇ‹Ç∑Ç©(Y)ÅÀ");
									line = reader.readLine();
									if ("y".equals(line.toLowerCase())) {
										promote = true;
									}
								}
							}
							cmd = new MoveCommand(target, position, promote);
							break;
						} else {
							continue;
						}
					} else {
						if (isPutChessmen(target, p)) {
							position = p;
							cmd = new PutCommand(target, position);
							break;
						} else {
							continue;
						}
					}
				}
			}

		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return cmd;
	}

	private int getNumber(final String value) {
		int no = 0;
		try {
			no = Integer.parseInt(value);
		} catch (NumberFormatException ex) {

		}
		return no;
	}
}
