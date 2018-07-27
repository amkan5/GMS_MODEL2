package domain;

import lombok.Data;

@Data 
public class ExamBean {
	protected String memId,examSeq, subSeq,score,month,recordSeq;


	@Override
	public String toString() {
		return "시험정보 [멤버id=" + memId + ", 시험번호=" + examSeq + ", 과목번호=" + subSeq + ", 점수=" + score
				+ ", 월=" + month + ", 성적표번호=" + recordSeq + "]";
	} 
	
	
}
