package jp.addmee.jchess.command;

/**
 * このクラスは、投了を行うコマンドクラスです。
 * 
 * @since 1.0.0
 * @version 1.0.0 2012/10/04
 * @author Kawakicchi
 */
public final class GiveUpCommand extends AbstractCommand {

	/**
	 * コンストラクタ
	 */
	public GiveUpCommand() {
		super(null, null, false, true);
	}

}
