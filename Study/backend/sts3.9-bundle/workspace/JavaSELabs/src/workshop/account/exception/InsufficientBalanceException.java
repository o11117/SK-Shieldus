package workshop.account.exception;
//��������� Exception
public class InsufficientBalanceException extends Exception{
	public InsufficientBalanceException(String errMessage) {
		//�θ�Ŭ����(Exception)�� ������ ȣ���ϱ�
		super(errMessage);
	}
	
}