/**
  *    ����ǩ��break,continue
 * 
 * @author china
 *
 */
public class TestLabelContinue {
	public static void main(String[] args) {
		outer: for(int i=101; i<150;i++) {
			for(int j=2;j<i/2;j++) {
				if(i%j==0) {
					continue outer; // ʹ�����ѭ�� �� continue
				}
			}
			System.out.println(i + " "); // ������ continueʱ���Ŵ�ӡ
		}
	}
}
