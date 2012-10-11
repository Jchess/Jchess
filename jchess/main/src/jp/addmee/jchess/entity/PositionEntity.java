package jp.addmee.jchess.entity;

/**
 * ���̃N���X�́A�ʒu����ێ�����N���X�ł��B
 * 
 * @since 1.0.0
 * @version 1.0.0 2012/09/30
 * @author Kawakicchi
 */
public final class PositionEntity {

	/**
	 * x���W
	 */
	private int x;

	/**
	 * y���W
	 */
	private int y;

	/**
	 * �R���X�g���N�^
	 * <p>
	 * <p>
	 * <table cellspacing="0">
	 * <tr>
	 * <td colspan="9" align="center" >X���W</td>
	 * <td></td>
	 * <td></td>
	 * </tr>
	 * <tr>
	 * <td>0</td>
	 * <td>1</td>
	 * <td>2</td>
	 * <td>3</td>
	 * <td>4</td>
	 * <td>5</td>
	 * <td>6</td>
	 * <td>7</td>
	 * <td>8</td>
	 * <td></td>
	 * <td></td>
	 * </tr>
	 * <tr>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td>0</td>
	 * <td rowspan="9">Y���W</td>
	 * </tr>
	 * <tr>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td>1</td>
	 * </tr>
	 * <tr>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td>2</td>
	 * </tr>
	 * <tr>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td>3</td>
	 * </tr>
	 * <tr>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td>4</td>
	 * </tr>
	 * <tr>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td>5</td>
	 * </tr>
	 * <tr>
	 * <td style="border: solid 1px;">��</td>
	 * <td style="border: solid 1px;">��</td>
	 * <td style="border: solid 1px;">��</td>
	 * <td style="border: solid 1px;">��</td>
	 * <td style="border: solid 1px;">��</td>
	 * <td style="border: solid 1px;">��</td>
	 * <td style="border: solid 1px;">��</td>
	 * <td style="border: solid 1px;">��</td>
	 * <td style="border: solid 1px;">��</td>
	 * <td>6</td>
	 * </tr>
	 * <tr>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;">�p</td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;">��</td>
	 * <td style="border: solid 1px;"></td>
	 * <td>7</td>
	 * </tr>
	 * <tr>
	 * <td style="border: solid 1px;">��</td>
	 * <td style="border: solid 1px;">�n</td>
	 * <td style="border: solid 1px;">��</td>
	 * <td style="border: solid 1px;">��</td>
	 * <td style="border: solid 1px;">��</td>
	 * <td style="border: solid 1px;">��</td>
	 * <td style="border: solid 1px;">��</td>
	 * <td style="border: solid 1px;">�n</td>
	 * <td style="border: solid 1px;">��</td>
	 * <td>8</td>
	 * </tr>
	 * </table>
	 * </p>
	 * </p>
	 * 
	 * @param aX X���W
	 * @param aY Y���W
	 */
	public PositionEntity(final int aX, final int aY) {
		x = aX;
		y = aY;
	}

	/**
	 * �R���X�g���N�^
	 * <p>
	 * �ʒu��'1A'�`'9I'�Ŏw�肵�܂��B
	 * <p>
	 * <table cellspacing="0">
	 * <tr>
	 * <td>1</td>
	 * <td>2</td>
	 * <td>3</td>
	 * <td>4</td>
	 * <td>5</td>
	 * <td>6</td>
	 * <td>7</td>
	 * <td>8</td>
	 * <td>9</td>
	 * <td></td>
	 * </tr>
	 * <tr>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td>A</td>
	 * </tr>
	 * <tr>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td>B</td>
	 * </tr>
	 * <tr>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td>C</td>
	 * </tr>
	 * <tr>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td>D</td>
	 * </tr>
	 * <tr>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td>E</td>
	 * </tr>
	 * <tr>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td>F</td>
	 * </tr>
	 * <tr>
	 * <td style="border: solid 1px;">��</td>
	 * <td style="border: solid 1px;">��</td>
	 * <td style="border: solid 1px;">��</td>
	 * <td style="border: solid 1px;">��</td>
	 * <td style="border: solid 1px;">��</td>
	 * <td style="border: solid 1px;">��</td>
	 * <td style="border: solid 1px;">��</td>
	 * <td style="border: solid 1px;">��</td>
	 * <td style="border: solid 1px;">��</td>
	 * <td>G</td>
	 * </tr>
	 * <tr>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;">�p</td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;">��</td>
	 * <td style="border: solid 1px;"></td>
	 * <td>H</td>
	 * </tr>
	 * <tr>
	 * <td style="border: solid 1px;">��</td>
	 * <td style="border: solid 1px;">�n</td>
	 * <td style="border: solid 1px;">��</td>
	 * <td style="border: solid 1px;">��</td>
	 * <td style="border: solid 1px;">��</td>
	 * <td style="border: solid 1px;">��</td>
	 * <td style="border: solid 1px;">��</td>
	 * <td style="border: solid 1px;">�n</td>
	 * <td style="border: solid 1px;">��</td>
	 * <td>I</td>
	 * </tr>
	 * </table>
	 * </p>
	 * </p>
	 * 
	 * @param p �ʒu
	 */
	public PositionEntity(final String p) {
		char c1 = p.charAt(0);
		char c2 = p.charAt(1);
		if ('1' == c1)
			x = 8;
		else if ('2' == c1)
			x = 7;
		else if ('3' == c1)
			x = 6;
		else if ('4' == c1)
			x = 5;
		else if ('5' == c1)
			x = 4;
		else if ('6' == c1)
			x = 3;
		else if ('7' == c1)
			x = 2;
		else if ('8' == c1)
			x = 1;
		else if ('9' == c1)
			x = 0;
		if ('A' == c2)
			y = 0;
		else if ('B' == c2)
			y = 1;
		else if ('C' == c2)
			y = 2;
		else if ('D' == c2)
			y = 3;
		else if ('E' == c2)
			y = 4;
		else if ('F' == c2)
			y = 5;
		else if ('G' == c2)
			y = 6;
		else if ('H' == c2)
			y = 7;
		else if ('I' == c2)
			y = 8;
	}

	/**
	 * �R���X�g���N�^
	 * <p>
	 * <p>
	 * <table cellspacing="0">
	 * <tr>
	 * <td colspan="9" align="center" >���ʒu</td>
	 * <td></td>
	 * <td></td>
	 * </tr>
	 * <tr>
	 * <td>9</td>
	 * <td>8</td>
	 * <td>7</td>
	 * <td>6</td>
	 * <td>5</td>
	 * <td>4</td>
	 * <td>3</td>
	 * <td>2</td>
	 * <td>1</td>
	 * <td></td>
	 * <td></td>
	 * </tr>
	 * <tr>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td>A</td>
	 * <td rowspan="9">�c�ʒu</td>
	 * </tr>
	 * <tr>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td>B</td>
	 * </tr>
	 * <tr>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td>C</td>
	 * </tr>
	 * <tr>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td>D</td>
	 * </tr>
	 * <tr>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td>E</td>
	 * </tr>
	 * <tr>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td>F</td>
	 * </tr>
	 * <tr>
	 * <td style="border: solid 1px;">��</td>
	 * <td style="border: solid 1px;">��</td>
	 * <td style="border: solid 1px;">��</td>
	 * <td style="border: solid 1px;">��</td>
	 * <td style="border: solid 1px;">��</td>
	 * <td style="border: solid 1px;">��</td>
	 * <td style="border: solid 1px;">��</td>
	 * <td style="border: solid 1px;">��</td>
	 * <td style="border: solid 1px;">��</td>
	 * <td>G</td>
	 * </tr>
	 * <tr>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;">�p</td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;"></td>
	 * <td style="border: solid 1px;">��</td>
	 * <td style="border: solid 1px;"></td>
	 * <td>H</td>
	 * </tr>
	 * <tr>
	 * <td style="border: solid 1px;">��</td>
	 * <td style="border: solid 1px;">�n</td>
	 * <td style="border: solid 1px;">��</td>
	 * <td style="border: solid 1px;">��</td>
	 * <td style="border: solid 1px;">��</td>
	 * <td style="border: solid 1px;">��</td>
	 * <td style="border: solid 1px;">��</td>
	 * <td style="border: solid 1px;">�n</td>
	 * <td style="border: solid 1px;">��</td>
	 * <td>I</td>
	 * </tr>
	 * </table>
	 * </p>
	 * </p>
	 * 
	 * @param aCol ���ʒu
	 * @param aRow �c�ʒu
	 */
	public PositionEntity(final char aCol, final char aRow) {
		char c1 = aCol;
		char c2 = aRow;
		if ('1' == c1)
			x = 8;
		else if ('2' == c1)
			x = 7;
		else if ('3' == c1)
			x = 6;
		else if ('4' == c1)
			x = 5;
		else if ('5' == c1)
			x = 4;
		else if ('6' == c1)
			x = 3;
		else if ('7' == c1)
			x = 2;
		else if ('8' == c1)
			x = 1;
		else if ('9' == c1)
			x = 0;
		if ('A' == c2)
			y = 0;
		else if ('B' == c2)
			y = 1;
		else if ('C' == c2)
			y = 2;
		else if ('D' == c2)
			y = 3;
		else if ('E' == c2)
			y = 4;
		else if ('F' == c2)
			y = 5;
		else if ('G' == c2)
			y = 6;
		else if ('H' == c2)
			y = 7;
		else if ('I' == c2)
			y = 8;
	}

	public PositionEntity(final PositionEntity position) {
		x = position.getX();
		y = position.getY();
	}

	/**
	 * X�ʒu���擾����B
	 * 
	 * @return�@X�ʒu
	 */
	public int getX() {
		return x;
	}

	/**
	 * Y�ʒu���擾����B
	 * 
	 * @return Y�ʒu
	 */
	public int getY() {
		return y;
	}

	public String toString() {
		StringBuffer s = new StringBuffer();
		s.append(9 - x);
		s.append(Character.valueOf((char) ('A' + y)));
		return s.toString();
	}
}
